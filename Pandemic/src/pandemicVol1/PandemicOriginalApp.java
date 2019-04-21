package pandemicVol1;

public class PandemicOriginalApp {

	public static void main(String[] args) {
		PandemicOriginalGameConfiguration gameConfiguration = new PandemicOriginalGameConfiguration();
		PandemicOriginalReferee referee = new PandemicOriginalReferee(gameConfiguration);
		referee.setup();
		referee.startGame();

	}

}
