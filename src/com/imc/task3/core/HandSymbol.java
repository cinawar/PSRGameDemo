package com.imc.task3.core;

/**
 * HandSymbol Enum
 * 
 * Provides static Compare method
 * 
 * 
 * @author  ozgur arslan
 * @version 1.0
 * @since   2016-01-24
 */

public enum HandSymbol
{
	PAPER,
	SCISSORS,
	ROCK,;
	
	
	/**Compare symbols symbol1 and symbol2
	 * 
	 * @param HandSymbol symbol1
	 * @param HandSymbol symbol2
	 * 
	 * return 1 if symbol1 is dominant
	 * return 2 if symbol2 is dominant
	 * return 0 if symbols are identical
	 * return -1 if any parameter is null
	 */
	public static int compare(HandSymbol symbol1, HandSymbol symbol2){


		if(symbol1 == null || symbol2 == null){
			return  -1;
		}


		//Same symbols mean its a draw
		if(symbol1 == symbol2){
			return 0;
		}

		if(symbol1.equals(HandSymbol.PAPER)){
			if(symbol2.equals(HandSymbol.ROCK)){
				return 1;
			}
			else{  //Symbol2 = Scissors
					return 2;
			}
		}else if(symbol1.equals(HandSymbol.SCISSORS)){
			if(symbol2.equals(HandSymbol.PAPER)){
				return 1;
			}
			else{  //Symbol2 = Rock
				return 2;
			}
		}else{  //Symbol1 = Rock
			if(symbol2.equals(HandSymbol.SCISSORS)){
				return 1;
			}
			else{  //Symbol2 = Paper
				return 2;
			}
		}
	}

}
