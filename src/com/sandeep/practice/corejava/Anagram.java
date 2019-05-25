package com.sandeep.practice.corejava;

import java.util.Scanner;



public class Anagram {

    static boolean isAnagram(String a, String b) {
    	if( a ==null || b == null || a.equals("") || b.equals(""))
    		return false;
    	
    	if(a.length() != b.length())
    		return false;
    	
    	java.util.HashMap<Character,Integer> firstMap = new java.util.HashMap();
    	a= a.toLowerCase();
    	b = b.toLowerCase();
    	
    	for (int index=0; index<a.length(); index++)
    	{
    		char c = a.charAt(index);
    		if(! firstMap.containsKey(c))
    		{
    			firstMap.put(c,1);
    		}
    		else
    		{
    			Integer frequency = firstMap.get(c);
    			firstMap.put(c, ++frequency);
    		}    				
    	}
    	System.out.println(firstMap);
    	
    	for(int indexTwo = 0; indexTwo<b.length();indexTwo++)
    	{
    		char letter = b.charAt(indexTwo);
    		//check letter present in the firstMap
    		if(! firstMap.containsKey(letter))
    		{
    			return false;
    		}
    		Integer f = firstMap.get(letter);
    		
    		if(f ==0)
    		{
    			return false;
    		}
    		else
    		{
    			firstMap.put(letter, --f);
    		}
    	}   	
    	

    	return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}