package com.attic.bj.majiang.rule.executor;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuResult;

public class MajiangHuActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangHuResult mjHuResult = (MajiangHuResult) mjAction
				.getAttribute(MajiangAction.MJHURESULT);
		mjGame.addMajiangHuResult(mjHuResult);
	}

}
