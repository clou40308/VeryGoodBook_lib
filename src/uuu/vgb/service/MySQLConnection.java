package uuu.vgb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

import uuu.vgb.exception.VGBException;

public class MySQLConnection {
	private static final String Driver;// = "com.mysql.cj.jdbc.Driver";
	private static final String URL;// ="jdbc:mysql://localhost:3306/mydb";
	private static final String USER_ID;// ="root";
	private static final String DB_PWD;// ="1234";

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("uuu.vgb.service.mysql");
		Driver = bundle.getString("jdbc.driver");
		URL = bundle.getString("jdbc.url");
		USER_ID = bundle.getString("jdbc.userid");
		DB_PWD = bundle.getString("jdbc.pwd");
//		System.out.printf("%s\n, %s\n, %s\n, %s\n", JDBC, URL, USER_ID, DB_PWD);
	}

//	public MySQLConnection() {
//		JDBC="com.mysql.cj.jdbc.Driver";
//	}
	public static Connection getConnection() throws VGBException {
		try {
			Class.forName(Driver);// 1. 載入Driver類別
			try {
				Connection connection = DriverManager.getConnection(URL, USER_ID, DB_PWD);// 2.建立連線
				return connection;
			} catch (SQLException e) {
				// Logger.getLogger("XxxxxXxxxx").log(Level.SEVERE, "建立連線失敗", e);// for
				// developer, tester ,a dmin
				throw new VGBException("建立連線失敗", e);
			}
		} catch (ClassNotFoundException e) {
			// Logger.getLogger("XxxxxXxxxx").log(Level.SEVERE, "載入Driver失敗", e);// for
			// developer, tester ,a dmin
			throw new VGBException("載入Driver失敗", e);
		}
	}
}
