package uuu.vgb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import uuu.vgb.entity.Product;

public class TestProductPassByValue {

	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		i++;
		System.out.printf("i: %s\n", i); // 2
		System.out.printf("j: %s\n", j); // 2

		Product p = new Product(1, "遙遙領先:使用Java開發Web新手轉高手之路", 650, 10);

		p.setCategory("書籍");
		System.out.printf("p.id: %s\n", p.getId());
		System.out.printf("p.Name: %s\n", p.getName());
		System.out.printf("p.UnitPrice: %s\n", p.getUnitPrice());
		System.out.printf("p.Stock: %s\n", p.getStock());
		System.out.printf("p.Category: %s\n", p.getCategory());
		System.out.println("******************************************************");
		Product p2 =p;
		p2.setId(2);
		p2.setName(p.getName()+" 第二版");
		p2.setUnitPrice(p.getUnitPrice()+50);
		System.out.printf("p.id: %s\n", p.getId());//1
		System.out.printf("p.Name: %s\n", p.getName());//"遙遙領先:使用Java開發Web新手轉高手之路"
		System.out.printf("p.UnitPrice: %s\n", p.getUnitPrice());//650
		System.out.printf("p.Stock: %s\n", p.getStock());//10
		System.out.printf("p.Category: %s\n", p.getCategory());//"書籍"
		System.out.println("******************************************************");
		System.out.printf("p2.id: %s\n", p2.getId());//1
		System.out.printf("p2.Name: %s\n", p2.getName());//"遙遙領先:使用Java開發Web新手轉高手之路"
		System.out.printf("p2.UnitPrice: %s\n", p2.getUnitPrice());//650
		System.out.printf("p2.Stock: %s\n", p2.getStock());//10
		System.out.printf("p2.Category: %s\n", p2.getCategory());//"書籍"
		
		
		String str = "ABCDE";
		StringBuffer strBuf = new StringBuffer(str);
		strBuf.reverse();
		System.out.println(strBuf);
		// ==============================
		// List 反轉
		List<String> strList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
		Collections.reverse(strList);
		System.out.println(strList);
		
	}

}
