package Assignment;

import java.util.Scanner;

public class Rules {
	
	
	public Rules() {
		
		System.out.println("General Rules:");
		System.out.println("1. Contestants are presented with a series of multiple-choice questions of increasing difficulty, each with four possible answers.");
		System.out.println("2. The contestant must choose the correct answer from the four options");
		System.out.println("3. You are given three lifelines! But each could only use for ONCE");
		System.out.println("4. Game ends once you incorrectly answers a question");
		System.out.println("Good luck and have fun playing!");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter: \n M to go to Main Menu \n W for Warmup\n");
		String choices = scanner.nextLine();
		choices = choices.toUpperCase();
		switch(choices) {
			case "M":
				new StartGame().main(null);
				break;
			case "W":
				System.out.println("\n What is the name of the code entered at the ATM to receive money? \n A.Pin, B.Neil, C.Jeff, D.Spike");
				System.out.print("Enter: \n M to go to Main Menu \n");
				String back = scanner.nextLine();
				choices = back.toUpperCase();
				switch(choices) {
					case "M":
						new StartGame().main(null);
						break;
				}
			
		}
		
    }
}




