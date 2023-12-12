import java.util.Arrays;

public class TicTacToe {
    static String[][] board = new String[3][3];

    public static void main(String[] args) {
        for (String[] chars : board) {
            Arrays.fill(chars, "_");
        }
        System.out.println(getBoard());
    }
    public static String getBoard(){
        return Arrays.toString(board[0]).concat("\n" + Arrays.toString(board[1]).concat("\n" + Arrays.toString(board[2])));
    }
    public  static void detectWin(String[][] currentBoard){
        String stringBoard = Arrays.toString(currentBoard);
        /*
            POSSIBLE WIN SCENARIOS
            By Row
             In Array
            [0][0] == [0][1] == [0][2]
            [1][0] == [1][1] == [1][2]
            [2][0] == [2][1] == [2][2]
             In String
            [0] == [1] == [2]
            [3] == [4] == [5]
            [6] == [7] == [8]

            By Column
             In Array
            [0][0] == [1][0] == [2][0]
            [0][1] == [1][1] == [2][1]
            [0][2] == [1][2] == [2][2]
             In String

            By Diagonal
            [0][0] == [1][1] == [2][2]
            [0][2] == [1][1] == [2][0]

            POSSIBLE TIE SCENARIO
            new String(currentBoard).indexOf("_") == -1 && winner == null
         */
    }


}
