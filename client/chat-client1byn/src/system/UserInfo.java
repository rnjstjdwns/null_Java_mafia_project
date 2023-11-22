package system;

public class UserInfo {
	private String id;
	private String password;
	private String nickname;
	private String profileAddress;
	private int winNum;
	private int loseNum;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String id, String password, String nickname, String profileAddress, int winNum, int loseNum) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.profileAddress = profileAddress;
		this.winNum = winNum;
		this.loseNum = loseNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileAddress() {
		return profileAddress;
	}
	public void setProfileAddress(String profileAddress) {
		this.profileAddress = profileAddress;
	}
	public int getWinNum() {
		return winNum;
	}
	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
	public int getLoseNum() {
		return loseNum;
	}
	public void setLoseNum(int loseNum) {
		this.loseNum = loseNum;
	}
}
