package com.attic.bj.core.action;

import com.attic.bj.common.helper.AttributeAccessor;
import com.attic.bj.core.card.Cards;
import com.attic.bj.core.user.Player;

public interface Action extends AttributeAccessor{

	public Player getPlayer();

	public int getType();

	public Cards getCards();

	public boolean isUserAction();
	
	public void changeType(int type);
	
	public void changeCards(Cards cards);

}
