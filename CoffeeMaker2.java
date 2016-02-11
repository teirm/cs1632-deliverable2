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
		boolean input_sat;
		boolean keep_going;	
		
		String user_input;
		String item;

		Scanner sc;	
		MyDumbRoom[] game_states;
		ArrayList<String> inventory;			

		current_pos = 0;
		total_states = 6;
		keep_going = true;

		inventory = new ArrayList<String>(); 
		sc = new Scanner(System.in);
		game_states = init_game(total_states);	

		System.out.printf("Coffee Maker Quest 2.0\n");

		while (keep_going) {

			System.out.printf(" INSTRUCTIONS (N, S, L, I, H, D) >\n\n");		

			display_room(current_pos, game_states);

			user_input = sc.nextLine();
			user_input = user_input.toUpperCase();	
			input_sat = check_input(user_input);	
		
			if (input_sat == false) {
				System.out.printf("What?\n");
			} else {
				System.out.printf("Totes Good.\n");
			
				if (user_input.equals("N")) {
					
					if (move_north(current_pos, total_states)) current_pos++;
					else System.out.printf("YOU SHALL NOT PASS\n");	
				
				} else if (user_input.equals("S")) {
					
					if (move_south(current_pos)) current_pos--;
					else System.out.printf("YOU SHALL NOT PASS\n");		
				
				} else if (user_input.equals("L")) {
					System.out.printf("Searching room\n");
					item = search_room(current_pos, game_states); 	
					System.out.printf(": %s\n", item);			
					
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
					display_inventory(inventory);			
				} else if (user_input.equals("H")) {
					display_instructions();	
				} else {
					System.out.printf("You drank what you found.\nCongratulations it was Toluene!\nGood Bye\n");
					keep_going = false;
				}
			}
		
		}

	}

	public static boolean move_north(int current_pos, int total_states) {

		return current_pos + 1 < total_states;
	
	}

	public static boolean move_south(int current_pos) {
		
		return current_pos - 1 >= 0;
	
	}

	public static void display_inventory(ArrayList<String> inv) {

		if (inv.contains("Coffee")) {
			System.out.printf("You have a cup of delicious coffee.\n");
		} else {
			System.out.printf("YOU HAVE NO COFFEE!\n");
		}

		if (inv.contains("Cream")) {
			System.out.printf("You have some fresh cream.\n");
		} else {
			System.out.printf("YOU HAVE NO CREAM!\n");
		}

		if (inv.contains("Sugar")) {
			System.out.printf("You have some tasy sugar.\n");
		} else {
			System.out.printf("YOU HAVE NO SUGAR\n");
		}
	}	


	public static void display_instructions() {

		System.out.printf("Instructions for Coffee Maker Quest -\n" + 
			"You are a brave student trying to study for finals, but you need caffeine.\n" + 
			"The goal of the game is to collect sugar, coffee, and cream so that you can study.\n");
	}	

	public static String search_room(int curr_pos, MyDumbRoom[] states) {

		MyDumbRoom curr_room = states[curr_pos];
		return curr_room.getItem();
	
	}

	public static void display_room(int curr_pos, MyDumbRoom[] states) {

		MyDumbRoom curr_room = states[curr_pos];
		
		System.out.printf("You see a <ADJ> room.\nIt has a <ADJ> %s.\n", curr_room.getFurniture());

		if (curr_room.getNorthDoor() != null) {
			System.out.printf("A %s door leads North.\n", curr_room.getNorthDoor());
		}

		if (curr_room.getSouthDoor() != null) {
			System.out.printf("A %s door leads South.\n", curr_room.getSouthDoor());
		}		


	}

	public static boolean check_input(String in) {

		boolean out = true;

		if (!in.equals("N") && !in.equals("S") && 
			!in.equals("L") && !in.equals("I") && 
			!in.equals("H") && !in.equals("D")) { out = false; }
		
		return out;
	}
			
	public static MyDumbRoom[] init_game(int state_count) {

		int i;	
		
		MyDumbRoom game_room;
		MyDumbRoom[] game_states = new MyDumbRoom[state_count];
		
		for (i = 0; i < state_count; i++) {
			game_room = create_room(i, state_count);	
			game_states[i] = game_room;	
		}
	
		return game_states;	
	}


	public static MyDumbRoom create_room(int room_pos, int total_rooms) {

		MyDumbRoom room = new MyDumbRoom();

		if (room_pos == 0) {
			room.setNorthDoor("Chunky");
			room.setFurniture("Start Table");
			room.setItem("Milk");
		} else if ( room_pos == total_rooms - 1) {
			room.setSouthDoor("Shiny");	
			room.setFurniture("End Table");
			room.setItem("Rum");
		} else {
			room.setNorthDoor("Creamy");
			room.setNorthDoor("Stalwart");
			room.setFurniture("Coffee Table");
		}

		return room;
	}
}
