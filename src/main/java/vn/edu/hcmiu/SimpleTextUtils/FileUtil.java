package vn.edu.hcmiu.SimpleTextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giang Nguyen
 * @Created on October 26th, 2015
 * @Last modified on May 19th, 2017
 *
 */
public class FileUtil {

	/**
	 * Returns the last line from a given text file. This method is particularly
	 * well suited for very large text files that contain millions of text lines
	 * since it will just seek the end of the text file and seek the last line
	 * indicator. Please use only for large sized text files.
	 * 
	 * @param file
	 *            A file on disk
	 * @return The last line or an empty string if nothing was found
	 * 
	 * @author Nuno Brito
	 * @author Michael Schierl
	 * @throws IOException
	 * @license MIT
	 * @date 2014-11-01
	 */
	public static String getLastLine(final File file) throws IOException {

		// file needs to exist
		if (file.exists() == false || file.isDirectory()) {
			return "";
		}

		// avoid empty files
		if (file.length() <= 2) {
			return "";
		}

		// open the file for read-only mode
		try (RandomAccessFile fileAccess = new RandomAccessFile(file, "r")) {
			char breakLine = '\n';
			// offset of the current filesystem block - start with the last one
			long blockStart = (file.length() - 1) / 4096 * 4096;
			// hold the current block
			byte[] currentBlock = new byte[(int) (file.length() - blockStart)];
			// later (previously read) blocks
			List<byte[]> laterBlocks = new ArrayList<byte[]>();

			while (blockStart >= 0) {

				fileAccess.seek(blockStart);
				fileAccess.readFully(currentBlock);
				// ignore the last 2 bytes of the block if it is the first one
				int lengthToScan = currentBlock.length - (laterBlocks.isEmpty() ? 2 : 0);
				for (int i = lengthToScan - 1; i >= 0; i--) {
					if (currentBlock[i] == breakLine) {
						// we found our end of line!
						StringBuilder result = new StringBuilder();
						// RandomAccessFile#readLine uses ISO-8859-1, therefore
						// we do here too
						result.append(new String(currentBlock, i + 1, currentBlock.length - (i + 1), "ISO-8859-1"));
						for (byte[] laterBlock : laterBlocks) {
							result.append(new String(laterBlock, "ISO-8859-1"));
						}
						// maybe we had a newline at end of file? Strip it.
						if (result.charAt(result.length() - 1) == breakLine) {
							// newline can be \r\n or \n, so check which one to
							// strip
							int newlineLength = result.charAt(result.length() - 2) == '\r' ? 2 : 1;
							result.setLength(result.length() - newlineLength);
						}
						if (result.toString().equals(""))
							result.append(tryTail(file));
						return result.toString();
					}
				}
				// no end of line found - we need to read more
				laterBlocks.add(0, currentBlock);
				blockStart -= 4096;
				currentBlock = new byte[4096];
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// oops, no line break found or some exception happened
		return tryTail(file);
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static String tryTail(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (!line.equals("")) {
				reader.close();
				reader = null;
				return line;
			}
		}
		if (reader != null) {
			reader.close();
		}
		return "";
	}
	
	public static String getLastLine(String path) throws IOException {
		return getLastLine(new File(path));
	}
	
	public static void cleanBlankLines(String path) throws IOException {
		cleanBlankLines(new File(path));
	}
	
	public static void cleanBlankLines(File input) throws IOException {
		File output = new File(input.getParent() + "\\output" + input.getName());
		TXTReader reader = new TXTReader(input);
		TXTWriter writer = new TXTWriter(output);
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (!TextUtils.isEmpty(line)) {
			writer.write(line);
			}
		}
				writer.close();
				reader.close();
				input.delete();
				output.renameTo(input);
	}
	
	public static void cleanBlankLinesForManyFiles(String dir) {
		cleanBlankLinesForManyFiles(new File(dir));
	}
	
	public static void cleanBlankLinesForManyFiles(File root) {
		for (String dir : root.list()) {
			cleanBlankLines(dir);
		}
	}

}