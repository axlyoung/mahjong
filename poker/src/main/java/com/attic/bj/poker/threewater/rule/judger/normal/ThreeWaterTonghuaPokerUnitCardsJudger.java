package com.attic.bj.poker.threewater.rule.judger.normal;

import com.attic.bj.poker.card.PokerAllCards;
import com.attic.bj.poker.card.PokerCard;
import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.PokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.ColorSamePokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.NumberSamePokerUnitCardsFinder;
import com.attic.bj.poker.card.strategy.base.NumberSamePokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCardsJudger;

public class ThreeWaterTonghuaPokerUnitCardsJudger implements
		PokerUnitCardsJudger {


	private ColorSamePokerUnitCardsJudger colorSamePokerUnitCardsJudger;
	private SequencePokerUnitCardsJudger sequencePokerUnitCardsJudger;

	public void setColorSamePokerUnitCardsJudger(
			ColorSamePokerUnitCardsJudger colorSamePokerUnitCardsJudger) {
		this.colorSamePokerUnitCardsJudger = colorSamePokerUnitCardsJudger;
	}

	public void setSequencePokerUnitCardsJudger(
			SequencePokerUnitCardsJudger sequencePokerUnitCardsJudger) {
		this.sequencePokerUnitCardsJudger = sequencePokerUnitCardsJudger;
	}

	@Override
	public PokerUnitCards judge(PokerCards pokerCards) {

		if (pokerCards == null || pokerCards.size() != 5) {
			return null;
		}

		if (colorSamePokerUnitCardsJudger.judge(pokerCards) == null) {
			return null;
		}
		if (sequencePokerUnitCardsJudger.judge(pokerCards) == null) {
			PokerCard pc = (PokerCard) pokerCards.getHeadCard();
			return new ThreeWaterTonghuaPokerUnitCards(pokerCards,
					pc.getPokerColor());
		}
		return null;
	}

	public static void main(String[] args) {
		NumberSamePokerUnitCardsFinder numberSamePokerUnitCardsFinder = new NumberSamePokerUnitCardsFinder();
		NumberSamePokerUnitCardsJudger numberSamePokerUnitCardsJudger = new NumberSamePokerUnitCardsJudger();
		ColorSamePokerUnitCardsJudger colorSamePokerUnitCardsJudger = new ColorSamePokerUnitCardsJudger();
		SequencePokerUnitCardsJudger sequencePokerUnitCardsJudger = new SequencePokerUnitCardsJudger();

		ThreeWaterTonghuaPokerUnitCardsJudger j = new ThreeWaterTonghuaPokerUnitCardsJudger();
		j.setSequencePokerUnitCardsJudger(sequencePokerUnitCardsJudger);
		j.setColorSamePokerUnitCardsJudger(colorSamePokerUnitCardsJudger);

		PokerAllCards pokerAllCards = new PokerAllCards();
		pokerAllCards.start();

		PokerCards pcs = new PokerCards();
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 1));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 2));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 3));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 4));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 7));
		// pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
		// PokerCard.Color.HONGTAO, 4));

		System.out.println(j.judge(pcs));
	}

}
