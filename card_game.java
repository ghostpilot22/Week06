// Card Game

package game.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class App
{
	public static void main(String[] args)
	{
		Card c = new Card(5, "Diamonds");
		System.out.println(c.getValue());
		System.out.println(c.getName());
		c.describe();
	}
}

public class Card
{
	private int value;
	private String name;
	
	public Card(int value, String suit)
	{
		this.value = value;
		switch(value)
		{
			case 2: this.name = "Two of " + suit; break;
			case 3: this.name = "Three of " + suit; break;
			case 4: this.name = "Four of " + suit; break;
			case 5: this.name = "Five of " + suit; break;
			case 6: this.name = "Six of " + suit; break;
			case 7: this.name = "Seven of " + suit; break;
			case 8: this.name = "Eight of " + suit; break;
			case 9: this.name = "Nine of " + suit; break;
			case 10: this.name = "Ten of " + suit; break;
			case 11: this.name = "Jack of " + suit; break;
			case 12: this.name = "Queen of " + suit; break;
			case 13: this.name = "King of " + suit; break;
			case 14: this.name = "Ace of " + suit; break;
		}
	}
	
	public int getValue() { return value; }
	
	public String getName() { return name; }
	
	public void describe()
	{
		System.out.println(name + ", value: " + value);
	}
}

public class Deck
{
	
}

public class Player
{
	
}