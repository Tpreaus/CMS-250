/**
 * 
 * Read and store data from a database
 * 
 * CMS 250
 * 
 * Theodore Preaus & Philip Clarke
 */

// Import all tools needed to read files and to use array list
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FelonDriver {
	
	// Declared Required Methods
	
	// Find a matching DNA and return the felon
	public static void findByDNA(String x, ArrayList<Felon> y) {
		
		int i = 0;
		boolean found = false;
		// Linear Search Using While
		while(i < y.size() && found == false) { 
			if(y.get(i).getDna().equals(x)) {
				System.out.println("A match has been found: ");
				found = true;
				
				y.get(i).printFelon();
				
			}
			else {
				i++;
			}
		}
		if (found == false) {
		System.out.println("No Match has been found");
		}
		System.out.print("\n\n");
	}
	
	// Generate a line up of Felons based on Gender and Crime
	public static void generateLineup(String x, char y, ArrayList<Felon> z) {
		
		// Print The Starting Statement
		System.out.println("Lineup of " + x + " suspects");
		for (int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println();
		// Go through the list checking for matches
		// For loop because you must check the whole list 
		for (int k = 0; k < z.size(); k++) {
			if (z.get(k).getGender() == y) {
				for (int j = 0; j < z.get(k).getCrimes().size(); j++) {
					if (z.get(k).getCrimes().get(j).equals(x)) {
						z.get(k).printFelon();
					}
				}
			}
		}
		for (int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("\n\n");
	}
	
	// Print out every Felon
	
	public static void printDatabase(ArrayList<Felon> x) {
		// Print First statement + line
		System.out.println("Felons in the Database");
		for (int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println();
		// Go through the array list and print every felon
		for (int i = 0; i < x.size(); i++) {
			x.get(i).printFelon();
		}
		for (int i = 0; i < 25; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("\n\n");
	}
	
	
	// Create the main class
	
	public static void main(String[] args) {
		
		
		// Initiate the ArrayList Felons
		ArrayList<Felon> felons = new ArrayList<Felon>();
		
		// Read file and create Felons 
		try {
		Scanner fileReader = new Scanner(new File("felons.txt"));
	
		while (fileReader.hasNextLine()) {
			
			int numFelon = Integer.parseInt(fileReader.nextLine());
			
			
			for (int i = 0; i < numFelon; i++)  {
				ArrayList<String> crime = new ArrayList<String>();
				
				String line = fileReader.nextLine();
				
				String[] words = line.split(" ");
				
				// Create a felon object 
				felons.add(new Felon(words[0], words[1]));
				// Set the DNA
				felons.get(i).setDna(words[3]);
				// Set the char for Gender
				felons.get(i).setGender(words[2].charAt(0));
				
				// Go through the rest of the list adding to the crimes
				for (int k = 4; k < words.length; k++) {
					crime.add(words[k]);
				}
				// Set crimes to the felon
				felons.get(i).setCrimes(crime);
			}
			
			// Read the number of commands 
			int numCom = Integer.parseInt(fileReader.nextLine());
			
			// Iterate through Commands
			
			for (int i = 0; i < numCom; i++) {
				String line = fileReader.nextLine();
				
				String[] words = line.split(" ");
				
				if (words[0].equals("P")) {
					printDatabase(felons);
				}
			
				else if (words[0].equals("F")) {
					findByDNA(words[1], felons);
				}
				
				else if (words[0].equals("L")) {
					generateLineup(words[1], words[2].charAt(0), felons);
				}
				else {
					System.out.println("illegal command");
				}
			}
		}
		// Close the Scanner
		fileReader.close();
		// Error catch system
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}	
	}
}
