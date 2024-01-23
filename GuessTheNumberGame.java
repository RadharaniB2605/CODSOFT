import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number Game!");

        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (playAgain) {
            int lowerLimit = 1;
            int upperLimit = 100;
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("\nI've generated a number between " + lowerLimit + " and " + upperLimit + ". Can you guess it?");

            while (true) {
                System.out.print("Enter your guess: ");

                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Clear the input buffer
                    continue;
                }

                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber + " in " + attempts + " attempts.");
                    roundsWon++;
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == 3) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nGame Over. You won " + roundsWon + " round(s) with an average of " + (roundsWon > 0 ? totalAttempts / roundsWon : 0) + " attempts per round.");


        scanner.close();
    }
}
