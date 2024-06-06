package stepsofJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchData {
public static void main(String[] args) throws Exception{
		
		String path = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/employee";
        String user= "postgres";
        String password = "root";
        
        Class.forName(path);
        Connection con = DriverManager.getConnection(url, user, password);
        
        String query = "select * from emp";
        
        Statement statement = con.createStatement();
        
        ResultSet resultSet = statement.executeQuery(query);
        
        while(resultSet.next()) {
        	System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) +" " + resultSet.getString(3));
        }
        
        con.close();
	}
}

