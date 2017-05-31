package vn.edu.hcmiu.simpleTextUtils.utils;

import static vn.edu.hcmiu.simpleTextUtils.utils.Constants.EMPTY_STRING;
import static vn.edu.hcmiu.simpleTextUtils.utils.Constants.FLOAT_STRING;
import static vn.edu.hcmiu.simpleTextUtils.utils.Constants.LOWERCASE_STRING;
import static vn.edu.hcmiu.simpleTextUtils.utils.Constants.UPPERCASE_STRING;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class FileFactory {
	
	public static File getEmptyFile() throws IOException {
		return File.createTempFile("test", null);
	}
	
	public static File getFileWithData(List <String> data) throws FileNotFoundException, IOException {
		File result = getEmptyFile();
		int size = data.size();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(result)));
for (int i = 0; i < size; ++i) {
	writer.write(data.get(i));
	if (i < size - 1) {
	writer.newLine();
	}
}
		writer.close();
		return result;
	}
	
	// For file with no blanked line
	public static List <String> getSolidFileData() {
		List <String> data = new ArrayList <>();
		data.add(UPPERCASE_STRING);
		data.add(FLOAT_STRING);
		data.add(UPPERCASE_STRING);
		data.add(LOWERCASE_STRING);
		data.add(FLOAT_STRING);
		return data;
	}

	// Only one blanked line
	public static List <String> getBlankedFileData() {
		List <String> data = new ArrayList <>();
		data.add(EMPTY_STRING);
return data;
	}

	// Many blanked lines
	public static List <String> getLargeBlankedFileData() {
		List <String> data = new ArrayList <>();
		for (int i = 0; i < 10; ++i) {
			data.add(EMPTY_STRING);
		}
return data;
	}
	
	private static List <String> getCopy(List <String> data) {
		return new ArrayList <>(data);
	}

	// Add one blanked line to the end of the list
		public static List <String> addBlankedLineToTheEnd(List <String> data) {
			List <String> newData = getCopy(data);
		newData.add(EMPTY_STRING);
		return newData;
	}
	
		// Add many blanked lines to the end of the list
	public static List <String> addManyBlankedLinesToTheEnd(List <String> data) {
		List <String> newData = getCopy(data);
		for (int i = 0; i < 5; ++i) {
		newData.add(EMPTY_STRING);
		}
		return newData;
	}

	// Add one blanked line between non-empty strings
	public static List <String> addBlankedLineBetweenStrings(List <String> data) {
		List <String> newData = getCopy(data);
		int size = data.size();
for (int i = 0; i < size; ++i) {
	newData.add(data.get(i));
	if (i < size - 1) {
	newData.add(EMPTY_STRING);
	}
}
		return newData;
	}
	
	public static List <String> addManyBlankedLinesBetweenStrings(List <String> data) {
		Random random = new Random(System.currentTimeMillis());
		List <String> newData = getCopy(data);
		int size = data.size();
for (int i = 0; i < size; ++i) {
	newData.add(data.get(i));
	if (i < size - 1) {
	for (int j = random.nextInt(size); j >= 0; --j) {
		newData.add(EMPTY_STRING);
	}
	}
}
		return newData;
	}
	
}
