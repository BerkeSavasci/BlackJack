import java.util.Scanner;

public class Game {
    static int firstCard = 0;
    static int secondCard = 0;
    static int dealerFirst = 0;
    static int dealerSecond = 0;
    static int card = 0;
    static Card c = new Card();
    static Main m = new Main();
    public  void game(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        firstCard = m.randNum(); //random number
        System.out.println("You get a \n" + c.drawRandomCard(firstCard)); //calls cards with the random number and prints
        secondCard = m.randNum(); //random number
        System.out.println("and a \n" + c.drawRandomCard(secondCard)); //calls cards with the random number and prints
        if(firstCard > 10||secondCard > 10) { //checks if the numbers are >10 black jack rules j q k = 10
            if (firstCard > 10) { // checks first card
                firstCard = 10; // resets its value to 10
                int total = firstCard + secondCard; //adds the numbers up saves them in total
                System.out.println("Your total is: " + (total)); // prints it
                if (total > 21) { //checks if you already lost
                    System.out.println("Bust!");
                    System.out.println("Press enter to restart: ");
                    game(); //resets game
                }
            }else {
                secondCard = 10; // if second number is >10 resets value to 1o
                int total = firstCard + secondCard;
                System.out.println("Your total is: " + (total));//adds the numbers up saves them in total
                if (total > 21) { //checks if you already lost
                    System.out.println("Bust!");
                    System.out.println("Press enter to restart: ");
                    game(); // resets game
                }
            }
        }else {
            System.out.println("Your total is: " + (firstCard + secondCard)); //both numbers are lower than 10 so adds and prints
        }
        System.out.println("Press enter to continue"); //user input
        input = scan.nextLine();
        dealerFirst = m.randNum(); //random number
        System.out.println("The dealer shows:\n "+c.drawRandomCard(dealerFirst));//calls cards with the random number
        dealerSecond = m.randNum(); //second random number
        int dealerTotal = dealerFirst+dealerSecond; //adds both random numbers
        System.out.println("And has a card facing down:\n "+c.faceDown()); // prints facing down card
        System.out.println("The dealers total is hidden");
        int total = firstCard+secondCard; //adds to card values from the user
        while (true) {
            String temp  = m.hitOrStay(); //calls hit or stay
            if(temp.equals("hit")){ // if user inputs hit goes in
                card = m.randNum(); //gives new random number
                System.out.println("You get a \n" + c.drawRandomCard(card));//calls draw random with the number and prints
                if(card > 10){ // checks if card is > 10 if so resets value to 10
                    card=10;
                }
                total +=card; // updates total
                System.out.println("Your new total is: " + total);//prints new total
                if (total > 21) { // if user has more than 21 he/she lost resets game
                    System.out.println("Bust!");
                    System.out.println("Press enter to restart: ");
                    game();
                }

            } else if(temp.equals("stay")){ // user inputs stay
                System.out.println("The dealers cards are: \n" + c.drawRandomCard(dealerFirst)+c.drawRandomCard(dealerSecond));//prints dealers cards
                if(dealerFirst > 10||dealerSecond > 10) { //checks if cards value >10
                    if (dealerSecond > 10) {//second card >10 resets value to 10
                        dealerSecond = 10;
                        System.out.println("Dealers total is: " + (dealerSecond + dealerFirst));//prints the total
                    }else {
                        dealerFirst = 10; //first card is>10 restes value to 10
                        System.out.println("Dealers total is: " + (dealerFirst+dealerSecond)); //prints the total
                    }
                }else {
                    System.out.println("Dealers total is " + (dealerFirst + dealerSecond)); //cards are <10 prints the total
                }
                while (dealerTotal<17){ //checks dealers total value
                    System.out.println("Enter to continue"); //pause for user
                    input =scan.nextLine();
                    int newCard = m.randNum(); //new random number for the dealer
                    System.out.println("The dealer draws: \n" + c.drawRandomCard(newCard));//prints dealers new card
                    dealerTotal +=newCard; //updates the total
                    System.out.println("Dealers total is: "+ dealerTotal);//prints the total
                }
                if(dealerTotal>21){ //dealer bust if total is >21
                    System.out.println("You win!");
                    System.exit(0);
                }else if(dealerTotal<total){ //dealer bust if player total>dealer total
                    System.out.println("You win!");
                    System.exit(0);
                }else if(total<dealerTotal){ //player bust if player total<dealer total
                    System.out.println("You lose!");
                    System.exit(0);
                }else if (total == dealerTotal){ //draw if equal
                    System.out.println("Draw!");
                    System.exit(0);
                }
            }

        }
    }
}
