package Assignment;


import java.util.Scanner;

public class GameOption {
	
	public GameOption() {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        if (name != null && !name.isEmpty()) {
        	System.out.println("Hi " +name + ", Choose Level. Enter 'e' For Easy Level and 'h' for Hard Level");
        	String level = scanner.nextLine();
        	switch (level) {
				case "e":
					//Call Easy Mode Class
					System.out.print("EasyMode");
			        Game e = new EasyMode();
			        e.Gaming();
				break;
				case "h":
					//Call Hard Mode Class
					System.out.print("HardMode");
					Game h = new HardMode();
			        h.Gaming();
				break;
        	}
        	
        }
        
		
	}

	

}
