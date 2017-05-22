package vn.edu.hcmiu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static vn.edu.hcmiu.Constants.*;

import org.junit.Test;

import vn.edu.hcmiu.SimpleTextUtils.TextUtils;

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

}
