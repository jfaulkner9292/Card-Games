import java.util.Scanner;

//Determine number of players NEED TO DECIDE RANGE
//Deal 5 cards to each player
//Ask player number if they have any #
//	If they have the asked # card, they give any cards with that #
//  Example: Ask #3 if they have any 7s. Player 3 does and hands over all "7" cards
//	If they don't have the card asked for, asker draws another card. If it is the card asked
//	for, they can show the others and draw again
//When a player has all 4 of a suit (all 3s for example), they place 
//If they run out of cards, they must draw 5 new cards 
//Play until deck is empty
//One point per 4 of a kind
public class goFish 
{
	Scanner input = new Scanner(System.in);
	
	public static void main(String []args)
	{
		
	}
	
	public void setup()
	{
		String userInput;
		System.out.println("How many players?");
		
		userInput = input.nextLine();
		
		while (!isInt(userInput)) //HAVE A SET RANGE OF PLAYERS AND CHECK HERE
		{
			System.out.println("Please enter a whole number");
			userInput = input.nextLine();
		}
		
	}
	
	public boolean isInt(String possibleInt)
	{
		try
		{
			Integer.parseInt(possibleInt);
			return true;
		}
		catch (NumberFormatException ex)
		{
			return false;
		}
	}

}
