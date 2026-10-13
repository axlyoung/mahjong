package com.attic.bj.majiang.rule.judger.hu.finder;

import java.util.ArrayList;
import java.util.List;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangUnitCards;

public class CombinedMajiangHuFinder implements NonThreeTwoMajiangHuFinder {

	private List<NonThreeTwoMajiangHuFinder> huFinders;

	public void setHuFinders(List<NonThreeTwoMajiangHuFinder> huFinders) {
		this.huFinders = huFinders;
	}

	@Override
	public List<MajiangHuCards> findLegalHuCards(
			List<MajiangUnitCards> listMiddleMjUnitCards, MajiangCards mjCards,
			MajiangCard mjCard) {
		List<MajiangHuCards> listRet = new ArrayList<MajiangHuCards>();
		for (NonThreeTwoMajiangHuFinder huFinder : huFinders) {
			List<MajiangHuCards> list = huFinder.findLegalHuCards(
					listMiddleMjUnitCards, mjCards, mjCard);
			if (list != null && list.size() != 0) {
				listRet.addAll(list);
			}
		}
		return listRet;
	}
}
