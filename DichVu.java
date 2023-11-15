package model;

public class DichVu {
	private String maDV;
	private String tenDV;
	private Float donGia;
	public DichVu(String maDV, String tenDV, Float donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
	}
	public DichVu() {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public Float getDonGia() {
		return donGia;
	}
	public void setDonGia(Float donGia) {
		this.donGia = donGia;
	}
	
}
