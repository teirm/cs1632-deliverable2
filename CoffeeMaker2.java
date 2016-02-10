/* Author: Cyrus Ramavarapu
Date: 10 February 2016
Purpose: Remake of CoffeeMakerQuest for CS1632
Deliverable 2 */

import java.util.Scanner;

public class CoffeeMaker2 {

	public static void main (String[] args) {

		int current_pos;
		int total_states;
		boolean input_sat;
		boolean keep_going;	
		
		String user_input;	
		Scanner sc;	
		MyDumbRoom[] game_states;		

		current_pos = 0;
		total_states = 6;
		keep_going = true;

		sc = new Scanner(System.in);
		game_states = init_game(total_states);	

		System.out.printf("Coffee Maker Quest 2.0\n");

		while (keep_going) {

			System.out.printf(" INSTRUCTIONS (N, S, L, I, H, D) >\n");		

			user_input = sc.nextLine();
			input_sat = check_input(user_input);	
		
			if (input_sat == false) {
				System.out.printf("What?\n");
			} else {
				System.out.printf("Totes Good.\n");
			
				if (user_input.equals("N")) {
					if (current_pos + 1 >= total_states) {
						System.out.printf("YOU SHALL NOT PASS\n");
					} else {
						current_pos++;
						System.out.printf("CONTINUE\n");
					}
				} else if (user_input.equals("S")) {
					if (current_pos - 1 < 0 ) {
						System.out.printf("YOU SHALL NOT PASS\n");
					} else {
						current_pos--;
						System.out.printf("CONTINUE\n");
					}
				} else {
					System.out.printf("Doing something else\n");
				}	
			}
		
		}

	}

	public static boolean check_input(String in) {

		boolean out = true;

		if (!in.equals("N") && !in.equals("S") && 
			!in.equals("L") && !in.equals("I") && 
			!in.equals("D")) { out = false; }
		
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
			room.setFurniture("Start Table");
			room.setItem("Milk");
		} else if ( room_pos == total_rooms - 1) {
			room.setFurniture("End Table");
			room.setItem("Rum");
		} else {
			room.setFurniture("Coffee Table");
			room.setItem("NONE");
		}

		return room;
	}
}
