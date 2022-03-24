/** *****************************************************************************                                                                                                                 
 *  Names:        Jawad Sifat  - Wan ying Li - Shay Savio                                                                                                                                                                                                                                                                                                
 *                                                                                                                                                                                                
 *  Title:  Ocean Test Client
 *
 *  Description: Tests the calls for the ocean class
 *
 *  Written:       3/16/2022
 *  Last updated:  3/22/2022
 *
 *  Compilation:   javac Ocean.java
 **************************************************************************** */


public class OceanTest {
    public static void main(String[] args) {
        Ocean ocean = new Ocean();
        /*
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(ocean.isOccupied(i, j));
            }
        } */
        ocean.print();
        ocean.placeAllShipsRandomly();
        ocean.print();
        System.out.println(ocean.isGameOver());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%6b", ocean.isOccupied(i, j));
            }
            System.out.println();
        }
        /*
        System.out.println(ocean.getShotsFired());
        System.out.println(ocean.getHitCount());
        System.out.println(ocean.isGameOver());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(ocean.getShipArray()[i][j]);
            }
        }
        */

    }
}