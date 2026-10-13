package com.attic.bj.majiang.helper;

import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public interface MajiangGangHelper {
	
	/**
	 * 计算连续杠的次数，从moback开始算
	 * @param mjGame
	 * @param mjPlayer
	 * @param fromIndex
	 * @param anGang
	 * @param mingGang
	 * @param xianGang
	 * @param hua
	 * @return
	 */
	public int sequenceGangSize(MajiangGame mjGame, MajiangPlayer mjPlayer,
			int fromIndex, boolean anGang, boolean mingGang, boolean xianGang,
			boolean hua);
	
	/**
	 * 计算明杠打的人，从moback开始算
	 * @param mjGame
	 * @param mjPlayer
	 * @param fromIndex
	 * @return
	 */
	public MajiangPlayer isMingGangDa(MajiangGame mjGame,
			MajiangPlayer mjPlayer, int fromIndex);

}
