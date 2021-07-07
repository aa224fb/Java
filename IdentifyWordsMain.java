package aa224fb_assign2;

import java.io.*;
import java.util.Scanner;

public class IdentifyWordsMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try {
			//File from args
			String path = args[0];
			
			Scanner scan = new Scanner(new File(path));
			String fileContent = "";
			
			//Scan content to string
			while(scan.hasNext()) {
				fileContent += scan.nextLine();
			}
			
			
			String wordString = "";
			
			//Save content to charArray
			char[] chars = fileContent.toCharArray();
			
			//Add letters and whitespaces to string
			for(Character c : chars) {
				if(Character.isLetter(c) || Character.isWhitespace(c)){
					wordString += c;
				}
				
			}
			scan.close();
			
			//New file
			File file = new File(path);
			FileWriter writer = new FileWriter(file.getParentFile().getPath() + "/words.txt");
			
			//Write characters from string to new file
			writer.write(wordString);
			
			writer.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
