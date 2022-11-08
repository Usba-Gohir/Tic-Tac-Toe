import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main (String [] args) {
        System.err.println("");
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("");
        System.out.println("The board consists of positions 1-9 as seen below:");
        System.out.println("");
        char [] [] showGameBoard = {
            {'1' , '|' ,'2' , '|' , '3'}, 
            {'-' , '+' ,'-' , '+' , '-'},
            {'4' , '|' ,'5' , '|' , '6'},
            {'-' , '+' ,'-' , '+' , '-'},
            {'7' , '|' ,'8' , '|' , '9'}
          };
       
          for (char[] row: showGameBoard){
              for(char b:row){
                  System.out.print(b); 
                  }
  
              //prints out each char per line
              System.out.println();
              
        }

            /*
            the game has 3 rows indicates with 
            3 {} but there are spaces for the lines 
            so we need 5 {} instead*/
        char [] [] gameBoard = {
        {' ' , '|' ,' ' , '|' , ' '}, 
        {'-' , '+' ,'-' , '+' , '-'},
        {' ' , '|' ,' ' , '|' , ' '},
        {'-' , '+' ,'-' , '+' , '-'},
        {' ' , '|' ,' ' , '|' , ' '}
        };
    
        
        while (true) {
            //create scanner
            Scanner scan = new Scanner(System.in);
            System.out.println("");
            System.out.println("Enter your posiion number 1-9:");
            int a = scan.nextInt();
            
            while(playerPositions.contains(a)|| cpuPositions.contains(a)){
                System.out.println("Position takes!!!!!!!!!!");
                a = scan.nextInt();}

            System.out.println("You placed an X at position " + a);

            placingPiece(gameBoard, a, "player");
            System.out.println("");
            String result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                break;}

            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            while(playerPositions.contains(cpuPos)|| cpuPositions.contains(cpuPos)){
                System.out.println("Position taken!!!!!!!!!!");
                cpuPos = rand.nextInt(9)+1;}


            System.out.println("The cpu placed an O at position " + cpuPos);
            placingPiece(gameBoard, cpuPos, "cpu");
            System.out.println("");

            result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                break;
            }
        }
    }
        
    public static void printGameBoard(char [] [] gameBoard) {
        //print out for each row
        //print ot for each symbol
        for (char[] row: gameBoard){
            for(char c:row){
                System.out.print(c); 
                }

            //prints out each char per line
            System.out.println();
        }

    }

    public static void placingPiece (char [] [] gameBoard, int a, String user ) {
       
        //set variable for position in gameboard
        char symbol = ' ';
        //.equals for string cant use ==
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(a);
            }
        else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(a);

            }

        switch (a) {
            case 1: gameBoard[0][0] = symbol;
                break;
            case 2: gameBoard[0][2] = symbol;
                break;
            case 3: gameBoard[0][4] = symbol;
                break;
            case 4: gameBoard[2][0] = symbol;
                break;
            case 5: gameBoard[2][2] = symbol;
                break;
            case 6: gameBoard[2][4] = symbol;
                break;
            case 7: gameBoard[4][0] = symbol;
                break;
            case 8: gameBoard[4][2] = symbol;
                break;
            case 9: gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
       
        //to print charr array, call the method
        printGameBoard(gameBoard);

    }

    public static String checkWinner() {

        //create list: stores ordered collection

        //win in rows
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);

        //wins coloums
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List botCol = Arrays.asList(3,6,9);

        //wins in diagonals
        List leftDiag = Arrays.asList(1,5,9);
        List rightDiag = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow); 
        winning.add(midRow); 
        winning.add(botRow); 

        winning.add(leftCol); 
        winning.add(midCol); 
        winning.add(botCol); 

        winning.add(leftDiag); 
        winning.add(rightDiag);

        for(List l: winning) {
            if (playerPositions.containsAll(l)){
                return "You won!!!!!!!!";}
            else if (cpuPositions.containsAll(l)){
                return "sorry!!!!!! cpu won!!!!!!!";}
            else if (playerPositions.size()+cpuPositions.size()==9){
                return "tie!!!!!!";}
            
        }       
        return "";

    }
}