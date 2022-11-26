import java.net.SocketTimeoutException;
import java.sql.*;
import java.util.*;

import javax.xml.transform.Source;


public class Main {
    public static void main(String[] args) throws Exception 
    {
        //int option = CommandMenu();
        Scanner scan = new Scanner(System.in); 
        CommandMenu();
        int choice = scan.nextInt();
        

    }
    public static void CommandMenu()
    {
        System.out.println("Command Menu");
        System.out.println(" 0.)  Exit");
        System.out.println(" 1.)  Display Schedule");
        System.out.println(" 2.)  Edit Schedule");
        System.out.println(" 3.)  Delete Trip Offering");
        System.out.println(" 4.)  Add Trip");
        System.out.println(" 5.)  Change Driver");
        System.out.println(" 6.)  Change Bus");
        System.out.println(" 7.)  Add Trip Offering");
        System.out.println(" 8.)  Display Stops");
        System.out.println(" 9.)  Display Weekly Schedule");
        System.out.println("10.)  Add Driver");
        System.out.println("11.)  Add Bus");
        System.out.println("12.)  Delete Bus");
        System.out.println("13.)  Insert Actual Trip Information");

    }
}

