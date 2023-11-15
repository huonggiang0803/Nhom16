package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.bacSi;
import model.benhNhan;


public class bacSiDao implements DAOInterface<bacSi>{
	public static bacSiDao getInstance() {
		return new bacSiDao();
	}
	@Override
	public int insert(bacSi t) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO bacsi (maBS, tenBS, gioiTinhBS,SĐTBS,Khoa)"+
					"VALUES (?,?,?,?,?)";
			PreparedStatement st =  con.prepareStatement(sql);
			
			st.setString(1,t.getMaBS());
			st.setString(2, t.getTenBS());
			st.setString(3, t.getGioiTinhBS());
			st.setString(4, t.getSĐTBS());
			st.setString(5, t.getKhoa());
			
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
	public int update(bacSi t) {
		int ketqua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE bacsi " +
	                     "SET tenBS=?, gioiTinhBS=?, SĐTBS=?, Khoa=? " +
	                     "WHERE maBS=?";

	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, t.getTenBS());
	        st.setString(2, t.getGioiTinhBS());
	        st.setString(3, t.getSĐTBS());
	        st.setString(4, t.getKhoa());
	        st.setString(5, t.getMaBS());  // Set the value for maBS

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
			
			String sql = "DELETE from bacsi "+
					 " WHERE maBS=?";
			
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
	public ArrayList<bacSi> selectAll() {
		ArrayList ketqua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM bacsi";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maBS = rs.getString("maBS");
				String tenBS = rs.getString("tenBS");
				String gioiTinhBS = rs.getString("gioiTinhBS");
				String SĐTBS = rs.getString("SĐTBS");
				String Khoa = rs.getString("Khoa");
				bacSi us = new bacSi(maBS, tenBS, gioiTinhBS, SĐTBS, Khoa);
				ketqua.add(us);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		}
		return ketqua;
	}

	@Override
	public bacSi selectById(String t) {
		bacSi ketqua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM bacsi WHERE maBS=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maBS = rs.getString("maBS");
				String tenBS = rs.getString("tenBS");
				String gioiTinhBS = rs.getString("gioiTinhBS");
				String SĐTBS = rs.getString("SĐTBS");
				String Khoa = rs.getString("Khoa");

				ketqua = new bacSi(maBS, tenBS, gioiTinhBS, SĐTBS, Khoa);	
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		
			}
		return ketqua;
	}

	@Override
	public List<bacSi> search(String tenBacSi) {
	    List<bacSi> resultList = new ArrayList<>();

	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "SELECT * FROM bacsi WHERE tenBS LIKE ?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, "%" + tenBacSi + "%");

	        ResultSet resultSet = st.executeQuery();

	        while (resultSet.next()) {
	            bacSi bn = new bacSi();
	            bn.setMaBS(resultSet.getString("maBS"));
	            bn.setTenBS(resultSet.getString("tenBS"));
	            bn.setGioiTinhBS(resultSet.getString("gioiTinhBS"));
	            bn.setSĐTBS(resultSet.getString("SĐTBS"));
	            bn.setKhoa(resultSet.getString("Khoa"));
	            resultList.add(bn);
	        }
	        JDBCUtil.closeConnection(con);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}
}
