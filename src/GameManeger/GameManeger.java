package GameManeger;

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

public class GameManeger {

	public GameManeger() {
		Scanner s = new Scanner(System.in);
		
		Player p1 = new Player(s.nextLine());
		p1.sayName();
		Player p2 = new Player(s.nextLine());
		p2.sayName();
		Player p3 = new Player(s.nextLine());
		p3.sayName();
		Player p4 = new Player(s.nextLine());
		p4.sayName();
		
		s.close();
		
		ArrayList <Job> jobAssignRandomBox = new ArrayList <Job> (15); 
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
		
		jobAssignRandomBox.add(Ambassador1);
		jobAssignRandomBox.add(Ambassador2);
		jobAssignRandomBox.add(Ambassador3);
		jobAssignRandomBox.add(assassin1);
		jobAssignRandomBox.add(assassin2);
		jobAssignRandomBox.add(assassin3);
		jobAssignRandomBox.add(commander1);
		jobAssignRandomBox.add(commander2);
		jobAssignRandomBox.add(commander3);
		jobAssignRandomBox.add(countess1);
		jobAssignRandomBox.add(countess2);
		jobAssignRandomBox.add(countess3);
		jobAssignRandomBox.add(duke1);
		jobAssignRandomBox.add(duke2);
		jobAssignRandomBox.add(duke3);

		Collections.shuffle(jobAssignRandomBox);
		Collections.shuffle(jobAssignRandomBox);
		Collections.shuffle(jobAssignRandomBox);
		
		p1.getTwoJobs(jobAssignRandomBox.get(14),jobAssignRandomBox.get(13));
		p2.getTwoJobs(jobAssignRandomBox.get(12),jobAssignRandomBox.get(11));
		p3.getTwoJobs(jobAssignRandomBox.get(10),jobAssignRandomBox.get(9));
		p4.getTwoJobs(jobAssignRandomBox.get(8),jobAssignRandomBox.get(7));
		
		System.out.println("\n====================\n게임을 시작합니다\n====================\n");
		
		p1.sayMyTwoCard(jobAssignRandomBox.get(14),jobAssignRandomBox.get(13));
		p2.sayMyTwoCard(jobAssignRandomBox.get(12),jobAssignRandomBox.get(11));
		p3.sayMyTwoCard(jobAssignRandomBox.get(10),jobAssignRandomBox.get(9));
		p4.sayMyTwoCard(jobAssignRandomBox.get(8),jobAssignRandomBox.get(7));
		
		for(int i = 14; i >= 7; i--) {
			jobAssignRandomBox.remove(i);
		}
		
		for(int i = 0; i <= 6; i++) {
			Player.royalCourtDeck.add(jobAssignRandomBox.get(i));
		}
		// 게임 세팅 끝
		
			
		p1.playerTurn();
		
		
			
	}
	


	public void isGameEnd(Player p1, Player p2, Player p3, Player p4) {
		if(p2.myJob == null && p3.myJob == null && p4.myJob == null) {
			System.out.println(p1.name + "님이 마지막까지 살아남았습니다." + p1.name + "님의 승리");
		} else if(p1.myJob == null && p3.myJob == null && p4.myJob == null) {
			System.out.println(p2.name + "님이 마지막까지 살아남았습니다." + p2.name + "님의 승리");
		} else if(p1.myJob == null && p2.myJob == null && p4.myJob == null) {
			System.out.println(p3.name + "님이 마지막까지 살아남았습니다." + p3.name + "님의 승리");
		} else if(p1.myJob == null && p2.myJob == null && p3.myJob == null) {
			System.out.println(p4.name + "님이 마지막까지 살아남았습니다." + p4.name + "님의 승리");
		} 
	}
}
