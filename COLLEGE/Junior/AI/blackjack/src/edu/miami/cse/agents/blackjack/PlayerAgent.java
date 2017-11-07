package edu.miami.cse.agents.blackjack;



import edu.miami.cse.agents.blackjack.Card.Rank;

// The strategy tables used in this code were obtained from
// https://www.blackjackapprenticeship.com/resources/blackjack-strategy-charts/
// Note that since splitting pairs is not an option in this
// version of blackjack, the tables were simplified in this implementation.

public class PlayerAgent {
	
	static private boolean[] softHand;
	static private boolean[][] hardHand;

	public PlayerAgent(){
		// Fills the lookup tables for the strategy
		fillSoft();
		fillHard();
	}
	

	public Action act(Hand cards, Card dealerUpCard) {
		if(cards.getValue()==21) return Action.STAND;
		
		Card[] hand = cards.toArray();
		boolean hasAce = handHasAce(hand);
		if(hand.length == 2 && hasAce){ 
			return softHandAct(hand, dealerUpCard);
		}
		else{
			return hardHandAct(cards, dealerUpCard);
		}

	}
	
	private boolean handHasAce(Card[] cards){
		for(Card c : cards){
			if (c.getRank() == Rank.ACE)
				return true;
		}
		
		return false;
	}
	

	
	private Action hardHandAct(Hand cards, Card dealerUpCard){
		int value = cards.getValue();
		
		if(value >= 17)
			return Action.HIT;
		else if(value <= 11)
			return Action.STAND;
		else{
			Hand temp = new Hand();
			temp.add(dealerUpCard);
			int upCardValue = temp.getValue();
			
			
			boolean willHit;
			
			if(value<=16 && value >=13)
				willHit = hardHand[0][upCardValue - 1];
			else
				willHit = hardHand[1][upCardValue - 1];
			
			
			if(willHit)
				return Action.HIT;
			else
				return Action.STAND;
			
		}
		
	}
	
	private Action softHandAct(Card[] cards, Card dealerUpCard){
		// This method is only called when the hand has at least one ace and has 2 cards
		Card card1 = cards[0];
		Card card2 = cards[1];

		if(card1.getRank() == Rank.ACE && card2.getRank() == Rank.ACE){
			return Action.HIT;
		}
		else{
			Hand temp = new Hand();
			temp.add(card1);
			temp.add(card2);
			
			int value = temp.getValue() - 11;
			
			if(value >= 8)
				return Action.STAND;
			else if(value <= 6){
				return Action.HIT;
			}
			else{
				temp = new Hand();
				temp.add(dealerUpCard);
				
				int i = temp.getValue();
				
				if(softHand[i - 2])
					return Action.HIT;
				else
					return Action.STAND;
			}
		}
	}
	
	private void fillHard() {
		hardHand = new boolean[][]{
			{false, false, false, false, false, true, true, true, true, true}, // 16-13
			{true, true, false, false, false, true, true, true, true, true}, // 12
		};
	}

		
		
	private void fillSoft() {
		softHand = new boolean[]{false, false, false, false, false, false, false, true, true, true}; // other card 7

	}
}

