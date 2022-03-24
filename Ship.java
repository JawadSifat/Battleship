/**
 * /** *****************************************************************************
 * Names:        Jawad Sifat  - Wan ying Li - Shay Savio
 * <p>
 * Title:  Ship.java (object class)
 * <p>
 * Description: Ship object class that will be used in other files and is the basic building block
 * of our battleship game.
 * <p>
 * Written:       3/16/2022
 * Last updated:  3/23/2022
 * <p>
 * Compilation:   javac Ship.java
 * <p>
 * ***************************************************************************
 */

public abstract class Ship {

    /***********************************************************************************|
     * I. Instance fields
     *
     /* *********************************************************************************/
    private int bowRow;
    //the row (0 to 9) which contains the bow (front) of the ships
    private int bowColumn;
    //the column (0 to 9) which contains the bow (front) of the ship.
    protected int length;
    //the number of squares occupied by the ship. An "empty sea" location has length 1.
    private boolean horizontal;
    //true if the ship occupies a single row, false otherwise.

    /**
     * An array of booleans telling whether that part of the ship has been hit.
     * Only battleships use all four locations; cruisers use the first three; destroyers 2;
     * submarines 1; and "empty sea" either one or none.
     */
    protected boolean[] hit = new boolean[4];

    /***********************************************************************************|
     * II. Accessors
     *
     /* *********************************************************************************/
    public int getLength() {
        return length;
    }

    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    abstract String getShipType();


    /***********************************************************************************|
     * III. Mutators
     *
     /* *********************************************************************************/

    public void setBowRow(int row) {
        this.bowRow = row;
    }

    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }


    //Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise.
    private boolean otph(int row, int column, Ocean ocean) {
        
        //check if there is enough room to put the ship in a give row
        int max = 11;
        for (int i = column; i < 10; i++) {
            if (ocean.isOccupied(row, i)) {
                max = i;
                break;
            }
        }
        if (max - column < length + 1) return false;
        if (column + length > 9) return false;
        //check if there is any ship on the row above the given row
        if (row != 0) {
            if (column > 1) {
                for (int i = column - 1; i < column + length + 1; i++) {
                    if (ocean.isOccupied(row - 1, i))
                        return false;
                }
            } else {
                for (int i = column; i < column + length + 1; i++) {
                if (ocean.isOccupied(row - 1, i))
                    return false;
                }
            }
        }
        //check if there is any ship on the row below the given row
        if (row != 9) {
            if (column > 1) {
                for (int i = column - 1; i < column + length + 1; i++) {
                    if (ocean.isOccupied(row + 1, i))
                        return false;
                }
            } else {
                for (int i = column; i < column + length + 1; i++) {
                if (ocean.isOccupied(row + 1, i))
                    return false;
                }
            }
        }
        //checks if there is any ship to the left and right of the ship
        if (column != 0) {
            if (ocean.isOccupied(row, column - 1))
                return false;
        }
        if (column != 9) {
            if (ocean.isOccupied(row, column + 1))
                return false;
        }
        return true;
    }

    private boolean otpv(int row, int column, Ocean ocean) {
        //check if there is enough room to put the ship in a give row
        int max = 11;
        for (int i = row; i < 10; i++) {
            if (ocean.isOccupied(i, column)) {
                max = i;
                break;
            }
        }
        if (max - row < length + 1) return false;
        if (row + length > 9) return false;
        //check if there is any ship on the column left to the given column
        if (column != 0) {
            if (row > 1) {
                for (int i = row - 1; i < row + length + 1; i++) {
                    if (ocean.isOccupied(i, column - 1))
                        return false;
                }
            } else {
                for (int i = row; i < row + length + 1; i++) {
                if (ocean.isOccupied(i, column - 1))
                    return false;
                }
            }
        }
        //check if there is any ship on the column right to the given column
        if (column != 9) {
            if (row > 1) {
                for (int i = row - 1; i < row + length + 1; i++) {
                    if (ocean.isOccupied(i, column + 1))
                        return false;
                }
            } else {
                for (int i = row; i < row + length + 1; i++) {
                if (ocean.isOccupied(i, column + 1))
                    return false;
                }
            }
        }
        //checks if there is any ship under and above the ship
        if (row != 0) {
            if (ocean.isOccupied(row - 1, column))
                return false;
        }
        if (row != 9) {
            if (ocean.isOccupied(row + 1, column))
                return false;
        }
        return true;
    }
    /*
    private boolean otph(int row, int column, Ocean ocean) {
        int max = 11;
        for (int i = column; i < 10; i++) {
            if (ocean.isOccupied(row, i)) {
                max = i;
                break;
            }
        }
        if (max - column < length + 1)
            return false;
        if (row != 0) {
            for (int i = column; i < column + length; i++) {
                if (ocean.isOccupied(row - 1, i))
                    return false;
            }
        }
        if (row != 9) {
            for (int i = column; i < column + length; i++) {
                if (ocean.isOccupied(row + 1, i))
                    return false;
            }
        }
        if (column != 0) {
            if (ocean.isOccupied(row, column - 1))
                return false;
        }
        return true;
    }

    private boolean otpv(int row, int column, Ocean ocean) {
        int max = 11;
        for (int i = row; i < 10; i++) {
            if (ocean.isOccupied(i, column)) {
                max = i;
                break;
            }
        }
        if (max - row < length + 1) return false;
        if (column != 0) {
            for (int i = row; i < row + length; i++) {
                if (ocean.isOccupied(column - 1, i))
                    return false;
            }
        }
        if (column != 9) {
            for (int i = row; i < row + length; i++) {
                if (ocean.isOccupied(column + 1, i))
                    return false;
            }
        }
        if (row != 0) {
            if (ocean.isOccupied(row - 1, column))
                return false;
        }

        return true;
    }*/

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (horizontal)
            return otph(row, column, ocean);
        return otpv(row, column, ocean);
    }

    //"Puts" the ship in the ocean. This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship,
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        bowRow = row;
        bowColumn = column;
        this.horizontal = horizontal;

        if (horizontal) {
            for (int i = column; i < column + length; i++)
                ocean.getShipArray()[row][i] = this;
        }
        else {
            for (int i = row; i < row + length; i++)
                ocean.getShipArray()[i][column] = this;
        }
    }

    //If a part of the ship occupies the given row and column, and the ship hasn't already been sunk, mark that part of the ship as "hit"
    //(in the hit array, 0 indicates the bow) and return true; else false
    public boolean shootAt(int row, int column) {
        if (this.isSunk()) return false;        //Early exit
        int distance = (int) (Math
                .sqrt(Math.pow((row - this.bowRow), 2) + Math
                        .pow((column - this.bowColumn), 2)));
        hit[distance] = true;
        return true;
    }

    //Return true if every part of the ship has been hit, false otherwise.
    public boolean isSunk() {
        for (boolean x : hit) {
            if (x == false)
                return false;        //Hit is initialized to all false meaning that it wasn't hit.
        }
        return true;

    }

    /***********************************************************************************|
     * IV. Override methods + private methods
     *
     /* *********************************************************************************/
    @Override
    public String toString() {
        if (this.isSunk()) return "x";
        else return "S";
    }


}