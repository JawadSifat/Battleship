import java.util.ArrayList;

public class Ocean {
    private static int shotsFired;
    private static int hitCount;

    private static String[][] grid = new String[10][10];
    protected Ship[][] ships = new Ship[10][10];

    public Ocean() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ships[i][j] = new EmptySea();
            }
        }
        shotsFired = 0;
        hitCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = ".";
            }
        }
    }

    private boolean rBool() {
        if (Math.random() < 0.50)
            return true;
        return false;
    }

    public void placeAllShipsRandomly() {
        Ship[] a = new Ship[10];
        for (int i = 0; i < 10; i++) {
            double r = Math.random();
            if (r < 0.25)
                a[i] = new Submarine();
            else if (r < 0.50)
                a[i] = new Cruiser();
            else if (r < 0.75)
                a[i] = new Destroyer();
            else
                a[i] = new Battleship();
        }
        ArrayList<Ship> b = new ArrayList<Ship>();
        for (int i = 4; i > 0; i--) {
            for (Ship x : a) {
                if (x.length == i)
                    b.add(x);
            }
        }
        for (int i = 0; i < 10; i++) {
            int row = (int) (Math.random() * 10);
            int column = (int) (Math.random() * 10);
            /*
            System.out.println(b.get(i).getShipType());
            System.out.println(row);
            System.out.println(column);
             */
            boolean horizontal = rBool();
            //System.out.println(horizontal);
            //System.out.println(b.get(i).okToPlaceShipAt(row, column, horizontal, this));
            if (b.get(i).okToPlaceShipAt(row, column, horizontal, this)) {
                b.get(i).placeShipAt(row, column, horizontal, this);
                //  System.out.println("placed");
            }
            else
                i--;
        }

    }

    public boolean isOccupied(int row, int column) {
        if (ships[row][column].getShipType().equals("emptysea") ||
                ships[row][column].isSunk())
            return false;
        return true;
    }

    public boolean shootAt(int row, int column) {
        grid[row][column] = ships[row][column].toString();
        if (ships[row][column].shootAt(row, column)) {
            hitCount++;
            shotsFired++;
            return true;
        }
        shotsFired++;
        return false;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isGameOver() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (isOccupied(i, j) && !ships[i][j].isSunk())
                    return false;
            }
        }
        return true;
    }

    public Ship[][] getShipArray() {
        return ships;
    }

    public void print() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }

    }
}
