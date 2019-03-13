package EM_Config;

import java.io.File;
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

public abstract class ConfigWriterTemplate {
	protected DocumentBuilderFactory dbFactory;
	protected DocumentBuilder dBuilder;
	protected Document doc;
	protected Element rootElement;
	protected  DOMSource source;
	protected StreamResult file; 
	
	public ConfigWriterTemplate(String name) throws ParserConfigurationException {
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.newDocument();
		rootElement= doc.createElement(name); 
		source = new DOMSource(doc);
		file = new StreamResult(new File("C:\\Users\\user\\git\\Software-Product-Line-for-Cooperative-Games\\PlugInDeneme\\"+name+".xml"));
        doc.appendChild(rootElement);
	};
	
	public final void write(Vector<Vector<String>> data) throws TransformerException {
		//for output to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        this.appendTheElements(data);
        transformer.transform(source, file);
	}
	
	protected abstract void appendTheElements(Vector<Vector<String>> data);
	protected abstract Node prepareElements(Vector<String> data);
	protected  Node createTagAndAttachTheElement(String nodeName, String value) {
		 	Element node = doc.createElement(nodeName);
	        node.appendChild(doc.createTextNode(value));
	        return node;
	}

	
}
