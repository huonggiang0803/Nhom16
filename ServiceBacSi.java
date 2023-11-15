package service;

import java.util.List;

import dao.bacSiDao;
import dao.benhNhanDao;
import model.bacSi;
import model.benhNhan;

public class ServiceBacSi {
	private bacSiDao bacSiDao;
	public ServiceBacSi() {
		bacSiDao = new bacSiDao();
	}
	public List<bacSi> getAllBS(){
		return bacSiDao.selectAll();
	}
	public void addBS(bacSi bn) {
		bacSiDao.insert(bn);
	}
	public void DeleteBS(String id) {
		bacSiDao.delete(id);
	}
	public void updateBS (bacSi bs) {
		bacSiDao.update(bs);
	}
	public bacSi selectById(String id) {
		return bacSiDao.selectById(id);
	}
	public List<bacSi> search(String tenBacSi) {
		return bacSiDao.search(tenBacSi);
	}
}
