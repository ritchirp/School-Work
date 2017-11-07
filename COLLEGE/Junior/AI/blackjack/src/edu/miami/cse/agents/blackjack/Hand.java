package edu.miami.cse.agents.blackjack;

import java.util.ArrayList;

import edu.miami.cse.agents.blackjack.Card.Rank;


/**
 * A hand (the cards) of a Blackjack player or dealer 
 */

public class Hand {
	private ArrayList<Card> cards;
	
	/**
	   * Creates a new empty card list.
	*/
	public Hand(){
		cards = new ArrayList<Card>();
	}
	
	/**
	   * Add a card to the card list.
	*/
	
	public void add(Card card){
		cards.add(card);
	}
	
	/**
	   * Calculates and returns the hand value (sum of the hand cards values)
	   * @return The hand value
	*/
	
	public int getValue(){
		int count = 0;
		int aceCount = 0;
		
		for(Card current : cards){
			Rank rank = current.getRank();			
			switch(rank) {
			case ACE:
				aceCount++;
				break;
			case TWO:
				count +=2;
				break;
			case THREE:
				count +=3;
				break;
			case FOUR:
				count +=4;
				break;
			case FIVE:
				count +=5;
				break;
			case SIX:
				count +=6;
				break;
			case SEVEN:
				count +=7;
				break;
			case EIGHT:
				count +=8;
				break;
			case NINE:
				count +=9;
				break;
			case TEN: case JACK: case QUEEN: case KING:
				count +=10;
				break;
			
			}
			

		}
		
		if(aceCount==0){
			return count;
		}
		else{ // Returns the highest value under 21 (if it exists) with the given hand
			if(count + 11 + (aceCount - 1) <= 21)
				return count + (aceCount - 1) + 11;
			else
				return count + aceCount;
		}
		
	}
	
	/**
	 * override toString in class java.lang.Object
	 */
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		
		for(Card c : cards){
			out.append(c.toString() + " ");
		}
		return new String(out);
	}
	
	
	public Card[] toArray(){
		Card[] out = new Card[cards.size()];
		
		for(int i=0; i<out.length; i++){
			out[i] = new Card(cards.get(i).getRank(), cards.get(i).getSuit());
		}
		
		return out;
	}
	
	
}
