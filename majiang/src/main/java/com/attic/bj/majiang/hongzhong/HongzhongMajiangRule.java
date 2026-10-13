package com.attic.bj.majiang.hongzhong;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.rule.MajiangRule;

public class HongzhongMajiangRule extends MajiangRule {

	private boolean hasHu(Action[] arrAction) {
		for (Action a : arrAction) {
			if (a.getType() == MajiangAction.MOFRONTHU
					|| a.getType() == MajiangAction.MOBACKHU
					|| a.getType() == MajiangAction.QIANGGANGHU) {
				return true;
			}
		}
		return false;
	}

	protected Action translateNoAction(Game game, Action action) {
		// logger.info("### enter into the translateNoAction");
		Actions legalActions = game.getLegalActions();
		Action[] arrAction = legalActions.getActionsByPlayer(action.getPlayer()
				.getAccount());
		if (arrAction == null || arrAction.length == 0) {
			return null;
		}
		// 如果当前用户有胡的，过指令失效!!!
		if (this.hasHu(arrAction)) {
			return null;
		}
		return super.translateNoAction(game, action);
	}
}
