package SetPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class JobAssignmentManeger {
	   
	   public JobAssignmentManeger() {
		   ArrayList <Integer> players = new ArrayList <Integer> (4);
		   players.add(0);
		   players.add(1);
		   players.add(1);
		   players.add(1);
		   
		   
		   Collections.shuffle(players);
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
		  
		  p1.role= players.get(0);
		  p2.role= players.get(1);
		  p3.role= players.get(2);
		  p4.role= players.get(3);
	      
//	       int role1 = players.get(0);
//	       int role2 = players.get(1);
//	       int role3 = players.get(2);
//	       int role4 = players.get(3);
	       
	       p1.getJob(p1.role);
	       p2.getJob(p2.role);
	       p3.getJob(p3.role);
	       p4.getJob(p4.role);
	       
	       
	      

	   }
	   
	   public static void main(String[] args) {
		
		   new JobAssignmentManeger();
	}
	}