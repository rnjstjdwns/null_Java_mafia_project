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
import Methods.Common;
import Methods.Coup;
import Methods.Mulligan;
import Methods.OutsideAid;
import Player.Player;

public class GameManeger { 
   
   boolean isGameEnd = true;
   int count =0;

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
      Mulligan mulligan = new Mulligan();
      Coup coup = new Coup();
      
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
            
            System.out.println();
            System.out.println("실행할 행동을 선택하세요!"); 
            System.out.println("1.소득");
            System.out.println("2.외부원조");
            System.out.println("3.쿠데타");
            System.out.println("4.직업능력사용");
            System.out.print("번호를 입력 >>");
            
            
            // 행동 번호를 입력
            int actionNumber1 = s.nextInt();
            
            // 행동 번호가 1번일 때(소득)
            if (actionNumber1 == 1) {
               players.get(cp).getOneCoin();
            }
            // 소득 끝
            
         // 행동 번호가 2번일 때(외부원조)
            else if(actionNumber1 == 2) 
            {
               //다른 플레이어들에게 저지할 것인지 질문
               for(int op = 0; op <players.size(); op++) 
               {
                  if(cp != op) 
                  {   
                     System.out.println();
                     System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님의 외부원조를 공작의 능력으로 저지하시겠습니까?");
                     System.out.println("1. 예");
                     System.out.println("2. 아니요");
                     System.out.print("번호를 입력 >>");
                     
                     //외부원조를 저지할것인지
                     int selectBlockNum = s.nextInt();
                     //예를 눌렀을 때
                     if(selectBlockNum == 1)
                     {
                        System.out.println();
                        System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 외부원조를 저지하려 합니다." 
                         + players.get(op).name + "님의 공작의 유무에 대해 도전하시겠습니까?");
                        System.out.println("1.공작의 유무에 대해 도전하기");
                        System.out.println("2.외부원조를 포기하기");
                        System.out.print("번호를 입력 >>");
                        
                        //도전할 것인지
                        int selectChallNum = s.nextInt();
                        //도전한다면
                        if(selectChallNum == 1)
                        {
                           System.out.println();
                           System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님이 공작의 유무에 대해 도전해왔습니다. 상대에게 보여줄 카드를 선택하세요.");
                           System.out.println("1." + players.get(op).myJob.get(0).jobName);
                           if(players.get(op).myJob.size() == 2) 
                           {
                           System.out.println("2." + players.get(op).myJob.get(1).jobName);
                           }
                           System.out.print("번호를 입력 >>");
                           
                           //어떤 카드를 보여줄 것인지
                           int drawCard = s.nextInt();
                           //1번 카드를 보여줄 때
                           if(drawCard == 1)
                           {
                              //보여준 1번카드가 공작이 맞다면
                              if(players.get(op).myJob.get(0).jobName == "공작")
                              {
                                 System.out.println();
                                 System.out.println(players.get(op).name + "님이 공작을 소유하고 있음을 증명했습니다!");
                                 System.out.println("보여진 \'공작\' 카드를 궁정덱에서 교환합니다.");
                                 
                                   //공작을 궁정덱 카드 한장과 교환하는 과정
                                   Player.royalCourtDeck.add(players.get(op).myJob.get(0));
                                   players.get(op).myJob.remove(0);
                                   Collections.shuffle(Player.royalCourtDeck);
                                   players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                                   Player.royalCourtDeck.remove(0);
                                   //공작을 궁정덱 카드 한장과 교환하는 과정
                                   
                                   System.out.println();
                                   System.out.println(players.get(cp).name + "님이 도전에 실패했습니다.");
                                   System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                                   System.out.println();
                                   System.out.println(players.get(cp).name + "님, 버릴 카드 하나를 선택해주세요.");
                                   System.out.println("1." + players.get(cp).myJob.get(0).jobName);
                                   if(players.get(cp).myJob.size() == 2) 
                                   {
                                   System.out.println("2." + players.get(cp).myJob.get(1).jobName);
                                   }
                                   System.out.print("번호를 입력>>");
                                   
                                   //어떤 카드를 버릴지
                                   int selectDeadCardNum = s.nextInt();
                                   // 1번 카드를 버릴 때
                                   if(selectDeadCardNum == 1)
                                   {
                                      players.get(cp).myJob.remove(0);
                                      //현재 플레이어를 플레이어 콜렉션에서 제거
                                      common.isPlayerDead(players.get(cp), players);
                                   }
                                   else if(selectDeadCardNum == 2)
                                   {
                                      players.get(cp).myJob.remove(1);
                                   }
            
                              }
                              //보여준 1번 카드가 공작이 아니라면
                              else if(players.get(op).myJob.get(0).jobName != "공작")
                              {
                                 System.out.println();
                                 System.out.println(players.get(op).name + "님에게 공작이 없다는 사실이 들통났습니다.");
                                 System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
                                 players.get(op).myJob.remove(0);
                                 //도전에 패배한 플레이어를 플레이어 콜렉션에서 제거
                                 common.isPlayerDead(players.get(op), players);
                                 System.out.println();
                                 System.out.println(players.get(cp).name + "님이 도전을 성공했습니다!");
                                 System.out.println(players.get(cp).name + "님이 외부원조로 코인을 2개 가져왔습니다.");
                                 players.get(cp).coin += 2;
                              }
                           }
                           //2번 카드를 보여줄 때
                           else if(drawCard == 2)
                           {
                              //보여준 2번 카드가 공작이 맞다면
                              if(players.get(op).myJob.get(1).jobName == "공작")
                              {
                                 System.out.println();
                                 System.out.println(players.get(op).name + "님이 공작을 소유하고 있음을 증명했습니다!");
                                 System.out.println("보여진 \'공작\' 카드를 궁정덱에서 교환합니다.");
                                 
                                   //공작을 궁정덱 카드 한장과 교환하는 과정
                                   Player.royalCourtDeck.add(players.get(op).myJob.get(1));
                                   players.get(op).myJob.remove(1);
                                   Collections.shuffle(Player.royalCourtDeck);
                                   players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                                   Player.royalCourtDeck.remove(0);
                                   //공작을 궁정덱 카드 한장과 교환하는 과정
                              }
                              //보여준 2번 카드가 공작이 아니라면
                              else if(players.get(op).myJob.get(1).jobName != "공작")
                              {
                                 System.out.println();
                                 System.out.println(players.get(op).name + "님에게 공작이 없다는 사실이 들통났습니다.");
                                 System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
                                 players.get(op).myJob.remove(1);
                                 System.out.println();
                                 System.out.println(players.get(cp).name + "님이 도전을 성공했습니다!");
                                 System.out.println(players.get(cp).name + "님이 외부원조로 코인을 2개 가져왔습니다.");
                                 players.get(cp).coin += 2;
                              }
                           }
                           
                           
                        }
                        //도전하지 않는다면
                        else if(selectChallNum == 2)
                        {
                           System.out.println();
                           System.out.println(players.get(op).name + "님이 " + players.get(cp).name + "님의 외부원조를 저지하였습니다.");
                           
                        }
                        
                        //다음 차례에게 또 질문하지 않도록 for문을 탈출
                        break;
                     }
                     //아니요를 눌렀을 때
                     else if(selectBlockNum == 2) 
                     {
                        //아니요 버튼이 눌린 횟수를 저장
                        count++;
                     }
                  }//op들을 호출하는 if문의 끝
               }//op들을 호출하는 for문의 끝
               
               if(count == players.size() - 1)
             {
                System.out.println();
                System.out.println(players.get(cp).name + "님이 외부원조로 코인을 2개 가져왔습니다.");
                players.get(cp).coin += 2;
                count = 0;
             }
             else
             {
                count = 0;
             }
            }// 외부원조 끝
            
            //행동 번호가 3일때 (쿠데타)
            else if(actionNumber1 == 3) {
               if(players.get(cp).coin < 7) {
                  System.out.println("\n코인이 7개 미만이면 쿠데타를 실행할 수 없습니다.");
                  cp--;
                  continue;
               }else {
                  s.nextLine();
                  System.out.println("\n쿠데타를 실행합니다!");
                    System.out.print("쿠데타를 실행할 대상 플레이어의 이름>>");
                    String selectPlayer = s.nextLine();
                    int deadCardNum = 0;
                    for(int tp=0; tp<players.size(); tp++) {
                       if(selectPlayer.equals(players.get(tp).name)) {
                             if(players.get(tp).myJob.size() == 2) {
                        coup.sayCoupTargetJobTwo(players.get(cp), players.get(tp));
                        deadCardNum = s.nextInt();
                        coup.coup(players.get(cp), players.get(tp), deadCardNum, players);
                             }else if(selectPlayer.equals(players.get(tp).name)) {
                                coup.sayCoupTargetJobOne(players.get(cp), players.get(tp));
                                deadCardNum = s.nextInt();
                                coup.coup(players.get(cp), players.get(tp), deadCardNum, players);
                             }
                       }
                    }//입력받은 대상 플레이어의 쿠데타 실행문 끝
               }
            }else if(actionNumber1 == 4) {
               System.out.println("\n실행할 직업 능력을 선택하세요!");
               System.out.print("1.공작의 세금징수\n2.대사의 교환\n3.사령관의 갈취\n4.암살자의 암살\n번호를 입력 >>");
               
               //어떤 직업 능력을 사용을 할지
               int actionNumber2 = s.nextInt();
               
               // 직업 능력 사용 번호가 1번일 때 (세금 징수)
               if(actionNumber2 == 1) 
               {
            	   for(int op = 0; op < players.size(); op++) {
            		   if(cp != op)
            		   {
            			   System.out.println();
            			   System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님의 공작의 유무에 도전하시겠습니까?");
            			   System.out.println("1.공작의 유무에 대해 도전하기");
            			   System.out.println("2.도전하지 않기");
            			   System.out.print("번호를 입력>>");
            			   
            			   //공작의 유무에 도전할것인지
            			   int selectChallNum = s.nextInt();
            			   //도전하지 않음
            			   if(selectChallNum == 1)
            			   {
            				   System.out.println();
            				   System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 공작의 유무에 대해 도전하였습니다. 상대에게 보여줄 카드를 선택하세요." );
            				   System.out.println("1." + players.get(cp).myJob.get(0).jobName);
            				   if(players.get(cp).myJob.size() == 2)
            				   {
            				   System.out.println("2." + players.get(cp).myJob.get(1).jobName);
            				   }
            				   System.out.print("번호를 입력>>");
            				   
            				   //보여줄 카드를 고름
            				   int drawCard = s.nextInt();
            				   //보여주는 카드가 1번일 때
            				   if(drawCard == 1)
            				   {
            					   //1번 카드가 공작일 때
            					   if(players.get(cp).myJob.get(0).jobName == "공작")
            					   {
            						   System.out.println();
            						   System.out.println(players.get(cp).name + "님이 공작을 소유하고 있음을 증명했습니다!");
            						   System.out.println("보여진 \'공작\'카드를 궁정 덱에서 교환합니다.");
            						   
            						   //공작을 궁정덱 카드 한장과 교환하는 과정
                                       Player.royalCourtDeck.add(players.get(cp).myJob.get(0));
                                       players.get(cp).myJob.remove(0);
                                       Collections.shuffle(Player.royalCourtDeck);
                                       players.get(cp).myJob.add(Player.royalCourtDeck.get(0));
                                       Player.royalCourtDeck.remove(0);
                                       //공작을 궁정덱 카드 한장과 교환하는 과정
                                       
                                       System.out.println();
                                       System.out.println(players.get(op).name + "님이 도전에 실패했습니다.");
                                       System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                                       
                                       System.out.println();
                                       System.out.println(players.get(op).name + "님, 버릴 카드 하나를 선택해주세요.");
                                       System.out.println("1." + players.get(op).myJob.get(0).jobName);
                                       if(players.get(op).myJob.size() == 2)
                                       {
                                       System.out.println("2." + players.get(op).myJob.get(1).jobName);
                                       }
                                       System.out.print("번호를 입력>>");
                                       
                                       //죽일 카드를 선택
                                       int deadCard = s.nextInt();
                                       //죽일 카드가 1번일 때
                                       if(deadCard == 1)
                                       {
                                    	   players.get(op).myJob.remove(0);
                                    	   common.isPlayerDead(players.get(op), players);
                                       }
                                       //죽일 카드가 2번 일때
                                       else if(deadCard == 2)
                                       {
                                    	   players.get(op).myJob.remove(1);
                                       }
                                       
                                       System.out.println();
                            		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
                            		   players.get(cp).coin += 3;
            					   }
            					   //1번 카드가 공작이 아닐 때
            					   else if(players.get(cp).myJob.get(0).jobName != "공작")
            					   {
            						   System.out.println();
            						   System.out.println(players.get(cp).name + "님이 공작이 없다는 사실이 들통났습니다!");
            						   System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
            						   players.get(cp).myJob.remove(0);
            						   System.out.println();
            						   System.out.println(players.get(op).name + "님이 도전을 성공했습니다!");
            						   common.isPlayerDead(players.get(cp), players);
            					   }
            				   }
            				   //보여주는 카드가 2번일 때
            				   else if(drawCard == 2)
            				   {
            					   if(players.get(cp).myJob.get(1).jobName == "공작")
            					   {
            						   System.out.println();
            						   System.out.println(players.get(cp).name + "님이 공작을 소유하고 있음을 증명했습니다!");
            						   System.out.println("보여진 \'공작\'카드를 궁정 덱에서 교환합니다.");
            						   
            						   //공작을 궁정덱 카드 한장과 교환하는 과정
                                       Player.royalCourtDeck.add(players.get(cp).myJob.get(1));
                                       players.get(cp).myJob.remove(1);
                                       Collections.shuffle(Player.royalCourtDeck);
                                       players.get(cp).myJob.add(Player.royalCourtDeck.get(0));
                                       Player.royalCourtDeck.remove(0);
                                       //공작을 궁정덱 카드 한장과 교환하는 과정
                                       
                                       System.out.println();
                                       System.out.println(players.get(op).name + "님이 도전에 실패했습니다.");
                                       System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                                       
                                       System.out.println();
                                       System.out.println(players.get(op).name + "님, 버릴 카드 하나를 선택해주세요.");
                                       System.out.println("1." + players.get(op).myJob.get(0).jobName);
                                       if(players.get(op).myJob.size() == 2)
                                       {
                                       System.out.println("2." + players.get(op).myJob.get(1).jobName);
                                       }
                                       System.out.print("번호를 입력>>");
                                       
                                       //죽일 카드를 선택
                                       int deadCard = s.nextInt();
                                       //죽일 카드가 1번일 때
                                       if(deadCard == 1)
                                       {
                                    	   players.get(op).myJob.remove(0);
                                    	   common.isPlayerDead(players.get(op), players);
                                       }
                                       //죽일 카드가 2번 일때
                                       else if(deadCard == 2)
                                       {
                                    	   players.get(op).myJob.remove(1);
                                       }
                                       
                                       System.out.println();
                            		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
                            		   players.get(cp).coin += 3;
            						   
            					   }
            					   //보여주는 2번카드가 공작이 아닐 때
            					   else if(players.get(cp).myJob.get(1).jobName != "공작")
            					   {
            						   System.out.println();
            						   System.out.println(players.get(cp).name + "님이 공작이 없다는 사실이 들통났습니다!");
            						   System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
            						   players.get(cp).myJob.remove(1);
            						   System.out.println();
            						   System.out.println(players.get(op).name + "님이 도전을 성공했습니다!");
            					   }
            				   }
            				   ////다음 차례에게 또 질문하지 않도록 for문을 탈출
            				   break;
            			   }
            			   
            			   //도전하지 않음
            			   else if (selectChallNum == 2)
            			   {
            				   count++;
            			   }
            		   }//op들을 호출하는 if문의 끝
            	   }//op들을 호출하는 for문의 끝
            	   
            	   if(count == players.size() - 1)
            	   {
            		   System.out.println();
            		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
            		   players.get(cp).coin += 3;
            		   count = 0;
            	   }
            	   else
            	   {
            		   count = 0;
            	   }
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
                                          
                                         // 도전을 실패한 플레이어가 죽었는지를 판단
                                         common.isPlayerDead(players.get(op), players);
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
                                      
                                     //도전받은 플레이어가 죽었는지를 판단
                                      common.isPlayerDead(players.get(cp), players);
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
                                          
                                         //도전을 실패한 플레이어가 죽었는지를 판단함
                                          common.isPlayerDead(players.get(op), players);
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
                 if(count == players.size() - 1) {
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
               else if(actionNumber2 == 3) {
                  System.out.println("\n갈취할 플레이어의 닉네임을 입력하세요");
                  String userNameToSteal = s.nextLine();
               }else if(actionNumber2 == 4) {
                  System.out.println("\n암살할 플레이어의 닉네임을 입력하세요");
                  String userNameToAssasination = s.nextLine();
      
               }
            }
            
            
         } //cp for문의 끝
         
         if(players.size() == 1) {
            System.out.println("\n"+players.get(0).name + "님의 세력이 마지막까지 살아남았습니다. \n" + players.get(0).name + "님의 승리!"); 
            isGameEnd = false;
         }
      }
     
   } // 게임 매니저 생성자
}