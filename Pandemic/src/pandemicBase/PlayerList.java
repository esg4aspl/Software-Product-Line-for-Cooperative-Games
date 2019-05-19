package pandemicBase;

import java.util.ArrayList;
import java.util.List;

import core.AbstractCard;
import core.AbstractPlayer;
import core.IPlayerList;

public class PlayerList implements IPlayerList {
	List<AbstractPlayer> playerList;
	public PlayerList() {
		this.playerList= new ArrayList<AbstractPlayer>();
	}
	@Override
	public int getNumberOfPlayers() {
		playerList = new ArrayList<AbstractPlayer>();
		return 0;
	}

	@Override
	public AbstractPlayer getPlayer(int index) {
		return playerList.get(index);
	}

	@Override
	public List<AbstractPlayer> getPlayers() {
		return playerList;
	}

	@Override
	public void addPlayer(AbstractPlayer player) {
		playerList.add(player);

	}

	@Override
	public void removePlayer(AbstractPlayer player) {
		playerList.remove(player);
	}

	@Override
	public String getPlayerStatus() {
		String stringToReturn = "";
		for(AbstractPlayer player : playerList) {
			String handToString = "";
			for (AbstractCard card: player.getHand().getDeck()) {
				handToString = handToString + card +"\n";
			}
		
			stringToReturn = stringToReturn + player.toString() + "\nCards in hand: " + handToString + " \n";
		}
		return stringToReturn;

	}
}
