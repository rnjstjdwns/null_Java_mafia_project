package Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Player.Player;

public class OutsideAid {

	public int outsideAid (int cp, ArrayList <Player> players, Scanner s, int count) {
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
                 System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 외부원조를 저지하려 합니다. " 
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
                            System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
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
                          
                          //플레이가 죽으면 콜렉션에서 제거
                          if (players.get(op).myJob.isEmpty()) 
                          {
                  	    	System.out.println();
                  	        System.out.println(players.get(op).name + "님의 세력이 패배하였습니다.");
                  	        players.remove(players.get(op));
                  	      if (cp > op) 
              	        	cp--;
                          }
                          //제거 끝
                          
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
                            System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
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
                            else if(selectDeadCardNum == 2)
                            {
                               players.get(cp).myJob.remove(1);
                            }

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
        
        if(count == players.size() - 1 && players.size() != 1)
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
	
	return cp;
	}
}
