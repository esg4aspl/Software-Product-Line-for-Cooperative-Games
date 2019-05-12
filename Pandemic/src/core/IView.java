package core;

import java.util.List;

import pandemicBase.BoardNode;
import pandemicBase.Player;

public interface IView {
	
	
	public AbstractAction getActionChoiceFromPlayer(AbstractReferee referee);
	public AbstractBoardNode getDestinationNodeFromPlayer(AbstractReferee referee);
	public AbstractCard getDrawnCardFromPlayer(AbstractReferee referee);
	public List<AbstractCard> getHandDeckFromPlayer();
	public AbstractPlayer whichplayerToShareInformationWith(AbstractReferee referee);
	public void ShowPlayDeck(AbstractReferee referee);
	public void showActionOptions();
	public void showResponseTo(String message);
	public void announceWinner(String winner);

}
