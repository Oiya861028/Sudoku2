public class Sudoku {
    private final int[][] board;
    private final int N;
    private final int SRN;
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
    private int calcStartingRowOrCol(int n){
        return n-n*SRN;
    }

    private boolean validInCell(int row, int col, int num){
        row = calcStartingRowOrCol(row);
        col = calcStartingRowOrCol(col);
        for(int i=0;i<SRN;i++){
            for(int j=0;j<SRN;j++){
                if(board[row+i][col+j]==num) return false;
            }
        }
        return true;
    }
    private boolean isValidNum(int startingRow, int startingCol, int num){
        return (validInCell(startingRow,startingCol,num) && validInCol(startingCol,num) && validInRow(startingRow,num));
    }
    private int generateRandomInt(int upperLim){
        return (int) (Math.random()*upperLim)+1;
    }
    private void fillBlock(int startingRow,int startingCol){
        int num;
        for(int i=0;i<SRN;i++){
            for(int j=0;j<SRN;j++){
                num = generateRandomInt(N);
                if(validInCell(startingRow,startingCol,num));
                board[startingRow+i][startingCol+j]=num;
            }
        }
    }
    private void fillDiagonalCells(){
        for(int i=0;i<N;i+=3){
            fillBlock(i,i);
        }
    }
    private void fillRemaining(){

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
