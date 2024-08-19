package uuu.vgb.test;

import uuu.vgb.exception.VGBException;
import uuu.vgb.service.MySQLConnection;

public class TestMySQLConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MySQLConnection.getConnection();
		} catch (VGBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final int i ;
	}

}
