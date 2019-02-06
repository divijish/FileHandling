package com.divijish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMover {

	public static void mover(String inputFileLocation, String outputFileLocation) {

		File inputFile = new File(inputFileLocation);
		File outputFile = new File(outputFileLocation);
		boolean inputRight = false;
		boolean outputRight = false;
		InputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			inputRight = true;
		} catch (FileNotFoundException e) {
			System.out.printf("Could not find file at '%s' location. Please make sure that the file exists. Exiting!",
					inputFileLocation);
		}
		OutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(outputFile);
			outputRight = true;
		} catch (FileNotFoundException e) {
			System.out.printf(
					"Error creating file at '%s' location. Please make sure utility has access to this location. Exiting!",
					outputFileLocation);
		}

		if (inputRight && outputRight) {
			try {
				FileMover.execute(fileInputStream, fileOutputStream);

			} catch (IOException e) {
				System.out.println(
						"Problem reading data from inputFile. Please check there are sufficient rights to do so.");
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					System.out.println("Error closing inputfile.");
				}
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					System.out.println("Error closing outputFile");
				}
			}
		}

	}

	private static void execute(InputStream fileInputStream, OutputStream fileOutputStream) throws IOException {

		byte[] buffer = new byte[1024];

		int bufferCount = 0;

		while (((bufferCount = fileInputStream.read(buffer)) != -1)) {
			fileOutputStream.write(buffer, 0, bufferCount);
		}

	}

}
