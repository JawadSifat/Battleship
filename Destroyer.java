/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  Destroyer 
 *
 *  Description: Subclass of ship, longest ship with a length of 2. 
 *
 *  Written:       3/16/2022
 *  Last updated:  3/17/2022
 *
 *  Compilation:   javac Destroyer.java
 **************************************************************************** */

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