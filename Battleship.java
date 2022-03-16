public class Battleship extends Ship {

	public Battleship(){
		this.length = 4;
		boolean[] hit = new boolean[4];
	}

	@Override
	public String getShipType(){
		return "battleship";
	}

}