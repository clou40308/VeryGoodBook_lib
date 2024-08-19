package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.SpecialOffer;
import uuu.vgb.entity.VIP;

public class TestPolymorphism {

	public static void main(String[] args) {
		Object o1 = new Object();// 一般的參考型別區域變數的宣告
		System.out.printf("o1: %s\n",o1);
		
		String s1 = "Hello";// 一般的參考型別區域變數的宣告
		System.out.printf("s1: %s,s1.length(): %s\n",s1,s1.length());
		
		Product p1 = new Product(1, "排球少年！！magazine 全 (首刷限定版)", 720);// 一般的參考型別區域變數的宣告
		System.out.printf("p1: %s,%s\n",p1,p1.getName());

		System.out.println((char)70);
		Object o2 = "Hello"; // 多型的參考型別區域變數的宣告
		System.out.printf("o2: %s\n",o2);//o2.toString()使用String的toString()
		System.out.printf("o2: %s,o2.length(): %s\n",o2,((String) o2).length());//o2.toString()使用String的toString(),o2.length()無法使用String的length()
		
		
		Object o3 = new Product(1, "排球少年！！magazine 全 (首刷限定版)", 720); // 多型的參考型別區域變數的宣告
//		o3 = new Object();
		if(o3 instanceof Product) {
			System.out.printf("價格:%s\n",((Product) o3).getUnitPrice());
		}else {
			System.out.println("o3不是Product或其SubClasses建立的物件");
		}
		
//		Product p2 = new SpecialOffer(2, "排球少年！！magazine 全 (首刷限定版)", 720, 21);
		Product p2;
		p2= new Product(1, "排球少年！！magazine 全 (首刷限定版)", 720);

		Customer c2 = new VIP("A123456789","123","jeff");

	}

}
