import java.util.ArrayList;
import java.util.List;


public class Hand {
	private List<Integer> cards;
	//private static int value;
	
	public static void main(String arg[]){
	}
	
	public Hand(List<Integer> hand){
		cards = hand;
	}
	
	public Hand(){
		cards = new ArrayList<Integer>();
	}
	
	public void add(int num){
		cards.add(num);
	}
	
	public int size(){
		return cards.size();
	}
	
	//Create a recursive algorithm(recursive backtracking algorithm) to deal with the Aces
	public int value(){
		int value = 0;
		for(int i = 0; i < size() ; i++){
			if(cards.get(i) % 13 == 0){
				value += 11;
			} else if(cards.get(i) % 13 >= 9){
				value += 10;
			} else {
				value += (cards.get(i) % 13 + 1);
			}
		}	
		return value;
	}
	
	
	//I'm going to work on this so that this will calculate Aces accordingly. aka, will value as 11 unless it busts. 
	//Make a separate class to see if a value busts? If initially busts go through cards again and see how many Aces, then start devalueing the Aces until the hand is out of Aces or no longer busts
	public int bjValue(){
		return 0;
	}
	
	
	//Currently just prints out the hand could return a string with the entire hand as well
	public void print(){
		for(int i =0; i < size(); i++){
			System.out.println((i+1) + ". " + card(cards.get(i)) + " (" +(value()) +")"); //The (#) is used to check any errors that occur
		}
	}
	
	//Translates numbers into their card equivalent
	public String card(int card){
		//System.out.println(card);
		String x = "";
		if((card%13 >= 10) || (card%13 == 0)){
			if(card%13 == 0){
				x = "Ace";
			}
			else if(card%13 == 10){
				x = "Jack";
			}
			else if(card%13 == 11){
				x = "Queen";
			}
			else if (card%13 == 12){
				x = "King";
			}
		} else {
			x = "" + (card%13 + 1) + "";
		}
		x += " of ";
		if(card/14 == 0){
			x += "Ducks";
		} else if(card/13 == 1){
			x += "Llamas";
		} else if(card/13 == 2){
			x += "Geese";
		} else if(card/13 ==3){
			x += "Penguins";
		} else {
			x = "non-existant card";
		}
	return x;
	}
}