package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.NhanVien;
import model.bacSi;

public class nhanVienDao implements DAOInterface<NhanVien>{

	private String tenNV;

	@Override
	public int insert(NhanVien t) {
		// TODO Auto-generated method stub
				int ketqua = 0;
				try {
					Connection con = JDBCUtil.getConnection();
					String sql = "INSERT INTO nhanvien (maNV, tenNV, gioiTinhNV,SĐTNV)"+
							"VALUES (?,?,?,?)";
					PreparedStatement st =  con.prepareStatement(sql);
					
					st.setString(1,t.getMaNV());
					st.setString(2, t.getTenNV());
					st.setString(3, t.getGioiTinhNV());
					st.setString(4, t.getSĐTNV());
					
					ketqua = st.executeUpdate();
					System.out.println("Ban da thuc thi "+sql);
					System.out.println("So "+ ketqua + " dong da thay doi");
					JDBCUtil.closeConnection(con);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return ketqua;
	}

	@Override
	public int update(NhanVien t) {
	    int ketqua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE nhanvien " +
	                     "SET tenNV=?, gioiTinhNV=?, SĐTNV=? " +
	                     "WHERE maNV=?";

	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, t.getTenNV());       
	        st.setString(2, t.getGioiTinhNV());
	        st.setString(3, t.getSĐTNV());
	        st.setString(4, t.getMaNV());        

	        ketqua = st.executeUpdate();
	        System.out.println("Ban da thuc thi " + sql);
	        System.out.println("So " + ketqua + " dong da thay doi");
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketqua;
	}

	@Override
	public int delete(String t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from nhanvien "+
					 " WHERE maNV=?";
			
			PreparedStatement st =  con.prepareStatement(sql);
			st.setString(1,t);
			ketqua = st.executeUpdate();
			System.out.println("Ban da thuc thi "+sql);
			System.out.println("So "+ ketqua + " dong da thay doi");
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<NhanVien> selectAll() {
		ArrayList ketqua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM nhanvien";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("tenNV");
				String gioiTinhNV = rs.getString("gioiTinhNV");
				String SĐTNV = rs.getString("SĐTNV");
				NhanVien us = new NhanVien(maNV, tenNV, gioiTinhNV, SĐTNV);
				ketqua.add(us);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		}
		return ketqua;
	}

	@Override
	public NhanVien selectById(String t) {
		NhanVien ketqua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM nhanvien WHERE maNV=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("tenNV");
				String gioiTinhNV = rs.getString("gioiTinhNV");
				String SĐTNV = rs.getString("SĐTNV");

				ketqua = new NhanVien(maNV, tenNV, gioiTinhNV, SĐTNV);	
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		
			}
		return ketqua;
	}

	@Override
	public List<NhanVien> search(String t) {
	    List<NhanVien> resultList = new ArrayList<>();

	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "SELECT * FROM nhanvien WHERE tenNV LIKE ?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, "%" + t + "%"); // Use the parameter 't' instead of 'tenNV'

	        ResultSet resultSet = st.executeQuery();

	        while (resultSet.next()) {
	            NhanVien bn = new NhanVien();
	            bn.setMaNV(resultSet.getString("maNV"));
	            bn.setTenNV(resultSet.getString("tenNV"));
	            bn.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
	            bn.setSĐTNV(resultSet.getString("SĐTNV"));
	            resultList.add(bn);
	        }
	        JDBCUtil.closeConnection(con);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}
}

