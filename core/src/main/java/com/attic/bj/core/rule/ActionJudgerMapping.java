package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;

public interface ActionJudgerMapping {
	public ActionJudger getActionJudger(Action action);
}
