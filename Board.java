package cisc181.lab_4;

public class Board {
    private int rows;
    private int columns;
    private BoardSpace[][]spaces;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        spaces = new BoardSpace[rows][columns];
        setUpEmptyBoard();
    }
    public Board(){
        this(0,0);
        spaces = new BoardSpace[0][0];
        setUpEmptyBoard();
    }

    public int getNumRows(){
        return rows;
    }

    public int getNumColumns(){
        return columns;
    }

    public BoardSpace[][] getSpaces(){
        return spaces;
    }

    //in bounds accepts row index and column index (in that order) and returns
    //a boolean value representing whether the location of this space is within the bounds of the
    //board
    //General Algorithm: if both row and column are greater than or equal to 0 and less than the rows and
    // columns fields, then return true
    public boolean inBounds(int row, int column){
        if((0<=row&&row<rows)&&(0<=column&&column<columns)){
            return true;
        }
        else{
            return false;
        }
    }
    //Purpose sets up a BoardSpace object for each space on board
    //Algorithm: Within every row, for every column, spaces holds
    // a new BoardSpace object. If row is odd, make that BoardSpace green, else blue
    public void setUpEmptyBoard(){
        String[] me = new String[2];
        me[0] = "Blue";
        me[1] = "Green";
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i%2==0){
                spaces[i][j]=new BoardSpace(i,j,me[1]);}
                else{
                    spaces[i][j]=new BoardSpace(i,j,me[0]);
                }

            }
        }
    }
//finds and returns an empty space on the board
//sets a random number to variables randomRow and randommColumn and a while loop continuously checks for
//the squares they correspond to in spaces until an empty space is found
    public BoardSpace findRandomEmptySpace() {
        int randomRow = (int) (Math.random() * rows-1);
        int randomColumn = (int) (Math.random() * columns-1);
        while(!(spaces[randomRow][randomColumn].isEmpty())) {
            randomRow = (int)(Math.random()*rows-1);
            randomColumn = (int)(Math.random()*columns-1);
        }
        return spaces[randomRow][randomColumn];
    }

    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");
        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   " );
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
    public static void main(String[]args){
        int numRows = 6;
        int numCols = 10;
        Board testBoard = new Board(numRows,numCols);
        testBoard.setUpEmptyBoard();
        // print the board all spaces should be empty
        System.out.println(testBoard.getSpaces().toString());
        System.out.println(testBoard.getNumRows());
        System.out.println(testBoard.getSpaces()[4][5]);
    }
}
