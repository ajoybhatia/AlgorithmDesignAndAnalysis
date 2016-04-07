package com.ajoy.algorithms.sorting.iterative;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SorterTest {

	private static final Sorter sorter = new BubbleSort();

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
