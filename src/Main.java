import java.util.Scanner;

public class Main {

    static Game g = new Game();

    public static void main(String[] args) {
        System.out.println("Welcome to Java Casio!\n" +
                "Do you have a knack for Black Jack?\n" +
                "We shall see..\n" +
                "Ready? Press enter to begin!");
        g.game();
    }
    public  int randNum  (){
        return  (int)(Math.random()*13)+1;
    }

    public String hitOrStay(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to 'hit' or 'stay'?");
        String input = scan.nextLine();
        switch (input){
            case "hit":
                return "hit";
            case "stay":
                return "stay";
            default:
                System.out.println("Please enter 'hit' or 'stay'");
                return hitOrStay();
        }
    }
}