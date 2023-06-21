package GroupProject1;

import java.util.Scanner;

/**
 *
 * @author Maskeen Singh
 */
public class BlackJackGame {

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Deck deck = new Deck();
        deck.shuffle();

        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("Player's Hand:");
        playerHand.display();
        System.out.println("Player's Hand Value: " + playerHand.getValue());

        System.out.println("Dealer's Hand:");
        dealerHand.display();
        System.out.println("Dealer's Hand Value: " + dealerHand.getValue());

        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Player's Hand:");
                playerHand.display();
                System.out.println("Player's Hand Value: " + playerHand.getValue());

                if (playerHand.getValue() > 21) {
                    System.out.println("Player busts! You lose.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                while (dealerHand.getValue() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }

                System.out.println("Dealer's Hand:");
                dealerHand.display();
                System.out.println("Dealer's Hand Value: " + dealerHand.getValue());

                if (dealerHand.getValue() > 21 || dealerHand.getValue() < playerHand.getValue()) {
                    System.out.println("You win!");
                } else if (dealerHand.getValue() > playerHand.getValue()) {
                    System.out.println("Dealer wins!");
                } else {
                    System.out.println("It's a tie!");
                }

                break;
            }
        }
        
        scanner.close();
    }
}    
