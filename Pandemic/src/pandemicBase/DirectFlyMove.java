package pandemicBase;

import common.AbstractCard;
import common.Board;
import common.BoardNode;
import common.CityCard;
import common.Player;
import rules.IMoveValidation;

public class DirectFlyMove implements IMoveValidation {

	@Override
	public void evaluate(AbstractCard card, Board board, Player player) {
		if(card instanceof CityCard) {
			String destNodeName = ((CityCard) card).getCityName();
			  for (BoardNode node : board.getNodeList()){
		        	if( node.getName().equals(destNodeName)) {
		        		player.setCurrentNode(node);
		        		//buralarda board nodelarýnýn üstündeki pieceleri de deðiþtirmek lazým src ve dst için.
		        	}
			  }
		        	
		}		
	}

}
