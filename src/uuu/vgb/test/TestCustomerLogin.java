package uuu.vgb.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;

import java.sql.*;

public class TestCustomerLogin {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/vgb";
	private static final String USER_ID = "root";
	private static final String DB_PWD = "1234";
	private static final String SELECT_CUSTOMER = "SELECT id, email, phone, password, name, birthday, gender,"
			+ "  address, subscribed, discount from customers " + "  where id='%s' and password ='%s';";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入帳號:");
		String id = scanner.next();

		System.out.println("請輸入密碼:");
		String password = scanner.next();

		System.out.printf("輸入了帳號: %s,密碼: %s\n", id, password);
		scanner.close();

		String sql = String.format(SELECT_CUSTOMER, id, password);
		System.out.printf("%s\n", sql);
		// JDBC

		try {
			Class.forName(Driver);// 1. 載入Driver
			try (Connection connection = DriverManager.getConnection(URL, USER_ID, DB_PWD); // 2.建立連線
					Statement stmt = connection.createStatement(); // 3.建立指令，會發生SQL Injection
					ResultSet rs = stmt.executeQuery(sql);// 4.執行指令
			) {
				Customer c = null;
				while (rs.next()) { // 5.讀取rs
					c = new Customer();
					String theId = rs.getString("id");
					c.setId(theId);
					c.setEmail(rs.getString("email"));
					c.setPhone(rs.getString("phone"));
					c.setName(rs.getString("name"));
					c.setBirthday(rs.getString("birthday"));
					c.setGender(rs.getString("gender").charAt(0));
					c.setAddress(rs.getString("address"));
					c.setSubscribed(rs.getBoolean("subscribed"));
					System.out.println(c);
				}
				if (c != null && password!=null && password.equals(c.getPassword())) {
					System.out.printf("登入成功，%s 您好\n",c.getName());
					return;
				} 
//				else if (c != null && password !=null && password.equals(c.getPassword())) {
//					
//				}
				
			} catch (SQLException e) {
				Logger.getLogger("XxxxxXxxxx").log(Level.SEVERE, "[建立連線|執行指令]失敗", e);// for developer, tester ,a dmin
			}
		} catch (ClassNotFoundException e) {
			Logger.getLogger("XxxxxXxxxx").log(Level.SEVERE, "載入Driver失敗", e);// for developer, tester ,a dmin
		}
		System.out.println("The End");
	}

}
