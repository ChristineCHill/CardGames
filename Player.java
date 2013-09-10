public class Player {
	private Hand tempHand;
	private String name = "";
	
	public Player(String n){
		name =n;
		tempHand = new Hand();
	}
	
	public Player(){
		name = "Minion";
		tempHand =new Hand();
	}
	
	public void giveCard(int card){
		tempHand.add(card);
	}
	
	public String getName(){
		return name;
	}
	
	public void print(){
		System.out.println(name);
		tempHand.print();
	}
}

