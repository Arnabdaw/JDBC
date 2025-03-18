package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Experiment
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
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            //create a query
            String query="select * from students";
            ResultSet resultSet=statement.executeQuery(query);


            //process the results
//            while(resultSet.next())
//            {
//                int id=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                String course=resultSet.getString("course");
//                System.out.println("ID: "+id+ " NAME: "+name+ " COURSE: "+course );
//            }

            while (resultSet.next())
            {
                Thread.sleep(2000);
                resultSet.refreshRow();
                System.out.println(resultSet.getInt(1)+"    "+
                        resultSet.getString(2)+"    "+resultSet.getString(3));
            }

            System.out.println();
            resultSet.last();
            System.out.println("fetching last row:");
            System.out.println("ID:"+resultSet.getInt("id"));
            System.out.println("NAME:"+resultSet.getString("name"));
            System.out.println("COURSE:"+resultSet.getString("course"));

            resultSet.updateString("course","BCA");
            resultSet.updateRow();
//
            System.out.println();
            resultSet.first();
            System.out.println("fetching first row:");
            System.out.println("ID:"+resultSet.getInt("id"));
            System.out.println("NAME:"+resultSet.getString("name"));
            System.out.println("COURSE:"+resultSet.getString("course"));
//
//            resultSet.moveToInsertRow();
//            resultSet.updateInt("id",8);
//            resultSet.updateString("name","Palit");
//            resultSet.updateString("course","Radiology");
//            resultSet.insertRow();

            System.out.println();
            resultSet.last();
            System.out.println("fetching last row:");
            System.out.println("ID:"+resultSet.getInt("id"));
            System.out.println("NAME:"+resultSet.getString("name"));
            System.out.println("COURSE:"+resultSet.getString("course"));



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
