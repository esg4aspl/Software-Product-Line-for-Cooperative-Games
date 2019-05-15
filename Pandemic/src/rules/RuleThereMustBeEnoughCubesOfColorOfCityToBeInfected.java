package rules;

import core.AbstractBoardNode;
import core.AbstractReferee;
import core.Color;
import core.ICubeList;
import core.IRule;
import pandemicBase.BoardNode;

public class RuleThereMustBeEnoughCubesOfColorOfCityToBeInfected implements IRule {
	AbstractBoardNode cityToBeInfected; 
	public RuleThereMustBeEnoughCubesOfColorOfCityToBeInfected(AbstractBoardNode cityToBeInfected) {
		this.cityToBeInfected = cityToBeInfected;
	}
	@Override
	public boolean evaluate(AbstractReferee referee) {
		Color colorOfCityToBeInfected = ((BoardNode)cityToBeInfected).getColor();
		ICubeList cubeList = referee.getCubeList();
		boolean areThereEnoughCubesOfSpecificColor = cubeList.areThereEnoughCubesOfSpecificColor(colorOfCityToBeInfected);	
		referee.setEndGame(!areThereEnoughCubesOfSpecificColor);
		return areThereEnoughCubesOfSpecificColor;
	}

}
