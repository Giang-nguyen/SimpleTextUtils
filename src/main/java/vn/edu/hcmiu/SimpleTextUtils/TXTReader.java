package vn.edu.hcmiu.SimpleTextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author Giang Nguyen
 * Extended function for BufferedReader
 *
 */
public class TXTReader extends BufferedReader {

	/**
	 * @param path The file directory
	 * @throws FileNotFoundException If the file at the provided location does not exist
	 * @throws UnsupportedEncodingException 
	 */
	public TXTReader(String path) throws FileNotFoundException, UnsupportedEncodingException {
this(new File(path));
	}

	/**
	 * @param path
	 * @param charset
	 * @throws FileNotFoundException If the file at the provided location does not exist
	 * @throws UnsupportedEncodingException
	 */
	public TXTReader(String path, String charset) throws FileNotFoundException, UnsupportedEncodingException {
		this(new File(path), charset);
	}
	
	/**
	 * @param f
	 * @throws FileNotFoundException If the file at the provided location does not exist
	 * @throws UnsupportedEncodingException
	 */
	public TXTReader(File f) throws FileNotFoundException, UnsupportedEncodingException {
		this(f, "UTF-8");
	}
	
	/**
	 * @param f
	 * @throws FileNotFoundException If the file at the provided location does not exist
	 * @throws UnsupportedEncodingException 
	 */
	public TXTReader(File f, String charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(new InputStreamReader(new FileInputStream(f), charset));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.BufferedReader#readLine()
	 */
	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		if (line != null) {
			line = line.trim();
		}
		return line;
	}

}
