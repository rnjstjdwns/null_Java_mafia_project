package Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Player.Player;

public class TaxCollection {

	public int taxCollection (int cp, ArrayList <Player> players, Scanner s, int count) {
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
                            System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
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
                            	System.out.println();
                      		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
                      		   players.get(cp).coin += 3;
                      		   
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
                            }
                            //죽일 카드가 2번 일때
                            else if(deadCard == 2)
                            {
                         	   players.get(op).myJob.remove(1);
                         	   System.out.println();
                    		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
                    		   players.get(cp).coin += 3;
                            }
                            
                            
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
 						   if (players.get(cp).myJob.isEmpty() == true) {
 						    	System.out.println();
 						        System.out.println(players.get(cp).name + "님의 세력이 패배하였습니다.");
 						        players.remove(players.get(cp));
 						        cp--;
 						   }            						   
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
                            System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
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
                            	System.out.println();
                      		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
                      		   players.get(cp).coin += 3;
                      		   
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
                            }
                            //죽일 카드가 2번 일때
                            else if(deadCard == 2)
                            {
                         	   players.get(op).myJob.remove(1);
                         	   
                         	  System.out.println();
                    		   System.out.println(players.get(cp).name + "님이 공작의 능력으로 세금 징수에 성공했습니다!");
                    		   players.get(cp).coin += 3;
                            }

 						   
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
 				   //다음 차례에게 또 질문하지 않도록 for문을 탈출
 				   break;
 			   }
 			   
 			   //도전하지 않음
 			   else if (selectChallNum == 2)
 			   {
 				   count++;
 			   }
 		   }//op들을 호출하는 if문의 끝
 	   }//op들을 호출하는 for문의 끝
 	   
 	   if(count == players.size() - 1 && players.size() != 1)
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
 	   return cp;
	}
}
