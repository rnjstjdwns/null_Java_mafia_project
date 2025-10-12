package GameManeger;

import java.util.ArrayList;
import java.util.Collections;

import Job.Ambassador;
import Job.Assassin;
import Job.Commander;
import Job.Countess;
import Job.Duke;
import Job.Job;
import Player.Player;
import Scan.Scan;

public class GameManeger {
   
   boolean isGameEnd = true;
   int count =0;

   public GameManeger() {
      
      Scan s = new Scan();
      
      Player p1 = new Player(s.getStringInput());
      p1.sayName();
      Player p2 = new Player(s.getStringInput());
      p2.sayName();
      Player p3 = new Player(s.getStringInput());
      p3.sayName();
      Player p4 = new Player(s.getStringInput());
      p4.sayName();
      
      ArrayList <Player> players = new ArrayList <Player> (4);
      players.add(p1);
      players.add(p2);
      players.add(p3);
      players.add(p4);
      
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
      
      p1.myJob.add(jobAssignRandomBox.get(14));
      p1.myJob.add(jobAssignRandomBox.get(13));
      p2.myJob.add(jobAssignRandomBox.get(12));
      p2.myJob.add(jobAssignRandomBox.get(11));
      p3.myJob.add(jobAssignRandomBox.get(10));
      p3.myJob.add(jobAssignRandomBox.get(9));
      p4.myJob.add(jobAssignRandomBox.get(8));
      p4.myJob.add(jobAssignRandomBox.get(7));
      
      System.out.print("\r\n"
              + "  ______                                \r\n"
              + " /      \\                               \r\n"
              + "|  $$$$$$\\  ______   __    __   ______  \r\n"
              + "| $$   \\$$ /      \\ |  \\  |  \\ /      \\ \r\n"
              + "| $$      |  $$$$$$\\| $$  | $$|  $$$$$$\\\r\n"
              + "| $$   __ | $$  | $$| $$  | $$| $$  | $$\r\n"
              + "| $$__/  \\| $$__/ $$| $$__/ $$| $$__/ $$\r\n"
              + " \\$$    $$ \\$$    $$ \\$$    $$| $$    $$\r\n"
              + "  \\$$$$$$   \\$$$$$$   \\$$$$$$ | $$$$$$$ \r\n"
              + "                              | $$      \r\n"
              + "                              | $$      \r\n"
              + "                               \\$$      \r\n"
              + "\n");
      
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
      
      while(isGameEnd) {
         for(int i = 0; i < players.size(); i++) {
         
            System.out.println("\n\n==========" + players.get(i).name + "님의 차례==========");
            System.out.println("내 코인: " + players.get(i).coin + "$, 내 남은 카드: "+ players.get(i).sayLeftCard() + "장");
            for(int j = 0; j < players.size(); j++) {
               if(j != i) {
               System.out.println(players.get(j).name + "님의 코인: " + players.get(j).coin + "$, " 
               + players.get(j).name + "님의 남은 카드: " + players.get(j).sayLeftCard() + "장");
               }
            }
            System.out.println("\n실행할 행동을 선택하세요!"); 
            System.out.print("1.소득\n2.외부원조\n3.쿠데타\n4.직업 능력 사용\n번호를 입력 >>");
            
            int actionNumber1 = s.getIntInput();
            if (actionNumber1 == 1) {
               players.get(i).getOneCoin();
            }else if(actionNumber1 == 2) {
               for(int j = 0; j <= players.size(); j++ ) {
                  if(j != i) {
                      System.out.print("\n"+players.get(j).name+"님! " + players.get(i).name 
                           + "님의 외부원조를 공작의 능력으로 저지 하시겠습니까?\n1.예\n2.아니요\n번호를 입력 >>");
                     int selectNum = s.getIntInput();
                     if(selectNum == 1) {
                        System.out.print("\n" + players.get(i).name + "님! "+players.get(j).name 
                              + "님이 외부원조를 저지하려합니다. " + players.get(j).name + "님의 공작의 유무에 대해 도전하시겠습니까?"
                              +"\n1.공작의 유무에 대해 도전하기\n2.외부원조를 포기하기\n번호를 입력 >>");
                        int challNum = s.getIntInput();
                        if(challNum == 1) {
                           if (players.get(j).myJob.size() == 2) {
                               System.out.print("\n"+ players.get(j).name+"님! "+ players.get(i).name + "님이 공작의 유무에 대해 도전해왔습니다. 상대에게 보여줄"
                                       + " 카드를 선택하세요. \n1. " + players.get(j).myJob.get(0).jobName + " 2. " + 
                                       players.get(j).myJob.get(1).jobName + "\n번호를 입력>>");   
                           } else if (players.get(j).myJob.size() == 1) {
                               // 리스트에 한 개의 요소만 있을 때 처리
                               System.out.print("\n"+ players.get(j).name+"님! "+ players.get(i).name + "님이 공작의 유무에 대해 도전해왔습니다. 상대에게 보여줄"
                                       + " 카드를 선택하세요. \n1. " + players.get(j).myJob.get(0).jobName + "\n번호를 입력>>");
                           }
                           
                           int selectOneCardNum = s.getIntInput();
                           if(selectOneCardNum == 1) {
                               if(players.get(j).myJob.get(0).jobName == "공작") {
                                   System.out.println("\n"+players.get(j).name + "님이 공작을 소유하고 있음을 증명했습니다!\n"
                                           +"보여진 \'공작\'카드를 궁정 덱에서 교환합니다.\n");
                                   Player.royalCourtDeck.add(players.get(j).myJob.get(0));
                                   players.get(j).myJob.remove(0);
                                   Collections.shuffle(Player.royalCourtDeck);
                                   players.get(j).myJob.add(Player.royalCourtDeck.get(0));

                                   System.out.println( players.get(i).name + "님이 도전에 실패했습니다. \n"
                                           + "패배의 댓가로 카드를 하나 잃습니다.");

                                   if (players.get(i).myJob.size() == 1) {
                                       System.out.print("\n"+ players.get(i).name+"님, 버릴 카드 하나를 선택해주세요. \n1. " 
                                                           + players.get(i).myJob.get(0).jobName + "\n번호를 입력>>");
                                   } else if (players.get(i).myJob.size() == 2){
                                       System.out.print("\n"+ players.get(i).name+"님, 버릴 카드 하나를 선택해주세요. \n1. " 
                                                           + players.get(i).myJob.get(0).jobName + " 2. " + 
                                                           players.get(i).myJob.get(1).jobName + "\n번호를 입력>>");
                                   }

                                   int deadCardNum = s.getIntInput();
                                   if(deadCardNum == 1) {
                                       players.get(i).myJob.remove(0);
                                       if(players.get(i).myJob.isEmpty() == true) {
                                                System.out.println("\n"+players.get(i).name + "님의 세력이 패배하였습니다."); 
                                                players.remove(i);
                                             }
                                   } else if(deadCardNum == 2) {
                                       players.get(i).myJob.remove(1);
                                   }
                               } else {
                                   players.get(j).myJob.remove(0);
                                   System.out.println("\n"+players.get(j).name + "님에게 공작이 없다는 사실이 들통났습니다."
                                           +"\n상대에게 보여진 카드 하나를 잃습니다.\n"+players.get(i).name + "님은 도전을 성공했습니다!");
                                   if(players.get(j).myJob.isEmpty() == true) {
                                       System.out.println("\n"+players.get(j).name + "님의 세력이 패배하였습니다."); 
                                          players.remove(j);
                                   }
                               }
                           } else if(selectOneCardNum == 2) {
                               if(players.get(j).myJob.get(1).jobName == "공작") {
                                   System.out.println("\n"+players.get(j).name + "님이 공작을 소유하고 있음을 증명했습니다!\n"
                                           +"보여진 \'공작\'카드를 궁정 덱에서 교환합니다.\n");
                                   Player.royalCourtDeck.add(players.get(j).myJob.get(1));
                                   players.get(j).myJob.remove(1);
                                   Collections.shuffle(Player.royalCourtDeck);
                                   players.get(j).myJob.add(Player.royalCourtDeck.get(0));

                                   System.out.println( players.get(i).name + "님이 도전에 실패했습니다. \n"
                                           + "패배의 댓가로 카드를 하나 잃습니다.");

                                   if (players.get(i).myJob.size() == 1) {
                                       System.out.print("\n"+ players.get(i).name+"님, 버릴 카드 하나를 선택해주세요. \n1. " 
                                               + players.get(i).myJob.get(0).jobName + "\n번호를 입력>>");
                                   } else if(players.get(i).myJob.size() == 2) {
                                       System.out.print("\n"+ players.get(i).name+"님, 버릴 카드 하나를 선택해주세요. \n1. " 
                                               + players.get(i).myJob.get(0).jobName + " 2. " + 
                                               players.get(i).myJob.get(1).jobName + "\n번호를 입력>>");
                                   }

                                   int deadCardNum = s.getIntInput();
                                   if(deadCardNum == 1) {
                                       players.get(i).myJob.remove(0);
                                       if(players.get(i).myJob.isEmpty() == true) {
                                             System.out.println("\n"+players.get(i).name + "님의 세력이 패배하였습니다."); 
                                             players.remove(i);
                                          }
                                   } else if(deadCardNum == 2) {
                                       players.get(i).myJob.remove(1);
                                   }
                                   
                               } else {
                                   players.get(j).myJob.remove(1);
                                   System.out.println("\n"+players.get(j).name + "님에게 공작이 없다는 사실이 들통났습니다."
                                           +"\n상대에게 보여진 카드 하나를 잃습니다.\n"+players.get(i).name + "님은 도전을 성공했습니다!");
                               }
                           }
                        }else if(challNum == 2){
                            System.out.println("\n"+ players.get(j).name + "님이 " + players.get(i).name + "님의 외부원조를 저지하였습니다.");
                        }
                        break;
                     }else if(selectNum == 2) {
                        count++;
                     }
                  }
               }
               if(count == 3) {
                  players.get(i).outsideAid();
                  count = 0;
               }else {
                  count = 0;
               }
            }else if(actionNumber1 == 3) {
               if(players.get(i).coin < 7) {
                  System.out.println("\n코인이 7개 미만이면 쿠데타를 실행할 수 없습니다.");
                  i--;
                  continue;
               }else {
                  System.out.println("\n쿠데타를 실행합니다!");
                    System.out.print("쿠데타를 실행할 상대 플레이어의 이름>>");
                    String selectPlayer = s.getStringInput();
                    int deadCardNum = 0;
                    for(int j=0; j<players.size(); j++) {
                       if(selectPlayer.equals(players.get(j).name)) {
                            players.get(i).coup(players.get(j),deadCardNum,players);
                       }
                    }
               }
            }else if(actionNumber1 == 4) {
               System.out.println("\n실행할 직업 능력을 선택하세요!");
               System.out.print("1.공작의 세금징수\n2.대사의 교환\n3.사령관의 갈취\n4.암살자의 암살\n번호를 입력 >>");
               
               int actionNumber2 = s.getIntInput();
               if(actionNumber2 == 1) {
                  players.get(i).dukeGetThreeCoin();
               }else if(actionNumber2 == 2) {
                  
               }else if(actionNumber2 == 3) {
                  System.out.println("\n갈취할 플레이어의 닉네임을 입력하세요");
                  String userNameToSteal = s.getStringInput();
               }else if(actionNumber2 == 4) {
                  System.out.println("\n암살할 플레이어의 닉네임을 입력하세요");
                  String userNameToAssasination = s.getStringInput();
      
               }
            }
         }
         if(players.size() == 1) {
            System.out.println("\n"+players.get(0).name + "님의 세력이 마지막까지 살아남았습니다. \n" + players.get(0).name + "님의 승리!"); 
            isGameEnd = false;
         }
      }
      
      
   } // 게임 매니저 생성자
   
   // 저지
   
   public void blockStealWithAmbassador(Player p) {
      
   }
   
   public void blockStealWithCommander(Player p) {
      
   }
   
   public void blockAssasinationWithCountess(Player p) {
      
   }
   
   // 도전

   public void challengeAmbassadorExistence() {
      
   }
   
   public void challengeAssassinExistence() {
      
   }
   
   public void challengeCommanderExistence() {
      
   }

   public void challengeCountessExistence() {
      
   }

   public void challengeDukeExistence() {
      
   }
}