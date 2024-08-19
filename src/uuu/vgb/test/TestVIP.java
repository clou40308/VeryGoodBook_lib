package uuu.vgb.test;

import uuu.vgb.entity.VIP;

public class TestVIP {
	public static void main(String[] args) {
		VIP vip = new VIP();
		vip.setId("123");
		vip.setName("jeff");
		vip.setDiscount(1);
		System.out.printf("vip.id: %s\n", vip.getId());
		System.out.printf("vip.Name: %s\n", vip.getName());
		System.out.printf("vip.Discount: %s\n", vip.getDiscount());
		System.out.printf("vip.DiscountString: %s\n",vip.getDiscountString());
		System.out.println(vip);
	}
}
