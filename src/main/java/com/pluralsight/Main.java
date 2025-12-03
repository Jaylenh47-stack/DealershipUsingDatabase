package com.pluralsight;

import com.mysql.cj.result.BufferedRowList;
import org.apache.commons.dbcp2.BasicDataSource;
import persistance.ContractDao;
import persistance.DealershipDao;
import persistance.VehicleDao;
import userinterface.UserInterface;
//How do big projects handle all of their Dao's
//Can i make a method to so that I don't have to say try connect.. every time
public class Main {

    public static void main(String[] args){
        try{
            BasicDataSource ds = getBasicDataSource(args);

            VehicleDao vehicleDao = new VehicleDao(ds);
            DealershipDao dealershipDao = new DealershipDao(ds);
            ContractDao contractDao = new ContractDao(ds);

            UserInterface userInterface = new UserInterface(vehicleDao, dealershipDao, contractDao);
            userInterface.display();
        }
        catch (Exception e){
            System.out.println("There was an error: " + e.getMessage());
        }




    }

    private static BasicDataSource getBasicDataSource(String username, String password, String URL){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(URL);

        return basicDataSource;
    }

    private static BasicDataSource getBasicDataSource(String[] args){
        String username = args [0];
        String password = args[1];
        String URL = args[2];
        return getBasicDataSource(username,password, URL);

    }





}
