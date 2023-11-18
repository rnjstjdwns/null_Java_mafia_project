package Methods;

import java.util.ArrayList;
import java.util.Collections;

import Player.Player;

public class OutsideAid {
	
	public void success(Player currentPlayer, ArrayList <Player> players, int count) {
		if(count == players.size() - 1) {
			System.out.println(currentPlayer.name +"님이 외부원조로 코인을 2개 가져왔습니다.");
            currentPlayer.coin += 2;
            count = 0;
         }else {
            count = 0;
         }
	}

	public void askBlock(Player currentPlayer, Player otherPlayer) {
		   System.out.print("\n" + otherPlayer.name+"님! " + currentPlayer.name 
	               + "님의 외부원조를 공작의 능력으로 저지 하시겠습니까?\n1.예\n2.아니요\n번호를 입력 >>");
	   }
	
	public void askChallengeAboutBlock(Player currentPlayer, Player otherPlayer) {
		System.out.print("\n" + currentPlayer.name + "님! "+ otherPlayer.name 
                + "님이 외부원조를 저지하려합니다. " + otherPlayer.name + "님의 공작의 유무에 대해 도전하시겠습니까?"
                +"\n1.공작의 유무에 대해 도전하기\n2.외부원조를 포기하기\n번호를 입력 >>");
	}
	
	public void selectDrawCardBetweenOne(Player currentPlayer, Player otherPlayer) {
		System.out.print("\n"+ otherPlayer.name +"님! "+ currentPlayer.name + "님이 공작의 유무에 대해 도전해왔습니다. 상대에게 보여줄"
	            + " 카드를 선택하세요. \n1. " + otherPlayer.myJob.get(0).jobName + "\n번호를 입력>>");
	}
	
	public void selectDrawCardBetweenTwo(Player currentPlayer, Player otherPlayer) {
		System.out.print("\n"+ otherPlayer.name+"님! "+ currentPlayer.name + "님이 공작의 유무에 대해 도전해왔습니다. 상대에게 보여줄"
	            + " 카드를 선택하세요. \n1. " + otherPlayer.myJob.get(0).jobName + " 2. " + 
	            otherPlayer.myJob.get(1).jobName + "\n번호를 입력>>");	
	}
	
	public void proveFirstIsDuke(Player currentPlayer, Player otherPlayer) {
		System.out.println("\n" + otherPlayer.name + "님이 공작을 소유하고 있음을 증명했습니다!\n"
                +"보여진 \'공작\'카드를 궁정 덱에서 교환합니다.\n");
        Player.royalCourtDeck.add(otherPlayer.myJob.get(0));
        otherPlayer.myJob.remove(0);
        Collections.shuffle(Player.royalCourtDeck);
        otherPlayer.myJob.add(Player.royalCourtDeck.get(0));

        System.out.println("\n"+ currentPlayer.name + "님이 도전에 실패했습니다. \n"
                + "패배의 댓가로 카드를 하나 잃습니다.");
	}

	public void proveFirstIsNotDuke(Player currentPlayer, Player otherPlayer) {
		
        System.out.println("\n" + otherPlayer.name + "님에게 공작이 없다는 사실이 들통났습니다."
                +"\n상대에게 보여진 카드 하나를 잃습니다.\n\n"+currentPlayer.name + "님은 도전을 성공했습니다!");
        
        otherPlayer.myJob.remove(0);
        
        System.out.println(currentPlayer.name +"님이 외부원조로 코인을 2개 가져왔습니다.");
        currentPlayer.coin += 2;
	}
	
	public void proveSecondIsDuke(Player currentPlayer, Player otherPlayer) {
		System.out.println("\n"+otherPlayer.name + "님이 공작을 소유하고 있음을 증명했습니다!\n"
                +"보여진 \'공작\'카드를 궁정 덱에서 교환합니다.\n");
        Player.royalCourtDeck.add(otherPlayer.myJob.get(1));
        otherPlayer.myJob.remove(1);
        Collections.shuffle(Player.royalCourtDeck);
        otherPlayer.myJob.add(Player.royalCourtDeck.get(0));

        System.out.println("\n"+ currentPlayer.name + "님이 도전에 실패했습니다. \n"
                + "패배의 댓가로 카드를 하나 잃습니다.");
	}
	
	public void proveSecondIsNotDuke(Player currentPlayer, Player otherPlayer) {
		
		System.out.println("\n" + otherPlayer.name + "님에게 공작이 없다는 사실이 들통났습니다."
                +"\n상대에게 보여진 카드 하나를 잃습니다.\n\n"+currentPlayer.name + "님은 도전을 성공했습니다!");
        
        otherPlayer.myJob.remove(1);
        System.out.println(currentPlayer.name +"님이 외부원조로 코인을 2개 가져왔습니다.");
        currentPlayer.coin += 2;
	}

	public void giveUp(Player currentPlayer, Player otherPlayer) {
		System.out.println("\n"+ otherPlayer.name + "님이 " + currentPlayer.name + "님의 외부원조를 저지하였습니다.");
	}
	
}
