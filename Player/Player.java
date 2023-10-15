package Player;

public class Player {
	
	String name;
	
	void setName(String name) {
		this.name = name;
	}
	
	void sayName() {
		System.out.println("이름을 " + name + "(으)로 설정하였습니다.");
	}
	
	void sayJob(Player p) {
		if(p instanceof Professor P) {
			System.out.println(name+"님의 직업은 교수입니다.");
		} else {System.out.println(name+"님의 직업은 학생입니다.");
	}
}
}