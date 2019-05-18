package pandemicBase;

import java.util.List;

import core.AbstractBoard;
import core.AbstractBoardNode;

public class Board extends AbstractBoard{

	public Board(List<AbstractBoardNode> nodeList) {
		super(nodeList);
	}
	
	public String toString() {
		String output = " ";
		for(AbstractBoardNode node : nodeList) {
			output = output + node.toString()+ "\n";
		}
		return output;
	}
	
}
