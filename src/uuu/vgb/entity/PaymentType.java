package uuu.vgb.entity;

public enum PaymentType {
	SHOP("門市取貨"),ATM("轉帳付款"),
	HOME("貨到付款",80),STORE("超商取貨"),CARD("信用卡");
	
	private final String description;
	private final double fee;
	
	private PaymentType(String description) {
		this(description,0);
	}
	
	private PaymentType(String description, double fee) {
		this.description = description;
		this.fee = fee;
	}
	public String getDescription() {
		return description;
	}
	public double getFee() {
		return fee;
	}
	
	
}
