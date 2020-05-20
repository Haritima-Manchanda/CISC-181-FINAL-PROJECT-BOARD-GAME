package cisc181.lab_4;

public class ActionDuplicate extends Action{

    /* duplicate means that the new Piece will have the same symbol and color as the original piece
     */
    private int duplicates;

    public ActionDuplicate(Game181H game181Object, int rowInitial, int columnInitial, int rowFinal, int columnFinal){
        super(game181Object,rowInitial,columnInitial,rowFinal,columnFinal);
        this.duplicates = 0;
    }

    public boolean validAction(){
        return fromSpaceValid() && toSpaceValid(true) && validActionPath() && this.duplicates < 3;
    }
    public void performAction(){
        PieceHorse object = new PieceHorse(this.game.getBoard().getSpaces()[this.fromSpaceRow][fromSpaceCol].getPiece().getSymbol(), this.game.getBoard().getSpaces()[this.fromSpaceRow][fromSpaceCol].getPiece().getColor());
        this.game.getCurrentTeam().addPieceToTeam(object);
        this.game.getBoard().getSpaces()[this.toSpaceRow][toSpaceCol].setPiece(object);
        this.duplicates ++;
        this.game.changeTurn();
    }
}
