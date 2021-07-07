package aa224fb_assign2;

import java.io.File;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;

public class WordCount1Main {

	public static void main(String[] args) {

		HashSet<Word> hashSet = new HashSet<>();
		TreeSet<Word> treeSet = new TreeSet<>();
		
		//Path as an argument
		String path = args[0];
		
		try {
			Scanner scan = new Scanner(new File(path));
			
			//Scan words from file and add to hashSet and treeSet
			while(scan.hasNext()){
				
				Word word = new Word(scan.next());
				hashSet.add(word);
				treeSet.add(word);				
			}
			scan.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();	
		}
		
		//Iterate over treeSet to get word in alphabetical order
		Iterator<Word> wordIterator = treeSet.iterator();
		System.out.println("Words in treeSet:");
		while(wordIterator.hasNext()) {
			System.out.println(wordIterator.next());
		}
		
		//Size of hashSet and treeSet
		System.out.println(hashSet.size());
		System.out.println(treeSet.size());
	}

}
