import java.net.SocketTimeoutException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Driver;
import java.util.*;

import javax.xml.transform.Source;


public class Main {
    public static void main(String[] args) throws Exception 
    {
        String url;  
            Connection con = null;  
            try {  
                Class.forName("com.mysql.jdbc.Driver");  
                //url="jdbc:mysql://localhost:3306/spring"; 
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CS4350Lab4", "sqluser", "password" );
                //con = DriverManager.getConnection(url);  
                System.out.println("Connection created");  
                con.close();  
                System.out.println("Connection closed");  
                }  
                catch (Exception e) {  
                System.out.println(e.toString());  
            }  

        //int option = CommandMenu();
        // Scanner scan = new Scanner(System.in); 
        // boolean notExit = true;
        // while(notExit){
        //     CommandMenu();
        //     int choice = scan.nextInt();
        //     switch(choice){
        //         case 0:
        //             notExit = false;
        //         break;
        //         case 1:
        //         //Display Schedule
        //             System.out.println("Display Schedule");
        //         break;
        //         case 2:
        //         //Edit Schedule
        //             System.out.println("Edit Schedule");
        //         break;
        //         case 3:
        //         //Delete Trip Offering
        //             System.out.println("Delete Trip Offering");
        //         break;
        //         case 4:
        //         //Add Potential Trip
        //             System.out.println("Add Potential Trip");
        //         break;
        //         case 5:
        //         //Change Driver
        //             System.out.println("Change Driver");
        //         break;
        //         case 6:
        //         //Change Bus
        //             System.out.println("Change Bus");
        //         break;
        //         case 7:
        //         //Add Trip Offering
        //             System.out.println("Add Trip Offering");
        //             addATripOffering();
        //         break;
        //         case 8:
        //         //Display Stops
        //             System.out.println("Display Stops");
        //         break;
        //         case 9:
        //         //Display Weekly Schedule
        //             System.out.println("Display Weekly Schedule");
        //         break;
        //         case 10:
        //         //Add Driver
        //             System.out.println("Add Driver");
        //         break;
        //         case 11:
        //         //Add Bus
        //             System.out.println("Add Bus");
        //         break;
        //         case 12:
        //         //Delete Bus
        //             System.out.println("Delete Bus");
        //         break;
        //         case 13:
        //         //Insert Actual Trip Information
        //             System.out.println("Insert Actual Trip Information");
        //         break;
        //         default:System.out.println("That is not an option, please try again.");
        //     }
        // }
        
    }
    public static void CommandMenu()
    {
        System.out.println("Command Menu");
        System.out.println(" 0.)  Exit");
        System.out.println(" 1.)  Display Schedule");
        System.out.println(" 2.)  Edit Schedule");
        System.out.println(" 3.)  Delete Trip Offering");
        System.out.println(" 4.)  Add Actual Trip");
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
    // Display Schedule
    public static void DisplaySchedule() {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Please enter Start Location:");
        String startLoc = scan.nextLine();
        System.out.println("Please enter Destination:");
        String destination = scan.nextLine();
        System.out.println("Please enter Date in the format YYYY/MM/DD:");
        String date = scan.nextLine();

        try{
            String sql =    "SELECT ScheduledStartTime, SecheduledArrivalTime, DriverName, BusID "
                            +"FROM Trip, TripOffering "
                            +"WHERE Trip.TripNumber = TripOffering.TripNumber AND"
                                +"TripOffering.Date = "+date+"AND";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab4", "sqluser", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            conn.close();

        }catch (SQLException ex){
           System.out.println(ex.getMessage());
           System.out.println("FAILURE!");
        }

    }
    // Edit Schedule
    // Delete Trip Offering
    // Add Potential Trip
    // Change Driver
    // Change 
    
    // Add Trip Offering
    public static void addATripOffering() {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Please enter Trip Number:");
        int tripNum = scan.nextInt();
        String nothing = scan.nextLine();
        System.out.println("Please enter Date in the format MM/DD/YYYY:");
        String date = scan.nextLine();
        System.out.println("Please enter Scheduled Start Time:");
        String startTime = scan.nextLine();
        System.out.println("Please enter Secheduled Arrival Time:");
        String arrivalTime = scan.nextLine();
        System.out.println("Please enter Driver Name:");
        String driverName = scan.nextLine();
        System.out.println("Please enter BusID:");
        int busID = scan.nextInt();

        try{
            String sql = "INSERT INTO TripOffering values("+tripNum+", '"+date+"', "+startTime+", "+arrivalTime+", "+driverName+", "+busID+");";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            conn.close();
        }catch (SQLException ex){
           System.out.println(ex.getMessage());
           System.out.println("FAILURE!");
        }

    }
    // Display Stops
    // Display Weekly Schedule
    // Add Driver
    // Add Bus
    // Delete Bus
    // Insert Actual Trip Information
}

