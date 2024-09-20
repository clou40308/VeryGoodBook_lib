package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Cpu;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.SpecialOffer;
import uuu.vgb.exception.VGBException;

class ProductsDAO {
	private static final String SELECT_ALL_PRODUCTS = "SELECT id, name, unit_price, stock, photo_url, "
			+ " category, release_date, description, discount FROM products ";

	List<Product> selectAllProducts() throws VGBException {
		List<Product> list = new ArrayList<>();
		// TODO: JDBC 1~5

		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PRODUCTS); // 3.準備指令
				ResultSet rs = pstmt.executeQuery();// 4.執行指令
		) {
			while (rs.next()) { // 5.處理rs
				Product p;// 可能是Product物件或SpecialOffer物件

				int discount = rs.getInt("discount");
				if (discount > 0) {
					p = new SpecialOffer();
					((SpecialOffer) p).setDiscount(discount);
				} else {// 否則
					p = new Product();
				}
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setStock(rs.getInt("stock"));
				p.setPhotoUrl(rs.getString("photo_url"));
				p.setCategory(rs.getString("category"));
				p.setReleaseDate(rs.getString("release_date"));
				p.setDescription(rs.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new VGBException("查詢全部產品失敗", e);
		}
		return list;
	}

	private static final String SELECT_PRODUCTS_BY_KEYWORD = SELECT_ALL_PRODUCTS + " WHERE name LIKE ? ";

	List<Product> selectProductsByKeyword(String keyword) throws VGBException {
		List<Product> list = new ArrayList<>();
		// TODO: JDBC 1~5
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_KEYWORD);// 3.準備指令
		) {
			// 3.1 傳入?的值
			pstmt.setString(1, '%' + keyword + '%');
			try (ResultSet rs = pstmt.executeQuery();// 4.執行指令
			) {
				while (rs.next()) {
					Product p;// 可能是Product物件或SpecialOffer物件
					int discount = rs.getInt("discount");
					if (discount > 0) {
						p = new SpecialOffer();
						((SpecialOffer) p).setDiscount(discount);
					} else {// 否則
						p = new Product();
					}
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));
					p.setReleaseDate(rs.getString("release_date"));
					p.setDescription(rs.getString("description"));
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("用[關鍵字查詢產品]失敗", e);
		}
		return list;
	}
	
	 private static final String SELECT_PRODUCTS_BY_CATEGORY =SELECT_ALL_PRODUCTS
			 + " WHERE category=? ";
	 List<Product> selectProductsByCategory(String category) throws VGBException {
			List<Product> list = new ArrayList<>();
			// TODO: JDBC 1~5
			try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
					PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);// 3.準備指令
			) {
				// 3.1 傳入?的值
				pstmt.setString(1, category);
				try (ResultSet rs = pstmt.executeQuery();// 4.執行指令
				) {
					while (rs.next()) {
						Product p;// 可能是Product物件或SpecialOffer物件
						int discount = rs.getInt("discount");
						if (discount > 0) {
							p = new SpecialOffer();
							((SpecialOffer) p).setDiscount(discount);
						} else {// 否則
							p = new Product();
						}
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("name"));
						p.setUnitPrice(rs.getDouble("unit_price"));
						p.setStock(rs.getInt("stock"));
						p.setPhotoUrl(rs.getString("photo_url"));
						p.setCategory(rs.getString("category"));
						p.setReleaseDate(rs.getString("release_date"));
						p.setDescription(rs.getString("description"));
						list.add(p);
					}
				}
			} catch (SQLException e) {
				throw new VGBException("用[分類查詢產品]失敗", e);
			}
			return list;
	}
	 
	private static final int LIMIT_NUM = 3 ;
	private static final String SELECT_LATEST_PRODUCTS = 
			SELECT_ALL_PRODUCTS
			+ " ORDER BY release_date DESC "
			+ " LIMIT " + LIMIT_NUM;
	List<Product> selectLatestProducts() throws VGBException{
		List<Product> list = new ArrayList<>();
		// TODO: JDBC 1~5
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_LATEST_PRODUCTS);// 3.準備指令
		) {
			try (ResultSet rs = pstmt.executeQuery();// 4.執行指令
			) {
				while (rs.next()) {
					Product p;// 可能是Product物件或SpecialOffer物件
					int discount = rs.getInt("discount");
					if (discount > 0) {
						p = new SpecialOffer();
						((SpecialOffer) p).setDiscount(discount);
					} else {// 否則
						p = new Product();
					}
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));
					p.setReleaseDate(rs.getString("release_date"));
					p.setDescription(rs.getString("description"));
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new VGBException("[查詢最新上架產品]失敗", e);
		}
		return list;
	}
	private static final String SELECT_PRODUCT_BY_ID =
			"SELECT id, name, unit_price, products.stock, products.photo_url, category, "+ 
			" products.release_date, description, discount, "+
		    " product_id, cpu_name, product_cpu.release_date AS cpu_release_date, "+
		    " product_cpu.photo_url  AS cpu_photo, "+
		    " product_cpu.stock AS cpu_stock "+
			" FROM products "+ 
			" LEFT JOIN product_cpu ON products.id = product_cpu.product_id "+
		    " WHERE id=? "; 
			
//			"SELECT id, name, unit_price, stock, photo_url, category, release_date, description, discount "
//					+"  FROM products "
//					+ "  WHERE id = ?"; 
	Product selectProductById(String id) throws VGBException {
		Product p = null;
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCT_BY_ID);// 3.準備指令
		) {
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery();// 4.執行指令
			) {
				while (rs.next()) {
						if(p==null) {
								int discount = rs.getInt("discount");
						if (discount > 0) {
							p = new SpecialOffer();
							((SpecialOffer) p).setDiscount(discount);
						} else {// 否則
							p = new Product();
						}
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("name"));
						p.setUnitPrice(rs.getDouble("unit_price"));
						p.setStock(rs.getInt("stock"));
						p.setPhotoUrl(rs.getString("photo_url"));
						p.setCategory(rs.getString("category"));
						p.setReleaseDate(rs.getString("release_date"));
						p.setDescription(rs.getString("description"));
					}
				
					//讀取cpu資料
					String cpuName = rs.getString("cpu_name");
					if(cpuName!=null){
						Cpu cpu = new Cpu();
						cpu.setCpuName(cpuName);
						cpu.setReleaseDate(LocalDate.parse(rs.getString("cpu_release_date")));
						cpu.setPhotoUrl(rs.getString("cpu_photo"));
						cpu.setStock(rs.getInt("cpu_stock"));
						
						p.add(cpu);
					}
				}
			}
		} catch (SQLException e) {
			throw new VGBException("[用id查詢產品]失敗", e);
		}
		return p;
	}
}
