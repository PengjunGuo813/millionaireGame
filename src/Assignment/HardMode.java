package Assignment;

import java.util.Random;

public class HardMode extends Game{
	private boolean usedFiftyLife = false;
	private boolean usedAskedAud = false;
	private boolean usedPhoneFriend = false;
	public HardMode() {// initialize easy mode characters
		round = 1; //round record
		qn = 1; // current question number record
		bonus[0] = "0"; // can't initialize the array in one command like bonus = {0, ...} as there will be a problem with this; bonus[0] = 0 is to make sure bonus[qn] can show the correct bonus with the corresponding question number
		bonus[1] = "$100";
		bonus[2] = "$200";
		bonus[3] = "$300";
		bonus[4] = "$500";
		bonus[5] = "$1,000";
		bonus[6] = "$2,000";
		bonus[7] = "$4,000";
		bonus[8] = "$8,000";
		bonus[9] = "$16,000";
		bonus[10] = "$32,000";
		bonus[11] = "$64,000";
		bonus[12] = "$125,000";
		bonus[13] = "$250,000";
		bonus[14] = "$500,000";
		bonus[15] = "$1,000,000";
	}
	
	public void Question() {
		HardQuestions hq = new HardQuestions(); // initialize question list
		Random random = new Random();
        int rq = random.nextInt(15); //create a random number to choose question from question bank
        while (qr.contains(rq)){ // check if the number has been used
        	rq = random.nextInt(15);
        }
        qr.add(rq);
        
        
		System.out.println("The " + qn + " question is: " + hq.question[rq]); // show the question
		System.out.println("The " + qn + " choices are: " + hq.choices[rq][0] + ",  " + hq.choices[rq][1] + ",  " + hq.choices[rq][2] + ",  " + hq.choices[rq][3]); //show the choices
        Lifelines life = new Lifelines(true,rq,qn,round, usedFiftyLife, usedAskedAud, usedPhoneFriend); // initialize lifelines
        String chosenLife = life.usage();
        if(chosenLife == "invalid") {
			chosenLife = life.usage();
		}
        if(chosenLife == "useFiftyFifty") {
			int[]lifeChoices = life.useFiftyFifty(rq);
			System.out.println("The " + qn + " question is:" + hq.question[rq]); // show the question
			System.out.println("The " + qn + " choices are: ");
			for (int c = 0; c < lifeChoices.length; c++) {
				int choiceIndex = lifeChoices[c];
				System.out.println(hq.choices[rq][choiceIndex]);
			}
			//Make the 50/50 Lifeline to true, means already used
			usedFiftyLife = true;
		}else if(chosenLife == "useAudienceHelp") {
			int[] audiencePick = life.useAskAudience(rq);
			System.out.println("A: " + audiencePick[0] + "% | B: " + audiencePick[1] + "% | C: " + audiencePick[2] + "% | D: " + audiencePick[3] + "%");
			System.out.println("Now pick your choice.");
			//Make the Audience Lifeline to true, means already used
			usedAskedAud = true;
			
		}else if (chosenLife == "usePhoneFriend") {
			int friendsPick = life.usePhoneFriend(rq);
			System.out.println("Your Friends answer is :" + hq.choices[rq][friendsPick] +" . Enter yours now."); // show the answer your friend pick
			//Make the Ask a Friend Lifeline to true, means already used
			usedPhoneFriend = true;
		}
        
        String answer = input.next(); // get the answer
		
        
		String playerAnswer =answer; // Get player's answer input
		try {
			errorHandler.validateAnswer(playerAnswer);
		    // Process player's answer if it is valid
		} catch (IllegalArgumentException e) {
		    // Handle the error message
		    System.err.println(e.getMessage());
		}
		
		String checkedAnswer = Check(answer); // call the function to check if the user want to change the answer
		if (checkedAnswer.equals(hq.answer[rq])) { // judge the answer, if it's right, keep going and if it's wrong, say goodbye and stop the program
			System.out.println("Correct! You have earned: " + bonus[qn]);
		}else {
			System.out.println("Sorry, the answer is wrong, and you can't get any money this time. See you next time!");
			System.exit(0);
		}
	}
	
	public void Gaming() { //  run the program
		System.out.println("Welcome to round " + round + "! Let's start the question " + qn);// tell player the round number and the question number
		for (int i = 0; i < 5; i++) {// for hard mode, there are 5 questions for each round
			Question();
			qn += 1;
		}
		if (round == 3) {// when the round 3 is over and all answers are correct, show the result and how much the player can get 
			System.out.println("Congratulations! You have passed the final round! Now you can leave with all bonus! Thank you for playing our game! Welcome play it again!");
		}
		else {// check the player whether wants to leave after current round(round 1 and 2) is over, if the player wants to leave, call the WalkAway function, otherwise, the round plus 1 and keep going
			System.out.println("Congratulations! You have passed the round " + round + "! Now you can choose to leave with your current bonus, or keep playing the game!"
					+ "Please enter 'w' to leave and any other button to keep playing!");
			if (input.next().equals("w")) {
				WalkAway();
			}
			else {
				round += 1;
				Gaming();
			}
		}
	}
	
}
