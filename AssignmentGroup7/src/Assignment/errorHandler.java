package Assignment;

public class errorHandler {
	
	public static void validateAnswer(String answer) throws IllegalArgumentException {
        if (!answer.equalsIgnoreCase("A") && !answer.equalsIgnoreCase("B")
            && !answer.equalsIgnoreCase("C") && !answer.equalsIgnoreCase("D")) {
            throw new IllegalArgumentException("Invalid answer. Please choose one of the options: A, B, C, or D.");
        }
    }
	
}

