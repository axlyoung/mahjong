package com.attic.bj.majiang.hongzhong;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.calculator.MajiangActionCalculator;
import com.attic.bj.majiang.rule.judger.MajiangActionJudger;

public class HongzhongMajiangXianGangActionCalculator extends
		MajiangActionCalculator {
	
	private MajiangActionJudger qiangGangHu;

	public void setQiangGangHu(MajiangActionJudger qiangGangHu) {
		this.qiangGangHu = qiangGangHu;
	}

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		// TODO Auto-generated method stub
		Actions actions = new MajiangActions();
		if (qiangGangHu != null) {
			Actions as = qiangGangHu.judge(mjGame, mjAction);
			if (as != null) {
				actions.addActions(as);
			}
		}

		if (actions.size() == 0 && mjGame.getMajiangBlackCards().size() == 6) {
			actions.addAction(new MajiangAction(null, MajiangAction.HUANGPAI,
					null, false));
		} else {
			Cards cards = new MajiangCards();
			cards.addTailCard(mjGame.getMajiangBlackCards().getTailCard());
			actions.addAction(new MajiangAction(mjAction.getPlayer(),
					MajiangAction.MOBACK, cards, false));
		}
		return actions;
	}

}
