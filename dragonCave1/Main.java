//import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main( String [] args) {
        Scanner input = new Scanner(System.in);
        int userOpt = 0;
        while (userOpt != 1 && userOpt!=2) {


        System.out.println("You are in a land full of dragons. In front of you, \n" +
                "you see two caves. In one cave, the dragon is friendly \n" +
                "and will share his treasure with you. The other dragon \n " +
                "is greedy and hungry and will eat you on sight. \n"+
                "Which cave will you go into? (Select 1 or 2)");





            try{
                userOpt = input.nextInt();

                switch (userOpt) {
                    case 1: {
                        System.out.println("You approach the cave...\n"+
                                "It is dark and spooky..\n"+
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                                "Gobbles you down in one bite!");
                        break;

                    }

                    case 2: {
                        System.out.println("The cave gets darker as you walk and you can't see..\n"+
                                "Suddenly you hear a noise from deeper in the cave. \n" +
                                "It sounds like movement and it is getting further away as you walk toward the sound..\n" +
                                "The movement sounds like running and then you hear a faint Scrreeech! \n " +
                                "Then something sounds like it is approaching from behind you...\n" +
                                "You turn around fast! \n"+
                                "The Sccreeecch is louder..\n"+
                                "Something is shining bright gold and in the reflection of the light of the shining object,\n" +
                                "you can see a tiny shriveled looking face with a wide grin and sharp teeth!\n" +
                                "..it is a like a Goblin!");
                        break;
                    }



                }
            }catch(Exception e){

                System.out.println("You turned back around from where you entered. Good choice..");
                break;
            }
        }
    }
}









