import java.net.SocketTimeoutException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Driver;
import java.util.*;
import javax.xml.transform.Source;
import com.microsoft.sqlserver.jdbc.*;

//Code done by Sam Childers and Noe Rivera
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        boolean notExit = true;
        while (notExit) {
            CommandMenu();
            int choice = scan.nextInt();
            switch (choice) {
                case 0:
                    notExit = false;
                    break;
                case 1:
                    // Display Schedule
                    System.out.println("Display Schedule");
                    break;
                case 2:
                    // Edit Schedule
                    System.out.println("Edit Schedule");
                    break;
                case 3:
                    // Delete Trip Offering
                    System.out.println("Delete Trip Offering");
                    deleteTripOffering();
                    break;
                case 4:
                    // Add Trip
                    addTrip();
                    break;
                case 5:
                    // Change Driver
                    System.out.println("Change Driver");
                    break;
                case 6:
                    // Change Bus
                    System.out.println("Change Bus");
                    break;
                case 7:
                    // Add Trip Offering
                    System.out.println("Add Trip Offering");
                    addTripOffering();
                    break;
                case 8:
                    // Display Stops
                    System.out.println("Display Stops");
                    break;
                case 9:
                    // Display Weekly Schedule
                    System.out.println("Display Weekly Schedule");
                    break;
                case 10:
                    // Add Driver
                    System.out.println("Add Driver");
                    addDriver();
                    break;
                case 11:
                    // Add Bus
                    System.out.println("Add Bus");
                    addBus();
                    break;
                case 12:
                    // Delete Bus
                    System.out.println("Delete Bus");
                    
                    break;
                case 13:
                    // Insert Actual Trip Information
                    System.out.println("Insert Actual Trip Information");
                    break;
                default:
                    System.out.println("That is not an option, please try again.");
            }
        }
    }

    public static void CommandMenu() {
        System.out.println("Command Menu");
        System.out.println(" 0.)  Exit"); //WORKS
        System.out.println(" 1.)  Display Schedule");
        System.out.println(" 2.)  Edit Schedule");
        System.out.println(" 3.)  Delete Trip Offering");//WORKS
        System.out.println(" 4.)  Add Trip");//WORKS
        System.out.println(" 5.)  Change Driver");//DONE NEED CHECK
        System.out.println(" 6.)  Change Bus");//DONE NEED CHECK
        System.out.println(" 7.)  Add Trip Offering");//WORKS
        System.out.println(" 8.)  Display Stops");
        System.out.println(" 9.)  Display Weekly Schedule");
        System.out.println("10.)  Add Driver");//WORKS
        System.out.println("11.)  Add Bus");//WORKS
        System.out.println("12.)  Delete Bus");//WORKS
        System.out.println("13.)  Create Actual Trip Information");
    }

    // Display Schedule
    public static void DisplaySchedule() {
        
    }


    // Edit Schedule


    // Delete Trip Offering
    public static void deleteTripOffering(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Trip Number:");
        int tripNum = scan.nextInt();
        String nothing = scan.nextLine();//needed so no error
        System.out.println("Please enter Date in the format MM/DD/YYYY:");
        String date = scan.nextLine();
        System.out.println("Please enter Scheduled Start Time:");
        String startTime = scan.nextLine();

        removeTripOffering(tripNum, date, startTime);
    }


    // Add Trip
    public static void addTrip(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Trip Number:");
        int tripNum = scan.nextInt();
        String nothing = scan.nextLine();//needed so no error
        System.out.println("Please enter Start Location:");
        String startLoc = scan.nextLine();
        System.out.println("Please enter Destination Name:");
        String destName = scan.nextLine();

        newTrip(tripNum,startLoc,destName);

    }

//changeBus(int busID, int tripNum, String date, String schStartTime)
    // Change Driver FOR GIVEN TRIP OFFERING
    public static void changeDriverForTrip(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Driver name you would like to change to:");
        String driverName = scan.nextLine();
        String nothing = scan.nextLine();
        System.out.println("Enter Trip Number:");
        int tripNum = scan.nextInt();
        nothing = scan.nextLine();
        System.out.println("Please enter Date of Trip in the format MM/DD/YYYY:");
        String date = scan.nextLine();
        System.out.println("Please enter Scheduled Start Time of Trip:");
        String schStartTime = scan.nextLine();

        changeDriver(driverName, tripNum, date, schStartTime);
    }
    // Change Bus FOR GIVEN TRIP OFFERING
    public static void changeBusForTrip(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Bus ID you would like to change to:");
        int busID = scan.nextInt();
        String nothing = scan.nextLine();
        System.out.println("Enter Trip Number:");
        int tripNum = scan.nextInt();
        nothing = scan.nextLine();
        System.out.println("Please enter Date of Trip in the format MM/DD/YYYY:");
        String date = scan.nextLine();
        System.out.println("Please enter Scheduled Start Time of Trip:");
        String schStartTime = scan.nextLine();

        changeBus(busID, tripNum, date, schStartTime);
    }


    // Add Trip Offering
    public static void addTripOffering() {
        Boolean cont = true;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Trip Number (From a trip that exists):");
            int tripNum = scan.nextInt();
            String nothing = scan.nextLine();//needed so no error
            System.out.println("Please enter Date in the format MM/DD/YYYY:");
            String date = scan.nextLine();
            System.out.println("Please enter Scheduled Start Time:");
            String startTime = scan.nextLine();
            System.out.println("Please enter Scheduled Arrival Time:");
            String arrivalTime = scan.nextLine();
            System.out.println("Please enter Driver Name:");
            String driverName = scan.nextLine();
            System.out.println("Please enter BusID:");
            int busID = scan.nextInt();
            // makes trip with only tripNum

            newTrip(tripNum, "", "");
            // default year will be hard coded as 0000
            newBus(busID, "", 0000);
            newTripOffering(tripNum, date, startTime, arrivalTime, driverName, busID);

            System.out.println("Do you want to endter more trips?(Y/N)");
            String option = scan.nextLine();
            if (option == "Y" || option == "y") {
                cont = true;
            } else if (option == "N" || option == "n") {

            }

        } while (cont);
    }


    // Display Stops
    // Display Weekly Schedule


    // Add Driver
    public static void addDriver(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Driver's name:");
        String name = scan.nextLine();
        System.out.println("Enter Driver's phone number:");
        String pNumber = scan.nextLine();

        newDriver(name, pNumber);

    }
    // Add Bus
    public static void addBus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Bus ID:");
        int busID = scan.nextInt();
        String nothing = scan.nextLine();
        System.out.println("Enter Bus model:");
        String model = scan.nextLine();
        System.out.println("Enter Bus year:");
        int year = scan.nextInt();
        nothing = scan.nextLine();

        newBus(busID, model, year);
    }
    // Delete Bus
    public static void deleteBus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Bus ID:");
        int busID = scan.nextInt();
        removeBus(busID);
    }
    // Insert Actual Trip Information

    public static void addActualTripStopInfo(){
        Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Trip Number (From a trip that exists):");
            int tripNum = scan.nextInt();
            String nothing = scan.nextLine();//needed so no error
            System.out.println("Please enter Stop number (From a stop that exists):");
            String stopNum = scan.nextLine();

            System.out.println("Please enter Scheduled Arrival Time:");
            String schArrive = scan.nextLine();
            System.out.println("Please enter Actual Start Time:");
            String actStart = scan.nextLine();
            System.out.println("Please enter Actual Arrival Time:");
            String actArrive = scan.nextLine();
            System.out.println("Please enter Number of Passengers Entering:");
            int passIn = scan.nextInt();
            nothing = scan.nextLine();//needed so no error
            System.out.println("Please enter Number of Passengers Leaving:");
            int passOur = scan.nextInt();
            nothing = scan.nextLine();//needed so no error

            //newTrip(tripNum, "", "");
            // default year will be hard coded as 0000
            //newBus(busID, "", 0000);
            //newTripOffering(tripNum, date, startTime, arrivalTime, driverName, busID);

            newActualTripStopInfo(tripNum, stopNum, schArrive, actStart, actArrive, passIn, passOut);
    }

    // QUERIES!!!
    public static void newTripOffering(int tripNum, String date, String startTime, String arrivalTime,
            String driverName, int busID) {
        try {
            String sql = "INSERT INTO TripOffering values(" + tripNum + ", \"" + date + "\", \"" + startTime + "\", \""
                    + arrivalTime + "\", \"" + driverName + "\", " + busID + ");";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }

    public static void newBus(int busID, String model, int year) {
        try {
            String sql = "INSERT INTO Bus values(" + busID + ", \"" + model + "\", " + year + ");";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }

    public static void newDriver(String name, String pNumber) {
        try {
            String sql = "INSERT INTO Bus values(\"" + name + "\", \"" + pNumber + "\");";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }

    public static void newTrip(int tripNum, String StartLocationName, String DestinationName) {
        try {
            String sql = "INSERT INTO Trip values(" + tripNum + ", \"" + StartLocationName + "\", \"" + DestinationName
                    + "\");";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }

    public static void newActualTripStopInfo(int tripNum, int stopNum, String schArrive, String actStart, String actArrive, int passIn, int passOut) {
        // try {
        //     String sql = "INSERT INTO newActualTripStopInfo values(" + tripNum + ", \"" + date + "\", \"" + startTime + "\", \""
        //             + arrivalTime + "\", \"" + driverName + "\", " + busID + ");";
        //     Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
        //             "password");
        //     Statement stmt = conn.createStatement();
        //     stmt.executeUpdate(sql);
        //     // System.out.println(rs);
        //     conn.close();
        // } catch (SQLException ex) {
        //     System.out.println(ex.getMessage());
        //     System.out.println("FAILURE!");
        // }
    }

    public static void removeTripOffering(int tripNum, String date, String startTime){
        try {
            String sql = "DELETE FROM TripOffering WHERE TripNumber = '"+tripNum+"' AND Date = '"+date+"' AND ScheduledStartTime = '"+startTime+"';";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }
    public static void removeBus(int busID) {
        try {
            String sql = "DELETE FROM Bus WHERE BusID = " + busID + ";";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }

    public static void changeDriver(String driverName, int tripNum, String date, String schStartTime){
        try {
            String sql = "UPDATE TripOffering SET DriverName = "+driverName+" WHERE TripNumber = "+tripNum+" AND Date = "+date+" AND ScheduledStartTime = "+schStartTime+";";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }

    public static void changeBus(int busID, int tripNum, String date, String schStartTime){
        try {
            String sql = "UPDATE TripOffering SET BusID = "+busID+" WHERE TripNumber = "+tripNum+" AND Date = "+date+" AND ScheduledStartTime = "+schStartTime+";";
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cs4350lab4", "sqluser",
                    "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // System.out.println(rs);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FAILURE!");
        }
    }
}
