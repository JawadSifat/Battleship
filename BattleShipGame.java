public class BattleShipGame {

    public static void main(String[] args) {

        while (true) {

            Ocean battlefield = new Ocean();

            // set up the game
            battlefield.placeAllShipsRandomly();
            battlefield.print();

            while (!battlefield.isGameOver()) {
                // accept "shots" from the user;

                System.out.print("Enter row: ");
                int row = StdIn.readInt();
                System.out.print("Enter column: ");
                int column = StdIn.readInt();

                //display the results;
                battlefield.print();
                if (battlefield.shootAt(row, column)) {
                    System.out.println("You just sank a " + battlefield.getShipArray()[row][column]
                            .getShipType());
                }
            }

            //print final scores;
            System.out.println("# of shots fired: ");
            System.out.println(battlefield.getShotsFired());
            System.out.println("Hit count: ");
            System.out.println(battlefield.getHitCount());

            // and ask the user if he/she wants to play again
            System.out.println("play again? (true/false)");
            boolean again = StdIn.readBoolean();
            if (!again) break;
        }

    }
}
