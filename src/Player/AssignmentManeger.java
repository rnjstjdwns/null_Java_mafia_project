package Player;

import java.util.ArrayList;
import java.util.Collections;

public class AssignmentManeger {
	
	public AssignmentManeger() {
	
	Player p1 = new Player();
	Player p2 = new Player();
	Player p3 = new Player();
	Player p4 = new Player();
	
	ArrayList <Integer> assignmentNumber = new ArrayList <Integer> (4);
	assignmentNumber.add(0);
	assignmentNumber.add(1);
	assignmentNumber.add(2);
	assignmentNumber.add(3);
	Collections.shuffle(assignmentNumber);
	
	p1.getJob(assignmentNumber.get(0));
	p2.getJob(assignmentNumber.get(1));
	p3.getJob(assignmentNumber.get(2));
	p4.getJob(assignmentNumber.get(3));

	}
	
	public static void main(String[] args) {
		new AssignmentManeger();
	}

}
