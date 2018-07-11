package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

	// NOT THE RIGHT WAY!
	// int expected = 2;
	// Unit unit = new Unit();
	// int actual = unit.add(1, 1);
	// // compare those 2 values.
	//
	// if (actual == expected) {
	// System.out.println("pass");
	// } else {
	// System.out.println("fail");
	// }
	@Test
	public void addTest() {
		int expected = 2;
		Unit unit = new Unit();
		int actual = unit.add(1, 1);
		Assert.assertEquals(actual, expected);
	}

}
