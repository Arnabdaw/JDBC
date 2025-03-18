package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hope
{
    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";

    public static String URL="jdbc:mysql://localhost:3306/dipraa";

    public static String USERNAME="root";

    public static String PASSWORD="";

    public static void main(String[] args)
    {
        try
        {
            //load the JDBC driver
            Class.forName(LOAD_DRIVER);

            //making connection
            Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //create a statement
            Statement statement = connection.createStatement();

            //create a query
            String query="select * from students";
            ResultSet resultSet=statement.executeQuery(query);


            //process the results
            while(resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String course=resultSet.getString("course");
                System.out.println("ID: "+id+ " NAME: "+name+ " COURSE: "+course );
            }

            //close the connection
            resultSet.close();
            statement.close();
            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
