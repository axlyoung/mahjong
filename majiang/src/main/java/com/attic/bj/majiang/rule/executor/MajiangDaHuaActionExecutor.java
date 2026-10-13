package com.attic.bj.majiang.rule.executor;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangDaHuaActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();
		MajiangMiddleCards mmcs = mp.getMajiangMiddleCards();
		MajiangInnerCards mmis = mp.getMajiangInnerCards();
		MajiangCard mc = (MajiangCard) mmis.removeCard(mjAction.getCards()
				.getTailCard());
	//	System.out.println("### mc " + mc);
		mmcs.addHuaCard(mc);
	}

}
