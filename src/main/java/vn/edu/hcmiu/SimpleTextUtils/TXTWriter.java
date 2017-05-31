package vn.edu.hcmiu.simpleTextUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author Giang Nguyen
 * @Created on October 26th, 2015
 * @Last modified on May 19th, 2017
 *
 */
public class TXTWriter extends BufferedWriter {

	/**
	 * @param path
	 * @throws FileNotFoundException
	 */
	public TXTWriter(String path) throws FileNotFoundException {
		this(new File(path));
	}

	/**
	 * @param f
	 * @throws FileNotFoundException
	 */
	public TXTWriter(File f) throws FileNotFoundException {
		super(new OutputStreamWriter(new FileOutputStream(f, true)));
	}

}
