public class Sudoku {
    private int[][] board;
    private int N;
    private int SRN;
    public Sudoku(int N){
        this.N = N;
        SRN = (int) Math.sqrt(N);
        board = new int[N][N];
    }
    private boolean validInRow(int i, int num){
        for(int j=0;j<N;j++){
            if(board[i][j]==num) return false;
        }
        return true;
    }
    private boolean validInCol(int j, int num){
        for(int i=0;i<N;i++){
            if(board[i][j]==num) return false;
        }
        return true;
    }
    private int findStartingCoord(int row, int col){
        return row-row*SRN col-col*SRN;
    }
    private boolean validInCell(int startingRow, int startingCol, int num){

    }
    private boolean isValidNum(int startingRow, int startingCol, int num){
        return (validInCell(startingRow,startingCol,num) && validInCol(startingCol,num) && validInRow(startingRow,num));
    }
    private int generateRandomInt(int upperLim){
        return (int) (Math.random()*upperLim)+1;
    }

    public void fillDiagonalCells(){

    }
    public void fillRemaining(){

    }
    public void fillBoard(){
        fillDiagonalCells();
        fillRemaining();
    }
    public void printBoard(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
