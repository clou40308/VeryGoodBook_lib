package uuu.vgb.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerService_update {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入ROC ID:");//F128546809
		String id = scanner.next();		
		
		System.out.println("請輸入密碼:");//a123456
		String password = scanner.next();		
		
		try {
			
			CustomerService service = new CustomerService();
			Customer c = service.login(id, password);
			System.out.println(c);
			
			c.setName("周軒");
			service.update(c);
			System.out.println("修改成功:");
			System.out.println(c);
		}catch(VGBDataInvalidException e) {
			System.err.println(e.getMessage()); //for user
		} catch (VGBException e) {
			System.err.println(e.getMessage()+", 請聯絡admin"); //for user
			Logger.getLogger("").log(Level.SEVERE,e.getMessage(),e);
		}
	}
}
