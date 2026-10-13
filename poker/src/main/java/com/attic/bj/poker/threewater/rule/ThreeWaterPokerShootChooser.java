package com.attic.bj.poker.threewater.rule;

import java.util.List;

import com.attic.bj.poker.card.PokerCards;
import com.attic.bj.poker.threewater.ThreeWaterPokerCards;

public interface ThreeWaterPokerShootChooser {
	
	public List<ThreeWaterPokerCards> chooseBetter(PokerCards pokerCards);
	
	public boolean legal(ThreeWaterPokerCards twPcs);
	
}
