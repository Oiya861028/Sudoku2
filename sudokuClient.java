public class sudokuClient {
    public static void main(String[] args){
        Sudoku board1 = new Sudoku(9); //create a board with 9 by 9 grid
        board1.fillBoard();
        board1.printBoard();
    }
}
