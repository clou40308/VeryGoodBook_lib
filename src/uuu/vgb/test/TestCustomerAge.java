package uuu.vgb.test;

import java.time.LocalDate;
import java.util.Date;

import uuu.vgb.entity.Customer;

public class TestCustomerAge {
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();//測試用
		int i;//i is a local variable
		i = 1;
		System.out.printf("%s\n",i);
		Customer c = new Customer();// c is a local variable
		c.id="A123456789";
		c.email="123@gmail.com";
		c.phone="09222222";
		c.setPassword("123");
		c.name="Jeff";
		
		//c.birthday=LocalDate.of(1994, 03, 30);
		c.setBirthday(2000,12,4); // 呼叫setBirthday(year, month, day) 來設定生日
		//c.birthday=LocalDate.parse("1994-03-30");//將符合iso-8601的日期字串轉換成
		c.setBirthday("2000-12-04"); //TODO:
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
		
		System.out.printf("從%s開始共花了%s ms\n",new Date(begin),System.currentTimeMillis());
		
		//計算年齡
//		int thisYear = LocalDate.now().getYear();
//		int birthYear = c.birthday.getYear();
//		int age = thisYear-birthYear;
		
		int age = c.getAge();
		System.out.printf("%s歲\n",age);
	}
}