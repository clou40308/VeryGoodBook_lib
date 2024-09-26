package uuu.vgb.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private Customer member;
	private Map<CartItem, Integer> cart = new HashMap<>();

	public Customer getMember() {
		return member;
	}

	public void setMember(Customer member) {
		this.member = member;
	}

	// 取代 cart屬性的setter的方法: add,update,remove
	public void addToCart(Product p, String cpuName, Size size, int quantity) {
		if(p == null) throw new IllegalArgumentException("加入購物車時產品p不得為null");
		
		Cpu theCpu =null;
		
		if(p.getCpuList().size()>0 && cpuName!=null) {
			theCpu = p.findCpu(cpuName);
		}
		
		CartItem item = new CartItem();
		item.setTheProduct(p);
		item.setTheCpu(theCpu);
		item.setTheSize(size);
		
		Integer preQty = cart.get(item); //檢查同一個item是否已經有之前購買數量
		
		if(preQty!=null) quantity +=preQty;
		
		cart.put(item, quantity);
		
		//TODO: 取代 cart屬性的getter的方法:
		
		
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [訂購人=" + member + "\n, 購物明細= \n" + cart + "]";
	}
}
