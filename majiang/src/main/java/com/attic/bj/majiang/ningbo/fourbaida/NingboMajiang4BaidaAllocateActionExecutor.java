package com.attic.bj.majiang.ningbo.fourbaida;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.card.Card;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.card.MajiangAllCards;
import com.attic.bj.majiang.card.MajiangBlackCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.ningbo.NingboMajiangGame;
import com.attic.bj.majiang.rule.executor.MajiangAllocateWithHuaActionExecutor;

public class NingboMajiang4BaidaAllocateActionExecutor extends
		MajiangAllocateWithHuaActionExecutor {

	private static final Logger logger = LoggerFactory
			.getLogger(NingboMajiang4BaidaAllocateActionExecutor.class);

	private MajiangCard findFirstNonHuaCard(MajiangBlackCards mbcs, int len) {
		MajiangCard mc = (MajiangCard) mbcs.getCard(len - 1);
		if (!mc.isUnit(MajiangCard.HUA)) {
			return mc;
		}
		return this.findFirstNonHuaCard(mbcs, len - 1);
	}

	// 翻百搭
	public void exec(Game game, Action action) {
		super.exec(game, action);
		NingboMajiangGame ningboMajiangGame = (NingboMajiangGame) game;
		MajiangAllCards macs = (MajiangAllCards) ningboMajiangGame
				.getAllCards();
		MajiangBlackCards mbcs = ningboMajiangGame.getMajiangBlackCards();
		MajiangCard mc = this.findFirstNonHuaCard(mbcs, mbcs.size());
	//	System.out.println(mc);
		String nextType = mc.nextType();
		Card[] cards = macs.findCardsByType(nextType);

		for (Card c : cards) {
			MajiangCard tmpMc = (MajiangCard) c;
	//		System.out.println(tmpMc);
			tmpMc.setBaida(true);
		}
		mbcs.removeCard(mc);
		// System.out.println("mbcs " + mbcs.size());
		ningboMajiangGame.setBaida(mc);
	}
}
