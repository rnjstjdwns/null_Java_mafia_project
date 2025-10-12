package system;

import java.sql.ResultSet;
//전체 정보 조회할 거 1
//개인 정보 조회할 거 2

//일단 개인 정보 조회하는 걸로 하고 전체 정보 조회하는 건 따로 또 만들어?
//차피 유저 리스트는 또 다른 걸로 만들 든가, 출력을 하든가 해야함
//전체 정보 가지고 뭘 하면 안되는 깐 UserInfo정보 안에는 자기 자신 정보가 들어있는 걸로 해야함
public class DBLinkUserInfo {
	public DBLinkUserInfo(DBConnection connection,String id, UserInfo userInfo) {
		
		//왜 이건 이렇게 해야되는 거임?
		String SQL = "select * from userInfo where id = '"+id+"'";
		try {
			ResultSet rs = null;
			
			connection.pstmt = connection.conn.prepareStatement(SQL);
			rs = connection.pstmt.executeQuery(SQL);
			
			while(rs.next()) {
				userInfo.setId(rs.getString("id"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setNickname(rs.getString("nickname"));
				userInfo.setProfileAddress(rs.getString("profileAddress"));
				userInfo.setWinNum(rs.getInt("winNum"));
				userInfo.setLoseNum(rs.getInt("loseNum"));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	UserInfo returnUserInfo() {
		return null;
		
	}
}
