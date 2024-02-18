// Letitia Pinter
// Card Game

package game.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Collections;

public class App
{
	public static void main(String[] args)
	{
		Deck d = new Deck();
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		d.shuffle();
		for(int i = 0; i<26; i++)
		{
			p1.draw(d);
			p2.draw(d);
		}
		// The actual game starts now.
		for(int i = 0; i<26; i++)
		{
			Card c1 = p1.flip();
			System.out.print(p1.getName() + "'s card: ");
			c1.describe();
			Card c2 = p2.flip();
			System.out.print(p2.getName() + "'s card: ");
			c2.describe();
			
			if(c1.getValue() > c2.getValue())
			{
				System.out.println(p1.getName() + " gets a point.");
				p1.incrementScore();
			}
			else if(c1.getValue() < c2.getValue())
			{
				System.out.println(p2.getName() + " gets a point.");
				p2.incrementScore();
			}
			else // if the cards are equal
			{
				System.out.println("No point was awarded.");
			}
			System.out.println(p1.getName() + "'s score: " + p1.getScore());
			System.out.println(p2.getName() + "'s score: " + p2.getScore());
		}
		
		// Once game is over:
		System.out.println(""); // Spacer
		System.out.println(p1.getName() + "'s score: " + p1.getScore());
		System.out.println(p2.getName() + "'s score: " + p2.getScore());
		
		if(p1.getScore() > p2.getScore())
			System.out.println(p1.getName() + " wins!");
		else if(p1.getScore() < p2.getScore())
			System.out.println(p2.getName() + " wins!");
		else
			System.out.println("Draw");
	}
}

public class Card
{
	private int value;
	private String name;
	
	public Card(int value, String suit)
	{ // Constructor. Creates the card and populates the fields.
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
	private ArrayList<Card> cards;
	
	public Deck()
	{ // Constructor. Populates the deck with cards.
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for(int i = 2; i <= 14; i++)
		{
			cards.add(new Card(i, "Hearts"));
			cards.add(new Card(i, "Diamonds"));
			cards.add(new Card(i, "Spades"));
			cards.add(new Card(i, "Clubs"));
		}
		this.cards = cards;
	}
	
	public void shuffle()
	{
		Collections.shuffle(cards);
	}
	
	public Card draw()
	{
		return cards.remove(0); // Pops the zeroth card off the deck.
	}
}

public class Player
{
	private ArrayList<Card> hand;
	private int score;
	private String name;
	
	public Player(String name)
	{
		this.name = name;
		this.score = 0;
		this.hand = new ArrayList<Card>();
	}
	
	public void describe()
	{
		System.out.println(name + ", Score: " + score + ", Hand:");
		for(Card c : hand) c.describe();
	}
	
	public Card flip()
	{
		return hand.remove(0); // Pops the zeroth card off the hand.
	}
	
	public void draw(Deck deck)
	{
		hand.add(deck.draw());
	}
	
	public void incrementScore() { score++; }
	public int getScore() { return score; }
	public String getName() { return name; }
}