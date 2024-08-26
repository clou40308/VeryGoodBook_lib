package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
