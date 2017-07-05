package com.imc.task3.core;

import java.util.Scanner;

import com.imc.task3.player.ComputerPlayer;
import com.imc.task3.player.HumanPlayer;
import com.imc.task3.player.Player;


/**
 * Paper Scissors Rock Game Engine Class
 * Creates one instance of UserPlayer and one instance of ComputerPlayer
 * 
 * Has two entry points: startGame(), startRound()
 * 
 * startGame() method will call startRound() internally
 * And after the execution of startRound() function, will ask the user
 * for another round
 * 
 * startRound() method will initialize a single round. After its execution
 * user will not be asked for another round. 
 * 
 * 
 * @author  Ozgur Arslan
 * @version 1.0
 * @since   2016-01-24
 */
public class GameEngine {

    Scanner scanner = new Scanner(System.in);
	int playerComputerWinCount, playerUserWinCount, drawCount;
	ComputerPlayer playerComputer = new ComputerPlayer();
    HumanPlayer playerUser = new HumanPlayer();
    
    /*
     * Game entry point for multiple rounds
     * After each round, user is asked if he/she wants to play again.
     */
    public void startGame(){
    	startRound();
    	while(playerUser.askForNextGame()){
			startRound();
		}
	    endGame();
    }
	
    /*
     * Game entry point for single round
     * Can be called for a single game
     */
	public void startRound(){
		//Each player decides their hands
		HandSymbol symbolA = playerComputer.getSymbol();
		HandSymbol symbolB = playerUser.getSymbol();
		
		//Display the hands
		System.out.println("Computer's hand: " + symbolA.toString()+ ", your hand: "+ symbolB.toString() );
		
		//Get the result
        int gameResult = HandSymbol.compare(symbolA, symbolB);
        
        //Prompt and record the result
        promptAndRecordResult(gameResult);
        
	}
	
	
	/*
	 *  End game to print total results
	 * This function is called when the user does not want to play any other rounds
	 * This function is usually called right before the application exits
	 */
	public void endGame(){
		System.out.println();
		
		//print a suitable message depending on the overall result
		 if(playerUserWinCount>playerComputerWinCount) {
	        	System.out.println("CONGRATULATIONS! You have one the game");
	     }else if(playerUserWinCount<playerComputerWinCount){
	        	System.out.println("Sorry! You have lost the game");
	     }else {
	        	System.out.println("Nobody won at the end!");
	     }

		//Print game details
		System.out.println();
		System.out.println("Out of the "+(playerComputerWinCount+playerUserWinCount+drawCount) +" games played so far");
		System.out.println("You have won "+playerUserWinCount+" times");
		System.out.println("Computer have won "+playerComputerWinCount+" times");
		System.out.println("It was a draw "+drawCount+" times");
       
		System.out.println("---Thank you for playing our game!---");
		
		
	}
	
	/*
	 * Game round result is prompt to the user
	 * Round result is recorded is global results
	 */
	private void promptAndRecordResult(int gameResult){
		
		if(gameResult==0){
			System.out.println("Its a draw");
			drawCount++;
		}else if(gameResult==1){
			System.out.println("Computer wins this round");
			playerComputerWinCount++;
		}else{
			System.out.println("You win this round");
			playerUserWinCount++;
		}
	}
	
	
	

}
