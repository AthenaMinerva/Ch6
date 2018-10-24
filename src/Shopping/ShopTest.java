package Shopping;

import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args) {
        //set variables
        boolean shopping = false;
        String itemName;
        double price;
        int quantity;
        ShoppingCart3 myCart = new ShoppingCart3();

        //ask to start shopping
        String input = MyTools.readString("Would you like to go shopping? (yes or no)");
        while(!input.equalsIgnoreCase("yes") & !input.equalsIgnoreCase("no")){
            System.out.print("Error: Wrong input\n");
            input = MyTools.readString("Would you like to go shopping? (yes or no)");
        }
        if(input.equalsIgnoreCase("yes")){
            shopping = true;
        }

        //shopping loop
        while(shopping) {

            itemName = MyTools.readString("What would you like to buy?");
            price = MyTools.readDouble("How much does it cost?");
            quantity = MyTools.readInt("How many do you want?");
            myCart.addToCart(itemName, price, quantity);

            input = MyTools.readString("Would you like to go shopping? (yes or no)");
            while(!input.equalsIgnoreCase("yes") & !input.equalsIgnoreCase("no")){
                System.out.print("Error: Wrong input\n");
                input = MyTools.readString("Would you like to go shopping? (yes or no)");
            }
            if(input.equalsIgnoreCase("no")){
                shopping = false;
            }
        }

        //print list
        System.out.println(myCart.toString());
    }
}
