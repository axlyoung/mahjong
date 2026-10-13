package com.attic.bj.poker.card.strategy.base;

import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;

public class SequencePokerUnitCards extends PokerUnitCards {

	private int sequenceMin;

	private int sequenceMax;

	public int getSequenceMin() {
		return sequenceMin;
	}

	public int getSequenceMax() {
		return sequenceMax;
	}

	public SequencePokerUnitCards(PokerCards pokerCards, int sequenceMin,
			int sequenceMax) {
		super(pokerCards);
		this.sequenceMin = sequenceMin;
		this.sequenceMax = sequenceMax;

	}

	@Override
	public String toString() {
		return "min[" + this.sequenceMin + "]max[" + this.sequenceMax + "]"
				+ super.toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "sequencePucs";
	}

}
