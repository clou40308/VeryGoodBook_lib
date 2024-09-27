package uuu.vgb.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import uuu.vgb.exception.VGBDataInvalidException;

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
		if(p.getCpuList().size()>0 && theCpu ==null) {
			throw new VGBDataInvalidException("加入購物車cpu不正確");
		}
		
		CartItem item = new CartItem();
		item.setTheProduct(p);
		item.setTheCpu(theCpu);
		item.setTheSize(size);
		
		Integer preQty = cart.get(item); //檢查同一個item是否已經有之前購買數量
		
		if(preQty!=null) quantity +=preQty;
		
		cart.put(item, quantity);
		
		
	}
	
	//取代 cart屬性的getter的方法:
	
	//用[source] -> [delegate methods]
	public int size() { //共N項
		return cart.size();
	}

	public boolean isEmpty() {
		return cart.isEmpty();
	}

	public Integer getQuantity(CartItem key) {
		return cart.get(key);
	}

	public Set<CartItem> getCartItemsSet() {
		return cart.keySet();//集合不得為傳正本 TODO:改成回傳副本
	}

	//自訂getter (依據商業邏輯)
	public double getAmount(CartItem key) {
		Integer qty = this.getQuantity(key);
		double amount = 0;
		if(qty != null) {
			amount  = key.getPrice()*qty;
		}
		return amount;
	}
	
	public int getTotalQuantity() {	//共N件
		int sum = 0;
		Collection<Integer> values = cart.values();
		for(Integer qty :values){
			if(qty!= null){
				sum = sum + qty;
			}
		}	
		return sum;
	}
	/**
	 * @return 購物車的總金額
	 */
	public double getTotalAmount() { //總金額
		double sum = 0;
		Set<CartItem> keySet =cart.keySet();
		for(CartItem item :keySet){
			sum = sum + getAmount(item);
		}	
		return Math.round(sum); //回傳前用 Math.round(sum)、Math.floor(sum)、Math.ceil(sum) 來處理小數資料
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [訂購人=" + member + "\n, 購物明細= \n" + cart 
				+ "\n"+String.format("\n 共%s項,%s台,總金額:%s元", size(), getTotalQuantity(), getTotalAmount())
				+ "]";
	}
}
