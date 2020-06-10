/*Jessica Noel
 * CS284
 * Assignment 5
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Anagrams {
	final Integer[] primes= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	Map<Character,Integer> letterTable = new HashMap<>();
	Map<Long,ArrayList<String>> anagramTable= new HashMap<Long,ArrayList<String>>();
	
	
	//constructor
	public Anagrams() {
		buildLetterTable();
	}

	
	//builds hash table
	private void buildLetterTable() {
		int index = 0;
		
	    for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
	      letterTable.put(alphabet, primes[index]);
	      index++;
	    }
	}
	
	
	private Long myHashCode(String s) {
		Long output= 1L;
		
		for (int i=0; i<s.length(); i++) {
			output*=this.letterTable.get(s.charAt(i));
		}
		
		return output;
	}
	
	
	public void addWord(String s) {
		Long key = myHashCode(s);
		
		if (this.anagramTable.get(key) != null) {
			this.anagramTable.get(key).add(s);
		}
		
		else {
			
			ArrayList<String> lst = new ArrayList<String>();
			lst.add(s);
			this.anagramTable.put(key, lst);
		}
	}
		
	
	
	
	//given method
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		while ((strLine = br.readLine()) != null) {
			this.addWord(strLine);			
		}
		
		br.close();
	}
	
	
	
	private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries(){
		ArrayList<Map.Entry<Long, ArrayList<String>>> output = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		int max=0;
		
		for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
			
			if (entry.getValue().size()>max) {
				max=entry.getValue().size();
			}
		}
		
		for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
			
			if (entry.getValue().size()==max) {
				output.add(entry);
			}
		}
		
		return output;
	}
	
	//given method
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		
		final long startTime = System.nanoTime();
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double)estimatedTime/1000000000);
		System.out.println("Time : "+ seconds);
		System.out.println("Key of max anagrams:" + maxEntries.get(0).getKey());
		System.out.println("List of max anagrams : "+ maxEntries.get(0).getValue()); 
		System.out.println("Length of list of max anagrams:" + maxEntries.get(0).getValue().size());
	}
}