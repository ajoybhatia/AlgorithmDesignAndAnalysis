package com.ajoy.algorithms.sorting;

import com.ajoy.algorithms.sorting.iterative.Sorter;
import com.ajoy.algorithms.util.Utils;

public class QuickSort extends Sorter {
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Complete file path/name needed.");
			return;
		}
		int[] givenArray = Utils.readIntsFromFile(args[0]);
		Sorter sorter = new QuickSort();
		sorter.sort(givenArray);
	}
	
	@Override
	public int[] sort(int[] array) {
		// Nothing to do for null, empty array or single-element array
		if (array == null || array.length == 0 || array.length == 1) {
			return array;
		}
		quicksort(array, 0, array.length-1);
		return array;
	}

	/**
	 * Implementation of quicksort algorithm for sorting an array of unsorted comparable
	 * data values.
	 * 
	 * @param array	containing elements to be sorted
	 * @param left	index of the first element of the sub-array to be sorted
	 * @param right	index of the last element of the sub-array to be sorted
	 */
	private void quicksort(int[] array, int left, int right) {
		if (!(left < right)) {
			return;
		}
		int pivotIndex = choosePivotElement(array, left, right);
		exchange(array, left, pivotIndex);
		int finalPivotIndex = partition(array, left, right);
		
		quicksort(array, left, finalPivotIndex - 1);
		quicksort(array, finalPivotIndex + 1, right);
	}

	private int partition(int[] A, int left, int right) {
		int p = A[left];
		int i = left + 1;
		for (int j = left + 1; j < right + 1; j++) {
			if (A[j] < p) {
				exchange(A, i++, j);
			}
		}
		// Put the pivot element in its rightful place, and return that index.
		exchange(A, left, i - 1);
		return (i - 1);
	}

	/**
	 * Chooses the median of the first, last and midpoint elements as the pivot element.
	 * Implementation can be modified to experiment with different ways to choose the
	 * pivot element.
	 * 
	 * @param array	to be sorted
	 * @param left	index of the first element of the sub-array to be sorted
	 * @param right	index of the last element of the sub-array to be sorted
	 * @return		index of the chosen pivot element
	 */
	private int choosePivotElement(int[] array, int left, int right) {
		int mid = (left + right)/2;
		int a = array[left];
		int b = array[mid];
		int c = array[right];
		if ((a < b && b < c) || (c < b && b < a)) {
			return mid;
		}
		else if ((b < c && c < a) || (a < c && c < b)) {
			return right;
		}
		else {
			return left;
		}
	}
}
