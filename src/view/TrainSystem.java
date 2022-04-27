package view;

import model.Booking;
import model.Customer;
import model.Train;
import list.MyList;
import menu.SubMenu;
import dbo.MenuManager;

public class TrainSystem {

    public static void main(String[] args) {

        MyList<Customer> lc = new MyList<>();
        MyList<Booking> lb = new MyList<>();
        MyList<Train> lt = new MyList<>();
        MenuManager m = new MenuManager();

        runMenu(lc, lb, lt, m);

    }

    public static void runMenu(MyList<Customer> lc, MyList<Booking> lb, MyList<Train> lt, dbo.MenuManager m) {
        while (true) {
            int choise = MenuManager.menu();

            if (choise == 0) {
                break;
            }
            switch (choise) {
                //Train
                case 1:
                    while (true) {
                        int choiceT = SubMenu.menuT();

                        if (choiceT == 0) {
                            break;
                        }
                        switch (choiceT) {
                            case 1:
                                MenuManager.loadFromFileTrains(lt);
                                break;
                            case 2:
                                m.inputTrainToHead(lt);   
                                break;
                            case 3:
                                m.printTrain(lt);
                                break;
                            case 4:
                                m.saveTrainsToFile(lt);
                                break;
                            case 6:
                                m.deleteByTCode(lt);
                                break;
                            case 5:
                                m.searchByTCode(lt);    
                                break;
                            case 7:
                                m.sortByTCode(lt);
                                break;
                            case 8:
                                m.addTrainAfter(lt);
                                break;
                            case 9:
                                m.deleteTrainAfter(lt);
                                break;
                        }
                    }
                    break;
                
                //Customer    
                case 2:
                    while (true) {
                        int choiseC = SubMenu.menuC();

                        if (choiseC == 0) {
                            break;
                        }
                        switch (choiseC) {
                            case 1:
                                m.loadFromFileCustomers(lc);
                                break;
                            case 2:
                                m.inputCusToTail(lc);
                                break;
                            case 3:
                                m.printCus(lc);
                                break;
                            case 4:
                                m.saveCustomersToFile(lc);
                                break;
                            case 5:
                                m.searchByCCode(lc);
                                break;
                            case 6:
                                m.delectByCCode(lc);    
                                break;
                        }
                    }
                    break;
                
                //Booking
                case 3:
                    while (true) {
                        int choiseB = SubMenu.menuB();

                        if (choiseB == 0) {
                            break;
                        }
                        switch (choiseB) {
                            case 1:
                                m.addBooking(lb, lc , lt);
                                break;
                            case 2:
                                m.printBooking(lb);
                                break;
                            case 3:
                                m.sortBooking(lb);
                                break;
                        }
                    }
                    break;
            }
        }
    }

}
