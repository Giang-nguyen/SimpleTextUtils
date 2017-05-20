package vn.edu.hcmiu;

import static org.junit.Assert.assertEquals;
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
	public void isEmptyShouldWork() {
		assertTrue(TextUtils.isEmpty(NULL_STRING));
		assertTrue(TextUtils.isEmpty(EMPTY_STRING));
		assertFalse(TextUtils.isEmpty(WHITESPACE_STRING));
		assertFalse(TextUtils.isEmpty(MIX_STRING));
		assertFalse(TextUtils.isEmpty(UNTRIMMED_STRING));
			}
	
	@Test
	public void isBlankedShouldWork() {
		assertTrue(TextUtils.isBlank(NULL_STRING));
		assertTrue(TextUtils.isBlank(EMPTY_STRING));
		assertTrue(TextUtils.isEmpty(WHITESPACE_STRING));
		assertFalse(TextUtils.isEmpty(MIX_STRING));
		assertFalse(TextUtils.isEmpty(UNTRIMMED_STRING));
	
	}

}
