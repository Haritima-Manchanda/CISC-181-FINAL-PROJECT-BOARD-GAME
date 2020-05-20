package cisc181.lab_4;

public abstract class Action {
    protected Game181H game;
    protected int fromSpaceRow;
    protected int fromSpaceCol;
    protected int toSpaceRow;
    protected int toSpaceCol;

    public Action(Game181H game181H, int rowInitial,int columnInitial, int rowFinal, int columnFinal){
        this.game = game181H;
        this.fromSpaceRow = rowInitial;
        this.fromSpaceCol = columnInitial;
        this.toSpaceRow = rowFinal;
        this.toSpaceCol = columnFinal;
    }

    public boolean fromSpaceValid(){

        return (this.game.getBoard().inBounds(this.fromSpaceRow,this.fromSpaceCol) &&
                this.game.getCurrentTeam().getTeamPieces().contains(this.game.getBoard().
                        getSpaces()[this.fromSpaceRow][this.fromSpaceCol].getPiece()));
    }

    public boolean toSpaceValid(boolean shouldBeEmpty){
        boolean value1;
        if(shouldBeEmpty){
            value1 = this.game.getBoard().inBounds(toSpaceRow,toSpaceCol)&&
                    this.game.getBoard().getSpaces()[this.toSpaceRow][this.toSpaceCol].isEmpty();
        }
        else{
            value1 = this.game.getBoard().inBounds(toSpaceRow,toSpaceCol)&&
                    this.game.getOpponentTeam().getTeamPieces().contains(this.game.getBoard().
                    getSpaces()[this.toSpaceRow][this.toSpaceCol].getPiece());
        }
        return  value1;
    }

    public boolean validActionPath(){
        return this.game.getBoard().getSpaces()[this.fromSpaceRow][this.fromSpaceCol].getPiece().
                validPath(this.fromSpaceRow,this.fromSpaceCol,this.toSpaceRow,this.toSpaceCol);
    }

    public abstract boolean validAction();
    public abstract void performAction();

}
