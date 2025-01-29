
import java.util.Scanner;

/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main (String [] args){
        int room = 0;
        CheckerClass c1 = new CheckerClass();
        CheckerClass c2 = new CheckerClass();
        boolean end = false;
        Scanner in = new Scanner (System.in);
        String statement = "";
        
        while (!end){  
            if(room == 0){ // This is the starting room where you begin
                System.out.print('\u000C');
                System.out.println("                Welcome to checkers!                      ");
                System.out.println("To play type 'Play', for instructions type 'Instructions'.");
                statement = in.nextLine();
                if(statement.equals("Instructions")){
                    room = 1;
                }
                else if(statement.equals("Play")){
                    room = 2;
                }
            }
            else if(room == 1){ // This is the instructions room
                System.out.print('\u000C');
                System.out.println("To play, use the syntax '[row][col] to [row][col]'.");
                System.out.println("The letters on the top and left of the board should");
                System.out.println("substitute for the row and col. The 'W' represent");
                System.out.println("white pieces, the 'B' represent black pieces, with");
                System.out.println("'1' and '2' for their kings, respectively.");
                System.out.println("Type 'Back' to go back to the menu.");
                statement = in.nextLine();
                if(statement.equals("Back")){
                    room = 0;
                }
            }
            else if(room == 2){ // This is the board game room
                if(c1.getTurn().equals("White")){
                    System.out.print('\u000C');
                    c1.printBoard();
                    System.out.println("Turn: " + c1.getTurn());
                    while(c1.getTurn().equals("White")){
                        statement = in.nextLine();
                        c1.makeMove(statement); 
                    }
                }
                else {
                    System.out.print('\u000C');
                    c1.printBoard();
                    System.out.println("Turn: " + c1.getTurn());
                    while(c1.getTurn().equals("Black")){
                        statement = in.nextLine();
                        c1.makeMove(statement); 
                    }
                }
                if(c1.whoWon().equals("None")){
                }
                else {
                    room = 3;
                }
            }
            else if(room == 3){ // This is the final room
                System.out.print('\u000C');
                System.out.println("         Good job " + c1.whoWon() + ". You won!");
                System.out.println("        To play again, type 'Play'");
                System.out.println("            To quit, type 'End'");
                c1.printBoard();
                statement = in.nextLine();
                if(statement.equals("Play")){
                    c1 = c2;
                    room = 2;
                }
                else if(statement.equals("End")){
                    end = true;
                }
            }
        }
    }
}
