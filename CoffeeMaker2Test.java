/* Authors: Evan Sheen, Cyrus Ramavarapu
Date: 12 February 2016
Purpose: JUnit tests for CoffeMakerQuest2 
*/

/* IMPORTANT: AT LEAST 3 TESTS NEED TO USE TEST DOUBLES
   			  AT LEAST 3 TESTS NEED TO USE TEST STUBS
			  */

/* TO SATISFY THE REQUIREMENT ABOVE IT IS LIKELY FURNITURE
   WILL HAVE TO BECOME ITS OWN CLASS */ 

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMaker2Test {



	// INVENTORY TESTS


	// ROOM TESTS

	/* A newly created room returns null if 
	   furniture is requested. Furniture has
	   not been set yet.
	   */
	@Test
	public void testEmptyRoom() {
		Room room_a = new Room();
		assertNull(room_a.getFurniture());
	}

	// INPUT TESTS

	/* Entering 'N', 'S', 'L', 'I', 'H', 'D' (VALID INPUT)
	   returns true */
	@Test
	public void testInput_N() {
		boolean input_1 = CoffeeMaker2.check_input("N");
		assertEquals(true, input_1);
	}
	
	@Test 
	public void testInput_D() {
		boolean input_1 = CoffeeMaker2.check_input("D");
		assertEquals(true, input_1);
	}

	/* Entering anything besides 'N', 'S', 'L', 'I', 'H', 'D'
	   returns false */
	@Test
	public void testInvalidInput() {
		boolean invalid_input = CoffeeMaker2.check_input("Q");
		assertEquals(false, invalid_input);
	}

	/* Entering a string where first character does not match
	   element of valid input set returns false */
	@Test
	public void testInvalidString() {
		boolean invalid_input = CoffeeMaker2.check_input("Zustandssumme");
		assertEquals(false, invalid_input);
	}	

	/* Entering a string where the first character is an
	   element of the valid input set returns false */
	@Test
	public void testFirstCharString() {
		boolean invalid_input = CoffeeMaker2.check_input("Daenerys");
		assertEquals(false, invalid_input);
	}

	/* Entering a element of valid input set is case insensitive
		and returns true */
	@Test
	public void testCaseInsensitivity() {
		boolean input_UC = CoffeeMaker2.check_input("S");
		boolean input_LC = CoffeeMaker2.check_input("s");

		assertEquals(true,  input_UC & input_LC);
	}

	// This is a dummy test (TO MAKE SURE THE LIBRARIES
   	// WORK 	
	/*
    @Test
	public void testEquals() {
		//Preconditions - a and b reference same object
		Room a = new Room();

		// Execution steps - reference a from new variable 
		Room b = a;

		// Postconditions / Expected behavior - assert that
		// a and b are the same
		assertSame(a, b);
	}
	*/


	// This main method runs our test suite (I think this is a test suite)
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CoffeeMaker2Test");
	}
}
