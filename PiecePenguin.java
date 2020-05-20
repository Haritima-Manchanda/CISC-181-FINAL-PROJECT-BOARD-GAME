package cisc181.lab_4;

public class PiecePenguin extends PieceEggLaying implements Attacker,Recruiter{

    private String symbol;
    private String color;
    private boolean hidden; // represents whether this piece is visible or hidden
    private int numAttacked;
    private int numEggs;

    public PiecePenguin(String symbol, String color, int numEggs, int numAttacked){
       super(symbol, color,numEggs);
        this.numEggs =numEggs;
        this.numAttacked = numAttacked;
        this.hidden = false;
    }

    // constructor for when color information not available yet
    public PiecePenguin(String symbol){
        this(symbol,"",0,0);
    }


    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }


    /**
    Purpose: See print message
     Algorithm: checks is columns are the same and the oldrow is one more or less than the new one.
     If that fails, the piece can still travel from column to column so it checks if the rows are the same
     **/
    public boolean validPath(int oldRow, int oldCol,int newRow,int newCol){
        System.out.println("Slide - piece can move left or right (one or more spaces) and NOT up and down");
        System.out.println("Or it can move one space up or down the board");
        return (((newCol==oldCol)&&((((oldRow+1)-newRow)==0)||((oldRow-1)-newRow==0)))|| (newRow==oldRow));
    }

    public void attack(int home, int homeCol, int enemyRow, int enemyCol){
        this.numAttacked++;
        System.out.println("Attack with lasers – other piece removed from game.");
        speak();
        System.out.println("Whoosh");
    }

    public void recruit(int homeRow, int homeCol, int enemyRow, int enemyCol){
        System.out.println("You're on my team now! – other piece removed from other team and added to this team.");
        speak();
        System.out.println("Recruited");
    }

    public PiecePenguin layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PiecePenguin(this.symbol, this.color,0,0);
        }
        else{
            return null;
        }
    }

    public int getNumEggs()  {
        return this.numEggs;
    }

    public int getNumAttacked()  {
        return this.numAttacked;
    }



    public void incrementNumAttacked( ){
        this.numAttacked++;
    }

/*    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }*/
}

