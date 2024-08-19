package uuu.vgb.test;

import uuu.vgb.entity.SpecialOffer;

public class TestSpecialOffer {
	public static void main(String[] args) {
		SpecialOffer sp = new SpecialOffer();
		sp.setId(2);
		sp.setName("排球少年！！magazine 全 (首刷限定版)");
		sp.setUnitPrice(650);
		sp.setStock(5);
		sp.setPhotoUrl("https://www.books.com.tw/products/0010994237?loc=P_0003_001");
		sp.setCategory("書籍");
		sp.setDescription("本書內容豐富！有主要角色專訪、Ｖ聯賽選手專訪：西田有志。\n"+
						  "作者歷代助手工作漫畫、三大平行作品特別篇：「排球少年社團活動！！」、\n"+
				          "「Ｌｅｔ’ｓ排球少年？」和「排球少年！！小說版！」全新輕小說。２款貼紙＆雙面大海報，還有抽獎送精美文件夾。");
		sp.setReleaseDate("2024-07-27");
		sp.setDiscount(50);//50%off

//		System.out.printf("sp.Id:%s\n",sp.getId());
//		System.out.printf("sp.Name:%s\n",sp.getName());
//		System.out.printf("sp.UnitPrice:%s\n",sp.getUnitPrice());
//		System.out.printf("sp.Stock:%s\n",sp.getStock());
//		System.out.printf("sp.PhotoUrl:%s\n",sp.getPhotoUrl());
//		System.out.printf("sp.Category:%s\n",sp.getCategory());
//		System.out.printf("sp.Description:%s\n",sp.getDescription());
//		System.out.printf("sp.ReleaseDate:%s\n",sp.getReleaseDate());
//		System.out.printf("sp.Discount:%s\n",sp.getDiscount());
//		System.out.printf("sp.DiscountString:%s\n",sp.getDiscountString());
//		System.out.printf("sp.UnitPrice:%s\n",sp.getUnitPrice());
		System.out.println(sp);
	}
}
