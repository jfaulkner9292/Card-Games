import java.util.Arrays;
import java.util.Random;

public class main 
{

	public static void main(String []args) 
	{
		
		System.out.println(System.getProperty("java.runtime.version"));
		//card cards[] = new card[53];
		
		card cards[] = createDeck();
		
		//System.out.println(cards[52].getCard());
		
		
		cards = shuffleDeck(cards);
		System.out.println("The deck has been shuffled!");
		
		showDeck(cards);
		
		
	}
	
	
	private static card[] createDeck()
	{
		int secondtHouseOffset = 13;
		int thridHouseOffset = 26;
		int fourthHouseOffset = 39;
		
		card cards[] = new card[53];
		
		for (int i = 1; i < 14; i++) // Assigns FIRST suit
		{
			card activeCard = new card(i, "Clubs", "Black");
			cards[i] = activeCard;
			
			//System.out.println(cards[i].getCard());
			
		}
		
		for (int i = 14; i < 27; i++) // Assigns SECOND suit
		{
			card activeCard = new card(i - secondtHouseOffset, "Diamonds", "Red");
			cards[i] = activeCard;
			
			//System.out.println(cards[i].getCard());
		}
		
		for (int i = 27; i < 40; i++) // Assigns THIRD suit
		{
			card activeCard = new card(i - thridHouseOffset, "Hearts", "Red");
			cards[i] = activeCard;
			
			//System.out.println(cards[i].getCard());
		}
		
		for (int i = 40; i < 53; i++) // Assigns FOURTH suit
		{
			card activeCard = new card(i - fourthHouseOffset, "Spades", "Black");
			cards[i] = activeCard;
			
			//System.out.println(cards[i].getCard());
		}
		
		return cards;
	}

	private static card[] shuffleDeck(card cards[])
	{
		
		card tempDeck[] = new card[53];
		Arrays.fill(tempDeck, null);
		
		Random rand = new Random();
		
		
		for (int i = 1; i < 53; i++)
		{
			int randNum = rand.nextInt(53);
			
			//Keeps generating numbers until a unique one is generated
			while (isAlreadyUsed(randNum, tempDeck, cards) == true) 
			{
				randNum = rand.nextInt(53);	
			}
			
			tempDeck[i] = cards[randNum];
			
		}
		return tempDeck;
		
	}
	
	private static void showDeck(card cards[])
	{
		for (int i = 1; i < 53; i++)
			System.out.println(cards[i].getCard());
			
	}
	
	
	//Returns false if the tempDeck[randNum] is empty and true if it is filled
	private static boolean isAlreadyUsed(int randNum, card tempDeck[], card cards[])
	{
		for (int i = 1; i < 53; i++)
		{
			if (tempDeck[i] == cards[randNum])
				return true;
		}
		
		return false;
	}
	
}


