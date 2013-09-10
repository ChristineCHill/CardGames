import java.util.ArrayList;
import java.util.List;


public class PlayerList {
	private List<Player> players;
	
	public PlayerList(){
		players = new ArrayList<Player>();
	}
	
	public PlayerList(List<Player> list){
		players = list;
	}
	
	public void add(Player player){
		players.add(player);
	}
	
	public int size(){
		return players.size();
	}
	
	public Player get(int i){
		
		return players.get(i);
	}
	
	public void print(){
		System.out.print("[");
		for(int i = 0; i < (size() - 1); i++){
			System.out.print(players.get(i).getName() + ", ");
		}
		System.out.println(players.get(size() - 1).getName() + "]");
	}
}

