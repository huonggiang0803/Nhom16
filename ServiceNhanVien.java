package service;

import java.util.List;

import dao.nhanVienDao;
import model.NhanVien;

public class ServiceNhanVien {
	private nhanVienDao nhanVienDao;
	public ServiceNhanVien() {
		nhanVienDao = new nhanVienDao();
	}
	public List<NhanVien> getAllNV(){
		return nhanVienDao.selectAll();
	}
	public void addnv(NhanVien bn) {
		nhanVienDao.insert(bn);
	}
	public void DeleteNV(String id) {
		nhanVienDao.delete(id);
	}
	public void updateNV (NhanVien nv) {
		nhanVienDao.update(nv);
	}
	public NhanVien selectById(String id) {
		return nhanVienDao.selectById(id);
	}
	public List<NhanVien> search(String tennhanVien) {
		return nhanVienDao.search(tennhanVien);
	}
}
