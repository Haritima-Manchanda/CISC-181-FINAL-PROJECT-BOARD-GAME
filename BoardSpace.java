package cisc181.lab_4;

public class BoardSpace {
    private int row;
    private int column;
    private String spaceColor;
    private boolean Empty;
    private Piece somePiece;

    public BoardSpace(int row,int column,String spaceColor){
        this.row = row;
        this.column = column;
        this.spaceColor = spaceColor;
        Empty = true;
    }
    public BoardSpace(){
        this(0,0,"Blue");
        Empty = true;
    }
    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public Piece getPiece(){
        return somePiece;
    }

    public String getSpaceColor(){
        return spaceColor;
    }

    public boolean isEmpty(){
        return Empty;
    }

    public void setPiece(Piece aPiece){
        somePiece = aPiece;
        Empty = false;
    }

    public Piece removePiece(){
        Empty = true;
        return somePiece;
    }

    public String toString(){
        if(isEmpty()){
            return "------";
        }
        else{
            return somePiece.getColor().charAt(0)+"-"+somePiece.getSymbol();
        }
    }

}
