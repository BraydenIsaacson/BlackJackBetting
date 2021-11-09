import java.util.ArrayList;
import java.util.Scanner;
public class blackJackGame
	{
		static int playerInitial = 100;
		static ArrayList<Card> deck = new ArrayList<Card>();
		public static void main(String[] args)
		{
			System.out.println("Forewarning: You can bet money that you do not have.");
			System.out.println("If you have a gambling addiction call 1-800-522-4700");
			System.out.println("All rights reserved to the casino.");
			System.out.println("");
			boolean wannaPlay = true;
			int bigLoop = 0;
			while(wannaPlay)
				{
				if (bigLoop ==0) {
					System.out.println("Do you want to play?");
				}
				if (bigLoop >0) {
					System.out.println("Do you want to play again?");
				}
				Scanner play = new Scanner(System.in);
				String userPlay = play.nextLine(); 
				if(userPlay.equals("yes") ||  userPlay.equals("Yes"))
					{
				System.out.println("");
				Deck.fillDeck();
				Deck.shuffle();
				System.out.println("Welcome to Blackjack where you will ultimately end up broke.");
				System.out.println("Press enter to move on.");
				pause();
				blackjack();	
				bigLoop++;
					}
				if(userPlay.equals("no") || userPlay.equals("No"))
					{
						System.out.println("");
						System.out.println("Well played. Come again!");
						wannaPlay = false;
					}
					}
		}
		public static void displayCards()
		{
			for(int i=0; i<Deck.deck.size(); i++)
				{
					System.out.println(Deck.deck.get(i).getRank()+ " of " + Deck.deck.get(i).getSuit());
				}
		}
		public static void dealCards()
		{
			int min = 1;
			int max = 52;
			int number = (int)(Math.random()*(max-min+1));
			int min1 = 1;
			int max1 = 52;
			int number2 = (int)(Math.random()*(max1-min1+1));
		}
		public static void pause()
		{
			Scanner pause = new Scanner(System.in);
			String g = pause.nextLine();
		}
		
		public static void blackjack()
			{
			//int playerInitial = 100;
			System.out.println("Your balance is "+playerInitial);
			pause();
			System.out.println("How much do you bet?");
			Scanner userBet = new Scanner(System.in);
			int playerBet = userBet.nextInt(); 
			int dealerBet = playerBet;
			PlayerHand.giveHands();
			System.out.println("");
			System.out.println("If you wish to hit, type 'yes' until you do not, then type 'no'.");
			System.out.println("");
			int playerCardValue = Deck.deck.get(0).getValue() + Deck.deck.get(1).getValue();
			System.out.println("Player card value = "+playerCardValue);
			int dealerCardValue = Deck.deck.get(2).getValue() + Deck.deck.get(3).getValue();
			boolean loop = true;
			boolean stop = true;
			while(loop)
			{
			if(playerCardValue == 21)
				{
					System.out.println("You won!");
					playerInitial = playerInitial + dealerBet;
					pause();
					System.out.println("Your balance is now "+ playerInitial);
					loop = false;
					pause();
					System.out.println("Your balance is added, you still get to play. Do you hit?");
				}
			else if(playerCardValue > 21)
				{
					System.out.println("You lost your money lol.");
					playerInitial = playerInitial - dealerBet;
					System.out.println("Your current amount is " + playerInitial);
				}
			else
				{
					System.out.println("Do you hit?");
				}
			int k=4;
			int again = 0;
			while(stop)
				{
					if (again >0) {
						System.out.println("Do you want to hit?");
					}
					Scanner userHit = new Scanner (System.in);
					String userGo  = userHit.nextLine();
					if(userGo.equals("Yes") || userGo.equals("yes"))
						{
							System.out.println("");
							int afterHitCard = (Deck.deck.get(k).getValue());
							//System.out.println("You hit "+afterHitCard);
							int total = afterHitCard + playerCardValue;
							System.out.println(total + " = Total Value");
							System.out.println("");
							playerCardValue = afterHitCard + playerCardValue;
							k=k+1;
							again++;
							if(total > 21)
								{
									int ki = k-1;
									int cardValueGreater =Deck.deck.get(ki).getValue();
									System.out.println("Card value = " + cardValueGreater);
									pause();
									System.out.println("You lose.");
									System.out.println("");
									playerInitial = playerInitial - dealerBet;
									System.out.println("Your current balance is "+ playerInitial);
									loop = false;
									stop = false;
								}
							if(total == 21)
								{
									System.out.println("You win!");
									playerInitial = playerInitial + dealerBet;
									loop = false;
									stop = false;
								}
						}
					if(userGo.equals("No") || userGo.equals("no"))
						{
							System.out.println("");
							System.out.println("Dealer's starting card value = "+dealerCardValue);
							pause();
							boolean dealerLessPlayer = true;			
							while(dealerLessPlayer)
								{		
							if (dealerCardValue < playerCardValue)
								{
									k = k+1;
									int dealerHit = (Deck.deck.get(k).getValue());
									int dealerTotal = dealerHit + dealerCardValue;
									dealerCardValue = dealerHit + dealerCardValue;
									System.out.println("Dealer hit a "+Deck.deck.get(k).getRank());
									pause();
									System.out.println("Dealer's total = "+ dealerTotal);
									//playerInitial = playerInitial - dealerBet;
									//System.out.println("Your current balance is "+ playerInitial);
									pause();
									loop = false; 
									stop = false;
								}
							if(dealerCardValue > 21)
								{
									//System.out.println("Dealer's total = "+ dealerTotal);
									k = k+1;
									int dealerHit = (Deck.deck.get(k).getValue());
									dealerCardValue = dealerHit + dealerCardValue;
									System.out.println("You win!");
									playerInitial = playerInitial + dealerBet;
									System.out.println("Your current balance is "+ playerInitial);
									//System.out.println("");
									pause();
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							if(dealerCardValue == 21)
								{
									System.out.println("Dealer hit 21, lol you lost. Gimme yo money");
									pause();
									playerInitial = playerInitial - dealerBet;
									System.out.println("Your current balance is "+ playerInitial);
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							if(dealerCardValue > playerCardValue && dealerCardValue < 21)
								{
									System.out.println("You lost yo money.");
									pause();
									playerInitial = playerInitial - dealerBet;
									System.out.println("Your current balance is "+ playerInitial);
									System.out.println("");
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							if(dealerCardValue == 20 && playerCardValue == 20)
								{
									System.out.println("You tied");
									pause();
									System.out.println("You should play again!");
									System.out.println("");
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							if(dealerCardValue == playerCardValue && dealerCardValue !=20 && dealerCardValue != 20)
								{
									k = k+1;
									int dealerHit = (Deck.deck.get(k).getValue());
									int dealerTotal = dealerHit + dealerCardValue;
									dealerCardValue = dealerHit + dealerCardValue;
									System.out.println("Dealer hit a "+Deck.deck.get(k).getRank());
									System.out.println("Dealer's total = "+ dealerTotal);
									System.out.println("");
									loop = false; 
									stop = false;
								}
								}
						}
				}
		}
			}
	}