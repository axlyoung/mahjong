package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangAnChiUnitCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangChiUnitCards;
import com.attic.bj.majiang.card.MajiangDuiziUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangDuiduiHuJudger implements MajiangHuJudger {

	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.DUIDUIHU;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		List<MajiangUnitCards> listMjUnitCards = mjHuCards.getListMjUnitCards();
		if (listMjUnitCards == null || listMjUnitCards.size() == 0) {
			return new HuType(false, null);
		}
		for (MajiangUnitCards mucs : listMjUnitCards) {
			if (mucs instanceof MajiangChiUnitCards) {
				return new HuType(false, null);
			}
			if (mucs instanceof MajiangAnChiUnitCards) {
				return new HuType(false, null);
			}
		}
		MajiangDuiziUnitCards mdzucs = mjHuCards.findDuiziUnitCards();
		MajiangCard tmpMc = (MajiangCard) mdzucs.getHeadCard();
		if (tmpMc.isUnit(MajiangCard.ZFB)) {
			return new HuType(true, true);
		}
		if (tmpMc.isUnit(MajiangCard.DNXB)) {
			boolean shooted = ZiHuaOrder.getDnxbOrder(tmpMc.getType())
					.intValue() == Math.abs(mjGame.getDealer().getPlayerOrder()
					- mjPlayer.getPlayerOrder());
			return new HuType(true, shooted);
		}
		return new HuType(true, false);

	}

}
