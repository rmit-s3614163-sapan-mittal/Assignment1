
public class Cyclist extends Athlete{
	public Cyclist(String id, String name, int age, String state) {
		super(id, name, age, state);
	}

	@Override
	public int compete() {
		return 500 + (int)(Math.random() * ((800 - 500) + 1));
	}
}
