package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService
{
    public void addTruck(Truck t)
    {
        try
        {
            String sql="INSERT INTO truck(name,model,capacity,driver_name)VALUES(?,?,?,?)";
            Connection connection=ConnectionDetails.getcon();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,t.getName());
            ps.setString(2,t.getModel());
            ps.setInt(3,t.getCapacity());
            ps.setString(4,t.getDriver_name());
            int rowimpacted=ps.executeUpdate();
            System.out.println("Row Impacted="+rowimpacted);

            ps.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Truck getTruckById(int id)
    {

        String sql="select * from truck where id=?";
        Truck truck=new Truck();
        try
        {

            Connection connection=ConnectionDetails.getcon();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet=ps.executeQuery();
            if (resultSet.next())
            {
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
            }
            ps.close();
            connection.close();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return truck;
    }

    public void updateTruck(Truck truck)
    {
        String sql="update truck set name=?,model=?,capacity=?,driver_name=? where id=?";
        try
        {
            Connection connection=ConnectionDetails.getcon();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,truck.getName());
            ps.setString(2,truck.getModel());
            ps.setInt(3,truck.getCapacity());
            ps.setString(4, truck.getDriver_name());
            ps.setInt(5,truck.getId());

            int rowupdated=ps.executeUpdate();
            System.out.println("row updated:"+rowupdated);


            ps.close();
            connection.close();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Truck> getAllTrucks()
    {
        String sql="select * from truck";
        List<Truck> t=new ArrayList<Truck>();

        try
        {
            Connection connection=ConnectionDetails.getcon();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next())
            {
                Truck truck=new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));
                t.add(truck);
            }


            resultSet.close();
            statement.close();
            connection.close();

        }


        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return t;
    }

    public void deleteTruck(int id)
    {
        String sql="delete from truck where id=?";
        try
        {
            Connection connection=ConnectionDetails.getcon();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            int rowdeleted=ps.executeUpdate();
            System.out.println(rowdeleted+" Row deleted:");

            ps.close();
            connection.close();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
