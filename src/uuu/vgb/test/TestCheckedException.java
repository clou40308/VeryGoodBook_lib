package uuu.vgb.test;

import java.sql.*;

import uuu.vgb.entity.Customer;

public class TestCheckedException {
	private static final String sql = "SELECT id,name ,email FROM customers";

	public static void main(String[] args) throws Exception{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vgb", "root", "1234");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setName(rs.getString("name"));
				c.setBirthday(rs.getString("birthday"));
				c.setGender(rs.getString("gender").charAt(0));
				c.setAddress(rs.getString("address"));
				c.setSubscribed(rs.getBoolean("subscribed"));
			}
			rs.close();
			stmt.close();
			connection.close();
	}
}
