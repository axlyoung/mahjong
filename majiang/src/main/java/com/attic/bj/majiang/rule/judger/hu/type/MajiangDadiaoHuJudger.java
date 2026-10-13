package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangAnChiUnitCards;
import com.attic.bj.majiang.card.MajiangAnGangUnitCards;
import com.attic.bj.majiang.card.MajiangAnPengUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangDadiaoHuJudger implements MajiangHuJudger {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.DADIAO;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		List<MajiangUnitCards> list = mjHuCards.getListMjUnitCards();
		for (MajiangUnitCards mucs : list) {
			if (mucs instanceof MajiangAnChiUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangAnPengUnitCards) {
				return new HuType(false, null);
			}
		}
		return new HuType(true, null);

	}

}
