package com.imc.task3.player;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import com.imc.task3.core.HandSymbol;



/**
 * HumanPlayer Class
 * Implements Player
 * 
 * Provides methods for interaction with the real person
 * 
 * 
 * @author  Ozgur Arslan
 * @version 1.0
 * @since   2016-01-24
 */
public class HumanPlayer implements Player{
	private Scanner scanner = new Scanner(System.in);
	Hashtable<String,HandSymbol> inputMap = new Hashtable<String,HandSymbol>();
	
	public HumanPlayer(){
		
		//populate hash map with possible user inputs
		inputMap.put("P", HandSymbol.PAPER);
		inputMap.put("PAPER", HandSymbol.PAPER);
		inputMap.put("1", HandSymbol.PAPER);
		inputMap.put("S", HandSymbol.SCISSORS);
		inputMap.put("SCISSORS", HandSymbol.SCISSORS);
		inputMap.put("2", HandSymbol.SCISSORS);
		inputMap.put("R", HandSymbol.ROCK);
		inputMap.put("ROCK", HandSymbol.ROCK);
		inputMap.put("3", HandSymbol.ROCK);
		inputMap.put("ROCK", HandSymbol.ROCK);
		inputMap.put("3", HandSymbol.ROCK);
		
	}
	
	@Override
	public HandSymbol getSymbol() {
		//instructions are prompt
		printInstructions();
        String input = scanner.nextLine();
        
        //input string is converted into HandSymbol
        String symbol = convertInput(input);
        if(symbol != null){
        	return HandSymbol.PAPER;
        }
        
        printInputError(input);
        //Recurse function till we get proper input
        return getSymbol();
	}
	

	/*
	 * Ask user if wants to play another round
	 * E or e (exit) means the user wants to exit the game
	 * Any other input means user wants to play one more round
	 */
	public boolean askForNextGame(){
		System.out.print("Press E to end game, press any other key to play one more round!");
		String input =scanner.nextLine().toUpperCase();
		if(input.length()>0 && input.equals("E"))
			return false;
        return true;
	}
	
	/*
	 * Instructions prompt
	 */
	private void printInstructions(){
		System.out.println("Please make your choice! Paper , Scissors or Rock");
		System.out.println("Paper: PAPER, paper, p, P, 1");
		System.out.println("Scissors: SCISSORS, scissors, s, S, 2");
		System.out.println("Rock: ROCK, rock, r, R, 3");
	}
	
	/*
	 * Input is not a valid input.
	 * User is acknowledged here
	 * 
	 */
	private void printInputError(String input){
		System.out.println("Sorry, we could not understand the command entered: "+input);
	}
	
	
	/*
	 * User input is converted to a HandSymbol
	 * 
	 */
	private String convertInput(String input){
		input = input.trim();
		input = input.toUpperCase();
		return input;
		
	}
	
	
}
