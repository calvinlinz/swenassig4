// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

import java.util.Objects;

/**
 * Represents a single card in the game.
 *
 * @author David J. Pearce
 *
 */
public class Card implements Comparable<Card> {

	/**
	 * Represents a card suit.
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Suit {
		/**
		 * The suit of hearts.
		 */
		HEARTS,
		/**
		 * The suit of clubs.
		 */
		CLUBS,
		/**
		 * The suit of diamonds.
		 */
		DIAMONDS,
		/**
		 * The suit of spades.
		 */
		SPADES;
	}

	/**
	 * Represents the different card "numbers".
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Rank {
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE;
	}

	// =======================================================
	// Card stuff
	// =======================================================

	private Suit suit; // HEARTS, CLUBS, DIAMONDS, SPADES
	private Rank rank; // 2 <= number <= 14 (ACE)

	/**
	 * Construct a card in the given suit, with a given number
	 *
	 * @param suit
	 *            --- between 0 (HEARTS) and 3 (SPADES)
	 * @param number
	 *            --- between 2 and 14 (ACE)
	 */
	public Card(Suit suit, Rank number) {
		this.suit = suit;
		this.rank = number;
	}

	/**
	 * Get the suit of this card, between 0 (HEARTS) and 3 (SPADES).
	 *
	 * @return The suite of this card.
	 */
	public Suit suit() {
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 *
	 * @return The rank of this card.
	 */
	public Rank rank() {
		return rank;
	}

	private static String[] suits = { "Hearts","Clubs","Diamonds","Spades"};
	private static String[] ranks = { "2 of ", "3 of ", "4 of ",
			"5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ",
			"Queen of ", "King of ", "Ace of " };

	@Override
	public String toString() {
		return ranks[rank.ordinal()] + suits[suit.ordinal()];
	}

	@Override
	public int compareTo(Card o) {
		// TODO: you need to implement this!
		if(this.equals(o)) return 0;
		if(this.suit.compareTo(o.suit) > 0) return 1;
		if(this.suit.compareTo(o.suit) < 0) return -1;
		if(this.rank.equals(o.rank)) return 0;
		if(this.rank.compareTo(o.rank) > 0) return 1;
		if(this.rank.compareTo(o.rank) < 0) return -1;
	
		return 0;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	public Card clone() {
		return new Card(suit,rank);
	}
}
