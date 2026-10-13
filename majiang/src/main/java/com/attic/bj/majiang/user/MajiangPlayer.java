package com.attic.bj.majiang.user;

import com.attic.bj.core.user.AbstractPlayer;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.card.MajiangOutterCards;

public class MajiangPlayer extends AbstractPlayer {

	public MajiangPlayer(String account) {
		super(account);
		// TODO Auto-generated constructor stub
	}

	private MajiangInnerCards majiangInnerCards = new MajiangInnerCards();
	private MajiangMiddleCards majiangMiddleCards = new MajiangMiddleCards();
	private MajiangOutterCards majiangOutterCards = new MajiangOutterCards();

	public MajiangInnerCards getMajiangInnerCards() {
		return this.majiangInnerCards;
	}

	public MajiangMiddleCards getMajiangMiddleCards() {
		return this.majiangMiddleCards;
	}

	public MajiangOutterCards getMajiangOutterCards() {
		return this.majiangOutterCards;
	}

	@Override
	public String toString() {
		String str = "### " + super.toString();
		str += "\r\n";
		str += majiangOutterCards;
		str += "\r\n";
		str += majiangMiddleCards;
		str += "\r\n";
		str += majiangInnerCards;
		return str;
	}

	public void clearCards() {
		this.majiangInnerCards.clear();
		this.majiangMiddleCards.clear();
		this.majiangOutterCards.clear();
	}

}
