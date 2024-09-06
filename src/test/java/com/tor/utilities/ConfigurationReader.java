package com.tor.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1 make it private so it`s not accessible from outside of the class
    //2 static is to make sure it`s created and loaded before everything else.
    private static Properties properties = new Properties();

    static {

        try {
            //2 - open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3 - Load the properties object with file (load properties)
            properties.load(file);

            //close the file in the memory
            file.close();


        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH");
            e.printStackTrace();
        }


    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
