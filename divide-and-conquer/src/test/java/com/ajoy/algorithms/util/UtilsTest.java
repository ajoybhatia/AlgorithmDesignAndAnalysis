/**
 * Feb 8, 2015: UtilsTest
 * 
 * @author Ajoy Bhatia
 */

package com.ajoy.algorithms.util;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

	/**
	 * Test method for {@link com.ajoy.algorithms.util.Utils#readIntsFromFile(java.lang.String)}.
	 */
	@Test
	public void testReadIntsFromFile() {
		int[] intsArray = Utils.readIntsFromFile("utilsTestInput.txt");
		assertEquals(5, intsArray.length);
		assertTrue(Arrays.equals(new int[]{ 23, 12, 4, 94, 9 }, intsArray));
	}
}
