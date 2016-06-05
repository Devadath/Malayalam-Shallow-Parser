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
import java.util.StringTokenizer;

class Word_Split_Details{
	String word;
	List<Integer> split_points9=new ArrayList<Integer>();
	String[] word99;
};
class WordIndex{
	String word;
	int index;
	int rule;
    boolean isSwaramSuffixNotRequired;
    boolean flag;
    String ruleString9;
};
class SplitModifiers9{
	String prefix9;
	String suffix9;
};
class TrainingFileCreator{
  private static  TrainingFileCreator SingleInstance=null;
  public static String DummyTrainingFile="";
  BufferedWriter oaw=null;
  private TrainingFileCreator(){
    try{
    oaw= new BufferedWriter(new FileWriter(DummyTrainingFile));
        }catch(Exception expt){
           System.out.println(expt+"HERE_________________DUMMY TRAINING FILE NOT CRATED");
           System.exit(0);
      }
  }
  public static TrainingFileCreator getInstance(){
       if(SingleInstance==null){
          SingleInstance=new TrainingFileCreator();
        }
     return  SingleInstance;
  }
  public  void  closeDummyFile() {
    try{
     oaw.close();
      }catch(Exception expt){
           System.out.println(expt+"DUMMY TRAINING FILE NOT CRATED");
                      System.exit(0);
      }
   }
  public void  writeToFile(String DummyFileRecord){
     try{
     oaw.write(DummyFileRecord+"\n");
        }catch(Exception expt){
           System.out.println(expt+"DUMMY TRAINING FILE NOT CRATED");

                    System.exit(0);
      }
  }
   
};
public class StatisticalSandhiSplitter9 {
	
	static HeadNode PositionPrefix=new HeadNode();
	static HeadNode PositionSuffix=new HeadNode();
	//static BufferedWriter poaw;	
	static int[] Carray;
	static{
		CArray(2);
	}
	public static String combineAndFormWordString(String prefix,char[] wordArray,int startIndex,int lastIndex){
	    for(int i=startIndex;i<=lastIndex;i++)
	    	prefix=prefix+wordArray[i];
	    return prefix;
	    
  }
	 public static String  probableCuffix9(String word99){
		 char[] wordAsArray9=word99.toCharArray();
		 HashMap<String,Float> hashmap9=new HashMap<String,Float>();
		 /*suffix of the first word from position prefix-PART OF SUFFIX PREFIX*/
		/* PositionPrefix.probableSuffixes9(hashmap9,wordAsArray9);*/
		 word99="";
		 float prob_9=0,current9=0;
		 for(Map.Entry<String, Float> entry : hashmap9.entrySet()) {
			    current9=entry.getValue();
			    if(current9>prob_9){
			       word99=entry.getKey();
			       prob_9=current9;
			    }
			}
		 word99=word99.trim();
		 return word99;
		 
	 }
	 public static String  probableCPrefix9(String word99){
		 System.out.println("XXXXXXXXXXXXXXXXXXXXWORD "+word99);
		 char[] wordAsArray9=word99.toCharArray();
		 HashMap<String,Float> hashmap9=new HashMap<String,Float>();
		 /*Prefix of the Second word from position Suffix-PART OF SUFFIX AND PREFIX */
		/* PositionSuffix.probableSuffixes9(hashmap9,wordAsArray9);*/
		 word99="";
		 float prob_9=0,current9=0;
		 for(Map.Entry<String, Float> entry : hashmap9.entrySet()) {
			    current9=entry.getValue();
			    if(current9>prob_9){
			       word99=entry.getKey();
			       System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+word99);
			       prob_9=current9;
			    }
			}
		 word99=word99.trim();
		// System.exit(0);
		 return word99;
		 
	 }
	 public static WordIndex splitJoins(char[] wordAsArray,int i){
		   WordIndex wordindex=new WordIndex();
		   String currentWord="";
		   
		   String rule="";
		   int ruleId=0;
		 /* try {
			poaw.write("\n"+wordAsArray[i]+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/	  
		    	  try{
		    		 /* try{
		    		  if(Util.isKoottaksharamForward(i,wordAsArray)||Util.isKoottaksharamTwoSide(i, wordAsArray))
		    			  continue;
		    		  }catch(ArrayIndexOutOfBoundsException aiob){}*/
		    		  if(Util.isKoottaksharam(i,wordAsArray)){
		    			    	  //&&Util.isSymbol(wordAsArray[i-1],false)
		                         //THIRD RULE
		                        if(Util.isSymbol(wordAsArray[i+1],true)){
		                          String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
		                          
		                          if(swaram!=null){
		                             // wordList.add(currentWord);
		                                  rule="third";
		                                   ruleId=SandhiRules.KOOTTAKSHARAM;
		                                  
		                                   
		                              //    newWordFormed=combineAndFormWordString(swaram,wordAsArray,i+2);
		                                  
		                                 
		                                 
		                          }
		                      }else{
		                      	rule="second";
		                      	ruleId=SandhiRules.KOOTTAKSHARAM;
		                        
		      	    		    //newWordFormed=combineAndFormWordString("അ",wordAsArray,i+1);
		      	    		    
		        			 
		                  	
		                  }
		    		  

		                }else if((wordAsArray[i]=='യ'||wordAsArray[i]=='വ')&&wordAsArray[i-1]!='്'){
			       /* try {
						poaw.write("\n ENTERED YA\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				       
				    	  if(wordAsArray.length>i+1&&Util.isSymbol(wordAsArray[i+1],true)){
				    		  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
				    		  if(swaram!=null){
				    			  rule="first";
				    			  ruleId=SandhiRules.YAKARAM;
				    			  // wordList.add(currentWord);
				    			  //newWordFormed=combineAndFormWordString(swaram,wordAsArray,i+2);
				    			  
				    			 
				    		  }
				    	  }else{
				    		  rule="first";
				    		  ruleId=SandhiRules.YAKARAM;
				    		  //newWordFormed=combineAndFormWordString("അ",wordAsArray,i+1);
				    		  
			    			  
				    	  }
				    	  
				      }else if(wordAsArray[i]=='മ'&&wordAsArray[i-1]!='്'){
				    	  //SECOND RULE
				    	  if(wordAsArray.length>i+1&&Util.isSymbol(wordAsArray[i+1],true)){
				    		  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
				    		  if(swaram!=null){
				    			  // wordList.add(currentWord);
				    			  rule="second";
				    			  ruleId=SandhiRules.MAKARAM;
				    			//  newWordFormed=combineAndFormWordString(swaram,wordAsArray,i+2);
				    			  currentWord=currentWord+'ം';
				    			  
				    			
				    		  }
				    	  }else{
				    		  rule="second";
				    		  ruleId=SandhiRules.MAKARAM;
				    		  currentWord=currentWord+'ം';
				    		  //newWordFormed=combineAndFormWordString("അ",wordAsArray,i+1);
				    		   
			    			  
				    	  }
				      }else if(Util.isChilluReplacableVyanjanam(wordAsArray[i])&&wordAsArray[i-1]!='്'){
				    	                     //FOURTH RULE
				    	  if(Util.isSymbol(wordAsArray[i+1],true)){
				    		  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
				    		  if(swaram!=null){
				    			  rule="fourth";
				    			  ruleId=SandhiRules.CHILLUVYANJANAM;
				    			
				    			  // wordList.add(currentWord);
				    			//  newWordFormed=combineAndFormWordString(swaram,wordAsArray,i+2);
				    			  
				    			
				    		  }
				    	  }
				      }else if(Util.isVyanjanam(wordAsArray[i])){
			    	  //&&Util.isSymbol(wordAsArray[i-1],false)
	                 //THIRD RULE
	                if(Util.isSymbol(wordAsArray[i+1],true)){
	                  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
	                  if(swaram!=null){
	                     // wordList.add(currentWord);
	                                rule="third";
	                                ruleId=SandhiRules.VYANJANAM;
	                              //  newWordFormed=combineAndFormWordString(swaram,wordAsArray,i+2);
	                                currentWord=currentWord+wordAsArray[i]+"്";
	                              
	                             
	                          
	                  }
	              }
		  

	        }else if(Util.isChillaksharam(wordAsArray[i])){
							  String isSuffix=currentWord+wordAsArray[i];
							  if(Util.isSuffix(isSuffix)){
								  rule="just seperate";
	                              ruleId=SandhiRules.JUST_SEPERATE;
	                              //newWordFormed=combineAndFormWordString("",wordAsArray,i+1);
	                              currentWord=currentWord+wordAsArray[i];
	                              
	                            
							  }
						  }
					  }catch(ArrayIndexOutOfBoundsException aiob){
						  
					  }
					  
			wordindex.rule=ruleId;
			wordindex.index=i;
			wordindex.ruleString9=rule;
		  
		 return wordindex;
		  
	  }

	 
	 /*WORD IS SPLITTED IN THE FOLLOWING FUNCTION*/
	public static  List<String> getSplitWords(List<WordIndex> wordList,String word){
		   Iterator<WordIndex> iterator=wordList.iterator();
		   int i=0;
		   int lastIndex=0;
		   List<String> listOfWords=new ArrayList<String>();
		   WordIndex CurrentwordIndex=null;
		   
		   String prefix="";
		   char[] wordAsArray=word.toCharArray();
		   String newWordFormed="";
		    int CLIT_COUN9=0;
		   while(iterator.hasNext()){
			   CurrentwordIndex=iterator.next();
	             i=CurrentwordIndex.index;
			    /* try {
					poaw.write("WORD ZZZZZZ="+word+"  RULE:-"+CurrentwordIndex.ruleString9+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				  if(CurrentwordIndex.rule==SandhiRules.KOOTTAKSHARAM){
				    	try{
				    	if(Util.isSymbol(wordAsArray[i+1],true)){
	                        
	                        
	                        	String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
	                        
	                        if(swaram!=null){
	                        	   if(Util.is_ILLA(i,wordAsArray))
	                        		   newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i);
	                        	   else
	                               newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i)+"്";
	                              
	                               prefix=swaram;
	                               lastIndex=i+2;
	                               listOfWords.add(newWordFormed);
	                               CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
	                               CLIT_COUN9++;
	                                
	                        }}else{
	                    	//currentWord=currentWord+wordAsArray[i]+"്";
	                        	if(Util.is_ILLA(i,wordAsArray))
	                        		   newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i);
	                        	   else
	                               newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i)+"്";
	                              
	    	    		          listOfWords.add(newWordFormed);
	                        	prefix="അ";
	                        	 CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
	                               CLIT_COUN9++;
	                        	lastIndex=i+1;
	                        	}
	                        
				    	}catch(ArrayIndexOutOfBoundsException aion){}
	                }else if(CurrentwordIndex.rule==SandhiRules.CHILLUVYANJANAM){
	                	try{
	                        //FOURTH RULE
	  			    	  if(Util.isSymbol(wordAsArray[i+1],true)){
	  			    		  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
	  			    		  if(swaram!=null){
	  			    			newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i-1)+Util.getChilluForVyanjanam(wordAsArray[i]);
	                            prefix=swaram;
	                            lastIndex=i+2;
	                            CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
	                               CLIT_COUN9++;
	                            listOfWords.add(newWordFormed);
	                            }
	  			    	  }
	                		
	                	}catch(ArrayIndexOutOfBoundsException aiob){
	                		
	                	}
				    	
				    }else if(CurrentwordIndex.rule==SandhiRules.MAKARAM){
				    	try{
				    		if(wordAsArray.length>i+1&&Util.isSymbol(wordAsArray[i+1],true)){
					    		  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
					    		  if(swaram!=null){
					    			  // wordList.add(currentWord);
					    			  newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i-1)+'ം';
		                               prefix=swaram;
		                               lastIndex=i+2;
		                               CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
		                               CLIT_COUN9++;
		                               listOfWords.add(newWordFormed);
		                               }
					    	  }else{
					    		  newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i-1)+'ം';
	    	    		          listOfWords.add(newWordFormed);
	                        	prefix="അ";
	                        	 CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
	                               CLIT_COUN9++;
	                        	lastIndex=i+1;
	                        	
					    	  }
				    	}catch(ArrayIndexOutOfBoundsException aiob){}
				    	
				    }else if(CurrentwordIndex.rule==SandhiRules.YAKARAM){
				    	  if(wordAsArray.length>i+1&&Util.isSymbol(wordAsArray[i+1],true)){
				    		  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
				    		  if(swaram!=null){
				    			  newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i-1);
	                              prefix=swaram;
	                              lastIndex=i+2;
	                              CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
	                               CLIT_COUN9++;
	                              listOfWords.add(newWordFormed);
				    		  }
				    	  }else{
				    		  newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i-1);
		    		          listOfWords.add(newWordFormed);
	                    	prefix="അ";
	                    	lastIndex=i+1;
	                    	 CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
                             CLIT_COUN9++;
				    	  }
				    	
				    }else if(CurrentwordIndex.rule==SandhiRules.VYANJANAM){
				    	try{
				    		 if(Util.isSymbol(wordAsArray[i+1],true)){
				                  String swaram=Util.getSwaramForSymbol(wordAsArray[i+1]);
				                  if(swaram!=null){
				                     // wordList.add(currentWord);
				                	  newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i)+"്";
		                               prefix=swaram;
		                               lastIndex=i+2;
		                               listOfWords.add(newWordFormed);
		                               CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
		                               CLIT_COUN9++;
		                               
				                  }
				              }
				    	}catch(ArrayIndexOutOfBoundsException aiob){}
				    }else if(CurrentwordIndex.rule==SandhiRules.JUST_SEPERATE){
				    	try{
				    	newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,i);
	                    prefix="";
	                    lastIndex=i+1;
	                    listOfWords.add(newWordFormed);
	                    CCResult9.getInstance().countRuleAcuracy9(word, newWordFormed, prefix, CurrentwordIndex.rule, CLIT_COUN9);
                        CLIT_COUN9++;
				    	}catch(ArrayIndexOutOfBoundsException aiob){
				    		
				    	}
				    }
				
		   }
		   newWordFormed=combineAndFormWordString(prefix,wordAsArray,lastIndex,wordAsArray.length-1);
		  
			  listOfWords.add(newWordFormed);
		   return listOfWords;
	   }
	   
	public static  void CArray(int n){
		int[] Carray=new int[n];
		for(int i=0;i<n;i++){
			Carray[i]=i;
		}
		StatisticalSandhiSplitter9.Carray=Carray;
	}
	public static String getPositionPrefix(char[] wordAsArray,int index9,int size){
		String word="";
		int count=0;
		 for(int i=index9;i<wordAsArray.length&&i>=0;i--){
			 if(count==size)
				 break;
			 word=word+wordAsArray[i];
			 count++;
		 }
		 System.out.println("B_WORD="+word);
		 return word;
	}
	public static String getPositionSuffix(char[] wordAsArray,int index9,int size){
		String word="";
		int count=0;

		 for(int i=index9+1;i<wordAsArray.length&&i>=0;i++){
			 if(count==size)
				 break;
			 word=word+wordAsArray[i];
			 count++;
		 }
		 System.out.println("F_WORD="+word);
		 return word;
	}
	public static  String getSuffixOfFirstWord9(String word99){
		char[] wordAsArray=word99.toCharArray();
		word99="";
		try{
		   if(wordAsArray.length>=3){
			   for(int i=wordAsArray.length-3;i<wordAsArray.length;i++){
				  word99=word99+wordAsArray[i]; 
			   }
			   return word99;
		   }
		}catch(ArrayIndexOutOfBoundsException arrayoutofboundindex){
			
			return null;
		}
		return null;
	}
	public static String getPrefixOfSecondWord9(String word99){
		char[] wordAsArray=word99.toCharArray();
		word99="";
		try{
		   if(wordAsArray.length>=3){
			   for(int i=0;i<3;i++){
				  word99=word99+wordAsArray[i]; 
			   }
			   return word99;
		   }
		}catch(ArrayIndexOutOfBoundsException arrayoutofboundindex){
			
			return null;
		}
		return null;
	}
	public static void processWordDetails(Word_Split_Details splitDetails9,BufferedWriter patternFile){
		char[] wordAsArray=splitDetails9.word.trim().toCharArray();
		String word="",prefix9=splitDetails9.word99[1],suffix9=splitDetails9.word99[0];
		int split_word_count9=2;
		try {
			patternFile.write(splitDetails9.word+"\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<wordAsArray.length;i++){
			/*check Split Points*/
			if(splitDetails9.split_points9.contains(i)){
				System.out.println("CCCCCCCCCCCCCCCCCCCCCCC BEFORE PROCESSING FIRST WORD"+suffix9+"   SECOND WORD"+prefix9);
				
				/*suffix of first word*/
			suffix9=getSuffixOfFirstWord9(suffix9);
				
				/*prefix of second word*/
				prefix9=getPrefixOfSecondWord9(prefix9);
				System.out.println("CCCCCCCCCCCCCCCCCCCCCCC AFTER PROCESSING SUFIIX OF FIRST WORD"+suffix9+"   PREFIX OF SECOND WORD"+prefix9);
				
			    /*Configuration*/
				word=getPositionPrefix(wordAsArray,i,ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters());
				try {
					patternFile.write(word+" & ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PositionPrefix.addWord(word,0,prefix9,suffix9);
				word=getPositionSuffix(wordAsArray,i,ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters());
				try {
					patternFile.write(word+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				PositionSuffix.addWord(word,0,prefix9,suffix9);
				try {
					patternFile.write(suffix9+" & "+prefix9+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("CLASS = "+0);
				System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCC"+splitDetails9.word99[0]);
				if(splitDetails9.word99!=null&&split_word_count9<splitDetails9.word99.length){
					/*suffix9:suffix of first word of split*/
					/*prefix9:prefix of second word of split*/
					suffix9=splitDetails9.word99[split_word_count9-1];
					prefix9=splitDetails9.word99[split_word_count9];
				   split_word_count9++;
				}
				
			}else{
				word=getPositionPrefix(wordAsArray,i, ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters());
				PositionPrefix.addWord(word,1,null,null);
				word=getPositionSuffix(wordAsArray,i,ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters() );
				PositionSuffix.addWord(word,1,null,null);
				System.out.println("CLASS = "+1);
		    }
			
		}
		//if(splitDetails9.word99.length>2)
	//	System.exit(0);
		
	}
	public static void getSplitPoints9(String word,BufferedWriter oaw,BufferedWriter oaw_w_split_points,BufferedWriter oaw_w_plaintext){
		 try {
                 String SandhiPoints="";
				System.out.println("\n\n\n\n\n\\n\n\n\n\n\n\nn\n\n\n\\n\n\\n\n\\n\n\n\n\n\n\\nDETAILS\n");
		char[] wordAsArray=word.trim().toCharArray();
		String positionPrefix9="",positionSuffix9="";
		oaw.write("\n");
		List<WordIndex> list99=new ArrayList<WordIndex>();
		for(int i=0;i<wordAsArray.length;i++){
			/*check Split Points*/
			
			positionPrefix9=getPositionPrefix(wordAsArray,i,ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters());
				
			positionSuffix9=getPositionSuffix(wordAsArray,i,ConfigurationSettings.getConfigurationSettings().getSplitPointNoOfCharacters());
				float split9=classOf(positionPrefix9,positionSuffix9);
				if(split9==0){
                                    if(SandhiPoints!="")
                                     SandhiPoints=SandhiPoints+","+i;
                                    else
                                       SandhiPoints=i+"";
				   list99.add(splitJoins(wordAsArray,i));
				   String CsuffixOfOneWord9=probableCuffix9(positionPrefix9);
					String CPrefixOfSecondWord9=probableCPrefix9(positionSuffix9);
					oaw.write("\n {CSUFFIX9-----> "+CsuffixOfOneWord9+" "+CPrefixOfSecondWord9+"<-----PREFIX9} \n");
					CCResult9.getInstance().registerSplitPointIdentification9(word.trim(),i,true);
				}else{
					CCResult9.getInstance().registerSplitPointIdentification9(word.trim(),i,false);
				}
				    
			oaw.write(wordAsArray[i]+" ["+split9+"]");
            
            
                  
				
			
		}
		List<String> list999=getSplitWords(list99, word);
		CCResult9.getInstance().OverallSplitAccuracy9(word.trim(), list999);
	    Iterator<String> iterator9=list999.iterator();
	    String word999="";
	    oaw.write(word+"	");
	    oaw_w_split_points.write("\n");
	    oaw_w_split_points.write(word+" ");
            String splitWordsRecord="";
	    if(iterator9.hasNext()){
	    	
	    	word999=iterator9.next();
                splitWordsRecord=word999;
	    	oaw.write(word999);
	    	oaw_w_split_points.write(word999);
	    	oaw_w_plaintext.write(word999);
	    }
	    
	    	
	    while(iterator9.hasNext()){
	    	word999=iterator9.next();
                splitWordsRecord=splitWordsRecord+"+"+word999;
	    	oaw.write("+"+word999);
	    	oaw_w_split_points.write("+"+word999);
	    	oaw_w_plaintext.write(" "+word999);
	    }
            //if(SandhiPoints!="")
	    TrainingFileCreator.getInstance().writeToFile(word+"="+splitWordsRecord+"|"+SandhiPoints);
		oaw.write("\n");
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static  float classOf(String positionPrefix9,String positionSuffix9){
	
		System.out.println("word="+positionPrefix9+" AND "+positionSuffix9);
		positionPrefix9=positionPrefix9.trim();
		float[] C_prefixProb=new float[2];
	    System.out.println("PREFIX PROB");
	    PositionPrefix.prob_C9(C_prefixProb,Carray,positionPrefix9.toCharArray());
		float[] C_suffixProb=new float[2];
		System.out.println("SUFFIX PROB");
		PositionSuffix.prob_C9(C_suffixProb,Carray,positionSuffix9.toCharArray());
		
		float maxProb=C_prefixProb[1]*C_suffixProb[1];
		float c_prob9=0;
		int CLAC99=1;
		
		
		System.out.print("CLASS="+CLAC99+",Prefix Prob="+C_prefixProb[1]+",Suffix_Prob="+C_suffixProb[1]);
		for(int i=1;i>=0;i--){
			System.out.print("CLASS="+i+",Prefix Prob="+C_prefixProb[i]+",Suffix_Prob="+C_suffixProb[i]);
			c_prob9=C_prefixProb[i]*C_suffixProb[i];
		    if(c_prob9>maxProb){
				maxProb=c_prob9;
				CLAC99=i;
			}
		}
		System.out.println("___________________________________________________________________________________________________");
		return CLAC99;
		//return CLAC99;
	}
	
	public static Word_Split_Details  processWords9(String word){
		Word_Split_Details detail9=new Word_Split_Details();
		StringTokenizer n_wordTokenizer999=new StringTokenizer(word,"=",false);
		    if(n_wordTokenizer999.hasMoreTokens())
			detail9.word=n_wordTokenizer999.nextToken().trim();
		    System.out.println("WWWW "+detail9.word);
		    String word_split_ponits;
		    
		    if(n_wordTokenizer999.hasMoreTokens()){
		      word_split_ponits=n_wordTokenizer999.nextToken().trim();
		      StringTokenizer n_wordTokenizer9=new StringTokenizer(word_split_ponits,"|",false);
		      
		      String word_splits9=n_wordTokenizer9.nextToken();
		      
		      StringTokenizer n_wordTokenizer_word99=new StringTokenizer(word_splits9,"+",false);
		      int count9=n_wordTokenizer_word99.countTokens();
		      detail9.word99=new String[count9];
		      int i=0;
		      while(n_wordTokenizer_word99.hasMoreTokens()){
		    	  detail9.word99[i]=n_wordTokenizer_word99.nextToken().trim();
		    	  System.out.println("WORD+++++++++++++++"+detail9.word99[i]);
		    	  i++;
		      }
		    
		      if(n_wordTokenizer9.hasMoreTokens()){
		    	 word_split_ponits=n_wordTokenizer9.nextToken();
		    	 System.out.println("NNNN "+word_split_ponits);
		    	 
		    	 word_split_ponits=word_split_ponits.trim();
		    	 StringTokenizer Cn_wordTokenizer=new StringTokenizer(word_split_ponits,",",false);
		    	 String NumString9="";
		    	 while(Cn_wordTokenizer.hasMoreTokens()){
		    		 NumString9=Cn_wordTokenizer.nextToken().trim();
		    		 if(NumString9!=""){		 
		    		 int Num=Integer.parseInt(NumString9);
		    		 detail9.split_points9.add(Num);
		    		
		    		 }
		    	 }
		    		 
		      }
		    }
		    
	   	
		return detail9;
	}
	public static void main(String[] a){
		
		/*String inputFile="/home/kjjose/Desktop/sandhi_rules/Sandhi_9999";
		String outputFile="/home/kjjose/Desktop/sandhi_rules/output9999";
		String DataFile999="/home/kjjose/Desktop/sandhi_rules/data_9999";*/
		
		String DataFile999="sandhi_rules/testNtrainData999/mal9/data_9999";
		String inputFile="sandhi_rules/testNtrainData999/mal9/Sandhi_9999";
		String outputFile="sandhi_rules/testNtrainData999/mal9/SandhiOUT";
		ConfigurationSettings.getConfigurationSettings().readConfig(a[0]);
		DataFile999=ConfigurationSettings.getConfigurationSettings().getInputDatafile();
		inputFile=ConfigurationSettings.getConfigurationSettings().getTrainingfile();
		outputFile=ConfigurationSettings.getConfigurationSettings().getWordlevleoutput_with_splitpoints();
		String outputFile_without_split_points=ConfigurationSettings.getConfigurationSettings().getWordleveloutput_without_splitpoints();
		String plaintTextOutput=ConfigurationSettings.getConfigurationSettings().getPlain_text_output();
		String patterFile=ConfigurationSettings.getConfigurationSettings().getPatternfile();
		String inputTestDataSplitDetailsFile=ConfigurationSettings.getConfigurationSettings().getInputDataTestDetails9();
               TrainingFileCreator.DummyTrainingFile=ConfigurationSettings.getConfigurationSettings().getDummyTrainingFileRecord();
		try {
			CCResult9.getInstance().parseTestFile9(ConfigurationSettings.getConfigurationSettings().getInputDataTestDetails9());
			//System.exit(0);
		} catch (IOException e1) {
			System.out.println("Wrongly Set Test Details File");
			return;
		}
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(9);
		if(list.contains(9))
			System.out.print("CONTAINS 9\n");
		
		if(list.contains(3))
			System.out.print("CONTAINS 3\n");
		if(list.contains(2))
			System.out.print("CONTAINS 1\n");
		
		
		
	try {
			BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(inputFile)));
			BufferedWriter oaw= new BufferedWriter(new FileWriter(outputFile));
			BufferedWriter oaw_w_split_points= new BufferedWriter(new FileWriter(outputFile_without_split_points));
			BufferedWriter oaw_w_plaintext= new BufferedWriter(new FileWriter(plaintTextOutput));
			BufferedWriter oaw_w_PatternFile= new BufferedWriter(new FileWriter(patterFile));
			BufferedReader reader9 = new BufferedReader( new InputStreamReader(new FileInputStream(DataFile999)));
			String New_Line999="";
		
			
			while((New_Line999=reader.readLine())!=null){
				 Word_Split_Details word_Split_Details9=processWords9(New_Line999);
				 processWordDetails(word_Split_Details9,oaw_w_PatternFile);
				//if(word_Split_Details9.split_points9.contains(9))
				//	System.out.println("Contains 9");
				
			
				//System.out.println(New_Line999);
				
			}
			int k;
			String word="";
		while((k = reader9.read()) != -1) {
			     char character = (char) k;
			     if(character==' '||character=='.'||character=='\n'||character==','||character=='\t'){
			    	 word=word.trim();
			    	 if(word!=""){
			    		 getSplitPoints9(word,oaw,oaw_w_split_points,oaw_w_plaintext);   
			             word="";
			    	   }
			    	   oaw_w_plaintext.write(character);
			    	 continue;
			     }
			   
			     word=word+character;
			   
			   }

			reader9.close();
			reader.close();
			oaw.close();
			oaw_w_split_points.close();
			oaw_w_plaintext.close();
			oaw_w_PatternFile.close();
                        TrainingFileCreator.getInstance().closeDummyFile();
		//	poaw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  CCResult9.getInstance().printResult();
   
		
	}
	
 
}
