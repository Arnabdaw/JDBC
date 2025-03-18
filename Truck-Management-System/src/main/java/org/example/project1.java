
package org.example;

import java.util.List;
import java.util.Scanner;

public class project1
{
    public static void main(String[] args)
    {
       TruckService truckService=new TruckService();

//     System.out.println("1: To add a new truck detail\n2: To display a specific truck detail\n" +
//             "3: To update a truck detail\n4: To display all truck details\n5: To delete a truck " +
//             "detail\n ");
//     while(true)
//     {
//        System.out.println("enter your choice");
//        Scanner obj=new Scanner(System.in);
//        int ch=obj.nextInt();
//        switch(ch)
//        {
//           case 1:
//
//        }
//     }




//       Truck t1=new Truck("TATA","2017",1000,"Rajesh");
//       Truck t2=new Truck("VOLVO","2019",3500,"Vola");
//       Truck t3=new Truck("MAHENDRA","2014",2000,"Bubai");
//       Truck t4=new Truck("EICHER","2022",400,"Papon");
//       Truck t5=new Truck("HONDA","2011",1300,"Aniket");
//       Truck t6=new Truck("TESLA","2025",5000,"Elon");
//       Truck t7=new Truck("PORCHE","2021",1900,"Rajjaq");


       //adding data in the database
//        System.out.println("Adding data:");
//        truckService.addTruck(t1);
//        truckService.addTruck(t2);
//        truckService.addTruck(t3);
//        truckService.addTruck(t4);
//        truckService.addTruck(t5);
//        truckService.addTruck(t6);
//        truckService.addTruck(t7);


        //fetching a specific row
        System.out.println();
        System.out.println("Fetching data by id:....."+5);
        Truck truck=truckService.getTruckById(5);
        System.out.println("Truck data:"+truck);


//        updating truck data
        System.out.println();
        truck.setDriver_name("Tuli");
        truckService.updateTruck(truck);
        System.out.println("updated truck data: "+truckService.getTruckById(5));


        //fetching all truck data
        System.out.println();
        System.out.println("Fetching all data.......");
        List<Truck>allTrucks=truckService.getAllTrucks();
        System.out.println("All trucks in Database:");
        for (Truck t:allTrucks)
        {
            System.out.println(t);
        }

//
        //delete truck data
        System.out.println();
        System.out.println("deleting all data by id......."+7);
        truckService.deleteTruck(7);
        System.out.println(7+"th row deleted");


        //final truck database
        System.out.println();
        allTrucks=truckService.getAllTrucks();
        System.out.println("All trucks in Database after all operation:");
        for (Truck t:allTrucks)
        {
            System.out.println(t);
        }

    }
}
