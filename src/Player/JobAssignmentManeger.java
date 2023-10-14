package Player;

import java.util.ArrayList;
import java.util.Collections;

public class JobAssignmentManeger {
	
	public JobAssignmentManeger() {
		
    ArrayList <Player> players = new ArrayList<>(4);
    
    Professor p1 = new Professor();
    players.add(p1);
    Student p2 = new Student();
    players.add(p2);
    Student p3 = new Student();
    players.add(p3);
    Student p4 = new Student();
    players.add(p4);
    
	Collections.shuffle(players); 		
	
	Player player1 = players.get(0);
	Player player2 = players.get(1);
	Player player3 = players.get(2);
	Player player4 = players.get(3);
	
	player1.sayJob();
	player2.sayJob();
	player3.sayJob();
	player4.sayJob();
	}
}
