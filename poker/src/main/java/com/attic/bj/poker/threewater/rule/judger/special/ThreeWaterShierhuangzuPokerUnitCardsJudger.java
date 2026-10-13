package com.attic.bj.poker.threewater.rule.judger.special;

import com.attic.bj.poker.card.PokerAllCards;
import com.attic.bj.poker.card.PokerCard;
import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.PokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.ColorSamePokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.NumberSamePokerUnitCardsFinder;
import com.attic.bj.poker.card.strategy.base.NumberSamePokerUnitCardsJudger;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCardsFinder;
import com.attic.bj.poker.card.strategy.base.SequencePokerUnitCardsJudger;
/**
 * 
 * @author lele
 * 	十二皇族
 *  全为JQKA的牌
 *
 */
public class ThreeWaterShierhuangzuPokerUnitCardsJudger implements PokerUnitCardsJudger {

	@Override
	public PokerUnitCards judge(PokerCards pokerCards) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pokerCards.size(); i++) {
			PokerCard pc = (PokerCard) pokerCards.getCard(i);
			if(pc.getPokerNumber() == 1){
				continue;
			}
			if (pc.getPokerNumber() >=11) {
				continue;
			}
			return null;
		}
		return new ThreeWaterShierhuangzuPokerUnitCards(pokerCards);
	}
	
	public static void main(String[] args) {

		NumberSamePokerUnitCardsJudger numberSamePokerUnitCardsJudger = new NumberSamePokerUnitCardsJudger();
		ColorSamePokerUnitCardsJudger colorSamePokerUnitCardsJudger = new ColorSamePokerUnitCardsJudger();
		SequencePokerUnitCardsJudger sequencePokerUnitCardsJudger = new SequencePokerUnitCardsJudger();
		NumberSamePokerUnitCardsFinder numberSamePokerUnitCardsFinder = new NumberSamePokerUnitCardsFinder();
		SequencePokerUnitCardsFinder sequencePokerUnitCardsFinder = new SequencePokerUnitCardsFinder();

		ThreeWaterShierhuangzuPokerUnitCardsJudger j = new ThreeWaterShierhuangzuPokerUnitCardsJudger();

		PokerAllCards pokerAllCards = new PokerAllCards();
		pokerAllCards.start();

		PokerCards pcs = new PokerCards();

		

		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HONGTAO, 11));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 11));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 12));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 12));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 12));

		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 12));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 13));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 13));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 13));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 13));
		
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.FANGKUAI, 1));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.CAOHUA, 1));
		pcs.addTailCard(pokerAllCards.getPokerCardByColorAndPokerNumber(
				PokerCard.Color.HONGTAO, 1));

		System.out.println(j.judge(pcs));
	}


}
