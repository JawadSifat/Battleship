public class OceanTest {
    public static void main(String[] args) {
        Ocean ocean = new Ocean();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(ocean.isOccupied(i, j));
            }
        }
        ocean.placeAllShipsRandomly();
        System.out.println(ocean.isGameOver());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(ocean.isOccupied(i, j));
                System.out.println(ocean.shootAt(i, j));
            }
        }
        System.out.println(ocean.getShotsFired());
        System.out.println(ocean.getHitCount());
        System.out.println(ocean.isGameOver());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(ocean.getShipArray()[i][j]);
            }
        }

    }
}
