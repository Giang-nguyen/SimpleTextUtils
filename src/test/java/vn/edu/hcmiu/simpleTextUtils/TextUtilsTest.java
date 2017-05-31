package vn.edu.hcmiu.simpleTextUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static vn.edu.hcmiu.simpleTextUtils.utils.Constants.*;

import org.junit.Test;

/**
 * @author Giang Nguyen
 * @Created on May 20th, 2017
 * @Last modified on May 20th, 2017
 *
 */
public class TextUtilsTest {
	
	@Test
	public void isEmptyShouldReturnTrue() {
		assertTrue(TextUtils.isEmpty(NULL_STRING));
		assertTrue(TextUtils.isEmpty(EMPTY_STRING));
	}
	
	@Test
	public void isEmptyShouldReturnFalse() {
		assertFalse(TextUtils.isEmpty(WHITESPACE_STRING));
		assertFalse(TextUtils.isEmpty(MIX_STRING));
		assertFalse(TextUtils.isEmpty(UNTRIMMED_STRING));
			}
	
	@Test
	public void isBlankedShouldReturnTrue() {
		assertTrue(TextUtils.isBlanked(NULL_STRING));
		assertTrue(TextUtils.isBlanked(EMPTY_STRING));
		assertTrue(TextUtils.isBlanked(WHITESPACE_STRING));
	}
	
	@Test
	public void isBlankedShouldReturnFalse() {
		assertFalse(TextUtils.isBlanked(MIX_STRING));
		assertFalse(TextUtils.isBlanked(UNTRIMMED_STRING));
		}
	
	@Test
	public void isUppercaseShouldReturnTrue() {
		assertTrue(TextUtils.isUppercase(UPPERCASE_STRING));
	}
	
	@Test
	public void isUppercaseShouldReturnFalse() {
		assertFalse(TextUtils.isUppercase(LOWERCASE_STRING));
		assertFalse(TextUtils.isUppercase(MIX_CASE_STRING));
		assertFalse(TextUtils.isUppercase(NULL_STRING));
		assertFalse(TextUtils.isUppercase(EMPTY_STRING));
		assertFalse(TextUtils.isUppercase(WHITESPACE_STRING));
		assertFalse(TextUtils.isUppercase(MANY_DIGIT_STRING));
	}

@Test	
	public void isLowercaseShouldReturnTrue() {
		assertTrue(TextUtils.isLowercase(LOWERCASE_STRING));
}

@Test	
public void isLowercaseShouldReturnFalse() {
		assertFalse(TextUtils.isLowercase(UPPERCASE_STRING));
		assertFalse(TextUtils.isLowercase(MIX_CASE_STRING));
		assertFalse(TextUtils.isLowercase(NULL_STRING));
		assertFalse(TextUtils.isLowercase(EMPTY_STRING));
		assertFalse(TextUtils.isLowercase(WHITESPACE_STRING));
		assertFalse(TextUtils.isLowercase(MANY_DIGIT_STRING));
	}
	
	@Test
	public void IsDigitShouldReturnTrue() {
assertTrue(TextUtils.isDigit(ONE_DIGIT_STRING));
assertTrue(TextUtils.isDigit(MANY_DIGIT_STRING));
	}
	
	@Test
	public void IsDigitShouldReturnFalse() {
		assertFalse(TextUtils.isDigit(NULL_STRING));
		assertFalse(TextUtils.isDigit(EMPTY_STRING));
		assertFalse(TextUtils.isDigit(MIX_STRING));
		assertFalse(TextUtils.isDigit(WHITESPACE_STRING));
		assertFalse(TextUtils.isDigit(FLOAT_STRING));
	}
	
@Test
public void isNumericShouldReturnTrue() {
	assertTrue(TextUtils.isNumeric(FLOAT_STRING));
	assertTrue(TextUtils.isNumeric(POSITIVE_FLOAT_STRING));
	assertTrue(TextUtils.isNumeric(NEGATIVE_FLOAT_STRING));
	assertTrue(TextUtils.isNumeric(ONE_DIGIT_STRING));
	assertTrue(TextUtils.isNumeric(MANY_DIGIT_STRING));
	assertTrue(TextUtils.isNumeric(POSITIVE_INTEGER_STRING));
	assertTrue(TextUtils.isNumeric(NEGATIVE_INTEGER_STRING));
}

public void isNumericShouldReturnFalse() {
assertFalse(TextUtils.isNumeric(NULL_STRING));	
assertFalse(TextUtils.isNumeric(EMPTY_STRING));
assertFalse(TextUtils.isNumeric(MIX_STRING));	
assertFalse(TextUtils.isNumeric(FAKE_FLOAT_STRING));	
assertFalse(TextUtils.isNumeric(COMMA_FLOAT_STRING));
assertFalse(TextUtils.isNumeric(MIX_SIGN_FLOAT_STRING));
assertFalse(TextUtils.isNumeric(WRONG_SIGN_FLOAT_STRING));	
}

@Test
public void IsLetterShouldReturnTrue() {
	assertTrue(TextUtils.isLetter(UPPERCASE_STRING));
	assertTrue(TextUtils.isLetter(LOWERCASE_STRING));
	assertTrue(TextUtils.isLetter(MIX_CASE_STRING));
}

@Test
public void IsLetterShouldReturnFalse() {
	assertFalse(TextUtils.isLetter(NULL_STRING));

assertFalse(TextUtils.isLetter(ONE_DIGIT_STRING));
assertFalse(TextUtils.isLetter(MANY_DIGIT_STRING));
	assertFalse(TextUtils.isLetter(NULL_STRING));
	assertFalse(TextUtils.isLetter(EMPTY_STRING));
	assertFalse(TextUtils.isLetter(MIX_STRING));
	assertFalse(TextUtils.isLetter(WHITESPACE_STRING));
	assertFalse(TextUtils.isLetter(FLOAT_STRING));
	assertFalse(TextUtils.isLetter(ALPHANUMERIC_STRING1));
	assertFalse(TextUtils.isLetter(ALPHANUMERIC_STRING2));
	assertFalse(TextUtils.isLetter(ALPHANUMERIC_STRING3));
	assertFalse(TextUtils.isLetter(WORD_STRING));

}

@Test
public void IsWordShouldReturnTrue() {
assertTrue(TextUtils.isWord(WORD_STRING));
assertTrue(TextUtils.isWord(ONE_DIGIT_STRING));
assertTrue(TextUtils.isWord(MANY_DIGIT_STRING));
assertTrue(TextUtils.isWord(MIX_CASE_STRING));
assertTrue(TextUtils.isWord(ALPHANUMERIC_STRING3));
}

@Test
public void IsWordShouldReturnFalse() {
	assertFalse(TextUtils.isWord(NULL_STRING));
	assertFalse(TextUtils.isWord(EMPTY_STRING));
	assertFalse(TextUtils.isWord(MIX_STRING));
	assertFalse(TextUtils.isWord(WHITESPACE_STRING));
	assertFalse(TextUtils.isWord(FLOAT_STRING));
}


@Test
public void IsAlphanumericShouldReturnTrue() {
assertTrue(TextUtils.isAlphanumeric(ALPHANUMERIC_STRING1));
assertTrue(TextUtils.isAlphanumeric(ALPHANUMERIC_STRING2));
assertTrue(TextUtils.isAlphanumeric(ALPHANUMERIC_STRING3));
assertTrue(TextUtils.isAlphanumeric(ALPHANUMERIC_STRING4));
assertTrue(TextUtils.isAlphanumeric(ONE_DIGIT_STRING));
assertTrue(TextUtils.isAlphanumeric(MANY_DIGIT_STRING));
assertTrue(TextUtils.isAlphanumeric(MIX_CASE_STRING));
}

@Test
public void IsAlphanumericShouldReturnFalse() {
	assertFalse(TextUtils.isAlphanumeric(NULL_STRING));
	assertFalse(TextUtils.isAlphanumeric(NULL_STRING));
	assertFalse(TextUtils.isAlphanumeric(EMPTY_STRING));
	assertFalse(TextUtils.isAlphanumeric(MIX_STRING));
	assertFalse(TextUtils.isAlphanumeric(WHITESPACE_STRING));
	assertFalse(TextUtils.isAlphanumeric(FLOAT_STRING));
}


@Test
public void isPalindromeShouldReturnTrue() {
	assertTrue(TextUtils.isPalindrome(EMPTY_STRING));
	assertTrue(TextUtils.isPalindrome(ONE_DIGIT_STRING));

	assertTrue(TextUtils.isPalindrome(PALINDROME_STRING));
	assertTrue(TextUtils.isPalindrome(PALINDROME_EVEN_STRING));
	assertTrue(TextUtils.isPalindrome(PALINDROME_2_STRING));
}


@Test
public void isPalindromeShouldReturnFalse() {
	assertFalse(TextUtils.isPalindrome(NULL_STRING));
	assertFalse(TextUtils.isPalindrome(FLOAT_STRING));
	assertFalse(TextUtils.isPalindrome(WHITESPACE_STRING));
	assertFalse(TextUtils.isPalindrome(MIX_CASE_STRING));
	assertFalse(TextUtils.isPalindrome(TWO_DIGIT_STRING));
}


@Test
public void reverseShouldWork() {
	assertEquals(NULL_STRING, TextUtils.reverse(NULL_STRING));
	assertEquals(EMPTY_STRING, TextUtils.reverse(EMPTY_STRING));
	assertEquals(ONE_DIGIT_STRING, TextUtils.reverse(ONE_DIGIT_STRING));
	assertEquals(REVERSED_ALPHANUMERIC_STRING1, TextUtils.reverse(ALPHANUMERIC_STRING1));
	assertEquals(REVERSED_ALPHANUMERIC_STRING4, TextUtils.reverse(ALPHANUMERIC_STRING4));
	assertEquals(REVERSED_MIX_CASE_STRING, TextUtils.reverse(MIX_CASE_STRING));
}

}
