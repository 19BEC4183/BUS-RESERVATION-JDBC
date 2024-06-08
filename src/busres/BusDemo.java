package busres;

import java.util.Scanner;

public class BusDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BusDAO busdao = new BusDAO();

        try {
            busdao.route();
            System.out.println("Enter RouteNO: ");
            int routenumber = scanner.nextInt();

            busdao.displayBusInfo47(routenumber);

            int userOpt = 1;

            while (userOpt == 1) {
                System.out.println("Enter 1 to Book and 2 to Cancel");
                userOpt = scanner.nextInt();
                BookingDAO bookingdao = new BookingDAO();

                if (userOpt == 2) { // cancellation
                    System.out.println("Enter Booking ID: ");
                    int cancellationid = scanner.nextInt();
                    BookingDAO.cancel(cancellationid);
                } else if (userOpt == 1) {
                    System.out.println("Enter number of passengers: ");
                    int numberOfPassengers = scanner.nextInt();
                    int i = 1;

                    Booking.Busdetails();
                    while (i <= numberOfPassengers) {
                        System.out.println("Booking details for passenger " + i + ":");
                        	 Booking booking = new Booking();

                        if (booking.isAvailable47()) {
                            bookingdao.addBooking47(booking);
                        } 
                        else
                        {
                            System.out.println("Sorry. Bus is full. Try another bus or date.");
                            break; 
                        }
                        if(i==numberOfPassengers)
                        {
                     	   BookingDAO.amount(booking,numberOfPassengers);
                     	   System.out.println("Your booking is confirmed for passenger " + i);
                        }
                        i++;
                     
                    }
                   
                    
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
