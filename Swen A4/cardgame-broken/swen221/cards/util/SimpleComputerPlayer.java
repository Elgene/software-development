package swen221.cards.util;

import swen221.cards.core.Card;
import swen221.cards.core.Hand;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

	public SimpleComputerPlayer(Player player) {
		super(player);
	}

	@Override
	public Card getNextCard(Trick trick){
		List<Card> playCardList = trick.getCardsPlayed();
		List<Card> handList = new ArrayList<>();
		player.getHand().iterator().forEachRemaining(handList::add);
		Collections.reverse(handList);
		//If player take a first move
		if(playCardList.size() == 0) return calFirstCard(trick, handList);
		//take suit of  leaders
		Card.Suit leaderSuit = playCardList.get(0).suit();
		//If the player is not the last to go
		if(playCardList.size() != 3){
			//If lead suit can win then play potential winning card
			if(mightWinTrick(trick, leaderSuit, player.getHand())){
				List<Card> potentialListCards = new ArrayList<>(player.getHand().matches(leaderSuit));
				Collections.sort(potentialListCards);
				return potentialListCards.get(potentialListCards.size() - 1);
			}else{
				List<Card> potentialListCards = new ArrayList<>(player.getHand().matches(leaderSuit));

				if(!potentialListCards.isEmpty()){
					Collections.sort(potentialListCards);
					//If the player can follow suit, remove a card
					return potentialListCards.get(0);
					//If the player has a card of suits but can not win, so play the lowest eligible card
				}else{
					return handList.get(handList.size() - 1);
				}

			}
		}

		//If the player is the last one
		List<Card> potentialListCards = new ArrayList<>(player.getHand().matches(leaderSuit));
		Collections.sort(potentialListCards);
		//If the player has a card that follows suit
		if(!potentialListCards.isEmpty()){
			Card highestCardPlayed = highestCardPlayed(playCardList, leaderSuit);

			Card playCard = potentialListCards.get(potentialListCards.size() - 1);

			for(Card card : potentialListCards){
				if(card.rank().getNum() - highestCardPlayed.rank().getNum() < playCard.rank().getNum() - highestCardPlayed.rank().getNum()
						&& card.rank().getNum() - highestCardPlayed.rank().getNum() > 0) playCard = card;   //take the lowest eligible card to play and win
			}


			return playCard;
		}

		potentialListCards = new ArrayList<>(player.getHand().matches(trick.getTrumps()));
		//If it is a trump card
		if(!potentialListCards.isEmpty()){
			Collections.sort(playCardList);
			//Get highest played card
			Card highestCardPlayed = highestCardPlayed(playCardList, playCardList.get(playCardList.size() - 1).suit());

			Card playCard = potentialListCards.get(potentialListCards.size() - 1);

			for(Card card : potentialListCards){
				if(card.rank().getNum() - highestCardPlayed.rank().getNum() < playCard.rank().getNum() - highestCardPlayed.rank().getNum()
						&& card.rank().getNum() - highestCardPlayed.rank().getNum() > 0) playCard = card;   //Find the lowest eligible trump card to play
			}


			return playCard;
		}


		Card highestCardPlayed = highestCardPlayed(playCardList, leaderSuit);

		Card playCard = handList.get(handList.size() - 1);

		for(Card cardInHand : handList){
			if(cardInHand.suit().getNum() - highestCardPlayed.suit().getNum() < playCard.suit().getNum() - highestCardPlayed.rank().getNum()
					&& cardInHand.suit().getNum() - highestCardPlayed.suit().getNum() > 0){

				if(cardInHand.rank().getNum() - highestCardPlayed.rank().getNum() < playCard.rank().getNum() - highestCardPlayed.rank().getNum()
						&& cardInHand.rank().getNum() - highestCardPlayed.rank().getNum() > 0) playCard = cardInHand;
			}
		}


		return playCard;
	}


	private Card calFirstCard(Trick trick, List<Card> hand){
		if(!player.getHand().matches(trick.getTrumps()).isEmpty()){
			for(Card card : hand){
				if(card.suit() == trick.getTrumps()) return card;
			}
		}

		return highestRankedOfCard(hand);
	}

	private Card highestCardPlayed(List<Card> cards, Card.Suit suit){
		Card highest = cards.get(0);

		for(Card card : cards){
			if(card.suit() == suit && card.rank().getNum() > highest.rank().getNum()) highest = card;
		}

		return highest;
	}

	private Card highestRankedOfCard(List<Card> hand){
		Card highest = hand.get(0);
		for(Card card : hand){
			if(card.rank().getNum() > highest.rank().getNum()) highest = card;
		}
		return highest;
	}

	private boolean mightWinTrick(Trick trick, Card.Suit lead, Hand hand){
		Set<Card> cards = hand.matches(lead);
		List<Card> cardsListPlayed = trick.getCardsPlayed();
		Collections.sort(cardsListPlayed);
		Collections.reverse(cardsListPlayed);

		Card highestCard = cardsListPlayed.get(0);

		if(!cards.isEmpty()){
			for(Card card : cards){
				if(card.rank().getNum() > highestCard.rank().getNum())
					return true;
			}
			return false;
		}

		cards = hand.matches(trick.getTrumps());


		return !cards.isEmpty();
	}
}