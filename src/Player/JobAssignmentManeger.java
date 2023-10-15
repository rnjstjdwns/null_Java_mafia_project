package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class JobAssignmentManeger {
	   
	   public JobAssignmentManeger() {

	      Player p1 = new Professor();
	      Player p2 = new Student();
	      Player p3 = new Student();
	      Player p4 = new Student();

	      Scanner s = new Scanner(System.in);
	      p1.setName(s.nextLine());
	      p2.setName(s.nextLine());
	      p3.setName(s.nextLine());
	      p4.setName(s.nextLine());
	      s.close();

	      ArrayList <Player> players = new ArrayList <Player> (4);
	      players.add(p1);
	      players.add(p2);
	      players.add(p3);
	      players.add(p4);
	      
	      // Collections.shuffle(players);

	      Professor player1 = (Professor)players.get(0);
	      Student player2   = (Student)players.get(1);
	      Student player3   = (Student)players.get(2);
	      Student player4   = (Student)players.get(3);

	      player1.sayName();
	      player1.sayJob(player1);
	      player2.sayName();
	      player2.sayJob(player2);
	      player3.sayName();
	      player3.sayJob(player3);
	      player4.sayName();
	      player4.sayJob(player4);

	   }
	   
	   public static void main(String[] args) {
		
		   new JobAssignmentManeger();
	}
	}	