 package Player;

import java.util.ArrayList;

import GameManeger.GameManeger;
import Job.Ambassador;
import Job.Assassin;
import Job.Commander;
import Job.Countess;
import Job.Duke;
import Job.Job;
import Scan.Scan;

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
      j1 = myJob.get(0);
      j2 = myJob.get(1);
      
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
      j1 = myJob.get(0);
      j2 = myJob.get(1);
      j3 = myJob.get(2);
      j4 = myJob.get(3);
      
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
   
   
   public int sayLeftCard() {
       int count = 0;
       for (int i = 0; i < myJob.size(); i++) {
           if (myJob.get(i) != null) {
               count++;
           }
       }
       return count;
   }
   
   public void blockOutsideAid(Player p) {
      System.out.println("\n"+this.name + "님이 " + p.name + "님의 외부원조를 저지하였습니다.");
   }
   
   
   public void getOneCoin() {
      coin += 1;
      System.out.println("\n소득으로 코인 1개를 가져왔습니다.");
   }
   
   public void outsideAid() {
      coin += 2;
      System.out.println("\n외부원조로 코인 2개를 가져왔습니다.");
      
   }
   
   public void coup(Player target, int deadCardNum, ArrayList <Player> players ) {
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

        deadCardNum = Scan.getIntInput();
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
   
   public void dukeGetThreeCoin() {
      coin += 3;
      System.out.println("\n공작의 세금 징수로 코인을 3개 가져왔습니다.\n" + name + "님의 현재코인: " + coin);
      
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
   
}