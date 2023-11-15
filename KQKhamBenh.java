package model;

import java.sql.Date;

public class KQKhamBenh {
	private String maPhieu;
	private String tenDV;
	private String maBS;
	private String tenBS;
	private String maBN;
	private String tenBN;
	private Date ngayKham;
	private String chuyenKhoa;
	private String ketLuan;
	public KQKhamBenh(String maPhieu, String tenDV, String maBS, String tenBS, String maBN, String tenBN, Date ngayKham,
			String chuyenKhoa, String ketLuan) {
		super();
		this.maPhieu = maPhieu;
		this.tenDV = tenDV;
		this.maBS = maBS;
		this.tenBS = tenBS;
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.ngayKham = ngayKham;
		this.chuyenKhoa = chuyenKhoa;
		this.ketLuan = ketLuan;
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getMaBS() {
		return maBS;
	}
	public void setMaBS(String maBS) {
		this.maBS = maBS;
	}
	public String getTenBS() {
		return tenBS;
	}
	public void setTenBS(String tenBS) {
		this.tenBS = tenBS;
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
	public Date getNgayKham() {
		return ngayKham;
	}
	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}
	public String getChuyenKhoa() {
		return chuyenKhoa;
	}
	public void setChuyenKhoa(String chuyenKhoa) {
		this.chuyenKhoa = chuyenKhoa;
	}
	public String getKetLuan() {
		return ketLuan;
	}
	public void setKetLuan(String ketLuan) {
		this.ketLuan = ketLuan;
	}
	@Override
	public String toString() {
		return "KQKhamBenh [maPhieu=" + maPhieu + ", tenDV=" + tenDV + ", maBS=" + maBS + ", tenBS=" + tenBS + ", maBN="
				+ maBN + ", tenBN=" + tenBN + ", ngayKham=" + ngayKham + ", chuyenKhoa=" + chuyenKhoa + ", ketLuan="
				+ ketLuan + "]";
	}
	
}
