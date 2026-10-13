package com.attic.bj.majiang.actionlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.ActionListener;
import com.attic.bj.core.card.Card;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.card.MajiangBlackCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.card.MajiangOutterCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.hangzhou.HangzhouMajiangGame;
import com.attic.bj.majiang.tiantai.TiantaiMajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangCardValidateActionListener implements ActionListener {

	private static final Logger logger = LoggerFactory
			.getLogger(MajiangCardValidateActionListener.class);

	private Card[] initArrCards(Game game) {
		return new Card[144];
	}

	private void copy(MajiangCards mjCards, Card[] arrCards) {
		int len = mjCards.size();
		if (len < 0) {
			return;
		}
		for (int i = 0; i < len; i++) {
			arrCards[mjCards.getCard(i).getNumber()] = mjCards.getCard(i);
		}
	}

	private void copy(Card c, Card[] arrCards) {
		if (c == null) {
			return;
		}
		arrCards[c.getNumber()] = c;
	}

	private void validate(MajiangGame mjGame, Card[] arrCards) {

		for (int i = 0; i < arrCards.length; i++) {
			MajiangCard c = (MajiangCard) arrCards[i];
			if (mjGame instanceof TiantaiMajiangGame) {
				if (i >= 72 && i < 108) {
					continue;
				}
			} else if (mjGame instanceof HangzhouMajiangGame) {
				if (i >= 136 && i < 144) {
					continue;
				}
			}
			if (c == null) {
				throw new RuntimeException("### card is null!! i [" + i + "]");
			}
			if (c.getNumber() != i) {
				throw new RuntimeException(
						"### card number do not match the sequence! number["
								+ c.getNumber() + "] i[" + i + "]");
			}
		}
	}

	public void listen(Game game, Action action) {
		if(1 == 1){
			return ;
		}
		
		Card[] arrCards = this.initArrCards(game);

		int total = 0;

		MajiangGame mjGame = (MajiangGame) game;
		MajiangPlayer mjPlayer = mjGame.getDealer();

		MajiangBlackCards mbcs = mjGame.getMajiangBlackCards();
		this.copy(mbcs, arrCards);
		total += mbcs.size();

		MajiangCard mjCard = mjGame.getBaida();
		if (mjCard != null) {
			if (mjGame instanceof TiantaiMajiangGame) {

			} else if (mjGame instanceof HangzhouMajiangGame) {

			} else {
				this.copy(mjCard, arrCards);
				total += 1;
			}
		}

		for (int i = 0; i < game.getActivePlayers(); i++) {
			MajiangPlayer nextPlayer = (MajiangPlayer) game.getPlayerByIndex(i);
			MajiangInnerCards mics = nextPlayer.getMajiangInnerCards();
			MajiangMiddleCards mmcs = nextPlayer.getMajiangMiddleCards();
			MajiangOutterCards mocs = nextPlayer.getMajiangOutterCards();
			this.copy(mics, arrCards);
			this.copy(mmcs, arrCards);
			this.copy(mocs, arrCards);
			total += mics.size();
			total += mmcs.size();
			total += mocs.size();
		}
		if (total != mjGame.getAllCards().size()) {
			throw new RuntimeException("### total is " + total);
		}
		this.validate(mjGame, arrCards);
	}
}
