/* Author: Cyrus Ramavarapu
Date: 10 February 2016
Purpose: Remake of CoffeeMakerQuest for CS1632
Deliverable 2 */

import java.util.Scanner;
import java.util.ArrayList;

public class CoffeeMaker2 {

	public static void main (String[] args) {

		int current_pos;
		int total_states;
		int bag_status;
		int win_status;

		boolean input_sat;
		boolean keep_going;	
		
		String user_input;
		String item;

		Scanner sc;	
	
		Room curr_room;	
		Room room_to_search;	
		Room[] game_states;
		
		ArrayList<String> inventory;			

		current_pos = 0;
		total_states = 6;
		keep_going = true;

		inventory = new ArrayList<String>(); 
		sc = new Scanner(System.in);
		game_states = new Room[total_states];	
		init_game(total_states, game_states);	

		System.out.printf("Coffee Maker Quest 2.0\n");

		while (keep_going) {

			curr_room = game_states[current_pos];
			display_room(curr_room);

			System.out.printf("\n INSTRUCTIONS (N, S, L, I, H, D) >\n");		
			
			user_input = sc.nextLine();
			input_sat = check_input(user_input);	
			user_input = user_input.toUpperCase();
			
			if (input_sat == false) {
				System.out.printf("What?\n");
			} else {
			
				if (user_input.equals("N")) {
					
					if (move_north(current_pos, total_states)) current_pos++;
				
				} else if (user_input.equals("S")) {
					
					if (move_south(current_pos)) current_pos--;
				
				} else if (user_input.equals("L")) {
					System.out.printf("Searching room\n");
					room_to_search = game_states[current_pos];		
					item = search_room(room_to_search); 	
					if (item == null) { 
						System.out.printf("You don't see anything out of the ordinary.\n");
					} else if (inventory.contains(item)) {
						System.out.printf("There might be something here...\n");
						System.out.printf("You found some %s\n", item);
					} else {
						System.out.printf("There might be something here...\n");
						System.out.printf("You found some %s\n", item);
						inventory.add(item);
					}

				} else if (user_input.equals("I")) {
					bag_status = display_inventory(inventory);			
				} else if (user_input.equals("H")) {
					display_instructions();	
				} else {
					bag_status = display_inventory(inventory);
					System.out.printf("\n");	
					win_status = process_bag(bag_status);

					if (win_status == 0) System.out.printf("You Lose!\n");
					else System.out.printf("You win!\n");

					keep_going = false;
				}
			}
		
		}

	}

	public static int process_bag(int bag_status) {

		int status = 0;

		switch (bag_status) {
			case 0:
				System.out.printf("You drink the air, as you have no coffee, sugar, or cream.\n" +
						"The air is invigorating, but not invigorating enough.  You cannot study.\n");
				break;
			case 1:
				System.out.printf("Without cream, you get an unlcer and cannot study.\n");
				break;
			case 2:
				System.out.printf("You drink the cream, but without caffeine, you cannot study.\n");
				break;	
			case 3:
				System.out.printf("Without sugar, the coffee is too bitter.  You cannot study.\n");
				break;
			case 4:
				System.out.printf("You eat the sugar, but without caffeine, you cannot study.\n");
				break;
			case 5:
				System.out.printf("Without cream, you get an unlcer and cannot study.\n");
				break;
			case 6:
				System.out.printf("You drink the sweetened cream, but without caffeine, you cannot study.\n");
				break;		
			case 7:
				System.out.printf("You Drink the beverage and are ready to study!\n");
				status = 1;	
				break;	
			default:
				System.out.printf("BROKEN\n");
				status = -1;
				break;
		}

		return status;	
			
	}

	public static boolean move_north(int current_pos, int total_states) {

		return current_pos + 1 < total_states;
	
	}

	public static boolean move_south(int current_pos) {
		
		return current_pos - 1 >= 0;
	
	}

	/* Each item is represented by a bit value:
		
		coffee: 001
		cream: 010
	    sugar: 100
		
		Bitwise OR of these values affords all
		items combinations 	
	*/
	public static int display_inventory(ArrayList<String> inv) {

		int has_coffee = 0x000;
		int has_cream = 0x000;
		int has_sugar = 0x000;

		if (inv.contains("Coffee")) {
			System.out.printf("You have a cup of delicious coffee.\n");
			has_coffee = 0x001;	
		} else {
			System.out.printf("YOU HAVE NO COFFEE!\n");
		}

		if (inv.contains("Cream")) {
			System.out.printf("You have some fresh cream.\n");
			has_cream = 0x002;	
		} else {
			System.out.printf("YOU HAVE NO CREAM!\n");
		}

		if (inv.contains("Sugar")) {
			System.out.printf("You have some tasy sugar.\n");
			has_sugar = 0x004;	
		} else {
			System.out.printf("YOU HAVE NO SUGAR\n");
		}

		return has_coffee + has_cream + has_sugar;
	}	


	public static int display_instructions() {

		System.out.printf("Instructions for Coffee Maker Quest -\n" + 
			"You are a brave student trying to study for finals, but you need caffeine.\n" + 
			"The goal of the game is to collect sugar, coffee, and cream so that you can study.\n");
	
		return 1;	
	}	

	public static String search_room(Room curr_room) {
		return curr_room.getItem();
	}

	public static int display_room(Room curr_room) {
	
		int room_status = 0;

		System.out.printf("\nYou see a %s room.\nIt has a %s.\n", curr_room.getRoomAdj(), curr_room.getFurniture());
		
		room_status+=1;

		if (curr_room.getNorthDoor() != null) {
			System.out.printf("A %s door leads North.\n", curr_room.getNorthDoor());
			room_status+=2;	
		}

		if (curr_room.getSouthDoor() != null) {
			System.out.printf("A %s door leads South.\n", curr_room.getSouthDoor());
			room_status+=4;
		}

		return room_status;
	}

	public static boolean check_input(String in) {

		boolean out = true;

		in = in.toUpperCase();

		if (!in.equals("N") && !in.equals("S") && 
			!in.equals("L") && !in.equals("I") && 
			!in.equals("H") && !in.equals("D")) { out = false; }
		
		return out;
	}
			
	public static int init_game(int state_count, Room[] game_states) {

		int i;	
		
		Room game_room;
		
		for (i = 0; i < game_states.length; i++) {
			game_room = new Room();	
			create_room(i, state_count, game_room);
			game_states[i] = game_room;	
		}
	
		return i;	
	}


	public static int create_room(int room_pos, int total_rooms, Room room) {

		int index;

		/* Take in 4-tuples: (room adj, furniture, north adj, south adj) */
		/* "NONE" means that door does not exist for the given state */
		String[] adj_furn_array = {"Small", "Quaint sofa", "Magenta", "NONE",
									"Funny", "Sad record player", "Beige", "Massive",
									"Refinanced", "Tight pizza", "Dead", "Smart",
									"Dumb", "Flat energy drink", "Vivacious", "Slim",
									"Bloodthirsty", "Beautiful bag of money", "Purple", "Sandy",
									"Rough", "Perfect air hockey table", "NONE", "Minimalist"}; 

		index = room_pos * 4;
		
		if (room_pos == 0) {
			room.setRoomAdj(adj_furn_array[index + 0]);
			room.setFurniture(adj_furn_array[index + 1]);
			room.setNorthDoor(adj_furn_array[index + 2]);
			room.setItem("Cream");
		} else if (room_pos == total_rooms / 2) {
			room.setRoomAdj(adj_furn_array[index + 0]);
			room.setFurniture(adj_furn_array[index + 1]);
			room.setNorthDoor(adj_furn_array[index + 2]);
			room.setSouthDoor(adj_furn_array[index + 3]);	
			room.setItem("Coffee");	
		} else if (room_pos == total_rooms - 1) {
			room.setRoomAdj(adj_furn_array[index + 0]);
			room.setFurniture(adj_furn_array[index + 1]);
			room.setSouthDoor(adj_furn_array[index + 3]);	
			room.setItem("Sugar");
		} else {
			room.setRoomAdj(adj_furn_array[index + 0]);
			room.setFurniture(adj_furn_array[index + 1]);
			room.setNorthDoor(adj_furn_array[index + 2]);
			room.setSouthDoor(adj_furn_array[index + 3]);	
		}

		return 1;
	}
}
