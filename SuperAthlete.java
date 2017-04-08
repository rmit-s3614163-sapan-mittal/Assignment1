
public class SuperAthlete extends Athlete{
	private String game;
	
	public SuperAthlete(String id, String name, int age, String state) {
		super(id, name, age, state);
	}

	//executing method of superclass
	public int compete() {
		int result = 0;
		switch(this.getGame()){
		// executing compete method based on game
			case "CYCLE":
				result = 500 + (int)(Math.random() * ((800 - 500) + 1));
			break;
			case "SWIM":
				result = 100 + (int)(Math.random() * ((200 - 100) + 1));
				break;
			case "RUN":
				result = 10 + (int)(Math.random() * ((20 - 10) + 1));
				break;
		}
		return result;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
}
