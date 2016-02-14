public class Room {
	
	private String northDoor;
	private String southDoor;
	private String furniture;
	private String item;
	private String roomAdj;
	
	//setters

	public int setRoomAdj(String s) {
		this.roomAdj = s;
		return 1;	
	}

	public int setNorthDoor(String s) {
		this.northDoor = s;
		return 1;	
	}

	public int setSouthDoor(String s) {
		this.southDoor = s;
		return 1;	
	}

	public int setFurniture(String s) {
		this.furniture = s;
		return 1;	
	}

	public int setItem(String s) {
		this.item = s;
		return 1;	
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
		return furniture;
	}

	public String getItem() {
		return item;
	}

}
