package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maneger {
	
	Maneger () {
		
		Professor p = new Professor();
		Student s1  = new Student();
		Student s2  = new Student();
		Student s3  = new Student();
		
		ArrayList <Player> Players = new ArrayList <Player> (4);
		Players.add(p);
		Players.add(s1);
		Players.add(s2);
		Players.add(s3);
		Collections.shuffle(Players);
		
		
		Scanner s = new Scanner(System.in);
		Players.get(0).setName(s.nextLine());
		Players.get(0).sayName();
		Players.get(0).sayJob(Players.get(0));
		
		Players.get(1).setName(s.nextLine());
		Players.get(1).sayName();
		Players.get(1).sayJob(Players.get(1));
		
		Players.get(2).setName(s.nextLine());
		Players.get(2).sayName();
		Players.get(2).sayJob(Players.get(2));
		
		Players.get(3).setName(s.nextLine());
		Players.get(3).sayName();
		Players.get(3).sayJob(Players.get(3));
		
	}
	
	public static void main(String[] args) {
		new Maneger();
	}
}
	
	
