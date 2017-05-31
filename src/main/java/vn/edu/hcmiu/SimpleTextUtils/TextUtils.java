package vn.edu.hcmiu.simpleTextUtils;

/**
 * @author Giang Nguyen
 * This class provide convenient method to validate String object
 * 
 */
public class TextUtils {
	
	/**
	 * Check if a string is empty or null
	 * @param input The string to check
	 * @return true if the string is null or empty, false otherwise
	 */
	public static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
	
	
	/**
	 * Check if a string is empty or contains only whitespace characters
	 * @param input The string to check
	 * @return True if the string is null, is empty, or contains only whitespace character such as space or new line character, false otherwise
	 */
	public static boolean isBlanked(String input) {
		return input == null || input.trim().isEmpty();
	}
	
	
	/**
	 * Check if a string is uppercase or not
	 * @param input The string to check
	 * @return True if the string is all uppercase, false otherwise
	 */
	public static boolean isUppercase(String input) {
		return !isBlanked(input) && !isNumeric(input) && input.toUpperCase().equals(input);
	}
	

	/**
	 * Check if a string is lowercase or not
	 * @param input The string to check
	 * @return True if the string is all lowercase, false otherwise
	 */
	public static boolean isLowercase(String input) {
		return !isBlanked(input) && !isNumeric(input) && input.toLowerCase().equals(input);
	}
	
	
	/**
	 * Check if a string represent a number
	 * @param input The string to check
	 * @return True if it is a floating point number or integer, false otherwise. Plus (+) or minus (-) sign are allowed.
	 */
	public static boolean isNumeric(String input) {
		return input != null && input.matches(Constants.NUMERIC_REGEX);
		}

	
	/**
	 * Check if a string only contains digits
	 * @param input The string to check
	 * @return True if the string only contains digits, false otherwise
	 */
	public static boolean isDigit(String input) {
		return input != null && input.matches(Constants.DIGIT_REGEX);
	}
	
	
	/**
	 * Check if a string contains only digits and letters
	 * @param input The string to check
	 * @return true if the string only contains digits and letters, false otherwise
	 */
	public static boolean isAlphanumeric(String input) {
		return input != null && input.matches(Constants.ALPHANUMERIC_REGEX);
	}
	
	
	/**
	 * Check if a string only contains letters
	 * @param input The string to check
	 * @return true if the string only contains letters, false otherwise
	 */
	public static boolean isLetter(String input) {
		return input != null && input.matches(Constants.ALPHABET_REGEX);
	}
	
	
	/**
	 * Check if a string only contains words
	 * @param input The string to check
	 * @return true if the string only contains letters, digit, underline, and space, false otherwise
	 */
	public static boolean isWord(String input) {
		return input != null && input.matches(Constants.WORD_REGEX);
	}
	
	
	/**
	 * Check if a string is a palindrome
	 * @param input The string to check
	 * @return true if the string is the same as its reverse string, false otherwise
	 */
	public static boolean isPalindrome(String input) {
		if (input == null) {
			return false;
		}
		
		for (int i = 0, j = input.length() - 1; i < j; ++i, --j) {
			if (input.charAt(i) != input.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	
	
/**
 * Reverse a string
 * @param input The string to reverse
 * @return The reversed string
 */
public static String reverse(String input) {
	return input == null ? null : (new StringBuilder(input)).reverse().toString();
}
	
}
