import java.util.Scanner;

public class Menu {
	public int getSelection(){
		int input;
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		return input;
	}
	public void printMenu(){
		System.out.println("Ozlympic Game");
		System.out.println("===================================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the Game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		System.out.println("\nEnter an option: ");
	}
	public void printGameSelection(){
		System.out.println("Select Game");
		System.out.println("===================================");
		System.out.println("1. Swimming");
		System.out.println("2. Running");
		System.out.println("3. Cycling");
	}
}
