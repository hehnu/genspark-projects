import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void anotherRound() {

        Scanner input = new Scanner(System.in);
        System.out.println("Save Hangman again? (Y or N)");
        String answer = String.valueOf(input.next());
        if (answer.equals("Y") || answer.equals("N")) {
            new Game();

        } else {
            System.out.print("Alright Bye!");
            return;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Howdy, Welcome to Helicopter Hangman! Help! Don't let Hangman fly away before guessing the secret word! ");
        File usa2 = new File("/Users/niagriffin/Desktop/genspark-projects/Hangman/src/usa2.txt");
        Scanner wordScanner = new Scanner(usa2);
        Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        while (wordScanner.hasNextLine()) {
            words.add(wordScanner.nextLine());
        }
        String hidden = words.get((int) (Math.random() * words.size()));
        char[] wordArray = hidden.toCharArray();

        char[] answers = new char[wordArray.length];
        for (int i = 0; i < wordArray.length; i++) {
            answers[i] = '?';
        }
        boolean done = false;
        int tries = 8;
        while (done == false) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String letter = input.next();
            //check for valid input
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Input not recognized. Please try again");
                letter = input.next();
            }
            //checks if letter is inside of word
            boolean match = false;
            for (int i = 0; i < wordArray.length; i++) {
                if ((letter.charAt(0)) == wordArray[i]) {
                    answers[i] = wordArray[i];
                    match = true;
                }
            }
            if (!match) {
                tries--;
                System.out.println("You guessed incorrectly. Try again.");
            }

            //done = true;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == '?') {
                    System.out.println(" _");
                    done = false;

                } else {
                    System.out.println(" " + answers[i]);
                }
            }
            System.out.println("\n" + "You have " + tries + " tries remaining..");
            drawHangman(tries);
            //check if game ends
            if (done) {
                System.out.println("Congrats!! You helped Hangman from being stranded!");
            }
        }
        if (tries <= 0) {
            System.out.println("You're lost, but it doesn't mean that you're stuck..");
            anotherRound();
            done = true;
        }


        System.out.println("The secret word is: " + hidden);

    }
    public static void drawHangman(int t) {
        if (t == 8) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
        }else if (t == 7) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
        } else if (t == 6) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
        } else if (t == 5) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
            System.out.println(".................");
        } else if (t == 4) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬☻ ");
            System.out.println(".................");
            System.out.println(".................");
        } else if (t == 3) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬☻/ ");
            System.out.println(".................");
            System.out.println(".................");
        } else if (t == 2) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬☻/ ");
            System.out.println("    ╬═╬/ ");
            System.out.println(".................");

        } else if(t==1) {
            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬☻/ ");
            System.out.println("    ╬═╬/▌ ");
            System.out.println("..................");
        }else{


            System.out.println("  ▬▬▬.◙.▬▬▬");
            System.out.println("  ═▂▄▄▓▄▄▂");
            System.out.println("◢◤ █▀▀████▄▄▄▄◢◤");
            System.out.println("█▄ █ █▄ ███▀▀▀▀▀▀▀╬");
            System.out.println("  ◥█████◤");
            System.out.println("  ══╩══╩══ ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬   ");
            System.out.println("    ╬═╬☻/ ");
            System.out.println("    ╬═╬/▌ ");
            System.out.println("    ╬═╬/| ");
        }

    }
}


//|    (∩◔ ͜つ◔)⊃━☆ﾟ.*"