package com.attic.bj.majiang.rule.judger.hu;

import java.util.List;

import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public interface MajiangBaoCalculator {
	public List<MajiangPlayer> calculatorMajiangBaos(MajiangGame mjGame,MajiangHuResult mjHuResult,MajiangPlayer mjPlayer);
}
