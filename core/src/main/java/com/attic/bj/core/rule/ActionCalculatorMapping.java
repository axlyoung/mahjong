package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;

public interface ActionCalculatorMapping {
	
	public ActionCalculator getActionCalculator(Action action);
}
