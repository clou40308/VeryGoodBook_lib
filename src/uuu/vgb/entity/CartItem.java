package uuu.vgb.entity;

public class CartItem {
	private Product theProduct; // Pkey
	private Cpu theCpu; // Pkey
	private Size theSize; // Pkey

	public Product getTheProduct() {
		return theProduct;
	}

	public void setTheProduct(Product theProduct) {
		this.theProduct = theProduct;
	}

	public Cpu getTheCpu() {
		return theCpu;
	}

	public void setTheCpu(Cpu theCpu) {
		this.theCpu = theCpu;
	}

	public Size getTheSize() {
		return theSize;
	}

	public void setTheSize(Size theSize) {
		this.theSize = theSize;
	}
	
	//根據購物車畫面設計getter
	public int getProductId() {
		return theProduct.getId();
	}
	
	public String getProductName() {
		return theProduct.getName();
	}
	
	public String getCpuName() {
		if(theCpu!=null) {
			return theCpu.getCpuName();
		}else {
			return"";
		}
	}
	
	public String getSizeName() {
		if(theSize!=null) {
			return theSize.getSizeName();
		}else {
			return"";
		}
	}

	public int getStock() {
		if(theSize!= null) {
			return theSize.getStock();
		}else if(theCpu!=null) {
			return theCpu.getStock();
		}else {
			return theProduct.getStock();
		}
	}
	
	public String getPhotoUrl() {
		if(theCpu != null && theCpu.getPhotoUrl()!=null) {
			return theCpu.getPhotoUrl();
		}else {
			return theProduct.getPhotoUrl();
		}
	}
	
	public double getListPrice() {
		if(theSize != null) {
			return theSize.getUnitPrice();
		}else {
			if(theProduct instanceof SpecialOffer) {
				return((SpecialOffer)theProduct).getListPrice();
			}else {
				return theProduct.getUnitPrice();
			}
		}
	}
	
	public double getPrice() {
		if(theSize != null) {
			return theSize.getPrice();
		}else {
			return theProduct.getUnitPrice();
		}
	}
	
	public String getDiscountString(){
		if(theProduct instanceof SpecialOffer) {
			return((SpecialOffer)theProduct).getDiscountString();
		}else {
			return "";
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((theCpu == null) ? 0 : theCpu.hashCode());
		result = prime * result + ((theProduct == null) ? 0 : theProduct.hashCode());
		result = prime * result + ((theSize == null) ? 0 : theSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CartItem other = (CartItem) obj;
		if (theCpu == null) {
			if (other.theCpu != null) {
				return false;
			}
		} else if (!theCpu.equals(other.theCpu)) {
			return false;
		}
		if (theProduct == null) {
			if (other.theProduct != null) {
				return false;
			}
		} else if (!theProduct.equals(other.theProduct)) {
			return false;
		}
		if (theSize == null) {
			if (other.theSize != null) {
				return false;
			}
		} else if (!theSize.equals(other.theSize)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "購物明細 [編號=" + getProductId() 
				+ String.format(", Product-Cpu-Size = %s-%s-%s" ,getProductName(),getCpuName(),getSizeName())
				+ ", 庫存=" + getStock() 
				+ "\n, 圖片網址="+ getPhotoUrl() 
				+ "\n, 定價=" + getListPrice() +", 折扣="+getDiscountString()+ ", 售價=" + getPrice() + "]\n";
	}

}
