package core;

import java.util.List;

import pandemicBase.BoardNode;
import rules.RuleDiseaseMustBeNotEradicatedYet;
import rules.RuleThereMustBeEnoughCubesOfColorOfCityToBeInfected;
import rules.RuleThereMustBeLessThanThreeCubesOfSameColorOnNode;
import rules.RuleThereMustNotBeMedicIfDiseaseIsCured;
import rules.RuleThereMustNotBeQuarantineSpecialistAtCurrentCityOrNeighbors;

public abstract class AbstractInfection {
	protected AbstractReferee referee;

	public AbstractInfection(AbstractReferee referee) {
		this.referee = referee;
	}
	protected void infectCity(AbstractBoardNode cityToBeInfected,ICubeList cubeList,Color color,AbstractTrack outbreakTrack,List<AbstractBoardNode> newlyInfectedNodeList) {
		if(isSatisfied(cityToBeInfected)) {
			if(!didOutbreakOccur(cityToBeInfected)) {
				putDiseaseCubesToNode(cityToBeInfected,cubeList,color);
				newlyInfectedNodeList.add(cityToBeInfected);
			}
			else {
				referee.setEndGame(outbreakTrack.didMarkerReachedLastSpace());
				if(!outbreakTrack.didMarkerReachedLastSpace()) {
					outbreakTrack.moveMarker();
					for (AbstractBoardNode neighborNode: cityToBeInfected.getNeighborList()) {
						infectCity(neighborNode,cubeList,color,outbreakTrack,newlyInfectedNodeList);
					}
				}
			}
		}	
	}
	protected boolean isSatisfied(AbstractBoardNode cityToBeInfected) {
		if((new RuleThereMustBeEnoughCubesOfColorOfCityToBeInfected(cityToBeInfected).evaluate(referee)) &&
			(new RuleThereMustNotBeMedicIfDiseaseIsCured(cityToBeInfected).evaluate(referee)) &&
			(new RuleThereMustNotBeQuarantineSpecialistAtCurrentCityOrNeighbors(cityToBeInfected).evaluate(referee))&&
			(new RuleDiseaseMustBeNotEradicatedYet(cityToBeInfected).evaluate(referee))
			) {
			return true;
		}
		return false;
	}
	protected boolean didOutbreakOccur(AbstractBoardNode cityToBeInfected) {
		IRule rule = new RuleThereMustBeLessThanThreeCubesOfSameColorOnNode(cityToBeInfected);
		return !rule.evaluate(referee);
	}
	protected  void putDiseaseCubesToNode(AbstractBoardNode cityToBeInfected, ICubeList cubeList,Color color) {
		AbstractGamePiece cube = cubeList.takeCubeFromCubeList(color);
		((BoardNode)cityToBeInfected).addPieceOnNode(cube);
	}
	public abstract void infect();

}
