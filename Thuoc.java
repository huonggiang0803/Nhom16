package model;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private Float giaThuoc;
	private String xuatXu;
	public Thuoc(String maThuoc, String tenThuoc, Float giaThuoc, String xuatXu) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.giaThuoc = giaThuoc;
		this.xuatXu = xuatXu;
	}
	public Thuoc() {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.giaThuoc = giaThuoc;
		this.xuatXu = xuatXu;
	}
	
	public Thuoc(String maThuoc, String tenThuoc) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public Float getGiaThuoc() {
		return giaThuoc;
	}
	public void setGiaThuoc(Float giaThuoc) {
		this.giaThuoc = giaThuoc;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	@Override
	public String toString() {
		return maThuoc;
	}
	
}
