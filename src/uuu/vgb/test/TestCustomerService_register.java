package uuu.vgb.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerService_register {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入ROC ID:");
		String id = scanner.next();

		System.out.println("請輸入E-mail:");
		String email = scanner.next();

		System.out.println("請輸入手機號碼:");
		String phone = scanner.next();

		System.out.println("請輸入密碼:");
		String password = scanner.next();
		System.out.println("請輸入姓名:");
		String name = scanner.next();

		Customer c = new Customer();

		try {
			c.setId(id);
			c.setEmail(email);
			c.setPhone(phone);
			c.setPassword(password);
			c.setName(name);
			
			c.setBirthday("2000-08-08");
			c.setGender(Customer.OTHERS);
			System.out.println(c);
			CustomerService service = new CustomerService();
			service.register(c);

		} catch ( VGBDataInvalidException e) {
			System.err.println(e.getMessage());
		} catch (VGBException e) {
			System.err.println(e.getMessage());
			Logger.getLogger("").log(Level.SEVERE,e.getMessage(),e);
		}
		
	}
}
