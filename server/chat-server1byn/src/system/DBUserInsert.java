package system;

public class DBUserInsert {
	public DBUserInsert(DBConnection connection, String id, String password, String nickname) {
		String sql = "insert into userInfo(id,password,nickname) values(?,?,?)";
		
		try {
			connection.pstmt = connection.conn.prepareStatement(sql);
			
			connection.pstmt.setString(1, id);
			connection.pstmt.setString(2, password);
			connection.pstmt.setString(3, nickname);
			
			connection.pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		
	}
}
