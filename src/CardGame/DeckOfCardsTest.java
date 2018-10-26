package CardGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Kate Johnson
 * Date: 10/24/18
 * Period: 1
 *
 * CardGame.DeckOfCardsTest.java
 *
 * Tester program to shuffle and deal a deck of Card objects
 */

public class DeckOfCardsTest
{
    public static void main (String[] args)
    {
        //Scanner!
        Scanner input = new Scanner(System.in);
        String responce;
        //set up deck
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // put Card objects in random order
        //create hands
        ArrayList<Card> playerHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        //game variables
        int playerTotal;
        int dealerTotal;
        boolean playing = true;
        boolean bust = false;

        //deal first two cards each
        for(int i  = 0; i < 2; i++) {
            playerHand.add(myDeckOfCards.dealCard());
            dealerHand.add(myDeckOfCards.dealCard());
        }
        playerTotal = myDeckOfCards.total(playerHand);
        dealerTotal = myDeckOfCards.total(dealerHand);

        //print dealer's 1st card
        System.out.println("The dealer's first card is:\n" + dealerHand.get(0).toString() + "\n");

        //print hand
        System.out.println("Your hand is:");
        for(int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).toString());
        }
        System.out.println("Total: " + playerTotal + "\n");

        //while player is deciding to hit or stay
        while(playing) {
            //ask player to hit or stay
            System.out.println("Press \'h\' to hit and \'s\' to stay");
            responce = input.next();

            //ask again if wrong input
            while(!responce.equals("h") & !responce.equals("s")) {
                System.out.println("Error: Wrong Input\nPress \'h\' to hit and \'s\' to stay");
                responce = input.next();
            }

            //what to do with player responce
            if(responce.equals("s")) {
                playing = false;
            } else {
                playerHand.add(myDeckOfCards.dealCard());
                playerTotal = myDeckOfCards.total(playerHand);

                //print hand
                System.out.println("Your hand is:");
                for(int i = 0; i < playerHand.size(); i++) {
                    System.out.println(playerHand.get(i).toString());
                }
                System.out.println("Total: " + playerTotal + "\n");

                //test total to see if we can continue
                if(playerTotal > 21) {
                    bust = true;
                    playing = false;
                } else if (playerTotal == 21) {
                    playing = false;
                }
            }
        }

        //After player stops hitting what to do: Bust, Win, Lose, Tie
        if(bust){
            System.out.println("That's a bust! Better luck next time.");
        } else{
            while(dealerTotal < 17) {
                dealerHand.add(myDeckOfCards.dealCard());
                dealerTotal = myDeckOfCards.total(dealerHand);
            }
            System.out.println("The dealer's total is: " + dealerTotal);
            if(dealerTotal > 21) {
                System.out.println("That's a bust for the dealer. You Win!");
            } else if(dealerTotal == playerTotal) {
                System.out.println("It's a tie!");
            } else if(dealerTotal > playerTotal) {
                System.out.println("You lost! Better luck next time.");
            } else {
                System.out.println("You win! Great job!");
            }
        }


/*        // -----------------------------------------------------------
        //  print all 52 Cards in the order in which they are dealt
        // -----------------------------------------------------------
        for (int i = 0; i < 13; i++)
        {
            // printf method is used for formatting output
            // print string (%) in a space of 20 characters (20s)
            // the - in the (-20s) makes the String left align
            // printf can be used with floats, ints and other types as well
            // cheat sheet @ https://thejavacheatsheet.wordpress.com/2015/04/11/printf/
            // Guide #2 https://www.cs.colostate.edu/~cs160/.Summer16/resources/Java_printf_method_quick_reference.pdf
            System.out.printf("%-20s%-20s%-20s%-20s\n",
                myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
                myDeckOfCards.dealCard(), myDeckOfCards.dealCard());

        }*/

    }
}
