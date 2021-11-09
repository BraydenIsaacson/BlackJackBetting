//import java.util.ArrayList;

public class PlayerHand
	{
		//static ArrayList<Card> playerCardValues = new ArrayList<Card>();
		public static void giveHands()
		{
			System.out.println("");
			System.out.println("You got a " +Deck.deck.get(0).getRank()+ " of " + Deck.deck.get(0).getSuit());
			System.out.println("You got a " +Deck.deck.get(1).getRank()+ " of " + Deck.deck.get(1).getSuit());
			
	}
		public static void getPlayerCardValue()
		{
			int playerCardValue = Deck.deck.get(0).getValue() + Deck.deck.get(1).getValue();
		}
}
