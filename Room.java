public class Room {
	private String roomAdj;
	private String northDoorAdj;
	private String southDoorAdj;
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
		public void setRoomAdj(String s) {
			this.roomAdj = s;
		}

		public void setNorthDoorAdj(String s) {
			this.northDoorAdj = s;
		}

		public void setSouthDoorAdj(String s) {
			this.southDoorAdj = s;
		}

		public void setFurnitureAdj(String s) {
			this.furnitureAdj = s;
		}

		public void setItem(String s) {
			this.item = s;
		}


		//getters
		public String getRoomAdj() {
			return roomAdj;
		}

		public String getNorthDoorAdj() {
			return northDoorAdj;
		}

		public String getSouthDoorAdj() {
			return southDoorAdj;
		}

		public String getFurnitureAdj() {
			return furnitureAdj;
		}

		Public String getItem() {
			return item;
		}









}
