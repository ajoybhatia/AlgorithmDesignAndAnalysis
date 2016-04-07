package com.ajoy.algorithms.sorting.iterative;

import com.ajoy.algorithms.sorting.iterative.Sorter;

/**
 * Implementation of BubbleSort algorithm
 * 
 * @author Ajoy
 */
public class BubbleSort extends Sorter {

	/* (non-Javadoc)
	 * @see com.ajoy.algorithms.sorting.Sorter#sort(java.lang.Object[])
	 */
	@Override
	public int[] sort(int[] array) {
		// Nothing to do for null, empty array or single-element array
		if (array == null || array.length == 0 || array.length == 1) {
			return array;
		}
		
		int last = array.length - 1;
		
		// For each element of the array, from left to right, ...
		for (int i = 0; i < last; i++) {
			// ... bubble up the minimum of the remaining unsorted values
			for (int j = last; j > i; j--) {
				if (array[j-1] > array[j]) {
					exchange(array, j - 1, j);
				}
			}
		}
		return array;
	}
}
