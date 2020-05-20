package cisc181.lab_4;

import java.util.ArrayList;

public class ActionRevive extends Action {
    /*
        Revive(): the frog piece has the ability to revive/add a Shark piece
        Changes made: Can revive/add only 1 shark piece for each team
    */

    protected int piecesRevived;

    public ActionRevive(Game181H game181Object, int rowInitial, int columnInitial, int rowFinal, int columnFinal){
        super(game181Object,rowInitial,columnInitial,rowFinal,columnFinal);
    }

    public boolean validAction(){
        return fromSpaceValid() && toSpaceValid(true) && validActionPath() && this.piecesRevived == 0;
    }

    public void performAction(){
        PieceSharkBait shark = new PieceSharkBait("Nemo", this.game.getCurrentTeam().getTeamColor());
        Piece pieceToRevive= null;
        if((this.game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece()instanceof PieceFrog)&&
                ActionAttack.attackedPieces.contains(shark)) {
            this.game.getCurrentTeam().addPieceToTeam(shark);
            this.game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(shark);
            System.out.println("Revive " + pieceToRevive+ " to "+this.game.getCurrentTeam());}
        else if((this.game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getRow()==3&&
                this.game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getColumn()==3)&&
                ActionAttack.attackedPieces.size()>0){
            for(Piece piece:ActionAttack.attackedPieces){
                if (piece.getColor().equals(this.game.getCurrentTeam().getTeamColor())){
                    pieceToRevive = piece;
                    break;
                }
            }
            this.game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(pieceToRevive);
            System.out.println("Revive "+pieceToRevive+" to "+this.game.getCurrentTeam());
        }
            this.game.changeTurn();
        }
}
