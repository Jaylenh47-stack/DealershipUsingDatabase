package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import persistance.VehicleDao;
import userinterface.UserInterface;
//How do big projects handle all of their Dao's
//Can i make a method to so that I don't have to say try connect.. every time
public class Main {

    public static void main(String[] args){
        try{
            BasicDataSource ds = new BasicDataSource();

            VehicleDao vD = new VehicleDao(ds);


            UserInterface userInterface = new UserInterface();
            userInterface.display();
        }



















    }






}
