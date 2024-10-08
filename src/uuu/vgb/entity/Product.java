package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Product {
	private int id; // PKey,AUTO-INCREMENT
	private String name; // required
	private double unitPrice;// required
	private int stock;// required
	private String photoUrl;// optional
	private String category; // 書籍/文具, required
	private LocalDate releaseDate;// required
	private String description = "";// optional 0~250個字元
	private int sizeCount ;
	private List<Cpu> cpuList = new ArrayList<>();

	
	public List<Cpu> getCpuList() {
		//return cpuList; //不應直接回傳正本
		return new ArrayList<>(cpuList); //應return 複本
		//return Collections.unmodifiableList(cpuList);//或return 不可變更的整本
	}

	//取代集合屬性的setter: add,(update,remove用不到)
	public void add(Cpu cpu){
		cpuList.add(cpu);
	}
	//集合屬性不可直接set
//	public void setCpuList(List<Cpu> cpuList) {
//		this.cpuList = cpuList;
//	}

	public Cpu findCpu(String Cpuname) {
		Cpu theCpu =null ;
		if( cpuList.size()>0 &&  Cpuname!=null) {
			for(int i=0; i<cpuList.size();i++) {
				Cpu cpu = cpuList.get(i);
				if(cpu!=null && cpu.getCpuName().equals(Cpuname)) {
					theCpu = cpu;
					break;
				}
			}
		}
		return  theCpu;
	}
	
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
		if(cpuList != null && cpuList.size()>0) {
			int  sum = 0;
			for ( int i = 0 ; i < cpuList.size() ; i++ ){
				Cpu cpu = cpuList.get(i);
				sum += cpu.getStock();
			}
			return sum;
		}
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

	
	public int getSizeCount() {
		return sizeCount;
	}

	public void setSizeCount(int sizeCount) {
		this.sizeCount = sizeCount;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Product other = (Product) obj;
		if (id != other.id) {
			return false;
		}
		return true;
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
				+ ",\n CPU清單=" + cpuList
				+ "\n]";
	}

	
}
