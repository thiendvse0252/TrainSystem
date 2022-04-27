/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import model.Customer;
import model.Booking;
import model.Train;
import list.MyList;
import static dbo.Validate.checkInputLimited;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MenuManager {

    public static void loadFromFileTrains(MyList<Train> t) {
        File f = new File(Validate.TRAIN_URL);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] train = line.split(",");
                t.addToTail(new Train(train[0], train[1], Integer.parseInt(train[2]), Integer.parseInt(train[3]), Double.parseDouble(train[4]), train[5]));
            }
            br.close();
            fr.close();
            System.err.println("Load successful!");
        } catch (Exception e) {
        }
    }

    public static void loadFromFileCustomers(MyList<Customer> mc) {
        //Object data = readAnObject();
        File f = new File(Validate.CUSTOMER_URL);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] customer = line.split(",");
                mc.addToTail(new Customer(customer[0], customer[1], customer[2]));
            }
            br.close();
            fr.close();
            System.err.println("Load successful!");
        } catch (IOException i) {
            System.err.println("Load file error!");
        } catch (Exception e) {
        }

    }

    //print info customers
    public static void printCus(MyList<Customer> mc) {
        //mc.traverse();
        int size = mc.length();
        if (size == 0) {
            System.out.println("CustomerList is empty.");
        } else {
            System.out.printf("%10s|%10s|%10s|\n", "Ccode", "Cus_name", "Phone");
            for (int i = 0; i < size; i++) {
                mc.getObject(i).showInfo();
            }
        }
    }  
    
    //print info train
    public static void printTrain(MyList<Train> ml) {
        int size = ml.length();
        if (size == 0) {
            System.out.println("TrainList is empty.");
        } else {
            System.out.printf("%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n", "Tcode", "Train_name",
                    "Seat", "Booked", "Depart_time", "Depart_place", "Available_seat");
            for (int i = 0; i < size; i++) {
                ml.getObject(i).showInfo();
            }
        }
    }  
    //add Customer to the end
    public static void inputCusToTail(MyList<Customer> mc) {
        System.out.print("Enter your code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter your name: ");
        String cName = Validate.checkInputString();
        System.out.print("Enter your number phone: ");
        String cPhone = Validate.checkInputPhone();

        mc.addToTail(new Customer(cCode, cName, cPhone));

        System.err.println("Add successful!");
    }

    public static void inputTrainToHead(MyList<Train> mt) {
        System.out.print("Enter your code: ");
        String tCode = Validate.checkInputString(); 
        System.out.print("Enter your train name: ");
        String tName = Validate.checkInputString();
        System.out.print("Enter number of seat: ");
        int tSeat = Validate.checkInputInt();
        System.out.print("Enter number seat was booked: ");
        int tBooked = Validate.checkInputBooked(tSeat);
        System.out.print("Enter depart_time: ");
        double time = Validate.checkInputDouble();
        System.out.print("Enter depart_place: ");
        String place = Validate.checkInputString();

        mt.addToHead(new Train(tCode, tName, tSeat, tBooked, time, place));

        System.err.println("Add succcessful!");
    }

    //search by customer code
    public static void searchByCCode(MyList<Customer> mc) {
        System.out.print("Enter Customer Code: ");
        String cCode = Validate.checkInputString();

        Customer c; //defind a Customer
        if ((c = mc.search(new Customer(cCode, "", ""))) == null) {
            System.err.println("Not found!");
            return;
        }
        System.out.println(c.toString());
    }  
    
    //delete by Customer code
    public static void delectByCCode(MyList<Customer> mc) {
        System.out.print("Enter Customer code: ");
        String cCode = Validate.checkInputString();

        mc.delete(new Customer(cCode, "", ""));
    }
 
    //search by Train Code
    public static void searchByTCode(MyList<Train> mt) {
        System.out.print("Enter tcode: ");
        String tCode = Validate.checkInputString();

        Train t;  //Define a Train 
        if ((t = mt.search(new Train(tCode, "", 0, 0, 0, ""))) == null) {
            System.err.println("Not found!");
            return;
        }
        System.out.println(t.toString());
    }

    //delete by Train Code
    public static void deleteByTCode(MyList<Train> mt) {
        System.out.print("Enter tcode: ");
        String tCode = Validate.checkInputString();

        mt.delete(new Train(tCode, "", 0, 0, 0, ""));

    }

    //sort Train list by TCode
    public static void sortByTCode(MyList<Train> mt) {
        mt.sort();
        System.err.println("Sorted");
    }

    //add a Train after   
    public static void addTrainAfter(MyList<Train> mt) {
        System.out.print("Enter position k: ");
        int k = Validate.checkInputInt();
        System.out.print("Enter your code: ");
        String tCode = Validate.checkInputString();
        System.out.print("Enter your train name: ");
        String tName = Validate.checkInputString();
        System.out.print("Enter number of seat: ");
        int tSeat = Validate.checkInputInt();
        System.out.print("Enter number seat was booked: ");
        int tBooked = Validate.checkInputBooked(tSeat);
        System.out.print("Enter depart_time: ");
        double time = Validate.checkInputDouble();
        System.out.print("Enter depart_place: ");
        String place = Validate.checkInputString();

        mt.addAfterPosition(k, new Train(tCode, tName, tSeat, tBooked, time, place));     

        System.err.println("Add successful!");
    }

    public static void addBooking(MyList<Booking> mb) {
        System.out.print("Enter Customer code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter Train code: ");
        String tCode = Validate.checkInputString();
        System.out.print("Enter Number of seat: ");
        int tSeat = Validate.checkInputInt();

        mb.addToTail(new Booking(tCode, cCode, tSeat));

        System.err.println("Add successful!");
    }

    public static void printBooking(MyList<Booking> mb) {
        //mo.traverse();
        int size = mb.length();
        if (size == 0) {
            System.out.println("BookingList is empty.");
        } else {
            System.out.printf("%10s|%10s|%10s|\n", "Tcode", "Ccode", "Seat");
            for (int i = 0; i < size; i++) {
                mb.getObject(i).showInfo();
            }
        }
    } 

    public static void sortBooking(MyList<Booking> mb) {
        mb.sort();
        System.err.println("Sorted");
    }

    public static int menu() {
        System.out.printf("%-3s%-10s", "", "==== Welcome to Train Booking System ====\n");
        System.out.println("1. Train list");
        System.out.println("2. Customer list");
        System.out.println("3. Booking list");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Enter your choice: ");
        int choise = checkInputLimited(0, 3);
        return choise;
    }

    public static void deleteTrainAfter(MyList<Train> mp) {
        System.out.print("Enter your code: ");
        String tCode = Validate.checkInputString();

        mp.deleteAfterNode(new Train(tCode, "", 0, 0, 0, ""));
    }

    public static void saveTrainsToFile(MyList<Train> mt) {
        File f = new File(Validate.TRAIN_URL);
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < mt.length(); i++) {
                Train t = mt.getObject(i);
                fw.write(t.getTcode() + "," + t.getTrain_name() + "," + Integer.toString(t.getSeat()) + "," + Integer.toString(t.getBooked()) + "," + Double.toString(t.getDepart_time()) + "," + t.getDepart_place() + "\n");
            }
            fw.close();
            System.err.println("Successfully!");
        } catch (IOException i) {
            System.err.println("File error!");
        } catch (Exception e) {
        }
    }

    public static void saveCustomersToFile(MyList<Customer> mc) {
        File f = new File(Validate.CUSTOMER_URL);
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < mc.length(); i++) {
                Customer c = mc.getObject(i);   //get customer from list
                fw.write(c.getCcode() + "," + c.getCus_name() + "," + c.getPhone() + "\n");
            }
            fw.close();
            System.err.println("Save successful!");
        } catch (IOException i) {
            System.err.println("File error!");
        } catch (Exception e) {
        }
    }

    public static void addBooking(MyList<Booking> mb, MyList<Customer> mc, MyList<Train> mt) {

        String tCode = checkInputTrain(mt);
        String cCode = checkInputCustomer(mc);
        int st = excuteBooking(mt, tCode);

        mb.addToTail(new Booking(tCode, cCode, st));

        System.err.println("Successfully!");
    }

    //check tCode
    static String checkInputTrain(MyList<Train> t) {
        System.out.print("Enter train code: ");
        while (true) {
            try {
                String tCode = Validate.checkInputString();
                for (int i = 0; i < t.length(); i++) {
                    Train tr = t.getObject(i);
                    if (tCode.equals(tr.getTcode())) {
                        return tCode;
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Your train code not exist!");
                System.out.print("Enter again: ");
            }
        }
    }

    //check cCode
    static String checkInputCustomer(MyList<Customer> mc) {
        System.out.print("Enter customer code: ");
        while (true) {
            try {
                String cCode = Validate.checkInputString();
                for (int i = 0; i < mc.length(); i++) {
                    Customer c = mc.getObject(i);
                    if (cCode.equals(c.getCcode())) {   //compare with ccode from list
                        return cCode;
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Not exist!");
                System.out.print("Enter again: ");
            }
        }
    }

    //insert and update order
    static int excuteBooking(MyList<Train> mt, String tCode) {
        System.out.print("Enter seat you want to book: ");

        while (true) {
            int st = Validate.checkInputInt();
            try {
                for (int i = 0; i < mt.length(); i++) {
                    Train p = mt.getObject(i);
                    if (tCode.equals(p.getTcode())) {
                        if (st > p.getSeat()) {
                            throw new NumberFormatException();
                        } else {
                            p.setSeat(p.getSeat() - st);
                            p.setBooked(p.getBooked() + st);
                            return st;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Not enough trains to book!");
                System.out.print("Please enter again: ");
            }
        }
    }
}
