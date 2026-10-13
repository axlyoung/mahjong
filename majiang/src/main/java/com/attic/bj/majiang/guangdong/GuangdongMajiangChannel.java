package com.attic.bj.majiang.guangdong;

import com.attic.bj.core.card.Cards;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.hongzhong.HongzhongMajiangChannel;

public class GuangdongMajiangChannel extends HongzhongMajiangChannel {
	
	
	@Override
	public Cards createAllCards(RoomInfo roomInfo) {
		MajiangCards mcs = (MajiangCards) this.applicationContext
				.getBean("majiangAllCardsOfFull");
		mcs.removeCards(mcs.getCardsByUnit(MajiangCard.HUA));
		return mcs;
	}
}
