package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.Thuoc;
import model.phieuDonThuoc;
import view.ThongTinThuoc;

public class donThuocDao implements DAOInterface<phieuDonThuoc>{

	@Override
	public int insert(phieuDonThuoc t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO donthuocchitiet (maDonThuoc, maThuoc,tenThuoc,soLuong,maBN,tenBN,phongKham,maNV,benhMacPhai,cachDung,ngayKeDon,ĐVT,thanhTien)"+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st =  con.prepareStatement(sql);
			
			st.setString(1,t.getMaDonThuoc());
			st.setString(2, t.getMaThuoc());
			st.setString(3, t.getTenThuoc());
			st.setInt(4, t.getSoLuong());
			st.setString(5, t.getMaBN());
			st.setString(6, t.getTenBN());
			st.setString(7, t.getPhongKham());
			st.setString(8, t.getMaNV());
			st.setString(9, t.getBenhMacPhai());
			st.setString(10, t.getCachDung());
			st.setDate(11, (Date) t.getNgayKeDon());
			st.setString(12, t.getĐVT());
			st.setFloat(13,t.getThanhTien());
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
	public int update(phieuDonThuoc t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<phieuDonThuoc> selectAll() {
		ArrayList ketqua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM donthuochitiet";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maDonThuoc = rs.getString("maDonThuoc");
				String maThuoc = rs.getString("maThuoc");
				String tenThuoc = rs.getString("tenThuoc");
				Integer soLuong = rs.getInt("soLuong");
				String xuatXu = rs.getString("xuatXu");
				String maBN = rs.getString("maBN");
				String tenBN = rs.getString("tenBN");
				String phongKham = rs.getString("phongKham");
				String maNV = rs.getString("maNV");
				String benhMacPhai = rs.getString("benhMacPhai");
				String cachDung = rs.getString("cachDung");
				Date ngayKeDon = rs.getDate("ngayKeDon");
				String ĐVT = rs.getString("ĐVT");
				Float thanhTien = rs.getFloat("thanhTien");
				phieuDonThuoc t = new phieuDonThuoc(maDonThuoc, maThuoc, tenThuoc, 0, maBN, tenBN, phongKham, maNV, benhMacPhai, cachDung, ngayKeDon, ĐVT, 0);
				ketqua.add(t);		
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.getStackTrace();		}
		return ketqua;
	}

	@Override
	public phieuDonThuoc selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<phieuDonThuoc> search(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
