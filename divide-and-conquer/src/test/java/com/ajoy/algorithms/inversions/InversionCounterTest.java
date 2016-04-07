/**
 * Feb 8, 2015: InversionCounterTest
 * 
 * @author Ajoy Bhatia
 */

package com.ajoy.algorithms.inversions;

import static org.junit.Assert.*;

import org.junit.Test;

public class InversionCounterTest {

	@Test
	public void testCountInversionsNull() {
		long invCount = InversionCounter.countInversions(null);
		assertEquals(0, invCount);
	}
	
	@Test
	public void testCountInversionsEmpty() {
		long invCount = InversionCounter.countInversions(new int[]{});
		assertEquals(0, invCount);
	}
	
	@Test
	public void testCountInversions1() {
		int[] A = { 1, 2, 3, 4, 5, 6 };
		long invCount = InversionCounter.countInversions(A);
		assertEquals(0, invCount);
	}
	
	@Test
	public void testCountInversions2() {
		int[] A = { 6, 5, 4, 3, 2, 1 };
		long invCount = InversionCounter.countInversions(A);
		assertEquals(15, invCount);
	}
	
	@Test
	public void testCountInversions3() {
		int[] A = { 1, 3, 5, 2, 4, 6 };
		long invCount = InversionCounter.countInversions(A);
		assertEquals(3, invCount);
	}

	@Test
	public void testCountInversions4() {
		int[] A = { 1, 6, 2, 3, 4, 5 };
		long invCount = InversionCounter.countInversions(A);
		assertEquals(4, invCount);
	}
	
	@Test
	public void testCountInversions5() {
		int[] A = { 5, 1, 6, 2, 3, 4 };
		long invCount = InversionCounter.countInversions(A);
		assertEquals(7, invCount);
	}
	
	@Test
	public void testCountInversions6() {
		int[] A = { 3, 2, 1 };
		long invCount = InversionCounter.countInversions(A);
		assertEquals(3, invCount);
	}
}
