package com.attic.bj.majiang.hongzhong;

import com.attic.bj.common.service.AdminService;
import com.attic.bj.common.util.RandomUtil;
import com.attic.bj.core.action.Action;
import com.attic.bj.core.card.Card;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.helper.WinLosePlayerStrategy;
import com.attic.bj.majiang.card.MajiangBlackCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.executor.MajiangAllocateActionExecutor;
import com.attic.bj.majiang.user.MajiangPlayer;

public class HongzhongMajiangAllocateActionExecutor extends
		MajiangAllocateActionExecutor {

	private AdminService adminService;

	private WinLosePlayerStrategy winLosePlayerStrategy;

	public void setWinLosePlayerStrategy(
			WinLosePlayerStrategy winLosePlayerStrategy) {
		this.winLosePlayerStrategy = winLosePlayerStrategy;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	private void adminJudge(MajiangGame mjGame) {
		for (int i = 0; i < mjGame.getActivePlayers(); i++) {
			MajiangPlayer mjPlayer = (MajiangPlayer) mjGame.getPlayerByIndex(i);
			if (!this.adminService.isSuperAdmin(mjPlayer.getAccount())) {
				continue;
			}

			MajiangInnerCards mjInnerCards = mjPlayer.getMajiangInnerCards();
			if (mjInnerCards.baidaCards().size() != 0) {
				break;
			}

			int random = RandomUtil.getRandomNumber(1, 100);
			if (random >= 40) {
				break;
			}

			MajiangBlackCards mjBcs = mjGame.getMajiangBlackCards();

			if (mjBcs.baidaCards().size() == 0) {
				break;
			}
			mjBcs.addTailCard(mjInnerCards.removeTailCard());
			MajiangCard baidaCard = (MajiangCard) mjBcs.baidaCards().getCard(0);
			mjInnerCards.addTailCard(baidaCard);
			mjBcs.removeCard(baidaCard);
			break;
		}
	}

	private void winJudge(MajiangGame mjGame) {
		for (int i = 0; i < mjGame.getActivePlayers(); i++) {
			MajiangPlayer mjPlayer = (MajiangPlayer) mjGame.getPlayerByIndex(i);
			if (!this.winLosePlayerStrategy.isNeedWinPlayer(mjPlayer
					.getAccount())) {
				continue;
			}

			MajiangInnerCards mjInnerCards = mjPlayer.getMajiangInnerCards();
			if (mjInnerCards.baidaCards().size() != 0) {
				continue;
			}

			int random = RandomUtil.getRandomNumber(1, 100);
			if (random > winLosePlayerStrategy.needWinRatio(mjPlayer
					.getAccount())) {
				continue;
			}

			MajiangBlackCards mjBcs = mjGame.getMajiangBlackCards();

			if (mjBcs.baidaCards().size() == 0) {
				continue;
			}
			mjBcs.addTailCard(mjInnerCards.removeTailCard());
			MajiangCard baidaCard = (MajiangCard) mjBcs.baidaCards().getCard(0);
			mjInnerCards.addTailCard(baidaCard);
			mjBcs.removeCard(baidaCard);
		}
	}

	private void loseJudge(MajiangGame mjGame) {
		for (int i = 0; i < mjGame.getActivePlayers(); i++) {
			MajiangPlayer mjPlayer = (MajiangPlayer) mjGame.getPlayerByIndex(i);
			if (!this.winLosePlayerStrategy.isNeedLosePlayer(mjPlayer
					.getAccount())) {
				continue;
			}

			// need lose player
			MajiangInnerCards mjInnerCards = mjPlayer.getMajiangInnerCards();
			if (mjInnerCards.baidaCards().size() == 0) {
				continue;
			}

			int random = RandomUtil.getRandomNumber(1, 100);
			if (random > this.winLosePlayerStrategy.needLoseRatio(mjPlayer
					.getAccount())) {
				continue;
			}

			MajiangBlackCards mjBcs = mjGame.getMajiangBlackCards();

			MajiangCards baidaCards = mjInnerCards.baidaCards();

			for (int j = 0; j < baidaCards.size(); j++) {
				Card tmpCard = baidaCards.getCard(j);
				mjBcs.addCard(5 + j, tmpCard);
				mjInnerCards.removeCard(tmpCard);
				mjInnerCards.addTailCard(mjBcs.removeTailCard());
			}
		}
	}

	public void exec(Game game, Action action) {
		super.exec(game, action);
		HongzhongMajiangGame mg = (HongzhongMajiangGame) game;

		Card[] cards = mg.getAllCards().findCardsByType("中");
		for (int i = 0; i < cards.length; i++) {
			((MajiangCard) cards[i]).setBaida(true);
		}

		/**
		 * for auto dapai
		 */
		for (int i = 0; i < game.getActivePlayers(); i++) {
			mg.putLastWaitUserActionTime(game.getPlayerByIndex(i).getAccount(),
					System.currentTimeMillis() + 2 * 60 * 60 * 1000);
		}

		
		this.winJudge(mg);
		this.loseJudge(mg);
//		this.adminJudge(mg);

	}

}
