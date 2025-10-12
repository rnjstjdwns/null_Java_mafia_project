package system;

import java.sql.*;

public class DBConnection {
	
	Connection conn;
	//PreparedStatement vs Statement
	PreparedStatement pstmt = null;
//	ResultSet srs = null;
	public DBConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/coup?serverTimezone=UTC", "root", "1234");
			System.out.println("DB 연결 완료");
			
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}


	public void connection_close() {
		try {
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
}
