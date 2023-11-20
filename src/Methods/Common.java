package Methods;

import java.util.ArrayList;

import Player.Player;

public class Common {

   public void isPlayerDead(Player p, ArrayList <Player> players ) {
      if(p.myJob.isEmpty() == true) {
              System.out.println("\n"+p.name + "님의 세력이 패배하였습니다."); 
              players.remove(p);
           }
   }
   
   public void selectDeadCardBetweenTwo(Player p) {
      System.out.print("\n"+ p.name+"님, 버릴 카드 하나를 선택해주세요. \n1. " 
                + p.myJob.get(0).jobName + " 2. " + 
                p.myJob.get(1).jobName + "\n번호를 입력>>");
   }
   
   public void selectDeadCardBetweenOne(Player p) {
      System.out.print("\n"+ p.name+"님, 버릴 카드 하나를 선택해주세요. \n1. " 
                + p.myJob.get(0).jobName + "\n번호를 입력>>");
      
   }
   
}
