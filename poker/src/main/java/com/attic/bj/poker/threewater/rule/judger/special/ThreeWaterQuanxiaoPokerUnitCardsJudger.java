package com.attic.bj.poker.threewater.rule.judger.special;

import com.attic.bj.poker.card.PokerCard;
import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.PokerUnitCardsJudger;
/**
 * 
 * @author lele
 * 	全小
 *	全部为2到8的牌，不算花色
 *
 */
public class ThreeWaterQuanxiaoPokerUnitCardsJudger implements PokerUnitCardsJudger {

	@Override
	public PokerUnitCards judge(PokerCards pokerCards) {
		for (int i = 0; i < pokerCards.size(); i++) {
			PokerCard pc = (PokerCard) pokerCards.getCard(i);
			if (pc.getPokerNumber() >=2  && pc.getPokerNumber() <= 8) {
				continue;
			}
			return null;
		}
		return new ThreeWaterQuanxiaoPokerUnitCards(pokerCards);
	}
	
	public static void main(String [] args){
		
	}


}
