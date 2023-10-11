import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void printGameBoard(char [][] gameBoard){
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }

    }
    public static void placePiece(char[][] gameBoard, int pos, String user){
        char symbol =' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch(pos){
            case 1:
                gameBoard [0][0] = symbol;
                break;
            case 2:
                gameBoard [0][2] = symbol;
                break;
            case 3:
                gameBoard [0][4] = symbol;
                break;
            case 4:
                gameBoard [2][0] = symbol;
                break;
            case 5:
                gameBoard [2][2] = symbol;
                break;
            case 6:
                gameBoard [2][4] = symbol;
                break;
            case 7:
                gameBoard [4][0] = symbol;
                break;
            case 8:
                gameBoard [4][2] = symbol;
                break;
            case 9:
                gameBoard [4][4] = symbol;
                break;
            default:
                break;
        }

    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List acrossLeft = Arrays.asList(1,5,9);
        List acrossRight = Arrays.asList(3,5,7);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(bottomRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(acrossRight);
        win.add(acrossLeft);

        for(List l: win){
            if(playerPositions.containsAll(l)){
                return "congradulations";
            }else if(cpuPositions.containsAll(l)) {
                return "You lose";
            }else if(playerPositions.size() + cpuPositions.size() == 9){
                return "CAT!";
            }
        }
        return "";
    }
   //we will create a simple tic-tac-toe game to recap java programming skills
    public static void main(String[] args) {
        // create 2d array for the gameboard
        char [][] gameBoard ={{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        }; //has 3 rows and 3 columns with lines in between
        printGameBoard(gameBoard);

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = sc.nextInt();
            placePiece(gameBoard, playerPos, "player");
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) +1; //to give random position for the cpu
            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);
            checkWinner();
        }

    }
}