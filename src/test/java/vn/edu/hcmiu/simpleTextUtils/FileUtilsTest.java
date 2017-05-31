package vn.edu.hcmiu.simpleTextUtils;

import static org.junit.Assert.assertEquals;
import static vn.edu.hcmiu.simpleTextUtils.utils.Constants.EMPTY_STRING;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vn.edu.hcmiu.simpleTextUtils.utils.FileFactory;

public class FileUtilsTest {
	
	private List <String> data;
	private  String lastLine;

	@Before
	public void init() {
		data = FileFactory.getSolidFileData();
		lastLine = data.get(data.size() - 1);
	}
	
	@Test
	public void getLastLineShouldReturnLastLine() throws IOException {
		// File with no blanked line
		File file = FileFactory.getFileWithData(data);
		assertEquals(lastLine, FileUtils.getLastLine(file));
		file.delete();

		// File with  blanked lines
		file = FileFactory.getFileWithData(FileFactory.addBlankedLineBetweenStrings(data));
		assertEquals(lastLine, FileUtils.getLastLine(file));
		file.delete();

		// File with  consecutive blanked lines
		file = FileFactory.getFileWithData(FileFactory.addManyBlankedLinesBetweenStrings(data));
		assertEquals(lastLine, FileUtils.getLastLine(file));
		file.delete();
		
		// File with  one blanked line at the end
		file = FileFactory.getFileWithData(FileFactory.addBlankedLineToTheEnd(data));
		assertEquals(lastLine, FileUtils.getLastLine(file));
		file.delete();
		
		// File with many lines between and at the end
		file = FileFactory.getFileWithData(FileFactory.addManyBlankedLinesBetweenStrings(FileFactory.addManyBlankedLinesToTheEnd(data)));
		assertEquals(lastLine, FileUtils.getLastLine(file));
		file.delete();
	}
	
	@Test
	public void getLastLineShouldReturnEmptyString() throws IOException {
		// Empty file
		File file = FileFactory.getEmptyFile();
		assertEquals(EMPTY_STRING, FileUtils.getLastLine(file));
		file.delete();
		
		// File with only one blank line
		file = FileFactory.getFileWithData(FileFactory.getBlankedFileData());
		assertEquals(EMPTY_STRING, FileUtils.getLastLine(file));
		file.delete();

		// File with only  blank lines
		file = FileFactory.getFileWithData(FileFactory.getLargeBlankedFileData());
		assertEquals(EMPTY_STRING, FileUtils.getLastLine(file));
		file.delete();
}
	
	public void cleanBlankedLinesShouldWork() throws IOException {
		// File with no blanked line
		File file = FileFactory.getFileWithData(data);
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();

		// File with  blanked lines
		file = FileFactory.getFileWithData(FileFactory.addBlankedLineBetweenStrings(data));
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();

		// File with  consecutive blanked lines
		file = FileFactory.getFileWithData(FileFactory.addManyBlankedLinesBetweenStrings(data));
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();
		
		// File with  one blanked line at the end
		file = FileFactory.getFileWithData(FileFactory.addBlankedLineToTheEnd(data));
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();
		
		// File with many lines between and at the end
		file = FileFactory.getFileWithData(FileFactory.addManyBlankedLinesBetweenStrings(FileFactory.addManyBlankedLinesToTheEnd(data)));
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();

		// Empty file
		file = FileFactory.getEmptyFile();
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();
		
		// File with only one blank line
		file = FileFactory.getFileWithData(FileFactory.getBlankedFileData());
		FileUtils.cleanBlankLines(file);
		check(file);
		file.delete();

		// File with only  blank lines
		file = FileFactory.getFileWithData(FileFactory.getLargeBlankedFileData());
		FileUtils.cleanBlankLines(file);
check(file);
		file.delete();
	}
	
	private void check(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
for (String str : data) {
	assertEquals(str, reader.readLine());
}
	reader.close();}

}
