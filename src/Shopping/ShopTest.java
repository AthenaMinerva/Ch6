package Shopping;

import java.util.Scanner;

public class ShopTest {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean shopping = false;
        ShoppingCart myCart = new ShoppingCart();
        System.out.println("Would you like to go shopping? (yes or no)");
        if(scan.next() == "yes") {
            shopping = true;
        }
        while(shopping) {
            System.out.println("What would you like to buy?");
            String itemName = scan.nextLine();
            System.out.println("How much does it cost?");
            double price = scan.nextDouble();
            System.out.println("How many do you want?");
            int quantity = scan.nextInt();
            myCart.addToCart(itemName, price, quantity);

            System.out.println("Would you like to go shopping? (yes or no)");
            String input = scan.next();
            while(input != "yes"){

                if(scan.next() == "yes") {
                    shopping = true;
                } else if(scan.next() == "no") {
                    shopping = false;
                } else {

                }
            }

        }
    }
}
