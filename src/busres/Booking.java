package busres;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
    String passengerName;
    static int busNo;
    static Date date;
    int age;
    String gender;
    String mobileNumber;
    String email;
    int BookingId;
    static Scanner scanner = new Scanner(System.in);
    public static void Busdetails()
    {
    	System.out.println("Enter bus no: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date (dd-MM-yyyy): ");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    Booking() throws SQLException {
        
        System.out.println("Available seats: " + display());
        System.out.println("Name of passenger: ");
        passengerName = scanner.next();
        System.out.println("Age: ");
        age = scanner.nextInt();
        System.out.println("Gender: ");
        gender = scanner.next();
        System.out.println("Mobile no: ");
        mobileNumber = scanner.next();
        System.out.println("Email Id: ");
        email = scanner.next();
    }

    public int display() throws SQLException {
        BusDAO busdao = new BusDAO();
        int capacity = busdao.getCapacity47(busNo);
        BookingDAO bookingdao = new BookingDAO();
        int booked = bookingdao.getBookedCount47(busNo, date);
        return capacity - booked;
    }

    public boolean isAvailable47() throws SQLException {
        BusDAO busdao = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();
        int capacity = busdao.getCapacity47(busNo);
        int booked = bookingdao.getBookedCount47(busNo, date);
        return booked < capacity;
    }
    
    
    // Getter methods for bus number and date
    public int getBusNo() {
        return busNo;
    }

    public Date getDate() {
        return date;
    }
}
