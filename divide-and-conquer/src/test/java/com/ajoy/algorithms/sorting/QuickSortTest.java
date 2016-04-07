package com.ajoy.algorithms.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.ajoy.algorithms.sorting.iterative.Sorter;

public class QuickSortTest {

	static Sorter sorter = new QuickSort();
	
	@Test
	public void testSort1() {
		int[] array = {3, 1, 56, 23, 4};
		sorter.sort(array);
		assertTrue(Arrays.equals(array, new int[] {1, 3, 4, 23, 56}));
	}

	@Test
	public void testSort2() {
		int[] array = {7, 3, 8, 4, 6, 5, 2, 1};
		sorter.sort(array);
		assertTrue(Arrays.equals(array, new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
	}
}
