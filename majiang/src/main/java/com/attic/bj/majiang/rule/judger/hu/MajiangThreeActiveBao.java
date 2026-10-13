package com.attic.bj.majiang.rule.judger.hu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.attic.bj.majiang.card.MajiangChiUnitCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.card.MajiangMingGangUnitCards;
import com.attic.bj.majiang.card.MajiangPengUnitCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.card.MajiangXianGangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangThreeActiveBao implements MajiangBaoCalculator {

	private int times = 3;

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public List<MajiangPlayer> calculatorMajiangBaos(MajiangGame mjGame,
			MajiangHuResult mjHuResult, MajiangPlayer mjPlayer) {
		// TODO Auto-generated method stub
		List<MajiangPlayer> listMjPlayer = new ArrayList<MajiangPlayer>();

		MajiangMiddleCards mmcs = mjPlayer.getMajiangMiddleCards();
		List<MajiangUnitCards> listUnitCards = mmcs.getListUnitCards();
		if (listUnitCards == null || listUnitCards.size() == 0) {
			return null;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (MajiangUnitCards mucs : listUnitCards) {
			if (mucs instanceof MajiangPengUnitCards) {
				MajiangPengUnitCards tmpMucs = (MajiangPengUnitCards) mucs;
				String account = tmpMucs.getMjDaPlayer().getAccount();
				Integer intRet = map.get(account);
				if (intRet == null) {
					map.put(account, 1);
				} else {
					map.put(account, intRet.intValue() + 1);
				}
			}
			if (mucs instanceof MajiangChiUnitCards) {
				MajiangChiUnitCards tmpMucs = (MajiangChiUnitCards) mucs;
				String account = tmpMucs.getMjDaPlayer().getAccount();
				Integer intRet = map.get(account);
				if (intRet == null) {
					map.put(account, 1);
				} else {
					map.put(account, intRet.intValue() + 1);
				}
			}
			if (mucs instanceof MajiangMingGangUnitCards) {
				MajiangMingGangUnitCards tmpMucs = (MajiangMingGangUnitCards) mucs;
				String account = tmpMucs.getMjDaPlayer().getAccount();
				Integer intRet = map.get(account);
				if (intRet == null) {
					map.put(account, 1);
				} else {
					map.put(account, intRet.intValue() + 1);
				}
			}
			if (mucs instanceof MajiangXianGangUnitCards) {
				MajiangXianGangUnitCards tmpMucs = (MajiangXianGangUnitCards) mucs;
				String account = tmpMucs.getMjDaPlayer().getAccount();
				Integer intRet = map.get(account);
				if (intRet == null) {
					map.put(account, 1);
				} else {
					map.put(account, intRet.intValue() + 1);
				}
			}
		}

		for (String key : map.keySet()) {
			Integer intRet = map.get(key);
			if (intRet != null && intRet.intValue() >= this.times) {
				listMjPlayer
						.add((MajiangPlayer) mjGame.getPlayerByAccount(key));
			}
		}
		return listMjPlayer.size() == 0 ? null : listMjPlayer;
	}
}
