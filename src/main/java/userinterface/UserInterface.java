package userinterface;

import models.*;
import models.Dealership;
import models.Vehicle;
import persistance.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private VehicleDao vehicleDao;
    private DealershipDao dealershipDao;
    private ContractDao contractDao;

    public UserInterface(VehicleDao vehicleDao, DealershipDao dealershipDao, ContractDao contractDao) {
        this.vehicleDao = vehicleDao;
        this.dealershipDao = dealershipDao;
        this.contractDao = contractDao;
    }

    public int displayMenu(){
        int userInput = ConsoleHelper.promptForInt("""
                Dealership
                --------------
                1) Search By Price
                2) Search By Make And Model
                3) Search By Year
                4) Search By Color
                5) Search By Mileage
                6) Search By Vehicle Type
                7) Display All Vehicles
                8) Add Vehicle
                9) Remove Vehicle
                10) Sell/Lease a vehicle
                0) Exit
                """);

        return userInput;
    }

    //call displayMenu, read user input and call corresponding method
    public void display(){
        //while loop
        while(true) {
            switch (displayMenu()) {
                case 1:
                    processSearchByPriceRequest();
                    break;
                case 2:
                    processSearchByMakeModelRequest();
                    break;
                case 3:
                    processSearchByYearRequest();
                    break;
                case 4:
                    processSearchByColorRequest();
                    break;
                case 5:
                    processSearchByMileageRequest();
                    break;
                case 6:
                    processSearchByVehicleTypeRequest();
                    break;
                case 7:
                    processDisplayAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSellOrLeaseVehicleRequest();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid input, please enter a whole number 0-9");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles){
        vehicles.forEach(System.out::println);
    }

    public void processSearchByPriceRequest(){
        double minPrice = ConsoleHelper.promptForDouble("Minimum price of Vehicle");
        double maxPrice = ConsoleHelper.promptForDouble("Maximum price of Vehicle");
        try {
            displayVehicles(vehicleDao.getVehiclesByPrice(minPrice, maxPrice));
            System.out.println();
        }
        catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
        }


    }

    public void processSearchByMakeModelRequest(){
        String make = ConsoleHelper.promptForString("Enter the make of the vehicle");
        String model = ConsoleHelper.promptForString("Enter the model of the vehicle");
        try {
            displayVehicles(vehicleDao.getVehiclesByMakeModel(make, model));
            System.out.println();
        }
        catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
        }

    }

    public void processSearchByYearRequest(){
        int min = ConsoleHelper.promptForInt("Enter the earliest year of the vehicles you want to see");
        int max = ConsoleHelper.promptForInt("Enter the latest year of the vehicles you want to see");
        try {
            displayVehicles(vehicleDao.getVehiclesByYear(min, max));
            System.out.println();
        }
        catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
        }
    }

    public void processSearchByColorRequest(){
        String color = ConsoleHelper.promptForString("Enter the color of the vehicle you want to see");
        try {
            displayVehicles(vehicleDao.getVehiclesByColor(color));
            System.out.println();
        }
        catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
        }
    }

    public void processSearchByMileageRequest(){
        int min = ConsoleHelper.promptForInt("Enter the minimum miles of the vehicles you want to see");
        int max = ConsoleHelper.promptForInt("Enter the maximum miles of the vehicles you want to see");
        try {
            displayVehicles(vehicleDao.getVehiclesByMileage(min, max));
            System.out.println();
        }
        catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
        }
    }

    public void processSearchByVehicleTypeRequest(){
        String vehicleType = ConsoleHelper.promptForString("Enter the type of the vehicles you want to see");
        try {
            displayVehicles(vehicleDao.getVehiclesByVehicleType(vehicleType));
            System.out.println();
        }
        catch (SQLException e) {
            System.out.println("There was a SQL error: " + e.getMessage());
        }
    }

    public void processDisplayAllVehiclesRequest(){
       try {
           displayVehicles(vehicleDao.getAllVehicles());
       }
       catch (SQLException e){
           System.out.println("There was a SQL error: " + e.getMessage());
       }
    }

    public void processAddVehicleRequest(){

        int vin = ConsoleHelper.promptForInt("Enter the vin number");
        int year = ConsoleHelper.promptForInt("Enter the year of the vehicle");
        String make = ConsoleHelper.promptForString("Enter the make of the vehicle");
        String model = ConsoleHelper.promptForString("Enter the model of the vehicle");
        String type = ConsoleHelper.promptForString("Enter the type of the vehicle");
        String color = ConsoleHelper.promptForString("Enter the color of the vehicle");
        int odometer = ConsoleHelper.promptForInt("Enter the mileage of the vehicle");
        double price = ConsoleHelper.promptForDouble("Enter the price of the vehicle");

       // Vehicle v = new Vehicle(vin, year, make, model, type, color, odometer, price);
        //dealership.addVehicle(v);

       // DealershipFileManager.saveDealership(dealership);
        System.out.println("models.Vehicle added successfully");


    }

    public void processRemoveVehicleRequest(){

        int vin = ConsoleHelper.promptForInt("Enter the vin number of the vehicle you want to remove");

       // Vehicle v = dealership.getVehicleByVIN(vin);

       // if(v != null){
        //    dealership.removeVehicle(v);
         //   DealershipFileManager.saveDealership(dealership);
       // }
        //else{
      //      System.out.println("models.Vehicle not found");
       // }
    }

    public Vehicle getVehicleByVinPrompt(){
//       boolean isFound = false;
//        do {
//            int vin = ConsoleHelper.promptForInt("Enter the vin number of the vehicle you would like to purchase");
//            Vehicle vehicleSold = dealership.getVehicleByVIN(vin);
//            if (vehicleSold != null) {
//                isFound = true;
//                return vehicleSold;
//            }
//            else{
//                System.out.println("models.Vehicle not found");
//            }
//        }while(!isFound);
        return null;
    }

    public Contract createContractWithCustomer(){
        //Make a sales contract from user input and return

        int sellOrLease = ConsoleHelper.promptForInt("Sell or Lease\n" +
                "1) Sell \n" +
                "2) Lease");

       Vehicle v = getVehicleByVinPrompt();
        String date = ConsoleHelper.promptForString("models.Contract date (YYYYMMDD)");
        String name = ConsoleHelper.promptForString("Customer name");
        String email = ConsoleHelper.promptForString("Customer email") ;


        if (sellOrLease == 1) {
            String financeOption = ConsoleHelper.promptForString("Would you like to finance the vehicle (yes/no");
            //todo add console helper promptForYesNo
            boolean isFinanced = financeOption.equalsIgnoreCase("yes") ? true : false;
            Contract salesContract = new SalesContract(date, name, email, v, isFinanced);
            return salesContract;
        }
        else{
            Contract leaseContract = new LeaseContract(date, name, email , v);
            return leaseContract;
        }



    }





    public void processSellOrLeaseVehicleRequest(){
                Contract c = createContractWithCustomer();
                ContractDataManager.saveContract(c);

               //remove the vehicle sold from csv
             //   dealership.removeVehicle(dealership.getVehicleByVIN(c.getVehicleSold().getVin()));
               // DealershipFileManager.saveDealership(dealership);





    }







}
