package Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Player.Player;

public class Steal {
	
	public int steal(int cp, int op, ArrayList <Player> players, Scanner s) {
		  System.out.println();
		  System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님이 코인을 갈취하려 합니다. 행동을 선택해주세요.");
		  System.out.println("1.코인 갈취 당하기");
		  System.out.println("2.갈취를 대사로 저지하기");
		  System.out.println("3.갈취를 사령관으로 저지하기");
		  System.out.println("4.사령관의 유무에 대해 도전하기");
		  System.out.print("번호를 입력 >>");
		  
		  //사령관의 유무에 도전할지
		  int challOrBlock = s.nextInt();
		  //2코인을 포기할 때
		  if(challOrBlock == 1)
		  {
			  if(players.get(op).coin == 1)
			  {
				  players.get(op).coin--;
				  players.get(cp).coin++;
				  System.out.println();
				  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
			  }
			  else if(players.get(op).coin >= 2)
			  {
				  players.get(op).coin -= 2;
				  players.get(cp).coin += 2;
				  System.out.println();
				  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
			  }
				
		  }
		  
		  // 갈취를 대사로 저지
		  else if(challOrBlock == 2)
		  {
			  System.out.println();
			  System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 갈취를 대사의 능력으로 저지하려 합니다. " + players.get(op).name + "님의 대사의 유무에 대해 도전하시겠습니까?");
			  System.out.println("1.대사의 유무에 대해 도전하기");
			  System.out.println("2.갈취를 포기하기");
			  System.out.print("번호를 입력 >>");
			  
			  //대사의 유무에 도전할 것인지
			  int chall = s.nextInt();
			  //대사의 유무에 도전할 때
			  if(chall == 1)
			  {
				  System.out.println();
				  System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님이 대사의 유무에 대해 도전해왔습니다. 상대에게 보여줄 카드를 선택하세요.");
				  System.out.println("1." + players.get(op).myJob.get(0).jobName);
				  if(players.get(op).myJob.size() == 2)
				  System.out.println("2." + players.get(op).myJob.get(1).jobName);
				  System.out.print("번호를 입력 >>");
				  
				  //어떤 카드를 보여줄지
				  int drawCard = s.nextInt();
				  //보여주는 카드가 1번 일 때
				  if(drawCard == 1) 
				  {
					  //보여주는 1번 카드가 대사가 맞을 때
					  if(players.get(op).myJob.get(0).jobName == "대사") 
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 대사를 소유하고 있음을 증명했습니다!");
						  System.out.println("보여진 \'대사\'카드를 궁정 덱에서 교환합니다.");
						  
						  //사령관을 궁정덱 카드 한장과 교환하는 과정
                        Player.royalCourtDeck.add(players.get(op).myJob.get(0));
                        players.get(op).myJob.remove(0);
                        Collections.shuffle(Player.royalCourtDeck);
                        players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                        System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                        Player.royalCourtDeck.remove(0);
                        //사령관을 궁정덱 카드 한장과 교환하는 과정
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님이 도전에 실패했습니다.");
                        System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님, 버릴 카드 하나를 선택해주세요.");
                        System.out.println("1." + players.get(cp).myJob.get(0).jobName);
                        if(players.get(cp).myJob.size() == 2)
                        System.out.println("2." + players.get(cp).myJob.get(1).jobName);
                        System.out.print("번호를 입력 >>");
                        
                        //어떤 카드를 버릴지
                        int deadCard = s.nextInt();
                        //1번 카드를 버릴 떄
                        if(deadCard == 1) 
                        {
                      	  players.get(cp).myJob.remove(0);
                      	  
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
                        //2번 카드를 버릴 때
                            if(deadCard == 2)
                            {
                          	  players.get(cp).myJob.remove(1);
                            }
                            

  					  }
  					  //보여주는 1번 카드가 대사가 아닐 때
					  else if(players.get(op).myJob.get(0).jobName != "대사")
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 대사가 없다는 사실이 들통났습니다!");
						  System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
						  
						  System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
						  
						//갈취하는 과정
                  	  if(players.get(op).coin == 1)
                  	  {
                  		  players.get(op).coin--;
                  		  players.get(cp).coin++;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
                  	  }
                  	  else if(players.get(op).coin >= 2)
                  	  {
                  		  players.get(op).coin -= 2;
                  		  players.get(cp).coin += 2;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
                  	  }
                  	  //여기까지 갈취하는 과정
						  
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
				  }
				  
				  // 보여주는 카드가 2번일 때
				  else if(drawCard == 2)
				  {
					//보여주는 2번 카드가 대사가 맞을 때
					  if(players.get(op).myJob.get(1).jobName == "대사") 
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 대사를 소유하고 있음을 증명했습니다!");
						  System.out.println("보여진 \'대사\'카드를 궁정 덱에서 교환합니다.");
						  
						  //사령관을 궁정덱 카드 한장과 교환하는 과정
                        Player.royalCourtDeck.add(players.get(op).myJob.get(1));
                        players.get(op).myJob.remove(1);
                        Collections.shuffle(Player.royalCourtDeck);
                        players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                        System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                        Player.royalCourtDeck.remove(0);
                        //사령관을 궁정덱 카드 한장과 교환하는 과정
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님이 도전에 실패했습니다.");
                        System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님, 버릴 카드 하나를 선택해주세요.");
                        System.out.println("1." + players.get(cp).myJob.get(0).jobName);
                        if(players.get(cp).myJob.size() == 2)
                        System.out.println("2." + players.get(cp).myJob.get(1).jobName);
                        System.out.print("번호를 입력 >>");
                        
                        //어떤 카드를 버릴지
                        int deadCard = s.nextInt();
                        //1번 카드를 버릴 떄
                        if(deadCard == 1) 
                        {
                      	  players.get(cp).myJob.remove(0);
                      	  
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
                        //2번 카드를 버릴 때
                            if(deadCard == 2)
                            {
                          	  players.get(cp).myJob.remove(1);
                            }
                            

  					  }
  					  //보여주는 2번 카드가 대사가 아닐 때
					  else if(players.get(op).myJob.get(1).jobName != "대사")
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 대사가 없다는 사실이 들통났습니다!");
						  System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
						  
						  System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
						  
						//갈취하는 과정
                  	  if(players.get(op).coin == 1)
                  	  {
                  		  players.get(op).coin--;
                  		  players.get(cp).coin++;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
                  	  }
                  	  else if(players.get(op).coin >= 2)
                  	  {
                  		  players.get(op).coin -= 2;
                  		  players.get(cp).coin += 2;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
                  	  }
                  	  //여기까지 갈취하는 과정
                  	  
						  players.get(op).myJob.remove(1);
					  }
				  }
			  }
			  
			  //갈취를 포기할 때
			  else if(chall == 2)
			  {
				  System.out.println();
				  System.out.println( players.get(op).name + "님이 " + players.get(cp).name + "님의 갈취를 저지하였습니다.");
			  }
		  }
		  
		  // 갈취를 사령관으로 저지
		  else if(challOrBlock == 3)
		  {
			  System.out.println();
			  System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 갈취를 사령관의 능력으로 저지하려 합니다. " + players.get(op).name + "님의 사령관의 유무에 대해 도전하시겠습니까?");
			  System.out.println("1.사령관의 유무에 대해 도전하기");
			  System.out.println("2.갈취를 포기하기");
			  System.out.print("번호를 입력 >>");
			  
			  //대사의 유무에 도전할 것인지
			  int chall = s.nextInt();
			  //대사의 유무에 도전할 때
			  if(chall == 1)
			  {
				  System.out.println();
				  System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님이 사령관의 유무에 대해 도전해왔습니다. 상대에게 보여줄 카드를 선택하세요.");
				  System.out.println("1." + players.get(op).myJob.get(0).jobName);
				  if(players.get(op).myJob.size() == 2)
				  System.out.println("2." + players.get(op).myJob.get(1).jobName);
				  System.out.print("번호를 입력 >>");
				  
				  //어떤 카드를 보여줄지
				  int drawCard = s.nextInt();
				  //보여주는 카드가 1번 일 때
				  if(drawCard == 1) 
				  {
					  //보여주는 1번 카드가 대사가 맞을 때
					  if(players.get(op).myJob.get(0).jobName == "사령관") 
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 사령관 소유하고 있음을 증명했습니다!");
						  System.out.println("보여진 \'사령관\'카드를 궁정 덱에서 교환합니다.");
						  
						  //사령관을 궁정덱 카드 한장과 교환하는 과정
                        Player.royalCourtDeck.add(players.get(op).myJob.get(0));
                        players.get(op).myJob.remove(0);
                        Collections.shuffle(Player.royalCourtDeck);
                        players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                        System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                        Player.royalCourtDeck.remove(0);
                        //사령관을 궁정덱 카드 한장과 교환하는 과정
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님이 도전에 실패했습니다.");
                        System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님, 버릴 카드 하나를 선택해주세요.");
                        System.out.println("1." + players.get(cp).myJob.get(0).jobName);
                        if(players.get(cp).myJob.size() == 2)
                        System.out.println("2." + players.get(cp).myJob.get(1).jobName);
                        System.out.print("번호를 입력 >>");
                        
                        //어떤 카드를 버릴지
                        int deadCard = s.nextInt();
                        //1번 카드를 버릴 떄
                        if(deadCard == 1) 
                        {
                      	  players.get(cp).myJob.remove(0);
                      	  
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
                        //2번 카드를 버릴 때
                            if(deadCard == 2)
                            {
                          	  players.get(cp).myJob.remove(1);
                            }
                            

  					  }
  					  //보여주는 1번 카드가 대사가 아닐 때
					  else if(players.get(op).myJob.get(0).jobName != "사령관")
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 사령관이 없다는 사실이 들통났습니다!");
						  System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
						  
						  System.out.println();
						  System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
						  
						//갈취하는 과정
                  	  if(players.get(op).coin == 1)
                  	  {
                  		  players.get(op).coin--;
                  		  players.get(cp).coin++;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
                  	  }
                  	  else if(players.get(op).coin >= 2)
                  	  {
                  		  players.get(op).coin -= 2;
                  		  players.get(cp).coin += 2;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
                  	  }
                  	  //여기까지 갈취하는 과정
						  
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
				  }
				  
				  // 보여주는 카드가 2번일 때
				  else if(drawCard == 2)
				  {
					//보여주는 2번 카드가 대사가 맞을 때
					  if(players.get(op).myJob.get(1).jobName == "사령관") 
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 사령관을 소유하고 있음을 증명했습니다!");
						  System.out.println("보여진 \'사령관\'카드를 궁정 덱에서 교환합니다.");
						  
						  //사령관을 궁정덱 카드 한장과 교환하는 과정
                        Player.royalCourtDeck.add(players.get(op).myJob.get(1));
                        players.get(op).myJob.remove(1);
                        Collections.shuffle(Player.royalCourtDeck);
                        players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                        System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                        Player.royalCourtDeck.remove(0);
                        //사령관을 궁정덱 카드 한장과 교환하는 과정
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님이 도전에 실패했습니다.");
                        System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                        
                        System.out.println();
                        System.out.println(players.get(cp).name + "님, 버릴 카드 하나를 선택해주세요.");
                        System.out.println("1." + players.get(cp).myJob.get(0).jobName);
                        if(players.get(cp).myJob.size() == 2)
                        System.out.println("2." + players.get(cp).myJob.get(1).jobName);
                        System.out.print("번호를 입력 >>");
                        
                        //어떤 카드를 버릴지
                        int deadCard = s.nextInt();
                        //1번 카드를 버릴 떄
                        if(deadCard == 1) 
                        {
                      	  players.get(cp).myJob.remove(0);
                      	  
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
                        //2번 카드를 버릴 때
                            if(deadCard == 2)
                            {
                          	  players.get(cp).myJob.remove(1);
                            }
                            

  					  }
  					  //보여주는 2번 카드가 대사가 아닐 때
					  else if(players.get(op).myJob.get(1).jobName != "사령관")
					  {
						  System.out.println();
						  System.out.println(players.get(op).name + "님이 사령관이 없다는 사실이 들통났습니다!");
						  System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
						  
						  System.out.println();
						  System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
						  
						//갈취하는 과정
                  	  if(players.get(op).coin == 1)
                  	  {
                  		  players.get(op).coin--;
                  		  players.get(cp).coin++;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
                  	  }
                  	  else if(players.get(op).coin >= 2)
                  	  {
                  		  players.get(op).coin -= 2;
                  		  players.get(cp).coin += 2;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
                  	  }
                  	  //여기까지 갈취하는 과정
						  
						  players.get(op).myJob.remove(1);
					  }
				  }
			  }
			  
			  //갈취를 포기할 때
			  else if(chall == 2)
			  {
				  System.out.println();
				  System.out.println( players.get(op).name + "님이 " + players.get(cp).name + "님의 갈취를 저지하였습니다.");
			  }
		  }
		  
		  //사령관의 유무에 대해 도전하기
		  else if(challOrBlock == 4)
		  {
			  System.out.println();
			  System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 사령관의 유무에 대해 도전해왔습니다. 상대에게 보여줄 카드를 선택하세요.");
			  System.out.println("1." + players.get(cp).myJob.get(0).jobName);
			  if(players.get(cp).myJob.size() == 2)
		      System.out.println("2." + players.get(cp).myJob.get(1).jobName); 
			  System.out.print("번호를 입력 >>");
			  
			  //어떤 카드를 보여줄지
			  int drawCard = s.nextInt();
			  //보여주는 카드가 1번 일 때
			  if(drawCard == 1) 
			  {
				  //보여주는 1번 카드가 사령관이 맞을 때
				  if(players.get(cp).myJob.get(0).jobName == "사령관") 
				  {
					  System.out.println();
					  System.out.println(players.get(cp).name + "님이 사령관을 소유하고 있음을 증명했습니다!");
					  System.out.println("보여진 \'사령관\'카드를 궁정 덱에서 교환합니다.");
					  
					  //사령관을 궁정덱 카드 한장과 교환하는 과정
                    Player.royalCourtDeck.add(players.get(cp).myJob.get(0));
                    players.get(cp).myJob.remove(0);
                    Collections.shuffle(Player.royalCourtDeck);
                    players.get(cp).myJob.add(Player.royalCourtDeck.get(0));
                    System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                    Player.royalCourtDeck.remove(0);
                    //사령관을 궁정덱 카드 한장과 교환하는 과정
                    
                    System.out.println();
                    System.out.println(players.get(op).name + "님이 도전에 실패했습니다.");
                    System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                    
                    System.out.println();
                    System.out.println(players.get(op).name + "님, 버릴 카드 하나를 선택해주세요.");
                    System.out.println("1." + players.get(op).myJob.get(0).jobName);
                    if(players.get(op).myJob.size() == 2)
                    System.out.println("2." + players.get(op).myJob.get(1).jobName);
                    System.out.print("번호를 입력 >>");
                    
                    //어떤 카드를 버릴지
                    int deadCard = s.nextInt();
                    //1번 카드를 버릴 떄
                    if(deadCard == 1) 
                    {
                  	  players.get(op).myJob.remove(0);
                  	  
                  	//갈취하는 과정
                        if(players.get(op).coin == 1)
      				  {
      					  players.get(op).coin--;
      					  players.get(cp).coin++;
      					  System.out.println();
      					  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
      				  }
      				  else if(players.get(op).coin >= 2)
      				  {
      					  players.get(op).coin -= 2;
      					  players.get(cp).coin += 2;
      					  System.out.println();
      					  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
      				  }
                        //여기까지 갈취하는 과정
                  	  
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
                    //2번 카드를 버릴 때
                    if(deadCard == 2)
                    {
                  	//갈취하는 과정
                        if(players.get(op).coin == 1)
      				  {
      					  players.get(op).coin--;
      					  players.get(cp).coin++;
      					  System.out.println();
      					  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
      				  }
      				  else if(players.get(op).coin >= 2)
      				  {
      					  players.get(op).coin -= 2;
      					  players.get(cp).coin += 2;
      					  System.out.println();
      					  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
      				  }
                        //여기까지 갈취하는 과정
                        
                  	  players.get(op).myJob.remove(1);
                    }
                    

  					  }
  					  //보여주는 1번 카드가 사령관이 아닐 때
				  else if(players.get(cp).myJob.get(0).jobName != "사령관")
				  {
					  System.out.println();
					  System.out.println(players.get(cp).name + "님이 사령관이 없다는 사실이 들통났습니다!");
					  System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
					  
					  System.out.println();
					  System.out.println(players.get(op).name + "님이 도전에 성공했습니다!");
					  
					  players.get(cp).myJob.remove(0);
					  
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
			  
			  else if(drawCard == 2)
			  {
				  //보여주는 2번 카드가 사령관이 맞을 때
				  if(players.get(cp).myJob.get(1).jobName == "사령관") 
				  {
					  System.out.println();
					  System.out.println(players.get(cp).name + "님이 사령관을 소유하고 있음을 증명했습니다!");
					  System.out.println("보여진 \'사령관\'카드를 궁정 덱에서 교환합니다.");
					  
					  //사령관을 궁정덱 카드 한장과 교환하는 과정
                    Player.royalCourtDeck.add(players.get(cp).myJob.get(1));
                    players.get(cp).myJob.remove(1);
                    Collections.shuffle(Player.royalCourtDeck);
                    players.get(cp).myJob.add(Player.royalCourtDeck.get(0));
                    System.out.println("궁정 덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                    Player.royalCourtDeck.remove(0);
                    //사령관을 궁정덱 카드 한장과 교환하는 과정
                    
                    System.out.println();
                    System.out.println(players.get(op).name + "님이 도전에 실패했습니다.");
                    System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                    
                    System.out.println();
                    System.out.println(players.get(op).name + "님, 버릴 카드 하나를 선택해주세요.");
                    System.out.println("1." + players.get(op).myJob.get(0).jobName);
                    if(players.get(op).myJob.size() == 2)
                    System.out.println("2." + players.get(op).myJob.get(1).jobName);
                    System.out.print("번호를 입력 >>");
                    
                    //어떤 카드를 버릴지
                    int deadCard = s.nextInt();
                    //1번 카드를 버릴 떄
                    if(deadCard == 1) 
                    {
                  	  
                  	//갈취하는 과정
                  	  if(players.get(op).coin == 1)
                  	  {
                  		  players.get(op).coin--;
                  		  players.get(cp).coin++;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
                  	  }
                  	  else if(players.get(op).coin >= 2)
                  	  {
                  		  players.get(op).coin -= 2;
                  		  players.get(cp).coin += 2;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
                  	  }
                  	  //여기까지 갈취하는 과정
                  	  
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
                    //2번 카드를 버릴 때
                    if(deadCard == 2)
                    {
                  	//갈취하는 과정
                  	  if(players.get(op).coin == 1)
                  	  {
                  		  players.get(op).coin--;
                  		  players.get(cp).coin++;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 1코인을 갈취 당하였습니다.");
                  	  }
                  	  else if(players.get(op).coin >= 2)
                  	  {
                  		  players.get(op).coin -= 2;
                  		  players.get(cp).coin += 2;
                  		  System.out.println();
                  		  System.out.println(players.get(op).name + "님이 "+ players.get(cp).name + "님에게 2코인을 갈취 당하였습니다.");
                  	  }
                  	  //여기까지 갈취하는 과정
                  	  
                  	  players.get(op).myJob.remove(1);
                    }
                    
				  }
				  //보여주는 2번 카드가 사령관이 아닐 때
				  else if(players.get(cp).myJob.get(1).jobName != "사령관")
				  {
					  System.out.println();
					  System.out.println(players.get(cp).name + "님이 사령관이 없다는 사실이 들통났습니다!");
					  System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
					  
					  System.out.println();
					  System.out.println(players.get(op).name + "님이 도전에 성공했습니다!");
					  
					  players.get(cp).myJob.remove(1);
				  }
			  }
		  }
		  
		  return cp;
	}
}
