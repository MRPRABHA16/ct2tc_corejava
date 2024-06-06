package stepsofJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class prepareStatement
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Main Start");
		
		String path = "org.postgresql.Driver";
		try {
			
			Class.forName(path);
			
		} catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
			
		}
		
		String url = "jdbc:postgresql://localhost:5432/employee";
		String username = "postgres";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url,username,password);
		String query = "insert into student values(?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1,10);
		preparedStatement.setString(2,"kiran");
		preparedStatement.setString(3,"kiran@gmail.com");
		
		preparedStatement.execute();
		
		System.out.println("Connection estibalished");
	}

}
