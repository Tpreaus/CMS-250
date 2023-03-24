/**
 * 
 *  Decrypt a message using linked Lists 
 *  
 *  CMS 250
 *  
 *  Theo Preaus & Philip Clarke
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decryptor {
	
	// Creates a linked list and alternates front and back 
	public static LList decryptWord(String x) {
		LList myList = new LList(); 

		for (int i = 0; i < x.length(); i++) {
			// Create the new Node with a next of null
				NodePointer letter = new NodePointer(x.charAt(i), null);
				if ((i % 2) == 0) {
					myList.addAtEnd(letter);
				} else
					myList.addAtHead(letter);
		}
		return myList;
	}
	
	public static void main(String[] args) {
		// Read the text file
		try {
		Scanner fileReader = new Scanner(new File("texts.txt"));
		
		// Read the next Line while one exists
		while (fileReader.hasNextLine()) {
			// Split the line as a string
			String line = fileReader.nextLine();
			// Split the string into an array of words by the "*"
			String[] words = line.split("\\*");
			
			// Go through the array of words 
			for(int i = 0; i < words.length; i++) {
				// Create a linked list of the decrypted word
				LList secWor = decryptWord(words[i]);
				// Go through and print the word
				NodePointer temp = secWor.getHead();
				while ( temp != null) {
					temp.printData();
					temp = temp.getNext();
				}
				// Print a space in between the words where the "*" would be
				System.out.print(" ");
			}
			System.out.println();
		}
		// Catch if the does not exist and throws an error
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
}
