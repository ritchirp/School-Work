package edu.miami.cse.agents.blackjack;


public class BlackJackGame {

	public static void main(String[] args) {

		// 1000 Games, dealer and player use same strategy
		DealerAgent dealer = new DealerAgent();
		int winnings = 0;
		int initialCash = 1000000;
		int betAmount = 10;
		int numGames = 1000;
		
		for(int i = 0; i<numGames; i++){ // Repeats the game 1000 times	
			winnings += playGame(dealer, betAmount);
		}
		
		System.out.println("The player won: $" + winnings + " over 1000 games");
		
		//100 More games using the same strategy
		numGames = 100000;
		winnings = 0;
		for(int i = 0; i<numGames; i++){ // Repeats the game 1000 times	
			winnings += playGame(dealer, betAmount);
		}
		System.out.println("The player's average net gain was: $" + winnings*1.0/numGames + " over 100 games");
		
		
		System.out.println("Now the player will use its own strategy");
		numGames = 100000;
		for(int i = 0; i<numGames; i++){ // Repeats the game 1000 times	
			winnings += playGame(dealer, betAmount);
		}
		System.out.println("The player's average net gain was: $" + winnings*1.0/numGames + " over 100 games");
		

	}
	/**
	 * Plays a game of Blackjack with the player and dealer utilizing the same strategy
	 * @param dealer the dealerAgent to be used
	 * @param betAmount the amount bet on the game
	 * @return the amount the player won (negative if they lost)
	 */
	static int playGame(DealerAgent dealer, int betAmount){
		int winnings = 0;
		
//		System.out.println("A new game has started");
		Deck deck = new Deck();
		Hand dealerHand = new Hand();
		Hand playerHand = new Hand();
		
		playerHand.add(deck.getCard());
		playerHand.add(deck.getCard());
	    dealerHand.add(deck.getCard());
	    dealerHand.add(deck.getCard());
	    
	    
	    while(dealer.act(playerHand) == Action.HIT){ 
	    	playerHand.add(deck.getCard());
	    }
		
		if(playerHand.getValue() > 21){
			winnings -= betAmount;
		}
		else{
			while(dealer.act(dealerHand) == Action.HIT){
				dealerHand.add(deck.getCard());
			}
			if(dealerHand.getValue() > 21 || playerHand.getValue() > dealerHand.getValue()){
				winnings += betAmount;
			}
			else if(playerHand.getValue() < dealerHand.getValue()){
				winnings -= betAmount;
			}
			// otherwise a tie and nothing needs to be done
		}
		
		return winnings;
	}
	
	// Plays a new game with the player using its own agent
	static int playGame(DealerAgent dealer, PlayerAgent player, int betAmount){
		int winnings = 0;
		
//		System.out.println("A new game has started");
		Deck deck = new Deck();
		Hand dealerHand = new Hand();
		Hand playerHand = new Hand();
		
		playerHand.add(deck.getCard());
		playerHand.add(deck.getCard());
	    dealerHand.add(deck.getCard());
		Card topCard = deck.getCard();
		dealerHand.add(topCard);
	    
	    
	    while(player.act(playerHand, topCard) == Action.HIT){ 
	    	playerHand.add(deck.getCard());
	    }
		
		if(playerHand.getValue() > 21){
			winnings -= betAmount;
		}
		else{
			while(dealer.act(dealerHand) == Action.HIT){
				dealerHand.add(deck.getCard());
			}
			if(dealerHand.getValue() > 21 || playerHand.getValue() > dealerHand.getValue()){
				winnings += betAmount;
			}
			else if(playerHand.getValue() < dealerHand.getValue()){
				winnings -= betAmount;
			}
			// otherwise a tie and nothing needs to be done
		}
		
		return winnings;
	}
	
}


