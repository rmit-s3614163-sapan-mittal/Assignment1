import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ozlympic {
	public static final int MAX_ATHLETES = 8;
	
	public static void main(String[] args) {
		//Database of Athletes
		ArrayList<Cyclist> cyclistList= new ArrayList<Cyclist>();
		Cyclist cyclist1 = new Cyclist("C1", "John", 23, "VIC");
		cyclistList.add(cyclist1);
		
		Cyclist cyclist2 = new Cyclist("C2", "Rahul", 22, "Mel");
		cyclistList.add(cyclist2);
		
		Cyclist cyclist3 = new Cyclist("C3", "Ross", 23, "VIC");
		cyclistList.add(cyclist3);
		
		Cyclist cyclist4 = new Cyclist("C4", " Taloor", 24, "Geelong");
		cyclistList.add(cyclist4);
		
		Cyclist cyclist5 = new Cyclist("C5", " Mihir", 22, "VIC");
		cyclistList.add(cyclist5);
		
		Cyclist cyclist6 = new Cyclist("C6", "Ricky", 21, "sydney");
		cyclistList.add(cyclist6);
		
		Cyclist cyclist7 = new Cyclist("C7", "Ronny", 28, "VIC");
		cyclistList.add(cyclist7);
		
		Cyclist cyclist8 = new Cyclist("C8", "Gazman", 25, "Adelaide");
		cyclistList.add(cyclist8);
		
		ArrayList<Sprinter> sprinterList= new ArrayList<Sprinter>();
		Sprinter sprinter1 = new Sprinter("S1", "Guz", 23, "VIC");
		sprinterList.add(sprinter1);
		
		Sprinter sprinter2 = new Sprinter("S2", "Bitchel", 21, "mel");
		sprinterList.add(sprinter2);
		
		Sprinter sprinter3 = new Sprinter("S3", "Michell", 25, "Adl");
		sprinterList.add(sprinter3);
		
		Sprinter sprinter4 = new Sprinter("S4", "Shawn", 28, "Sydney");
		sprinterList.add(sprinter4);
		
		Sprinter sprinter5 = new Sprinter("S5", "Michael", 26, "VIC");
		sprinterList.add(sprinter5);
		
		Sprinter sprinter6 = new Sprinter("S6", "Rohan", 22, "Canberra");
		sprinterList.add(sprinter6);
		
		Sprinter sprinter7 = new Sprinter("S7", "Rahul", 21, "Perth");
		sprinterList.add(sprinter7);
		
		Sprinter sprinter8 = new Sprinter("S8", "james", 22, "VIC");
		sprinterList.add(sprinter8);
		
		ArrayList<Swimmer> swimList= new ArrayList<Swimmer>();
		swimList.add(new Swimmer("Sw1", "Ram", 22, "VIC"));
		swimList.add(new Swimmer("Sw2", "Sham", 24, "Mel"));
		swimList.add(new Swimmer("Sw3", " jamy", 21, "Ade"));
		swimList.add(new Swimmer("Sw4", "  Sam", 29, "Can"));
		swimList.add(new Swimmer("Sw5", "Roam", 22, "Syd"));
		swimList.add(new Swimmer("Sw6", "Under", 22, "Per"));
		swimList.add(new Swimmer("Sw7", " Rocky", 22, "Per"));
		swimList.add(new Swimmer("Sw8", "  Jonty", 22, "VIC"));
		
		ArrayList<SuperAthlete> superAlist = new ArrayList<SuperAthlete>();
		SuperAthlete sa1 = new SuperAthlete("Sa1", "Beny", 22, "VIC");
		superAlist.add(sa1);
		superAlist.add(new SuperAthlete("Sa2", " Adam", 22, "VIC"));
		superAlist.add(new SuperAthlete("Sa3", "Gilch", 27, "mel"));
		superAlist.add(new SuperAthlete("Sa4", "Clark", 22, "syd"));
		superAlist.add(new SuperAthlete("Sa5", "Dhoni", 29, "gln"));
		superAlist.add(new SuperAthlete("Sa6", "Sachin", 32, "Can"));
		superAlist.add(new SuperAthlete("Sa7", "Mongia", 21, "Adl"));
		superAlist.add(new SuperAthlete("Sa8", "Dinesh", 29, "per"));
		boolean exit = false;
		boolean predicted = true;
		// athletes in particular game
		ArrayList <Athlete> athletesInGame = new ArrayList<Athlete>();
		// no. of games played
		ArrayList <Game> listOfGames = new ArrayList<Game>();
		int iterator = 0;
		int  predictedPlayer = 0;
		while(!exit){
			Menu mainMenu = new Menu();
			mainMenu.printMenu();
			// selecting option from the menu
			int selection = mainMenu.getSelection();
			ListsOfAthletes lists = new ListsOfAthletes(cyclistList, swimList, sprinterList, superAlist);
			StartGame game = new StartGame(lists);
			Game sport = new Swimming(new Official("OS", "Official", 35, "QLD"), null, "SampleID");
			
			//select the game
			switch(selection){
				case 1:
					predicted = false;
					mainMenu.printGameSelection();
					int selectGame;
					Scanner scan = new Scanner(System.in);
					selectGame = scan.nextInt();
					game.setSelection(selectGame);
					athletesInGame = game.athletesParticipating();
					String id = Integer.toString(iterator);
					switch(game.getType()){
						case "SWIM":
							id = "S" + id;
							sport = new Swimming(new Official("OS", "Official", 35, "QLD"), athletesInGame, id);
							for(int i = 0; i < athletesInGame.size(); i++){
								if((athletesInGame.get(i)) instanceof SuperAthlete ){
									((SuperAthlete) athletesInGame.get(i)).setGame("SWIM");
								}
							}
							break;
						case "RUN":
							id = "R" + id;
							sport = new Running(new Official("OR", "Official", 35, "QLD"), athletesInGame, id);
							for(int i = 0; i < athletesInGame.size(); i++){
								if((athletesInGame.get(i)) instanceof SuperAthlete ){
									((SuperAthlete) athletesInGame.get(i)).setGame("RUN");
								}
							}
							break;
						case "CYCLE":
							id = "C" + id;
							sport = new Cycling(new Official("OR", "Official", 35, "QLD"), athletesInGame, id);
							for(int i = 0; i < athletesInGame.size(); i++){
								if((athletesInGame.get(i)) instanceof SuperAthlete ){
									((SuperAthlete) athletesInGame.get(i)).setGame("CYCLE");
								}
							}
							break;
					      }
					
					break;
					//Predict The player
				case 2:
					if(athletesInGame.size() == 0){
						System.out.println("Select a game before trying to predict its outcome");
					}
					else{
						System.out.println("\tId\tAge\tState");
						for(int i = 0; i < athletesInGame.size(); i++){
							System.out.println((i+1)+"\t"+athletesInGame.get(i).getId()+"\t"+athletesInGame.get(i).getAge()+"\t"+athletesInGame.get(i).getState());
						}
						System.out.print("Please enter an integer corresponding to the player of your choice: ");
						 predictedPlayer = mainMenu.getSelection();
						while(predictedPlayer < 1 || predictedPlayer > athletesInGame.size()){
							System.out.print("Please try again: ");
							predictedPlayer = mainMenu.getSelection();
						}
						System.out.println("You selected the player with id "+athletesInGame.get(predictedPlayer - 1).getId());
						predicted = true;
					}
					break;
				case 3:
					if(!predicted){
						System.out.println("You must first predict the winner before starting the game");
					}
					else{
						 Athlete winner = new Swimmer("sample", "sample", 1, "sample");
						
					
						Athlete SecondWinner = new Swimmer("sample", "sample", 1, "sample");
						Athlete ThirdWinner = new Swimmer("sample", "sample", 1, "sample");
						for(int i = 0; i < athletesInGame.size(); i++){
							athletesInGame.get(i).setTime(athletesInGame.get(i).compete());
						}
						//Sorting based on the time 
					   Collections.sort(athletesInGame);
						  for(int i = 0; i < athletesInGame.size(); i++){
							System.out.println("Player "+athletesInGame.get(i).getId()+" finished in "+athletesInGame.get(i).getTime()+"seconds");
						}
						System.out.println(athletesInGame.get(0).getId() + " is the fastest!");
						System.out.println(athletesInGame.get(1).getId() + " is the secondfastest!");
						System.out.println(athletesInGame.get(2).getId() + " is the thirdfastest!");
						// check predicted player wins 
						if(athletesInGame.get(predictedPlayer - 1).getId() ==athletesInGame.get(0).getId()){
							System.out.println("Congratulations , Your player have won");
							
						    } 
						else  System.out.println("sorry better luck next time");
					
				     	//storing Time of top3 athletes
					    int min = athletesInGame.get(0).getTime();
					 
					    int min2 = athletesInGame.get(1).getTime();
					    int min3 = athletesInGame.get(2).getTime();
						for(int i = 0; i < athletesInGame.size(); i++){
							if(athletesInGame.get(i).getTime() == min){
						
								winner = athletesInGame.get(i);
								//allot points to the athlete
								winner.setPoints(athletesInGame.get(i).getPoints() + 5);
							}
							if(athletesInGame.get(i).getTime() == min2){
							
								SecondWinner = athletesInGame.get(i);
								athletesInGame.get(i).setPoints(athletesInGame.get(i).getPoints() + 3);
							}
							if(athletesInGame.get(i).getTime() == min3){
								
								ThirdWinner = athletesInGame.get(i);
								athletesInGame.get(i).setPoints(athletesInGame.get(i).getPoints() + 2);
							}
						}
						//check top one is Cyclist
						if(winner instanceof Cyclist){
							for(int i = 0; i < lists.getCyclists().size(); i++){
								if(winner.getId().equals(lists.getCyclists().get(i).getId())){
									lists.getCyclists().get(i).setTime(winner.getTime());
									lists.getCyclists().get(i).setPoints(winner.getPoints());
								}
							}
						}
						//check second one is Cyclist
						if(SecondWinner instanceof Cyclist){
							for(int i = 0; i < lists.getCyclists().size(); i++){
								if(SecondWinner.getId().equals(lists.getCyclists().get(i).getId())){
									lists.getCyclists().get(i).setTime(SecondWinner.getTime());
									lists.getCyclists().get(i).setPoints(SecondWinner.getPoints());
								}
							}
						}
						//check third one is Cyclist
						if(ThirdWinner instanceof Cyclist){
							for(int i = 0; i < lists.getCyclists().size(); i++){
								if(ThirdWinner.getId().equals(lists.getCyclists().get(i).getId())){
									lists.getCyclists().get(i).setTime(ThirdWinner.getTime());
									lists.getCyclists().get(i).setPoints(ThirdWinner.getPoints());
								}
							}
						}
						//check top1 is Sprinter
						else if(winner instanceof Sprinter){
							for(int i = 0; i < lists.getSprinters().size(); i++){
								if(winner.getId().equals(lists.getSprinters().get(i).getId())){
									lists.getSprinters().get(i).setTime(winner.getTime());
									lists.getSprinters().get(i).setPoints(winner.getPoints());
								}
							}
						}
						//check middleone is Sprinter
						else if(SecondWinner instanceof Sprinter){
							for(int i = 0; i < lists.getSprinters().size(); i++){
								if(SecondWinner.getId().equals(lists.getSprinters().get(i).getId())){
									lists.getSprinters().get(i).setTime(SecondWinner.getTime());
									lists.getSprinters().get(i).setPoints(SecondWinner.getPoints());
								}
							}
						}
						
						//check thirdone is Sprinter
						else if(ThirdWinner instanceof Sprinter){
							for(int i = 0; i < lists.getSprinters().size(); i++){
								if(ThirdWinner.getId().equals(lists.getSprinters().get(i).getId())){
									lists.getSprinters().get(i).setTime(ThirdWinner.getTime());
									lists.getSprinters().get(i).setPoints(ThirdWinner.getPoints());
								}
							}
						}
						//check firstone is Sprinter
						else if(winner instanceof Swimmer){
							for(int i = 0; i < lists.getSwimmers().size(); i++){
								if(winner.getId().equals(lists.getSwimmers().get(i).getId())){
									lists.getSwimmers().get(i).setTime(winner.getTime());
									lists.getSwimmers().get(i).setPoints(winner.getPoints());
								}
							}
						}
						//check secondone is Sprinter
						else if(SecondWinner instanceof Swimmer){
							for(int i = 0; i < lists.getSwimmers().size(); i++){
								if(SecondWinner.getId().equals(lists.getSwimmers().get(i).getId())){
									lists.getSwimmers().get(i).setTime(SecondWinner.getTime());
									lists.getSwimmers().get(i).setPoints(SecondWinner.getPoints());
								}
							}
						}
						//check thirdone is Swimmer
						else if(ThirdWinner instanceof Swimmer){
							for(int i = 0; i < lists.getSwimmers().size(); i++){
								if(ThirdWinner.getId().equals(lists.getSwimmers().get(i).getId())){
									lists.getSwimmers().get(i).setTime(ThirdWinner.getTime());
									lists.getSwimmers().get(i).setPoints(ThirdWinner.getPoints());
								}
							}
						}
						//check winner for SuperAthlete
						else if(winner instanceof SuperAthlete){
							for(int i = 0; i < lists.getSuperAthletes().size(); i++){
								if(winner.getId().equals(lists.getSuperAthletes().get(i).getId())){
									lists.getSuperAthletes().get(i).setTime(winner.getTime());
									lists.getSuperAthletes().get(i).setPoints(winner.getPoints());
									 }}}
						else if(SecondWinner instanceof SuperAthlete){
							for(int i = 0; i < lists.getSuperAthletes().size(); i++){
							  if(SecondWinner.getId().equals(lists.getSuperAthletes().get(i).getId())){
									lists.getSuperAthletes().get(i).setTime(SecondWinner.getTime());
									lists.getSuperAthletes().get(i).setPoints(SecondWinner.getPoints());
							        }}}
						else if(ThirdWinner instanceof SuperAthlete){
							for(int i = 0; i < lists.getSuperAthletes().size(); i++){	
								if(ThirdWinner.getId().equals(lists.getSuperAthletes().get(i).getId())){
									lists.getSuperAthletes().get(i).setTime(ThirdWinner.getTime());
									lists.getSuperAthletes().get(i).setPoints(ThirdWinner.getPoints());
							        }}
						    }
						//setting Id of games playes
						sport.setId(Integer.toString(listOfGames.size()));
						//setting topPlayer to be displayed in the result
						sport.setWinner(winner);
						listOfGames.add(sport);
					}
					break;
		
		
				case 4:
					//result of all games
					System.out.println("id\tWinner");
					for(int i = 0; i < listOfGames.size(); i++){
						System.out.println(listOfGames.get(i).getId()+"\t"+listOfGames.get(i).getWinner().getId() );
					}
					break;
				case 5://total points of players
					System.out.println("id\tname\tstate\tpoints");
					for(int i = 0; i < lists.getCyclists().size(); i++){
						System.out.println(lists.getCyclists().get(i).getId()+"\t"+lists.getCyclists().get(i).getName()
								+"\t"+lists.getCyclists().get(i).getState()+"\t"+lists.getCyclists().get(i).getPoints());
					}
					for(int i = 0; i < lists.getSprinters().size(); i++){
						System.out.println(lists.getSprinters().get(i).getId()+"\t"+lists.getSprinters().get(i).getName()
								+"\t"+lists.getSprinters().get(i).getState()+"\t"+lists.getSprinters().get(i).getPoints());
					}
					for(int i = 0; i < lists.getSwimmers().size(); i++){
						System.out.println(lists.getSwimmers().get(i).getId()+"\t"+lists.getSwimmers().get(i).getName()
								+"\t"+lists.getSwimmers().get(i).getState()+"\t"+lists.getSwimmers().get(i).getPoints());
					}
					for(int i = 0; i < lists.getSuperAthletes().size(); i++){
						System.out.println(lists.getSuperAthletes().get(i).getId()+"\t"+lists.getSuperAthletes().get(i).getName()
								+"\t"+lists.getSuperAthletes().get(i).getState()+"\t"+lists.getSuperAthletes().get(i).getPoints());
					}
					break;
				case 6:
					//out of the program
					exit = true;
					break;
				default:
					System.out.println("Please Select an integer between 1 - 6");
					break;
			}
		}
		
	}
}
