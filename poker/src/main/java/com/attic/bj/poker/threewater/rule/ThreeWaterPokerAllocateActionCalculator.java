package com.attic.bj.poker.threewater.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.action.DefaultActions;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.rule.ActionCalculator;
import com.attic.bj.poker.threewater.ThreeWaterPokerAction;

public class ThreeWaterPokerAllocateActionCalculator implements
		ActionCalculator {

	@Override
	public Actions calculateAction(Game game, Action action) {
		// TODO Auto-generated method stub
		DefaultActions das = new DefaultActions();
		
		for(int i = 0;i< game.getActivePlayers();i++){
			das.addAction(new ThreeWaterPokerAction(game.getPlayerByIndex(i),ThreeWaterPokerAction.SHOOT,null,true));
		}
		return das;
	}

}
