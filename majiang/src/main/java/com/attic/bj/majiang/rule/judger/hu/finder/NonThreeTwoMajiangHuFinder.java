package com.attic.bj.majiang.rule.judger.hu.finder;

import java.util.List;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangUnitCards;

public interface NonThreeTwoMajiangHuFinder {
	
	public List<MajiangHuCards> findLegalHuCards(List<MajiangUnitCards> listMiddleMjUnitCards, MajiangCards mjCards,MajiangCard mjCard);

}
