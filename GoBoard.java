import java.util.Scanner;

public class GoBoard {

    static String[][] goBoard = new String[9][9];

    static boolean[][] livess = new boolean[9][9];
    static boolean[][] territory = new boolean[9][9];
    static boolean[][] beenChecked = new boolean[9][9];

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
                    + ((turn) ? "Black" : "White") + ":");
     
            moveX = scn.nextInt();
            
            System.out.println("Please enter the y coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + ":");

            moveY = scn.nextInt();

            if ((moveY > dimension || moveY < 0) || (moveX > dimension || moveX < 0)) {
                System.out.println(
                        "Out of Bounds.");
                continue;
            } else {

                if (goBoard[moveY][moveX] == null) {
                    goBoard[moveY][moveX] = ((turn) ? "B" : "W");
                } else {
                    System.out.println(
                            "Space Occupied.");
                    continue;
                }
                
            }

            turn = !turn;
        }
    }

static int blackScore = 0;
static int whiteScore = 0;

public static void checkAndCapture(String opponent, int moveX, int moveY) {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int[] dir : directions) {
        int adjX = moveX + dir[0];
        int adjY = moveY + dir[1];

        if (isOnBoard(adjX, adjY) && goBoard[adjY][adjX] != null && goBoard[adjY][adjX].equals(opponent)) {
            resetBeenChecked();
            if (!hasLiberty(adjX, adjY)) {
                captureGroup(adjX, adjY);
            }
        }
    }
}

public static boolean hasLiberty(int x, int y) {
    if (!isOnBoard(x, y) || goBoard[y][x] == null) {
        return false;
    }
    if (beenChecked[y][x]) {
        return false;
    }

    beenChecked[y][x] = true;

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] dir : directions) {
        int adjX = x + dir[0];
        int adjY = y + dir[1];

        if (isOnBoard(adjX, adjY) && goBoard[adjY][adjX] == null) {
            livess[y][x] = true;
            return true;
        }
        if (isOnBoard(adjX, adjY) && goBoard[adjY][adjX] != null && goBoard[adjY][adjX].equals(goBoard[y][x])) {
            if (hasLiberty(adjX, adjY)) {
                livess[y][x] = true;
                return true;
            }
        }
    }
    livess[y][x] = false;
    return false;
}

public static void captureGroup(int x, int y) {
    String stoneColor = goBoard[y][x];
    int capturedStones = 0;

    if (stoneColor != null) {
        goBoard[y][x] = null; 
        capturedStones++;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int adjX = x + dir[0];
            int adjY = y + dir[1];

            if (isOnBoard(adjX, adjY) && goBoard[adjY][adjX] != null && goBoard[adjY][adjX].equals(stoneColor)) {
                captureGroup(adjX, adjY); // Recursively capture connected stones
            }
        }

        if (stoneColor.equals("B")) {
            whiteScore += capturedStones;
        } else if (stoneColor.equals("W")) {
            blackScore += capturedStones;
        }
    }
}

public static boolean isOnBoard(int x, int y) {
    return (x >= 0 && x < goBoard.length && y >= 0 && y < goBoard.length);
}

public static void resetBeenChecked() {
    for (int i = 0; i < beenChecked.length; i++) {
        for (int j = 0; j < beenChecked[i].length; j++) {
            beenChecked[i][j] = false;
            }
        }
    }
}
