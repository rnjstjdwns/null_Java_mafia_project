package Player;

import java.util.ArrayList;
import java.util.Scanner;

import Item.Item;

public class Player {
	
	static Scanner s = new Scanner(System.in);
	
	Player p;
	ArrayList <Item> bag = new ArrayList <Item> (6);
	String name;
	
	public Player() {
		setName(s.next());
		sayName();
	}
	
	void setName(String name) {
		this.name = name;
		
	}
	
	void sayName() {
		System.out.println("이름을 "+ name + "으로 설정하였습니다.");
	}
	
	void sayJob() {
		if (this instanceof Professor) {
			p = this;
		    System.out.println(name + "님의 직업은 교수입니다.");
		} else if (this instanceof Student) {
			p = this;
		    System.out.println(name + "님의 직업은 학생입니다.");
		}
	}
}