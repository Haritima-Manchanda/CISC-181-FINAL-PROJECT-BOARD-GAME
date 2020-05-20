package cisc181.lab_4;

public abstract class Piece {
    private String symbol;
    private String color;
    private boolean hidden;
    private boolean masterPiece;
    public Piece(String symbol, String color){
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;
        this.masterPiece = false;
    }
    public Piece(){
        this("default","green");
        this.hidden = false;}
    public abstract void speak();
    public String getSymbol() {
        return symbol;}
    public String getColor() {
        return color;}
    public boolean isMasterPiece(){
        return masterPiece;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public void setMasterPiece(boolean bool){
        this.masterPiece = bool;
    }
    public void setColor(String color){
        this.color = color;}
    public boolean isHidden() {
        return hidden;}
    public void setHidden(boolean hidden) {
        this.hidden = hidden;}
    public abstract boolean validPath(int oldRow, int oldCol,int newRow,int newCol);
    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }
}
