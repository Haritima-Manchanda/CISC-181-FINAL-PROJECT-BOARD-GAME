package cisc181.lab_4;


public class PieceSharkBait extends Piece implements Recruiter{

    /*private String symbol;
    private String color;
    private boolean hidden; // represents whether this piece is visible or hidden
*/

    public PieceSharkBait(String symbol, String color){
        super(symbol,color);
        /*
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;*/
    }

    // constructor for when color information is not available yet
    public PieceSharkBait(String symbol){
        this(symbol,"");
    }

    public void speak(){
        System.out.println("Shark bait oooh ha haa!");
    }

    /*
    Purpose: see print message
    Algorithm: checks if both the old columns and old rows when added or subtracted with 2, are divisible by
    the new rows and columns respectively
     */
    public boolean validPath(int oldRow, int oldCol,int newRow,int newCol) {
        System.out.println("can move 2 spaces diagonally");
        if(Math.abs(Math.sqrt(Math.pow(newRow-oldRow,2)+Math.pow(newCol-oldCol,2))-Math.sqrt(8))<=0.00001){
            return true;
        }
        return false;
    }

    public void recruit(int homeRow, int homeCol, int enemyRow, int enemyCol){
        System.out.println("You're on my team now! – other piece removed from other team and added to this team.");
        speak();
        System.out.println("Fun");
    }


}

