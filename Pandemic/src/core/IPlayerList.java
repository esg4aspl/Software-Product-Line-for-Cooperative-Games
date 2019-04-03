package core;

import java.util.List;

public interface IPlayerList {

	public int getNumberOfPlayers();
	public AbstractPlayer getPlayer(int index);
	public List<AbstractPlayer> getPlayers();
	public void addPlayer(AbstractPlayer player);
	public void removePlayer(AbstractPlayer player);
	public String getPlayerStatus(); // ne için gerekli?

}
