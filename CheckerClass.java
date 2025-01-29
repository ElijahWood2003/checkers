

/**
 * Write a description of class CheckerClass here.
 *
 * @Elijah Wood
 * @version (a version number or a date)
 */
public class CheckerClass
{
    private String [][] board;
    private final int size = 8;
    private int turn;
    private final String [] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /**
     * Creates the checkerboard with W's and B's for pieces and O's
     * for blank spots, with letters on the edges
     */
    public CheckerClass(){
        board = new String[size + 1][size + 1];
        turn = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(r == 0 && c != 0){
                    board[r][c] = letters[c - 1];
                    continue;
                }
                else if(c == 0 && r != 0){
                    board[r][c] = letters[r - 1];
                    continue;
                }
                else if(c == 0 && r == 0){
                    board[r][r] = " ";
                    continue;
                }

                if(r % 2 == 1 && c % 2 == 0 && !(r == 4 || r == 5)){
                    if(r < 4){
                        board[r][c] = "W";
                    }
                    else {
                        board[r][c] = "B";
                    }
                }
                else if(r % 2 == 0 && c % 2 == 1 && !(r == 4 || r == 5)){
                    if(r < 4){
                        board[r][c] = "W";
                    }
                    else {
                        board[r][c] = "B";
                    }
                }
                else {
                    board[r][c] = "O";
                }
            }
        }
    }

    /**
     * Prints the board in a neat format
     */
    public void printBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Takes 4 positions and checks whether the move is legal based on:
     *     - Whose turn it is
     *     - Whether the initial position is on the right players piece
     *     - Whether the move is diagonal
     *     - Whether the move does not go out of bounds
     *     - Whether the move is "going forward" (no backwards movement)
     *         
     */
    public boolean isLegal(int r1, int c1, int r2, int c2){
        // Checking out of bounds
        if(r1 < 1 || r1 > board.length || r2 < 1 || r2 > board.length ||
        c1 < 1 || c1 > board.length || c2 < 1 || c2 > board.length){
            return false;
        }

        // Checking whether the initial piece is the right piece
        int f = c2 - c1; // Checks whether the direction in the columns was forward or backward
        int e = r2 - r1; // Checks whether the direction in the rows was forward or backward
        if(turn == 0){
            if(board[r1][c1].equals("W")){
                if(Math.abs(c2 - c1) == 1 && (r2 - r1) == 1){
                    if(board[r2][c2] == "O"){
                        return true;
                    }
                }
                else if(f == 2 && (board[r2 - 1][c2 - 1] == "B" || board[r2 - 1][c2 - 1] == "2")){
                    if(board[r2][c2] == "O"){
                        board[r2 - 1][c2 - 1] = "O";
                        return true;
                    }
                }
                else if(f == -2 && (board[r2 - 1][c2 + 1] == "B" || board[r2 - 1][c2 + 1] == "2")){
                    if(board[r2][c2] == "O"){
                        board[r2 - 1][c2 + 1] = "O";
                        return true;
                    }
                }
            }
            else if(board[r1][c1].equals("1")){
                if(Math.abs(c2 - c1) == 1 && Math.abs(r2 - r1) == 1){
                    if(board[r2][c2] == "O"){
                        return true;
                    }
                }
                else if(f == 2 && e == 2 && (board[r2 - 1][c2 - 1] == "B" || board[r2 - 1][c2 - 1] == "2")){
                    if(board[r2][c2] == "O"){
                        board[r2 - 1][c2 - 1] = "O";
                        return true;
                    }
                }
                else if(f == -2 && e == 2 && (board[r2 - 1][c2 + 1] == "B" || board[r2 - 1][c2 + 1] == "2")){
                    if(board[r2][c2] == "O"){
                        board[r2 - 1][c2 + 1] = "O";
                        return true;
                    }
                }
                else if(f == 2 && e == -2 && (board[r2 + 1][c2 - 1] == "B" || board[r2 + 1][c2 - 1] == "2")){
                    if(board[r2][c2] == "O"){
                        board[r2 + 1][c2 - 1] = "O";
                        return true;
                    }
                }
                else if(f == -2 && e == -2 && (board[r2 + 1][c2 + 1] == "B" || board[r2 + 1][c2 + 1] == "2")){
                    if(board[r2][c2] == "O"){
                        board[r2 + 1][c2 + 1] = "O";
                        return true;
                    }
                }

            } 
        }
        else if(turn == 1){
            if(board[r1][c1].equals("B")){
                if(Math.abs(c2 - c1) == 1 && (r2 - r1) == -1){
                    if(board[r2][c2] == "O"){
                        return true;
                    }
                }
                else if(f == 2 && (board[r2 + 1][c2 - 1] == "W" || board[r2 + 1][c2 - 1] == "1")){
                    if(board[r2][c2] == "O"){
                        board[r2 + 1][c2 - 1] = "O";
                        return true;
                    }
                }
                else if(f == -2 && (board[r2 + 1][c2 + 1] == "W" || board[r2 + 1][c2 + 1] == "1")){
                    if(board[r2][c2] == "O"){
                        board[r2 + 1][c2 + 1] = "O";
                        return true;
                    }
                }
            }
            else if(board[r1][c1].equals("2")){
                if(Math.abs(c2 - c1) == 1 && Math.abs(r2 - r1) == 1){
                    if(board[r2][c2] == "O"){
                        return true;
                    }
                }
                else if(f == 2 && e == 2 && (board[r2 - 1][c2 - 1] == "W" || board[r2 - 1][c2 - 1] == "1")){
                    if(board[r2][c2] == "O"){
                        board[r2 - 1][c2 - 1] = "O";
                        return true;
                    }
                }
                else if(f == -2 && e == 2 && (board[r2 - 1][c2 + 1] == "W" || board[r2 - 1][c2 + 1] == "1")){
                    if(board[r2][c2] == "O"){
                        board[r2 - 1][c2 + 1] = "O";
                        return true;
                    }
                }
                else if(f == 2 && e == -2 && (board[r2 + 1][c2 - 1] == "W" || board[r2 + 1][c2 - 1] == "1")){
                    if(board[r2][c2] == "O"){
                        board[r2 + 1][c2 - 1] = "O";
                        return true;
                    }
                }
                else if(f == -2 && e == -2 && (board[r2 + 1][c2 + 1] == "W" || board[r2 + 1][c2 + 1] == "1")){
                    if(board[r2][c2] == "O"){
                        board[r2 + 1][c2 + 1] = "O";
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     * Takes a statement and makes the move on the board if it is legal
     */
    public void makeMove(String statement){
        if(statement.length() != 8){
            System.out.println("Please follow syntax.");
            return;
        }

        int r1 = 1;
        int c1 = 1;
        int r2 = 1;
        int c2 = 1;

        // Getting the position of the piece being moved 
        while(!letters[r1 - 1].equals(statement.substring(0, 1))){
            if(r1 < letters.length){
                r1++;
            }
            else {
                System.out.println("Please follow syntax.");
                return;
            }
        }
        while(!letters[c1 - 1].equals(statement.substring(1, 2))){
            if(c1 < letters.length){
                c1++;
            }
            else {
                System.out.println("Please follow syntax.");
                return;
            }
        } 

        // Getting the position of the movement
        while(!letters[r2 - 1].equals(statement.substring(6, 7))){
            if(r2 < letters.length){
                r2++;
            }
            else {
                System.out.println("Please follow syntax.");
                return;
            }
        
        }
        while(!letters[c2 - 1].equals(statement.substring(7, 8))){
            if(c2 < letters.length){
                c2++;
            }
            else {
                System.out.println("Please follow syntax.");
                return;
            }
        }
        
        // Checking if the move is legal
        if(isLegal(r1, c1, r2, c2)){
            board[r2][c2] = board[r1][c1];
            board[r1][c1] = "O";

            if(turn == 0){
                if(r2 == board.length - 1){
                    board[r2][c2] = "1";
                }
                turn = 1;
            }
            else {
                if(r2 == 1){
                    board[r2][c2] = "2";
                }
                turn = 0;
            }
        }
        else {
            System.out.println("Illegal move.");
        }
    }
    

    /**
     * Returns whose turn it is in string form of "Black" or "White"
     */
    public String getTurn(){
        if(turn == 0){
            return "White";
        }
        else {
            return "Black";
        }
    }

    /**
     * Checks if either of the players won and returns the color if they did
     */
    public String whoWon(){
        int b = 0;
        int w = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c].equals("W") || board[r][c].equals("1")){
                    w++;
                }
                else if(board[r][c].equals("B") || board[r][c].equals("2")){
                    b++;
                }
            }
        }

        if(b == 0){
            return "White";
        }
        else if(w == 0){
            return "Black";
        }
        else {
            return "None";
        }
    }

}
