package stepsofJDBC;

import java.sql.*;
import java.util.*;

public class Deleterow
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Main Start");
		
		String path = "org.postgresql.Driver";
		
		Class.forName(path);	
		
		String url = "jdbc:postgresql://localhost:5432/svit";
		String username = "postgres";
		String password = "root";
			
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established");
		
		String query = "delete from student where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);		
		
		System.out.println("Enter the id : ");
		int id = s.nextInt();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.execute();
		
		System.out.println("Main End");
		
		s.close();		
	}
}


