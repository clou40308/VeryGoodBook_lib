package uuu.vgb.test;

import java.time.LocalDate;
import java.util.Date;

import uuu.vgb.entity.Customer;

public class TestCustomer {
	private int k = 100;//non-static屬性，在main方法不能直接使用
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();//測試用
		int i;//i is a local variable
		i = 1;
		System.out.printf("%s\n",i);
		
//		System.out.printf("%s\n",k); 無法編譯，non-static屬性，在main方法不能直接使用
		System.out.printf("%s\n",new TestCustomer().k);
		Customer c = new Customer();// c is a local variable
		c.id="A123456789";
		c.email="123@gmail.com";
		c.phone="09222222";
		c.setPassword("123");
		c.name="Jeff";
		c.birthday=LocalDate.of(1994, 03, 30);
		c.gender='M';
		c.address="台北市";
		c.subscribed=false;
		System.out.printf("c.id: %s\n",c.id);
		System.out.printf("c.email: %s\n",c.email);
		System.out.printf("c.phone: %s\n",c.phone);
		System.out.printf("c.password: %s\n",c.getPassword());
		System.out.printf("c.name: %s\n",c.name);
		System.out.printf("c.birthday: %s\n",c.birthday);
		System.out.printf("c.gender: %s\n",c.gender);
		System.out.printf("c.address: %s\n",c.address);
		System.out.printf("c.subscribed: %s\n",c.subscribed);
		System.out.println(c.toString());
		System.out.printf("從%s開始共花了%s ms\n",new Date(begin),System.currentTimeMillis());
	}
}