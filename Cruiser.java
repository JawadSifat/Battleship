public class Cruiser extends Ship {

	public Cruiser(){
		this.length = 3;
		boolean[] hit = new boolean[3];
	}

	@Override
	public String getShipType(){
		return "cruiser";
	}
	
}