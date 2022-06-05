import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String hello = String.valueOf(name.next());
        System.out.println("Well " + hello + ", I am thinking of a number between 1 and 20.");
               // "Are you ready?"); y or n
        GTN.game(hello);
    }
}
