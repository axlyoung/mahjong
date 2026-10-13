package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangChiUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangMingGangUnitCards;
import com.attic.bj.majiang.card.MajiangPengUnitCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.card.MajiangXianGangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangMenqingHuJudger implements MajiangHuJudger {

	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		List<MajiangUnitCards> listMjUnitCards = mjHuCards.getListMjUnitCards();
		if (listMjUnitCards == null || listMjUnitCards.size() == 0) {
			return new HuType(false, null);
		}
		for (MajiangUnitCards mucs : listMjUnitCards) {
			if (mucs instanceof MajiangChiUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangPengUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangMingGangUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangXianGangUnitCards) {
				return new HuType(false, null);
			}
		}
		return new HuType(true, null);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.MENGQING;
	}

}
