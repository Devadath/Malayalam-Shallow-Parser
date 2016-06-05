import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class Util {
	static HashMap<Character,String> SymbolVowelMap=new HashMap<Character,String>();
	static HashMap<Character,String> Consonent_Chillu_Map=new HashMap<Character,String>();
	static HashMap<String,String> Suffixes=new HashMap<String,String>();
	static HashMap<String,String> SuffixPrefix=new HashMap<String,String>();
   static HashMap<String,String> SplittableSuffix=new HashMap<String,String>(); 
   static String LLA="";
	static{
		 // VOWEL SYMBOL TO VOWEL MAP
		   SymbolVowelMap.put('ാ',"ആ");
		   SymbolVowelMap.put('ി',"ഇ");
		   SymbolVowelMap.put('ീ',"ഈ");
		   SymbolVowelMap.put('ു',"ഉ");
		   SymbolVowelMap.put('ൂ',"ഊ");
		   SymbolVowelMap.put('ൃ',"ഋ");
		   SymbolVowelMap.put('െ',"എ");
		   SymbolVowelMap.put('േ',"ഏ");
		   SymbolVowelMap.put('ൈ',"ഐ");
		   SymbolVowelMap.put('ൊ',"ഒ");
		   SymbolVowelMap.put('ോ',"ഓ");
		   SymbolVowelMap.put('ൗ',"ഔ");
		   SymbolVowelMap.put('ം',"അം");
		  //CONSONENT CHILLU MAP
		   Consonent_Chillu_Map.put('ര', "ര്‍");
		  Consonent_Chillu_Map.put('ല', "ല്‍");
		   Consonent_Chillu_Map.put('ള', "ള്‍");
		   Consonent_Chillu_Map.put('ന', "ന്‍");
		   //SUFFIX PREFIX
		
		 //SLITTABLE SUFFIX
		   SplittableSuffix.put("ആണ്","Y");
		   //SplittableSuffix.put("അത്","Y");
		   SplittableSuffix.put("ആയ","Y");
		   SplittableSuffix.put("എന്ന","Y");
		   SplittableSuffix.put("ആയി ","Y");
		   SplittableSuffix.put("അതു","Y");
		   SplittableSuffix.put("ഉണ്ട്","Y");
		   SplittableSuffix.put("എന്ന്","Y");
		   SplittableSuffix.put("അല്ല","Y");
		   SplittableSuffix.put("ഇല്ല","Y");
		   SplittableSuffix.put("ഉണ്ട്","Y");
		   SplittableSuffix.put("ആയ","Y");
		  // SplittableSuffix.put("ഇത്","Y"); removed
		   Suffixes.put("ആര്‍","Y");
		   
		   //SUFFIXES
		  Suffixes.put("അം","Y");
		   Suffixes.put("ഒർഉ","Y");
		 //  Suffixes.put("ആം","Y"); can be attached with a suffix
		   Suffixes.put("ഇ","Y");
		   Suffixes.put("ഉം","Y");
		   Suffixes.put("ഉട്","Y");
		   Suffixes.put("എ","Y");
		   Suffixes.put("അം","Y");
		   Suffixes.put("ഒക്ക്","Y");
		   //Suffixes.put("ആണ്","Y");
		   Suffixes.put("ഇന്റ്","Y");
		   Suffixes.put("എന്ന്","Y");
		   Suffixes.put("ആൽ","Y");
		   Suffixes.put("അല്ല","Y");
		   Suffixes.put("എന്ന്","Y");
		   //Suffixes.put("അത്","Y");
		   Suffixes.put("ഈ","Y");
		   Suffixes.put("ആള്‍","Y");
		   Suffixes.put("ഉന്ന്","Y");
		 //  Suffixes.put("അത്","Y");
		   Suffixes.put("ആത്ത","Y");
		   Suffixes.put("ഒരു","Y");
		   Suffixes.put("ഉക","Y");
		
		//   Suffixes.put("അ","Y");
		   Suffixes.put("ആല്‍","Y");
		   		 //  Suffixes.put("ഒന്ന്","Y");
		   Suffixes.put("ഉം","Y");
		  Suffixes.put("ഇക്ക്","Y");
		  // Suffixes.put("ഉ","Y");
		   Suffixes.put("ഇൽ","Y");
		   Suffixes.put("ഓള്‍","Y");
		   Suffixes.put("ഉക","Y");
		   Suffixes.put("ഇന്റ്","Y");
		   //Suffixes.put("ആ","Y");
		  // Suffixes.put("ഉട്","Y");
		   Suffixes.put("ആർ","Y");
		   Suffixes.put("അള്‍","Y");
		   Suffixes.put("ഇല്‍","Y");
		   Suffixes.put("ഏക്ക്‌","Y");
		 //  Suffixes.put("ഇക്ക്","Y");
		   Suffixes.put("ഉന്ന","Y");
		   Suffixes.put("എ","Y");
		   Suffixes.put("ഓട്ട്‌","Y");
		   Suffixes.put("ഒണ്ട്","Y");
		   Suffixes.put("ഇച്ച്","Y");
		   Suffixes.put("ഉട്","Y");
		 //  Suffixes.put("ആക്","Y");
		   Suffixes.put("ഓല്‍","Y");
		 //  Suffixes.put("ആല്‍","Y");
		   Suffixes.put("ഒക്ക്","Y");
		   Suffixes.put("അല്‍","Y");
		   Suffixes.put("ഒണ്ട്‌","Y");
		   Suffixes.put("ഇകള്‍","Y");
		//   Suffixes.put("ന്","Y");
		   Suffixes.put("അത്","Y");
		 //  Suffixes.put("അങ്ങ്","Y");
		   Suffixes.put("അല്ല","Y");
		   Suffixes.put("ഉണ്ട്‌","Y");
		  Suffixes.put("ഇന്‍","Y");
		   Suffixes.put("ഓട്‌","Y");
		   Suffixes.put("അന്‍","Y");
		   Suffixes.put("ഉകള്‍","Y");
		 //  Suffixes.put("ഊട്","Y");
		   Suffixes.put("ഇകള്‍","Y");
		   Suffixes.put("ആന്‍","Y");
		   Suffixes.put("അന്ന്","Y");
		   Suffixes.put("ആന്‍","Y");
		   Suffixes.put("ഇട്ട്","Y");
		   Suffixes.put("ഉണ്ട്‌","Y");
		   Suffixes.put("ഉന്ന","Y");
		  Suffixes.put("ഓട്","Y");
		   Suffixes.put("അന്‍","Y");
		 //  Suffixes.put("അന്‍","Y");
		   
		   
		   }
	public static  boolean isSplittableSuffix(String suffix){
	 String word=SplittableSuffix.get(suffix.trim());
	 if(word!=null)
		 return true;
	 return false;
	}
	public static boolean isSuffix(String suffix){
		suffix=suffix.trim();
		if(suffix=="")
			return false;
		  boolean ret=(Suffixes.get(suffix)!=null)||(SplittableSuffix.get(suffix)!=null);
		  System.out.println(suffix+" "+ret);
		return ret;
	}
  public static  boolean isChilluReplacableVyanjanam(char script_element){
	 return Consonent_Chillu_Map.get(script_element)!=null;
 }
 public static String getChilluForVyanjanam(char symbol){
		return Consonent_Chillu_Map.get(symbol);
		
	 }
 public static  String getSwaramForSymbol(char symbol){
	return SymbolVowelMap.get(symbol);
	
 }
 public static boolean isSymbol(char script_element,boolean isVowelOnly){
	
	 if(script_element>='ാ'&&script_element<='ൈ')
		 return true;
	else if((script_element>='ൊ'&&script_element<='ൗ')||(script_element=='ോ'))
	    return true;	
    else if(!isVowelOnly&&(script_element=='ം'||script_element=='\u0D03'))
    	return true;
	 return false;
	 
 }
  public static boolean isVyanjanam(char script_element){
	 if(script_element>='ക'&&script_element<='ഹ')
		 return true;
	 return false;
  }
  public static boolean isSwaram(char script_element){
		 if(script_element>='അ'&&script_element<='ഔ')
			 return true;
		 if(script_element=='ൠ')
			 return true;
		 return false;
	  }
  public static boolean isKoottaksharamForward(int i,char[] array){
	  try{
		   if(i+2<array.length&&Util.isVyanjanam(array[i])&&array[i+1]=='്'&&Util.isVyanjanam(array[i+2])){
			   //System.out.println("KOOTTAKSHARAM:"+array[i]+" "+array[i+1]+" "+array[i+2]);
			   return true;
		   }
		   }catch(ArrayIndexOutOfBoundsException aiob){
				
		   }
		   
		   return false;
	  
  }
  public static  boolean is_ILLA(int i,char[] array){
	  try{
		   if(array[i]=='ല'&&array[i-1]=='്'&&array[i-2]=='ല'){
			   //System.out.println("KOOTTAKSHARAM:"+array[i-2]+" "+array[i-1]+" "+array[i]);
			   return true;
		   }
		   }catch(ArrayIndexOutOfBoundsException aiob){
			
		   }
		   try{
		   if(array[i]=='ല'&&array[i+1]=='്'&&array[i+2]=='ല'){
			   //System.out.println("KOOTTAKSHARAM:"+array[i]+" "+array[i+1]+" "+array[i+2]);
			   return true;
		   }
		   }catch(ArrayIndexOutOfBoundsException aiob){
				
		   }
		   
		   return false;
  }
  public static boolean isKoottaksharamTwoSide(int i,char[] array){
	        try{
		          if(i>0&&i+1<array.length&&Util.isVyanjanam(array[i-1])&&array[i]=='്'&&Util.isVyanjanam(array[i+1]))
			        return true;
		   
		   }catch(ArrayIndexOutOfBoundsException aiob){
				
		   }catch(Exception exception){
			   
		   }
		   
		   return false;
	  
  }
  public static boolean isKoottaksharamBackward(int i,char[] array){
	  try{
		   if(i>1&&i<array.length&&Util.isVyanjanam(array[i])&&array[i-1]=='്'&&Util.isVyanjanam(array[i-2])){
			   //System.out.println("KOOTTAKSHARAM:"+array[i-2]+" "+array[i-1]+" "+array[i]);
			   return true;
		   }
	}catch(ArrayIndexOutOfBoundsException aiob){
			
		   }
	  return true;
  }
  public static boolean isKoottaksharam(int i,char[] array){
	   try{
	   if(Util.isVyanjanam(array[i])&&array[i-1]=='്'&&Util.isVyanjanam(array[i-2])){
		   //System.out.println("KOOTTAKSHARAM:"+array[i-2]+" "+array[i-1]+" "+array[i]);
		   return true;
	   }
	   }catch(ArrayIndexOutOfBoundsException aiob){
		
	   }
	   try{
	   if(Util.isVyanjanam(array[i])&&array[i+1]=='്'&&Util.isVyanjanam(array[i+2])){
		   //System.out.println("KOOTTAKSHARAM:"+array[i]+" "+array[i+1]+" "+array[i+2]);
		   return true;
	   }
	   }catch(ArrayIndexOutOfBoundsException aiob){
			
	   }
	   
	   return false;
  }
  public static boolean isChillaksharam(char script_element){
		 if(script_element>='ൺ'&&script_element<='ൿ')
			 return true;
		 return false;
	  }
 
}
