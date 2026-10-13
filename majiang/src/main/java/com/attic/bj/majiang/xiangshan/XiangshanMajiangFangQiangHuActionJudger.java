package com.attic.bj.majiang.xiangshan;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.MajiangFangQiangQiangGangHuActionJudger;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuResult;
import com.attic.bj.majiang.user.MajiangPlayer;

public class XiangshanMajiangFangQiangHuActionJudger extends
		MajiangFangQiangQiangGangHuActionJudger {

	private static final Logger logger = LoggerFactory
			.getLogger(XiangshanMajiangFangQiangHuActionJudger.class);

	@Override
	protected MajiangActions judgeInner(MajiangGame mjGame,
			MajiangAction mjAction) {

		if (mjAction.getAttribute("FANGQIANGMOFRONTHU") == null) {
			return super.judgeInner(mjGame, mjAction);
		}

		MajiangPlayer mjPlayer = (MajiangPlayer) mjAction.getPlayer();
		MajiangCard mjCard = (MajiangCard) mjAction.getCards().getTailCard();
		MajiangActions mas = new MajiangActions();

		MajiangPlayer mjNextPlayer = mjPlayer;
		while (true) {
			mjNextPlayer = (MajiangPlayer) mjGame.nextPlayer(mjNextPlayer);
			if (mjNextPlayer == mjPlayer) {
				break;
			}
			logger.debug("### mjNextPlayer " + mjNextPlayer.getAccount());
			MajiangCards mjCards = new MajiangCards();
			mjCards.addTailCards(mjNextPlayer.getMajiangInnerCards().toArray());
			mjCards.addTailCard(mjCard);
			List<MajiangHuCards> listMjHuCards = huStrategy.findLegalHuCards(
					mjGame, mjNextPlayer.getMajiangMiddleCards()
							.getListUnitCards(), mjCards, mjCard);
			logger.debug("### find the listMjHuCards " + listMjHuCards);
			if (listMjHuCards == null || listMjHuCards.size() == 0) {
				continue;
			}

			int huType = MajiangAction.FANGQIANGHU;
			List<MajiangHuResult> listHuResult = huStrategy.calHuResultFan(
					mjGame, mjNextPlayer, huType, listMjHuCards);
			if (listHuResult == null || listHuResult.size() == 0) {
				continue;
			}
			for (MajiangHuResult mhr : listHuResult) {
				MajiangPlayer gangedPlayer = (MajiangPlayer) mjAction
						.getAttribute("FANGQIANGBEIGANG");
				if (gangedPlayer == mhr.getMjPlayer()) {
					mhr.setFan(mhr.getFan() + 1);
					mhr.setDetails(mhr.getDetails() + "自摸+1");
				}
			}
			MajiangHuResult mjHuResult = huStrategy.findLegalHuResult(mjGame,
					listHuResult);
			if (mjHuResult == null) {
				continue;
			}
			logger.debug("###  find mjHuResult " + mjHuResult);
			mjHuResult.setMjLosePlayer(mjPlayer);
			MajiangCards mjResultCards = new MajiangCards();
			mjResultCards.addTailCard(mjCard);
			MajiangAction mjRetAction = new MajiangAction(mjNextPlayer, huType,
					mjResultCards, true);
			mjRetAction.setAttribute(MajiangAction.MJHURESULT, mjHuResult);
			mas.addAction(mjRetAction);
		}

		return mas.size() == 0 ? null : mas;
	}

}
