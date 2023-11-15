package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class benhNhan {
	private String 	maBN;
	private String tenBN;
	private String gioiTinhBN;
	private Date ngaySinh;
	private String doiTuong;
	private String maBH;
	private String diaChiBN;
	private String SĐTBN;
	public benhNhan(String maBN, String tenBN, String gioiTinhBN, Date ngaySinh, String doiTuong, String maBH,
			String diaChiBN, String SĐTBN) {
		super();
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.gioiTinhBN = gioiTinhBN;
		this.ngaySinh = ngaySinh;
		this.doiTuong = doiTuong;
		this.maBH = maBH;
		this.diaChiBN = diaChiBN;
		this.SĐTBN = SĐTBN;
	}
	
	public benhNhan(String maBN, String tenBN, Date ngaySinh) {
		super();
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.ngaySinh = ngaySinh;
	}

	public benhNhan() {
		super();
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.gioiTinhBN = gioiTinhBN;
		this.ngaySinh = ngaySinh;
		this.doiTuong = doiTuong;
		this.maBH = maBH;
		this.diaChiBN = diaChiBN;
		this.SĐTBN = SĐTBN;
	}
	
	public benhNhan(String maBN, String tenBN) {
		super();
		this.maBN = maBN;
		this.tenBN = tenBN;
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
	public String getGioiTinhBN() {
		return gioiTinhBN;
	}
	public void setGioiTinhBN(String gioiTinhBN) {
		this.gioiTinhBN = gioiTinhBN;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
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
	public String getDiaChiBN() {
		return diaChiBN;
	}
	public void setDiaChiBN(String diaChiBN) {
		this.diaChiBN = diaChiBN;
	}
	public String getSĐTBN() {
		return SĐTBN;
	}
	public void setSĐTBN(String SĐTBN) {
		this.SĐTBN = SĐTBN;
	}
	@Override
	public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedNgaySinh = dateFormat.format(ngaySinh);
        return maBN ;
    }
	
	
	
	
}
