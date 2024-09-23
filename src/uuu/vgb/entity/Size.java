package uuu.vgb.entity;

public class Size {

	private int productId; // PKey

	private String cpuName; // PKey

	private String sizeName; // PKey

	private int stock; // 必要

	private double unitPrice; // 必要,定價

	private double price; // 必要,折扣後售價

	private int ordinal; // 非必要

	public Size() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuName == null) ? 0 : cpuName.hashCode());
		result = prime * result + productId;
		result = prime * result + ((sizeName == null) ? 0 : sizeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Size)) {
			return false;
		}
		Size other = (Size) obj;
		if (cpuName == null) {
			if (other.cpuName != null) {
				return false;
			}
		} else if (!cpuName.equals(other.cpuName)) {
			return false;
		}
		if (productId != other.productId) {
			return false;
		}
		if (sizeName == null) {
			if (other.sizeName != null) {
				return false;
			}
		} else if (!sizeName.equals(other.sizeName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Size [" +productId +"-" + cpuName + "-" + sizeName + ", 庫存=" + stock
				+ ", 定價=" + unitPrice + ", 售價=" + price + ", 序號=" + ordinal + "]\n";
	}

	
	
}
