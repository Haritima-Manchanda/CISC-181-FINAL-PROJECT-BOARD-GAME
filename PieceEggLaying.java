package cisc181.lab_4;

public abstract class PieceEggLaying extends Piece {
    final public static int MAX_EGGS =2;
    private int numEggs;
    private String symbol;
    private String color;

    public PieceEggLaying(String symbol, String color,int numEggs) {
        super(symbol, color);
        this.numEggs = numEggs;
    }
    public PieceEggLaying(){
        this("default","blue",0);
    }

    public abstract PieceEggLaying layEgg();
    public void incrementNumEggs(){
        this.numEggs++;
    }
    public int getNumEggs()  {
        return this.numEggs;
    }


}
