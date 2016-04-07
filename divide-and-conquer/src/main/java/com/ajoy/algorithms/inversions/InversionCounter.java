/**
 * Feb 8, 2015: InversionCounter
 * 
 * @author Ajoy Bhatia
 */

package com.ajoy.algorithms.inversions;

import java.util.Arrays;

import com.ajoy.algorithms.util.Utils;


public class InversionCounter {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Complete file path/name needed.");
			return;
		}
		int[] givenArray = Utils.readIntsFromFile(args[0]);
		System.out.println("Number of inversions = " + countInversions(givenArray));
	}
	
	/**
	 * Method to count number of inversions in a given array. A wrapper
	 * over the recursively called logic in sortAndCountInv(int[])
	 * 
	 * @param A array of integers whose inversions are to be counted
	 * 
	 * @return number of inversions in the array, i.e. number of pairs
	 *         of indices {@code i}, {@code j} such that {@code i < j}
	 *         AND {@code A[i] > A[j]}
	 */
	public static long countInversions(int[] A) {
		if (A == null) {
			return 0;
		}
		return sortAndCountInv(A).invCount;
	}
	
	/**
	 * Given an array of integers, uses the Divide-and-Conquer paradigm to
	 * return a sorted array and the number of inversions in the original
	 * array. Calls itself recursively over the left- and right-halves of the
	 * given array. Then combines the two sorted halves, keeping a running
	 * count of the split inversions, i.e. inversions with the greater value
	 * in the left-half and the lesser value in the right-half.
	 * 
	 * Complexity: O(N*logN)
	 * 
	 * @param A array of integers whose inversions are to be counted
	 */
	private static ArrayWithInversionCount sortAndCountInv(int[] A) {
		int len = A.length;
		if (len < 2) {
			// We have an empty or single element array.
			return new ArrayWithInversionCount(A, 0);
		}
		int[] ALeftHalf = Arrays.copyOfRange(A, 0, len/2);
		int[] ARightHalf = Arrays.copyOfRange(A, len/2, len);
		ArrayWithInversionCount B = sortAndCountInv(ALeftHalf);
		ArrayWithInversionCount C = sortAndCountInv(ARightHalf);
		ArrayWithInversionCount D = mergeAndCountSplitInv(B.array, C.array);
		
		return new ArrayWithInversionCount(D.array, B.invCount + C.invCount + D.invCount);
	}
	
	/**
	 * Merges two sorted integer arrays (as in mergesort), while keeping a running
	 * count of the number of inversions, i.e. pairs of indices {@code i}, {@code j}
	 * such that {@code B[i] > C[j]}
	 * 
	 * @param B a sorted integer array
	 * @param C another sorted integer array
	 * @return the merged sorted array and number of inversions found
	 */
	private static ArrayWithInversionCount mergeAndCountSplitInv(int[] B, int[] C) {
		int BLen = B.length;
		int CLen = C.length;
		
		int[] D = new int[BLen + CLen];
		long invCount = 0;
		
		for (int i = 0, j = 0; i < BLen || j < CLen; ) {
			if (i >= BLen) {
				D[i+j] = C[j];
				j++;
				continue;
			}
			if (j >= CLen) {
				D[i+j] = B[i];
				i++;
				continue;
			}
			if (B[i] < C[j]) {
				D[i+j] = B[i];
				i++;
			}
			else {
				D[i+j] = C[j];
				j++;
				// B[i] > C[j] => All other remaining values B[i+1] ... B[BLen-1] are greater than C[j]
				// So there are (BLen - i) inversions with C[j], i.e. number of elements of B still to
				// be traversed.
				invCount += (BLen - i);
			}
		}
		
		return new ArrayWithInversionCount(D, invCount);
	}
	
	/* Internal class to let us return sorted array and inversion count. */
	static class ArrayWithInversionCount {
		int[] array;
		long  invCount;
		
		ArrayWithInversionCount(int[] array, long invCount) {
			this.array = array;
			this.invCount = invCount;
		}
	}
}
