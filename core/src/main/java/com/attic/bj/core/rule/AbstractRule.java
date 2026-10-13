package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.ActionNotify;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.game.Game;

public abstract class AbstractRule implements Rule {

	protected ActionExecutorMapping actionExecutorMapping;

	protected ActionCalculatorMapping actionCalculatorMapping;

	protected ActionNotify actionNotify;

	public void setActionNotify(ActionNotify actionNotify) {
		this.actionNotify = actionNotify;
	}

	public void setActionCalculatorMapping(
			ActionCalculatorMapping actionCalculatorMapping) {
		this.actionCalculatorMapping = actionCalculatorMapping;
	}

	public void setActionExecutorMapping(
			ActionExecutorMapping actionExecutorMapping) {
		this.actionExecutorMapping = actionExecutorMapping;
	}


	protected Actions calNext(Game game, Action action) {
		return actionCalculatorMapping.getActionCalculator(action)
				.calculateAction(game, action);
	}

}
