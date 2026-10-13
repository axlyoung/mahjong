package com.attic.bj.majiang.rule.judger.hu.type;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangQingyiseHuJudger implements MajiangHuJudger {


	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		String unit = null;
		for (int i = 0; i < mjHuCards.size(); i++) {
			MajiangCard mc = (MajiangCard) mjHuCards.getCard(i);
			if (mc.isBaida()) {
				continue;
			}
			if (mc.isUnit(MajiangCard.ZFB)) {
				return new HuType(false,null);
			}
			if (mc.isUnit(MajiangCard.DNXB)) {
				return new HuType(false,null);
			}
			if (mc.isUnit(MajiangCard.HUA)) {
				continue;
			}
			String tmpUnit = mc.getType().substring(1, 2);
			if (unit == null) {
				unit = tmpUnit;
			} else {
				if (!tmpUnit.equals(unit)) {
					return new HuType(false, null);
				}
			}
		}
		if (unit == null) {
			return new HuType(false, null);
		}
		return new HuType(true, unit);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.QINGYISE;
	}

}
