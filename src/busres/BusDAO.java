package busres;

import java.sql.*;

public class BusDAO 

{

	public void route()
	{
		System.out.println("\t\tWelcome to Blue Bus");
		System.out.println();
		System.out.println("-------Routes-----");
		System.out.println("KARUR TO CHENNAI --> RouteNo=45");
		System.out.println("NAMAKKAL TO CHENNAI --> RouteN0=47");
		System.out.println();
	}
	
	public void displayBusInfo47(int routeno) throws SQLException {
		String query=" ";
		if(routeno==45)
		{
		query = "Select * from bus47 WHERE BUS_NO>200 && BUS_NO<300";
		}
		if(routeno==47)
		{
		query = "Select * from bus47 WHERE BUS_NO>100 && BUS_NO<200";
		}
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus_Name: " + rs.getString(1));
			System.out.println("Bus No: " + rs.getInt(2));
			if(rs.getInt(3)==0)
				System.out.println("AC: no ");
			else
				System.out.println("AC: yes ");
			System.out.println("Capacity: " + rs.getInt(4));
			System.out.println("Timing: " + rs.getString(5));
			System.out.println("Amount: "+rs.getInt(6));
			System.out.println("------------------------------------------");
		}
		
	}
	
	
	public int getCapacity47(int id) throws SQLException {
		String query = "Select capacity from bus47 where bus_no=" + id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}