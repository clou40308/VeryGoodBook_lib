package uuu.vgb.service;

import java.sql.*;

import uuu.vgb.entity.Order;
import uuu.vgb.entity.OrderItem;
import uuu.vgb.exception.VGBException;

class OrderDAO {

	private static final String INSERT_ORDERS = 
			"INSERT INTO orders "
			+ "	(id, customer_id, created_date, created_time,  "
			+ " shipping_type, shipping_fee, payment_type, payment_fee, "
			+ " recipient_name, recipient_email, recipient_phone, shipping_address) "
			+ " VALUES(?,?,?,?, ?,?,?,?, ?,?,?,?) ";

	private static final String INSERT_ORDER_ITEMS = 
			"INSERT INTO order_items "
			+ "	(order_id, product_id, cpu_name, size_name, price, quantity) " 
			+ " VALUES(?,?,?,?, ?,?) ";

	void insert(Order order) throws VGBException {

		try (
				Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt1 = connection.prepareStatement(INSERT_ORDERS, Statement.RETURN_GENERATED_KEYS); // 3.準備指令pstmt1
				PreparedStatement pstmt2 = connection.prepareStatement(INSERT_ORDER_ITEMS);	// 3.準備指令pstmt2
			) {
			connection.setAutoCommit(false);  //關閉[交易自動確認]，類似connection.beginTransaction()
			
			try {
			//新增訂單
				//3.1 傳入pstmt1的?的值
				pstmt1.setInt(1, order.getId());
				pstmt1.setString(2,order.getMember().getId());
				pstmt1.setString(3, order.getCreatedDate().toString());
				pstmt1.setString(4, order.getCreatedTime().toString());
				
				pstmt1.setString(5, order.getShippingType().name());
				pstmt1.setDouble(6, order.getShippingFee());
				
				pstmt1.setString(7, order.getPaymentType().name());
				pstmt1.setDouble(8, order.getPaymentFee());
				
				pstmt1.setString(9, order.getRecipientName());
				pstmt1.setString(10, order.getRecipientEmail());
				pstmt1.setString(11, order.getRecipientPhone());
				pstmt1.setString(12, order.getShippingAddress());
				
				// 4.執行指令pstmt1
				pstmt1.executeUpdate();
				
				//5.處理rs(取得AI的key)
				try(
					ResultSet rs = pstmt1.getGeneratedKeys();
				){
					while(rs.next()) {
						order.setId(rs.getInt(1));
					}
				}
				
				//新增訂單明細
				for(OrderItem item: order.getOrderItemSet()) {
					//3.1 傳入pstmt2的?的值
					item.setOrderId(order.getId());
					
					pstmt2.setInt(1, order.getId());
					pstmt2.setInt(2, item.getProductId());
					pstmt2.setString(3, item.getCpuName());
					pstmt2.setString(4, item.getSizeName());
					
					pstmt2.setDouble(5, item.getPrice());
					pstmt2.setInt(6, item.getQuantity());
					// 4.執行指令pstmt2
					pstmt2.executeUpdate();
				}
				
				connection.commit();
			}catch (Exception e) {
				connection.rollback();
				throw e; //將e拋回原來的錯誤處理機制
			}finally {
				connection.setAutoCommit(true); //若有connection pool機制，還原為預設值 
			}
				
		} catch (SQLException e) {
			throw new VGBException("建立訂單失敗!",e);
		}
	}
}
