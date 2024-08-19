package uuu.vgb.entity;

public class SpecialOffer extends Product {
	private int discount;

	


	public SpecialOffer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpecialOffer(int id, String name, double unitPrice, int stock) {
		super(id, name, unitPrice, stock);
		// TODO Auto-generated constructor stub
	}

	public SpecialOffer(int id, String name, double unitPrice) {
		super(id, name, unitPrice);
		// TODO Auto-generated constructor stub
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount >=1 && discount <=90) {
			this.discount = discount;
		}else {
			System.err.printf("VIP折扣必須在1%%~90%%之間 \n"); //for 
			// TODO:第13章 改成(拋出) throw XxxEeception物件
		}
	}
	public String getDiscountString() {
		int discount = 100-this.discount;
		if(discount % 10 == 0) {
			discount  = discount /10;
		}
		return discount +"折";
	}
	/**
	 * 查詢售價
	 * @return
	 */
	@Override
	public double getUnitPrice() {
		return super.getUnitPrice() * (100-discount)/100;
	}

	@Override
	public String toString() {
		return "["+super.toString()+"discount=" + discount + "]";
				
	}
	
}
