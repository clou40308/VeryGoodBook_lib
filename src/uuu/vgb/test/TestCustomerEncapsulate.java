package uuu.vgb.test;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import uuu.vgb.entity.Customer;

public class TestCustomerEncapsulate {
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();//測試用
		int i;//i is a local variable
		i = 1;
		System.out.printf("%s\n",i);
		Customer c = new Customer();// c is a local variable
		c.setId("Z123456789");
		c.setEmail("123@gmail.com");
		c.setPhone("0922656613");
		
		c.setPassword("123");
		c.setName("Jeff");
		
		//c.birthday=LocalDate.of(1994, 03, 30);
		c.setBirthday(LocalDate.of(1994, 03, 30)); // 呼叫setBirthday(year, month, day) 來設定生日
		//c.birthday=LocalDate.parse("1994-03-30");//將符合iso-8601的日期字串轉換成
		//c.setBirthday("2000-12-04"); //TODO:
		c.setGender('M');
		c.setAddress("台北市");
		c.setSubscribed(false);
		System.out.printf("c.id: %s\n",c.getId());
		System.out.printf("c.email: %s\n",c.getEmail());
		System.out.printf("c.phone: %s\n",c.getPhone());
		System.out.printf("c.password: %s\n",c.getPassword());
		System.out.printf("c.name: %s\n",c.getName());
		System.out.printf("c.birthday: %s\n",c.getBirthday());
		System.out.printf("c.gender: %s\n",c.getGender());
		System.out.printf("c.address: %s\n",c.getAddress());
		System.out.printf("c.subscribed: %s\n",c.isSubscribed());
		
		System.out.printf("從%s開始共花了%s ms\n",new Date(begin),System.currentTimeMillis());
		
		//計算年齡
//		int thisYear = LocalDate.now().getYear();
//		int birthYear = c.birthday.getYear();
//		int age = thisYear-birthYear;
		
		int age = c.getAge(LocalDate.of(1994, 03, 30));
		System.out.println(c.getAge());
	}
}