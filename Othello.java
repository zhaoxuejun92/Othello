import java.util.Scanner;

public class Othello {

    public static final int NONE = 0;
    public static final int BLACK = 1;
    public static final int WHITE = 2;
    public int length;
    public Scanner s;

    public int[][] board;
    
    public Othello(int length) {
       //TO-DO: create the initial state of the game
        this.board = new int[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                this.board[i][j] = NONE;
            }
        }

        board[length/2 - 1][length/2 - 1] = WHITE;
        board[length/2 - 1][length/2] = BLACK;
        board[length/2][length/2 - 1] = BLACK;
        board[length/2][length/2] = WHITE;
        this.length = length;
        this.s = new Scanner(System.in);
    }

    public boolean isValid(int row, int col, int player) {
        //TO-DO
        int OPPONENT;
        if(player == BLACK)
            OPPONENT = WHITE;
        else
            OPPONENT = BLACK;
        boolean bounded;
        int j;
        if((row >= length)||(col >= length)){
            return false;
        }else if (this.board[row][col] != NONE) {
            return false;
        } else {
            j = 1;
            bounded = false;
            while((col - j) >= 0){
                if(this.board[row][col - j] == NONE){
                    break;
                }else if(this.board[row][col - j] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row][col - j] == player) && bounded){
                    return true;
                }else{
                    break;
                }
            }

            j = 1;
            bounded = false;
            while ((col + j) < length){
                if(this.board[row][col + j] == NONE){
                    break;
                }else if(this.board[row][col + j] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row][col + j] == player) && bounded){
                    return true;
                }else {
                    break;
                }
            }

            j = 1;
            bounded = false;
            while ((row - j) >= 0){
                if(this.board[row - j][col] == NONE){
                    break;
                }else if(this.board[row - j][col] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row - j][col] == player) && bounded){
                    return true;
                }else{
                    break;
                }
            }

            j = 1;
            bounded = false;
            while ((row + j) < length){
                if(this.board[row + j][col] == NONE){
                    break;
                }else if(this.board[row + j][col] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row + j][col] == player) && bounded){
                    return true;
                }else{
                    break;
                }
            }

            j = 1;
            bounded = false;
            while(((row - j) >= 0)&&((col - j) >= 0)){
                if(this.board[row - j][col - j] == NONE){
                    break;
                }else if(this.board[row - j][col - j] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row - j][col - j] == player)&&bounded){
                    return true;
                }else {
                    break;
                }
            }

            j = 1;
            bounded = false;
            while(((row - j) >= 0)&&((col + j) < length)){
                if(this.board[row - j][col + j] == NONE){
                    break;
                }else if(this.board[row - j][col + j] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row - j][col + j] == player)&&bounded){
                    return true;
                }else{
                    break;
                }
            }

            j = 1;
            bounded = false;
            while(((row + j) < length)&&((col - j) >= 0)){
                if(this.board[row + j][col - j] == NONE){
                    break;
                }else if(this.board[row + j][col - j] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row + j][col - j] == player)&&bounded){
                    return true;
                }else{
                    break;
                }
            }

            j = 1;
            bounded = false;
            while(((row + j) < length)&&((col + j) < length)){
                if(this.board[row + j][col + j] == NONE){
                    break;
                }else if(this.board[row + j][col + j] == OPPONENT){
                    bounded = true;
                    j = j + 1;
                }else if((this.board[row + j][col + j] == player)&&bounded){
                    return true;
                }else{
                    break;
                }
            }

        }
            return false;
    }


    public boolean hasValidMoves(int player) {
        //TO-DO
        int row;
        int col;
        int k;
        for (int i = 0; i< this.length; i++){
            for(int j = 0; j< this.length; j++){
                if (this.board[i][j] == player){
                    row = i;
                    col = j;
                    if (((col - 1) >= 0) && (this.board[row][col - 1] != NONE) && (this.board[row][col - 1] != player)){
                        k = 2;
                        while((col - k) >= 0){
                            if(this.board[row][col - k] == NONE){
                                return true;
                            }else if(this.board[row][col - k] != player){
                                k = k + 1;
                            }else if(this.board[row][col - k] == player){
                                break;
                            }
                        }
                    }
                    if (((col + 1) < length) && (this.board[row][col + 1] != NONE) && (this.board[row][col + 1] !=
                            player)){
                        k = 2;
                        while((col + k) < length){
                            if(this.board[row][col + k] == NONE){
                                return true;
                            }else if(this.board[row][col + k] != player){
                                k = k + 1;
                            }else if(this.board[row][col + k] == player){
                                break;
                            }
                        }
                    }
                    if (((row - 1) >= 0) && (this.board[row - 1][col] != NONE) && (this.board[row - 1][col] !=
                            player)){
                        k = 2;
                        while((row - k) > 0){
                            if(this.board[row - k][col] == NONE){
                                return true;
                            }else if(this.board[row - k][col] != player){
                                k = k + 1;
                            }else if(this.board[row - k][col] == player){
                                break;
                            }
                        }
                    }
                    if (((row + 1) < length) && (this.board[row + 1][col] != NONE) && (this.board[row + 1][col] !=
                            player)){
                        k = 2;
                        while((row + k) < length){
                            if(this.board[row + k][col] == NONE){
                                return true;
                            }else if(this.board[row + k][col] != player){
                                k = k + 1;
                            }else if(this.board[row + k][col] == player){
                                break;
                            }
                        }
                    }
                    if (((row - 1) >= 0)&&((col - 1)>= 0) && (this.board[row - 1][col - 1] != NONE) && (this
                            .board[row -
                            1][col- 1] !=
                            player)){
                        k = 2;
                        while(((row - k) >= 0)&&((col - k)>= 0)){
                            if(this.board[row - k][col - k] == NONE){
                                return true;
                            }else if(this.board[row - k][col - k] != player){
                                k = k + 1;
                            }else if(this.board[row - k][col - k] == player){
                                break;
                            }
                        }
                    }
                    if (((row - 1) >= 0)&&((col + 1) < length) && (this.board[row - 1][col + 1] != NONE) && (this
                            .board[row -
                            1][col+ 1] !=
                            player)){
                        k = 2;
                        while(((row - k) >= 0)&&((col + k)< length)){
                            if(this.board[row - k][col + k] == NONE){
                                return true;
                            }else if(this.board[row - k][col + k] != player){
                                k = k + 1;
                            }else if(this.board[row - k][col + k] == player){
                                break;
                            }
                        }
                    }
                    if (((row + 1) < length)&&((col - 1) >= 0) && (this.board[row + 1][col - 1] != NONE) && (this
                            .board[row +
                            1][col - 1] !=
                            player)){
                        k = 2;
                        while(((row + k) < length)&&((col - k)>= 0)){
                            if(this.board[row + k][col - k] == NONE){
                                return true;
                            }else if(this.board[row + k][col - k] != player){
                                k = k + 1;
                            }else if(this.board[row + k][col - k] == player){
                                break;
                            }
                        }
                    }
                    if (((row + 1) < length)&&((col + 1) < length) && (this.board[row + 1][col + 1] != NONE) && (this
                            .board[row +
                            1][col + 1] !=
                            player)){
                        k = 2;
                        while(((row + k) < length)&&((col + k)<length)){
                            if(this.board[row + k][col + k] == NONE){
                                return true;
                            }else if(this.board[row + k][col + k] != player){
                                k = k + 1;
                            }else if(this.board[row + k][col + k] == player){
                                break;
                            }
                        }
                    }

                }
            }
        }
        return false;
    }


    public void makeMove(int row, int col, int player) {
        //TO-DO
        this.board[row][col] = player;
        boolean bounded;
        int OPPONENT;
        int j;
        int loc = col;
        if(player == BLACK)
            OPPONENT = WHITE;
        else
            OPPONENT = BLACK;
        j = 1;
        bounded = false;
        while((col - j) >= 0){
            if(this.board[row][col - j] == NONE){
                break;
            }else if(this.board[row][col - j] == OPPONENT){
                j = j + 1;
            }else if(this.board[row][col - j] == player){
                bounded = true;
                loc = col - j;
                break;
            }
        }
        if(bounded){
            for(int i = loc + 1; i < col; i++){
                this.board[row][i] = player;
            }
        }

        j = 1;
        bounded = false;
        while ((col + j) < length){
            if(this.board[row][col + j] == NONE){
                break;
            }else if(this.board[row][col + j] == OPPONENT){
                j = j + 1;
            }else if(this.board[row][col + j] == player){
                bounded = true;
                loc = col + j;
                break;
            }
        }
        if(bounded){
            for(int i = col + 1; i < loc; i++){
                this.board[row][i] = player;
            }
        }

        j = 1;
        bounded = false;
        while ((row - j) >= 0){
            if(this.board[row - j][col] == NONE){
                break;
            }else if(this.board[row - j][col] == OPPONENT){
                j = j + 1;
            }else if(this.board[row - j][col] == player){
                bounded = true;
                loc = row - j;
                break;
            }
        }
        if(bounded){
            for(int i = loc + 1; i < row; i++){
                this.board[i][col] = player;
            }
        }

        j = 1;
        bounded = false;
        while ((row + j) < length){
            if(this.board[row + j][col] == NONE){
                break;
            }else if(this.board[row + j][col] == OPPONENT){
                j = j + 1;
            }else if(this.board[row + j][col] == player){
                bounded = true;
                loc = row + j;
                break;
            }
        }
        if(bounded){
            for(int i = row + 1; i < loc; i++){
                this.board[i][col] = player;
            }
        }

        j = 1;
        bounded = false;
        while(((row - j) >= 0)&&((col - j) >= 0)){
            if(this.board[row - j][col - j] == NONE){
                break;
            }else if(this.board[row - j][col - j] == OPPONENT){
                j = j + 1;
            }else if(this.board[row - j][col - j] == player){
                bounded = true;
                loc = j;
                break;
            }
        }
        if(bounded){
            for(int i = 1; i < j; i++){
                this.board[row - i][col - i] = player;
            }
        }

        j = 1;
        bounded = false;
        while(((row - j) >= 0)&&((col + j) < length)){
            if(this.board[row - j][col + j] == NONE){
                break;
            }else if(this.board[row - j][col + j] == OPPONENT){
                j = j + 1;
            }else if(this.board[row - j][col + j] == player){
                bounded = true;
                loc = j;
                break;
            }
        }
        if(bounded){
            for(int i = 1; i < j; i++){
                this.board[row - i][col + i] = player;
            }
        }

        j = 1;
        bounded = false;
        while(((row + j) < length)&&((col - j) >= 0)){
            if(this.board[row + j][col - j] == NONE){
                break;
            }else if(this.board[row + j][col - j] == OPPONENT){
                j = j + 1;
            }else if(this.board[row + j][col - j] == player){
                bounded = true;
                loc = j;
                break;
            }
        }
        if(bounded){
            for(int i = 1; i < j; i++){
                this.board[row + i][col - i] = player;
            }
        }

        j = 1;
        bounded = false;
        while(((row + j) < length)&&((col + j) < length)){
            if(this.board[row + j][col + j] == NONE){
                break;
            }else if(this.board[row + j][col + j] == OPPONENT){
                j = j + 1;
            }else if(this.board[row + j][col + j] == player){
                bounded = true;
                loc = j;
                break;
            }
        }
        if(bounded){
            for(int i = 1; i < j; i++){
                this.board[row + i][col + i] = player;
            }
        }
    }

    public void checkwinner(){
        int blacknumber = 0;
        int whilenumber = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(this.board[i][j] == BLACK)
                    blacknumber = blacknumber + 1;
                else if(this.board[i][j] == WHITE)
                    whilenumber = whilenumber + 1;
            }
        }
        if(blacknumber > whilenumber){
            System.out.println("BLACK WINS!");
            System.out.println("CONGRADUATIONS!");
        }else if(blacknumber < whilenumber){
            System.out.println("WHITE WINS!");
            System.out.println("CONGRADUATIONS!");
        }else if(blacknumber == whilenumber){
            System.out.println("THERE IS A TIE!");
        }
    }

    public void playGame() {
       //TO-DO
        int row;
        int col;
        int player = BLACK;
        while(this.hasValidMoves(BLACK)||this.hasValidMoves(WHITE)){
            if(this.hasValidMoves(player)){
                this.printBoard(player);
                if(player == BLACK)
                    System.out.println("Current player: X");
                else if(player == WHITE)
                    System.out.println("Current player: O");
                do{
                    System.out.println("Enter a valid position");
                    System.out.println("Row");
                    row = s.nextInt();
                    System.out.println("Column");
                    col = s.nextInt();
                }while(!this.isValid(row,col,player));
                this.makeMove(row,col,player);
            }
            if(player == BLACK)
                player = WHITE;
            else if(player == WHITE)
                player = BLACK;
        }
        this.checkwinner();
    }
    
   /**
     * This method prints the board to the console
     * @param turn current turn
     */
   public void printBoard(int turn) {
        int numBlacks = 0;
        int numWhites = 0;
        System.out.println();
        System.out.printf("   ");
        for (int i = 0; i < this.board.length; i++) {
            System.out.printf(" " + i + "  ");
        }
        System.out.printf("\n  ");
        for (int i = 0; i < this.board.length; i++) {
            System.out.printf("----");
        }
        System.out.println();
        for (int i = 0; i < this.board.length; i++) {
            System.out.printf(i + " |");
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == WHITE) {
                    System.out.printf(" O |");
                    numWhites++;
                } else if (this.board[i][j] == BLACK) {
                    System.out.printf(" X |");
                    numBlacks++;
                } else if (isValid(i, j, turn)) {
                    System.out.printf(" * |");
                } else {
                    System.out.printf("   |");
                }
            }
            System.out.println();
            System.out.printf("  ");
            for (int j = 0; j < this.board.length; j++) {
                System.out.printf("----");
            }
            System.out.println();

        }
        System.out.println("Black: " + numBlacks + " - " + "White: " + numWhites);
        System.out.println();

    }

    /**
     * Main method to run a round of othello
     * @param args command line parameters
     */
    public static void main(String[] args) {
        // you may change the input to experiment with other boards
        Othello game = new Othello(4);
        game.playGame();
    }


}