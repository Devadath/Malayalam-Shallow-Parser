import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ConfigurationSettings {
	static ConfigurationSettings singleInstance=null;

	
	public String getWordlevleoutput_with_splitpoints() {
		return wordlevleoutput_with_splitpoints;
	}
	public void setWordlevleoutput_with_splitpoints(
			String wordlevleoutput_with_splitpoints) {
		this.wordlevleoutput_with_splitpoints = wordlevleoutput_with_splitpoints;
	}
	public String getWordleveloutput_without_splitpoints() {
		return wordleveloutput_without_splitpoints;
	}
	public void setWordleveloutput_without_splitpoints(
			String wordleveloutput_without_splitpoints) {
		this.wordleveloutput_without_splitpoints = wordleveloutput_without_splitpoints;
	}
	public String getPlain_text_output() {
		return plain_text_output;
	}
	public void setPlain_text_output(String plain_text_output) {
		this.plain_text_output = plain_text_output;
	}
	public String getPatternfile() {
		return patternfile;
	}
	public void setPatternfile(String patternfile) {
		this.patternfile = patternfile;
	}
	public int getSplitPointNoOfCharacters() {
		return splitPointNoOfCharacters;
	}
	public void setSplitPointNoOfCharacters(int splitPointNoOfCharacters) {
		this.splitPointNoOfCharacters = splitPointNoOfCharacters;
	}
	public int getInitialSkipProbClaculation() {
		return initialSkipProbClaculation;
	}
	public void setInitialSkipProbClaculation(int initialSkipProbClaculation) {
		this.initialSkipProbClaculation = initialSkipProbClaculation;
	}
	public String getTrainingfile() {
		return trainingfile;
	}
	public void setTrainingfile(String trainingfile) {
		this.trainingfile = trainingfile;
	}
	public String getInputDatafile() {
		return inputDatafile;
	}
	public void setInputDatafile(String inputDatafile) {
		this.inputDatafile = inputDatafile;
	}
	String wordleveloutput_without_splitpoints;
	String plain_text_output;
	String patternfile;
	int splitPointNoOfCharacters;
	int  initialSkipProbClaculation;
	String trainingfile;
	String inputDatafile;
	String inputDataTestDetailsC;
	String wordlevleoutput_with_splitpoints;
	String ErrorDetailsFileC;
	String AccruracteSplit9;
        String DummyTrainingFileRecord;
	public String getDummyTrainingFileRecord(){
            return DummyTrainingFileRecord;
         }
	public String getErrorFile(){
		return ErrorDetailsFileC;
	}
	public String getInputDataTestDetails9(){
		
		return inputDataTestDetailsC;
	}
	private ConfigurationSettings(){
		
		
	}  
	public String getAccurateFile(){
	  
	   return 	this.AccruracteSplit9;
	}
	public static ConfigurationSettings getConfigurationSettings(){
		if(singleInstance==null){
			
			singleInstance=new ConfigurationSettings();
			
		}
		return singleInstance;
		
	}
	public void readConfig(String configFile){
	    try {
	    	 
	    	File fXmlFile = new File(configFile);
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);
	     
	    	//optional, but recommended
	    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    	doc.getDocumentElement().normalize();
	     
	    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	     
	    	NodeList nList = doc.getElementsByTagName("configdetails");
	     
	    	System.out.println("----------------------------");
	     
	    	for (int temp = 0; temp < nList.getLength(); temp++) {
	     
	    		Node nNode = nList.item(temp);
	     
	    		System.out.println("\nCurrent Element :" + nNode.getNodeName());
	     
	    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	     
	    			Element eElement = (Element) nNode;
	     
	    			System.out.println("wordlevleoutput_with_splitpoints : " + eElement.getAttribute("wordlevleoutput_with_splitpoints")+eElement.getElementsByTagName("wordlevleoutput_with_splitpoints").item(0).getTextContent());
	    			wordlevleoutput_with_splitpoints=eElement.getElementsByTagName("wordlevleoutput_with_splitpoints").item(0).getTextContent();
	    			
	    			
	    			System.out.println("wordleveloutput_without_splitpoints : " + eElement.getAttribute("wordleveloutput_without_splitpoints")+eElement.getElementsByTagName("wordleveloutput_without_splitpoints").item(0).getTextContent());
	    			wordleveloutput_without_splitpoints=eElement.getElementsByTagName("wordleveloutput_without_splitpoints").item(0).getTextContent();
	    			
	    			
	    			System.out.println("plain_text_output : " + eElement.getAttribute("plain_text_output")+eElement.getElementsByTagName("plain_text_output").item(0).getTextContent());
	    			plain_text_output=eElement.getElementsByTagName("plain_text_output").item(0).getTextContent();
	    			
	    			System.out.println("patternfile : " + eElement.getAttribute("patternfile")+eElement.getElementsByTagName("patternfile").item(0).getTextContent());
	    			patternfile=eElement.getElementsByTagName("patternfile").item(0).getTextContent();
	    			
	    			System.out.println("splitPointNoOfCharacters : " + eElement.getAttribute("splitPointNoOfCharacters")+eElement.getElementsByTagName("splitPointNoOfCharacters").item(0).getTextContent());
	    			splitPointNoOfCharacters=Integer.parseInt(eElement.getElementsByTagName("splitPointNoOfCharacters").item(0).getTextContent());
	    			
	    			System.out.println("initialSkipProbClaculation : " + eElement.getAttribute("initialSkipProbClaculation")+eElement.getElementsByTagName("initialSkipProbClaculation").item(0).getTextContent());
	    			initialSkipProbClaculation=Integer.parseInt(eElement.getElementsByTagName("initialSkipProbClaculation").item(0).getTextContent());
	    			
	    			System.out.println("trainingfile : " + eElement.getAttribute("trainingfile")+eElement.getElementsByTagName("trainingfile").item(0).getTextContent());
	    			trainingfile=eElement.getElementsByTagName("trainingfile").item(0).getTextContent();
	    			
	    			System.out.println("inputDatafile : " + eElement.getAttribute("inputDatafile")+eElement.getElementsByTagName("inputDatafile").item(0).getTextContent());
	    			inputDatafile=eElement.getElementsByTagName("inputDatafile").item(0).getTextContent();
	    			inputDataTestDetailsC=eElement.getElementsByTagName("inputDatafileSplitDetail").item(0).getTextContent();
	    			System.out.println("inputDataTestfile : " + inputDataTestDetailsC);
	    			ErrorDetailsFileC=eElement.getElementsByTagName("ErrorSplitFile").item(0).getTextContent();
	    			System.out.println("ERROR DETAILS FILE : " + ErrorDetailsFileC);
	    			AccruracteSplit9=eElement.getElementsByTagName("AccurateSplitFile").item(0).getTextContent();
                                DummyTrainingFileRecord=eElement.getElementsByTagName("DummyTrainingFileRecord").item(0).getTextContent();
	    			System.out.println("ERROR DETAILS FILE : " + AccruracteSplit9);
	             
	     
	    		}
	    	}
	        } catch (Exception e) {
	    	e.printStackTrace();
	        }		
	}

}
