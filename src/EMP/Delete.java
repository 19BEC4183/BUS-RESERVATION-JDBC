package EMP;
import java.sql.*;

public class Delete
{
	public static void main(String[] args) throws SQLException {
		delete();
		
	}
	
//INSERT OPERATION	
	/*public static void Insertpst() throws SQLException
	{
		
		int empid=122;
		String name="Dhilip";
		String designation= "Junior Developer";
		int salary=27000;
		
		String query="INSERT INTO EMP VALUES(?,?,?,?);";
		
		Connection con= DriverManager.getConnection(dburl, un, pw);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, empid);
		ps.setString(2, name);
		ps.setString(3, designation);
		ps.setInt(4, salary);
		int c=ps.executeUpdate();
		System.out.println(c);
		
		con.close();
		
	}*/
	
	public static void delete() throws SQLException
	{
		String dburl = "jdbc:mysql://localhost:3306/practice";
		String un="root";
		String pw="root";
		int empid=122;
		
		String query="DELETE FROM EMP WHERE EMPID=?;";
		
		Connection con= DriverManager.getConnection(dburl, un, pw);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, empid);
		
		int c=ps.executeUpdate();
		System.out.println(c);
		
		con.close();
		
	}
}