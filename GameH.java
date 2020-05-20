package cisc181.lab_4;

import java.util.Collections;

public abstract class GameH {
    private Board board;
    private TeamH team1;
    private TeamH team2;
    protected ToolBox gameToolBox;
    private String turn;

    /*
    Purpose: find random spots for every piece on both teams
    General Algorithm: sets up a new board and a boardspace meant
    to temporarily store new boardspaces
    Then through for loops, finds a random space and sets that random space
    to a piece in the team's arraylist. Two for loops, to count for two different
    team arraylist lengths
     */
    private void initializeGameBoard(int numRow,int numCol){
        board = new Board(numRow,numCol);
        board.setUpEmptyBoard();
        BoardSpace me;
        for(int i =0;i<team1.getTeamPieces().size();i++){
            board.findRandomEmptySpace();
            me = board.findRandomEmptySpace();
            me.setPiece(team1.getTeamPieces().get(i));
        }
        for(int i=0;i<team2.getTeamPieces().size();i++){
            board.findRandomEmptySpace();
            me = board.findRandomEmptySpace();
            me.setPiece(team2.getTeamPieces().get(i));
        }
    }

    public GameH(int rows,int columns,TeamH team1,TeamH team2){
        this.team1 = team1;
        this.team2 = team2;
        turn = team1.getTeamName();
        initializeGameBoard(rows,columns);
        gameToolBox = new ToolBox(true);
        team1.getToolBox().addTool(gameToolBox.removeTool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER));
        team2.getToolBox().addTool(gameToolBox.removeTool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER));
    }
    public GameH(){
        this(0,0,null,null);
    }

    public Board getBoard(){
        return this.board;
    }
    public TeamH getCurrentTeam(){
        if (turn==team1.getTeamName())
            return team1;
        else
            return team2;
    }

    public TeamH getOpponentTeam() {
        if (turn == team1.getTeamName())
            return team2;
        else
            return team1;
    }

    public ToolBox getGameToolBox(){
        return gameToolBox;
    }

    public boolean isTurn(TeamH team){
        return turn==team.getTeamName();
    }

    public void changeTurn(){
        if(turn== team1.getTeamName())
            turn=team2.getTeamName();
        else{
            turn=team1.getTeamName();
        }
    }
    public abstract boolean isAWinner();
    public abstract TeamH getWinner();
    public abstract boolean isGameEnded();

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
                .append("\n" + getBoard().toString())
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }




}
