package com.attic.bj.majiang.rule.judger;

import java.util.List;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangAnGangUnitCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangAnGangActionJudger extends MajiangActionJudger {

	@Override
	protected MajiangActions judgeInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		// TODO Auto-generated method stub

		MajiangActions mas = new MajiangActions();
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();
		MajiangInnerCards majiangInnerCards = mp.getMajiangInnerCards();
		List<MajiangAnGangUnitCards> list = majiangInnerCards
				.findMajiangAnGangUnitCards();
		if (list == null) {
			return null;
		}
		for (MajiangAnGangUnitCards magucs : list) {
			if(((MajiangCard)magucs.getHeadCard()).isBaida()){
				continue;
			}
			MajiangAction ma = new MajiangAction(mp, MajiangAction.ANGANG,
					magucs, true);
			mas.addAction(ma);
		}
		return mas;
	}
}
