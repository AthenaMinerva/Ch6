package Shopping;

import java.util.Scanner;

public class ShopTest {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean shopping = false;
        System.out.println("Would you like to go shopping? (yes or no)");
        if(scan.next() == "yes") {
            shopping = true;
        }
        while(shopping) {
            System.out.println();
        }
    }
}
