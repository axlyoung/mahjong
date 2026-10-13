package com.attic.bj.majiang.hongzhong;

import java.util.List;

import com.attic.bj.core.card.Card;
import com.attic.bj.core.card.Cards;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.card.MajiangPengUnitCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.MajiangXianGangActionJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class HongzhongMajiangXianGangActionJudger extends
		MajiangXianGangActionJudger {

	@Override
	protected MajiangActions judgeInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangActions mas = new MajiangActions();
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();

		MajiangCard mc = (MajiangCard) mjAction.getCards().getTailCard();
		MajiangMiddleCards mmcs = mp.getMajiangMiddleCards();
		String type = mc.getType();
		List<MajiangUnitCards> listUcs = mmcs.getListUnitCards();
		if (listUcs == null || listUcs.size() == 0) {
			return null;
		}
		for (MajiangUnitCards ucs : listUcs) {
			if (ucs instanceof MajiangPengUnitCards) {
				if (ucs.getHeadCard().getType().equals(type)) {
					Cards cards = new MajiangCards();
					cards.addTailCard(mc);
					mas.addAction(new MajiangAction(mp, MajiangAction.XIANGANG,
							cards, true));
					return mas;
				}
			}
		}
		return null;
	}

}
