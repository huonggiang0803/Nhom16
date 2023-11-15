package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		//com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver(); // đầy đủ
		try {
			// đăng ký MySQL Driver với DriverManager
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/quanlykhambenh"; // locohost là máy chủ 3306 là cổng chay mysql trên locohost
			String username = "root";
			String password = "";
			// tạo kết nối
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c; // khi viết bắt buộc phải return 
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c!=null) {
				c.close();
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void prinInfo (Connection c) {
		if (c!= null) {
			try {
				System.out.println(c.getMetaData().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
