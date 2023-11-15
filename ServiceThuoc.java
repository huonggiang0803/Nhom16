package service;

import java.util.List;

import dao.thuocDao;
import dao.thuocDao;
import model.Thuoc;

public class ServiceThuoc {
	private thuocDao thuocDao;
	public ServiceThuoc() {
		thuocDao = new thuocDao();
	}
	public List<Thuoc> getAllT(){
		return thuocDao.selectAll();
	}
	public void addT(Thuoc t) {
		thuocDao.insert(t);
	}
	public void DeleteT(String id) {
		thuocDao.delete(id);
	}
	public void updateT (Thuoc t) {
		thuocDao.update(t);
	}
	public Thuoc selectById(String id) {
		return thuocDao.selectById(id);
	}
	public List<Thuoc> search(String tenThuoc) {
		return thuocDao.search(tenThuoc);
	}
}
