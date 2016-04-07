/**
 * Feb 19, 2015: MergeSortTest
 * 
 * @author Ajoy Bhatia
 */
package com.ajoy.algorithms.sorting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.ajoy.algorithms.sorting.iterative.Sorter;

public class MergeSortTest {

	static Sorter sorter = new MergeSort();
	
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
		int[] sortedArray = sorter.sort(array);
		assertTrue(Arrays.equals(sortedArray, new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	public void testSort2() {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] sortedArray = sorter.sort(array);
		assertTrue(Arrays.equals(sortedArray, new int[] { 1, 2, 3, 4, 5 }));
	}
	
	@Test
	public void testSort3() {
		int[] array = { 43, 2, 45, 50, 21, 15 };
		int[] sortedArray = sorter.sort(array);
		assertTrue(Arrays.equals(sortedArray, new int[] { 2, 15, 21, 43, 45, 50 }));
	}
}
