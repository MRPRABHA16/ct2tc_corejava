package stepsofJDBC;

import java.sql.Connection;
//import org.postgresql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class example {
	public static void main(String[] args)
	{ 
		System.out.println("Main Start");
		
		String path = "org.postgresql.Driver";
		try {
			Class.forName(path);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://localhost:5432/employee";
		String username = "postgres";
		String password = "root";
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query = "create table student(id int, name varchar, gender varchar)";
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			statement.execute(query);
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}
}


