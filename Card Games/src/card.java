
public class card 
{
	int cardNum;
	String cardSuit;
	String cardColor;
	
	public card(int number, String suit, String color)
	{
		cardNum = number;
		cardSuit = suit;
		cardColor = color;
	}
	
	
	public static void main(String []args)
	{
		
	}
	
	public String getCard()
	{
		String all;
		
		all = cardColor;
		
		switch(cardNum)
		{
			case 13: 
				all = all +  " " + "King";
				break;
			case 12:
				all = all +  " " + "Queen";
				break;
			case 11:
				all = all +  " " + "Jack";
				break;
			case 1:
				all = all +  " " + "Ace";	
				break;
			default:
				all = all +  " " + cardNum;
		}
		
		all = all + " of " + cardSuit;
		
		return all;
	}
	
	public String getAll()
	{
		String all;
		
		//all = String.valueOf(cardNum) + " " + cardFace + " " + cardColor;
		all = cardColor + " " + String.valueOf(cardNum) + " " + cardSuit;
		
		return all;
	}
	
	
}
