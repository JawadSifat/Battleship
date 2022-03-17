/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  Battleship 
 *
 *  Description: Subclass of ship, longest ship with a length of 4. 
 *
 *  Written:       3/16/2022
 *  Last updated:  3/17/2022
 *
 *  Compilation:   javac Battleship.java
 **************************************************************************** */

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