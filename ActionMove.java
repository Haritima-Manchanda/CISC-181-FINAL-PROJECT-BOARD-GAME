package cisc181.lab_4;

public class ActionMove extends Action{
    public ActionMove(Game181H game181Object, int rowInitial, int columnInitial, int rowFinal, int columnFinal){
        super(game181Object,rowInitial,columnInitial,rowFinal,columnFinal);
    }
    public boolean validAction(){
        return fromSpaceValid() && toSpaceValid(true) && validActionPath();
    }
    public void performAction(){
        Piece object = this.game.getBoard().getSpaces()[this.fromSpaceRow][fromSpaceCol].removePiece();
        this.game.getBoard().getSpaces()[this.toSpaceRow][toSpaceCol].setPiece(object);
        this.game.changeTurn();
    }

}
