package SetPlayer;

import java.util.*;

import Job.*;

public class Player extends JobAssignmentManeger{
	static ArrayList <Job> royalCourtdeck = new ArrayList <Job> (15);
	String name;
	int coin=0;
	public Job [] myJob = new Job[2];
	protected Player(){
		
	}
	
	public void getJob(Job job1, Job job2){
		myJob[0] = job1;
		myJob[1] = job2;
	}
	
	public void sayJob() {
		if(myJob[0] instanceof Duke) {
			System.out.println(this.name + "의 직업1은 공작입니다.");
		}
		else if(myJob[0] instanceof Assassin) {
			System.out.println(this.name + "의 직업1은 암살자입니다.");
		}
		else if(myJob[0] instanceof Commander) {
			System.out.println(this.name + "의 직업1은 사령관입니다.");
		}
		else if(myJob[0] instanceof Countess) {
			System.out.println(this.name + "의 직업1은 공작부인입니다.");
		}
		else if(myJob[0] instanceof Ambassador) {
			System.out.println(this.name + "의 직업1은 대사입니다.");
		}
		
		if(myJob[1] instanceof Duke) {
			System.out.println(this.name + "의 직업2는 공작입니다.");
		}
		else if(myJob[1] instanceof Assassin) {
			System.out.println(this.name + "의 직업2는 암살자입니다.");
		}
		else if(myJob[1] instanceof Commander) {
			System.out.println(this.name + "의 직업2는 사령관입니다.");
		}
		else if(myJob[1] instanceof Countess) {
			System.out.println(this.name + "의 직업2는 공작부인입니다.");
		}
		else if(myJob[1] instanceof Ambassador) {
			System.out.println(this.name + "의 직업2는 대사입니다.");
		}
	}

	public void setName(String name) {
		this.name=name;
	}
	
//	여기부터 직업 능력 사용, 저지와 도전
//	0. 저지와 도전
	public void block() {
		
	}
	
	public void challenge() {
		
	}
	
//	1. 플레이어가 자신의 턴이 되자마자 바로 실행할 수 있는 행동
	 public void getOneCoin() {
	      coin += 1;
	      System.out.println("소득으로 코인 한개를 가져왔습니다. " + name + "님의 현재코인 : "+ coin);
	   }
	   
	   public void outsideAid() {
	      
	   }
	   
	   public void dukeGetThreeCoin () {
	      coin += 3;
	      System.out.println("공작의 세금 징수로 코인을 세개 가져왔습니다." + name + "님의 현재코인 : " + coin);
	   
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
	        }
	    }
	   
	   public void ambassdorDoMulligan () {
	   
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
	   
//	    1번 끝 
	   
//	    2. 저지하는 행동 (일반)
	   public void dukeBlockOutsideAid() {
	      
	   }
	   
	   public void commanderBlockCommanderStealTwoCoin() {
	      
	   }
	   
	   public void ambassadorBlockCommanderStealTwoCoin() {
	      
	   }
	   
//	    2번 끝
	   
//	    3. 저지하는 행동 (특수)
	   public void countessBlockAssassinDoAssassination() {
	      
	   }
	   
//	    3번 끝
	   
//	    4. 도전하는 행동
	   public void challengeDukeExistence() {
	      
	   }
	   
	   public void challengeAmbassadorExistence() {
	      
	   }
	   
	   public void challengeCommanderExistence () {
	      
	   }
	   
	   public void challengeDukeBlockOutsideAid() {
	      
	   }
	   
	   public void challengeCommanderBlockCommanderStealTwoCoin() {
	      
	   }
	   
	   public void challengeAmbassadorBlockCommanderStealTwoCoin() {
	      
	   }
	   
//	    4번 끝
	   
//	    5. 도전하는 행동 (특수)
	   public void challengeAssassinExistence() {
	      
	   }
	   
	   public void challengeCountessExistence() {
	      
	   }
	   
	   public void challengeCountessBlockAssassinDoAssassination() {
	      
	   }
	   
//	    5번 끝
}