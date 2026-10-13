package com.attic.bj.majiang.rule.judger.hu.type;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangZimoHuJudger implements MajiangHuJudger {

	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		boolean ret = (huType == MajiangAction.MOFRONTHU
				|| huType == MajiangAction.MOBACKHU || huType == MajiangAction.QIANGGANGHU);
		return new HuType(ret, null);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.ZIMO;
	}

}
