package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

class Permutations
{
	final  Hashtable<String,String> dictionary =new Hashtable<String, String>();
	public  ArrayList<String> permutation(String s) {
	   
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

	
	public  ArrayList<String> merge(ArrayList<String> list, String c) {
	    ArrayList<String> res = new ArrayList<String>();
	   
	   
	    for (String s : list) {
	      
	        for (int i = 0; i <= s.length(); ++i) {
	            String ps = new StringBuffer(s).insert(i, c).toString();
	            res.add(ps);
	        }
	    }
	    return res;
	    
	}
	
	
	public  void addToDictionary() throws IOException{
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
	
	public  HashSet<String> checkWord(HashSet<String> wordList) throws IOException{
		HashSet<String> words=new HashSet<String>(); 
		for(String s : wordList){
		if(s.equalsIgnoreCase(dictionary.get(s))){
			  words.add(s);
		  }
		}
		return words;
				
		
	}
	
	private List<String> permute (String str2){
		List<String> wordlist = new ArrayList<String>();
		for(int i=0;i<=str2.length();i++){
			for(int j=i;j<=str2.length();j++)
		{
				String element=str2.substring(i,j);
		
		 wordlist.addAll(permutation(element));
		}
			}
			return wordlist;
	}
	
	
	public static void main(String[] args) throws IOException{
		Permutations pm= new Permutations();
		HashSet<String> output =new HashSet<String>();
		List<String> finaloutput =new ArrayList<String>();
		HashSet<String> wordList = new HashSet<String>();
		HashSet<String> temp =new HashSet<String>();
		
		pm.addToDictionary();
		
		Scanner in = new Scanner(System.in);
		String str=in.next();
		String original = str;
        /*char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        str = sorted;*/
		String[] str1 = null;
		str1=str.split("(?<=\\G..........)");
	
	
		for(String str2 : str1 ){
		wordList.addAll(pm.permute(str2));
		}
		for(String ss : wordList){
			
			temp.addAll(pm.permute(ss));
			
		}
		output.addAll(pm.checkWord(temp));
		finaloutput.addAll(output);
	
		
		Collections.sort(finaloutput);
		System.out.println("Word Count : \t"+finaloutput.size()+"\n");
		for(String op: finaloutput){
			System.out.println(op);
		}
		}
		}
