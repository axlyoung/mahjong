package com.attic.bj.majiang.hongzhong;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.executor.MajiangDaNonHuaActionExecutor;

public class HongzhongMajiangDaNonHuaActionExecutor extends
		MajiangDaNonHuaActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		super.execInner(mjGame, mjAction);
		MajiangCard mc = (MajiangCard) mjAction.getCards().getHeadCard();
		if (mc.isBaida()) {
			((HongzhongMajiangGame) mjGame).putDaHongzhong(mjAction.getPlayer()
					.getAccount());
		}
	}

}
