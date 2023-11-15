package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import database.JDBCUtil;
import model.benhNhan;

public class benhNhanDao implements DAOInterface<benhNhan>{
	public static benhNhanDao getInstance() {
		return new benhNhanDao();
	}
	@Override
	public int insert(benhNhan t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO benhnhan (maBN, tenBN, gioiTinhBN,ngaySinh,doiTuong,maBH,diaChiBN,SĐTBN)"+
					"VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement st =  con.prepareStatement(sql);
			
			st.setString(1,t.getMaBN());
			st.setString(2, t.getTenBN());
			st.setString(3, t.getGioiTinhBN());
			st.setDate(4, t.getNgaySinh());
			st.setString(5, t.getDoiTuong());
			st.setString(6, t.getMaBH());
			st.setString(7, t.getDiaChiBN());
			st.setString(8, t.getSĐTBN());

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
	public int update(benhNhan t) {
	    int ketqua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE benhnhan " +
	                     "SET tenBN=?, gioiTinhBN=?, ngaySinh=?, doiTuong=?, maBH=?, diaChiBN=?, SĐTBN=? " +
	                     "WHERE maBN=?";

	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, t.getTenBN());
	        st.setString(2, t.getGioiTinhBN());
	        st.setDate(3, t.getNgaySinh());
	        st.setString(4, t.getDoiTuong());
	        st.setString(5, t.getMaBH());
	        st.setString(6, t.getDiaChiBN());
	        st.setString(7, t.getSĐTBN());
	        st.setString(8, t.getMaBN());

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
			
			String sql = "DELETE from benhnhan "+
					 " WHERE maBN=?";
			
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
	public ArrayList<benhNhan> selectAll() {
		ArrayList ketqua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM benhnhan";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maBN = rs.getString("maBN");
				String tenBN = rs.getString("tenBN");
				String gioiTinhBN = rs.getString("gioiTinhBN");
				Date ngaySinh = rs.getDate("ngaySinh");
				String doiTuong = rs.getString("doiTuong");
				String maBH = rs.getString("maBH");
				String diaChiBN = rs.getString("diaChiBN");
				String SĐTBN = rs.getString("SĐTBN");
				
				benhNhan us = new benhNhan(maBN, tenBN, gioiTinhBN, ngaySinh, doiTuong, maBH, diaChiBN, SĐTBN);
				ketqua.add(us);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		}
		return ketqua;
	}

	@Override
	public benhNhan selectById(String t) {
		benhNhan ketqua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM benhnhan WHERE maBN=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maBN = rs.getString("maBN");
				String tenBN = rs.getString("tenBN");
				String gioiTinhBN = rs.getString("gioiTinhBN");
				Date ngaySinh = rs.getDate("ngaySinh");
				String doiTuong = rs.getString("doiTuong");
				String maBH = rs.getString("maBH");
				String diaChiBN = rs.getString("diaChiBN");
				String SĐTBN = rs.getString("SĐTBN");
				
				ketqua = new benhNhan(maBN, tenBN, gioiTinhBN, ngaySinh, doiTuong, maBH, diaChiBN, SĐTBN);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		
			}
		return ketqua;
	}

	public List<benhNhan> search(String tenBenhNhan) {
	    List<benhNhan> resultList = new ArrayList<>();

	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "SELECT * FROM benhnhan WHERE tenBN LIKE ?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, "%" + tenBenhNhan + "%");

	        ResultSet resultSet = st.executeQuery();

	        while (resultSet.next()) {
	            benhNhan bn = new benhNhan();
	            bn.setMaBN(resultSet.getString("maBN"));
	            bn.setTenBN(resultSet.getString("tenBN"));
	            bn.setGioiTinhBN(resultSet.getString("gioiTinhBN"));
	            bn.setNgaySinh(resultSet.getDate("ngaySinh"));
	            bn.setDoiTuong(resultSet.getString("doiTuong"));
	            bn.setMaBH(resultSet.getString("maBH"));
	            bn.setDiaChiBN(resultSet.getString("diaChiBN"));
	            bn.setSĐTBN(resultSet.getString("SĐTBN"));
	            resultList.add(bn);
	        }
	        JDBCUtil.closeConnection(con);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}
}

