package com.attic.bj.majiang.rule.judger.hu.type;

import com.attic.bj.majiang.card.MajiangAnGangUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangMingGangUnitCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.card.MajiangXianGangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangGangHuJudger implements MajiangHuJudger {

	public static class GangDetail {
		private int mingGang;
		private int anGang;
		private int xianGang;

		public GangDetail(int mingGang, int anGang, int xianGang) {
			this.mingGang = mingGang;
			this.anGang = anGang;
			this.xianGang = xianGang;
		}

		public int getMingGang() {
			return mingGang;
		}

		public int getAnGang() {
			return anGang;
		}

		public int getXianGang() {
			return xianGang;
		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.GANG;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		int mg = 0;
		int xg = 0;
		int ag = 0;
		for (MajiangUnitCards mucs : mjHuCards.getListMjUnitCards()) {
			if (mucs instanceof MajiangMingGangUnitCards) {
				mg++;
			} else if (mucs instanceof MajiangAnGangUnitCards) {
				ag++;
			} else if (mucs instanceof MajiangXianGangUnitCards) {
				xg++;
			}
		}
		if (mg == 0 && xg == 0 && ag == 0) {
			return new HuType(false, null);
		}
		return new HuType(true, new GangDetail(mg, ag, xg));
	}

}
