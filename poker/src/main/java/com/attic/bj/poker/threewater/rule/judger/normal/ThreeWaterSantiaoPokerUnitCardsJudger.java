package com.attic.bj.poker.threewater.rule.judger.normal;

import java.util.List;

import com.attic.bj.poker.card.PokerAllCards;
import com.attic.bj.poker.card.PokerCard;
import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.PokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.ColorSamePokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.NumberSamePokerUnitCardsFinder;
import com.attic.bj.poker.card.strategy.base.NumberSamePokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCardsJudger;

public class ThreeWaterSantiaoPokerUnitCardsJudger implements
		PokerUnitCardsJudger {


	private NumberSamePokerUnitCardsFinder numberSamePokerUnitCardsFinder;

	private NumberSamePokerUnitCardsJudger numberSamePokerUnitCardsJudger;

	public void setNumberSamePokerUnitCardsJudger(
			NumberSamePokerUnitCardsJudger numberSamePokerUnitCardsJudger) {
		this.numberSamePokerUnitCardsJudger = numberSamePokerUnitCardsJudger;
	}

	public void setNumberSamePokerUnitCardsFinder(
			NumberSamePokerUnitCardsFinder numberSamePokerUnitCardsFinder) {
		this.numberSamePokerUnitCardsFinder = numberSamePokerUnitCardsFinder;
	}

	@Override
	public PokerUnitCards judge(PokerCards pokerCards) {
		// TODO Auto-generated method stub
		if (pokerCards.size() != 3 && pokerCards.size() != 5) {
			return null;
		}

		if (pokerCards.size() == 3) {
			PokerUnitCards pucs = numberSamePokerUnitCardsJudger
					.judge(pokerCards);
			if (pucs == null) {
				return null;
			}
			return new ThreeWaterSantiaoPokerUnitCards(pokerCards, pokerCards,
					null);
		}

		if (numberSamePokerUnitCardsFinder.find(pokerCards, 4) != null) {
			return null;
		}

		List<PokerUnitCards> list = numberSamePokerUnitCardsFinder.find(
				pokerCards, 3);
		if (list == null || list.size() == 0) {
			return null;
		}
		PokerUnitCards pucs = list.get(0);
		PokerCards copyCards = new PokerCards();
		copyCards.addTailCards(pokerCards.toArray());
		copyCards.removeCards(pucs.toArray());

		if (null != numberSamePokerUnitCardsJudger.judge(copyCards)) {
			return null;
		}
		return new ThreeWaterSantiaoPokerUnitCards(pokerCards, pucs, copyCards);
	}

	public static void main(String[] args) {
		NumberSamePokerUnitCardsFinder numberSamePokerUnitCardsFinder = new NumberSamePokerUnitCardsFinder();
		NumberSamePokerUnitCardsJudger numberSamePokerUnitCardsJudger = new NumberSamePokerUnitCardsJudger();
		ColorSamePokerUnitCardsJudger colorSamePokerUnitCardsJudger = new ColorSamePokerUnitCardsJudger();
		SequencePokerUnitCardsJudger sequencePokerUnitCardsJudger = new SequencePokerUnitCardsJudger();

		ThreeWaterSantiaoPokerUnitCardsJudger j = new ThreeWaterSantiaoPokerUnitCardsJudger();
		j.setNumberSamePokerUnitCardsFinder(numberSamePokerUnitCardsFinder);
		j.setNumberSamePokerUnitCardsJudger(numberSamePokerUnitCardsJudger);

		PokerAllCards pokerAllCards = new PokerAllCards();
		pokerAllCards.start();

		PokerCards pcs = new PokerCards();
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 1));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HONGTAO, 1));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.CAOHUA, 1));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 3));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HEITAO, 3));
		// pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
		// PokerCard.Color.HONGTAO, 4));

		System.out.println(j.judge(pcs));
	}

}
