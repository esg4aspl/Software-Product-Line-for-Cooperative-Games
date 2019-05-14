package core;

import java.util.List;

public interface IView {
	
	
	public AbstractAction getActionChoiceFromPlayer(AbstractReferee referee);
	public AbstractBoardNode getDestinationNodeFromPlayer(AbstractReferee referee);
	public AbstractCard getChosenCardFromPlayer(AbstractDeck deck);
	public List<AbstractCard> getHandDeckFromPlayer();
	public AbstractPlayer whichplayerToShareInformationWith(AbstractReferee referee);
	public void showSetUpInformation();
	public void showDeck(AbstractDeck deck);
	public void showActionOptions();
	public void showResponseToPlayer(String message);
	public void announceWinner(String winner);
	public void showNewlyInfectedNodeList(AbstractReferee referee);
	public void showBoardStatue(AbstractReferee referee);
	public Color askDiseaseColor(AbstractReferee referee);
	
}
