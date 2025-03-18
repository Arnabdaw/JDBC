package org.example;

import java.sql.*;


public class insertexp
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
            Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //create a Preparedstatement

            String query="INSERT INTO students(id,name,course) VALUES(?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1,7);
            ps.setString(2,"Nisha");
            ps.setString(3,"Nursing");

            int rowimpacted=ps.executeUpdate();
            System.out.println("Row impacted="+rowimpacted);



            //close the connection
            ps.close();
            connection.close();


        }


        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
