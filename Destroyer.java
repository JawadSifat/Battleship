public class Destroyer extends Ship {

	public Destroyer(){
		this.length = 2;
		boolean[] hit = new boolean[2];
	}

	@Override
	public String getShipType(){
		return "destroyer";
	}
	
}