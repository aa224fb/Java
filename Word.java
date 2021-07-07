package aa224fb_assign2;

public class Word implements Comparable<Word> {
	
	private String word;

	public Word(String str) {
		this.word = str;
	}
	
	public String toString() { 
		return word; 
	}
	
	/* Override Object methods */
	//Hash value for the word
	public int hashCode() { 
		int hc  = 0;
		
		for(int i = 0; i < word.length(); i++) { 
			char c  = word.charAt(i);
			hc += Character.getNumericValue(c);
		}
		return hc;
	}
	
	public boolean equals(Object other) { 
		if(other instanceof Word) {
			
			Word otherWord  = (Word) other ;
			return word.toLowerCase().equals(otherWord.word.toLowerCase());
		}
		
		return false;
	}
	
	/* Implement Comparable */
	public int compareTo(Word w) { 
		return word.compareToIgnoreCase(w.word);
	}
}