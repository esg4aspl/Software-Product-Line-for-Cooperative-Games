package rules;

import core.AbstractCard;
import pandemicBase.Board;
import pandemicBase.BoardNode;
import pandemicBase.CityCard;
import pandemicBase.Player;
import core.IMoveValidation;

public class DirectFlyMove implements core.IMoveValidation {

	@Override
	public void evaluate(AbstractCard card, Board board, Player player) {
		if(card instanceof CityCard) {
			String destNodeName = ((CityCard) card).getCityName();
			  for (BoardNode node : board.getNodeList()){
		        	if( node.getName().equals(destNodeName)) {
		        		player.setCurrentNode(node);
		        		//buralarda board nodelar�n�n �st�ndeki pieceleri de de�i�tirmek laz�m src ve dst i�in.
		        	}
			  }
		        	
		}		
	}

}
