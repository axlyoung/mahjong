package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangAnGangUnitCards;
import com.attic.bj.majiang.card.MajiangAnPengUnitCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangMingGangUnitCards;
import com.attic.bj.majiang.card.MajiangPengUnitCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.card.MajiangXianGangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangZfbHuJudger implements MajiangHuJudger {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.ZFB;
	}
	
	/**
	 * 如果三个是百搭,暂时不算它
	 */
	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		int total = 0;
		List<MajiangUnitCards> listUnitCards = mjHuCards.getListMjUnitCards();
		for (MajiangUnitCards mucs : listUnitCards) {

			if (mucs instanceof MajiangAnPengUnitCards) {
				if (mucs.totalBaida() == 3) {
					continue;
				}
				MajiangCard mc = mucs.firstNonBaidaCard();
				String type = mc.getType();
				if (type.equals("中") || type.equals("发") || type.equals("白")) {
					total += 1;
				}
				continue;

			}
			if (mucs instanceof MajiangPengUnitCards || mucs instanceof MajiangMingGangUnitCards || mucs instanceof MajiangXianGangUnitCards || mucs instanceof MajiangAnGangUnitCards) {
				String type = mucs.getHeadCard().getType();
				if (type.equals("中") || type.equals("发") || type.equals("白")) {
					total += 1;
				}
				continue;
			}
		}

		return new HuType(true, total);
	}

}
