package com.attic.bj.majiang.hongzhong;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.calculator.MajiangDaNonHuaWithNotSameActionCalculator;

public class HongzhongMajiangDaNonHuaActionCalculator extends
		MajiangDaNonHuaWithNotSameActionCalculator {
	
	
	@Override
	protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction) {

		Actions actions = new MajiangActions();

		

		if (mjGame.getMajiangBlackCards().size() == 6) {
			actions.addAction(new MajiangAction(null, MajiangAction.HUANGPAI,
					null, false));
			return actions;
		}

		if (mingGangActionJudger != null) {
			actions.addActions(mingGangActionJudger.judge(mjGame, mjAction));
		}
		if (pengActionJudger != null) {
			actions.addActions(pengActionJudger.judge(mjGame, mjAction));
		}

		actions = this.getNotSameDaActions(mjGame, mjAction, actions);

		

		Cards cards = new MajiangCards();
		cards.addTailCard(mjGame.getMajiangBlackCards().getHeadCard());
		MajiangAction moMajiangAction = new MajiangAction(
				mjGame.nextPlayer(mjAction.getPlayer()), MajiangAction.MOFRONT,
				cards, false);
		actions.addAction(moMajiangAction);
		return actions;
	}
}
