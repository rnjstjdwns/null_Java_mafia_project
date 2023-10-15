package Player;

public class Player {
	
	String name;
	
	Player() {
		
	}
	
	

	public void setName() {
		
	}
	
	public void sayName() {
		
	}
	
	public void getJob(int i) {
		if(i == 0) {
			Professor p = (Professor) this;
		} else {
			 Student s = (Student) this;
		}
	}
	
	public void sayJob(Professor p) {
		System.out.println("당신의 직업은 교수입니다.");
	}
	
	public void sayJob(Student s) {
		System.out.println("당신의 직업은 학생입니다.");
	}
 }
