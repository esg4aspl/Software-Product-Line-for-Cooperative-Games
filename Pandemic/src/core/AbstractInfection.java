package core;

import rules.RuleDiseaseMustBeNotEradicatedYet;
import rules.RuleThereMustBeEnoughCubesOfColorOfCityToBeInfected;
import rules.RuleThereMustNotBeMedicIfDiseaseIsCured;
import rules.RuleThereMustNotBeQuarantineSpecialistAtCurrentCityOrNeighbors;

public abstract class AbstractInfection {
	protected AbstractReferee referee;

	public AbstractInfection(AbstractReferee referee) {
		this.referee = referee;
	}
	protected void infectCity(AbstractBoardNode cityToBeInfected,ICubeList cubeList,Color color) {
		if(isSatisfied(cityToBeInfected)) {
			if(!didOutbreakOccur(cityToBeInfected)) {
				putDiseaseCubesToNode(cityToBeInfected,cubeList,color);
			}
			else {
				for (AbstractBoardNode neighborNode: cityToBeInfected.getNeighborList()) {
					infectCity(neighborNode,cubeList,color);
				}
			}
		}	
	}
	protected boolean isSatisfied(AbstractBoardNode cityToBeInfected) {
		if(new RuleThereMustBeEnoughCubesOfColorOfCityToBeInfected(cityToBeInfected).evaluate(referee) &&
			new RuleThereMustNotBeMedicIfDiseaseIsCured(cityToBeInfected).evaluate(referee) &&
			new RuleThereMustNotBeQuarantineSpecialistAtCurrentCityOrNeighbors(cityToBeInfected).evaluate(referee)&&
			new RuleDiseaseMustBeNotEradicatedYet(cityToBeInfected).evaluate(referee)
			) {
			return true;
		}
		return false;
	}
	public abstract void infect();
	protected abstract boolean didOutbreakOccur(AbstractBoardNode cityToBeInfected);
	protected abstract void putDiseaseCubesToNode(AbstractBoardNode cityToBeInfected, ICubeList cubeList,Color color);
}
