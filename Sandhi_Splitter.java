import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.crypto.spec.OAEPParameterSpec;


public class Sandhi_Splitter {	
	
	public static void main(String[] a){
	   	
		
		String inputFile="/home/kjjose/Desktop/sandhi_rules/words999";
		String outputFile="/home/kjjose/Desktop/sandhi_rules/outpuRules9";
		
		try{
		BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(inputFile)));
		BufferedWriter oaw= new BufferedWriter(new FileWriter(outputFile));
		/*String line99="";
		while((line99=reader.readLine())!=null){
			line99=line99.trim();
			char[] wordAsArray9=line99.toCharArray();
			oaw.write(line99+"  ");
			for(int i=0;i<wordAsArray9.length;i++){
				oaw.write("["+i+"]"+wordAsArray9[i]);
			}
			oaw.write("\n");
			
			
		}*/
		
		int k;
		 String word="";
		while((k = reader.read()) != -1) {
		     char character = (char) k;
		    // System.out.print(character);
		     if(character=='\n'){
		    	 System.out.println(word);
		    	 word=word.trim();
		    	 char[] wordAsArray9=word.toCharArray();
		    	 oaw.write(word+"  ");
					for(int i=0;i<wordAsArray9.length;i++){
						oaw.write("["+i+"]"+wordAsArray9[i]);
					}
					oaw.write("\n");
					word="";
					continue;

		     }
		     word=word+character;
		}
		oaw.close();
		
		}catch(Exception exception){
			
		}

	}

}
