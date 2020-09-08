package swen221.cards.core;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Comparable<Card>, Cloneable, Serializable{

	/**
	 * Represents a card suit.
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Suit {
		HEARTS (1),
		CLUBS (2),
		DIAMONDS (3),
		SPADES (4);

		private int num;

		Suit(int num){
			this.num = num;
		}

		public int getNum(){
			return num;
		}
	}

	/**
	 * Represents the different card "numbers".
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Rank{
		TWO (2),
		THREE (3),
		FOUR (4),
		FIVE (5),
		SIX (6),
		SEVEN (7),
		EIGHT (8),
		NINE (9),
		TEN (10),
		JACK (11),
		QUEEN (12),
		KING (13),
		ACE (14);

		private int num;

		Rank(int num){
			this.num = num;
		}

		public int getNum(){
			return num;
		}
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
	 * @return
	 */
	public Suit suit() {
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 *
	 * @return
	 */
	public Rank rank() {
		return rank;
	}

	private static String[] suits = { "Hearts","Clubs","Diamonds","Spades"};
	private static String[] ranks = { "2 of ", "3 of ", "4 of ",
			"5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ",
			"Queen of ", "King of ", "Ace of " };

	public String toString() {
		return ranks[rank.ordinal()] + suits[suit.ordinal()];
	}

	@Override
	public int compareTo(Card o) {
		if(o.suit.getNum() == this.suit.getNum()){
			return (int)Math.signum(this.rank.getNum() - o.rank.getNum());
		}

		return (int)Math.signum(this.suit.getNum() - o.suit.getNum());
	}



	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Card card = (Card) o;
		return suit == card.suit &&
				rank == card.rank;
	}

	@Override
	public int hashCode(){
		return Objects.hash(suit, rank);
	}
}
