package system;

import java.sql.ResultSet;

public class UserLoginConfirm {
	String password;
	public UserLoginConfirm(DBConnection connection,String inp_id, UserInfo userInfo) {
		
		//왜 이건 이렇게 해야하고??
		String SQL = "select password from userInfo where id = '"+inp_id+"'";
		try {
			ResultSet rs = null;
			connection.pstmt = connection.conn.prepareStatement(SQL);
			/* connection.pstmt.setString(1, inp_id); */
			rs = connection.pstmt.executeQuery();
			while(rs.next()) {
				password = rs.getString("password");
				System.out.println(inp_id);
			}
			
			
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean userLoginCon(String inp_password) {
		if(inp_password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
