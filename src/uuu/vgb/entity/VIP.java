package uuu.vgb.entity;

public class VIP extends Customer {
	private int discount;
	
	public VIP() {
		super();
	}

	
	public VIP(String id, String password, String name, char gender) {
		super(id, password, name, gender);
		// TODO Auto-generated constructor stub
	}


	public VIP(String id, String password, String name) {
		super(id, password, name);
		// TODO Auto-generated constructor stub
	}


	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount >=2 && discount <=15) {
			this.discount = discount;
		}else {
			System.err.printf("VIP折扣必須在2%%~15%%之間 \n"); //for 
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

	@Override
	public String toString() {
		return "["+ super.toString() + 
				  ",\n VIP折扣為:" + discount + "% off, 即為" + getDiscountString() + "]";
	}
	
}
