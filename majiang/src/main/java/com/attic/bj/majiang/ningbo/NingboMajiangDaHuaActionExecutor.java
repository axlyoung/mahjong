package com.attic.bj.majiang.ningbo;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.executor.MajiangDaHuaActionExecutor;
import com.attic.bj.majiang.user.MajiangPlayer;

public class NingboMajiangDaHuaActionExecutor extends
		MajiangDaHuaActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		super.execInner(mjGame, mjAction);

		mjAction.setAttribute("HUATAISHU", NingboMajiangHuaJudgeUtil.judge(
				mjGame, (MajiangPlayer) mjAction.getPlayer()));
	}
}
