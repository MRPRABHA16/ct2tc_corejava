package stepsofJDBC;

import java.sql.*;
import java.util.*;

public class UpdateRow
{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Main start");

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/svit";
        String username = "postgres";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established");

        System.out.println("Update: 1. ID 2. Name 3. Gender 4. Age");
        int ch = s.nextInt();

        String query = null;
        PreparedStatement preparedStatement = null;

        switch (ch)
        {
            case 1:
                System.out.println("Enter the id to be updated!");
                int oldId = s.nextInt();
                System.out.println("Enter the new id!");
                int newId = s.nextInt();

                query = "UPDATE student SET id = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, newId);
                preparedStatement.setInt(2, oldId);
                preparedStatement.executeUpdate();
                break;

                
            case 2:
                System.out.println("Enter the id of the student whose name is to be updated!");
                int studentIdForName = s.nextInt();
                System.out.println("Enter the new name!");
                String newName = s.next();

                query = "UPDATE student SET name = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, studentIdForName);
                preparedStatement.executeUpdate();
                break;

                
            case 3:
                System.out.println("Enter the id of the student whose gender is to be updated!");
                int studentIdForGender = s.nextInt();
                System.out.println("Enter the new gender!");
                String newGender = s.next();

                query = "UPDATE student SET gender = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, newGender);
                preparedStatement.setInt(2, studentIdForGender);
                preparedStatement.executeUpdate();
                break;

                
            case 4:
                System.out.println("Enter the id of the student whose age is to be updated!");
                int studentIdForAge = s.nextInt();
                System.out.println("Enter the new age!");
                int newAge = s.nextInt();

                query = "UPDATE student SET age = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, newAge);
                preparedStatement.setInt(2, studentIdForAge);
                preparedStatement.executeUpdate();
                break;

                
            default:
                System.out.println("Invalid choice");
        }

        System.out.println("Main end");
        
        s.close();
    }
}
