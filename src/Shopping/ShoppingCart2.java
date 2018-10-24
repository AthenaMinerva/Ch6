package Shopping;

import java.text.NumberFormat;

public class ShoppingCart2 {
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity
    private Item[] cart;      //Declare a cart instance variable


    /**
     * Creates an empty shopping cart with a capacity of 5 items
     */
    public ShoppingCart2()
    {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart = new Item[capacity]; //Initialize the cart instance variable to the appropriate size
    }

    /**
     * Adds an item to the shopping cart.
     * @param itemName
     * @param price
     * @param quantity
     */
    public void addToCart(String itemName, double price, int quantity)
    {
        //if cart is full, make it 3 items bigger
        if(itemCount == cart.length) {
            this.increaseSize();
        }

        //Complete the addToCart method
        cart[itemCount++] = new Item(itemName, price, quantity);
        totalPrice += price*quantity;
    }

    //Complete the getter method getTotalPrice. Remember the getter should not print anything.
    public double getTotalPrice(){
        return totalPrice;
    }

    public int getCartLength()
    {
        return cart.length;
    }


    /**
     *
     * @return the contents of the cart together with summary information
     */
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String contents = "\nShopping Cart\n";
        contents += String.format("%-10s%10s%10s%10s","Item","Price","Quantity","Total\n");


        for (int i = 0; i < itemCount; i++)
        {
            //contents += cart[i].toString() + "\n";
            contents += String.format("%-15s%10.2f%10d%10.2f\n",cart[i].getName(),cart[i].getPrice(), cart[i].getQuantity(),
                                                               (cart[i].getPrice()*cart[i].getQuantity()));
        }

        contents += "\nTotal Price: " + fmt.format(totalPrice);
        contents += "\n";

        return contents;
    }

    private void increaseSize(){
        capacity += 3;
        Item[] tempCart = new Item[capacity];
        for(int i = 0; i < cart.length; i++) {
            tempCart[i] = cart[i];
        }
        cart = tempCart;
    }
}
