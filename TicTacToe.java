import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    static String[][] board = new String[3][3];
    static Boolean turn = false;
    //player 1 = false
    //player 2 = true
    static String winner = "?";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (String[] chars : board) {
            Arrays.fill(chars, "_");
        }
        while (Objects.equals(winner, "?")) {
            System.out.println(getBoard());
            if (turn) {
                System.out.println("Please input the space you want to put an O player 2:");
            } else {
                System.out.println("Please input the space you want to put an X player 1:");
            }
            takeTurn();
        }
        if (Objects.equals(winner, "Tie")) {
            System.out.println("Its a Tie!");
        } else {
            System.out.println(winner + " Won!");
        }
    }
    public static String getBoard(){
        return Arrays.toString(board[0]).concat("\n" + Arrays.toString(board[1]).concat("\n" + Arrays.toString(board[2])));
    }
    public  static void detectWin(String[][] currentBoard){
        String stringBoard= "";
        for(String[] rows : currentBoard){
            for (String row : rows) {
                stringBoard = stringBoard.concat(row);
            }
        }
        if(!stringBoard.contains("_") && Objects.equals(winner, "?")){
            winner = "Tie";
        }
        else {
            //By Row
            if(stringBoard.charAt(0) == stringBoard.charAt(1) && stringBoard.charAt(1) == stringBoard.charAt(2)){
                //Top Row Win
                if(stringBoard.charAt(0) != '_'){
                    winner = String.valueOf(stringBoard.charAt(0));
                }
            }
            if(stringBoard.charAt(3) == stringBoard.charAt(4) && stringBoard.charAt(4) == stringBoard.charAt(5)){
                //Middle Row Win
                if(stringBoard.charAt(3) != '_'){winner = String.valueOf(stringBoard.charAt(3));}
            }
            if(stringBoard.charAt(6) == stringBoard.charAt(7) && stringBoard.charAt(7) == stringBoard.charAt(8)){
                //Bottom Row Win
                if(stringBoard.charAt(6) != '_'){winner = String.valueOf(stringBoard.charAt(6));}
            }

            //By Column
            if(stringBoard.charAt(0) == stringBoard.charAt(3) && stringBoard.charAt(3) == stringBoard.charAt(6)){
                //Left Column Win
                if(stringBoard.charAt(0) != '_'){winner = String.valueOf(stringBoard.charAt(0));}
            }
            if(stringBoard.charAt(1) == stringBoard.charAt(4) && stringBoard.charAt(4) == stringBoard.charAt(7)){
                //Middle Colum Win
                if(stringBoard.charAt(1) != '_'){winner = String.valueOf(stringBoard.charAt(1));}
            }
            if(stringBoard.charAt(2) == stringBoard.charAt(5) && stringBoard.charAt(5) == stringBoard.charAt(8)){
                //Right Column Win
                if(stringBoard.charAt(2) != '_'){winner = String.valueOf(stringBoard.charAt(2));}
            }

            //By Diagonal
            if(stringBoard.charAt(0) == stringBoard.charAt(4) && stringBoard.charAt(4) == stringBoard.charAt(8)){
                //Top Left - Bottom Right Diagonal Win
                if(stringBoard.charAt(0) != '_'){winner = String.valueOf(stringBoard.charAt(0));}
            }
            if(stringBoard.charAt(2) == stringBoard.charAt(4) && stringBoard.charAt(4) == stringBoard.charAt(6)){
                //Top Right - Bottom Left Diagonal Win
                if(stringBoard.charAt(2) != '_'){winner = String.valueOf(stringBoard.charAt(2));}
            }
        }
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
             [0] == [3] == [6]
             [1] == [4] == [7]
             [2] == [5] == [8]

            By Diagonal
              In Array
            [0][0] == [1][1] == [2][2]
            [0][2] == [1][1] == [2][0]
              In String
            [0] == [4] == [8]
            [2] == [4] == [6]

            POSSIBLE TIE SCENARIO
            new String(currentBoard).indexOf("_") == -1 && winner == null
         */
    }

    public static Boolean updateBoard(String input, String[][] currentBoard, String player){
        input = input.toLowerCase();
        switch (input){
            case "tl", "top left", "lt", "left top":
                if(Objects.equals(currentBoard[0][0], "_")){
                currentBoard[0][0] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
            case "tm", "top middle", "top mid", "top center", "tc", "center top", "ct", "mid top", "middle top", "mt":
                if(Objects.equals(currentBoard[0][1], "_")){
                currentBoard[0][1] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "tr", "top right":
                if(Objects.equals(currentBoard[0][2], "_")){
                currentBoard[0][2] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "lm", "left middle", "middle left", "ml":
                if(Objects.equals(currentBoard[1][0], "_")){
                currentBoard[1][0] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "center", "middle", "c", "m":
                if(Objects.equals(currentBoard[1][1], "_")){
                currentBoard[1][1] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "rm", "right middle", "middle right", "mr":
                if(Objects.equals(currentBoard[1][2], "_")){
                currentBoard[1][2] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "bl", "bottom left", "left bottom", "lb":
                if(Objects.equals(currentBoard[2][0], "_")){
                currentBoard[2][0] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "bm", "bottom middle", "mb", "bottom center", "bc", "cb", "center bottom":
                if(Objects.equals(currentBoard[2][1], "_")){
                currentBoard[2][1] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            case "br", "bottom right", "rb", "right bottom":
                if(Objects.equals(currentBoard[2][2], "_")){
                currentBoard[2][2] = player;
                detectWin(currentBoard);
                return true;}
                else{
                    System.out.println("That Space Is Taken!");
                    return false;
                }
                
            default:
                System.out.println("ERROR: Input out of bounds. \n Try using things like: bottom right, br, center, c for inputs instead");
                return false;
                
        }

    }

    public static void takeTurn(){
        if(turn && Objects.equals(winner, "?")){
            if(updateBoard(sc.next(), board, "O")) {
                turn = false;
            }
        }
        else {
            if(updateBoard(sc.next(), board, "X")) {
                turn = true;
            }
        }
    }

}
