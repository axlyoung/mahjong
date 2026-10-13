package com.attic.bj.majiang.rule.judger.hu;

import java.util.ArrayList;
import java.util.List;

import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangThreePassiveBao implements MajiangBaoCalculator {

	private MajiangBaoCalculator majiangThreeActiveBao;

	public void setMajiangThreeActiveBao(
			MajiangBaoCalculator majiangThreeActiveBao) {
		this.majiangThreeActiveBao = majiangThreeActiveBao;
	}

	@Override
	public List<MajiangPlayer> calculatorMajiangBaos(MajiangGame mjGame,
			MajiangHuResult mjHuResult, MajiangPlayer mjPlayer) {
		// TODO Auto-generated method stub

		List<MajiangPlayer> listRetPlayer = new ArrayList<MajiangPlayer>();

		MajiangPlayer mjNextPlayer = mjPlayer;
		while ((mjNextPlayer = (MajiangPlayer) mjGame.nextPlayer(mjNextPlayer)) != mjPlayer) {
			List<MajiangPlayer> listPlayer = majiangThreeActiveBao
					.calculatorMajiangBaos(mjGame, mjHuResult, mjNextPlayer);
			if (listPlayer!=null && listPlayer.contains(mjPlayer)) {
				listRetPlayer.add(mjNextPlayer);
			}
		}
		return listRetPlayer.size() == 0 ? null : listRetPlayer;

	}
}
