package vn.edu.hcmiu.SimpleTextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Giang Nguyen
 * @Created on October 26th, 2015
 * @Last modified on May 19th, 2017
 *
 */
public class TXTReader extends BufferedReader {

	/**
	 * @param path
	 * @throws FileNotFoundException
	 */
	public TXTReader(String path) throws FileNotFoundException {
		super(new InputStreamReader(new FileInputStream(new File(path))));
	}

	/**
	 * @param f
	 * @throws FileNotFoundException
	 */
	public TXTReader(File f) throws FileNotFoundException {
		super(new InputStreamReader(new FileInputStream(f)));
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
