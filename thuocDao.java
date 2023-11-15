package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.Thuoc;

public class thuocDao implements DAOInterface<Thuoc>{

	@Override
	public int insert(Thuoc t) {
		// TODO Auto-generated method stub
				int ketqua = 0;
				try {
					Connection con = JDBCUtil.getConnection();
					String sql = "INSERT INTO thuoc (maThuoc, tenThuoc, giaThuoc, xuatXu)"+
							"VALUES (?,?,?,?)";
					PreparedStatement st =  con.prepareStatement(sql);
					
					st.setString(1,t.getMaThuoc());
					st.setString(2, t.getTenThuoc());
					st.setFloat(3, t.getGiaThuoc());
					st.setString(4, t.getXuatXu());

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
	public int update(Thuoc t) {
	    int ketqua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE thuoc " +
	                     "SET tenThuoc=?, giaThuoc=?, xuatXu=? " +
	                     "WHERE maThuoc=?";

	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, t.getTenThuoc());
	        st.setFloat(2, t.getGiaThuoc());
	        st.setString(3, t.getXuatXu());
	        st.setString(4, t.getMaThuoc());

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
			
			String sql = "DELETE from thuoc "+
					 " WHERE maThuoc=?";
			
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
	public ArrayList<Thuoc> selectAll() {
		ArrayList ketqua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM thuoc";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maThuoc = rs.getString("maThuoc");
				String tenThuoc = rs.getString("tenThuoc");
				Float giaThuoc = rs.getFloat("giaThuoc");
				String xuatXu = rs.getString("xuatXu");
				Thuoc t = new Thuoc(maThuoc, tenThuoc, giaThuoc,xuatXu);
				ketqua.add(t	);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		}
		return ketqua;
	}

	@Override
	public Thuoc selectById(String t) {
		Thuoc ketqua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM thuoc WHERE maThuoc=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maThuoc = rs.getString("maThuoc");
				String tenThuoc = rs.getString("tenThuoc");
				Float giaThuoc = rs.getFloat("giaThuoc");
				String xuatXu = rs.getString("xuatXu");
				ketqua = new Thuoc(maThuoc, tenThuoc, giaThuoc, xuatXu);	
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		
			}
		return ketqua;
	}

	@Override
	public List<Thuoc> search(String t) {
		List<Thuoc> resultList = new ArrayList<>();

	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "SELECT * FROM thuoc WHERE tenThuoc LIKE ?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, "%" + t + "%"); 

	        ResultSet resultSet = st.executeQuery();

	        while (resultSet.next()) {
	            Thuoc bn = new Thuoc();
	            bn.setMaThuoc(resultSet.getString("maThuoc"));
	            bn.setTenThuoc(resultSet.getString("tenThuoc"));
	            bn.setGiaThuoc(resultSet.getFloat("GiaThuoc"));
	            resultList.add(bn);
	        }
	        JDBCUtil.closeConnection(con);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}

}
