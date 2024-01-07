public class Sudoku {
    private final int[][] board;
    private final int N; //dimensions
    private final int SRN; //square root of dimension, useful for calculation
    public Sudoku(int N){
        this.N = N;
        SRN = (int) Math.sqrt(N);
        board = new int[N][N];
    }
    private boolean validInRow(int i, int num){ //loop through every number on the same row on the grid
        for(int j=0;j<N;j++){
            if(board[i][j]==num) return false;
        }
        return true;
    }
    private boolean validInCol(int j, int num){ //loop through every num on the same col on the grid
        for(int i=0;i<N;i++){
            if(board[i][j]==num) return false;
        }
        return true;
    }
    private int calcStartingRowOrCol(int n){ //helper method for placing diagonals that resets the coordinate to the coordinate of the cell
        return n-n%SRN;
    }

    private boolean validInCell(int row, int col, int num){ //Helper method for placing diagonal and checking cell numbers
        row = calcStartingRowOrCol(row);
        col = calcStartingRowOrCol(col);
        for(int i=0;i<SRN;i++){
            for(int j=0;j<SRN;j++){
                if(board[row+i][col+j]==num) return false;
            }
        }
        return true;
    }
    private boolean isValidNum(int row, int col, int num){ //combination of three checks above
        return (validInCell(row,col,num) && validInCol(col,num) && validInRow(row,num));
    }
    private int generateRandomInt(int upperLim){ //generator that doesn't use Random class
        return (int) (Math.random()*upperLim)+1;
    }
    private void fillBlock(int startingRow,int startingCol){ //fill a three by three block
        int num;
        for(int i=0;i<SRN;i++){
            for(int j=0;j<SRN;j++){
                do{
                    num = generateRandomInt(N);
                }while(!isValidNum(startingRow,startingCol, num));
                board[startingRow+i][startingCol+j]=num;
            }
        }
    }
    private void fillDiagonalCells(){ //fill diagonal blocks that doesn't have any checks in between them
        for(int i=0;i<N;i+=SRN){
            fillBlock(i,i);
        }
    }
    private boolean fillRemaining(int row, int col){
        if(col >=N && row <N-1){ //if the end of the row is reached, move to next row
            row++;
            col =0;
        }
        if(col>=N && row>=N)
            return true; //if the end of the board is reached

        //skip diagonals
        if(row<SRN){ //top left
            if(col<SRN){
                col= SRN;
            }
        }
        else if(row<N-SRN){ //middle
            if(col==(row/SRN)*SRN){
                col+=SRN;
            }
        }
        else{ //bottom right
            if(col==N-SRN){
                row++;
                col=0;
                if(row>=N) return true;
            }
        }
        //recursion that moves on to the next grid and backtracks if the placed number doesn't lead to a solution
        for(int num=1;num<=N;num++){
            if(isValidNum(row, col, num)){
                board[row][col] = num;
                if(fillRemaining(row, col+1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }
    public void fillBoard(){ //method you can call in the client class
        fillDiagonalCells();
        fillRemaining(0, SRN);
    }
    public void printBoard(){ //method you can call in the client class
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
