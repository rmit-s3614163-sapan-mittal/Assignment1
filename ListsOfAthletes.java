import java.util.ArrayList;

public class ListsOfAthletes {
	private ArrayList<Cyclist> cyclists;
	private ArrayList<Swimmer> swimmers;
	private ArrayList<Sprinter> sprinters;
	private ArrayList<SuperAthlete> superAthletes;
	//constructor for ListOfAthletes taking different athletes as parameters
	public ListsOfAthletes(ArrayList<Cyclist> cyclists, ArrayList<Swimmer> swimmers, ArrayList<Sprinter> sprinters, ArrayList<SuperAthlete> superAthletes){
		this.setCyclists(cyclists);
		this.setSwimmers(swimmers);
		this.setSprinters(sprinters);
		this.setSuperAthletes(superAthletes);
	}
//getters and setters of different athletes
	public ArrayList<Cyclist> getCyclists() {
		return cyclists;
	}

	public void setCyclists(ArrayList<Cyclist> cyclists) {
		this.cyclists = cyclists;
	}

	public ArrayList<Swimmer> getSwimmers() {
		return swimmers;
	}

	public void setSwimmers(ArrayList<Swimmer> swimmers) {
		this.swimmers = swimmers;
	}

	public ArrayList<Sprinter> getSprinters() {
		return sprinters;
	}

	public void setSprinters(ArrayList<Sprinter> sprinters) {
		this.sprinters = sprinters;
	}

	public ArrayList<SuperAthlete> getSuperAthletes() {
		return superAthletes;
	}

	public void setSuperAthletes(ArrayList<SuperAthlete> superAthletes) {
		this.superAthletes = superAthletes;
	}
}
