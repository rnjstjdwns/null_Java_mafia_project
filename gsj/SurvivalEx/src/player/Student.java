package player;

public class Student extends Player{
	Student(String nickName) {
		super.setNickName(nickName);
	}
	void sayJob() {
		System.out.println("나는 학생");
	}
}
