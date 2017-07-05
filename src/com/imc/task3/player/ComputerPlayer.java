package com.imc.task3.player;


import java.util.Random;

import com.imc.task3.core.HandSymbol;


/**
 * ComputerPlayer Class
 * Implements Player
 * 
 * Provides a random HandSymbol through getSymbol() method
 * 
 * 
 * @author  Ozgur Arslan
 * @version 1.0
 * @since   2016-01-24
 */
public class ComputerPlayer implements Player{
	Random random = new Random();

	@Override
	public HandSymbol getSymbol() {
		
		int choise = random.nextInt(3);
		if(choise == 0){
			return HandSymbol.PAPER;
		}else if(choise == 1){
			return HandSymbol.SCISSORS;
		}else{
			return HandSymbol.ROCK;
		}
	}

}
