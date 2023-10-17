package JobAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Job.Ambassador;
import Job.Assassin;
import Job.Commander;
import Job.Countess;
import Job.Duke;
import Job.Job;
import Player.Player;

public class JobAssignmentManeger {

	JobAssignmentManeger() {
		Scanner s = new Scanner(System.in);
		
		Player p1 = new Player(s.nextLine());
		Player p2 = new Player(s.nextLine());
		Player p3 = new Player(s.nextLine());
		Player p4 = new Player(s.nextLine());
		p1.sayName();
		p2.sayName();
		p3.sayName();
		p4.sayName();
		
		s.close();
		
		ArrayList <Job> assignJobRandomBox = new ArrayList <Job> (15); 
		Ambassador Ambassador1 = new Ambassador();
		Ambassador Ambassador2 = new Ambassador();
		Ambassador Ambassador3 = new Ambassador();
		Assassin assassin1 = new Assassin();
		Assassin assassin2 = new Assassin();
		Assassin assassin3 = new Assassin();
	    Commander commander1 = new Commander();
	    Commander commander2 = new Commander();
		Commander commander3 = new Commander();
		Countess countess1 = new Countess();
		Countess countess2 = new Countess();
		Countess countess3 = new Countess();
		Duke duke1 = new Duke();
		Duke duke2 = new Duke();
		Duke duke3 = new Duke();
		
		assignJobRandomBox.add(Ambassador1);
		assignJobRandomBox.add(Ambassador2);
		assignJobRandomBox.add(Ambassador3);
		assignJobRandomBox.add(assassin1);
		assignJobRandomBox.add(assassin2);
		assignJobRandomBox.add(assassin3);
		assignJobRandomBox.add(commander1);
		assignJobRandomBox.add(commander2);
		assignJobRandomBox.add(commander3);
		assignJobRandomBox.add(countess1);
		assignJobRandomBox.add(countess2);
		assignJobRandomBox.add(countess3);
		assignJobRandomBox.add(duke1);
		assignJobRandomBox.add(duke2);
		assignJobRandomBox.add(duke3);

		Collections.shuffle(assignJobRandomBox);
		
		p1.getTwoJobs(assignJobRandomBox.get(14),assignJobRandomBox.get(13));
		p2.getTwoJobs(assignJobRandomBox.get(12),assignJobRandomBox.get(11));
		p3.getTwoJobs(assignJobRandomBox.get(10),assignJobRandomBox.get(9));
		p4.getTwoJobs(assignJobRandomBox.get(8),assignJobRandomBox.get(7));
		
		for(int i = 14; i >= 7; i--) {
		assignJobRandomBox.remove(i);
		}
		
		p1.sayMyCard();
		p2.sayMyCard();
		p3.sayMyCard();
		p4.sayMyCard();
           
		System.out.println("궁정 덱에 있는 카드의 수는 " + assignJobRandomBox.size()+ "개 입니다.");
		
	}
	
	public static void main(String[] args) {
		new JobAssignmentManeger();
	}
}
