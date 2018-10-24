package Sales;
/**
 * Name: Kate Johnson
 * Date: 10/19/2018
 * Period: 1
 *
 * Sales.Sales.java
 *
 * Reads in and stores sales for each of 5 salespeople.  Displays
 * sales entered by salesperson id and total sales for all salespeople.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        //Prompt the user for the number of sales people that they need to enter
        //and modify the program to create an appropriately sized array.
        System.out.print("How many sales people do you want? ");
        
        final int SALESPEOPLE = scan.nextInt();
        int[] sales = new int[SALESPEOPLE];
        int sum;

        for (int i=0; i < sales.length; i++)
        {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }
        //print the array for verification
        //System.out.println(Arrays.toString(sales));

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i < sales.length; i++)
        {
            System.out.println("\t " + (i+1) + "\t\t\t" + sales[i]);
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);


        //Use your average method to print the average sales
        System.out.println("Average sales: " + average(sales));


        //Use your indexOfMax method to print the index of the best sales person
        //and the sales amount for that sales person.
        int indexMax = indexOfMax(sales);
        System.out.println("Best salesperson: " + (indexMax+1) + "\nTheir sales: " + sales[indexMax]);


        //Do the same for the worst sales person
        int indexMin = indexOfMin(sales);
        System.out.println("Worst salesperson: " + (indexMin+1) + "\nTheir sales: " + sales[indexMin]);
    }

    public static double average(int[] arr) throws IllegalStateException
    {
        //compute and return the average of arr
        //Be sure to use the length instance variable and you may assume that the array is full.
        //If the array does not have at least 1 element in it, throw an IllegalStateException

        int total = 0;
        int length = arr.length;

        if (length == 0){
            throw new IllegalStateException();
        } else {
            for(int i = 0; i < length; i++) {
                total += arr[i];
            }
            //double result = (double)total/length;
        }
        return (double)total/length;
    }

    public static int indexOfMax(int[] arr)
    {
        //find and return the index of the max value in arr
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] >= max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    //Do the same for an indexOfMin method
    public static int indexOfMin(int[] arr)
    {

        int index = -1;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] <= max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
