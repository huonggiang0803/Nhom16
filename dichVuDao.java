package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.DichVu;

public class dichVuDao implements DAOInterface<DichVu>{

	@Override
	public int insert(DichVu t) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO dichvu (maDV, tenDV, donGia)"+
					"VALUES (?,?,?)";
			PreparedStatement st =  con.prepareStatement(sql);
			
			st.setString(1,t.getMaDV());
			st.setString(2, t.getTenDV());
			st.setFloat(3, t.getDonGia());
			
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
	public int update(DichVu t) {
	    int ketqua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE dichvu " +
	                     "SET tenDV=?, donGia=? " +
	                     "WHERE maDV=?";

	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, t.getTenDV());
	        st.setFloat(2, t.getDonGia());
	        st.setString(3, t.getMaDV()); 

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
			
			String sql = "DELETE from dichvu "+
					 " WHERE maDV=?";
			
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
	public ArrayList<DichVu> selectAll() {
		ArrayList ketqua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM dichvu";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maDV = rs.getString("maDV");
				String tenDV = rs.getString("tenDV");
				Float donGia = rs.getFloat("donGia");
				DichVu dv = new DichVu(maDV, tenDV, donGia);
				ketqua.add(dv);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		}
		return ketqua;
	}

	@Override
	public DichVu selectById(String t) {
		DichVu ketqua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM dichvu WHERE maDV=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maDV = rs.getString("maDV");
				String tenDV = rs.getString("tenDV");
				Float donGia = rs.getFloat("donGia");

				ketqua = new DichVu(maDV, tenDV, donGia);	
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		
			}
		return ketqua;
	}

	@Override
	public List<DichVu> search(String t) {
		 List<DichVu> resultList = new ArrayList<>();

		    try {
		        Connection con = JDBCUtil.getConnection();

		        String sql = "SELECT * FROM dichvu WHERE tenDV LIKE ?";
		        PreparedStatement st = con.prepareStatement(sql);
		        st.setString(1, "%" + t + "%"); // Use the parameter 't' instead of 'tenDV'

		        ResultSet resultSet = st.executeQuery();

		        while (resultSet.next()) {
		            DichVu bn = new DichVu();
		            bn.setMaDV(resultSet.getString("maDV"));
		            bn.setTenDV(resultSet.getString("tenDV"));
		            bn.setDonGia(resultSet.getFloat("donGia"));
		            resultList.add(bn);
		        }
		        JDBCUtil.closeConnection(con);

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
	}
}
