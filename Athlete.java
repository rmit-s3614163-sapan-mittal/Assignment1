
public abstract class Athlete extends Participant implements Comparable<Athlete>{
private int points;
private int time;

	public Athlete(String id, String name, int age, String state) {
		
		super(id, name, age, state);
	}
	//abstract method will be implemented in subclasses
	public abstract int compete();
	
	//getters and settors
	public void setTime(int time){
		this.time = time;
	}
	public int getTime(){
		return this.time;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	// impelementing  comparable  interface method to compare time of player
	public int compareTo(Athlete athlete) {
		int comparetime = ((Athlete)athlete).getTime();
		return this.getTime() - comparetime;
	}
	
	
}
