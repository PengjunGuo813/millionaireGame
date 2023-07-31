package Assignment;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lifelines {
    private boolean fiftyFiftyUsed;
    private boolean askAudienceUsed;
    private boolean phoneFriendUsed;
    private boolean isHardMode;
    private int rq;
    private int round;
    private int qn;
    
    EasyQuestions eq = new EasyQuestions(); // initialize easy question list
    HardQuestions hq = new HardQuestions(); // initialize hard question list

    enum LifelineType {
    	FIFTY_FIFTY,
        ASK_AUDIENCE,
        PHONE_FRIEND
    }
    
    public Lifelines(boolean isHardMode,int rq, int qn, int round, boolean isFiftyUsed, boolean isAudience, boolean isFriend) {
        fiftyFiftyUsed = isFiftyUsed;
    	askAudienceUsed = isAudience;
        phoneFriendUsed = isFriend;
        this.isHardMode = isHardMode;
        this.rq = rq;
        this.qn = qn;
        this.round = round;
    }
    
	public boolean isAvailable(LifelineType type, int roundNumber) {
		if (isHardMode && roundNumber == 1) {
            return false; // lifelines not available in round 1 in hard mode
        }
        switch (type) {
            case FIFTY_FIFTY:
                return !fiftyFiftyUsed;
            case ASK_AUDIENCE:
                return !askAudienceUsed;
            case PHONE_FRIEND:
                return !phoneFriendUsed;
            default:
                return false;
        }
    }
	
//	public String usage() {
//		if(isHardMode && qn == 1) {
//			return null; // If hard mode and 1st question. Exit.
//		} 
//		
//		//No more LifeLines:
//		if( 
//				(!isAvailable(LifelineType.FIFTY_FIFTY,qn)) &&
//				(!isAvailable(LifelineType.ASK_AUDIENCE,qn)) &&
//				(!isAvailable(LifelineType.PHONE_FRIEND,qn))
//		)
//		{
//			System.out.println("Sorry, you have run out of lifeline options! Enter your answer");
//		}
//		else {
//			
//			System.out.println("Do you want to use the lifelines? Y or N");
//			Scanner choice = new Scanner(System.in);
//			if (choice.next().equals("Y") ){
//				if (isAvailable(LifelineType.FIFTY_FIFTY,qn))
//					System.out.println("a. You can use the 50/50 option!");
//				if (isAvailable(LifelineType.ASK_AUDIENCE,qn))
//					System.out.println("b. You can use the ask the audience option!");
//				if (isAvailable(LifelineType.PHONE_FRIEND,qn))
//					System.out.println("c. You can use the phone a friend option!");
//				
//				
//				
//				Scanner input = new Scanner(System.in);
//				System.out.println("Give your choice: ");
//				String decision  = input.nextLine();
//				decision = decision.toLowerCase();
//				if (decision.equals("a") && isAvailable(LifelineType.FIFTY_FIFTY,qn) ){
//					return "useFiftyFifty";
//				}
//				else if (decision.equals("b") && isAvailable(LifelineType.ASK_AUDIENCE,qn)){
//					return "useAudienceHelp";
//				}
//				else if (decision.equals("c") && isAvailable(LifelineType.PHONE_FRIEND,qn)){
//					return "usePhoneFriend";
//				} else {
//					System.out.println("Option not available.");
//					return null;
//				}
//				
//				
//
//			  }else {
//				System.out.println("No problem! Enter your choice.");
//			}
//			
//		}
//		
//		
//		return null;
//	}
	
	public String usage() {
		if(isHardMode && round == 1) {
			return null; // If hard mode and 1st question. Exit.
		} 
		
        System.out.println("Do you want to use the lifelines? Y or N");
        Scanner choice = new Scanner(System.in);
        if (choice.next().equals("Y") ){
            if (isAvailable(LifelineType.FIFTY_FIFTY,round))
                System.out.println("a. You can use the 50/50 option!");
            if (isAvailable(LifelineType.ASK_AUDIENCE,round))
                System.out.println("b. You can use the ask the audience option!");
            if (isAvailable(LifelineType.PHONE_FRIEND,round))
                System.out.println("c. You can use the phone a friend option!");

            //No more LifeLines:
            if( 
                    (!isAvailable(LifelineType.FIFTY_FIFTY,round)) &&
                    (!isAvailable(LifelineType.ASK_AUDIENCE,round)) &&
                    (!isAvailable(LifelineType.PHONE_FRIEND,round))
            )
                System.out.println("Sorry, you have run out of lifeline options!");

            Scanner input = new Scanner(System.in);
            System.out.println("Give your choice: ");
            String decision  = input.nextLine();
            decision = decision.toLowerCase();
            if (decision.equals("a") && isAvailable(LifelineType.FIFTY_FIFTY,round)){
                return "useFiftyFifty";
            }
            else if (decision.equals("b") && isAvailable(LifelineType.ASK_AUDIENCE,round)){
                return "useAudienceHelp";
            }
            else if (decision.equals("c") && isAvailable(LifelineType.PHONE_FRIEND,round)){
                return "usePhoneFriend";
            }
            else {
                System.out.println("You can't use an unavaliable choice");
                //usage();
                return "invalid";
            }

          }else {
            System.out.println("No problem! Enter your choice.");
        }

        return null;
    }

	
	public int[] useFiftyFifty(int rq) { // Return the 2 choices
		int[] fiftyFiftyChoices = new int[2];
		if(!fiftyFiftyUsed) {
			Random random = new Random();
			String correctAnswer = null;
			if(isHardMode) {
				correctAnswer = hq.answer[rq]; //This is the correct answer values are A, B, C, D
			} else {
				// initialize question list
	    		correctAnswer = eq.answer[rq]; //This is the correct answer values are A, B, C, D
			}
			//get index of the correct answer;
    		String[] letters = {"A", "B", "C", "D"};
    		int indexOfAns = -1;
    		for (int i = 0; i < letters.length; i++) {
    		    if (letters[i] == correctAnswer) {
    		    	indexOfAns = i;
    		        break;
    		    }
    		}
    		int randomIndex;
    		do {
    		    randomIndex = random.nextInt(4); // generate a random index from 0-3
    		} while (randomIndex == indexOfAns); // repeat until the random index is different from the specific index
    		fiftyFiftyChoices[0] = indexOfAns;
    		fiftyFiftyChoices[1] = randomIndex;
    		Arrays.sort(fiftyFiftyChoices);
		}
		return fiftyFiftyChoices;
	}

    
	public int[] useAskAudience(int rq) { //returns the array of most answer from the audience
		if(!askAudienceUsed) { //this lifeline is not yet used.
			if(isHardMode) {
				System.out.println("Question is: \n" + hq.question[rq]);
				System.out.println("Audience, Please select your answer: ");
    			String[] letters = {"A", "B", "C", "D"};
	    		for (int i = 0; i < letters.length; i++) {
	    			System.out.println(hq.choices[rq][i]);
	    		}
			} else {
				System.out.println("Question is: \n" + eq.question[rq]);
				System.out.println("Audience, Please select your answer: ");
    			String[] letters = {"A", "B", "C", "D"};
	    		for (int i = 0; i < letters.length; i++) {
	    			System.out.println(eq.choices[rq][i]);
	    		}
			}
			Random rand = new Random();
            int[] audienceAnswers = new int[4];
            // generate a random response for each answer option
            for (int i = 0; i < 4; i++) {
            	audienceAnswers[i] = rand.nextInt(51) + 25; // generate a number between 25 and 75
            }
            
            // calculate the percentage of audience members who chose each answer
            int totalResponses = 0;
            int[] answerPercentages = new int[4];
            for (int i = 0; i < 4; i++) {
                totalResponses += audienceAnswers[i];
            }
            for (int i = 0; i < 4; i++) {
                answerPercentages[i] = (int) Math.round(audienceAnswers[i] / (double) totalResponses * 100);
            }
            
            return answerPercentages;
		}
		return null;
	}
    
    public int usePhoneFriend(int rq) { //returns the index of the answer
    	if(!phoneFriendUsed) {
    		if(isHardMode) {
    			System.out.println("Friend, Please select your answer: ");
    			String[] letters = {"A", "B", "C", "D"};
	    		for (int i = 0; i < letters.length; i++) {
	    			System.out.println(hq.choices[rq][i]);
	    		}
    		}else {
    			System.out.println("Friend, Please select your answer: ");
    			String[] letters = {"A", "B", "C", "D"};
	    		for (int i = 0; i < letters.length; i++) {
	    			System.out.println(eq.choices[rq][i]);
	    		}
    		}
    		// Create a random number generator. Lets say this is the friend choose.
            Random input = new Random();
            return input.nextInt(4);
    	}
    	return 0;
    }
}