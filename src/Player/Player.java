 package Player;

import java.util.ArrayList;

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
   public ArrayList <Job> myJob = new ArrayList <Job> (4);
   
   public Player(String name) {
           this.name = name;
       }

   public void sayName() {
      System.out.println("이름을 "+ name + "(으)로 설정하였습니다.");
   }
   
   public void sayMyTwoCard(Job j1, Job j2) {   
      
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

   public int sayLeftCard() {
	    int count = 0;
	    for (int i = 0; i < myJob.size(); i++) {
	        if (myJob.get(i) != null) {
	            count++;
	        }
	    }
	    return count;
	}
   
   
   public void getOneCoin() {
      coin += 1;
      System.out.println("\n소득으로 코인 1개를 가져왔습니다.");
   }
   
   public void coup(Player target, int deadCardNum, ArrayList <Player> players) {
	      this.coin-=7;
	      if (target.myJob.size() == 1) {
	            System.out.print("\n"+ this.name + "님이 " + target.name + "님의 세력에 쿠데타를 일으켰습니다! \n\n"
	                        + target.name + "님, 버릴 카드 하나를 선택해주세요. \n1. " 
	                        + target.myJob.get(0).jobName + "\n번호를 입력>>");
	        } else if(target.myJob.size() == 2) {
	           System.out.print("\n"+ this.name + "님이 " + target.name + "님의 세력에 쿠데타를 일으켰습니다! \n\n"
	                      + target.name + "님, 버릴 카드 하나를 선택해주세요. \n1. "
	                          + target.myJob.get(0).jobName + " 2. " + 
	                          target.myJob.get(1).jobName + "\n번호를 입력>>");
	        }
	   }
	   
   public void coup2(Player target, int deadCardNum, ArrayList <Player> players) {
	        if(deadCardNum == 1) {
	           System.out.println("\n" + target.myJob.get(0).jobName + " 카드를 잃었습니다.");
	           target.myJob.remove(0);
	            if(target.myJob.isEmpty() == true) {
	                  System.out.println("\n"+target.name + "님의 세력이 패배하였습니다."); 
	                  players.remove(target);
	               }
	        } else if(deadCardNum == 2) {
	           System.out.println("\n" + target.myJob.get(1).jobName + " 카드를 잃었습니다.");
	            target.myJob.remove(1);
	            
	        }
	        
	    }
   
}