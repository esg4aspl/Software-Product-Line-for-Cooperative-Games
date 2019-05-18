package pandemicVol1;


public class PandemicVol1App {

	public static void main(String[] args) {
		PandemicVol1GameConfiguration gameConfiguration = new PandemicVol1GameConfiguration();
		PandemicVol1Referee referee = new PandemicVol1Referee(gameConfiguration);
		referee.setup();
		referee.startGame();

	}

}
