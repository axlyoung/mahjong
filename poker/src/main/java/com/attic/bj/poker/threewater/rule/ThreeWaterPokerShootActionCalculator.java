package com.attic.bj.poker.threewater.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.action.DefaultActions;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.rule.ActionCalculator;
import com.attic.bj.poker.threewater.ThreeWaterPokerAction;
import com.attic.bj.poker.threewater.ThreeWaterPokerPlayer;

public class ThreeWaterPokerShootActionCalculator implements ActionCalculator {

	@Override
	public Actions calculateAction(Game game, Action action) {
//		for(int i = 0;i< game.getActivePlayers();i++){
//			ThreeWaterPokerPlayer pp = (ThreeWaterPokerPlayer)game.getPlayerByIndex(i);
//		}
		
		DefaultActions das = new DefaultActions();
		das.addAction(new ThreeWaterPokerAction(null,ThreeWaterPokerAction.COMPLETE,null,false));
		return das;
	}

}
