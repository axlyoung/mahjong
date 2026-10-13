package com.attic.bj.majiang.ningbo;

import com.attic.bj.majiang.card.MajiangHuaUnitCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.type.HuType;
import com.attic.bj.majiang.rule.judger.hu.type.HuaJudgeUtil;
import com.attic.bj.majiang.rule.judger.hu.type.MajiangHuaHuJudger.HuaDetail;
import com.attic.bj.majiang.user.MajiangPlayer;

public class NingboMajiangHuaJudgeUtil {

	public static int judge(MajiangGame mjGame, MajiangPlayer mjPlayer) {

		MajiangMiddleCards mmcs = mjPlayer.getMajiangMiddleCards();
		if (mmcs == null) {
			return 0;
		}
		MajiangHuaUnitCards mhucs = mmcs.getMajiangHuaUnitCards();
		if (mhucs == null) {
			return 0;
		}
		HuType huType = HuaJudgeUtil.judge(mjGame, mjPlayer, mhucs);
		if (!huType.isShooted()) {
			return 0;
		}
		HuaDetail huaDetail = (HuaDetail) huType.getDetail();
		NingboMajiangRoomInfo ri = (NingboMajiangRoomInfo) mjGame.getRoom()
				.getRoomInfo();

		return huaDetail.getSequence() + huaDetail.getZhengHua()
				* ri.getJinhua() + huaDetail.getYeHua() * ri.getYehua();
	}
}
