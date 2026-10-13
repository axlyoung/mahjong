package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;

public interface ActionExecutorMapping {
	public ActionExecutor getActionExecutor(Action action);
}
