/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  Cruiser 
 *
 *  Description: Subclass of ship, longest ship with a length of 3. 
 *
 *  Written:       3/16/2022
 *  Last updated:  3/17/2022
 *
 *  Compilation:   javac Cruiser.java
 **************************************************************************** */

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