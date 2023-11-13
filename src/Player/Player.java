 package Player;

import java.util.ArrayList;
import java.util.Scanner;

import Job.Ambassador;
import Job.Assassin;
import Job.Commander;
import Job.Countess;
import Job.Duke;
import Job.Job;

public class Player {
	
	public static ArrayList <Job> royalCourtDeck = new ArrayList <Job> (7);
	
	public String name;
	public int coin = 2;
	public Job[] myJob = new Job[4];
	
	public Player(String name) {
	        this.name = name;
	    }

	public void sayName() {
		System.out.println("이름을 "+ name + "(으)로 설정하였습니다.");
	}
	
	public void print(String s) {
		System.out.println(s);
	}
	public void sayMyTwoCard(Job j1, Job j2) {	
		j1 = myJob[0];
		j2 = myJob[1];
		
		if (j1 instanceof Ambassador) {
			System.out.print(name + "님의 첫번째 카드는 대사,");
		} else if (j1 instanceof Assassin) {
			System.out.print(name + "님의 첫번째 카드는 암살자,");
		} else if (j1 instanceof Commander) {
			System.out.print(name + "님의 첫번째 카드는 사령관,");
		} else if (j1 instanceof Countess) {
			System.out.print(name + "님의 첫번째 카드는 백작부인,");
		} else if (j1 instanceof Duke) {
			System.out.print(name + "님의 첫번째 카드는 공작,");
		};
	
		if (j2 instanceof Ambassador) {
			System.out.println(" 두번째 카드는 대사입니다.");
		} else if (j2 instanceof Assassin) {
			System.out.println(" 두번째 카드는 암살자 입니다.");
		} else if (j2 instanceof Commander) {
			System.out.println(" 두번째 카드는 사령관 입니다.");
		} else if (j2 instanceof Countess) {
			System.out.println(" 두번째 카드는 백작부인 입니다.");
		} else if (j2 instanceof Duke) {
			System.out.println(" 두번째 카드는 공작 입니다.");
		};
	}
	
	public void sayMyFourCard(Job j1, Job j2, Job j3, Job j4) {
		j1 = myJob[0];
		j2 = myJob[1];
		j3 = myJob[2];
		j4 = myJob[3];
		
		if (j1 instanceof Ambassador) {
			System.out.print(name + "님의 첫번째 카드는 대사,");
		} else if (j1 instanceof Assassin) {
			System.out.print(name + "님의 첫번째 카드는 암살자,");
		} else if (j1 instanceof Commander) {
			System.out.print(name + "님의 첫번째 카드는 사령관,");
		} else if (j1 instanceof Countess) {
			System.out.print(name + "님의 첫번째 카드는 백작부인,");
		} else if (j1 instanceof Duke) {
			System.out.print(name + "님의 첫번째 카드는 공작,");
		};
		
		if (j2 instanceof Ambassador) {
			System.out.println(" 두번째 카드는 대사,");
		} else if (j2 instanceof Assassin) {
			System.out.println(" 두번째 카드는 암살자,");
		} else if (j2 instanceof Commander) {
			System.out.println(" 두번째 카드는 사령관,");
		} else if (j2 instanceof Countess) {
			System.out.println(" 두번째 카드는 백작부인,");
		} else if (j2 instanceof Duke) {
			System.out.println(" 두번째 카드는 공작,");
		};
		
		if (j3 instanceof Ambassador) {
			System.out.println(" 세번째 카드는 대사,");
		} else if (j3 instanceof Assassin) {
			System.out.println(" 세번째 카드는 암살자,");
		} else if (j3 instanceof Commander) {
			System.out.println(" 세번째 카드는 사령관,");
		} else if (j3 instanceof Countess) {
			System.out.println(" 세번째 카드는 백작부인,");
		} else if (j3 instanceof Duke) {
			System.out.println(" 세번째 카드는 공작,");
		};
		
		if (j4 instanceof Ambassador) {
			System.out.println(" 네번째 카드는 대사입니다.");
		} else if (j4 instanceof Assassin) {
			System.out.println(" 네번째 카드는 암살자입니다.");
		} else if (j4 instanceof Commander) {
			System.out.println(" 네번째 카드는 사령관입니다.");
		} else if (j4 instanceof Countess) {
			System.out.println(" 네번째 카드는 백작부인입니다.");
		} else if (j4 instanceof Duke) {
			System.out.println(" 네번째 카드는 공작입니다.");
		};
	}
	
	public void selectTwoCard(int a, int b) {
		
		
	}
	
	public void getTwoJobs(Job j1, Job j2) {
		myJob[0] = j1;
		myJob[1] = j2;
	}
	

	// 여기부터 직업 능력 사용, 저지와 도전
	// 0. 저지와 도전
	public void block() {
		
	}
	
	public void challenge() {
		
	}
	
	// 1. 플레이어가 자신의 턴이 되자마자 바로 실행할 수 있는 행동
	public void getOneCoin() {
		coin += 1;
		this.print("소득으로 코인 1개를 가져왔습니다. " + name + "님의 현재코인 : "+ coin);
	}
	
	public void outsideAid() {
		coin += 2;
		this.print("외부원조로 코인 2개를 가져왔습니다." + name + "님의 현재코인 : " + coin);
		
	}
	
	public void coup() {
		
	}
	
	public void dukeGetThreeCoin() {
		coin += 3;
		System.out.println("공작의 세금 징수로 코인을 세개 가져왔습니다." + name + "님의 현재코인 : " + coin);
		
		// 다른 플레이어가 도전할 수 있게 구현
	}
	
	public void commanderStealTwoCoin(Player p) {
        if(coin >= 2) {
            this.coin += 2;
            p.coin -= 2;
        }
        else if(coin == 1) {
            this.coin += 1;
            p.coin -= 1;
        }
        else if(coin == 0) {
            System.out.println("강탈해올 상대의 코인이 없습니다.");
            //다시 턴 사용할 수 있게 구현
        }
    }
	
	public void ambassdorDoMulligan() {
		myJob[2] = royalCourtDeck.get(0);
		myJob[3] = royalCourtDeck.get(0);
		
		System.out.println("대사의 교환으로 두개의 카드를 궁정덱에서 가져왔습니다."
				+ "네 장의 카드 중 선택할 두 장의 카드를 골라주세요.");
		
		sayMyFourCard(myJob[0], myJob[1], myJob[2], myJob[3]);
		
		
		}
	
	public void assassinDoAssassination(Player p) {
        Scanner select = new Scanner(System.in); 
        this.coin -= 3;

        if(p.myJob.length == 2) {
             System.out.println("암살당할 카드를 선택하세요 (1~2): ");
             int selectNum = select.nextInt();

             if(selectNum == 1) {
                 p.myJob[0] = null;
             }

             else if(selectNum == 2) {
                 p.myJob[1] = null;
             }
        }

        else if(p.myJob.length == 1) {
            if(p.myJob[0] == null) {
                p.myJob[1] = null;
            }

            else if(p.myJob[1] == null) {
                p.myJob[0] = null;
            }
        }
        select.close();
     }
	
	// 1번 끝 
	
	// 2. 저지하는 행동 (일반)
	public void dukeBlockOutsideAid() {
		
	}
	
	public void commanderBlockCommanderStealTwoCoin() {
		
	}
	
	public void ambassadorBlockCommanderStealTwoCoin() {
		
	}
	
	// 2번 끝
	
	// 3. 저지하는 행동 (특수)
	public void countessBlockAssassinDoAssassination() {
		
	}
	
	// 3번 끝
	
	// 4. 도전하는 행동
	public void challengeDukeExistence() {
		
	}
	
	public void challengeAmbassadorExistence() {
		
	}
	
	public void challengeCommanderExistence() {
		
	}
	
	public void challengeDukeBlockOutsideAid() {
		
	}
	
	public void challengeCommanderBlockCommanderStealTwoCoin() {
		
	}
	
	public void challengeAmbassadorBlockCommanderStealTwoCoin() {
		
	}
	
	// 4번 끝
	
	// 5. 도전하는 행동 (특수)
	public void challengeAssassinExistence() {
		
	}
	
	public void challengeCountessExistence() {
		
	}
	
	public void challengeCountessBlockAssassinDoAssassination() {
		
	}
	
	// 5번 끝

}
