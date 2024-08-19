package uuu.vgb.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.LoginFailedException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerLogin_MODEL {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入帳號/email/手機號碼:");
		String id = scanner.next();

		System.out.println("請輸入密碼:");
		String password = scanner.next();

		System.out.printf("輸入了帳號/email/手機號碼: %s,密碼: %s\n", id, password);
		scanner.close();

		CustomerService service = new CustomerService();
		
		try {
			Customer c = service.login(id, password);
			System.out.println("登入成功, " + c+"你好");
		} catch (LoginFailedException e) {
			System.out.println(e.getMessage());
		} catch (VGBException e) {
			System.out.println("登入失敗" + e.getMessage() + ",請聯絡Admin");
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e); //for admin
		}

	}

}
