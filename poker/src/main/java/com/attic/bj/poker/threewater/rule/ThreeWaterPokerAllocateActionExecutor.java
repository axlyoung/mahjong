package com.attic.bj.poker.threewater.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.rule.ActionExecutor;
import com.attic.bj.poker.card.PokerBlackCards;
import com.attic.bj.poker.card.PokerUnitCards;
import com.attic.bj.poker.card.PokerUnitCardsJudger;
import com.attic.bj.poker.threewater.ThreeWaterPokerAction;
import com.attic.bj.poker.threewater.ThreeWaterPokerCards;
import com.attic.bj.poker.threewater.ThreeWaterPokerGame;
import com.attic.bj.poker.threewater.ThreeWaterPokerPlayer;

public class ThreeWaterPokerAllocateActionExecutor implements ActionExecutor {

	private static final Logger logger = LoggerFactory
			.getLogger(ThreeWaterPokerAllocateActionExecutor.class);

	private ThreeWaterPokerShootChooser threeWaterPokerShootChooser;

	private PokerUnitCardsJudger specialPokerUnitCardsJudger;

	public void setSpecialPokerUnitCardsJudger(
			PokerUnitCardsJudger specialPokerUnitCardsJudger) {
		this.specialPokerUnitCardsJudger = specialPokerUnitCardsJudger;
	}

	public void setThreeWaterPokerShootChooser(
			ThreeWaterPokerShootChooser threeWaterPokerShootChooser) {
		this.threeWaterPokerShootChooser = threeWaterPokerShootChooser;
	}

	@Override
	public void exec(Game game, Action action) {
		ThreeWaterPokerGame twpg = (ThreeWaterPokerGame) game;
		ThreeWaterPokerAction twpa = (ThreeWaterPokerAction) action;
		PokerBlackCards pbcs = twpg.getPokerBlackCards();

		for (int i = 0; i < twpg.getActivePlayers(); i++) {
			ThreeWaterPokerPlayer twpp = (ThreeWaterPokerPlayer) twpg
					.getPlayerByIndex(i);
			ThreeWaterPokerCards threeWaterPokerCards = twpp
					.getThreeWaterPokerCards();

			threeWaterPokerCards.addTailCards(pbcs.removeTailCards(13));


			PokerUnitCards pucs = specialPokerUnitCardsJudger
					.judge(threeWaterPokerCards);

			logger.info("specialPokerUnitCards[" + pucs + "]");

			if (pucs != null) {
				pucs.sort();
				threeWaterPokerCards.setSpecialCards(pucs);
			} else {
				twpp.setListCandidate(threeWaterPokerShootChooser
						.chooseBetter(twpp.getThreeWaterPokerCards()));
			}
		}
	}
}
