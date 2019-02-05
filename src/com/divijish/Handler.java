package com.divijish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Handler {

	public static void main(String[] args) {

		File configFile = new File("./config.properties");
		InputStream configStream;

		Properties properties = new Properties();
		try {
			configStream = new FileInputStream(configFile);
			properties.load(configStream);
		} catch (IOException e) {

			System.out.println("Please provide the config.properties file in classpath. Exiting!");
			System.exit(0);
		}

		Scanner inputScanner = new Scanner(System.in);
		String inputFileLocation = properties.getProperty("inputFileLocation");
		String outputFileLocation = properties.getProperty("outputFileLocation");
		File inputFile = new File(inputFileLocation);
		File outputFile = new File(outputFileLocation);

		try {
			InputStream fileInputStream = new FileInputStream(inputFile);
		} catch (FileNotFoundException e) {
			System.out.printf("Could not find file at '%s' location. Please make sure that the file exists. Exiting!", inputFileLocation);
			System.exit(0);
		}
		
		try {
			OutputStream outputStream = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			
			System.out.printf("Error creating file at '%s' location. Please make sure utility has access to this location. Exiting!", outputFileLocation);
		}
		
		
		
		

	}

}
