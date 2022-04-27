package dbo;

import java.util.Scanner;

public class Validate {

    private final static Scanner sc = new Scanner(System.in);
    private final static Scanner scStr = new Scanner(System.in);
    private static final String VALID_PHONE = "^[0-9]{10}$";
    static final String TRAIN_URL = "Trains.txt";
    static final String CUSTOMER_URL = "Customers.txt";

    public static int checkInputLimited(int min, int max) {
        while (true) {
            try {
                int result = sc.nextInt();
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please enter " + min + " to " + max + "!");
            }
        }
    }

    protected static String checkInputString() {
        while (true) {
            try {
                String result = scStr.nextLine();
                if (result.isEmpty()) {
                    throw new NullPointerException();
                }
                return result;
            } catch (NullPointerException n) {
                System.out.print("Enter again: ");
                System.err.println("Existed!");
            }
        } 
    }

    protected static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());
                return result;
            } catch (Exception e) {
                System.err.println("Please input number!");
                System.out.print("Enter again: ");                
            } 
        }
    }

    protected static double checkInputDouble() {
        while (true) {
            try {
                double result = sc.nextDouble();
                return result;
            } catch (NumberFormatException n) {
                System.out.print("Enter again: ");
                System.err.println("Please input number!");
            }
        }
    }

    protected static int checkInputBooked(int seat) {
        while (true) {
            try {
                int result = checkInputInt();
                if (result > seat) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException n) {
                System.err.println("booked ≤ seat");
                System.out.print("Enter again: ");
            }
        }
    }

    protected static String checkInputPhone() {
        while (true) {
            try {
                String result = checkInputString();
                if (!result.matches(VALID_PHONE)) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Enter 10-digit please!");
                System.out.print("Enter again: ");
            }
        }
    }

}
