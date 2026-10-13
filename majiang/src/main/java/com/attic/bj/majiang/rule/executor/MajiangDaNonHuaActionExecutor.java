package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.card.Card;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.card.MajiangOutterCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangDaNonHuaActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		MajiangPlayer player = (MajiangPlayer) mjAction.getPlayer();
		MajiangInnerCards mics = player.getMajiangInnerCards();
		MajiangOutterCards mocs = player.getMajiangOutterCards();
		Card c = mjAction.getCards().getHeadCard();
		mics.removeCard(c);
		mocs.addTailCard(c);
	}

}
