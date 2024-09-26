package uuu.vgb.entity;

import java.time.LocalDate;

import uuu.vgb.exception.VGBDataInvalidException;

public class Cpu {

	private String cpuName; // 必要,PKey

	private int stock; // 必要

	private LocalDate releaseDate;

	private String photoUrl;

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		if(cpuName !=null && (cpuName=cpuName.trim()).length()>0) {
			this.cpuName = cpuName;
		}else {
			throw new VGBDataInvalidException("CPU名稱必須有值");
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuName == null) ? 0 : cpuName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cpu)) {
			return false;
		}
		Cpu other = (Cpu) obj;
		if (cpuName == null) {
			if (other.cpuName != null) {
				return false;
			}
		} else if (!cpuName.equals(other.cpuName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cpu [CPU名稱=" + cpuName + ", CPU庫存=" + stock + "\n, CPU上架日期="
				+ releaseDate + ", 圖片網址="+ photoUrl + "]";
	}
	
	
}
