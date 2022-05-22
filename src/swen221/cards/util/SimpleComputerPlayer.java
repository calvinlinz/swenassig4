// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.util;

import java.util.ArrayList;
import java.util.List;

import swen221.cards.core.Card;
import swen221.cards.core.IllegalMove;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 *
 * @author David J. Pearce
 *
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer {

	/**
	 * Construct a new (simple) computer player with the given player information.
	 *
	 * @param player Key player informmation.
	 */
	public SimpleComputerPlayer(Player player) {
		super(player);
	}

	@Override
	public Card getNextCard(Trick trick) {
		// TODO: you need to implement this!

		Card min = null;
		Card max = null;
		Card discard = null;
		boolean hasSuit = false;
		
		Player.Direction d = trick.getLeadPlayer();
		Player.Direction opp = null;
		List<Card> winnable = new ArrayList<>();
		switch(d){
			case NORTH: opp = Player.Direction.WEST;
			break;
			case SOUTH: opp = Player.Direction.EAST;
			break;
			case EAST: opp = Player.Direction.NORTH;
			break;
			case WEST: opp = Player.Direction.SOUTH;
			break;
		}
		
			Card send = null;
			Card max2 =null;
			
			
		
			if(trick.getCardPlayed(trick.getLeadPlayer()) != null){

			if(player.getDirection().equals(opp)) {

				for(Card card : trick.getCardsPlayed()) {
						if(max2 == null) {
							max2 = card;
						}
						if(card.compareTo(max2) == -1) {
							max2 = card;
						}
					}
						
				
				
			
				for(Card card : player.getHand()){
					if(trick.getTrumps() != null && card.suit().equals(trick.getCardPlayed(trick.getLeadPlayer()).suit())) {
						if(max2!=null) {
							if(card.compareTo(max2) == 1) {
								winnable.add(card);
								System.out.println(card.toString());
							}
						}
						
					}else {
						if(max2!=null) {
							if(card.compareTo(max2) == 1) {
								winnable.add(card);
								System.out.println(card.toString());
							}
						}
						
					}
					
				}
			
				if(!winnable.isEmpty()) {
					for(Card card : winnable) {
						if(send == null) {
							send = card;
						}
						if(send.compareTo(card) == 1) {
							send = card;
						}
					}
				}
			
			if(send != null) {
				return send;
			}
			
			}
			
			}
		
		
		
		
		
		
		if(trick.getCardPlayed(trick.getLeadPlayer()) != null){
			Card leader = trick.getCardPlayed(trick.getLeadPlayer());
			for(Card card : player.getHand()) {
				if(card.suit().equals(leader.suit())){
					hasSuit = true;
					if(min == null) {
						min = card;
						max = card;
					}
					if(card.compareTo(min) == 1) {
						min = card;
					}
					if(card.compareTo(max) == -1) {
						max = card;
					}
				}
			}
			
			if(max != null && min != null) {
				if(max.compareTo(leader) == -1) {
					return max;
				}else if (min.compareTo(leader) == 1) return min;
			}
			
			
			if(max == null && min == null) {
				for(Card card : player.getHand()) {
					if(discard == null) {
						discard = card;
					}
					if(discard.compareTo(card) == 1 ) {
						discard = card;
					}
				}
				return discard;
			}
			
			
			
		}
						
		

	return discard;
	}
}
