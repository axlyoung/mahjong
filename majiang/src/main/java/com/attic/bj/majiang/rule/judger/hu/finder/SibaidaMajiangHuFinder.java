package com.attic.bj.majiang.rule.judger.hu.finder;

import java.util.ArrayList;
import java.util.List;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangHuCards.HuFinderEnum;
import com.attic.bj.majiang.card.MajiangUnitCards;

public class SibaidaMajiangHuFinder implements NonThreeTwoMajiangHuFinder {

	@Override
	public List<MajiangHuCards> findLegalHuCards(
			List<MajiangUnitCards> listMiddleMjUnitCards, MajiangCards mjCards,
			MajiangCard mjCard) {
		// TODO Auto-generated method stub
		if (mjCards.baidaCards().size() == 4) {
			MajiangHuCards mjHuCards = new MajiangHuCards();
			mjHuCards.setHuFinderType(HuFinderEnum.SIBAIDA);
			mjHuCards.setMjHuCard(mjCard);
			List<MajiangHuCards> listRet = new ArrayList<MajiangHuCards>();
			listRet.add(mjHuCards);
			return listRet;
		}
		return null;
	}

}
