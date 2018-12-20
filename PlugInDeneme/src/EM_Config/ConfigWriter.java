package EM_Config;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class ConfigWriter {
	
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;
	private Element rootElementFeatures;
	private  DOMSource source;
	private StreamResult file; 
	
	public ConfigWriter() throws ParserConfigurationException {
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.newDocument();
		rootElementFeatures = doc.createElement("Features"); 
		source = new DOMSource(doc);
		file = new StreamResult("config.xml");
        doc.appendChild(rootElementFeatures);


	};
					
	public void writeFeatures(Vector <Vector<String>> data) throws TransformerException, FileNotFoundException {
		
		//for output to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        for (int i=0; i<data.size();i++) {
        	rootElementFeatures.appendChild(this.getFeature(doc, data.get(i).get(0), data.get(i).get(1), data.get(i).get(2) ));
        }
        transformer.transform(source, file);
	}
	
	public void writeBoardNodes(Vector <Vector<String>> data) throws TransformerException, FileNotFoundException {
		
		//for output to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        for (int i=0; i<data.size();i++) {
        	rootElementFeatures.appendChild(this.getBoard(doc, data.get(i).get(0), data.get(i).get(1) ));
        	
        }
        transformer.transform(source, file);
	}
	

    private  Node getFeature(Document doc, String featureName, String type, String amount) {
        Element feature = doc.createElement("Feature");
        
        //create name element
        feature.appendChild(getFeatureElements(doc, feature, "featureName", featureName));

        //create type element
        feature.appendChild(getFeatureElements(doc, feature, "type", type));

        //create amount element
        feature.appendChild(getFeatureElements(doc, feature, "amount", amount));

        return feature;
    }


    //utility method to create text node
    private  Node getFeatureElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private  Node getBoard(Document doc, String nodeName, String neighbours) {
        Element board = doc.createElement("Board");
        
        //create name element
        board.appendChild(getBoardElements(doc, board, "nodeName", nodeName));

        //create type element
        board.appendChild(getBoardElements(doc, board, "neighbours", neighbours));

        return board;
    }
    
    private  Node getBoardElements(Document doc, Element element, String nodeName, String value) {
        Element node = doc.createElement(nodeName);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    
    
    
    
    public static Vector<Vector<String>> getBoardNodes(Vector<Vector<String>> data){
		String parentNode = data.get(0).get(0); //a þu an
		String childNodes = ""; //þu an boþ
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(int i=0;i<data.size();i++) {
			if(data.get(i).get(0).equals(parentNode)) {
			childNodes = childNodes + data.get(i).get(1) + "  ";
			//System.out.println("if "+i);
			}
			else {
				
				Vector<String> temp = new Vector<String>();
				temp.add(parentNode);
				temp.add(childNodes);
				result.add(temp);
				childNodes="";
				
				childNodes = childNodes + data.get(i).get(1) + "  ";
				//System.out.println("else " +i);
				
				parentNode=data.get(i).get(0);
			}	
		
		}
		Vector<String> temp = new Vector<String>();
		temp.add(parentNode);
		temp.add(childNodes);
		result.add(temp);
		return result;
	}
    
    /*
    public Vector<Vector<String>> getBoardNodes(Vector<Vector<String>> data){
		String parentNode = data.get(0).get(0); //a þu an
		String childNodes = ""; //þu an boþ
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		
		for(int i=0;i<data.size();i++) {
			if(data.get(i).get(0).equals(parentNode)) {
				if(i!= data.size()-1) {
					childNodes = childNodes + data.get(i).get(1) + ",";
				}
				else {
					childNodes = childNodes + data.get(i).get(1);
				}
			}
			else {
				Vector<String> temp = new Vector<String>();
				temp.add(parentNode);
				temp.add(childNodes);
				result.add(temp);
				//temp.clear();
				childNodes="";
				if(i!= data.size()-1) {
					childNodes = childNodes + data.get(i).get(1) + ",";
				}
				else {
					childNodes = childNodes + data.get(i).get(1);
				}
				parentNode=data.get(i).get(0);
			}	
		}
		return result;
	}
    
    
    */
}