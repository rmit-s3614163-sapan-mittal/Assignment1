
public class Sprinter extends Athlete{

	public Sprinter(String id, String name, int age, String state) {
		super(id, name, age, state);
		}

//implementation of compete method
	public int compete() {
		return 10 + (int)(Math.random() * ((20 - 10) + 1));
	}

}
