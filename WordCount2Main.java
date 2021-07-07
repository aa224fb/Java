package aa224fb_assign2;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) {
		
		HashWordSet hashWordSet = new HashWordSet();
		TreeWordSet treeWordSet = new TreeWordSet();
		
		//Path as an argument
		String path = args[0];
				
		try {
			Scanner scan = new Scanner(new File(path));
					
			//Scan words from file and add to hashSet and treeSet
			while(scan.hasNext()){
						
				Word word = new Word(scan.next());
					hashWordSet.add(word);
					treeWordSet.add(word);				
			}
			scan.close();
		 } catch(Exception e) {
			e.printStackTrace();	
		}
		
		//Iterate over treeSet to get word in alphabetical order
		Iterator<Word> TreeIterator = treeWordSet.iterator();
				System.out.println("Words in treeWordSet:");
				while(TreeIterator.hasNext()) {
					System.out.println(TreeIterator.next());
				}
				
		//Size of hashSet and treeSet
		System.out.println(hashWordSet.size());
		System.out.println(treeWordSet.size());

	}

}
