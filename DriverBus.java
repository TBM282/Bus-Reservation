package BusRes_JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverBus {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);

		BusDAO busdao=new BusDAO();
		try {
		busdao.displayBusInfo();
		
		
		int userOpt=1;
		while(userOpt==1)
		{
			System.out.println("Enter the Number\n1.Book\n2.Exit");
			userOpt=sc.nextInt();
			if(userOpt==1)
			{
//				System.out.println("Booking...");
				Booking booking=new Booking();
				if(booking.isAvailable())
				{
//					bookings.add(booking);
					BookingDAO bookingdao=new BookingDAO();
					bookingdao.addBooking(booking);
					System.out.println("Your booking is confirmed");
				}
				else
				{
					System.out.println("Sorry, Bus is full. Try another bus or date");
				}
			}
		}
		sc.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
	}
}
