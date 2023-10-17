package Player;

import Job.Ambassador;
import Job.Assassin;
import Job.Commander;
import Job.Countess;
import Job.Duke;
import Job.Job;

public class Player {
	
	String name;
	int coin;
	Job[] myJob = new Job[2];
	// 변수
	
	public Player(String name) {
		this.name = name;
	}
	// 생성자
	
	public void sayName() {
		System.out.println("이름을 "+ name + "(으)로 설정하였습니다.");
	}
	
	public void sayMyCard() {	
		if (myJob[0] instanceof Ambassador) {
			System.out.print(name + "님의 첫번째 직업 카드는 대사,");
		} else if (myJob[0] instanceof Assassin) {
			System.out.print(name + "님의 첫번째 직업카드는 암살자,");
		} else if (myJob[0] instanceof Commander) {
			System.out.print(name + "님의 첫번째 직업카드는 사령관,");
		} else if (myJob[0] instanceof Countess) {
			System.out.print(name + "님의 첫번째 직업카드는 백작부인,");
		} else if (myJob[0] instanceof Duke) {
			System.out.print(name + "님의 첫번째 직업카드는 공작,");
		};
	
		if (myJob[1] instanceof Ambassador) {
			System.out.println(" 두번째 카드는 대사입니다.");
		} else if (myJob[1] instanceof Assassin) {
			System.out.println(" 두번째 카드는 암살자 입니다.");
		} else if (myJob[1] instanceof Commander) {
			System.out.println(" 두번째 카드는 사령관 입니다.");
		} else if (myJob[1] instanceof Countess) {
			System.out.println(" 두번째 카드는 백작부인 입니다.");
		} else if (myJob[1] instanceof Duke) {
			System.out.println(" 두번째 카드는 공작 입니다.");
		}
	}
	
	public void getTwoJobs(Job j1, Job j2) {
		myJob[0] = j1;
		myJob[1] = j2;
	}
	
	void doAction() {
		
	}
	
	
	
	//메소드(능력 저지, 이름 알려주기, 본인의 턴)
}
