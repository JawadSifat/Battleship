public class Submarine extends Ship {

	public Submarine(){
		this.length = 1;
		boolean[] hit = new boolean[1];
	}

	@Override
	public String getShipType(){
		return "submarine";
	}
	
}