package EM_Config;

import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BoardNodeSelectionWriter extends ConfigWriterTemplate {

	public BoardNodeSelectionWriter(String name) throws ParserConfigurationException {
		super(name);
		
	}

	@Override
	protected void appendTheElements(Vector<Vector<String>> data) {
		data = matchTheNeighbours(data);
		for (int i=0; i<data.size();i++) {
        	rootElement.appendChild(prepareElements(data.get(i)));
        	
        }
	}

	@Override
	protected Node prepareElements(Vector<String> data) {
		Element board = doc.createElement("BoardNode");
        
        //create name element
        board.appendChild(createTagAndAttachTheElement("nodeName", data.get(0)));

        //create type element
        board.appendChild(createTagAndAttachTheElement("neighbours", data.get(1)));

        return board;
	}
	// bu method alýnan komþularýn düzgün bir þekilde ayrýlýp dosyaya düzgün bir þekilde yazýlmasý için için yazýlmýþtýr
	private Vector<Vector<String>> matchTheNeighbours(Vector<Vector<String>> data){
		String parentNode = data.get(0).get(0); //a þu an
		String childNodes = ""; //þu an boþ
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(int i=0;i<data.size();i++) {
			if(data.get(i).get(0).equals(parentNode)) {
			childNodes = childNodes + data.get(i).get(1) + "  ";
			}
			else {
				
				Vector<String> temp = new Vector<String>();
				temp.add(parentNode);
				temp.add(childNodes);
				result.add(temp);
				childNodes="";
				
				childNodes = childNodes + data.get(i).get(1) + "  ";
				
				parentNode=data.get(i).get(0);
			}	
		
		}
		Vector<String> temp = new Vector<String>();
		temp.add(parentNode);
		temp.add(childNodes);
		result.add(temp);
		return result;
	}

}
