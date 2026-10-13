package com.attic.bj.majiang.rule.judger.hu.type;

import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangHuaHuJudger implements MajiangHuJudger {

	public static class HuaDetail {
		int sequence;
		int zhengHua;
		int yeHua;

		@Override
		public String toString() {
			return this.zhengHua + " " + this.yeHua + " " + this.sequence;
		}

		public HuaDetail(int sequence, int zhengHua, int yeHua) {
			this.sequence = sequence;
			this.zhengHua = zhengHua;
			this.yeHua = yeHua;
		}

		public int getSequence() {
			return sequence;
		}

		public int getZhengHua() {
			return zhengHua;
		}

		public int getYeHua() {
			return yeHua;
		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.HUA;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		return HuaJudgeUtil.judge(mjGame, mjPlayer,
				mjHuCards.findHuaUnitCards());
	}
}
