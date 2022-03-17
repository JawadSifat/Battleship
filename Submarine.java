/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  Submarine 
 *
 *  Description: Subclass of ship, shortest ship with a length of 1. 
 *
 *  Written:       3/16/2022
 *  Last updated:  3/17/2022
 *
 *  Compilation:   javac Submarine.java
 **************************************************************************** */

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