
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class HeadNode{
	HashMap<Character,WordCTrieNode> RootNodes=new HashMap<Character,WordCTrieNode>();
	public void addWord(String word,int wordClass,String prefix9,String suffix9){
		word=word.trim();
		if(word==""||word.length()==0)
			return;
		char[] wordAsArray=word.toCharArray();
		WordCTrieNode rootNode=RootNodes.get(wordAsArray[0]);
		if(rootNode==null){
			rootNode=new WordCTrieNode();
			RootNodes.put(wordAsArray[0],rootNode);
		       rootNode.setCharcter(wordAsArray[0]);
		}
        rootNode.addWord(wordAsArray,0,wordClass,prefix9,suffix9);
		
	}
	 /*PREFIX AND SUFFIX*/
	 /*public void probablePrefixes9(HashMap<String,Float> hashmap,char[] wordAsArray){
		 if(wordAsArray.length>0){
				WordCTrieNode rootNode=RootNodes.get(wordAsArray[0]);
				if(rootNode!=null){
					rootNode.probablePrefixes9(hashmap,wordAsArray,0);
				}
				}
	 }
	  public void probableSuffixes9(HashMap<String,Float> hashmap,char[] wordAsArray){
		  if(wordAsArray.length>0){
				WordCTrieNode rootNode=RootNodes.get(wordAsArray[0]);
				if(rootNode!=null){
					rootNode.probableSuffixes9(hashmap,wordAsArray,0);
				}
				} 
	  }*/
	public void prob_C9(float[] prob,int[] C,char[] wordAsArray){
		if(wordAsArray.length>0){
		WordCTrieNode rootNode=RootNodes.get(wordAsArray[0]);
		if(rootNode!=null){
			rootNode.prob_C9(prob, C, wordAsArray,0);
		}
		}
		
	}
   
   public void view_node(){
	   System.out.println("HEAD NODE ENTRIES");
	   for (Map.Entry entry : this.RootNodes.entrySet()) {
		    System.out.println(entry.getKey());
		}
	   System.out.println("\n");
	   for (Map.Entry entry : this.RootNodes.entrySet()) {
		    WordCTrieNode node=(WordCTrieNode)entry.getValue();
		    node.view_node(0);
		}
   }
	
}
class WordCTrieNode{
   Character ch;
   HashMap<Integer,Integer> Word_C_Prob=new HashMap<Integer,Integer>();
   HashMap<String,Integer> Split_Prefix9=new HashMap<String,Integer>();
   HashMap<String,Integer> Split_Suffix9=new HashMap<String,Integer>();
   HashMap<Character,WordCTrieNode> word_trieNextNodes=new HashMap<Character,WordCTrieNode>();
   public void setCharcter(char character){
	   this.ch=character;
   }
   public void view_node(int l){
	   System.out.print("LEVEL "+l+"  CHAR="+this.ch+"   MAP ENTRIES->");
	   for (Map.Entry entry9 : this.word_trieNextNodes.entrySet())
		   System.out.print(entry9.getKey()+"  ");
	   System.out.print("\n");
	   for (Map.Entry entry : this.word_trieNextNodes.entrySet()) {
		    WordCTrieNode node=(WordCTrieNode)entry.getValue();
		    node.view_node(l+1);
		    
		}
	   
   }
   
   public void addWord(char[] wordAsArray,int currentIndex,int wordclass,String prefix9,String suffix9){
	   
	   Integer classCount=Word_C_Prob.get(wordclass);
	   http://hamariweb.com/dictionaries/air_urdu-meanings.aspx
	   if(classCount==null)
		   Word_C_Prob.put(wordclass,1);
	   else{
		   classCount++;
		   Word_C_Prob.put(wordclass,classCount);
	     }
	   if(prefix9!=null&&suffix9!=null){
	   classCount=Split_Prefix9.get(prefix9);
	   
	   if(classCount==null)
		   Split_Prefix9.put(prefix9,1);
	   else{
		   classCount++;
		   Split_Prefix9.put(prefix9,classCount);
	     }
	   
       classCount=Split_Prefix9.get(prefix9);
	   
	   if(classCount==null)
		   Split_Suffix9.put(suffix9,1);
	   else{
		   classCount++;
		   Split_Suffix9.put(suffix9,classCount);
	     }
	   }
	   System.out.println("CLASS COUNT"+wordAsArray[currentIndex]);
	   currentIndex++;
	   
	   
	   if(currentIndex<wordAsArray.length){
		   WordCTrieNode nextNode=word_trieNextNodes.get(wordAsArray[currentIndex]);
		   if(nextNode==null){
			   nextNode=new WordCTrieNode();
			   nextNode.setCharcter(wordAsArray[currentIndex]);
			   word_trieNextNodes.put(wordAsArray[currentIndex],nextNode);
			   
		   }
		   nextNode.addWord(wordAsArray,currentIndex,wordclass,prefix9,suffix9);
			   
	   }
	 }
     /*PREFIX AND SUFFIX*/
    /* public void probablePrefixes9(HashMap<String,Float> hashmap,char[] wordAsArray,int currentIndex){
    	 if(currentIndex>1){
    		 Integer total9=0;
    		 for(Map.Entry<String, Integer> entry : Split_Prefix9.entrySet()) {
 			    total9=total9+entry.getValue();
 			}
    		 for(Map.Entry<String, Integer> entry : Split_Prefix9.entrySet()) {
    			    Integer frequency9=entry.getValue();
    			    String key=entry.getKey();
    			    float prob99=(float)frequency9/total9;
    			    Float currentProb9=hashmap.get(key);
    			    if(currentProb9==null){
    			    	hashmap.put(key,prob99);
    			    	
    			    }else{
    			    	hashmap.put(key,prob99*currentProb9);
    			    }
    			}
    		 
    	 }
    	 currentIndex++;

		   if(currentIndex<wordAsArray.length){
			  
			   WordCTrieNode nextNode=word_trieNextNodes.get(wordAsArray[currentIndex]);
			   //System.out.println("START:NEXT LETTER=I/p"+wordAsArray[currentIndex]);
			       if(nextNode!=null){
			    	   nextNode.probablePrefixes9(hashmap,wordAsArray,currentIndex);
				     System.out.println("END:o/p"+nextNode.ch);
			       }
			   }
	
    	 
     }
     public void probableSuffixes9(HashMap<String,Float> hashmap,char[] wordAsArray,int currentIndex){
    	 if(currentIndex>1){
    		 Integer total9=0;
    		 for(Map.Entry<String, Integer> entry : Split_Suffix9.entrySet()) {
 			    total9=total9+entry.getValue();
 			}
    		 for(Map.Entry<String, Integer> entry : Split_Suffix9.entrySet()) {
    			    Integer frequency9=entry.getValue();
    			    String key=entry.getKey();
    			    float prob99=(float)frequency9/total9;
    			    Float currentProb9=hashmap.get(key);
    			    if(currentProb9==null){
    			    	hashmap.put(key,prob99);
    			    	
    			    }else{
    			    	hashmap.put(key,prob99*currentProb9);
    			    }
    			}
    		 
    	 }
    	 currentIndex++;

		   if(currentIndex<wordAsArray.length){
			  
			   WordCTrieNode nextNode=word_trieNextNodes.get(wordAsArray[currentIndex]);
			   //System.out.println("START:NEXT LETTER=I/p"+wordAsArray[currentIndex]);
			       if(nextNode!=null){
			    	   nextNode.probablePrefixes9(hashmap,wordAsArray,currentIndex);
				     System.out.println("END:o/p"+nextNode.ch);
			       }
			   }
	
    	 
     }*/

     public void prob_C9(float[] prob,int[] C,char[] wordAsArray,int currentIndex){
    	 int totalFrequency=0;
    	 if(currentIndex>=ConfigurationSettings.getConfigurationSettings().getInitialSkipProbClaculation()){
    	    for(int i=0;i<C.length;i++){
    	    	Integer current_frequeny=Word_C_Prob.get(C[i]);
    	    	if(current_frequeny!=null){
    	    		totalFrequency=totalFrequency+current_frequeny;
    	    	}
    	    }
    	    System.out.println("NODE CHARACTER="+this.ch+"INPUT CHAR="+wordAsArray[currentIndex]+" INDEX="+currentIndex);
    	    if(totalFrequency!=0){
    	    	for(int i=0;i<C.length;i++){
        	    	Integer current_frequeny=Word_C_Prob.get(C[i]);
        	    	System.out.println("CLASS "+C[i]+"  FREQ"+current_frequeny);
        	    	if(current_frequeny!=null){
        	    		if(prob[C[i]]!=0){
        	    			prob[C[i]]=prob[C[i]]+prob[C[i]]*((float)current_frequeny/totalFrequency);
        	    		}else{
        	    			prob[C[i]]=(float)current_frequeny/totalFrequency;
        	    		}
        	    	}
        	    }
    	    	
    	    }
    	 }
    	    currentIndex++;
    		   
    		   if(currentIndex<wordAsArray.length){
    			  
    			   WordCTrieNode nextNode=word_trieNextNodes.get(wordAsArray[currentIndex]);
    			   //System.out.println("START:NEXT LETTER=I/p"+wordAsArray[currentIndex]);
    			       if(nextNode!=null){
    			    	   nextNode.prob_C9(prob,C,wordAsArray,currentIndex);
    				   System.out.println("END:o/p"+nextNode.ch);
    			       }
    			   }
    	    
     }
     
}

