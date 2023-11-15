package model;

public class bacSi {
	private String maBS;
	private String tenBS;
	private String gioiTinhBS;
	private String SĐTBS;
	private String Khoa;
	public bacSi(String maBS, String tenBS, String gioiTinhBS, String SĐTBS, String Khoa) {
		super();
		this.maBS = maBS;
		this.tenBS = tenBS;
		this.gioiTinhBS = gioiTinhBS;
		this.SĐTBS = SĐTBS;
		this.Khoa = Khoa;
	}
	public bacSi() {
		super();
		this.maBS = maBS;
		this.tenBS = tenBS;
		this.gioiTinhBS = gioiTinhBS;
		this.SĐTBS = SĐTBS;
		this.Khoa = Khoa;
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
	public String getGioiTinhBS() {
		return gioiTinhBS;
	}
	public void setGioiTinhBS(String gioiTinhBS) {
		this.gioiTinhBS = gioiTinhBS;
	}
	public String getSĐTBS() {
		return SĐTBS;
	}
	public void setSĐTBS(String sĐTBS) {
		SĐTBS = sĐTBS;
	}
	public String getKhoa() {
		return Khoa;
	}
	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	@Override
	public String toString() {
		return maBS;
	}
	public bacSi(String maBS, String tenBS, String khoa) {
		super();
		this.maBS = maBS;
		this.tenBS = tenBS;
		Khoa = khoa;
	}
	
}
