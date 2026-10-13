package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangBlackCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangAllocateActionExecutor extends MajiangActionExecutor {

	public void exec(Game game, Action action) {

		MajiangGame mg = (MajiangGame) game;

		MajiangBlackCards bcs = mg.getMajiangBlackCards();
		for (int i = 0; i < 3; i++) {
			MajiangPlayer dealer = mg.getDealer();
			MajiangPlayer nextPlayer = dealer;
			do {
				nextPlayer.getMajiangInnerCards().addTailCards(
						bcs.removeHeadCards(4));
				nextPlayer = (MajiangPlayer) mg.nextPlayer(nextPlayer);
			} while (nextPlayer != dealer);
		}
		MajiangPlayer dealer = mg.getDealer();
		MajiangPlayer nextPlayer = dealer;
		do {
			nextPlayer.getMajiangInnerCards().addTailCards(
					bcs.removeHeadCards(1));
			nextPlayer = (MajiangPlayer) mg.nextPlayer(nextPlayer);
		} while (nextPlayer != dealer);

		// MajiangGame mg = (MajiangGame) game;
		//
		// MajiangBlackCards bcs = mg.getMajiangBlackCards();
		// MajiangPlayer nextPlayer = mg.getDealer();
		// while(true){
		// nextPlayer.getMajiangInnerCards().addTailCards(
		// mg.getMajiangBlackCards().removeHeadCards(13));
		// nextPlayer = (MajiangPlayer)mg.nextPlayer(nextPlayer);
		// if(nextPlayer == mg.getDealer()){
		// break;
		// }
		// }
	}

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub

	}
}
