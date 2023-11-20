package Methods;

import java.util.ArrayList;
import java.util.Collections;
import Player.Player;

public class Mulligan {
   
   //대사의 능력을 사용하기위한 메소드들.
   public void myJobAdd(Player currentPlayer) {
       //궁정덱을 섞음.
       Collections.shuffle(Player.royalCourtDeck);
       Collections.shuffle(Player.royalCourtDeck);
       Collections.shuffle(Player.royalCourtDeck);
         
       //궁정덱에서 카드 2장을 가져옴.
       currentPlayer.myJob.add(Player.royalCourtDeck.get(6));
       currentPlayer.myJob.add(Player.royalCourtDeck.get(5));
       System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(6).jobName + "카드를 가져왔습니다.");
       System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(5).jobName + "카드를 가져왔습니다.");
       Player.royalCourtDeck.remove(6);
       Player.royalCourtDeck.remove(5);
   }
   public void askSelectCardBetweenFour(Player currentPlayer) {
      //4장의 카드중 가져올 카드 2장을 선택.
      System.out.print("\n궁정덱에서 2장의 카드를 가져왔습니다!\n가져올 2장의 카드를 선택해주세요.\n\n1."
                          + currentPlayer.myJob.get(0).jobName + " 2." + currentPlayer.myJob.get(1).jobName
                          + " 3." + currentPlayer.myJob.get(2).jobName + " 4." + currentPlayer.myJob.get(3).jobName
                          + "\n\n카드 번호를 2개 입력해주세요>>");
   }
   public void askSelectCardBetweenThree(Player currentPlayer) {
      //3장의 카드중 가져올 카드 1장을 선택.
      System.out.print("\n궁정덱에서 2장의 카드를 가져왔습니다!\n가져올 1장의 카드를 선택해주세요.\n\n1."
                          + currentPlayer.myJob.get(0).jobName + " 2." + currentPlayer.myJob.get(1).jobName
                          + " 3." + currentPlayer.myJob.get(2).jobName+ "\n\n카드 번호를 1개 입력해주세요>>");
   }
   public void unselectCardUndoBetweenFour(Player currentPlayer, int selectCard1, int selectCard2) {
      ArrayList <Integer> Box = new ArrayList <> (4);
      Box.add(0);
      Box.add(1);
      Box.add(2);
      Box.add(3);
      
      
      int removeCard1= 0;
      int removeCard2= 0;
       
      selectCard1 -= 1;
       selectCard2 -= 1;
         
         //선택하지않은 카드를 다시 궁정덱에 넣음.
          
          for(int i = 0; i < Box.size(); i++) {
             if(Box.get(i) == selectCard1 || Box.get(i) == selectCard2) {
                Box.remove(i);
                break;
             }
          }
          for(int i = 0; i < Box.size(); i++) {
             if(Box.get(i) == selectCard1 || Box.get(i) == selectCard2) {
                Box.remove(i);
                break;
             }
          }
         
         removeCard1 = Box.get(0);
         removeCard2 = Box.get(1);
         
         Player.royalCourtDeck.add(currentPlayer.myJob.get(removeCard1));
         Player.royalCourtDeck.add(currentPlayer.myJob.get(removeCard2));
         currentPlayer.myJob.remove(removeCard2);
         currentPlayer.myJob.remove(removeCard1);
         System.out.println("\n현재 내가 가지고 있는 카드 : " + currentPlayer.myJob.get(0).jobName +", " + currentPlayer.myJob.get(1).jobName);
          
   }
   public void unselectCardUndoBetweenThree(Player currentPlayer, int selectCard1) {
      ArrayList <Integer> Box = new ArrayList <> (3);
      Box.add(0);
      Box.add(1);
      Box.add(2);
      
      
      int removeCard1= 0;
      int removeCard2= 0;
       
      selectCard1 -= 1;
         
         //선택하지않은 카드를 다시 궁정덱에 넣음.
          
       for(int i = 0; i < Box.size(); i++) {
          if(Box.get(i) == selectCard1) {
             Box.remove(i);
             break;
          }
       }
       for(int i = 0; i < Box.size(); i++) {
          if(Box.get(i) == selectCard1) {
             Box.remove(i);
             break;
          }
       }
         
       removeCard1 = Box.get(0);
       removeCard2 = Box.get(1);
         
       Player.royalCourtDeck.add(currentPlayer.myJob.get(removeCard1));
       Player.royalCourtDeck.add(currentPlayer.myJob.get(removeCard2));
       currentPlayer.myJob.remove(removeCard2);
       currentPlayer.myJob.remove(removeCard1);
       
       System.out.println("\n현재 내가 가지고 있는 카드 : " + currentPlayer.myJob.get(0).jobName);
       }
   
   public void askChallengeAboutMulligan(Player currentPlayer, Player otherPlayer) {
         System.out.print("\n" + otherPlayer.name + "님! "+ currentPlayer.name 
                   + "님이 대사의 교환 능력을 사용하려고합니다. " + currentPlayer.name + "님의 대사의 유무에 대해 도전하시겠습니까?"
                   +"\n1.대사의 유무에 대해 도전하기\n2.도전하지 않기\n번호를 입력 >>");
      }
   
   //도전에 사용하기위한 메소드들.
   public void selectDrawCardBetweenTwo(Player currentPlayer, Player otherPlayer) {
         System.out.print("\n"+ currentPlayer.name+"님! "+ otherPlayer.name + "님이 대사의 유무에 대해 도전해왔습니다. 상대에게 보여줄"
                  + " 카드를 선택하세요. \n1. " + currentPlayer.myJob.get(0).jobName + " 2. " + 
                  currentPlayer.myJob.get(1).jobName + "\n번호를 입력>>");   
   }
   
   public void selectDrawCardBetweenOne(Player currentPlayer, Player otherPlayer) {
         System.out.print("\n"+ currentPlayer.name +"님! "+ otherPlayer.name + "님이 대사의 유무에 대해 도전해왔습니다. 상대에게 보여줄"
                  + " 카드를 선택하세요. \n1. " + currentPlayer.myJob.get(0).jobName + "\n번호를 입력>>");
   }
   
   public void proveFirstIsMulligan(Player currentPlayer, Player otherPlayer) {
         System.out.println("\n" + currentPlayer.name + "님이 대사를 소유하고 있음을 증명했습니다!\n"
                   +"보여진 \'대사\'카드를 궁정 덱에서 교환합니다.\n");
           Player.royalCourtDeck.add(currentPlayer.myJob.get(0));
           currentPlayer.myJob.remove(0);
           Collections.shuffle(Player.royalCourtDeck);
           currentPlayer.myJob.add(Player.royalCourtDeck.get(0));
           System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
           Player.royalCourtDeck.remove(0);

           System.out.println("\n"+ otherPlayer.name + "님이 도전에 실패했습니다. \n"
                   + "패배의 댓가로 카드를 하나 잃습니다.");
           
   }
   
   public void proveFirstIsNotMulligan(Player currentPlayer, Player otherPlayer) {
         
        System.out.println("\n" + currentPlayer.name + "님에게 대사가 없다는 사실이 들통났습니다."
                +"\n상대에게 보여진 카드 하나를 잃습니다.\n\n"+otherPlayer.name + "님은 도전을 성공했습니다!");
        
        currentPlayer.myJob.remove(0);
    }
   
   public void proveSecondIsMulligan(Player currentPlayer, Player otherPlayer) {
         System.out.println("\n"+currentPlayer.name + "님이 대사를 소유하고 있음을 증명했습니다!\n"
                   +"보여진 \'대사\'카드를 궁정 덱에서 교환합니다.\n");
           Player.royalCourtDeck.add(currentPlayer.myJob.get(1));
           currentPlayer.myJob.remove(1);
           Collections.shuffle(Player.royalCourtDeck);
           currentPlayer.myJob.add(Player.royalCourtDeck.get(0));
           System.out.println("궁정덱에서 " + Player.royalCourtDeck.get(0).jobName + "카드를 가져왔습니다.");
           Player.royalCourtDeck.remove(0);

           System.out.println("\n"+ otherPlayer.name + "님이 도전에 실패했습니다. \n"
                   + "패배의 댓가로 카드를 하나 잃습니다.");
           
      }
   
   public void proveSecondIsNotMulligan(Player currentPlayer, Player otherPlayer) {
         
         System.out.println("\n" + currentPlayer.name + "님에게 대사가 없다는 사실이 들통났습니다."
                   +"\n상대에게 보여진 카드 하나를 잃습니다.\n\n"+otherPlayer.name + "님은 도전을 성공했습니다!");
           
           currentPlayer.myJob.remove(1);
   }
}
       

   
