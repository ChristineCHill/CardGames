import java.lang.reflect.Array;
import java.util.*;

//A series of methods that involves randomly generating, and then deciphering what card is produced
//This is currently enabled to print out the first five cards shuffled in the deck. The cards are not removed. In any actual games [0] would be removed and once arraylist.length == 0 a new deck is generated and shuffled
public class test {
	public static void main(String [] args){
		System.out.println("llamas are better than duckies.");
		ArrayList<Integer> deck = new ArrayList<Integer>();
		PlayerList players = new PlayerList();

		//
		Scanner console = new Scanner(System.in);
		System.out.println("\nHow many players are there?: ");
		int pNum = console.nextInt();
		Player temp2 = new Player("Will.i.am da Dealer");
		console.nextLine();
		players.add(temp2);
		for(int i = 0; i < pNum; i++){ 
			System.out.println("Type Player name: ");
			String name = console.nextLine();
			Player temp = new Player(name);
			players.add(temp);
		}
		players.print();
		
		//Requests cards to be dealt
		System.out.println("\nHow many cards do you want to draw?: ");
		int num = console.nextInt();
		if(num > 0){
			//System.out.println("Your cards are: \n");
			for(int i =0; i < num * players.size(); i++){
				if(!deck.contains(0)){
					refillDeck(deck);
				}
				players.get(i % players.size()).giveCard(i);
					//How to access 
					//players[j].giveCard(i);
			}
		}
		
		//prints the dealer's cards
		players.get(0).print();
		
		/*Player Mark = new Player(":Mark:");
		Player Will = new Player("Will.i.am");
		System.out.println("\nHow many cards do you want to draw?: ");
		int num = console.nextInt();
		if(num > 0){
			//System.out.println("Your cards are: \n");
			for(int i =0; i < num; i++){
				if(!deck.contains(0)){
					refillDeck(deck);
				}
				Mark.giveCard(deck.remove(0));
				//deck.remove(0);
				Will.giveCard(deck.remove(0));
				//deck.remove(0);
			}
		}
		Mark.print();
		Will.print();*/
	}
	
	//Analyzes and prints the card generated
	public static void Print(String card){		
		System.out.println("You have drawn the " + card);
	}
	
	public static void refillDeck(List<Integer> deck){
		for(int i = 0; i < 52; i++){
			deck.add(i);
		}
		Collections.shuffle(deck);
	}
	
	//Will randomize a single card for you
	public static int Ncard(){
		Random rand = new Random();
		int num = rand.nextInt(4*13);
		return num;
	}
	
	public static ArrayList<Integer> disperseCards(int handSize, int players, ArrayList<Integer> deck){
		for(int i = 0; i < handSize; i++){
			for(int j = 0; j < players; j++){
				if(!deck.contains(0)){
					refillDeck(deck);
				}
				//player at j receives next card in deck
				deck.remove(0);
			}
		}
		return deck;
	}
	
	/*//Translates numbers into their card equivalent
	public static String card(int card){
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
	}*/
}
