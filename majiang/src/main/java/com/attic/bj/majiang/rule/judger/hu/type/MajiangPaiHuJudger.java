package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangAnGangUnitCards;
import com.attic.bj.majiang.card.MajiangAnPengUnitCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangDuiziUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangMingGangUnitCards;
import com.attic.bj.majiang.card.MajiangPengUnitCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.card.MajiangXianGangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.game.MajiangGameInfo;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangPaiHuJudger implements MajiangHuJudger {

	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.PAIHU;
	}

	public static class PaihuDetail {
		public static int TWOBAIDA = 1;
		public static int ZFB = 2;
		public static int WF = 3;
		public static int QF = 4;
		public static int NORMAL = 5;

		private int duiziType;

		public int getDuiziType() {
			return duiziType;
		}

		public PaihuDetail(int duiziType) {
			this.duiziType = duiziType;
		}
	}

	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		List<MajiangUnitCards> listMjUnitCards = mjHuCards.getListMjUnitCards();
		for (MajiangUnitCards mucs : listMjUnitCards) {
			if (mucs instanceof MajiangPengUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangAnPengUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangMingGangUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangAnGangUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangXianGangUnitCards) {
				return new HuType(false, null);
			}
		}
		MajiangDuiziUnitCards mdzucs = mjHuCards.findDuiziUnitCards();
		int totalBaida = mdzucs.totalBaida();
		MajiangCard mc = null;
		if (totalBaida == 2) {
			return new HuType(true, new PaihuDetail(PaihuDetail.TWOBAIDA));
		} else {
			mc = mdzucs.firstNonBaidaCard();
		}
		if (mc.isUnit(MajiangCard.ZFB)) {
			return new HuType(true, new PaihuDetail(PaihuDetail.ZFB));
		}
		if (mc.isUnit(MajiangCard.DNXB)) {
			int dis = Math.abs(mjPlayer.getPlayerOrder()
					- mjGame.getDealer().getPlayerOrder());
			int dis1 = ZiHuaOrder.getDnxbOrder(mc.getType());
			if (dis == dis1) {
				return new HuType(true, new PaihuDetail(PaihuDetail.WF));
			}
			MajiangGameInfo mjGameInfo = (MajiangGameInfo) mjGame.getGameInfo();
			if (dis1 == mjGameInfo.getQuan()) {
				return new HuType(true, new PaihuDetail(PaihuDetail.QF));
			}
		}
		return new HuType(true, new PaihuDetail(PaihuDetail.NORMAL));
	}
}
