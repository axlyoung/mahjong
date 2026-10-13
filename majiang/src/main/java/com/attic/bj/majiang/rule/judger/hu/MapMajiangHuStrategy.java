package com.attic.bj.majiang.rule.judger.hu;

import java.util.List;
import java.util.Map;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MapMajiangHuStrategy implements MajiangHuStrategy {

	private Map<String, MajiangHuStrategy> mapHuStrategy;

	public void setMapHuStrategy(Map<String, MajiangHuStrategy> mapHuStrategy) {
		this.mapHuStrategy = mapHuStrategy;
	}

	@Override
	public List<MajiangHuCards> findLegalHuCards(MajiangGame mjGame,
			List<MajiangUnitCards> listMiddleMjUnitCards, MajiangCards mjCards,
			MajiangCard mjCard) {
		// TODO Auto-generated method stub
		MajiangHuStrategy mjHuStrategy = mapHuStrategy.get(mjGame.getRoom()
				.getRoomInfo().getName());
		return mjHuStrategy.findLegalHuCards(mjGame, listMiddleMjUnitCards,
				mjCards, mjCard);
	}

	@Override
	public List<MajiangHuResult> calHuResultFan(MajiangGame mjGame,
			MajiangPlayer mjPlayer, int huType,
			List<MajiangHuCards> listMjHuCards) {
		// TODO Auto-generated method stub
		MajiangHuStrategy mjHuStrategy = mapHuStrategy.get(mjGame.getRoom()
				.getRoomInfo().getName());
		return mjHuStrategy.calHuResultFan(mjGame, mjPlayer, huType,
				listMjHuCards);
	}

	@Override
	public MajiangHuResult findLegalHuResult(MajiangGame mjGame,
			List<MajiangHuResult> listHuResult) {
		// TODO Auto-generated method stub
		MajiangHuStrategy mjHuStrategy = mapHuStrategy.get(mjGame.getRoom()
				.getRoomInfo().getName());
		return mjHuStrategy.findLegalHuResult(mjGame, listHuResult);
	}

}
