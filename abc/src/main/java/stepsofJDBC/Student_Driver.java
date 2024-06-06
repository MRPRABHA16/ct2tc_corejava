package stepsofJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Student_Driver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Student database management system");
		
		String path = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/employee";
		String username = "postgres";
		String password = "root";
		
		try
		{
			Class.forName(path);
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			while(true)
			{
				System.out.println("--------- Choose from the below option: -------");
				System.out.println();
				System.out.println("Enter 1 to insert data\nEnter 2 to insert data in a Batch\nEnter 3 to fetch data\nEnter 0 to exit");
				int choice = sc.nextInt();
				
				switch(choice)
				{
				case 1 :
					Student.insertData(connection);
					break;
						
				case 2 :
					Student.insertBatchData(connection);
					break;
				
				case 3 :
					Student.FetchData(connection);
					break;
					
				case 0 :
					System.out.println("Goodbye user");
					break;
					
				default :
					System.out.println("----------Please choose only the above options----------------");
						
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured, please check the code");
			e.printStackTrace();
		}
	}

}
