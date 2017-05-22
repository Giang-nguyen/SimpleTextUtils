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
	
	public static boolean isBlanked(String input) {
		return input == null || input.trim().isEmpty();
	}
	
	public static boolean isUppercase(String input) {
		return !isBlanked(input) && !isNumeric(input) && input.toUpperCase().equals(input);
	}
	
	public static boolean isLowercase(String input) {
		return !isBlanked(input) && !isNumeric(input) && input.toLowerCase().equals(input);
	}
	
	public static boolean isNumeric(String input) {
		return input != null && input.matches(Constants.NUMERIC_REGEX);
		}

	public static boolean isDigit(String input) {
		return input != null && input.matches(Constants.DIGIT_REGEX);
	}

}
