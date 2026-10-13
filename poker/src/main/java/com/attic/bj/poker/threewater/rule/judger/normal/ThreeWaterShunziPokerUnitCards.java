package com.attic.bj.poker.threewater.rule.judger.normal;

import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCards;

public class ThreeWaterShunziPokerUnitCards extends PokerUnitCards {

	private SequencePokerUnitCards sequenceUnitCards;

	public SequencePokerUnitCards getSequenceUnitCards() {
		return sequenceUnitCards;
	}

	public ThreeWaterShunziPokerUnitCards(PokerCards pcs,
			SequencePokerUnitCards sequenceUnitCards) {
		super(pcs);
		this.sequenceUnitCards = sequenceUnitCards;
	}

	@Override
	public String toString() {
		return "sequenceUcs[" + this.sequenceUnitCards + "]" + super.toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "顺子";
	}

}
