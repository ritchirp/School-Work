package edu.miami.cse.agents.blackjack;

import edu.miami.cse.agents.blackjack.Card.Rank;
import edu.miami.cse.agents.blackjack.Card.Suit;

public class Test {

	public static void main(String[] args) {
		Hand hand = new Hand();
		hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
		hand.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
//		hand.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
		
		PlayerAgent player = new PlayerAgent();
		
		
		System.out.println(player.act(hand, new Card(Rank.EIGHT, Suit.CLUBS)));

	}

}
