package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangWudaHuJudger implements MajiangHuJudger {

	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.WUDA;
	}

	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mjHuCards.size(); i++) {
			MajiangCard mc = (MajiangCard) mjHuCards.getCard(i);
			if (mc.isBaida()) {
				return new HuType(false, null);
			}
		}
		return new HuType(true, null);
	}

}
