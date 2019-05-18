package rules;
import java.util.List;
import java.util.Set;

import core.AbstractBoardNode;
import core.AbstractPlayer;
import core.AbstractReferee;
import core.IRule;
import pandemicBase.BoardNode;
import pandemicBaseRoles.QuarantineSpecialist;

public class RuleThereMustNotBeQuarantineSpecialistAtCurrentCityOrNeighbors implements IRule {
	AbstractBoardNode cityToBeInfected; 
	public RuleThereMustNotBeQuarantineSpecialistAtCurrentCityOrNeighbors(AbstractBoardNode cityToBeInfected) {
		this.cityToBeInfected = cityToBeInfected;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		if(isThereQuarantineSpecialistOnNode(cityToBeInfected)) {
			return false;
		}
		else {
			Set<AbstractBoardNode> neighbors = ((BoardNode)cityToBeInfected).getNeighborList();
			for (AbstractBoardNode neighborNode : neighbors) {
				if(isThereQuarantineSpecialistOnNode(neighborNode)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isThereQuarantineSpecialistOnNode(AbstractBoardNode boardNode) {
		List<AbstractPlayer> playerListOfBoardNode = ((BoardNode)boardNode).getPlayersOnNode();
		for (AbstractPlayer player : playerListOfBoardNode) {
			if(player.getRole() instanceof QuarantineSpecialist) {
				return true;
			}
		}
		return false;
	}
}
