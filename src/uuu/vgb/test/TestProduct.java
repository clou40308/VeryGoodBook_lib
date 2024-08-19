package uuu.vgb.test;

import uuu.vgb.entity.Product;

public class TestProduct {
	public static void main(String[] args) {
		//Product p = new Product();
		Product p = new Product(1,"遙遙領先:使用Java開發Web新手轉高手之路",650,10);
		p.setId(1);
		p.setName("遙遙領先:使用Java開發Web新手轉高手之路");
		p.setUnitPrice(650);
		p.setPhotoUrl("https://www.books.com.tw/products/0010983582");
		p.setCategory("工具書");
		p.setReleaseDate("2024-03-20");		
		p.setDescription("　　●2024年繼續用Java開發，真正正統純OO語言\r\n"
				+ "　　●Web開發及Java Web開發的異同\r\n"
				+ "　　●Java開發的環境安裝、設定、使用\r\n"
				+ "　　●JSP基礎、內建物件、JavaBean技術、Servelet技術\r\n"
				+ "　　●Servlet的籂檢程式及監聽器\r\n"
				+ "　　●Java Web的資料庫操作及EL運算語言、JSTL標籤、Ajax技術\r\n"
				+ "　　●SSM架構之Spring IoC、AOP、MVC\r\n"
				+ "　　●MyBatis、Maven’ SSM整合");
//		System.out.printf("p.id: %s\n",p.getId());
//		System.out.printf("p.Name: %s\n",p.getName());
//		System.out.printf("p.UnitPrice: %s\n",p.getUnitPrice());
//		System.out.printf("p.Stock: %s\n",p.getStock());
		System.out.println(p);
	}

}
