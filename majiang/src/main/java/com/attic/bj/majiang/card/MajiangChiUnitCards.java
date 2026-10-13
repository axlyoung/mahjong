package com.attic.bj.majiang.card;

import java.util.HashMap;
import java.util.Map;

import com.attic.bj.core.server.Formatter;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangChiUnitCards extends MajiangUnitCards implements Formatter {

	private MajiangCard mjDaCard;

	private MajiangPlayer mjDaPlayer;

	public MajiangCard getMjDaCard() {
		return mjDaCard;
	}

	public MajiangPlayer getMjDaPlayer() {
		return mjDaPlayer;
	}

	public MajiangChiUnitCards(MajiangPlayer mjDaPlayer, MajiangCard mjDaCard,
			MajiangCard card1, MajiangCard card2) {

		this.mjDaPlayer = mjDaPlayer;
		this.mjDaCard = mjDaCard;
		
		this.addTailCard(mjDaCard);
		this.addTailCard(card1);
		this.addTailCard(card2);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "吃";
	}

	@Override
	public Map format() {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int cn = this.mjDaCard.getNumber();
		int cns[] = this.toNumberArray();
		map.put("a", "chi");
		map.put("cns", this.orderedCardNumber(cns, cn));
		map.put("who", this.mjDaPlayer.getPlayerOrder());
		map.put("cn", cn);
		return map;
	}

}
