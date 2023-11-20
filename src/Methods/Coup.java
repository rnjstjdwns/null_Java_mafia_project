package Methods;

import java.util.ArrayList;

import Player.Player;

public class Coup {
   public void sayCoupTargetJobTwo(Player currentPlayer, Player targetPlayer) {
      currentPlayer.coin-=7;
       System.out.print("\n"+ currentPlayer.name + "님이 " + targetPlayer.name + "님의 세력에 쿠데타를 일으켰습니다! \n\n"
                          + targetPlayer.name + "님, 버릴 카드 하나를 선택해주세요. \n1. "
                        + targetPlayer.myJob.get(0).jobName + " 2. " + 
                        targetPlayer.myJob.get(1).jobName + "\n번호를 입력>>");
       
   }
   public void sayCoupTargetJobOne(Player currentPlayer, Player targetPlayer) {
      currentPlayer.coin-=7;
         if (targetPlayer.myJob.size() == 1) {
               System.out.print("\n"+ currentPlayer.name + "님이 " + targetPlayer.name + "님의 세력에 쿠데타를 일으켰습니다! \n\n"
                           + targetPlayer.name + "님, 버릴 카드 하나를 선택해주세요. \n1. " 
                           + targetPlayer.myJob.get(0).jobName + "\n번호를 입력>>");
           }
   }
      public void coup(Player currentPlayer, Player targetPlayer, int deadCardNum, ArrayList <Player> players, int cp, int op) {
           if(deadCardNum == 1) {
              System.out.println("\n" + targetPlayer.myJob.get(0).jobName + " 카드를 잃었습니다.");
              targetPlayer.myJob.remove(0);
               if(targetPlayer.myJob.isEmpty() == true) {
                     System.out.println("\n"+targetPlayer.name + "님의 세력이 패배하였습니다."); 
                     players.remove(targetPlayer);
                     if(cp<op) {
                        cp--;
                     }
                  }
           } else if(deadCardNum == 2) {
              System.out.println("\n" + targetPlayer.myJob.get(1).jobName + " 카드를 잃었습니다.");
               targetPlayer.myJob.remove(1);
               
           }
           
       }
}