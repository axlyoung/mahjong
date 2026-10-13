package com.attic.bj.majiang.rule.judger.hu.type;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangFengyiseHuJudger implements MajiangHuJudger {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.FENGYISE;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub

		for (int i = 0; i < mjHuCards.size(); i++) {
			MajiangCard mc = (MajiangCard) mjHuCards.getCard(i);
			if (mc.isBaida()) {
				continue;
			}
			if (mc.isUnit(MajiangCard.ZFB)) {
				continue;
			}
			if (mc.isUnit(MajiangCard.DNXB)) {
				continue;
			}
			if (mc.isUnit(MajiangCard.HUA)) {
				continue;
			}
			return new HuType(false, null);
		}
		return new HuType(true, null);
	}

}
