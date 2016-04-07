package com.ajoy.algorithms.sorting;

import com.ajoy.algorithms.sorting.iterative.Sorter;

public class MergeSort extends Sorter {

	@Override
	public int[] sort(int[] array) {
		// Nothing to do for null, empty array or single-element array
		if (array == null || array.length == 0 || array.length == 1) {
			return array;
		}
		
		return mergesort(array, 0, array.length - 1);
	}

	private int[] mergesort(int[] array, int left, int right) {
		if (left >= right) {
			return new int[] { array[left] };
		}
		// Sort the left half and the right half.
		int mid = (left+right)/2;
		int[] A = mergesort(array, left, mid);
		int[] B = mergesort(array, mid + 1, right);
		
		// Now, merge the two sorted halves.
		int[] C = new int[right-(left-1)];
		mergeAB(C, A, mid-left+1, B, right - mid);
		return C;
	}
	
	private void mergeAB(int[] C, int[] A, int numA, int[] B, int numB) {
		for (int i = 0, j = 0, k = 0; k < numA + numB; k++) {
			if (i == numA) {
				C[k] = B[j++];
				continue;
			}
			if (j == numB) {
				C[k] = A[i++];
				continue;
			}
			C[k] = (A[i] < B[j]) ? A[i++] : B[j++];
		}
	}
}
