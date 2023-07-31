package Assignment;

import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("=== Who Wants to be a Millionaire ===");
        System.out.println("1. Start Game");
        System.out.println("2. View Rules");
        System.out.println("3. Exit Game");
        System.out.print("Enter your choice: ");
//        try {
        	choice = scanner.nextInt();
        	switch (choice) {
        	case 1:
        		System.out.println("Starting game...");
                // Call another class to select option to start the game.
                new GameOption();
                break;
            case 2:
                System.out.println("=== Game Rules ===");
                System.out.println("Here are the rules of the game:");
             // Call another class to display rules.
                new Rules();
                break;
            case 3:
                System.out.println("Exiting game...");
                break;
            default:
                System.out.println("Invalid choice. Enter 1-3");
                break;
        	}
        	
//        }  catch (Exception e) {
//            System.out.println("Invalid input. Please enter an integer.");
//        }
//        
        
    }

}
