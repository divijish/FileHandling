package com.divijish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
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

		boolean noError = true;

		List<String> errorList = configFileChecker(properties);
		if (errorList.size() > 0) {
			noError = false;
		}

		if (noError) {
			String inputFileLocation = properties.getProperty("inputFileLocation");
			String outputFileLocation = properties.getProperty("outputFileLocation");

			Scanner inputScanner = new Scanner(System.in);

			System.out.println("1. Use input and output path to write a file.");
			System.out.println("2. Write from command line.");

			Integer operation = inputScanner.nextInt();

			switch (operation) {

			case 1:
				FileMover.mover(inputFileLocation, outputFileLocation);
				break;

			case 2:
				try {
					SystemFileHandler.mover(inputScanner, outputFileLocation);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Wrong Input!");
			}

		} else {
			errorList.stream().forEach(System.out::println);
		}

	}

	private static List<String> configFileChecker(Properties properties) {
		List<String> errorList = new ArrayList<String>();
		String inputFileLocation = properties.getProperty("inputFileLocation");
		String outputFileLocation = properties.getProperty("outputFileLocation");

		if (inputFileLocation == null) {
			errorList.add("inputFileLocation not found");
		}

		if (outputFileLocation == null) {
			errorList.add("outputFileLocation not found");
		}

		return errorList;

	}

}
