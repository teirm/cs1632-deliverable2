public class Room {
	private String northDoor;
	private String southDoor;
	private String furnitureAdj;
	private String item;


	/* Potential methods: 
		Constructor (could probably get away with default)

		ADD ROOM ADJECTIVE
		ADD FURNITURE WITH ADJECTIVE
		ADD DOOR NORTH WITH ADJECTIVE
		ADD DOOR SOUTH WITH ADJECTIVE

		GET ROOM DESCRIPTION
		GET FURNITURE DESCRIPTION
		GET NORTH DESCRIPTION
		GET SOUTH DESCRIPTION
	*/	
		public Room() {

		}


		//setters

		public void setNorthDoor(String s) {
			this.northDoor = s;
		}

		public void setSouthDoor(String s) {
			this.southDoor = s;
		}

		public void setFurniture(String s) {
			this.furniture = s;
		}

		public void setItem(String s) {
			this.item = s;
		}


		//getters
		public String getRoomAdj() {
			return roomAdj;
		}

		public String getNorthDoor() {
			return northDoor;
		}

		public String getSouthDoor() {
			return southDoor;
		}

		public String getFurniture() {
			return furnitureAdj;
		}

		Public String getItem() {
			return item;
		}









}
