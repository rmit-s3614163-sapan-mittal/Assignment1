import java.util.ArrayList;

public abstract class Game {
	//winner of game
	private Athlete winner;
    //id of game
	private String id;
	public Game(Official official, ArrayList<Athlete> athletes, String id){
		this.setId(id);
	}
	//method to getthe winner
	public Athlete getWinner() {
		return winner;
	}
	
	//setting winner
	public void setWinner(Athlete winner) {
		this.winner = winner;
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
