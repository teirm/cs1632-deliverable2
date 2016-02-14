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

import java.util.ArrayList;
import org.mockito.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMaker2Test {

	// INVENTORY TESTS

	/* An empty inventory returns 0 indicating that user
	   has not acquired any items */ 
	@Test
	public void testDisplayEmptyInventory() {
		
		int ret_val;	
		ArrayList<String> empty_inv = new ArrayList<String>();
			
		ret_val = CoffeeMaker2.display_inventory(empty_inv);
		assertEquals(0, ret_val);
	}

	/* An inventory returns 1 indicating that user
	   has acquired ONLY Coffee */ 
	@Test
	public void testDisplayCoffeeInventory() {
		
		int ret_val;
		ArrayList<String> coffee_inv = new ArrayList<String>();
		coffee_inv.add("Coffee");		
		ret_val = CoffeeMaker2.display_inventory(coffee_inv);
		assertEquals(1, ret_val);
	}
		
	/* An inventory returns 2 indicating that user
	   has acquired ONLY Cream */ 
	@Test
	public void testDisplayCreamInventory() {
		int ret_val;
		ArrayList<String> cream_inv = new ArrayList<String>();
		cream_inv.add("Cream");		
		ret_val = CoffeeMaker2.display_inventory(cream_inv);
		assertEquals(2, ret_val);
	}

	/* An inventory returns 4 indicating that user
	   has acquired ONLY Sugar */ 
	@Test
	public void testDisplaySugarInventory() {
		int ret_val;
		ArrayList<String> sugar_inv = new ArrayList<String>();
		sugar_inv.add("Sugar");		
		ret_val = CoffeeMaker2.display_inventory(sugar_inv);
		assertEquals(4, ret_val);
	}


	/* An inventory returns 5 indicating that user
	   has acquired ONLY Coffee and Sugar */ 
	@Test
	public void testDisplayCoffeeSugarInventory() {
		int ret_val;
		ArrayList<String> inv = new ArrayList<String>();
		inv.add("Sugar");
		inv.add("Coffee");		
		ret_val = CoffeeMaker2.display_inventory(inv);
		assertEquals(5, ret_val);
	}

	/* An inventory returns 5 indicating that user
	   has acquired ONLY Coffee and Cream */ 
	@Test
	public void testDisplayCoffeeCreamInventory() {
		int ret_val;
		ArrayList<String> inv = new ArrayList<String>();
		inv.add("Cream");
		inv.add("Coffee");		
		ret_val = CoffeeMaker2.display_inventory(inv);
		assertEquals(3, ret_val);
	}

	/* An inventory returns 6 indicating that user
	   has acquired ONLY Sugar and Cream */ 
	@Test
	public void testDisplaySugarCreamInventory() {
		int ret_val;
		ArrayList<String> inv = new ArrayList<String>();
		inv.add("Sugar");
		inv.add("Cream");		
		ret_val = CoffeeMaker2.display_inventory(inv);
		assertEquals(6, ret_val);
	}

	/* An inventory returns 7 indicating that user
	   has acquired All three items (Coffee, Sugar, Cream) */ 
	@Test
	public void testDisplayFullInventory() {
		int ret_val;
		ArrayList<String> inv = new ArrayList<String>();
		inv.add("Sugar");
		inv.add("Cream");		
		inv.add("Coffee");	
		ret_val = CoffeeMaker2.display_inventory(inv);
		assertEquals(7, ret_val);
	}

	/* An empty bag if contents are drunk should return
	   0 */
	@Test
	public void testProcessEmptyBag() {
		int ret_val;
		ret_val = CoffeeMaker2.process_bag(0);
		assertEquals(0, ret_val);
	}

	/* A full bag if contents are drunk should return
	   1 */
	@Test
	public void testFullBag() {
		int ret_val;
		ret_val = CoffeeMaker2.process_bag(7);
		assertEquals(1, ret_val);
	}

	/* A negative bag returns -1 */
	@Test
	public void testNegativeBag() {
		int ret_val;
		ret_val = CoffeeMaker2.process_bag(-20);
		assertEquals(-1, ret_val);
	}

	/* A bag too large returns -1 */
	@Test
	public void testOverSizedBag() {
		int ret_val;
		ret_val = CoffeeMaker2.process_bag(30);
		assertEquals(-1, ret_val);
	}	

	// MOVEMENT TESTS

	/* Moving north when in between the end points is valid 
	   and should return true. The index for these rooms
	   is less than the max number of rooms */
	@Test
	public void testNorthStep() {
		boolean ret_val;
		ret_val = CoffeeMaker2.move_north(3, 6);
		assertEquals(true, ret_val);
	}

	/* Moving north when at the final state is not
	   allowed and should return false.  Room indexing
	   starts at 0 */ 
	@Test
	public void testBlockedNorth() {
		boolean ret_val;
		ret_val = CoffeeMaker2.move_north(5, 6);
		assertEquals(false, ret_val);
	}

	/* Being in a state beyond the max number of states
	   is not allowed and should return false */
	@Test
	public void testTooFarNorth() {
		boolean ret_val;
		ret_val = CoffeeMaker2.move_north(100, 6);
		assertEquals(false, ret_val);
	}

	/* Moving south when in between the end points is
	   valid and should return room  The index for these
	   rooms is greater than 0 */
	@Test
	public void testSouthStep() {
		boolean ret_val;
		ret_val = CoffeeMaker2.move_south(3);
		assertEquals(true, ret_val);
	}

	/* Moving south when at the inital state is not allowed
	   and should return false.  Room indexing starts at
	   0 */
	@Test
	public void testBlockedSouth() {
		boolean ret_val;
		ret_val = CoffeeMaker2.move_south(0);
		assertEquals(false, ret_val);
	}

	/* Moving south when beyond the inital state is not allowed
	   and should return false */
	@Test
	public void testTooFarSouth() {
		boolean ret_val;
		ret_val = CoffeeMaker2.move_south(-100);
		assertEquals(false, ret_val);
	}

	// ROOM TESTS

	/* A room with adj set to S
	   returns S with adj getter */
	@Test
	public void testRoomAdj() {
		String adj = "Fishy";	

		Room room_a = new Room();
		room_a.setRoomAdj(adj);
		
		assertEquals(adj, room_a.getRoomAdj());
	}	

	/* A room with northdoor set to S
   		returns S with associated getter */	   
	@Test
	public void testNorthDoor() {
		String northDoor = "Ducky";

		Room room_a = new Room();
		room_a.setNorthDoor(northDoor);
		assertEquals(northDoor, room_a.getNorthDoor());
	}	

	/* A room with southdoor set to S
   		returns S with associated getter */	   
	@Test
	public void testSouthDoor() {
		String southDoor = "Ducky";

		Room room_a = new Room();
		room_a.setSouthDoor(southDoor);
		assertEquals(southDoor, room_a.getSouthDoor());
	}

	/* A room without northdoor set to S
   		returns null with associated getter */	   
	@Test
	public void testNullNorthDoor() {
		Room room_a = new Room();
		assertEquals(null, room_a.getNorthDoor());
	}	

	/* A room without southdoor set to S
   		returns null with associated getter */	   
	@Test
	public void testNullSouthDoor() {
		Room room_a = new Room();
		assertEquals(null, room_a.getSouthDoor());
	}

	/* A room with furniture set to F
   		returns F with furniture getter */
	@Test
	public void testFurniture() {
		String furn = "Quarter Sawn Oak Table";	

		Room room_a = new Room();
		room_a.setFurniture(furn);

		assertEquals(furn, room_a.getFurniture());
	}

	/* A room with item set to I
	   returns I with item getter */
	@Test
	public void testItem() {
		String item = "Feral bag dogs";

		Room room_a = new Room();
		room_a.setItem(item);

		assertEquals(item, room_a.getItem());
	}

	/* If a room has a searchable item, search_room 
	   returns the searchable item */
	@Test
	public void testSearchRoomWithItem() {
		String item;	
		Room mock_room = mock(Room.class);
		when(mock_room.getItem()).thenReturn("Cream");
		item = CoffeeMaker2.search_room(mock_room); 
		assertEquals("Cream", item);		
	}

	/* If a room item is not set (ergo null), search_room
	   returns null */
	/* This test feels fishy */
	@Test
	public void testSearchRoomWithoutItem() {
		String item;	
		Room mock_room = mock(Room.class);
		when(mock_room.getItem()).thenReturn(null);
		item = CoffeeMaker2.search_room(mock_room); 
		assertNull(item);	
	}

	/* display room returns 1 if no door is present in room */
	@Test
	public void testDoorlessRoom() {
		int room_status;	

		Room mock_room = mock(Room.class);
		when(mock_room.getRoomAdj()).thenReturn("Fishy");
		when(mock_room.getFurniture()).thenReturn("kitty!");
		when(mock_room.getNorthDoor()).thenReturn(null);
		when(mock_room.getSouthDoor()).thenReturn(null);
		room_status = CoffeeMaker2.display_room(mock_room);
		assertEquals(1, room_status);
	}

	/* display room returns 3 if ONLY north door is present in room */
	@Test
	public void testNorthOnlyRoom() {
		int room_status;	

		Room mock_room = mock(Room.class);
		when(mock_room.getRoomAdj()).thenReturn("Fishy");
		when(mock_room.getFurniture()).thenReturn("kitty!");
		when(mock_room.getNorthDoor()).thenReturn("Quaint");
		when(mock_room.getSouthDoor()).thenReturn(null);
		room_status = CoffeeMaker2.display_room(mock_room);
		assertEquals(3, room_status);
	}


	/* display room returns 5 if ONLY south door is present in room */
	@Test
	public void testSouthOnlyRoom() {
		int room_status;	

		Room mock_room = mock(Room.class);
		when(mock_room.getRoomAdj()).thenReturn("Fishy");
		when(mock_room.getFurniture()).thenReturn("kitty!");
		when(mock_room.getNorthDoor()).thenReturn(null);
		when(mock_room.getSouthDoor()).thenReturn("Barbaric");
		room_status = CoffeeMaker2.display_room(mock_room);
		assertEquals(5, room_status);
	}
	
	/* display room returns 5 if ONLY south door is present in room */
	@Test
	public void testNorthSouthRoom() {
		int room_status;	

		Room mock_room = mock(Room.class);
		when(mock_room.getRoomAdj()).thenReturn("Fishy");
		when(mock_room.getFurniture()).thenReturn("kitty!");
		when(mock_room.getNorthDoor()).thenReturn("Quaint");
		when(mock_room.getSouthDoor()).thenReturn("Barbaric");
		room_status = CoffeeMaker2.display_room(mock_room);
		assertEquals(7, room_status);
	}

	/* A newly created room returns null if 
	   furniture is requested. Furniture has
	   not been set yet.
	   */
	@Test
	public void testEmptyRoom() {
		Room room_a = new Room();
		assertNull(room_a.getFurniture());
	}

	/* Room in position less than total number of game states
	   should be filled with doors items and furniture */
	@Test
	public void testCreateRoom() {
		int room_pos = 2;
		int total_rooms = 6;

		// So the example LinkedListTest code given by Bill does the mocking with a 
		// slightly different syntax.  I think this works due to the above imports
		// however some testing on the testing (meta-testing :P ) needs to be done
		int retVal = CoffeeMaker2.create_room(room_pos, total_rooms, mock(Room.class));

		assertEquals(1, retVal);
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

	/* Entering an element of valid input set is case insensitive
		and returns true */
	@Test
	public void testCaseInsensitivity() {
		boolean input_UC = CoffeeMaker2.check_input("S");
		boolean input_LC = CoffeeMaker2.check_input("s");

		assertEquals(true,  input_UC & input_LC);
	}

	/* Entering invalid input is case insensitive and returns
	  	false */
    @Test
	public void testInvalidCaseInsensitivity() {
		boolean input_UC = CoffeeMaker2.check_input("z");
		boolean input_LC = CoffeeMaker2.check_input("Z");

		assertEquals(false,  input_UC & input_LC);
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
