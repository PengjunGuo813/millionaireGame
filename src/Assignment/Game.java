package Assignment;

import java.util.*;

public class Game {
	public int round; // current round number
	public int qn; // current question number
	public String[] bonus = new String[16]; // an array to store the bonus amount
	public Scanner input = new Scanner(System.in); // initialize Scanner as it will throw a "NoSuchElementException" if input is closed manually, initialize input here can avoid this problem and use it wherever we need it. 
	public ArrayList<Integer> qr =new ArrayList<Integer>();
	
	public Game() { // a void constructor method
		
	}
	
	public void Gaming() { // the method that used to run this program, overwrite to implement different difficulty mode
		
	}
	
	
	public void Question() { // ask user a question
				
	}
	
	public String Check(String answer) { // check if the user want to change the answer
		System.out.println("Please check your answer is: " + answer + ", if you don't want to change your answer, please enter y, otherwise, enter n or anything else"); // show player what to do to change or keep the answer
		String checking = input.next(); //get the player decision
		
		if (checking.equals("y")) { // if they don't change the answer, return the former one, otherwise, return a new one till the player doesn't want to change the answer
			System.out.println("You didn't change the anwer!");
		}else {
			System.out.println("Please enter your new answer:");
			answer = input.next();
			answer = Check(answer);
		}
		return answer;
	}
	
	public void WalkAway() { // say goodbye if the user want to leave the game before the round 3 over
		System.out.println("Congratulations! You have passed the round " + round + " and you can take " + bonus[qn-1] + " back!"); //qn-1 because qn automatically added after the Question method is called, however, the WalkAway method is called after that
		System.exit(0);
	}
}
