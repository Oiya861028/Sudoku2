public class sudokuClient {
    public static void main(String[] args){
        Sudoku board1 = new Sudoku(9);
        board1.fillBoard();
        board1.printBoard();
    }
}
