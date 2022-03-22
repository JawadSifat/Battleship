/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  Ship.java (object class)
 *
 *  Description: Ship object class that will be used in other files and is the basic building block
 * 				of our battleship game. 
 *
 *  Written:       3/16/2022
 *  Last updated:  3/17/2022
 *
 *  Compilation:   javac Ship.java
 *  
 **************************************************************************** */

public abstract class Ship {

	/***********************************************************************************|
	 * I. Instance fields
	 * 
	 /* *********************************************************************************/
	private   int bowRow;						    //the row (0 to 9) which contains the bow (front) of the ships
	private   int bowColumn; 						//the column (0 to 9) which contains the bow (front) of the ship.
	protected int length;							//the number of squares occupied by the ship. An "empty sea" location has length 1.
	private   boolean horizontal;					//true if the ship occupies a single row, false otherwise.

	/**
	 * An array of booleans telling whether that part of the ship has been hit. 
	 * Only battleships use all four locations; cruisers use the first three; destroyers 2; 
	 * submarines 1; and "empty sea" either one or none.
	 * */
	protected boolean[] hit = new boolean[4];	

	/***********************************************************************************|
	 * II. Accessors
	 * 
	 /* *********************************************************************************/
	public int getLength(){
		return length;
	}					

	public int getBowRow(){
		return bowRow;
	}

	public int getBowColumn(){
		return bowColumn;
	}

	public boolean isHorizontal(){
		return horizontal;
	}

	abstract String getShipType();


	/***********************************************************************************|
	 * III. Mutators
	 * 
	 /* *********************************************************************************/

	 public void setBowRow(int row){
	 	this.bowRow = row;
	 }

	 public void setBowColumn(int column){
	 	this.bowColumn = column;
	 }

	 public void setHorizontal(boolean horizontal){
	 	this.horizontal = horizontal;
	 }

	
	 //Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise. 
	 public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
	 	int len = this.getLength();
	 	if (horizontal == true){
	 		if ( (row + len >= ((ocean.ships).length)) ) return false;
	 	}
	 	if (horizontal == false){
	 		if ( (col + len >= ((ocean.ships[row]).length)   )) return false;
	 	}
	 	return true;

	 	for (int rows = row - 1; rows >= 0){
	 		for (int cols = col - 1; col >= 0 && col < col + len; col++){
	 			if (!(ocean.ships[row][column].getShipType() == "emptysea")) return false;
	 		}
	 		break;
	 	}

	 	for (int rows = row - 1; rows >= 0){
	 		for (int cols = col - 1; col >= 0 && col < col + len; col++){
	 			if (!(ocean.ships[row][column].getShipType() == "emptysea")) return false;
	 		}
	 		break;
	 	}



	 }

	 //"Puts" the ship in the ocean. This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship, 
	 public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
	 	bowRow 			= row;
	 	bowColumn 		= column;
	 	horizontal      = horizontal;

	 }

	 //If a part of the ship occupies the given row and column, and the ship hasn't already been sunk, mark that part of the ship as "hit"
	 //(in the hit array, 0 indicates the bow) and return true; else false
	 public boolean shootAt(int row, int column){
	 	if (this.isSunk()) return false;		//Early exit



	 }

	 //Return true if every part of the ship has been hit, false otherwise.
	 public boolean isSunk(){
	 	for (boolean x : hit){
	 		if (x == false) return false;		//Hit is initialized to all false meaning that it wasn't hit. 
	 	}
	 	return true;

	 }

	 /***********************************************************************************|
	 * IV. Override methods + private methods
	 * 
	 /* *********************************************************************************/
	 @Override
	 public String toString(){
	 	if (this.isSunk()) return "x";
	 	else return "S";
	 }



}