package service;

import java.util.List;

import dao.dichVuDao;
import model.DichVu;

public class ServiceDichVu {
	private dichVuDao dichVuDao;
	public ServiceDichVu() {
		dichVuDao = new dichVuDao();
	}
	public List<DichVu> getAllDV(){
		return dichVuDao.selectAll();
	}
	public void addDV(DichVu dv) {
		dichVuDao.insert(dv);
	}
	public void DeleteDV(String id) {
		dichVuDao.delete(id);
	}
	public void updateDV (DichVu dv) {
		dichVuDao.update(dv);
	}
	public DichVu selectById(String id) {
		return dichVuDao.selectById(id);
	}
	public List<DichVu> search(String tendichVu) {
		return dichVuDao.search(tendichVu);
	}
}
