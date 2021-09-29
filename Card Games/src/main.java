import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class main 
{

	public static void main(String []args) 
	{
		
		//System.out.println(System.getProperty("java.runtime.version"));
		
		//Creates an array of card objects 
		card cards[] = createDeck(); 
		
		//Creats a scanner object for the user to use as input
		Scanner input = new Scanner(System.in);
		
		
		ArrayList<String> gameList = new ArrayList<String>();
		gameList.add("Go Fish");
		gameList.add("52 Card Pickup");
		
		//String[] gameList = {"Go Fish", "52 Card Pickup"};
		
		PickGame(gameList, input);
		
		/* CODE TO SHUFFLE THE DECK
		cards = shuffleDeck(cards);
		System.out.println("The deck has been shuffled!");
		
		showDeck(cards);
		*/
		
		
		
	}
	
	private static void PickGame(ArrayList gameList, Scanner input) 
	{
		boolean validInput = false;
		
		ListGames(gameList);
		
		String userInput = input.nextLine();
		
		String selectedGame = userInput;
		
		while (gameList.contains(selectedGame) == false)
		{
			System.out.println("That is not a valid game, please choose one from the list!");
			
			ListGames(gameList);
			
			selectedGame = input.nextLine();
		}
		
		
		System.out.println("You chose: " + selectedGame);
		
		System.out.println("Would you like to start? (Yes/No)");
		
		userInput = input.nextLine().toLowerCase();
		
		if (userInput.equals("yes") || userInput.equals("no"))
			validInput = true;
		
		while (validInput == false)
		{
			System.out.println("Not valid input");
			userInput = input.nextLine().toLowerCase();
			
			if (userInput.equals("yes") || userInput.equals("no"))
				validInput = true;
		}
	} 
	
	private static void ListGames(ArrayList gameList)
	{
		System.out.println("Choose a game to play: \n");
		for (int i = 0; i < gameList.size(); i++)
			System.out.println(gameList.get(i));
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


