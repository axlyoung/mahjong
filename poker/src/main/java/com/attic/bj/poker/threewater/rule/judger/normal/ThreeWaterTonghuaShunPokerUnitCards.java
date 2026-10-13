package com.attic.bj.poker.threewater.rule.judger.normal;

import com.attic.bj.poker.card.PokerCard;
import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCards;

public class ThreeWaterTonghuaShunPokerUnitCards extends PokerUnitCards {

	private PokerCard.Color color;

	private SequencePokerUnitCards sequenceUnitCards;

	public SequencePokerUnitCards getSequenceUnitCards() {
		return sequenceUnitCards;
	}

	public ThreeWaterTonghuaShunPokerUnitCards(PokerCards pokerCards,
			SequencePokerUnitCards sequenceUnitCards, PokerCard.Color color) {
		super(pokerCards);
		this.color = color;
		this.sequenceUnitCards = sequenceUnitCards;
	}

	public PokerCard.Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "color[" + color + "]sequneceUcs[" + this.sequenceUnitCards
				+ "]" + super.toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "同花顺";
	}

}
