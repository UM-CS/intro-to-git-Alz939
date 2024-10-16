import java.util.Scanner;

public class GoBoard {

    static String[][] goBoard = new String[9][9];

    public static void main(String[] args) {

        Boolean cont = true, turn = true;
        int moveX, moveY;

        Scanner scn = new Scanner(System.in);

        int dimension = goBoard.length - 1;

        while (cont) {

            System.out.println("  0 1 2 3 4 5 6 7 8");
            for (int i = 0; i < goBoard.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < goBoard[i].length; j++) {
                    if (goBoard[i][j] == null) {
                        System.out.print("+|");
                    } else {
                        System.out.print(goBoard[i][j] + "|");
                    }
                }
                System.out.println();
            }

            System.out.println("\n" + ((turn) ? "Black" : "White") + "'s turn to move!\n\n");

            System.out.println("Please enter the x coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + " piece or type 'exit':");

            String inputX = scn.next();
            if (inputX.equalsIgnoreCase("exit")) {
            System.out.println("Exiting.");
            break;
            }

                    
            moveX = scn.nextInt();
            

            System.out.println("Please enter the y coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + " piece or type 'exit':");

            moveY = scn.nextInt();

            if ((moveY > dimension || moveY < 0) || (moveX > dimension || moveX < 0)) {
                System.out.println(
                        "Out of Bounds!");
                continue;
            } else {

                if (goBoard[moveY][moveX] == null) {
                    goBoard[moveY][moveX] = ((turn) ? "B" : "W");
                } else {
                    System.out.println(
                            "Space Occupied");
                    continue;
                }
                
            }

            turn = !turn;
        }

    }
}
