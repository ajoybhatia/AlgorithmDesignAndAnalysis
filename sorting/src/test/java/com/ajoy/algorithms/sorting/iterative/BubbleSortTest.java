/**
 * Feb 19, 2015: BubbleSortTest
 * 
 * @author Ajoy Bhatia
 */
package com.ajoy.algorithms.sorting.iterative;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.ajoy.algorithms.sorting.iterative.Sorter;

public class BubbleSortTest {

	static Sorter sorter = new BubbleSort();
	
	@Test
	public void testSortNull() {
		int[] retVal = sorter.sort(null);
		assertNull(retVal);
	}
	
	@Test
	public void testSortEmpty() {
		int[] array = new int[] {};
		int[] retVal = sorter.sort(array);
		assertTrue(retVal == array);
		assertTrue(Arrays.equals(retVal, new int[] {}));
	}
	
	@Test
	public void testSortSingle() {
		int[] array = {2};
		int[] retVal = sorter.sort(array);
		assertTrue(retVal == array);
		assertTrue(Arrays.equals(retVal, new int[] {2}));
	}
	
	@Test
	public void testSort1() {
		int[] array = { 5, 3, 2, 4, 1 };
		sorter.sort(array);
		assertTrue(Arrays.equals(array, new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	public void testSort2() {
		int[] array = { 1, 2, 3, 4, 5 };
		sorter.sort(array);
		assertTrue(Arrays.equals(array, new int[] { 1, 2, 3, 4, 5 }));
	}
	
	@Test
	public void testSort3() {
		int[] array = { 43, 2, 45, 50, 21, 15 };
		sorter.sort(array);
		assertTrue(Arrays.equals(array, new int[] { 2, 15, 21, 43, 45, 50 }));
	}
	
	@Test
	public void testExchangeIllegalArgs() {
		try {
			sorter.exchange(new int[] { 2, 5, 76, 3 }, -1, 2);
		}
		catch (IllegalArgumentException e) {
			// Exception thrown, as expected
			return;
		}
		// Should not get here, if the expected exception was thrown
		fail("Expected exception was not thrown");
	}
	
	@Test
	public void testExchangeSelf() {
		int[] array = { 2, 5, 76, 3 };
		sorter.exchange(array, 2, 2);
		assertTrue(Arrays.equals(array, new int[]{ 2, 5, 76, 3 }));
	}
}
