package com.ajoy.algorithms.sorting.iterative;

public abstract class Sorter {
	
	/**
	 * Returns the given array with its values in sorted order. Although the given array
	 * is the one that is sorted and does not need to be returned, returning it allows
	 * other operations on the array to be chained, e.g. sorter.sort(array).clone()
	 * 
	 * @param array	the array to be sorted
	 * @return	the same array but now sorted
	 */
	public abstract int[] sort(int[] array);
	
	protected void exchange(int[] array, int i, int j) {
		int last = array.length - 1;
		if (i < 0 || i > last || j < 0 || j > last) {
			throw new IllegalArgumentException("Invalid array index");
		}

		if (i == j) {
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
