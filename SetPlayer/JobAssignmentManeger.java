package SetPlayer;
import Job.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Job.Job;
public class JobAssignmentManeger {
	   
	   public JobAssignmentManeger() {
		   ArrayList <Job> royalCourtdeck = new ArrayList <Job> (15);
		   Duke duke1 = new Duke();
		   Duke duke2 = new Duke();
		   Duke duke3 = new Duke();
		   Assassin assassin1 = new Assassin();
		   Assassin assassin2 = new Assassin();
		   Assassin assassin3 = new Assassin();
		   Countess countess1 = new Countess();
		   Countess countess2 = new Countess();
		   Countess countess3 = new Countess();
		   Ambassador ambassador1 = new Ambassador();
		   Ambassador ambassador2 = new Ambassador();
		   Ambassador ambassador3 = new Ambassador();
		   Commander commander1 = new Commander();
		   Commander commander2 = new Commander();
		   Commander commander3 = new Commander();
		   
		   royalCourtdeck.add(duke1);
		   royalCourtdeck.add(duke2);
		   royalCourtdeck.add(duke3);
		   royalCourtdeck.add(assassin1);
		   royalCourtdeck.add(assassin2);
		   royalCourtdeck.add(assassin3);
		   royalCourtdeck.add(countess1);
		   royalCourtdeck.add(countess2);
		   royalCourtdeck.add(countess3);
		   royalCourtdeck.add(ambassador1);
		   royalCourtdeck.add(ambassador2);
		   royalCourtdeck.add(ambassador3);
		   royalCourtdeck.add(commander1);
		   royalCourtdeck.add(commander2);
		   royalCourtdeck.add(commander3);		   

		   Collections.shuffle(royalCourtdeck);
		   
		   Player p1 = new Player();
		   Player p2 = new Player();
		   Player p3 = new Player();
		   Player p4 = new Player();
		   
		  Scanner s = new Scanner(System.in);
		  p1.setName(s.nextLine());
		  p2.setName(s.nextLine());
		  p3.setName(s.nextLine());
		  p4.setName(s.nextLine());
		  s.close();
		  
		  p1.getJob(royalCourtdeck.get(13),royalCourtdeck.get(14));
		  p2.getJob(royalCourtdeck.get(11),royalCourtdeck.get(12));
		  p3.getJob(royalCourtdeck.get(9),royalCourtdeck.get(10));
		  p4.getJob(royalCourtdeck.get(7),royalCourtdeck.get(8));
		  
		  for(int i=14; i >=7; i--) {
			  royalCourtdeck.remove(i);
		  }
		  
		  p1.sayJob();
		  p2.sayJob();
		  p3.sayJob();
		  p4.sayJob();
	      
		  System.out.println("궁정에 있는 카드 수는 " + royalCourtdeck.size() + "개 입니다.");
	      

	   }
	   
	   public static void main(String[] args) {
		
		   new JobAssignmentManeger();
	}
}