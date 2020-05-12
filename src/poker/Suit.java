package poker;
import java.util.*;
import java.io.*;

public class Suit {
	
	int a = -1;
	int b = -1;
	public Suit() {
	}
	public Suit( int hand1num, int hand2num){	
		a = hand1num;
		b = hand2num;
		
	}		
	public String getWinner(){
		String winner = "";
		
		if (a < b ) 
		{
			winner = "Player 1 is the winner";
		} else if (a > b)
		{
			winner = "Player 2 is the winner";
		} else 
		{		
			winner = "Both have same type of hands. So no winner.";	
		}
		return winner;
		
	}

}



































