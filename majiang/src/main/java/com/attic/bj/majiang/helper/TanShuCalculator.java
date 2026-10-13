package com.attic.bj.majiang.helper;

import com.attic.bj.majiang.user.MajiangPlayer;

public interface TanShuCalculator {
	
	/**
	 * 计算滩数
	 * @param actionPlayer
	 * @param daPlayer
	 * @return
	 */
	public int calculatorTanShu(MajiangPlayer actionPlayer,MajiangPlayer daPlayer);
	
}
