package com.attic.bj.majiang.fenhua;

import com.attic.bj.core.game.Game;
import com.attic.bj.core.room.DefaultRoom;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.core.user.Player;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.channel.MajiangChannel;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.game.MajiangGameInfo;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuResult;

public class FenhuaMajiangChannel extends MajiangChannel {

	@Override
	public Room createRoom(String account, RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		String id = server.generateId();
		FenhuaMajiangRoomInfo fhRoomInfo = (FenhuaMajiangRoomInfo) roomInfo;
		Room room;
		if (fhRoomInfo.isPinghu()) {
			room = new DefaultRoom(roomInfo, id);
		} else {
			room = new DefaultRoom(roomInfo, id, fhRoomInfo.getChongciMoney());
		}
		room.setChannel(this);
		return room;
	}

	@Override
	public Game createGame(RoomInfo roomInfo, Game lastGame,Room room) {
		// TODO Auto-generated method stub

		int quan = 0, zuan = 0;
		if (null != lastGame) {
			MajiangGameInfo lastGameInfo = (MajiangGameInfo) lastGame
					.getGameInfo();
			MajiangGame lastMjGame = (MajiangGame) lastGame;
			int lastZuan = lastGameInfo.getZuan();
			int lastQuan = lastGameInfo.getQuan();

			if (lastZuan == roomInfo.getPlayerNum() - 1) {
				zuan = 0;
				quan = lastQuan + 1;
			} else {
				zuan = lastZuan + 1;
				quan = lastQuan;
			}

			Player lastPlayer = lastMjGame.getPlayerByIndex(lastZuan);
			for (int i = 0; i < lastMjGame.getMajiangHuResults().size(); i++) {
				MajiangHuResult mjHuResult = lastMjGame.getMajiangHuResults()
						.getMajiangHuResult(i);
				if (mjHuResult.getHuType() != MajiangAction.HUANGPAI) {
					if (lastPlayer == mjHuResult.getMjPlayer()) {
						zuan = lastZuan;
						quan = lastQuan;
					}
				}
			}
		}
		MajiangGameInfo gameInfo = new MajiangGameInfo();
		gameInfo.setPlayerNum(roomInfo.getPlayerNum());
		gameInfo.setZuan(zuan);
		gameInfo.setQuan(quan);

		MajiangGame fenhuaGame = new MajiangGame(gameInfo);
		return fenhuaGame;
	}

}
