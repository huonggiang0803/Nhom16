package model;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String gioiTinhNV;
	private String SĐTNV;
	public NhanVien(String maNV, String tenNV, String gioiTinhNV, String SĐTNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinhNV = gioiTinhNV;
		this.SĐTNV = SĐTNV;
	}
	public NhanVien() {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinhNV = gioiTinhNV;
		this.SĐTNV = SĐTNV;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getGioiTinhNV() {
		return gioiTinhNV;
	}
	public void setGioiTinhNV(String gioiTinhNV) {
		this.gioiTinhNV = gioiTinhNV;
	}
	public String getSĐTNV() {
		return SĐTNV;
	}
	public void setSĐTNV(String SĐTNV) {
		this.SĐTNV = SĐTNV;
	}
	@Override
	public String toString() {
		return maNV;
	}
	
	
}
