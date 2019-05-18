package pandemicOriginal;

import java.util.ArrayList;
import java.util.List;

import core.AbstractBoardNode;
import core.AbstractGameConfiguration;
import core.Color;
import pandemicBase.BoardNode;

public class PandemicOriginalGameConfiguration extends AbstractGameConfiguration {

	@Override
	public int getNumberOfDiseaseCubeTypes() {
		return 4;

	}

	@Override
	public int getNumberOfDiseaseCubePerCubeType() {
		return 24;
	}

	@Override
	public int getOutbreakRange() {
		return 9;
	}

	@Override
	public int getNumberOfPlayers() {
		return 4;
	}

	@Override
	public int getNumberOfCardsPerPlayer() {
		return 2;
	}

	@Override
	public int[] getValuesOfInfectionRateNumber() {
		int[] values = new int[]{2,2,2,3,3,4,4};
		return values;
	}

	@Override
	public int getNumberOfNodes() {
		return 48;
	}

	@Override
	public String getInitialBoardNode() {
		return "Atlanta";
	}

	@Override
	public List<AbstractBoardNode> getNodes() {
		List<AbstractBoardNode> nodeList = new ArrayList<AbstractBoardNode>();
		AbstractBoardNode Moscow = new BoardNode("Moscow",Color.BLACK,38);
		AbstractBoardNode Delhi = new BoardNode("Delhi",Color.BLACK,46);
		AbstractBoardNode Istanbul = new BoardNode("Istanbul",Color.BLACK,33);
		AbstractBoardNode Tehran = new BoardNode("Tehran",Color.BLACK,20);
		AbstractBoardNode Kolkata = new BoardNode("Kolkata",Color.BLACK,35);
		AbstractBoardNode Baghdad = new BoardNode("Baghdad",Color.BLACK,17);
		AbstractBoardNode Karachi = new BoardNode("Karachi",Color.BLACK,44);
		AbstractBoardNode Chennai = new BoardNode("Chennai",Color.BLACK,25);
		AbstractBoardNode Cairo = new BoardNode("Cairo",Color.BLACK,36);
		AbstractBoardNode Algiers = new BoardNode("Algiers",Color.BLACK,3);
		AbstractBoardNode Riyadh = new BoardNode("Riyadh",Color.BLACK,11);
		AbstractBoardNode Mumbai = new BoardNode("Mumbai",Color.BLACK,39);
		nodeList.add(Moscow);
		nodeList.add(Delhi);
		nodeList.add(Istanbul);
		nodeList.add(Tehran);
		nodeList.add(Kolkata);
		nodeList.add(Baghdad);
		nodeList.add(Karachi);
		nodeList.add(Chennai);
		nodeList.add(Cairo);
		nodeList.add(Algiers);
		nodeList.add(Riyadh);
		nodeList.add(Mumbai);
		
		AbstractBoardNode Kinshasa = new BoardNode("Kinshasa",Color.YELLOW,26);
		AbstractBoardNode Santiago = new BoardNode("Santiago",Color.YELLOW,16);
		AbstractBoardNode Khartoum = new BoardNode("Khartoum",Color.YELLOW,10);
		AbstractBoardNode LosAngeles = new BoardNode("Los Angeles",Color.YELLOW,37);
		AbstractBoardNode Johannesburg = new BoardNode("Johannesburg",Color.YELLOW,6);
		AbstractBoardNode BuenosAires = new BoardNode("Buenos Aires",Color.YELLOW,34);
		AbstractBoardNode SaoPaulo = new BoardNode("Sao Paulo",Color.YELLOW,42);
		AbstractBoardNode Bogota = new BoardNode("Bogota",Color.YELLOW,24);
		AbstractBoardNode Lima = new BoardNode("Lima",Color.YELLOW,28);
		AbstractBoardNode MexicoCity = new BoardNode("Mexico City",Color.YELLOW,41);
		AbstractBoardNode Lagos = new BoardNode("Lagos",Color.YELLOW,30);
		AbstractBoardNode Miami = new BoardNode("Miami",Color.YELLOW,14);
		nodeList.add(Kinshasa);
		nodeList.add(Santiago);
		nodeList.add(Khartoum);
		nodeList.add(LosAngeles);
		nodeList.add(Johannesburg);
		nodeList.add(BuenosAires);
		nodeList.add(SaoPaulo);
		nodeList.add(Bogota);
		nodeList.add(Lima);
		nodeList.add(MexicoCity);
		nodeList.add(Lagos);
		nodeList.add(Miami);
		
		
		
		AbstractBoardNode Essen = new BoardNode("Essen",Color.BLUE,1);
		AbstractBoardNode SanFrancisco = new BoardNode("San Francisco",Color.BLUE,15);
		AbstractBoardNode Paris = new BoardNode("Paris",Color.BLUE,29);
		AbstractBoardNode Atlanta = new BoardNode("Atlanta",Color.BLUE,8);
		AbstractBoardNode Washington = new BoardNode("Washington",Color.BLUE,7);
		AbstractBoardNode Madrid = new BoardNode("Madrid",Color.BLUE,13);
		AbstractBoardNode NewYork = new BoardNode("New York",Color.BLUE,43);
		AbstractBoardNode Montreal = new BoardNode("Montreal",Color.BLUE,4);
		AbstractBoardNode London = new BoardNode("London",Color.BLUE,23);
		AbstractBoardNode StPatersburg = new BoardNode("St Patersburg",Color.BLUE,9);
		AbstractBoardNode Milan = new BoardNode("Milan",Color.BLUE,12);
		AbstractBoardNode Chicago = new BoardNode("Chicago",Color.BLUE,27);
		nodeList.add(Essen);
		nodeList.add(SanFrancisco);
		nodeList.add(Paris);
		nodeList.add(Atlanta);
		nodeList.add(Washington);
		nodeList.add(Madrid);
		nodeList.add(NewYork);
		nodeList.add(Montreal);
		nodeList.add(London);
		nodeList.add(StPatersburg);
		nodeList.add(Milan);
		nodeList.add(Chicago);
		
		AbstractBoardNode HoChiMinhCity = new BoardNode("Ho Chi Minh City",Color.RED,21);
		AbstractBoardNode Taipei = new BoardNode("Taipei",Color.RED,22);
		AbstractBoardNode Jakarta = new BoardNode("Jakarta",Color.RED,48);
		AbstractBoardNode Osaka = new BoardNode("Osaka",Color.RED,2);
		AbstractBoardNode Tokyo = new BoardNode("Tokyo",Color.RED,31);
		AbstractBoardNode Sydney = new BoardNode("Sydney",Color.RED,5);
		AbstractBoardNode Beijing = new BoardNode("Beijing",Color.RED,40);
		AbstractBoardNode Shanghai = new BoardNode("Shanghai",Color.RED,32);
		AbstractBoardNode Bangkok = new BoardNode("Bangkok",Color.RED,19);
		AbstractBoardNode Seoul = new BoardNode("Seoul",Color.RED,47);
		AbstractBoardNode Manila = new BoardNode("Manila",Color.RED,45);
		AbstractBoardNode HongKong = new BoardNode("Hong Kong",Color.RED,18);
		nodeList.add(HoChiMinhCity);
		nodeList.add(Taipei);
		nodeList.add(Jakarta);
		nodeList.add(Osaka);
		nodeList.add(Tokyo);
		nodeList.add(Sydney);
		nodeList.add(Beijing);
		nodeList.add(Shanghai);
		nodeList.add(Bangkok);
		nodeList.add(Seoul);
		nodeList.add(Manila);
		nodeList.add(HongKong);
		
		
		
		//The neighbors
		Moscow.addNeighbor(Tehran);
		Moscow.addNeighbor(StPatersburg);
		Moscow.addNeighbor(Istanbul);
		
		Delhi.addNeighbor(Tehran);
		Delhi.addNeighbor(Karachi);
		Delhi.addNeighbor(Mumbai);
		Delhi.addNeighbor(Chennai);
		Delhi.addNeighbor(Kolkata);
		
		
		Istanbul.addNeighbor(Milan);
		Istanbul.addNeighbor(StPatersburg);
		Istanbul.addNeighbor(Moscow);
		Istanbul.addNeighbor(Baghdad);
		Istanbul.addNeighbor(Cairo);
		Istanbul.addNeighbor(Algiers);
		
		Tehran.addNeighbor(Moscow);
		Tehran.addNeighbor(Baghdad);
		Tehran.addNeighbor(Karachi);
		Tehran.addNeighbor(Delhi);

		
		Kolkata.addNeighbor(Delhi);
		Kolkata.addNeighbor(Chennai);
		Kolkata.addNeighbor(Bangkok);
		Kolkata.addNeighbor(HongKong);
		
		
		Baghdad.addNeighbor(Tehran);
		Baghdad.addNeighbor(Karachi);
		Baghdad.addNeighbor(Riyadh);
		Baghdad.addNeighbor(Cairo);
		Baghdad.addNeighbor(Istanbul);
		
		Karachi.addNeighbor(Tehran);
		Karachi.addNeighbor(Delhi);
		Karachi.addNeighbor(Mumbai);
		Karachi.addNeighbor(Baghdad);
		Karachi.addNeighbor(Riyadh);
		
		Chennai.addNeighbor(Mumbai);
		Chennai.addNeighbor(Delhi);
		Chennai.addNeighbor(Kolkata);
		Chennai.addNeighbor(Bangkok);
		Chennai.addNeighbor(Jakarta);
		
		Cairo.addNeighbor(Algiers);
		Cairo.addNeighbor(Istanbul);
		Cairo.addNeighbor(Baghdad);
		Cairo.addNeighbor(Riyadh);
		Cairo.addNeighbor(Khartoum);

		
		Algiers.addNeighbor(Madrid);
		Algiers.addNeighbor(Paris);
		Algiers.addNeighbor(Istanbul);
		Algiers.addNeighbor(Cairo);

		
		Riyadh.addNeighbor(Cairo);
		Riyadh.addNeighbor(Baghdad);
		Riyadh.addNeighbor(Karachi);

		
		
		Mumbai.addNeighbor(Karachi);
		Mumbai.addNeighbor(Delhi);
		Mumbai.addNeighbor(Chennai);

		
		Kinshasa.addNeighbor(Lagos);
		Kinshasa.addNeighbor(Khartoum);
		Kinshasa.addNeighbor(Johannesburg);

		
		Santiago.addNeighbor(Lima);
		
		Khartoum.addNeighbor(Cairo);
		Khartoum.addNeighbor(Lagos);
		Khartoum.addNeighbor(Kinshasa);
		Khartoum.addNeighbor(Johannesburg);
		
		LosAngeles.addNeighbor(Sydney);
		LosAngeles.addNeighbor(SanFrancisco);
		LosAngeles.addNeighbor(Chicago);
		LosAngeles.addNeighbor(MexicoCity);

		
		
		Johannesburg.addNeighbor(Kinshasa);
		Johannesburg.addNeighbor(Khartoum);

		BuenosAires.addNeighbor(Bogota);
		BuenosAires.addNeighbor(SaoPaulo);
		
		SaoPaulo.addNeighbor(Bogota);
		SaoPaulo.addNeighbor(BuenosAires);
		SaoPaulo.addNeighbor(Madrid);
		SaoPaulo.addNeighbor(Lagos);
		
		Bogota.addNeighbor(MexicoCity);
		Bogota.addNeighbor(Miami);
		Bogota.addNeighbor(SaoPaulo);
		Bogota.addNeighbor(BuenosAires);
		Bogota.addNeighbor(Lima);

		Lima.addNeighbor(Santiago);
		Lima.addNeighbor(MexicoCity);
		Lima.addNeighbor(Bogota);
		
		MexicoCity.addNeighbor(LosAngeles);
		MexicoCity.addNeighbor(Chicago);
		MexicoCity.addNeighbor(Miami);
		MexicoCity.addNeighbor(Bogota);
		MexicoCity.addNeighbor(Lima);
		
		Lagos.addNeighbor(Khartoum);
		Lagos.addNeighbor(Kinshasa);
		Lagos.addNeighbor(SaoPaulo);
		
		Miami.addNeighbor(MexicoCity);
		Miami.addNeighbor(Atlanta);
		Miami.addNeighbor(Washington);
		Miami.addNeighbor(Bogota);
		
		Essen.addNeighbor(London);
		Essen.addNeighbor(Paris);
		Essen.addNeighbor(Milan);
		Essen.addNeighbor(StPatersburg);
		
		SanFrancisco.addNeighbor(Tokyo);
		SanFrancisco.addNeighbor(Manila);
		SanFrancisco.addNeighbor(Chicago);
		SanFrancisco.addNeighbor(LosAngeles);
		
		Paris.addNeighbor(London);
		Paris.addNeighbor(Madrid);
		Paris.addNeighbor(Algiers);
		Paris.addNeighbor(Milan);
		Paris.addNeighbor(Essen);
		
		Atlanta.addNeighbor(Chicago);
		Atlanta.addNeighbor(Miami);
		Atlanta.addNeighbor(Washington);
		
		Washington.addNeighbor(NewYork);
		Washington.addNeighbor(Montreal);
		Washington.addNeighbor(Atlanta);
		Washington.addNeighbor(Miami);
		
		Madrid.addNeighbor(SaoPaulo);
		Madrid.addNeighbor(Algiers);
		Madrid.addNeighbor(NewYork);
		Madrid.addNeighbor(London);
		Madrid.addNeighbor(Paris);
		
		NewYork.addNeighbor(Montreal);
		NewYork.addNeighbor(Washington);
		NewYork.addNeighbor(London);
		NewYork.addNeighbor(Madrid);
		
		Montreal.addNeighbor(Chicago);
		Montreal.addNeighbor(Washington);
		Montreal.addNeighbor(NewYork);
		
		London.addNeighbor(NewYork);
		London.addNeighbor(Madrid);
		London.addNeighbor(Paris);
		London.addNeighbor(Essen);
		
		StPatersburg.addNeighbor(Essen);
		StPatersburg.addNeighbor(Istanbul);
		StPatersburg.addNeighbor(Moscow);
		
		Milan.addNeighbor(Essen);
		Milan.addNeighbor(Paris);
		Milan.addNeighbor(Istanbul);
		
		Chicago.addNeighbor(SanFrancisco);
		Chicago.addNeighbor(LosAngeles);
		Chicago.addNeighbor(MexicoCity);
		Chicago.addNeighbor(Atlanta);
		Chicago.addNeighbor(Montreal);
		
		HoChiMinhCity.addNeighbor(Jakarta);
		HoChiMinhCity.addNeighbor(Bangkok);
		HoChiMinhCity.addNeighbor(HongKong);
		HoChiMinhCity.addNeighbor(Manila);

		Taipei.addNeighbor(HongKong);
		Taipei.addNeighbor(Shanghai);
		Taipei.addNeighbor(Osaka);
		Taipei.addNeighbor(Manila);
		
		Jakarta.addNeighbor(Chennai);
		Jakarta.addNeighbor(Bangkok);
		Jakarta.addNeighbor(HoChiMinhCity);
		Jakarta.addNeighbor(Sydney);
		
		Osaka.addNeighbor(Taipei);
		Osaka.addNeighbor(Tokyo);
		
		Tokyo.addNeighbor(Seoul);
		Tokyo.addNeighbor(Shanghai);
		Tokyo.addNeighbor(SanFrancisco);
		
		Sydney.addNeighbor(Manila);
		Sydney.addNeighbor(LosAngeles);
		Sydney.addNeighbor(Jakarta);
		
		Beijing.addNeighbor(Seoul);
		Beijing.addNeighbor(Shanghai);
		
		Shanghai.addNeighbor(Beijing);
		Shanghai.addNeighbor(Seoul);
		Shanghai.addNeighbor(Tokyo);
		Shanghai.addNeighbor(Taipei);
		Shanghai.addNeighbor(HongKong);
		
		Bangkok.addNeighbor(Kolkata);
		Bangkok.addNeighbor(HongKong);
		Bangkok.addNeighbor(Chennai);
		Bangkok.addNeighbor(Jakarta);
		Bangkok.addNeighbor(HoChiMinhCity);
		
		Seoul.addNeighbor(Beijing);
		Seoul.addNeighbor(Shanghai);
		Seoul.addNeighbor(Tokyo);
		
		Manila.addNeighbor(SanFrancisco);
		Manila.addNeighbor(Taipei);
		Manila.addNeighbor(HongKong);
		Manila.addNeighbor(HoChiMinhCity);
		Manila.addNeighbor(Sydney);
		
		HongKong.addNeighbor(Taipei);
		HongKong.addNeighbor(Kolkata);
		HongKong.addNeighbor(Shanghai);
		HongKong.addNeighbor(Bangkok);
		HongKong.addNeighbor(HoChiMinhCity);
		HongKong.addNeighbor(Manila);
		
		
		return nodeList;
	}
	

	@Override
	public List<String> getNameOfRoles() {
		List<String> roleList = new ArrayList<String>();
		roleList.add("Medic");
		roleList.add("Researcher");
		roleList.add("Scientist");
		roleList.add("OperationsExpert");
		roleList.add("QuarantineSpecialist");
		
		
		return roleList;
	}
}
