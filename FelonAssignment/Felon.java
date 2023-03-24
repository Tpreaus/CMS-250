/**
 * 
 * Felon Class declaration
 * 
 * CMS 250 Theodore Preaus & Philip Clarke
 * 
 */

import java.util.ArrayList;

public class Felon {
	
	
	// Declare Data Members
	private String name, id, dna;
	private char gender;
	private ArrayList<String> crimes;
	
	// Constructor
	public Felon(String n, String i) {
		this.name = n;
		this.id = i;
		
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	//--------------------------------
	
	public String getId() {
		return id;
	}
	//--------------------------------
	
	public String getDna() {
		return dna;
	}
	//--------------------------------

	public char getGender() {
		return gender;
	}
	//--------------------------------

	public ArrayList<String> getCrimes() {
		return crimes;
	}
	//--------------------------------
	
	public void setName(String x) {
		name = x;
	}
	//--------------------------------

	public void setId(String x) {
		id = x;
	}
	//--------------------------------

	public void setDna(String x) {
		dna = x;
	}
	//--------------------------------

	public void setGender(char x) {
		gender = x;
	}
	//--------------------------------

	public void setCrimes(ArrayList<String> x) {
		crimes = x;
	}
	//--------------------------------
	
	// Create a method to print a formatted felon object
	public void printFelon() {
		System.out.println("Name: " + name + " Id: " + id + " Gender: " + gender + " Crimes: " + crimes);
		}
	
}
