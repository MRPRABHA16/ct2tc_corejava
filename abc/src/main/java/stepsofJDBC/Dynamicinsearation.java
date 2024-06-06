package stepsofJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Dynamicinsearation
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
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student ID:");
		int Id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Student name:");
		String name = sc.nextLine();
		
		System.out.println("Enter Student Email:");
		String email = sc.nextLine();
		
		preparedStatement.setInt(1,Id);
		preparedStatement.setString(2,name);
		preparedStatement.setString(3,email);
		
		preparedStatement.execute();
		
		System.out.println("Connection estibalished");
	}

}
