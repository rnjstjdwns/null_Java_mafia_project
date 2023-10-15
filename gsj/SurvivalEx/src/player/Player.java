package player;

public class Player {
	private String nickName;
	private String jobName;
	Player() {
		
	}
	Player(String jobName) {
		this.jobName = jobName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public void sayJob(Professor p) {
		System.out.println("당신의 직업은 교수");
	}
	
	public void sayJob(Student s) {
		System.out.println("당신의 직업은 학생");
	}
}
