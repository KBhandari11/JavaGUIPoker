package poker;

import java.util.*;
import java.io.*;

public class Card
{
	int rank;
	String suite;

	public Card()
	{
	}

	public Card(int r, String s)
	{
		rank=r;
		suite=s;
	}

	public boolean isHigher(Card other)
	{
		boolean ret=true;
		if (isHigher(this.suite, other.suite))
			ret=true;
		else if (this.suite.equals(other.suite))
		{
			if (this.rank>=other.rank)
				ret=true;
			else
				ret=false;
		}
	return ret;
	}

	public static boolean isHigher(String s1, String s2)
	{
		boolean ret=true;
		switch (s1)
		{
		case "hearts":
			ret=true;
		case "spades":
			if (s2.equals("hearts"))
				ret=false;
			else if (s2.equals("diamonds"))
				ret=true;
			else if (s2.equals("clubs"))
				ret=true;
		case "diamonds":
			if (s2.equals("hearts"))
				ret=false;
			else if (s2.equals("spades"))
				ret=false;
			else if (s2.equals("clubs"))
				ret=true;
		case "clubs":
			ret=false;
		}
	return ret;
	}

	public void Print()
	{
		System.out.println("Rank: "+this.rank+" Suite: "+this.suite);
	}

	public static String[][] Read()
	{
		String[] suits = {"hearts","diamonds","clubs","spades"};
		String[] values= {"2","3","4","5","6","7","8","9","10","11","12","13","14"};
		String[][] hand = new String[5][2];
		Random rand = new Random();
		boolean x = false ; 
		for(int i = 0; i<5; i++ ) {
			do {
				x = false ; 
				int suit = rand.nextInt(4);
				int value = rand.nextInt(13);
				hand[i][0]= values[value];
				hand[i][1]= suits[suit];
				for(int j = 0; j<i; j++) {
					if((hand[j][0]==hand[i][0]) && (hand[j][1]==hand[i][1])) {
						x = true;
						break;
					}
				}
			}while(x);
		}
		
	return hand ;
	}

	public static void main(String []args)
	{
		/*
		String[][] hand = Read();
		Card []cards=new Card[5];
		for(int i = 0; i<5; i++ ) {
			cards[i] =new Card(Integer.parseInt(hand[i][0]), hand[i][1]);
			cards[i].Print();
		}
	

		if (card[].isHigher(card2))
			System.out.println("card1 > card2");
		else
			System.out.println("card2 > card1");
			*/
	}
}
