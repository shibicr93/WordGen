package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

class Permutations
{
	public static ArrayList<String> permutation(String s) {
	   
	    ArrayList<String> res = new ArrayList<String>();
	   
	    if (s.length() == 1) {
	        res.add(s);
	    } else if (s.length() > 1) {
	        int lastIndex = s.length() - 1;
	        
	        String last = s.substring(lastIndex);
	       
	        String rest = s.substring(0, lastIndex);
	        
	        res = merge(permutation(rest), last);
	    }
	    return res;
	}

	
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
	    ArrayList<String> res = new ArrayList<String>();
	   
	   
	    for (String s : list) {
	      
	        for (int i = 0; i <= s.length(); ++i) {
	            String ps = new StringBuffer(s).insert(i, c).toString();
	            res.add(ps);
	        }
	    }
	    return res;
	}
	  final static Hashtable<String,String> dictionary=  new Hashtable<String, String>();
	public static void addToDictionary() throws IOException{
		 BufferedReader br = new BufferedReader(new FileReader(new File("dict_words.txt")));
		
		   try {
		       
		        String currentLine;

		        while ((currentLine=br.readLine()) != null) {
		           
		        	dictionary.put(currentLine.toLowerCase(), currentLine);
		        	
		        }
		        		       
		    } finally {
		        br.close();
		    }
	}
	
	public static List<String> checkWord(List<String> wordList) throws IOException{
		List<String> words=new ArrayList<String>(); 
		for(String s : wordList){
		if(s.equalsIgnoreCase(dictionary.get(s))){
			  words.add(s);
		  }
		}
		return words;
				
		
	}
	
	public static void main(String[] args) throws IOException{
		addToDictionary();
		HashSet<String> output =new HashSet<String>();
		List<String> wordList = new ArrayList<String>();
		String str="terminal";
		for(int i=0;i<=str.length();i++){
			for(int j=i;j<=str.length();j++)
		{
				String element=str.substring(i,j);
		
		 wordList.addAll(permutation(element));
		}
		}	
		output.addAll(checkWord(wordList));
			
		System.out.println("Word Count : \t"+output.size()+"\n");
		for(String op: output){
			System.out.println(op);
		
		}
	
	}
}