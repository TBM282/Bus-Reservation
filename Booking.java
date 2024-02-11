package BusRes_JDBC;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Booking {

	String passengerName;
	int busNo;
	Date date;
	
	public Booking()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the passenger: ");
		this.passengerName=sc.next();
		System.out.println("Enter the Bus Number");
		this.busNo=sc.nextInt();
		System.out.println("Enter the Date dd-mm-yyyy");
		String dateInput=sc.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean isAvailable() throws SQLException
	{
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		
		int capacity=busdao.getCapacity(busNo);
		int booked=bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
	
	
}
