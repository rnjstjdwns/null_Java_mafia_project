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
import Methods.Assassination;
import Methods.Common;
import Methods.Coup;
import Methods.Mulligan;
import Methods.OutsideAid;
import Methods.Steal;
import Methods.TaxCollection;
import Player.Player;

public class GameManeger { 
   
   boolean isGameEnd = true;
   int count =0;

   public GameManeger() {
      
      Scanner s = new Scanner(System.in);
      
      System.out.println("플레이어 1님! 사용할 이름을 입력해주세요");
      Player p1 = new Player(s.nextLine());
      p1.sayName();
      System.out.println("\n플레이어 2님! 사용할 이름을 입력해주세요");
      Player p2 = new Player(s.nextLine());
      p2.sayName();
      System.out.println("\n플레이어 3님! 사용할 이름을 입력해주세요");
      Player p3 = new Player(s.nextLine());
      p3.sayName();
      System.out.println("\n플레이어 4님! 사용할 이름을 입력해주세요");
      Player p4 = new Player(s.nextLine());
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
      
      p1.sayMyTwoCard(p1.myJob.get(0),p1.myJob.get(1));
      p2.sayMyTwoCard(p2.myJob.get(0),p2.myJob.get(1));
      p3.sayMyTwoCard(p3.myJob.get(0),p3.myJob.get(1));
      p4.sayMyTwoCard(p4.myJob.get(0),p4.myJob.get(1));
      
      for(int i = 14; i >= 7; i--) {
         jobAssignRandomBox.remove(i);
      }
      
      for(int i = 0; i <= 6; i++) {
         Player.royalCourtDeck.add(jobAssignRandomBox.get(i));
      }
      
      Common common = new Common();
      OutsideAid outsideAid = new OutsideAid();
      Mulligan mulligan = new Mulligan();
      Coup coup = new Coup();
      Steal steal = new Steal();
      TaxCollection taxCollection = new TaxCollection();
      Assassination assassination = new Assassination();
      
      while(isGameEnd) {
         for(int cp = 0; cp < players.size(); cp++) {
         
            System.out.println("\n\n==========" + players.get(cp).name + "님의 차례==========");
            System.out.println("내 코인: "+ players.get(cp).coin + "$");
            System.out.print("내 카드: " + players.get(cp).myJob.get(0).jobName);
            if(players.get(cp).myJob.size() == 2)
            {
            System.out.println(", "+players.get(cp).myJob.get(1).jobName);
            }
            System.out.println();
            
            for(int op = 0; op < players.size(); op++) {
               if(op != cp) {
               System.out.println(players.get(op).name + "님의 코인: " + players.get(op).coin + "$, " 
               + players.get(op).name + "님의 남은 카드: " + players.get(op).sayLeftCard() + "장");
               }
            }// 나머지 플레이어들 정보 출력
            
            int actionNumber1 = 0;
            
            // 코인이 10개 미만일 때
            if(players.get(cp).coin < 10) {
            System.out.println();
            System.out.println("실행할 행동을 선택하세요!"); 
            System.out.println("1.소득");
            System.out.println("2.외부원조");
            System.out.println("3.쿠데타");
            System.out.println("4.직업능력사용");
            System.out.print("번호를 입력 >>");
            // 행동 번호를 입력
            actionNumber1 = s.nextInt();
            }
            
            // 코인이 10개 이상일 때
            if(players.get(cp).coin >= 10) {
            	System.out.println();
		        System.out.println("코인이 10개 이상이므로 쿠를 실행합니다.");
		        actionNumber1 = 3;
            }
            
            
            // 행동 번호가 1번일 때(소득)
            if (actionNumber1 == 1) {
               players.get(cp).getOneCoin();
            }
            // 소득 끝
            
         // 행동 번호가 2번일 때(외부원조)
            else if(actionNumber1 == 2) 
            {
               cp = outsideAid.outsideAid(cp, players, s, count);
            }// 외부원조 끝
            
          //행동 번호가 3일때 (쿠데타)
            else if(actionNumber1 == 3) {
               if(players.get(cp).coin < 7) {
                  //만약 코인이 7개 미만일 경우 턴 재시작
                  System.out.println("\n코인이 7개 미만이면 쿠데타를 실행할 수 없습니다.");
                  cp--;
                  continue;
               }else {
                   //입력받기전 스캐너 초기화
                    s.nextLine();
                  
                    //쿠데타 실행
                    System.out.println("\n쿠데타를 실행합니다!");
                    System.out.print("쿠데타를 실행할 대상 플레이어의 이름>>");
                    
                    //쿠데타를 실행할 대상 플레이어의 이름을 입력받는 스캐너
                    String selectPlayer = s.nextLine();
                    
                    
                    int deadCardNum = 0;
                    for(int tp=0; tp<players.size(); tp++) {
                       //입력받은 플레이어의 이름과 이름이 같으면 쿠데타 실행
                       if(selectPlayer.equals(players.get(tp).name)) {
                          
                          //만약 대상 플레이어의 카드 수가 2장일 때
                             if(players.get(tp).myJob.size() == 2) {                                
                              coup.sayCoupTargetJobTwo(players.get(cp), players.get(tp));
                              
                              //제거할 카드의 번호를 입력받을 스캐너
                              deadCardNum = s.nextInt();
                              
                              //카드 제거
                              coup.coup(players.get(cp), players.get(tp), deadCardNum, players, cp, tp);
                             }
                          
                             //만약 대상 플레이어의 카드 수가 1장일 때
                             else if(selectPlayer.equals(players.get(tp).name)) {
                                coup.sayCoupTargetJobOne(players.get(cp), players.get(tp));
                                
                                //제거할 카드의 번호를 입력받을 스캐너
                                deadCardNum = s.nextInt();
                                
                                //카드 제거 후 플레이어를 제거
                                coup.coup(players.get(cp), players.get(tp), deadCardNum, players, cp, tp);
                             }
                       }
                    }//입력받은 대상 플레이어의 쿠데타 실행문 끝
               }
            }
            
            
            else if(actionNumber1 == 4) {
               System.out.println("\n실행할 직업 능력을 선택하세요!");
               System.out.print("1.공작의 세금징수\n2.대사의 교환\n3.사령관의 갈취\n4.암살자의 암살\n번호를 입력 >>");
               
               //어떤 직업 능력을 사용을 할지
               int actionNumber2 = s.nextInt();
               
               // 직업 능력 사용 번호가 1번일 때 (세금 징수)
               if(actionNumber2 == 1) 
               {
                 cp = taxCollection.taxCollection(cp, players, s, count);
               } //세금징수 끝
               
             //직업 능력 사용 번호가 2번일 때 (교환)
               else if(actionNumber2 == 2) {
                 System.out.println("\n" + players.get(cp).name + "님이 대사의 교환을 선택하셨습니다.");
                 
                 //도전할지 말지 여부를 현재 플레이어 외 다른 플레이어들에게 선택.
                 for(int op = 0; op < players.size(); op++ ) {
                      if(op != cp) {
                         mulligan.askChallengeAboutMulligan(players.get(cp),players.get(op));
                         
                         //도전여부를 입력받을 스캐너.
                         int challNum = s.nextInt();
                         
                         //만약 도전을 시도했을때.
                         if(challNum == 1) {
                          
                            // 도전을 받은 현재 플레이어의 생명이 두개가 살아있을 때 어떤 카드를 보여줄 것인지 선택
                              if (players.get(cp).myJob.size() == 2) {
                                  mulligan.selectDrawCardBetweenTwo(players.get(cp), players.get(op));
                              } 
                              
                              // 도전을 받은 현재 플레이어의 생명이 한개가 살아있을 때 어떤 카드를 보여줄 것인지 선택
                              else if (players.get(cp).myJob.size() == 1) {
                                  mulligan.selectDrawCardBetweenOne(players.get(cp), players.get(op));
                              }
                              
                              // 어떤 카드를 보여줄 것인지 번호를 입력 받는 스캐너
                              int selectOneCardNum = s.nextInt();
                              
                              // 1번 카드를 보여주기로 했을 때
                              if(selectOneCardNum == 1) {
                                 
                                 //보여준 1번 카드가 대사가 맞을 때
                                  if(players.get(cp).myJob.get(0).jobName == "대사") {
                                     mulligan.proveFirstIsMulligan(players.get(cp), players.get(op));
                                 
                                      //도전에 실패한 플레이어가 버릴 카드 선택 (카드가 두장일 때)
                                      if (players.get(op).myJob.size() == 2) {
                                         common.selectDeadCardBetweenTwo(players.get(op));
                                      } 
                                      
                                      //도전에 실패한 플레이어가 버릴 카드 선택 (카드가 한장일 때)
                                      else if (players.get(op).myJob.size() == 1){
                                          common.selectDeadCardBetweenOne(players.get(op));
                                      }
                                      
                                      // 버리는 카드가 몇번인지 입력받는 스캐너
                                      int deadCardNum = s.nextInt();
                                      
                                      // 1번일 때
                                      if(deadCardNum == 1) {
                                          
                                        // 1번 카드를 삭제
                                         players.get(op).myJob.remove(0);
                                          
                                         //플레이가 죽으면 콜렉션에서 제거
                                         if (players.get(cp).myJob.isEmpty()) 
                                         {
                                           System.out.println();
                                            System.out.println(players.get(cp).name + "님의 세력이 패배하였습니다.");
                                            players.remove(players.get(cp));
                                            cp--;
                                         }
                                         //제거 끝
                                         
                                         count = players.size() - 1;
                                      } 
                                      
                                      // 2번일 때
                                      else if(deadCardNum == 2) {
                                         
                                         // 2번 카드를 삭제
                                          players.get(op).myJob.remove(1);
                                          count = players.size() - 1;
                                      }
                                      
                                  } 
                                  
                                  // 보여준 1번카드가 대사가 아닐 떄
                                  else if (players.get(cp).myJob.get(0).jobName != "대사"){
                                     
                                     //도전받은 플레이어의 보여진 카드를 제거
                                     mulligan.proveFirstIsNotMulligan(players.get(cp),players.get(op));
                                      
                                     //플레이가 죽으면 콜렉션에서 제거
                                     if (players.get(cp).myJob.isEmpty()) 
                                     {
                                       System.out.println();
                                        System.out.println(players.get(cp).name + "님의 세력이 패배하였습니다.");
                                        players.remove(players.get(cp));
                                        cp--;
                                     }
                                     //제거 끝
                                     
                                      }
                                  } 
                         
                              // 2번 카드를 보여주기로 했을 때
                              else if(selectOneCardNum == 2) {
                                 
                                 // 보여준 2번 카드가 대사일 때
                                  if(players.get(cp).myJob.get(1).jobName == "대사") {
                                      
                                     //대사 카드를 궁정덱에서 교환함.
                                     mulligan.proveSecondIsMulligan(players.get(cp), players.get(op));
                                      
                                      // 도전을 실패한 플레이어가 버릴 카드 선택 (두장일 때)
                                      if (players.get(op).myJob.size() == 2) {
                                          
                                         //
                                         common.selectDeadCardBetweenTwo(players.get(op));
                                      } 
                                      // 도전을 실패한 플레이어가 버릴 카드 선택 (한장일 때)
                                      else if(players.get(op).myJob.size() == 1) {
                                          
                                         //
                                         common.selectDeadCardBetweenOne(players.get(op));
                                      }
                                      
                                      // 버릴 카드를 입력받는 스캐너
                                      int deadCardNum = s.nextInt();
                                      
                                      // 1번 카드를 버릴 때
                                      if(deadCardNum == 1) {
                                         players.get(op).myJob.remove(0);
                                          
                                         //플레이가 죽으면 콜렉션에서 제거
                                         if (players.get(cp).myJob.isEmpty()) 
                                         {
                                           System.out.println();
                                            System.out.println(players.get(cp).name + "님의 세력이 패배하였습니다.");
                                            players.remove(players.get(cp));
                                            cp--;
                                         }
                                         //제거 끝
                                         
                                          count = players.size() - 1;
                                      } 
                                      // 2번 카드를 버릴 때
                                      else if(deadCardNum == 2) {
                                          players.get(op).myJob.remove(1);
                                          count = players.size() - 1;
                                      }
                                      
                                  } else if(players.get(cp).myJob.get(1).jobName != "대사") {
                                      mulligan.proveSecondIsNotMulligan(players.get(cp), players.get(op));
                                  }
                              }
                          break;
                         }  
                         
                         
                         //도전을 아무도 시도하지않았을때.
                         else if(challNum == 2) {
                            count++;
                         }
                      }
                 }
                 if(count == players.size() - 1 && players.size() != 0) {
                    System.out.println("\n대사의 교환 능력이 발동됩니다.");
                    int selectCard1= 0;
                    int selectCard2= 0;
                
                    //대사 능력으로 2장의 카드를 뽑음.
                    mulligan.myJobAdd(players.get(cp));
                    
                    //내 카드가 2장일때 대사 능력 실행.
                          if(players.get(cp).myJob.size() == 4) {
                             
                             //어떤 카드를 가져올지 선택.
                             mulligan.askSelectCardBetweenFour(players.get(cp));
                             
                             //가져올 카드의 번호를 입력받을 스캐너.
                             selectCard1= s.nextInt();
                             selectCard2= s.nextInt();
                  
                             //선택하지않은 카드를 궁정덱에 다시 돌려놓는 메소드.
                             mulligan.unselectCardUndoBetweenFour(players.get(cp), selectCard1, selectCard2);
                          }
               
                          //내 카드가 1장일때 대사 능력 실행 .
                          else if(players.get(cp).myJob.size() == 3) {
                  
                             //어떤 카드를 가져올지 선택.
                             mulligan.askSelectCardBetweenThree(players.get(cp));
                  
                             //가져올 카드의 번호를 입력받을 스캐너.
                             selectCard1= s.nextInt();
                  
                             //선택하지않은 카드를 궁정덱에 다시 돌려놓는 메소드.
                             mulligan.unselectCardUndoBetweenThree(players.get(cp), selectCard1);
                          }
                 count = 0;
                 }
                 else {
                    count = 0;
                 }
               }//교환 끝
               
               //직업능력사용 3번 (갈취)
               else if(actionNumber2 == 3) 
               {
                System.out.println();
                System.out.println("코인을 갈취할 플레이어를 선택하세요! (0코인인 플레이어의 코인은 갈취할 수 없습니다.)");
                for(int opn = 0, i = 1; opn < players.size(); opn++, i++){
                   if(cp != opn){
                      System.out.println(i + "." + players.get(opn).name);
                   }
                   else {
                      i--;
                   }
                }
                System.out.print("번호를 입력 >>");
               
                
                // 어떤 플레이어에게 갈취를 사용할지
                int playerNum = s.nextInt();
                // 1번 플레이어한테 갈취를 사용할 때
                if(playerNum == 1)
                {
                   
                   int op = 0;
                    if(op == cp)
                       op++;
                    
                     cp = steal.steal(cp, op, players, s);
                }
                
                //2번 플레이어를 선택했을 때
                else if(playerNum == 2)
                {
                   int op = 1;
                    if(cp < 2) 
                       op++;
                   
                    cp = steal.steal(cp, op, players, s);
                }
                
                //3번 플레이어를 선택했을 때
                else if(playerNum == 3)
                {
                   int op = 2;
                   if(cp < 3)
                      op++;
                   
                   cp = steal.steal(cp, op, players, s);
                }
               }
               
               
               //직업능력 사용 4번 (암살)
             //직업능력 사용 4번 (암살)
               else if(actionNumber2 == 4) {
                      
                   if(players.get(cp).coin >= 3) {
                      System.out.println();
                      System.out.println("암살할 플레이어를 선택하세요!");
                      for(int opn = 0, i = 1; opn < players.size(); opn++, i++){
                         if(cp != opn){
                            System.out.println(i + "." + players.get(opn).name);
                         }
                         else {
                            i--;
                         }
                      }
                      System.out.print("번호를 입력 >>");
                   
                      // 어떤 플레이어에게 암살을 사용할지
                      int playerNum = s.nextInt();
                      
                   // 1번 플레이어한테 암살을 사용할 때
                       if(playerNum == 1)
                       {
                          
                          int op = 0;
                           if(op == cp)
                              op++;
                           
                           //암살 실행
                           cp = assassination.assassination(cp, op, players, s);
                       }
                       
                       //2번 플레이어를 선택했을 때
                       else if(playerNum == 2)
                       {
                          int op = 1;
                           if(cp < 2) 
                              op++;
                          
                           cp = assassination.assassination(cp, op, players, s);
                       }
                       
                       //3번 플레이어를 선택했을 때
                       else if(playerNum == 3)
                       {
                          int op = 2;
                          if(cp < 3)
                             op++;
                          
                          cp = assassination.assassination(cp, op, players, s);
                       }
                      
                   }
                         else if(players.get(cp).coin < 3) {
                            System.out.println("코인이 3개 미만이면 암살을 시도할 수 없습니다. 현재 코인 : " + players.get(cp).coin + "개");
                            cp--;
                            continue;
                         }
             } //직업능력 사용 4번 (암살) 끝
            }
            
            
            if(players.size() == 1) {
               System.out.println("\n"+players.get(0).name + "님의 세력이 마지막까지 살아남았습니다. \n" + players.get(0).name + "님의 승리!"); 
               isGameEnd = false;
            }
         } //cp for문의 끝
         
      } // while의 끝
     
   } // 게임 매니저 생성자
}