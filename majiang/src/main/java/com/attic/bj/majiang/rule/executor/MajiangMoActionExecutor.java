package com.attic.bj.majiang.rule.executor;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangBlackCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public abstract class MajiangMoActionExecutor extends MajiangActionExecutor {

	abstract protected int getDir();

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangBlackCards mbcs = mjGame.getMajiangBlackCards();
		MajiangPlayer mjPlayer = (MajiangPlayer) mjAction.getPlayer();
		MajiangInnerCards mics = mjPlayer.getMajiangInnerCards();
		MajiangCard c;
		if (getDir() == 0) {
			c = (MajiangCard) mbcs.removeHeadCard();
		} else {
			c = (MajiangCard) mbcs.removeTailCard();
		}
		mics.addTailCard(c);
		mjPlayer.getMajiangInnerCards().sort();
	}
}
