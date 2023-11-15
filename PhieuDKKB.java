package model;

import java.sql.Date;

public class PhieuDKKB {
	private int STT;
	private String maBN;
	private String tenBN;
	private String doiTuong;
	private String maBH;
	private String TTSK;
	private Date ngaySinh;
	private Date ngayDK;
	public PhieuDKKB(int STT, String maBN, String tenBN, String doiTuong, String maBH, String TTSK,Date ngaySinh, Date ngayDK) {
		super();
		this.STT = STT;
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.doiTuong = doiTuong;
		this.maBH = maBH;
		this.TTSK = TTSK;
		this.ngaySinh = ngaySinh;
		this.ngayDK = ngayDK;
	}
	public PhieuDKKB() {
		super();
		this.STT = STT;
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.doiTuong = doiTuong;
		this.maBH = maBH;
		this.TTSK = TTSK;
		this.ngaySinh = ngaySinh;
		this.ngayDK = ngayDK;
	}
	
	public int getSTT() {
		return STT;
	}
	public void setSTT(int sTT) {
		STT = sTT;
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
	public String getDoiTuong() {
		return doiTuong;
	}
	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}
	public String getMaBH() {
		return maBH;
	}
	public void setMaBH(String maBH) {
		this.maBH = maBH;
	}
	public String getTTSK() {
		return TTSK;
	}
	public void setTTSK(String tTSK) {
		TTSK = tTSK;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayDK() {
		return ngayDK;
	}
	public void setNgayDK(Date ngayDK) {
		this.ngayDK = ngayDK;
	}
	@Override
	public String toString() {
		return "PhieuDKKB [STT=" + STT + ", maBN=" + maBN + ", tenBN=" + tenBN + ", doiTuong=" + doiTuong + ", maBH="
				+ maBH + ", TTSK=" + TTSK + ", ngayDK=" + ngayDK + "]";
	}
	
	
}
