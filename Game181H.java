package cisc181.lab_4;

import java.util.ArrayList;
import java.util.Collections;

public class Game181H extends GameH {
    public Game181H(int numRows,int numColumns, TeamH team1,TeamH team2){
        super(numRows,numColumns,team1,team2);
    }

    /*@Override
    public boolean isAWinner() {
        return (getCurrentTeam().getTeamPieces().size()==0)&&
                (getOpponentTeam().getTeamPieces().size()>0)
                ||
                (getOpponentTeam().getTeamPieces().size()==0)&&
                        (getCurrentTeam().getTeamPieces().size()>0);
    }*/
    public boolean isAWinner(){
        if(getCurrentTeam().getTeamPieces().size()>getOpponentTeam().getTeamPieces().size()){
            return true;
        }
        else if(getOpponentTeam().getTeamPieces().size()>getCurrentTeam().getTeamPieces().size()){
            return true;
        }
        return false;
    }

    //checks if the teampieces in either the current or opponent teams are missing a masterpiece by keeping track of the normal piece
    //and if the normal pieces left is equal to the arraylist size
    public boolean masterCaptured(){
        int normalPieceCount=0;
        int normalPieceCount1 = 0;
        for(int i = 0;i<this.getCurrentTeam().getTeamPieces().size();i++){
            if(this.getCurrentTeam().getTeamPieces().get(i).isMasterPiece()==false){
                normalPieceCount++;
            }
        }
        for(int i =0;i<this.getOpponentTeam().getTeamPieces().size();i++){
            if(this.getOpponentTeam().getTeamPieces().get(i).isMasterPiece()==false){
                normalPieceCount1++;
            }
        }

        if(normalPieceCount==this.getCurrentTeam().getTeamPieces().size()||normalPieceCount1==this.getOpponentTeam().getTeamPieces().size()){
            return true;
        }
        return false;
    }


    @Override
    public boolean isGameEnded() {
        return ((getCurrentTeam().getTeamPieces().size()==0)||
                (getOpponentTeam().getTeamPieces().size()==0))||masterCaptured();
    }

    public TeamH getWinner() {
        if (isAWinner() == true) {
            if(getCurrentTeam().getTeamPieces().size()==0)
                return getOpponentTeam();
            else
                return getCurrentTeam();
        }
        else if(masterCaptured()==true){
        int normalPieceCount=0;
        int normalPieceCount1 = 0;
        for(int i = 0;i<this.getCurrentTeam().getTeamPieces().size();i++){
            if(this.getCurrentTeam().getTeamPieces().get(i).isMasterPiece()==false){
                normalPieceCount++;
            }
        }
        for(int i =0;i<this.getOpponentTeam().getTeamPieces().size();i++){
            if(this.getOpponentTeam().getTeamPieces().get(i).isMasterPiece()==false){
                normalPieceCount1++;
            }
        }
        if(normalPieceCount==this.getCurrentTeam().getTeamPieces().size()){
            return getOpponentTeam();
        }
        else if(normalPieceCount1==this.getOpponentTeam().getTeamPieces().size()){
            return getCurrentTeam();
        }}
        return null;
    }

    public String strHiddenBoard() {
        Piece curPiece;
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");
        for (int col = 0; col < getBoard().getSpaces()[0].length; col++) {
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for (int row = 0; row < getBoard().getSpaces().length; row++) {
            boardString.append("Row : " + row + "  ");
            for (int col = 0; col < getBoard().getSpaces()[row].length; col++) {
                curPiece = getBoard().getSpaces()[row][col].getPiece();
                if (curPiece == null) {
                    boardString.append("------" +"  ");
                }
                else if (curPiece.isHidden() &&
                getOpponentTeam().getTeamPieces().contains(curPiece)){
                    boardString.append("------" + "  ");
                }
else {
                    boardString.append(getBoard().getSpaces()[row][col].toString() +"");
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game ToolBox:\n").append(gameToolBox.toString());
        retString.append(String.join("", Collections.nCopies(50, "*")))
            .append(String.join("", Collections.nCopies(50, "*")))
        .append("\n\n" + getCurrentTeam().toString() + "\n")
        .append(String.join("", Collections.nCopies(50, "*")))
        .append("\n\n" + getOpponentTeam().toString() + "\n")
        .append(String.join("", Collections.nCopies(50, "*")))
        .append("\nGame Board:\n")
        .append(strHiddenBoard())
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }


}
