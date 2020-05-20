package cisc181.lab_4;

public class PieceHorse extends Piece implements Recruiter{

    public PieceHorse(String symbol, String color){
        super(symbol,color);
    }

    // constructor for when color information not available yet
    public PieceHorse(String symbol){
        this(symbol,"");
    }

    public void speak(){
        System.out.println("You mess with me, you mess with the whole squad");
    }

    public boolean validPath(int rowInitialIndex, int columnInitialIndex,int rowFinalIndex, int columnFinalIndex){
        System.out.println(("Can move any direction within three spaces"));

        int diffRows= Math.abs(rowFinalIndex-rowInitialIndex);
        int diffCols = Math.abs(columnFinalIndex-columnInitialIndex);
        if(diffRows <= 3 && diffCols <= 3){
            return true;
        }
        else{
            return false;
        }
    }


    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        System.out.println("You're on my team now! – other piece removed from other team and added to this team.");
        speak();
    }
}
