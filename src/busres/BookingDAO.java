package busres;

import java.util.Date;
import java.sql.*;

public class BookingDAO {
    
    public int getBookedCount47(int busNo, Date date) throws SQLException {
        String query = "select count(passenger_name) from booking47 where bus_no=? and travel_date=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        pst.setInt(1, busNo);
        pst.setDate(2, sqldate);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
    public void addBooking47(Booking booking) throws SQLException {
        String query = "INSERT INTO booking47 (passenger_name, bus_no, travel_date, age, gender, mobile_number, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = DbConnection.getConnection();
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqldate);
        pst.setInt(4, booking.age);
        pst.setString(5, booking.gender);
        pst.setString(6, booking.mobileNumber);
        pst.setString(7, booking.email);
        
        pst.executeUpdate();
        
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            booking.BookingId = rs.getInt(1);
        }
        
        System.out.println("Booking ID: " + booking.BookingId);	
    }
    
    public static void cancel(int id) throws SQLException {
        String query = "DELETE from booking47 where BookingId=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Cancellation successful for Booking ID: " + id);
        } else {
            System.out.println("No booking found with Booking ID: " + id);
        }
    }
    
    public static void amount(Booking booking,int numberOfPassengers) throws SQLException
    {
    	int amount=0;
    	String query="SELECT AMOUNT FROM bus47 WHERE BUS_NO="+booking.busNo;
    	Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) 
		{
			amount=rs.getInt(1);
		}
    	System.out.println("Total Amount : "+amount*numberOfPassengers);
    }
    
  
}

