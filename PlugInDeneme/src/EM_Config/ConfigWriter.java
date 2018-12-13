package EM_Config;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	//change
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;
	private Element rootElement;

	
	public ConfigWriter() throws ParserConfigurationException {
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.newDocument();
		rootElement = doc.createElement("Features"); 
	};
	
	public void write(String fileName) throws TransformerException, FileNotFoundException {
		
		//for output to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        doc.appendChild(rootElement);
		
		
		String[] features = new String[3];
		String line;
		 Scanner sc = new Scanner(new File(fileName));
		 
		 while (sc.hasNextLine()) {
		     line = sc.nextLine();
		     features = line.split(" ");
		     rootElement.appendChild(this.getFeature(doc, features[0],features[1], features[2]));

		 }
		 sc.close();
        
        ////write to file
        StreamResult file = new StreamResult(new File("config.xml"));
        
        //write data
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

}