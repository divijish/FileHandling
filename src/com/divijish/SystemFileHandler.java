package com.divijish;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemFileHandler {

	public static void mover(Scanner inputScanner, String outputFileLocation) throws IOException {
		
		File outputFile = new File(outputFileLocation);
		
		FileWriter writer = new FileWriter(outputFile);
		
		while(inputScanner.hasNextLine())
		writer.write(inputScanner.nextLine());
		writer.close();
	}

}
