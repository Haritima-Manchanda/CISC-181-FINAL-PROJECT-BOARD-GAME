package cisc181.lab_4;

public class PieceBlueHen extends PieceEggLaying implements Attacker{

    private String symbol;
    private String color;
    private boolean hidden; // represents whether this piece is visible or hidden
    private boolean fly;
    private int numEggs;
    private int numAttacked;

    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked){
        super(symbol,color,numEggs);
        this.numEggs =numEggs;
        this.numAttacked = numAttacked;
        this.hidden = false;
        updateFly();
    }

    // constructor for when color information not available yet
    // and brand new piece that hasn’t laid eggs and hasn’t attacked
    public PieceBlueHen(String symbol){
        this(symbol,"",0,0);
    }

    public void speak(){
        System.out.println("Go UD!");
    }



    public int getNumEggs()  {
        return this.numEggs;
    }

    public int getNumAttacked()  {
        return this.numAttacked;
    }
    public boolean canFly ()  {
        return this.fly;
    }
    public void incrementNumEggs(){
        super.incrementNumEggs();
        updateFly();
    }

    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }

    /*
    Purpose: See print message in function
    Algorithm: if it can fly, true everywhere
               if not, then return whether or not it's true that a row+/-1 is equal
               to the new row, as long as the column stays the same. If that's false,
               it checks for the same thing with column and row reversed.
     */
    public boolean validPath(int oldRow, int oldCol,int newRow,int newCol){
        System.out.println("If can't fly -> can move one space left, or right, or up, or down.\n" +
                "If can fly -> can move to any empty space on board.");
        boolean bool=false;
        if(!fly){
            bool=(((((oldRow+1)==newRow)||((oldRow-1)==newRow))&&(oldCol==newCol))
            ||((((oldCol+1)==newCol)||((oldCol-1)==newCol))&&(oldRow==newRow)));
        }
        else if(fly){
            bool= true;
        }
        return bool;
    }

    public void attack(int home, int homeCol, int enemyRow, int enemyCol){
        this.numAttacked++;
        System.out.println("Attack with lasers - other piece removed from game.");
        speak();
        System.out.println("Boom");
    }

    public PieceBlueHen layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBlueHen(this.symbol,this.color,this.numEggs,this.numAttacked);
        }
        else{
            return null;
        }
    }

    private void updateFly( ) {
        if (this.numEggs < MAX_EGGS) {
            this.fly = true;
        } else if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }

    public static void main(String[]args){
        PieceBlueHen bh = new PieceBlueHen("BH","Red",10,1);
        System.out.println(bh.validPath(6,20,7,10));
    }

}

