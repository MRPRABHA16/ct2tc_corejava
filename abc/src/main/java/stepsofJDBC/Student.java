package stepsofJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student
{
	public static void insertData(Connection connection) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		String query =" insert into Student_Details values(?,?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(query);
		
		System.out.println("Enter the Student ID:");
		int id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Student name:");
		String name = sc.nextLine();
		
		System.out.println("Enter the Student Email:");
		String email = sc.nextLine();
		
		System.out.println("Enter the gender:");
		String gender = sc.nextLine();
		
		System.out.println("Enter the Student Age:");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the Departement:");
		String departement = sc.nextLine();
		
		statement.setInt(1,id);
		statement.setString(2,name);
		statement.setString(3,email);
		statement.setString(4,gender);
		statement.setInt(5,age);
		statement.setString(6,departement);
		
		statement.execute();
	}
	public static void insertBatchData(Connection connection) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		String query =" insert into Student_Details values(?,?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(query);
		
		while(true)
		{
			System.out.println("Enter the Student ID:");
			int id = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter Student name:");
			String name = sc.nextLine();
			
			System.out.println("Enter the Student Email:");
			String email = sc.nextLine();
			
			System.out.println("Enter the gender:");
			String gender = sc.nextLine();
			
			System.out.println("Enter the Student Age:");
			int age = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter the Departement:");
			String departement = sc.nextLine();
			
			statement.setInt(1,id);
			statement.setString(2,name);
			statement.setString(3,email);
			statement.setString(4,gender);
			statement.setInt(5,age);
			statement.setString(6,departement);
			
			statement.execute();
			
			statement.addBatch();
			
			System.out.println("Enter 0 to exit or anything else to continue");
			int exit = sc.nextInt();
			if(exit == 0)
			{
				break;
			}
		}
		statement.executeBatch();
		System.out.println("The quries have been executed");
	}
	
	public static void FetchData(Connection connection) throws SQLException
	{    
        String query = "select * from student_details";
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery(query);
        
        while(resultSet.next()) {
        	System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) +" " + resultSet.getString(3)+" "+ resultSet.getString(4)+ " "+ resultSet.getInt(5) + " "+ resultSet.getString(6));
        }
        
        connection.close();
	}
	
	public static void updateStudentDetails(Connection connection) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter 1 to update student name\nEnter 2 to update student email\n"+"Enter 3 to update student departement");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			updateStudentName(connection);
			break;
			
		default :
			System.out.println("Please choose only from the above options");
		}
	}
	
	private static void updateStudentName(Connection connection) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String query = "update student set name = ? where id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		
		
	}
}
