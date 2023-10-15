package Player;

import java.util.ArrayList;

import Item.Item;

public class Player {
	
	String name;
	ArrayList <Item> bag = new ArrayList <> (6);
	
	Player() {
		
	}
   
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayName() {
		System.out.println("이름을 " + this.name + "(으)로 설정하였습니다.");
	}

	public void sayJob(Professor p) {
		System.out.println("당신의 직업은 교수 입니다.");
	}
	
	public void sayJob(Student s) {
		System.out.println("당신의 직업은 학생입니다.");
	}
}