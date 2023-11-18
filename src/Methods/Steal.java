package Methods;

import Player.Player;

public class Steal {

	public void askPlayerToSteal4(Player currentPlayer, String name1, String name2, String name3) 
	{
		System.out.println(currentPlayer + "님!, 2코인을 갈취할 플레이어를 선택해주세요");
		System.out.println("1." + name1 );
		System.out.println("2." + name2 );
		System.out.println("3." + name3 );
	}
	
	public void askPlayerToSteal3(Player currentPlayer, String name1, String name2) 
	{
		System.out.println(currentPlayer + "님!, 2코인을 갈취할 플레이어를 선택해주세요");
		System.out.println("1." + name1 );
		System.out.println("2." + name2 );
	}
	
	public void askPlayerToSteal2(Player currentPlayer, String name1)
	{
		System.out.println(currentPlayer + "님!, 2코인을 갈취할 플레이어를 선택해주세요");
		System.out.println("1." + name1 );
	}
	
	
}
