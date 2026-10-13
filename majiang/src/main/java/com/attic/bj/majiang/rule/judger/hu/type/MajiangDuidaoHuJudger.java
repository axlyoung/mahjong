package com.attic.bj.majiang.rule.judger.hu.type;

import java.util.List;

import com.attic.bj.majiang.card.MajiangAnPengUnitCards;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangDuidaoHuJudger implements MajiangHuJudger {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MajiangHuJudger.DUIDAO;
	}

	@Override
	public HuType judge(MajiangGame mjGame, MajiangPlayer mjPlayer, int huType,
			MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		List<MajiangUnitCards> list=  mjHuCards.getListMjUnitCards();
		for(MajiangUnitCards mucs:list){
			if(mucs.containsCard(mjHuCards.getMjHuCard())){
				if(mucs instanceof MajiangAnPengUnitCards){
					return new HuType(true,null);
				}
			}
		}
		return new HuType(false,null);
	}

}
