public class Ocean {
    private Ship[][] ships = new Ship[10][10];
    private static int shotsFired;
    private static int hitCount;

    private static String[][] grid = new String[10][10];
    
    public Ocean() {
	for(int i = 0; i < 10; i++){
	    for(int j = 0; j < 10; j++){
		ships[i][j] = new EmptySea();
	    }
	}
	shotsFired = 0;
	hitCount = 0;
    }
    private boolean rBool() {
	if(Math.random() < 0.50)
	    return true;
	return false;
    }
    public void placeAllShipsRandomly() {
	Ship b = new Battleship();
	Ship c = new Cruiser();
	Ship d = new Destroyer();
	Ship s = new Submarine();
	Ship[] a = {b, c, d, s};
	for(int i = 0; i < 3; i++) {
	    int row = (int)(Math.random() * 10);
	    int column = (int)(Math.random() * 10);
	    boolean horizontal = rBool();
	    if(a[i].okToPlaceShipAt(row, column, horizontal, this))
		a[i].placeShipAt(row, column, horizontal, this);
	    else
		i--;
	}
	for(int i = 0; i < 10; i++){
	    for(int j = 0; j < 10; j++){
		grid[i][j] = ".";
	    }
	}
    }
    public boolean isOccupied(int row, int column) {
	if(ships[row][column].getShipType().equals("EmptySea"))
	    return false;
	return true;
    }
    public boolean shootAt(int row, int column) {
	grid[row][column] = ships[row][column].toString();
	if(ships[row][column].shootAt(row, column)){
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
	for(int i = 0; i < 10; i++){
	    for(int j = 0; j < 10; j++){
		if(isOccupied(i, j) && !ships[i][j].isSunk())
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
	for(int i = 0; i < 10; i++){
	    System.out.print(i + " ");
	    for(int j = 0; j < 10; j++)
		System.out.print(grid[i][j] + " ");
	    System.out.println();
	}

    }
}

