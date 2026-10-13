package com.attic.bj.poker.threewater.rule.judger.special;

import java.util.List;

import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCards;

public class ThreeWaterSantonghuashunPokerUnitCards extends
		ThreeWaterSanshunziPokerUnitCards {

	public ThreeWaterSantonghuashunPokerUnitCards(PokerCards pcs,
			List<SequencePokerUnitCards> listCards) {
		super(pcs, listCards);
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "三同花顺";
	}
	
	

}
