/**
 * Feb 8, 2015: Utils
 * 
 * @author Ajoy Bhatia
 */

package com.ajoy.algorithms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	/**
	 * Reads a file which has one integer value on each line, and returns the values
	 * in an integer array.
	 * 
	 * @param filePath the path of the file to read
	 * @return int array containing the values from each line
	 */
	public static int[] readIntsFromFile(String filePath) {
		try {
			Path path = Paths.get(filePath);
			List<Integer> values = new ArrayList<Integer>();
			
			// Read values from file at given file path.
			BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
			String line = reader.readLine();
			while (line != null) {
				Integer value = Integer.valueOf(line);
				values.add(value);
				line = reader.readLine();
			}
			
			// Convert List<Integer> to int[].
			int[] intArray = new int[values.size()];
			int i = 0;
			for (Integer value : values) {
				intArray[i++] = value.intValue();
			}
			
			// Return the int[].
			return intArray;
			
		} catch (IOException e) {
			System.out.println("Caught IOException: " + e + "\nReturning null");
			return null;
		}
	}
}
