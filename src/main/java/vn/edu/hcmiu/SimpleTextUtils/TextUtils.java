package vn.edu.hcmiu.SimpleTextUtils;

/**
 * @author Giang Nguyen
 * @Created on May 19th, 2017
 * @Last modified on May 19th, 2017
 *
 */
public class TextUtils {
	
	public static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
	
	public static boolean isBlank(String input) {
		return input == null || input.trim().isEmpty();
	}
	
	public static boolean isUppercase(String input) {
		return input != null && input.toUpperCase().equals(input);
	}
	
	public boolean isLowerCase(String input) {
		return input != null && input.toLowerCase().equals(input);
	}
	
	public static boolean isNumeric(String input) {
		return input != null && input.matches(Constants.NUMERIC_REGEX);
	}

}
