package model;

import java.util.Date;

public class phieuDonThuoc {
	private String maDonThuoc;
	private String maThuoc;
	private String tenThuoc;
	private int soLuong;
	private String maBN;
	private String tenBN;
	private String phongKham;
	private String maNV;
	private String benhMacPhai;
	private String cachDung;
	private Date ngayKeDon;
	private String ĐVT;
	private float thanhTien;
	public phieuDonThuoc(String maDonThuoc, String maThuoc, String tenThuoc, int soLuong, String maBN, String tenBN,
			String phongKham, String maNV, String benhMacPhai, String cachDung, Date ngayKeDon, String ĐVT,
			float thanhTien) {
		super();
		this.maDonThuoc = maDonThuoc;
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.soLuong = soLuong;
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.phongKham = phongKham;
		this.maNV = maNV;
		this.benhMacPhai = benhMacPhai;
		this.cachDung = cachDung;
		this.ngayKeDon = ngayKeDon;
		this.ĐVT = ĐVT;
		this.thanhTien = thanhTien;
	}
	public phieuDonThuoc() {
		super();
		this.maDonThuoc = maDonThuoc;
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.soLuong = soLuong;
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.phongKham = phongKham;
		this.maNV = maNV;
		this.benhMacPhai = benhMacPhai;
		this.cachDung = cachDung;
		this.ngayKeDon = ngayKeDon;
		this.ĐVT = ĐVT;
		this.thanhTien = thanhTien;
	}
	public String getMaDonThuoc() {
		return maDonThuoc;
	}
	public void setMaDonThuoc(String maDonThuoc) {
		this.maDonThuoc = maDonThuoc;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getMaBN() {
		return maBN;
	}
	public void setMaBN(String maBN) {
		this.maBN = maBN;
	}
	public String getTenBN() {
		return tenBN;
	}
	public void setTenBN(String tenBN) {
		this.tenBN = tenBN;
	}
	public String getPhongKham() {
		return phongKham;
	}
	public void setPhongKham(String phongKham) {
		this.phongKham = phongKham;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getBenhMacPhai() {
		return benhMacPhai;
	}
	public void setBenhMacPhai(String benhMacPhai) {
		this.benhMacPhai = benhMacPhai;
	}
	public String getCachDung() {
		return cachDung;
	}
	public void setCachDung(String cachDung) {
		this.cachDung = cachDung;
	}
	public Date getNgayKeDon() {
		return ngayKeDon;
	}
	public void setNgayKeDon(Date ngayKeDon) {
		this.ngayKeDon = ngayKeDon;
	}
	public String getĐVT() {
		return ĐVT;
	}
	public void setĐVT(String ĐVT) {
		this.ĐVT = ĐVT;
	}
	public float getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
	
}
