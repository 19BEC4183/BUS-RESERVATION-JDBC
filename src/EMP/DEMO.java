package EMP;

import java.sql.*;

public class DEMO 
{
	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/practice";
		String un="root";
		String pw="root";
		String query="SELECT * FROM EMP WHERE SAL>100000";
		Insertdata();
		
		Connection con= DriverManager.getConnection(dburl, un, pw);
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(query);
		while(rs.next())
		{
		System.out.println("Id is "+rs.getInt(1));
		System.out.println("Name is "+rs.getString(2));
		System.out.println("Designation is "+rs.getString(3));
		System.out.println("Salary is "+rs.getInt(4));
		System.out.println("-------------------------------------");
		}
		con.close();
		
	}
	
	public static void Insertdata() throws SQLException
	{
		String dburl = "jdbc:mysql://localhost:3306/practice";
		String un="root";
		String pw="root";
		int empid=121;
		String name="Sudhakar";
		String designation= "Junior Developer";
		int salary=25000;
		
		String query="INSERT INTO EMP VALUES("+ empid +",'"+name+"','"+designation+"',"+salary+");";
		
		Connection con= DriverManager.getConnection(dburl, un, pw);
		Statement s=con.createStatement();
		int rs=s.executeUpdate(query);
		System.out.println(rs);
		
		con.close();
		
	}
}
