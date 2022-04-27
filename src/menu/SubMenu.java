/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import dbo.Validate;
import static dbo.Validate.checkInputLimited;

public class SubMenu {

    public static int menuT() {
        System.out.println("  ==== Train Information ====");
        System.out.println("1. Load data from file\n"
                + "2. Input & add to the head\n"
                + "3. Display data\n"
                + "4. Save train list to file\n"
                + "5. Search by tcode\n"
                + "6. Delete by tcode\n"
                + "7. Sort by tcode\n"
                + "8. Add after position k\n"
                + "9. Delete the node after the node having code = xCode\n"
                + "0. Exit to main menu\n");
        System.out.println("");
        System.out.print("Enter your choice: ");

        int choice = Validate.checkInputLimited(0, 9);
        return choice;
    }

    public static int menuB() {
        System.out.println("  ==== Booking Information ====");
        System.out.println("1. Input data\n"
                + "2. Display data with total value\n"
                + "3. Sort  by tcode + ccode\n"
                + "0. Exit to main menu\n");
        System.out.println("");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputLimited(0, 3);
        return choice;
    }

    public static int menuC() {
        System.out.println("  ==== Customer Information ====");
        System.out.println("1. Load data from file\n"
                + "2. Input & add to the end\n"
                + "3. Display data\n"
                + "4. Save customer list to file\n"
                + "5. Search by ccode\n"
                + "6. Delete by ccode\n"
                + "0. Exit to main menu\n");
        System.out.println("");
        System.out.print("Enter your choice: ");
        int choice = checkInputLimited(0, 6);
        return choice;
    }

}
