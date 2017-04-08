
public class Swimmer extends Athlete{

	public Swimmer(String id, String name, int age, String state) {
		super(id, name, age, state);
	}

	//execution of compete method
	public int compete() {
		return 100 + (int)(Math.random() * ((200 - 100) + 1));
	}

}
