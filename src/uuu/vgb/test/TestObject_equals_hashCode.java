package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class TestObject_equals_hashCode {
	public static void main(String[] args) {
		// 數字基本型別(byte,short,char,int,long,float,double)
		int i = 1;
		double j = 1.0;
		System.out.printf("%s == %s : %s\n", i, j, i == j);

		double x = 0.3;
		double y = 0.1 + 0.1 - 0.1 + x - 0.1;

		System.out.printf("%s != %s: %s\n", x, y, x == y);// IEEE 754

		// 參考型別 String
		String s1 = "Hello";
		String s2 = "Hello"; // String pool
		String s3 = new String("hello");
		System.out.printf("%s == %s: %s\n", s1, s2, s1 == s2);// true
		System.out.printf("%s == %s: %s\n", s1, s3, s1 == s3);// false
		System.out.printf("\"%s\".equals(\"%s\"): %s\n", s1, s3, s1.equals(s3));// 用equals來比較內容是否相同
		System.out.printf("\"%s\".equalsIgnoreCase(\"%s\"): %s\n", s1, s3, s1.equalsIgnoreCase(s3));// 用equalsIgnoreCase來比較(不分大小寫)內容是否相同

		// 參考型別 Customer
		Customer c1 = new Customer("A123456789", "123", "JEFF");
		Customer c2 = new Customer("A123456789", "123", "JOHN");
		VIP vip = new VIP("A123456789","56","JOHN");
		System.out.println(c1 == c2);  //false
		System.out.println(c1.equals(c2));  //true,必須在Customer類別override equals方法,並以id為主鍵才會為true
		System.out.println(c2.equals(vip));
		
		c2=c1;
		System.out.println(c1 == c2);  // true
		System.out.println(c1.equals(c2));  // true
		
		
	}
}
