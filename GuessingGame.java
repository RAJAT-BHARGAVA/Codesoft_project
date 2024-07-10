import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GuessingGame {
    public static void main(String[] args) {
        int score = 0;
        int rounds = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            rounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 6;

            System.out.println("\nRound " + rounds + "!");
            System.out.println("I'm thinking of a number between 1 and 100.");

            while (attempts < maxAttempts) {
                attempts++;
                int userGuess = getUserGuess(scanner);

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You found the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Game over! The number was " + numberToGuess + ".");
                System.out.println("Your score for this round is " + (maxAttempts - attempts) + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nYour final score is " + score + " across " + rounds + " rounds.");
    }

    private static int getUserGuess(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter your guess: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
