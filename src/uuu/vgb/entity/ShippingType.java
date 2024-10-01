package uuu.vgb.entity;

public enum ShippingType {
	SHOP("門市取貨",new PaymentType[] {PaymentType.SHOP}), 
	HOME("宅配", 120, PaymentType.ATM ,PaymentType.HOME,PaymentType.CARD), 
	STORE("超商取貨", PaymentType.ATM ,PaymentType.STORE,PaymentType.CARD),
	NO("無須貨運",PaymentType.ATM,PaymentType.CARD);// 第一行必須先宣告列舉職(最好用英文)

	private final String description;
	private final double fee;
	private final PaymentType[] PaymentTypeArray;
	
//	public PaymentType[] getPaymentTypeArray() {
//		return PaymentTypeArray!=null?PaymentTypeArray.clone():null;
//	}
	
	public String getPaymentTypeArrayStr() {
		StringBuilder data = new StringBuilder();
		if(PaymentTypeArray != null && PaymentTypeArray.length>0) {
			for(PaymentType pType :PaymentTypeArray) {
				if(data.length()>0) data.append(",");
				data.append(pType.name());
			}
		}
		return data.toString();
	}

	private ShippingType(String description,PaymentType... PaymentTypeArray) {
		this(description, 0,PaymentTypeArray);
	}

	private ShippingType(String description, double fee,PaymentType... PaymentTypeArray) {
		this.description = description;
		this.fee = fee;
		this.PaymentTypeArray=PaymentTypeArray;
	}

	public String getDescription() {
		return description;
	}

	public double getFee() {
		return fee;
	}

	@Override
	public String toString() {
		return this.description + "," + this.fee + "元";
	}
}
