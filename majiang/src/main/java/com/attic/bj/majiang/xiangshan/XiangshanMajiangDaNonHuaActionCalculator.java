package com.attic.bj.majiang.xiangshan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.core.user.Player;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.helper.TanShuCalculator;
import com.attic.bj.majiang.rule.calculator.MajiangDaNonHuaWithNotSameActionCalculator;
import com.attic.bj.majiang.rule.judger.MajiangActionJudger;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuResult;
import com.attic.bj.majiang.user.MajiangPlayer;

public class XiangshanMajiangDaNonHuaActionCalculator extends
		MajiangDaNonHuaWithNotSameActionCalculator {

	private static final Logger logger = LoggerFactory
			.getLogger(XiangshanMajiangDaNonHuaActionCalculator.class);

	protected TanShuCalculator allTanShuCalculator;

	protected MajiangActionJudger mofrontHuActionJudger;

	public void setMofrontHuActionJudger(
			MajiangActionJudger mofrontHuActionJudger) {
		this.mofrontHuActionJudger = mofrontHuActionJudger;
	}

	public void setAllTanShuCalculator(TanShuCalculator allTanShuCalculator) {
		this.allTanShuCalculator = allTanShuCalculator;
	}

	private void processMingGangDaFangqiangHu(MajiangGame mjGame,
			MajiangAction mjAction, Actions actions) {

		MajiangPlayer daPlayer = this.isMingGangDa(mjGame, mjAction);
		logger.info("### mingGangDaPlayer[" + daPlayer + "]");
		Actions tmpActions;
		if (daPlayer == null) { // 不是明杠别人打得牌
			tmpActions = this.fangQiangHuActionJudger.judge(mjGame, mjAction);
			if (tmpActions == null || tmpActions.size() == 0) {
				return;
			}
			actions.addActions(tmpActions);
		} else {
			mjAction.setAttribute("FANGQIANGMOFRONTHU", new Object());
			mjAction.setAttribute("FANGQIANGBEIGANG", daPlayer);
			tmpActions = this.fangQiangHuActionJudger.judge(mjGame, mjAction);
			if (tmpActions != null && tmpActions.size() > 0) {
				for (int i = 0; i < tmpActions.size(); i++) {
					MajiangHuResult mjHuResult = (MajiangHuResult) tmpActions
							.getAction(i)
							.getAttribute(MajiangAction.MJHURESULT);
					if (mjHuResult.getMjPlayer() == daPlayer) {
						mjHuResult.setAttribute("FANGQIANGMOFRONTHU",
								new Object());
					}
				}
				actions.addActions(tmpActions);
			}
		}
		logger.info("### actions[" + actions + "]");
	}

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction) {

		Actions actions = new MajiangActions();

		this.processMingGangDaFangqiangHu(mjGame, mjAction, actions);

		if (mjGame.getMajiangBlackCards().size() == 0) {
			actions.addAction(new MajiangAction(null, MajiangAction.HUANGPAI,
					null, false));
			return actions;
		}

		Actions pengGangActions = new MajiangActions();
		if (mingGangActionJudger != null) {
			pengGangActions.addActions(mingGangActionJudger.judge(mjGame,
					mjAction));
		}
		if (pengActionJudger != null) {
			pengGangActions
					.addActions(pengActionJudger.judge(mjGame, mjAction));
		}
		pengGangActions = this.getNotSameDaActions(mjGame, mjAction,
				pengGangActions);
		actions.addActions(pengGangActions);

		this.sendThreeHintMessage(pengGangActions, mjAction.getPlayer());

		if (chiActionJudger != null) {
			actions.addActions(chiActionJudger.judge(mjGame, mjAction));
		}

		Cards cards = new MajiangCards();
		cards.addTailCard(mjGame.getMajiangBlackCards().getHeadCard());
		MajiangAction moMajiangAction = new MajiangAction(
				mjGame.nextPlayer(mjAction.getPlayer()), MajiangAction.MOFRONT,
				cards, false);
		actions.addAction(moMajiangAction);

		return actions;

	}

	private void sendThreeHintMessage(Actions pengGangActions, Player daPlayer) {
		if (pengGangActions == null || pengGangActions.size() == 0) {
			return;
		}
		for (int i = 0; i < pengGangActions.size(); i++) {
			Action a = pengGangActions.getAction(i);
			if (a.getType() != MajiangAction.PENG
					&& a.getType() != MajiangAction.MINGGANG) {
				continue;
			}
			Player actionPlayer = a.getPlayer();
			if (this.allTanShuCalculator.calculatorTanShu(
					(MajiangPlayer) actionPlayer, (MajiangPlayer) daPlayer) == 2) {
				String tintMessage = this.messageListener
						.getPlaceHolderAccount(actionPlayer.getAccount())
						+ "确定要碰"
						+ this.messageListener.getPlaceHolderAccount(daPlayer
								.getAccount()) + "三下?";
				this.messageListener.listen(actionPlayer.getAccount(),
						tintMessage);
			}
			return;
		}
	}
}
