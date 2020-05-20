package cisc181.lab_4;
import java.util.Scanner;

public class PieceFrog extends PieceEggLaying implements Attacker {
    private int numAttacked;
    private int numRevived;


    public PieceFrog(String symbol, String color, int numEggs, int numAttacked){
        super(symbol,color,numEggs);
        this.numAttacked = numAttacked;
        this.numRevived = 0;

    }

    public boolean validPath(int rowInitialIndex, int columnInitialIndex,int rowFinalIndex, int columnFinalIndex){
        System.out.println("Can hop up,left,right, and down two spaces");

        int diffRows= Math.abs(rowFinalIndex-rowInitialIndex);
        int diffCols = Math.abs(columnFinalIndex-columnInitialIndex);

        if((diffRows == 2 && diffCols == 0) || (diffRows == 0 && diffCols ==2)){
            return true;
        }
        else{
            return false;
        }
    }

    public void speak(){
        System.out.println("Fly high, do or die, dare to dream, cheer extreme!");
    }

    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.numAttacked++;
        System.out.println("Attacks or Engulfs with its Tongue – other piece removed from game.");
        speak();
    }


    public void Revive(TeamH team){
        if(this.numRevived == 0) {
            String choice;

            Scanner scnr = new Scanner(System.in);
            System.out.println("Do you want to revive a piece??");
            choice = scnr.nextLine();

            if (choice.toUpperCase().equals("YES")) {
                String pieceReviveChoice;

                System.out.println("Which piece(BlueHen or Penguin) do you want to revive? Enter Either BlueHen or Penguin");
                pieceReviveChoice = scnr.nextLine();

                if (pieceReviveChoice.toUpperCase().equals("BLUEHEN")) {
                    PieceBlueHen blueHen = new PieceBlueHen("Hen", team.getTeamColor(),0, 0);
                    team.addPieceToTeam(blueHen);
                    System.out.println("Piece Added to: " + team);
                    this.numRevived++;
                }

                else if(pieceReviveChoice.toUpperCase().equals("PENGUIN")){
                    PiecePenguin penguin = new PiecePenguin("Penguin",team.getTeamColor(), 0, 0);
                    team.addPieceToTeam(penguin);
                    System.out.println("Piece Added to: " + team);
                    this.numRevived++;
                }
            }
            else {
                System.out.println("No piece added");
            }
        }

        else{
            System.out.println("Sorry cannot add piece. Exceeded limit for numAttacked");
        }
    }

    public PieceFrog layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.getNumEggs() < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PieceFrog(this.getSymbol(), this.getColor(),0,0);
        }
        else{
            return null;
        }
    }

}
