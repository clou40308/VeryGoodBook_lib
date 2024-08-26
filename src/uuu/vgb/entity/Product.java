package uuu.vgb.entity;

import java.time.LocalDate;

public class Product {
	private int id; // PKey,AUTO-INCREMENT
	private String name; // required
	private double unitPrice;// required
	private int stock;// required
	private String photoUrl;// optional
	private String category; // 書籍/文具, required
	private LocalDate releaseDate;// required
	private String description = "";// optional 0~250個字元

	public Product() {// 最重要,符合Java BEAN

	}

	public Product(int id, String name, double unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Product(int id, String name, double unitPrice, int stock) {
		// super();

		this(id, name, unitPrice);
//		this.id = id;
//		this.name = name;
//		this.unitPrice = unitPrice;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		} else {
			System.err.println("產品編號不得為負數");
			// TODO:第13章 改成(拋出) throw XxxEeception物件
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate date) {
		this.releaseDate = date;
	}

	/**
	 * 將符合iso-8601的日期字串轉換成LocalDate物件
	 * 再呼叫setReleaseDate(Localate物件)**間接**指派給產品的releaseDate屬性
	 * 
	 * @param releaseDatel
	 */
	public void setReleaseDate(String dateStr) {
		if(dateStr!=null) {
			LocalDate date = LocalDate.parse(dateStr);
			this.setReleaseDate(date);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return 
				this.getClass().getSimpleName()
				+ "[\n產品編號=" + id + ", 名稱=" + name 
				+ ",\n 定價=" + unitPrice + ", 庫存=" + stock + ", 分類=" + category 
				+ ",\n 圖片=" + photoUrl 
				+ ",\n 上架日=" + releaseDate 
				+ ",\n 說明=" + description 
				+ "\n]";
	}

	
}
