package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class Test_instanceof {
	public static void main(String[] args) {
		Object o = new Object();
		Customer c = new Customer();
		VIP v = new VIP();
		String s = "";
	
		System.out.println(o instanceof Object);
		System.out.println(o instanceof Customer);
		System.out.println(o instanceof VIP);
		System.out.println(o instanceof String);

		System.out.println(c instanceof Object);
		System.out.println(c instanceof Customer);
		System.out.println(c instanceof VIP);
//		System.out.println(c instanceof String);//無法編譯

		System.out.println(v instanceof Object);
		System.out.println(v instanceof Customer);
		System.out.println(v instanceof VIP);
//		System.out.println(v instanceof String);//無法編譯

		System.out.println(s instanceof Object);
//		System.out.println(s instanceof Customer);//無法編譯
//		System.out.println(s instanceof VIP);//無法編譯
		System.out.println(s instanceof String);
	}
}
