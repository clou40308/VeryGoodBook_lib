package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor.STRING;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;
import uuu.vgb.exception.LoginFailedException;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;

class CustomersDAO {
	private static final String SELECT_CUSTOMER = "SELECT id, email, phone, password, name, birthday, gender,"
			+ "  address, subscribed, discount from customers " + " WHERE id=? OR email=? OR phone=?  ";// AND BINARY
																										// password=? ";

	Customer selectById(String id) throws VGBException {
		Customer c = null;
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER); // 3.建立指令，會發生SQL Injection
		) {
			pstmt.setString(1, id); // 3.1傳入?的值
			pstmt.setString(2, id);// 3.1傳入?的值
			pstmt.setString(3, id);// 3.1傳入?的值
			try (ResultSet rs = pstmt.executeQuery();// 4.執行指令
			) {
				while (rs.next()) { // 5.讀取rs
					String theId = rs.getString("id");
					if(!theId.equals(id)) {
						throw new LoginFailedException("登入失敗，帳號不正確");
					}
					int discount = rs.getInt("discount");
					if (discount > 0) { // 折扣>0
//						VIP vip =new VIP();
//						vip.setDiscount(discount);
//						c=vip;
						c = new VIP();// 建立VIP物件
						((VIP) c).setDiscount(discount);
					} else {// 否則
						c = new Customer();// 建立一般Customer物件
					}
					c.setId(theId);
					c.setEmail(rs.getString("email"));
					c.setPhone(rs.getString("phone"));
					c.setPassword(rs.getString("password"));
					c.setName(rs.getString("name"));
					c.setBirthday(rs.getString("birthday"));
					c.setGender(rs.getString("gender").charAt(0));
					c.setAddress(rs.getString("address"));
					c.setSubscribed(rs.getBoolean("subscribed"));

					// System.out.println(c);
				}
			}

		} catch (SQLException e) {
			// Logger.getLogger("CustomersDAO").log(Level.SEVERE, "用id查詢客戶失敗", e);
			throw new VGBException("用id查詢客戶失敗", e);
		}
		return c;
	}

	private static final String INSERT_CUSTOMER = "INSERT INTO `customers` "
			+ " (id, email, phone, password, name, birthday, gender, address, subscribed) "
			+ "	VALUES (?,?,?,?,?,?,?  ,?,?)";

	public void insert(Customer c) throws VGBException {

		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(INSERT_CUSTOMER);// 3.建立指令，會發生SQL Injection
		) {
			// 3.1 傳入?的值
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getPhone());
			pstmt.setString(4, c.getPassword());
			pstmt.setString(5, c.getName());
			pstmt.setString(6, String.valueOf(c.getBirthday()));
			pstmt.setString(7, String.valueOf(c.getGender()));
			pstmt.setString(8, c.getAddress());
			pstmt.setBoolean(9, c.isSubscribed());
			pstmt.executeUpdate();// 4.執行指令
		} catch (SQLIntegrityConstraintViolationException e) {
			String column = "";
			if (e.getMessage().indexOf("email_UNIQUE") >= 0) {
				column = "email";
			} else if (e.getMessage().indexOf("phone_UNIQUE") >= 0) {
				column = "手機";
			} else if (e.getMessage().indexOf("PRIMARY") >= 0) {
				column = "身分證";
			} else {
				throw new VGBException("註冊會員失敗" + e.getErrorCode(), e);
			}
			String msg = String.format("註冊會員失敗,%s已經重複註冊", column);
			throw new VGBDataInvalidException(msg, e);
		} catch (SQLException e) {
			throw new VGBException("註冊會員失敗" + e.getErrorCode(), e);
		}
	}

	private static final String UPDATE_CUSTOMER = 
			" UPDATE customers "
			+ " SET email=?, phone=?, password=?, name=?, birthday=?, gender=?, address=?, subscribed=? "
			+ "	WHERE id=? ";
	public void update(Customer c)  throws VGBException{
		try (Connection connection = MySQLConnection.getConnection(); // 1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_CUSTOMER);// 3.建立指令，會發生SQL Injection
		) {
			// 3.1 傳入?的值
			pstmt.setString(9, c.getId());
			pstmt.setString(1, c.getEmail());
			pstmt.setString(2, c.getPhone());
			pstmt.setString(3, c.getPassword());
			pstmt.setString(4, c.getName());
			pstmt.setString(5, String.valueOf(c.getBirthday()));
			pstmt.setString(6, String.valueOf(c.getGender()));
			pstmt.setString(7, c.getAddress());
			pstmt.setBoolean(8, c.isSubscribed());
			pstmt.executeUpdate();// 4.執行指令
		} catch (SQLIntegrityConstraintViolationException e) {
			String column = "";
			if (e.getMessage().indexOf("email_UNIQUE") >= 0) {
				column = "email";
			} else if (e.getMessage().indexOf("phone_UNIQUE") >= 0) {
				column = "手機";
			} else if (e.getMessage().indexOf("PRIMARY") >= 0) {
				column = "身分證";
			} else {
				throw new VGBException("修改會員失敗" + e.getErrorCode(), e);
			}
			String msg = String.format("修改會員失敗,%s已經重複註冊", column);
			throw new VGBDataInvalidException(msg, e);
		} catch (SQLException e) {
			throw new VGBException("修改會員失敗" + e.getErrorCode(), e);
		}
		
	}
}
