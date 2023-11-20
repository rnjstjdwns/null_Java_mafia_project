package Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Player.Player;

public class Assassination {
   public int assassination(int cp, int op, ArrayList <Player> players, Scanner s) {
      players.get(cp).coin-=3;
      
      System.out.println();
      System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님이 암살을 시도했습니다! 행동을 선택해주세요.");
      System.out.println("1.암살당하기");
      System.out.println("2.백작부인으로 저지하기");
      System.out.println("3.암살자의 유무에 대해 도전하기");
      System.out.print("번호를 입력 >>");
      
        int blockNum = s.nextInt();
      
        //1번 암살당하기를 선택한 경우
        if(blockNum == 1) {
           
           //암살하는 과정
            System.out.println();
           System.out.print(players.get(op).name + "님이 " + players.get(cp).name + "님에게 암살 당했습니다!");
           System.out.println();
           System.out.println(players.get(op).name + "님, 버릴 카드 하나를 선택해주세요.");
           System.out.println("1. " + players.get(op).myJob.get(0).jobName);
           if(players.get(op).myJob.size() == 2) {
           System.out.println("2. " + players.get(op).myJob.get(1).jobName);
           }
           System.out.print("번호를 입력>>");
           //암살당할 카드번호를 입력받을 스캐너
           int deadCardNum = s.nextInt();
            
           //암살당할 카드번호가 1일 때
            if(deadCardNum == 1) {
               System.out.println("\n" + players.get(op).myJob.get(0).jobName + " 카드를 잃었습니다.");
               players.get(op).myJob.remove(0);
               if(players.get(op).myJob.isEmpty() == true) {
                      System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                      players.remove(players.get(op));
                     if(cp > op) {
                       cp--;
                    }
                   }
            } 
            
            //암살당할 카드번호가 2일 때
            else if(deadCardNum == 2) {
                    System.out.println("\n" + players.get(op).myJob.get(1).jobName + " 카드를 잃었습니다.");
                    players.get(op).myJob.remove(1);
                
            }
           
           //여기까지 암살하는 과정
        }
        
        //2번 저지하기를 선택한 경우
        else if(blockNum == 2) {
         System.out.println();
              System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 암살을 백작부인의 능력으로 저지하려 합니다. " + players.get(op).name + "님의 백작부인의 유무에 대해 도전하시겠습니까?");
              System.out.println("1.백작부인의 유무에 대해 도전하기");
              System.out.println("2.암살을 포기하기");
              System.out.print("번호를 입력 >>");
              
              //백작부인의 유무에 도전할 것인지
              int chall = s.nextInt();
              
              //백작부인의 유무에 도전할 때
              if(chall == 1)
              {
                 System.out.println();
                 System.out.println(players.get(op).name + "님! " + players.get(cp).name + "님이 백작부인의 유무에 대해 도전해왔습니다. 상대에게 보여줄 카드를 선택하세요.");
                 System.out.println("1." + players.get(op).myJob.get(0).jobName);
                 if(players.get(op).myJob.size() == 2) {
                 System.out.println("2." + players.get(op).myJob.get(1).jobName);
                 }
                 System.out.print("번호를 입력 >>");
                 //어떤 카드를 보여줄지
                 int drawCard = s.nextInt();
                 //보여주는 카드가 1번 일 때
                 if(drawCard == 1) 
                 {
                    //보여주는 1번 카드가 백작부인이 맞을 때
                    if(players.get(op).myJob.get(0).jobName == "백작부인") 
                    {
                       System.out.println();
                       System.out.println(players.get(op).name + "님이 백작부인을 소유하고 있음을 증명했습니다!");
                       System.out.println("보여진 \'백작부인\'카드를 궁정 덱에서 교환합니다.");
                       
                       //백작부인을 궁정덱 카드 한장과 교환하는 과정
                           Player.royalCourtDeck.add(players.get(op).myJob.get(0));
                           players.get(op).myJob.remove(0);
                           Collections.shuffle(Player.royalCourtDeck);
                           players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                           System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                           Player.royalCourtDeck.remove(0);
                           //백작부인을 궁정덱 카드 한장과 교환하는 과정
                           
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
                      //보여주는 1번 카드가 백작부인이 아닐 때
                    else if(players.get(op).myJob.get(0).jobName != "백작부인")
                    {
                       System.out.println();
                       System.out.println(players.get(op).name + "님이 백작부인이 없다는 사실이 들통났습니다!");
                       
                       //카드가 두장일때 두장 전부 제거
                       if(players.get(op).myJob.size() == 2) {
                          System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
                          System.out.println("백작부인의 유무에 대해 " + players.get(cp).name + "님의 도전 성공 댓가와 암살 능력으로 카드 두장을 모두 잃습니다.");
                          //카드 두장을 전부 제거되므로 암살당한 플레이어는 탈락됨
                          players.get(op).myJob.remove(1);
                          players.get(op).myJob.remove(0);
                          System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                          players.remove(op);
                          if(cp > op) {
                             cp--;
                          }
                       }
                       
                       //카드가 한장일때 카드 제거
                       else if(players.get(op).myJob.size() == 1) {
                          System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
                          System.out.println("백작부인의 유무에 대해 " + players.get(cp).name + "님의 도전 성공 댓가로 카드 한장을 잃습니다.");
                          players.get(op).myJob.remove(0);
                          System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                          players.remove(op);
                          if(cp > op) {
                             cp--;
                          }
                       }
                    }
                 }
                 
                 // 보여주는 카드가 2번일 때
                 else if(drawCard == 2)
                 {
                  //보여주는 2번 카드가 백작부인이 맞을 때
                    if(players.get(op).myJob.get(1).jobName == "백작부인") 
                    {
                       System.out.println();
                       System.out.println(players.get(op).name + "님이 백작부인을 소유하고 있음을 증명했습니다!");
                       System.out.println("보여진 \'백작부인\'카드를 궁정 덱에서 교환합니다.");
                       
                       //백작부인을 궁정덱 카드 한장과 교환하는 과정
                           Player.royalCourtDeck.add(players.get(op).myJob.get(1));
                           players.get(op).myJob.remove(1);
                           Collections.shuffle(Player.royalCourtDeck);
                           players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                           System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                           Player.royalCourtDeck.remove(0);
                           //백작부인을 궁정덱 카드 한장과 교환하는 과정
                           
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
                              
                              //플레이어가 죽으면 콜렉션에서 제거
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
                      //보여주는 2번 카드가 백작부인이 아닐 때
                    else if(players.get(op).myJob.get(1).jobName != "백작부인")
                    {
                       System.out.println();
                       System.out.println(players.get(op).name + "님이 백작부인이 없다는 사실이 들통났습니다!");
                       System.out.println();
                       
                       System.out.println(players.get(cp).name + "님이 도전에 성공했습니다!");
                       
                     //카드가 두장일때 두장 전부 제거
                       if(players.get(op).myJob.size() == 2) {
                          System.out.println("백작부인의 유무에 대해 " + players.get(cp).name + "님의 도전 성공 댓가와 암살 능력으로 카드 두장을 모두 잃습니다.");
                          //카드 두장을 전부 제거되므로 암살당한 플레이어는 탈락됨
                          players.get(op).myJob.remove(1);
                          players.get(op).myJob.remove(0);
                          System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                          players.remove(op);
                          if(cp > op) {
                             cp--;
                          }
                       }
                       
                       //카드가 한장일때 카드 제거
                       else if(players.get(op).myJob.size() == 1) {
                          System.out.println("백작부인의 유무에 대해 " + players.get(cp).name + "님의 도전 성공 댓가로 카드 한장을 잃습니다.");
                          players.get(op).myJob.remove(0);
                          System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                          players.remove(op);
                          if(cp > op) {
                             cp--;
                          }
                       }
                    } //보여주는 2번 카드가 백작부인이 아닐 때 끝
                 }
              } //1번 백작부인의 유무에 대해 도전한 경우 끝
              
              //2번 암살을 포기하기를 선택한 경우
              else if(chall == 2)
              {
                 System.out.println();
                 System.out.println( players.get(op).name + "님이 " + players.get(cp).name + "님의 암살을 저지하였습니다.");
              }
           
      }//2번 저지하기 끝
      
      //3번 암살자의 유무에 대해 도전한 경우
        else if(blockNum == 3) {
           
            //암살자의 유무에 도전할 때
              System.out.println();
              System.out.println(players.get(cp).name + "님! " + players.get(op).name + "님이 암살자의 유무에 대해 도전해왔습니다. 상대에게 보여줄 카드를 선택하세요.");
              System.out.println("1." + players.get(cp).myJob.get(0).jobName);
              if(players.get(cp).myJob.size() == 2) {
                 System.out.println("2." + players.get(cp).myJob.get(1).jobName);
              }
              System.out.print("번호를 입력 >>");
              //어떤 카드를 보여줄지
              int drawCard = s.nextInt();
              //보여주는 카드가 1번 일 때
              if(drawCard == 1) 
              {
                 //보여주는 1번 카드가 암살자가 맞을 때
                 if(players.get(cp).myJob.get(0).jobName == "암살자") 
                 {
                    System.out.println();
                    System.out.println(players.get(cp).name + "님이 암살자를 소유하고 있음을 증명했습니다!");
                    System.out.println("보여진 \'암살자\'카드를 궁정 덱에서 교환합니다.");
                    
                    //암살자를 궁정덱 카드 한장과 교환하는 과정
                        Player.royalCourtDeck.add(players.get(op).myJob.get(0));
                        players.get(op).myJob.remove(0);
                        Collections.shuffle(Player.royalCourtDeck);
                        players.get(op).myJob.add(Player.royalCourtDeck.get(0));
                        System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                        Player.royalCourtDeck.remove(0);
                        //암살자를 궁정덱 카드 한장과 교환하는 과정
                        
                        System.out.println();
                        System.out.println(players.get(op).name + "님이 도전에 실패했습니다.");
                        System.out.println("패배의 댓가로 카드 하나를 잃습니다.");
                        
                        System.out.println();
                        System.out.println(players.get(op).name + "님, 버릴 카드 하나를 선택해주세요.");
                        System.out.println("1." + players.get(op).myJob.get(0).jobName);
                        if(players.get(op).myJob.size() == 2) {
                           System.out.println("2." + players.get(op).myJob.get(1).jobName);
                        }
                        System.out.print("번호를 입력 >>");
                        
                        //어떤 카드를 버릴지
                        int deadCard = s.nextInt();
                        //1번 카드를 버릴 떄
                        if(deadCard == 1) 
                        {
                           players.get(op).myJob.remove(0);
                           
                           //플레이어가 죽으면 콜렉션에서 제거
                           if (players.get(op).myJob.isEmpty()) 
                           {
                             System.out.println();
                              System.out.println(players.get(op).name + "님의 세력이 패배하였습니다.");
                              players.remove(players.get(op));
                              if(cp > op) {
                               cp--;
                            }
                           }
                            //제거 끝
                        }
                        //2번 카드를 버릴 때
                            if(deadCard == 2)
                            {
                               players.get(op).myJob.remove(1);
                            }
                            

                   }
                   //보여주는 1번 카드가 암살자가 아닐 때
                 else if(players.get(cp).myJob.get(0).jobName != "암살자")
                 {
                    System.out.println();
                    System.out.println(players.get(cp).name + "님이 암살자가 없다는 사실이 들통났습니다!");
                    
                    //카드가 두장일때
                    if(players.get(cp).myJob.size() == 2) {
                       
                       System.out.println(players.get(op).name + "님이 도전에 성공했습니다!");
                       System.out.println("암살자의 유무에 대해 " + players.get(op).name + "님의 도전 성공 댓가로 " + players.get(cp).name + "님의 카드 한장을 잃습니다.");
                       
                       //선택했던 1번 카드 한장을 제거
                       players.get(cp).myJob.remove(0);
                       
                    }
                    
                    //카드가 한장일때 카드 제거 후 도전당한 플레이어 탈락
                    else if(players.get(cp).myJob.size() == 1) {
                       System.out.println(players.get(op).name + "님이 도전에 성공했습니다!");
                       System.out.println("암살자의 유무에 대해 " + players.get(op).name + "님의 도전 성공 댓가로 " + players.get(cp).name + "님의 카드 한장을 잃습니다.");
                       players.get(cp).myJob.remove(0);
                       System.out.println("\n"+players.get(cp).name + "님의 세력이 패배하였습니다."); 
                       players.remove(cp);
                       cp--;
                    }
                 } //보여주는 1번 카드가 암살자가 아닐 때 끝
              }
              
              // 보여주는 카드가 2번일 때
              else if(drawCard == 2)
              {
               //보여주는 2번 카드가 암살자가 맞을 때
                 if(players.get(cp).myJob.get(1).jobName == "암살자") 
                 {
                    System.out.println();
                    System.out.println(players.get(cp).name + "님이 암살자를 소유하고 있음을 증명했습니다!");
                    System.out.println("보여진 \'암살자\'카드를 궁정 덱에서 교환합니다.");
                    
                    //암살자를 궁정덱 카드 한장과 교환하는 과정
                        Player.royalCourtDeck.add(players.get(cp).myJob.get(1));
                        players.get(cp).myJob.remove(1);
                        Collections.shuffle(Player.royalCourtDeck);
                        players.get(cp).myJob.add(Player.royalCourtDeck.get(0));
                        System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
                        Player.royalCourtDeck.remove(0);
                        //암살자를 궁정덱 카드 한장과 교환하는 과정
                        
                      //카드가 두장일때 두장 전부 제거
                       if(players.get(op).myJob.size() == 2) {
                          System.out.println(players.get(op).name + "님이 도전에 실패했습니다!");
                          System.out.println("암살자의 유무에 대해 " + players.get(op).name + "님의 도전 실패 댓가와 암살 능력으로 카드 두장을 모두 잃습니다.");
                          //카드 두장을 전부 제거되므로 암살당한 플레이어는 탈락됨
                          players.get(op).myJob.remove(1);
                          players.get(op).myJob.remove(0);
                          System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                          players.remove(op);
                          if(cp > op) {
                             cp--;
                          }
                       }
                       
                       //카드가 한장일때 카드 제거
                       else if(players.get(op).myJob.size() == 1) {
                          System.out.println(players.get(cp).name + "님이 도전에 실패했습니다!");
                          System.out.println("암살자의 유무에 대해 " + players.get(op).name + "님의 도전 실패 댓가로 카드 한장을 잃습니다.");
                          players.get(op).myJob.remove(0);
                          System.out.println("\n"+players.get(op).name + "님의 세력이 패배하였습니다."); 
                          players.remove(op);
                          if(cp > op) {
                             cp--;
                          }
                       }
                   }
                   //보여주는 2번 카드가 암살자가 아닐 때
                 else if(players.get(cp).myJob.get(1).jobName != "암살자")
                 {
                    System.out.println();
                    System.out.println(players.get(cp).name + "님이 암살자가 없다는 사실이 들통났습니다!");
                    System.out.println("상대에게 보여진 카드 하나를 잃습니다.");
                    System.out.println();
                    System.out.println(players.get(op).name + "님이 도전에 성공했습니다!");
                    
                    System.out.println();
                    System.out.println(players.get(cp).name + "님, 버릴 카드 하나를 선택해주세요.");
                    System.out.println("1." + players.get(cp).myJob.get(0).jobName);
                    if(players.get(cp).myJob.size() == 2) {
                       System.out.println("2." + players.get(cp).myJob.get(1).jobName);
                    }
                    System.out.print("번호를 입력 >>");
                    
                    //어떤 카드를 버릴지
                    int deadCard = s.nextInt();
                    //1번 카드를 버릴 떄
                    if(deadCard == 1) 
                    {
                       players.get(cp).myJob.remove(0);
                       
                       //플레이어가 죽으면 콜렉션에서 제거
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
                 } // 보여주는 2번 카드가 암살자가 아닐 때 끝
              } //보여주는 카드가 2번일 때 끝
        }//1번 백작부인의 유무에 대해 도전한 경우 끝
   return cp;
   }
}