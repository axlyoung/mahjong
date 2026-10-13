package com.attic.bj.majiang.hongzhong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangHuCards;
import com.attic.bj.majiang.card.MajiangHuCards.HuFinderEnum;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.DefaultMajiangHuStrategy;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuJudger;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuResult;
import com.attic.bj.majiang.rule.judger.hu.type.FanDetail;
import com.attic.bj.majiang.user.MajiangPlayer;

public class HongzhongMajiangHuStrategy extends DefaultMajiangHuStrategy {

	@Override
	protected List<FanDetail> calculateFanDetail(MajiangGame mjGame,
			MajiangPlayer mjPlayer, int huType, MajiangHuCards mjHuCards) {
		// TODO Auto-generated method stub
		List<FanDetail> list = new ArrayList<FanDetail>();

		FanDetail fd = new FanDetail();
		if (mjHuCards.getHuFinderType() == HuFinderEnum.SIBAIDA) {
			if (huType != MajiangAction.FANGQIANGHU) {
				fd.add(MajiangHuJudger.SIBAIDA, 4);
			}
		}
		list.add(fd);
		return list;
	}

	@Override
	public MajiangHuResult findLegalHuResult(MajiangGame mjGame,
			List<MajiangHuResult> listHuResult) {
		// TODO Auto-generated method stub
		if (listHuResult == null || listHuResult.size() == 0) {
			return null;
		}

		String huAccount = listHuResult.get(0).getMjPlayer().getAccount();
		HongzhongMajiangGame hongzhongGame = (HongzhongMajiangGame) mjGame;
		if(hongzhongGame.daHongzhong(huAccount)){  //打过红中不能胡
			return null;
		}
		

		Collections.sort(listHuResult);
		MajiangHuResult finalResult = listHuResult.get(0);
		return finalResult;
	}

}
