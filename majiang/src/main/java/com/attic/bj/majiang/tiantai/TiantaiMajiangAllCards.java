package com.attic.bj.majiang.tiantai;

import com.attic.bj.core.card.Card;
import com.attic.bj.majiang.card.MajiangAllCards;
import com.attic.bj.majiang.card.MajiangCard;

public class TiantaiMajiangAllCards extends MajiangAllCards {

	public void start() {
		this.initCards();
		Card[] cards = this.getCardsByUnit(MajiangCard.TIAO);
		this.removeCards(cards);
	}
}
