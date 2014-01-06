package Poker;
import java.util.Random;

import javax.swing.JOptionPane;


public class PokerGame {
	//variable initialization
	
	//string array used in displaying images
	public static String[] shand = new String[10];
	
	//how much has been bet by players
	static int playerbet = 0;
	static int aibet = 0;
	
	//rank of players
	static String playerRank = "";
	static String aiRank = "";
	//size of the deck
	public static int deckSize = 52;
	//outcome of the game
	public static String outcome = "";
	
	//subrank in case of a draw in ranks
	public static int playersubrank;
	public static int aisubrank;
	
	//value of hands secondary high card in case of a draw
	public static int secondaryHcard = 0;
	public static int aisecondaryHcard = 0;
	
	//starting money of ai and player in bank
	public static int playerbank = 1000;
	public static int aibank = 1000;
	
	//ai hand
	public static int[] aihand = new int[5];

	public static void main(String[] args) {
	
			
			int[] cards = new int[deckSize];   
			int[] suits = new int[deckSize];   
			int[] values = new int[deckSize];       
			//player hand
			int[] hand = new int[5];
			//ai hand

			for(int i=0; i < deckSize; i++){
				cards[i]=i;   
				}   
			
			//populating hands with cards
			populate_hand(hand);
			populate_hand(aihand);
			check_hand(aihand,hand);
		
		
		//calling sorting algorithm
		sort(hand);
		sort(aihand);
		
		playerRank = rank(hand,false);
		aiRank =  rank(aihand,true);
		
		System.out.println(aiRank);
		System.out.println(playerRank);
		
		for(int i = 0;i <= 4;i++){
			shand[i] = String.format("images/%d.png",hand[i]);
			System.out.println(shand[i]);
		}
		for(int i = 5;i <= 9;i++){
			shand[i] = String.format("images/%d.png",aihand[i - 5]);
			System.out.println(shand[i]);
		}
			
		for(int n = 0;n < 5;n++){	
			
		
			suits[n] = hand[n] / 13;     
			values[n] = hand[n] % 13;     
		
			switch(values[n])         
			{         
			case 0:  System.out.print("Two of ");   
			break;         
			case 1:  System.out.print("Three of "); 
			break;        
			case 2:  System.out.print("Four of "); 
			break;         
			case 3:  System.out.print("Five of ");  
			break;         
			case 4:  System.out.print("Six of ");  
			break;         
			case 5:  System.out.print("Seven of "); 
			break;         
			case 6:  System.out.print("Eight of ");
			break;        
			case 7:  System.out.print("Nine of "); 
			break;        
			case 8:  System.out.print("Ten of ");   
			break;       
			case 9:  System.out.print("Jack of "); 
			break;        
			case 10: System.out.print("Queen of "); 
			break; 
			case 11: System.out.print("King of ");  
			break;     
			case 12: System.out.print("Ace of ");  
			break;       
			}  
			switch(suits[n])       { 
			case 0:  System.out.print("Hearts\n");   
			break;         
			case 1:  System.out.print("Clubs\n"); 
			break;         
			case 2:  System.out.print("Spades\n");   
			break;         
			case 3:  System.out.print("Diamonds\n");   
			break;      
				}   
			}
	Gui window = new Gui();
	window.setVisible(true);
		
	}
//sorting algorithm
public static void sort(int hand[]){
		boolean swapped = true;
		int tmp;
		//int l = 0;
				while(swapped){
					swapped = false;
					
					for(int i=1;i <= 4;i++){
						
						if((hand[i-1] % 13) > (hand[i] % 13)) {
							tmp = hand[i-1];
							hand[i-1] = hand[i];
							hand[i] = tmp;
							swapped = true;
						
						}
						
					}
				}
	}
//ranking algorithm
public static String rank(int hand[],boolean computer){
	int usedindex = 0;
	int usedindex_2 = 0;
	boolean pair = false; 
	boolean same = false;
	boolean royal = false;
	int subranking = 0;
	
	//straight
	for(int i = 0;i <= 3;i++){
			if( (hand[i] % 13) == (hand[i+1] % 13 + 1) && same == true){
				same = true;
			}
			else same = false;
	}
		
	if(same){
		subranking = hand[0];
		subrank(computer,subranking);
		return "Straight";
	}
		
	//straight-flush
	if((hand[0] / 13) == (hand[1] / 13) && (hand[0] / 13) == (hand[2] / 13) && (hand[0] / 13) == (hand[3] / 13) && (hand[0] / 13) == (hand[4] / 13)){
			for(int i = 0;i <= 3;i++){
				if((hand[i] % 13) == ((hand[i + 1] % 13) + 1)){
					same = true;
				}
					else same = false;
			}
			if(same == true){
				subranking = hand[0];
				subrank(computer,subranking);
				return "Straight Flush";
			}
	}
	
	//Full House
	for(int i = 2;i <= 4;i++){
		if((hand[i] % 13) == (hand[i-1] % 13) && (hand[i] % 13) == (hand[i-2] % 13)){
			if(i == 2){
				if((hand[i + 1] % 13) == (hand[i + 2] % 13)){
					subranking = (hand[0] % 13) + (hand[3] % 13);
					subrank(computer,subranking);
					return "Full House";
				}
			}
			else if(i == 4){
				if((hand[i - 3] % 13) == (hand[i - 4 ] % 13)){
					subranking = (hand[0] % 13) + (hand[4] % 13);
					subrank(computer,subranking);
					return "Full House";
				}
			}
		}
	}
	
	//royal-flush
	if((hand[0] / 13) == (hand[1] / 13) && (hand[0] / 13) == (hand[2] / 13) && (hand[0] / 13) == (hand[3] / 13) && (hand[0] / 13) == (hand[4] / 13)){
		for(int i = 0;i <= 4;i++){
			if((hand[i] % 13) >= 10 && (hand[i] % 13) <= 12){
			royal = true;
			}
			else {
				royal = false;
			}
		}
		if(royal){
			subrank(computer,subranking);
			return "Royal Flush";
		}
	}

	
	//Flush
	if((hand[0] / 13) == (hand[1] / 13) && (hand[0] / 13) == (hand[2] / 13) && (hand[0] / 13) == (hand[3] / 13) && (hand[0] / 13) == (hand[4] / 13)){
		subranking = hand[0] % 13;
		subrank(computer,subranking);
		return "Flush";
		
	}

	//four of a kind
	for(int i = 3;i <= 4;i++){
		if((hand[i] % 13) == (hand[i-1] % 13) && (hand[i] % 13) == (hand[i-2] % 13) && (hand[i] % 13) == (hand[i-3] % 13)){
			subranking = hand[i] % 13;
			subrank(computer,subranking);
			return "Four of a Kind";
			
		}
	}
	
	
	//three of a kind
	for(int i = 2;i <= 4;i++){
		if((hand[i] % 13) == (hand[i-1] % 13) && (hand[i] % 13) == (hand[i-2] % 13)){
			subranking = hand[i] % 13;
			subrank(computer,subranking);
			return "Three of a Kind";
			
		}
	}

	//pair and two pairs
	for(int i = 1;i <= 4;i++){	

		if((hand[i] % 13) == (hand[i-1] % 13) && usedindex != i){
			if(pair){
				subranking = (hand[usedindex] % 13) + (hand[i] % 13);
				subrank(computer,subranking);
				return "Two Pairs";
			}
			else {
		
			usedindex = i;
			pair = true;
			}	
		}
	}
	if(pair){
		subranking = hand[usedindex] % 13;
		subrank(computer,subranking);
		return "Pair";
	}
	subranking = hand[0];
	subrank(computer,subranking);
	if(computer){
		aisecondaryHcard = hand[1];
	}
	else {
		secondaryHcard = hand[1];
	}
	return "High Card";
}
//function which populates hands with cards
public static void populate_hand(int hand[],int otherhand[]){
	boolean conflict = false;
	int uniqueNumbersRequired = 5;
	int aRandomNumber;
	int index = 0;
	int duplicateindex;
	Random r = new Random();
	
	while(index < uniqueNumbersRequired)
	{
		aRandomNumber = r.nextInt(PokerGame.deckSize);
		hand[index] = aRandomNumber;
		
		duplicateindex = 0;
		
		
		while(hand[duplicateindex] != aRandomNumber){
			for(int i=0;i < 5;i++){
				if(otherhand[duplicateindex] != aRandomNumber){
					conflict = true;
				}
			}
		if(conflict)
			duplicateindex++;
		}
		if(index == duplicateindex)index++;
		
	}
	
}
public static void populate_hand(int hand[]){
	int uniqueNumbersRequired = 5;
	int aRandomNumber;
	int index = 0;
	int duplicateindex;
	Random r = new Random();
	
	while(index < uniqueNumbersRequired)
	{
		aRandomNumber = r.nextInt(PokerGame.deckSize);
		hand[index] = aRandomNumber;
		
		duplicateindex = 0;
		
		while(hand[duplicateindex] != aRandomNumber){
			duplicateindex++;
		}
	
		if(index == duplicateindex)index++;
		
	}
	
}
//check both hands to make sure there is no duplication of cards
public static void check_hand(int hand[],int otherhand[]){
	boolean change = true;
	Random r = new Random();
	int rnumber = r.nextInt(PokerGame.deckSize);
	while(change){
		for(int i = 0;i <= 4;i++){
			for(int n = 0;n<= 4;n++){
				rnumber = r.nextInt(PokerGame.deckSize);
				if(hand[i] == otherhand[n]){
				hand[i] = rnumber;
				change = true;
				}
				else change = false;
			}	
		}
	}
}
//compare hands against each other
public static String compare_hands(String playerank,String airank) {
	String[] ranks = {"High Card","Pair","Two Pairs","Three of a Kind","Straight","Flush","Royal Flush","Full House","Four of a Kind","Straight Flush"};
	int player = 0;
	int ai = 0;
	for(int i =0;i <= 9;i++){
		if(ranks[i] == playerank){
			player = i;
		}
	}
	for(int i =0;i <= 9;i++){
		if(ranks[i] == airank){
			ai = i;
		}
	}
	if(player == ai){
		//draw, "Not today"
		if(aisubrank > playersubrank) {
			JOptionPane.showMessageDialog(null, "Computer Wins!");
		}
		if(playersubrank > aisubrank){
			JOptionPane.showMessageDialog(null, "Player Wins!");
		}
		if(airank == "High Card" && playerank == "High Card"){
			if(secondaryHcard > aisecondaryHcard){
				JOptionPane.showMessageDialog(null, "Player Wins!");
			}
			else if(secondaryHcard < aisecondaryHcard){
				JOptionPane.showMessageDialog(null, "Computer Wins!");
			}
		}
	}
	else if(player > ai){
		//player win
		JOptionPane.showMessageDialog(null, "Player Wins!");
		return "Player wins!";
		
	}
	else if(player < ai){
		//ai win
		JOptionPane.showMessageDialog(null, "Computer Wins!");
		return "Computer wins!";
	}
	
	return "meh";
}
//set value of subrank
public static void subrank(boolean computer,int subranking) {
	if(computer){
		aisubrank = subranking;
	}
	else if(!computer){
		playersubrank = subranking;
	}
	
}
		
}