package com.attic.bj.majiang.rule.judger.hu.type;

import com.attic.bj.majiang.card.MajiangDuiziUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangDandiaoHuJudger implements MajiangHuJudger {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.DANDIAO;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		MajiangDuiziUnitCards mdzucs = mjHuCards.findDuiziUnitCards();
		if (mdzucs.containsCard(mjHuCards.getMjHuCard())) {
			return new HuType(true, null);
		}
		return new HuType(false, null);
	}

	

}
