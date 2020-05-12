package poker;
import java.util.*;
import java.io.*;

public class Hand
{
	Card []cards=new Card[5];
	int []ranking=new int[5];

	public Hand()
	{
		String[][] hand = Card.Read();
		String[] arr = new String[5];
		for(int i = 0; i <5; i++) {
			arr[i] = hand[i][0]+" "+hand[i][1];
		}
		Quicksort quickSort = new Quicksort();
		arr = quickSort.quickSort(arr);
		String x;
		String[] split;
		for (int i=0; i<5; i++)
		{
			x = arr[i];
			split = x.split("\\s+");
			cards[i] =new Card(Integer.parseInt(split[0]), split[1]);
			ranking[i] = cards[i].rank;
		}
		 Arrays.sort(ranking); 
		
	}

	
	public boolean RoyalFlush()
	{
		boolean sameSuite=false;
		int x = 10;
		for (int i=0; i<4; i++)
		{
			if(ranking[i] == x) {
				sameSuite=true;
			}
			else {
				sameSuite=false;
				break;
			}
			x++;
		}
			
		if(sameSuite&&this.Flush()) {
			return true;
		}else{
			return false;
		}
	}
	public boolean StraightFlush()
	{
		
		if(this.Straight()&&this.Flush()) {
			return true;
		}else{
			return false;
		}
	}
	public boolean Straight()
	{
		boolean sameSuite=false;
		for (int i=0; i<4; i++)
		{
			if(ranking[i] == ranking[i+1]-1) {
				sameSuite=true;
			}
			else {
				sameSuite=false;
				break;
			}
		}
			
		if(sameSuite) {
			return true;
		}else{
			return false;
		}
	}

	public boolean Flush()
	{
		boolean sameSuite=true, it;
		for (int i=0; i<4; i++)
		{
			it=cards[i].suite.equals(cards[i+1].suite);
			sameSuite=sameSuite&&it;
		}
		if(sameSuite) {
			return true;
		}else{
			return false;
		}
	}
	public boolean FourKind()
	{
		int a;
		for (int i=0; i<2; i++)
		{
			a = countOccurrences(ranking, 5, ranking[i]);
			if(a == 4) {
				return true;
			}
		}
		return false;
	}
	public boolean FullHouse()
	{
		int[] a = new int[5];
		for (int i=0; i<4; i++)
		{
			a[i] = countOccurrences(ranking, 5, ranking[i]);
			
		}
		int three = countOccurrences(a, 5, 3);
		int two = countOccurrences(a, 5, 2);
		if((three == 3) && (two==2)) {
			return true;
		}
		return false;
	}
	public boolean ThreeKind()
	{
		int a;
		for (int i=0; i<5; i++)
		{
			a = countOccurrences(ranking, 5, ranking[i]);
			if(a == 3) {
				return true;
			}
		}
		return false;
	}
	public void PrintHand()
	{
		for (int i=0; i<5; i++)
		{
			this.cards[i].Print();
		}
	}
	public static int countOccurrences(int arr[], int n, int x) 
    { 
        int res = 0; 
        for (int i=0; i<n; i++) 
            if (x == arr[i]) 
              res++; 
        return res; 
    }
	
	public static void main(boolean []args)
	{
		for(int i = 0; i<=1000; i++) {
		Hand myHand=new Hand();
		myHand.PrintHand();
		if(!myHand.RoyalFlush()) {
			if(!myHand.StraightFlush()) {
				if(!myHand.Straight()) {
					if(!myHand.Flush()) {
						if(!myHand.FourKind()) {
							if(!myHand.FullHouse()) {
								if(!myHand.ThreeKind()) {
									myHand.PrintHand();
									System.out.println("You Lose");
								}
								else {
									System.out.println("ThreeKind");
								}
							}
							else {
								System.out.println("Full House");
							}
						}
						else {
							System.out.println("FourKind");
						}
					}
					else {
						System.out.println("Flush");
					}
				}
				else {
					System.out.println("Straight");
				}
			}
			else {
				System.out.println("Straight Flush");
			}
		}
		else {
			System.out.println("Royal Flush");
		}
		
		}
		
	}
}
