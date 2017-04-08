import java.util.ArrayList;
import java.util.Random;

public class StartGame {
	private int selection;
	private ListsOfAthletes list;
	private ArrayList <Athlete> athleteList = new ArrayList<Athlete>();
	private String type;
	
	public StartGame(ListsOfAthletes list){
		this.setList(list);
	}
	public int getTotal(){
		int total = 0;
		while(total <= 4  || total >= 8){
			total = (int) (4 + (Math.random() * (8 - 4)));
		}
		return total;
	}
	public int getSelection() {
		return selection;
	}
	public void setSelection(int selection) {
		this.selection = selection;
		int normalAthletes = 0;
		int superAthletes = 0;
		System.out.println("No. athletes competing: " + this.getTotal());
			while(true){
				//randomly generated players and saviing them
				normalAthletes = (int)(0 + (Math.random() * (this.getTotal() - 0)));
				superAthletes = (int)(0 + (Math.random() * (this.getTotal() - 0)));
				if(normalAthletes + superAthletes == this.getTotal()){
					break;
				}
		}
			//game selection
		switch(this.getSelection()){
		case 1:
			System.out.println("You chose swimming");
			addToSwimList(normalAthletes, superAthletes);
			this.setType("SWIM");
			break;
		case 2:
			System.out.println("You chose Running");
			addToSprintList(normalAthletes, superAthletes);
			this.setType("RUN");
			break;
		case 3:
			System.out.println("You chose Cycling");
			addToCycleList(normalAthletes, superAthletes);
			this.setType("CYCLE");
			break;
		default:
			System.out.println("Please enter a choice between 1 and 3");
			break;
		}
	}
	public ListsOfAthletes getList() {
		return list;
	}
	public void setList(ListsOfAthletes list) {
		this.list = list;
	}
	//adding randomly generated superAthletes and swimmers
	public void addToSwimList(int normalAthletes, int superAthletes){
		Random r = new Random();
		for(int i = 0; i < normalAthletes; i++){
			Athlete a = this.getList().getSwimmers().get(r.nextInt(this.getList().getSwimmers().size()));
			this.athleteList.add(a);
		}
		for(int i = 0; i < superAthletes; i++){
			Athlete a = this.getList().getSuperAthletes().get(r.nextInt(this.getList().getSuperAthletes().size()));
			this.athleteList.add(a);
		}
		for(int i = 0; i < this.athleteList.size(); i++){
			System.out.println(this.athleteList.get(i).getId());
		}
	}//adding randomly generated superAthletes and sprinters
	public void addToSprintList(int normalAthletes, int superAthletes){
		Random r = new Random();
		for(int i = 0; i < normalAthletes; i++){
			Athlete a = this.getList().getSprinters().get(r.nextInt(this.getList().getSprinters().size()));
			this.athleteList.add(a);
		}
		for(int i = 0; i < superAthletes; i++){
			Athlete a = this.getList().getSuperAthletes().get(r.nextInt(this.getList().getSuperAthletes().size()));
			this.athleteList.add(a);
		}
		for(int i = 0; i < this.athleteList.size(); i++){
			System.out.println(this.athleteList.get(i).getId());
		}
	}
	//adding randomly generated superAthletes and Cyclist
	public void addToCycleList(int normalAthletes, int superAthletes){
		Random r = new Random();
		for(int i = 0; i < normalAthletes; i++){
			Athlete a = this.getList().getCyclists().get(r.nextInt(this.getList().getCyclists().size()));
			this.athleteList.add(a);
		}
		for(int i = 0; i < superAthletes; i++){
			Athlete a = this.getList().getSuperAthletes().get(r.nextInt(this.getList().getSuperAthletes().size()));
			this.athleteList.add(a);
		}
		for(int i = 0; i < this.athleteList.size(); i++){
			System.out.println(this.athleteList.get(i).getId());
		}
	}
	
	public ArrayList <Athlete> athletesParticipating(){
		return this.athleteList;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
