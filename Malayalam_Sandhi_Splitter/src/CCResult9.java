import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.SliderUI;


class ExpecteSplitDetails9{
	String WORD;
	String[] WORDS9;
	List<Integer> splitPoints9;

	ExpecteSplitDetails9(String C_RESULT9){
		if(C_RESULT9==null||C_RESULT9=="")
			return;
		splitPoints9=new ArrayList<Integer>();
		WORDS9=new String[9];
		WORD=C_RESULT9.substring(0,C_RESULT9.indexOf('=')).trim();
		String SplitDetails9=C_RESULT9.substring(C_RESULT9.indexOf('=')+1,C_RESULT9.indexOf('|'));
		String Indexes9=C_RESULT9.substring(C_RESULT9.indexOf('|')+1,C_RESULT9.length());
		
		System.out.println(WORD+" "+SplitDetails9+" "+Indexes9);
		WORDS9=SplitDetails9.split("\\+");
		for(String c:WORDS9){
			System.out.println(c);
			
		}
		String[] IndexList9=Indexes9.split("\\,");
		for(String c:IndexList9){
			System.out.println(c);
			splitPoints9.add(Integer.parseInt(c));			
		}
		
	}
	
	
	
}
class RuleDetails{
	int true_C9;
	int false_C9;
}

public class CCResult9 {
	
	static CCResult9 singleResult9=null;
	long  identifiedSplitPoints9;
	long  totalNumberOfSplitPoints=0;
	long false_Positive_splitPoints9=0;
	long true_Positive_splitPoints9=0;
	long false_Negative_SplitPoints9=0;
	long true_Negative_SplitPoints9=0;
	long correct_Overall_Split9=0;
	long wrong_Overall_Split9=0;
	BufferedWriter ERROR_DETAILS_FILE= null;
	BufferedWriter ACCURATE_DETAILS_FILE9= null;
	HashMap<String,ExpecteSplitDetails9> wordMap9=new HashMap<String,ExpecteSplitDetails9>(); 
    HashMap<Integer,RuleDetails> ruleAccuracy9=new HashMap<Integer,RuleDetails>();
	
	
	
	static CCResult9 getInstance(){
		
		   if(singleResult9==null)
			   singleResult9=new CCResult9();
		   
		   return singleResult9;
	}
	private CCResult9(){
		try {
			this.ERROR_DETAILS_FILE=new BufferedWriter(new FileWriter(ConfigurationSettings.getConfigurationSettings().getErrorFile()));
			this.ACCURATE_DETAILS_FILE9=new BufferedWriter(new FileWriter(ConfigurationSettings.getConfigurationSettings().getAccurateFile()));
		} catch (IOException e) {
			System.out.println("NO ERROR FILE CONFIGURED");
			System.exit(0);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] a){
		String c="കൃതഘ്നനാകുമല്ലോ=കൃതഘ്നന്‍+ആകും+അല്ലോ|6,10";
		new ExpecteSplitDetails9(c); 
		
	}
	public void OverallSplitAccuracy9(String word999,List<String> list999){
		ExpecteSplitDetails9 expectedDetail9=wordMap9.get(word999);
		System.out.println("OVERALL ACCURACY "+word999);
		System.out.println("EXPECTED");
		if(expectedDetail9!=null){
		for(String c:expectedDetail9.WORDS9){
			System.out.println("WORD 1 "+c);
			
		}}else{
			System.out.println(word999);
		}
		
		System.out.println("WHAT IS DONE"); 
		for(String c:list999){
			System.out.println("WORD 1 "+c);
			
		}
				
		if(expectedDetail9!=null){
			for(String c:expectedDetail9.WORDS9){
				if(!list999.contains(c.trim())){
					wrong_Overall_Split9++;
					System.out.print("CONTROL1");
					return;
					
				}
			}
		    correct_Overall_Split9++;
		    System.out.print("CONTROL2");
		}else{
			if(list999.size()==1){
			correct_Overall_Split9++;
			System.out.print("CONTROL3");
			}
			else{
			wrong_Overall_Split9++;
			System.out.print("CONTROL4");
			}
		}
		
	}
	public void countRuleAcuracy9(String word99,String newFormed9,String Word_Prefix999,int rule999,int splitCount9){
		try{
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "+word99+" "+newFormed9+" "+Word_Prefix999+" "+rule999+" "+splitCount9);
		ExpecteSplitDetails9 expectedDetail9=wordMap9.get(word99);
		if(expectedDetail9!=null){
			if(splitCount9+1<expectedDetail9.WORDS9.length){
				String word_1=expectedDetail9.WORDS9[splitCount9];
				String word_2=expectedDetail9.WORDS9[splitCount9+1];
				char ch3=newFormed9.charAt(newFormed9.length()-1);
				char ch9=Word_Prefix999.charAt(Word_Prefix999.length()-1);
				System.out.println("Rule Accuracy="+ch3+"&"+word_1+"           "+ch9+"&"+word_2);
				System.out.println("Rule Accuracy CCC="+ch3+"&"+word_1.charAt(word_1.length()-1)+"           "+ch9+"&"+word_2.charAt(0));
				if((ch3==word_1.charAt(word_1.length()-1))&&(ch9==word_2.charAt(0))){
					RuleDetails ruleCount9= ruleAccuracy9.get(rule999);
					if(ruleCount9==null){
						ruleCount9=new RuleDetails();
						ruleCount9.true_C9=1;
					ruleAccuracy9.put(rule999,ruleCount9);
					splitCount9++;
					ACCURATE_DETAILS_FILE9.write("ACCURATE SPLIT RULE ID  "+rule999+" IN WORD "+word99+" AT "+splitCount9+" th SPLIT (CREATED WORD "+newFormed9+")\n");
				
					}
					else{
						ruleCount9.true_C9++;
						ruleAccuracy9.put(rule999,ruleCount9);
						splitCount9++;
						ACCURATE_DETAILS_FILE9.write("ACCURATE SPLIT RULE ID "+rule999+" IN WORD "+word99+" AT "+splitCount9+" th SPLIT (CREATED WORD "+newFormed9+")\n");
					}
				}else{
					RuleDetails ruleCount9= ruleAccuracy9.get(rule999);
					if(ruleCount9==null){
						ruleCount9=new RuleDetails();
						ruleCount9.false_C9=1;
						splitCount9++;
						ERROR_DETAILS_FILE.write("RULE ERROR FOR RULE ID "+rule999+" IN WORD "+word99+" AT "+splitCount9+" th SPLIT (CREATED WORD "+newFormed9+")\n");
					ruleAccuracy9.put(rule999,ruleCount9);
					}
					else{
						ruleCount9.false_C9++;
						ruleAccuracy9.put(rule999,ruleCount9);
						splitCount9++;
						ERROR_DETAILS_FILE.write("RULE ERROR FOR RULE ID "+rule999+" IN WORD "+word99+" AT "+splitCount9+" th SPLIT (CREATED WORD "+newFormed9+")\n");
					}
					
				}
			}
		}
		}catch(Exception e){
			
			System.out.println("ERROR IN ERROR LOG");
			System.exit(0);
		}
	}
	public  void  parseTestFile9(String cctest_FILE_PATH9) throws IOException{
		BufferedReader reader9 = new BufferedReader( new InputStreamReader(new FileInputStream(cctest_FILE_PATH9)));
		String line99=null;
		while((line99=reader9.readLine())!=null){
			line99=line99.trim();
			ExpecteSplitDetails9 expectedDeatil9=new ExpecteSplitDetails9(line99);
			System.out.println("WORD TO MAP"+expectedDeatil9.WORD);
			wordMap9.put(expectedDeatil9.WORD.trim(),expectedDeatil9);
			
		}
	}
	public void registerSplitPointIdentification9(String word99,int index9,boolean isIdentifiedAsSplitPoint9){
		try{
		ExpecteSplitDetails9 expectedDetail9=wordMap9.get(word99);
		if(expectedDetail9==null){
			if(isIdentifiedAsSplitPoint9){
		      	false_Positive_splitPoints9++;
		      	ERROR_DETAILS_FILE.write("SPLIT PONT CLASSIFICATION "+"IDENTIFIED AS FALSE POSITIVE FOR WORD "+word99+" AT INTDEX "+index9+"\n");
			}else
				true_Negative_SplitPoints9++;
		}else{
			if(isIdentifiedAsSplitPoint9){
			if(expectedDetail9.splitPoints9.contains(index9))
				true_Positive_splitPoints9++;
			else{
				false_Positive_splitPoints9++;
				ERROR_DETAILS_FILE.write("SPLIT PONT CLASSIFICATION "+"IDENTIFIED AS FALSE POSITIVE FOR WORD "+word99+" AT INTDEX "+index9+"\n");
			  }
			}else{
				if(expectedDetail9.splitPoints9.contains(index9)){
					false_Negative_SplitPoints9++;
					ERROR_DETAILS_FILE.write("SPLIT PONT CLASSIFICATION "+"IDENTIFIED AS FALSE NEGATIVE FOR WORD "+word99+" AT INTDEX "+index9+"\n");
				}else
					true_Negative_SplitPoints9++;
				
			}
		}
		}catch(Exception e){
			System.out.print("IO ERROR IN ERROR LOGGING");
			System.exit(0);
		}
	}
	public void printResult(){
		System.out.println("\n\n\nRESULT");
		System.out.println("CURRENT CONFIGURATION");
		System.out.println("NO. OF CHARACTERS FOR SPLIT POINT IDENTIFICATION "+ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters());
		System.out.println("NO OF INITIAL SKIP FOR SMOOTHING "+ConfigurationSettings.getConfigurationSettings().getInitialSkipProbClaculation());
		System.out.println("True Positive "+true_Positive_splitPoints9);
		System.out.println("False Positive "+false_Positive_splitPoints9);
		System.out.println("True Negative "+true_Negative_SplitPoints9);
		System.out.println("False Negative "+false_Negative_SplitPoints9);
		double precision9=(double)true_Positive_splitPoints9/(true_Positive_splitPoints9+false_Positive_splitPoints9);
		double recall9=(double)true_Positive_splitPoints9/(true_Positive_splitPoints9+false_Negative_SplitPoints9);
		double f_measure1=(2*recall9*precision9)/(recall9+precision9);
		System.out.println("PRECISION   "+precision9+"    RECALL"+recall9+"   F_MEASURE1 "+f_measure1);
		Iterator it = ruleAccuracy9.entrySet().iterator();
		System.out.println("RULE DETAILS.................");
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        RuleDetails ruleDetail9=(RuleDetails) pairs.getValue();
	        double accuracyValue9=(double)ruleDetail9.true_C9/(ruleDetail9.true_C9+ruleDetail9.false_C9);
	        System.out.println(pairs.getKey() + " = accurate-:" + ruleDetail9.true_C9+"     inaccurate:"+ruleDetail9.false_C9+"   Accuracy : "+accuracyValue9);
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    System.out.println("OVERALL SPLIT DETAILS................................");
	    double AccuracyValue9=(double)correct_Overall_Split9/(correct_Overall_Split9+wrong_Overall_Split9);
	    System.out.println("ACCURATE SPLITS "+correct_Overall_Split9+"  IACCURATE  SPLITS "+wrong_Overall_Split9+"    ACCURACY "+AccuracyValue9);
		try{
			ERROR_DETAILS_FILE.close();
			ACCURATE_DETAILS_FILE9.close();
			
		}catch(Exception e){
			System.out.println("ERROR IN ERROR LOG ");
			System.exit(0);
			
		}
		
		
	}
	

}
