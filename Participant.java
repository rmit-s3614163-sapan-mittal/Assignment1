
public abstract class Participant {
	private String id;
	private String name;
	private int age;
	private String state;
	//constructor for participant taking personal information as a parameter
	public Participant(String id, String name, int age, String state){
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setState(state);
	}
	//getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
