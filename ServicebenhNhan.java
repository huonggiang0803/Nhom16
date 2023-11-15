package service;

import java.util.List;

import dao.benhNhanDao;
import model.benhNhan;

public class ServicebenhNhan {
	private benhNhanDao benhnhanDao;
	public ServicebenhNhan() {
		benhnhanDao = new benhNhanDao();
	}
	public List<benhNhan> getAllBN(){
		return benhnhanDao.selectAll();
	}
	public void addBN(benhNhan bn) {
		benhnhanDao.insert(bn);
	}
	public void DeleteBN(String id) {
		benhnhanDao.delete(id);
	}
	public void updateBN (benhNhan user) {
		benhnhanDao.update(user);
	}
	public benhNhan selectById(String id) {
		return benhnhanDao.selectById(id);
	}
	public List<benhNhan> search(String tenBenhNhan) {
		return benhnhanDao.search(tenBenhNhan);
	}
}
