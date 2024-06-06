package stepsofJDBC;

import java.sql.*;
import java.util.*;


public class BatchExecution 
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Main start");

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/svit";
        String username = "postgres";
        String password = "root";

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established");

        String query = "insert into student values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        while(true) 
        {
        	System.out.print("Enter id: ");
            int id = s.nextInt();
            
            System.out.print("Enter name: ");
            String name = s.next();
            
            System.out.print("Enter gender: ");
            String gender = s.next();
            
            System.out.print("Enter age: ");
            int age = s.nextInt();
            
            System.out.println();
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setInt(4, age);
            
            ps.addBatch();
            
            ps.executeBatch();
            
            
            System.out.println("Enter 1 to continue or 0 to stop!!");
            int n = s.nextInt();
            
            if(n==0)break;
        }
        System.out.println("Main end");
        
        s.close();
	}
}
