package dao;

import java.util.ArrayList;
import java.util.List;

import model.bacSi;
import model.benhNhan;

public interface DAOInterface<T> {
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(String t);
	
	public ArrayList<T> selectAll();
	
	public T selectById(String t);
	
	public List<T> search(String t);

}
