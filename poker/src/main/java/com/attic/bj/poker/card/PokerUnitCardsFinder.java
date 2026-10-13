package com.attic.bj.poker.card;

import java.util.List;

import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;

public interface PokerUnitCardsFinder {
	public List<PokerUnitCards> find(PokerCards pokerCards,int size);
}
