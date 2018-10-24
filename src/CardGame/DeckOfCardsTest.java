package CardGame;

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
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // put Card objects in random order
        Card[] hand1 = new Card[5];

        //deal one hand
        for(int i  = 0; i < hand1.length; i++) {
            hand1[i] = myDeckOfCards.dealCard();
        }

        //print hand
        System.out.println("The hand of player 1 is:");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",
                hand1[0].toString(), hand1[1].toString(),
                hand1[2].toString(), hand1[3].toString(), hand1[4].toString());

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
