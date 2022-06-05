import java.util.Scanner;
import java.util.InputMismatchException;
public class GTN {
    public static void anotherRound(String hello) {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play again? (Y or N)");
        String answer = input.next();
        if (answer == "Y" || answer == "y") {
            game(hello);

        } else {
            System.out.print("Goodbye!");
            return;
        }
    }

    public static void game(String hello) {
        Scanner input = new Scanner(System.in);
        int number = 1 + (int) (20 * Math.random());
        int A = 6;
        int i, guess;

            for (i = 1; i < A; i++) {
                System.out.println("Take a guess: ");

                try {
                guess = input.nextInt();

                //If guess is correct
                if (number == guess) {
                    System.out.println("Good job, " + hello +
                            "! \n"
                            + "You guessed my number in " + i + " guesses!");
                    anotherRound(hello);
                    break;

                } else if (number > guess && i != A - 1) {
                    System.out.println(hello + ", your guess is too high. Try again.");
                } else if (number < guess && i != A - 1) {
                    System.out.println(hello + ", your guess is too low. Try again.");
                }

            }catch (Exception e) {

                    System.out.println("Whaa?");
                    break;
                }
            if (i == A) {
                System.out.println("Dang, you're out of guesses! \n" +
                        "My secret number is: " + number + "!");
                anotherRound(hello);
            }

        }
    }
}