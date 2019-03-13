package EM_Config;

import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FeatureSelectionWriter extends ConfigWriterTemplate {

	public FeatureSelectionWriter(String name) throws ParserConfigurationException {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void appendTheElements(Vector<Vector<String>> data) {
		for (int i=0; i<data.size();i++) {
        	this.rootElement.appendChild(this.prepareElements(data.get(i)));
        }
	}

	@Override
	protected Node prepareElements(Vector<String> data) {
		Element feature = doc.createElement("Feature");
		
		//create name element
        feature.appendChild(createTagAndAttachTheElement( "featureName",data.get(0) ));

        //create type element
        feature.appendChild(createTagAndAttachTheElement("type", data.get(1)));

        //create amount element
        feature.appendChild(createTagAndAttachTheElement("amount", data.get(2)));

        return feature;
	}


}
