package uuu.vgb.entity;

public class OrderItem {
	private int orderId; // Pkey
	private Product product;// Pkey
	private String cpuName = "";// Pkey
	private String sizeName = "";// Pkey

//	private double listPrice;	//必要,交易時定價
//	private int discount;		//必要,交易時折扣
	private double price; // 必要,交易價
	private int quantity; // 必要

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//依據畫面加 getter
	
	public int getProductId() {
		return product.getId();
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public String getPhotoUrl() {
		return product.getPhotoUrl();
	}
	
	public double getAmount() {
		return price*quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuName == null) ? 0 : cpuName.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((sizeName == null) ? 0 : sizeName.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (cpuName == null) {
			if (other.cpuName != null) {
				return false;
			}
		} else if (!cpuName.equals(other.cpuName)) {
			return false;
		}
		if (orderId != other.orderId) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
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
		return "訂單明細 [訂單編號=" + orderId 
				+ String.format(", 購買產品=%s-%s-%s",getProductName(),cpuName, sizeName)
				+",\n 售價=" + price + ", 數量=" + quantity + "台, 小計 "+ getAmount() 
				+"元,\n 圖片url="+getPhotoUrl() +"]";
	}



}