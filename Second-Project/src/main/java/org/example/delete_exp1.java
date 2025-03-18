
package org.example;

import java.sql.*;


public class delete_exp1
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
//            String query="delete from students where id=?";
//            PreparedStatement ps=connection.prepareStatement(query);
//            ps.setInt(1,6);
//            int rowimpacted=ps.executeUpdate();
//            System.out.println(rowimpacted);

//            Statement statement=connection.createStatement();
//            String qr="INSERT INTO students VALUES(6,'Ishika','CSE')";
//            int rowimpacted=statement.executeUpdate(qr);
//            System.out.println(rowimpacted);


//            ps.close();
//            statement.close();
            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
