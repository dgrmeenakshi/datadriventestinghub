package com.DataDrivenTesting.Rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        Properties or = new Properties();

        String configpropFilePath = (System.getProperty("user.dir"))+"//src//main//resources//properties//Config.properties";
        String orPropertiesFilePath =  (System.getProperty("user.dir"))+"//src//main//resources//properties//OR.properties";

        File configpropFile = new File(configpropFilePath);
        File orpropFile = new File(orPropertiesFilePath);

        FileInputStream fis = new FileInputStream(configpropFile);
        config.load(fis);

        FileInputStream orpropFileInputStream = new FileInputStream(orpropFile);
        or.load(orpropFileInputStream);

        System.out.println(config.getProperty("browser"));
        System.out.println(or.getProperty("bml"));


    }
}
