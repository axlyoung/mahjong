package com.attic.bj.poker.threewater.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.poker.action.PokerAction;
import com.attic.bj.poker.game.PokerGame;
import com.attic.bj.poker.rule.PokerRule;
import com.attic.bj.poker.threewater.ThreeWaterPokerAction;

public class ThreeWaterPokerRule extends PokerRule {

	@Override
	protected PokerAction judgeLegalAction(PokerGame pokerGame,
			PokerAction pokerAction) {
		
		
		if(pokerAction.getType() == ThreeWaterPokerAction.SHOOT){
			Actions actions = pokerGame.getLegalActions();
			Action  []retActions = actions.getActionsByTypeAndPlayer(pokerAction.getPlayer().getAccount(),ThreeWaterPokerAction.SHOOT );
			if(retActions == null || retActions.length == 0){
				return null;
			}
//			actions.removeActionByTypeAndPlayer(pokerAction.getPlayer().getAccount(),ThreeWaterPokerAction.SHOOT );
			return pokerAction;
		}
		
		return pokerAction;
	}

}
