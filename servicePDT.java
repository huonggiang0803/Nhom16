package service;

import java.util.List;

import dao.dichVuDao;
import dao.donThuocDao;
import model.DichVu;
import model.phieuDonThuoc;

public class servicePDT {
	private donThuocDao donThuocDao;
	public servicePDT() {
		donThuocDao = new donThuocDao();
	}
	public List<phieuDonThuoc> getAllPDT(){
		return donThuocDao.selectAll();
	}
	public void addPDT(phieuDonThuoc dt) {
		donThuocDao.insert(dt);
	}
}
