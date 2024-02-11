package BusRes_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Data Access Object
public class BusDAO {

	public void displayBusInfo() throws SQLException
	{
		String query="select * from bus";
		Connection con=DB_Connection.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(query);
		while(rs.next())
		{
			System.out.println("Bus No : "+rs.getInt(1));
			if(rs.getInt(2)==0)
			{
				System.out.println("AC : no");
			}
			else
			{
				System.out.println("AC : yes");
			}
			System.out.println("Capacity : "+rs.getInt(3));
		}
		System.out.println("--------------------------------");
		
		
	}
	
	public int getCapacity(int id)throws SQLException
	{
		String query="select capacity from bus where id="+id;
		Connection con=DB_Connection.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
