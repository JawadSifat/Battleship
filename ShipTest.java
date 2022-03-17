/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  ShipTest 
 *
 *  Description: TTD appraoch to making sure that all the ship and ocean methods work
 *
 *  Written:       3/16/2022
 *  Last updated:  3/17/2022
 *
 *  Compilation:   javac ShipTest.java
 * 	Execution:	   java ShipTest
 **************************************************************************** */

public class ShipTest {
	
	public static void main(String[] args) {
		
		Ocean testOcean = new Ocean();
		Ship testBattleship = new Battleship();
		Ship testCruiser = new Cruiser();
		Ship testDestroyer = new Destroyer();
		Ship testSubmarine = new Submarine();
		
		// tests for getters:
		System.out.println("Bow Row: ");
		System.out.println(testBattleship.getBowRow());
		System.out.println("Bow Column: ");
		System.out.println(testBattleship.getBowColumn());
		System.out.println("Is Horizontal: ");
		System.out.println(testBattleship.isHorizontal());
		
		// tests for setters:
		System.out.println("Set bow row to 5 ");
		testBattleship.setBowRow(5);
		System.out.println(testBattleship.getBowRow());
		
		System.out.println("Set bow column to 5 ");
		testBattleship.setBowColumn(5);
		System.out.println(testBattleship.getBowColumn());
		
		System.out.println("Set horizontal to false ");
		testBattleship.setHorizontal(false);
		System.out.println(testBattleship.isHorizontal());
		
		
		// test okToPlaceShipAt:
		System.out.println("Is okToPlaceShipAt row 5, column 5, not horizontal in testOcean");
		System.out.println(testBattleship.okToPlaceShipAt(5, 5, false, testOcean));
		
		// test placeShipAt:
		System.out.println("placeShipAt row 5, column 5, not horizontal in testOcean");
		testBattleship.placeShipAt(5, 5, false, testOcean);
		// use okToPlaceShipAt to check placeShipAt:
		System.out.println(testBattleship.okToPlaceShipAt(5, 5, false, testOcean));
		
		// test shootAt:
		System.out.println("shoot at ship at row 5 column 5: ");
		System.out.println(testBattleship.shootAt(5, 5));
		
		// test isSunk 
		System.out.println("Is ship at row 5 column 5 sunk: ");
		System.out.println(testBattleship.isSunk());
		
		// test getShipType and toString for 4 types of ships:
		System.out.println(testBattleship.getShipType());
		System.out.println(testBattleship);
		System.out.println(testCruiser.getShipType());
		System.out.println(testCruiser);
		System.out.println(testDestroyer.getShipType());
		System.out.println(testDestroyer);
		System.out.println(testSubmarine.getShipType());
		System.out.println(testSubmarine);
		
	}
}