package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;

public abstract class AbstractActionCalculatorMapping implements
		ActionCalculatorMapping {

	private ActionCalculator[] actionCalculators;

	public void setActionCalculators(ActionCalculator[] actionCalculators) {
		this.actionCalculators = actionCalculators;
	}

	public ActionCalculator getActionCalculator(Action action) {
		return actionCalculators[action.getType()];
	}
}
