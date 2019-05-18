package PandemicKids;
public class PandemicKidsApp {

	public static void main(String[] args) {
		PandemicKidsGameConfiguration gameConfigurationKids = new PandemicKidsGameConfiguration();
		PandemicKidsReferee refereeKids = new PandemicKidsReferee(gameConfigurationKids);
		refereeKids.setup();
		refereeKids.startGame();
	}

}
