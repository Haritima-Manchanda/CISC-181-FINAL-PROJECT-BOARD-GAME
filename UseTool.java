package cisc181.lab_4;

import java.util.ArrayList;
import java.util.Scanner;

public class UseTool {
    protected Game181H game;

    Scanner scnr = new Scanner(System.in);
    public UseTool(Game181H game181H){
        this.game = game181H;
    }

    public boolean validUseToolAction(Tool tool){
        if((!tool.getToolType().equals(Tool.ITEM.COIN)) && (this.game.getCurrentTeam().getToolBox().hasTool(tool.getToolType(),tool.getToolStrength()))){
            return true;
        }
        return false;
    }

    public void exchangeTool(Tool tool, ToolBox toolBoxRemovedFrom, ToolBox toolBoxAddedTo){
        toolBoxAddedTo.addTool(tool);
        toolBoxRemovedFrom.removeTool(tool.getToolType(),tool.getToolStrength());
    }

    private void performHide(boolean hidden, boolean areAllHidden, TeamH teamHidden) {
        if(hidden){
            if(areAllHidden){
                for(int i=0; i < teamHidden.getTeamPieces().size(); i++){
                    teamHidden.getTeamPieces().get(i).setHidden(true);}
            }
            else{
                int i = 0;
                teamHidden.getTeamPieces().get(i).setHidden(true);
            }
        }

        else{
            if(areAllHidden){
                for(int i=0; i < teamHidden.getTeamPieces().size(); i++){
                    teamHidden.getTeamPieces().get(i).setHidden(false);}
            }
            else{
                int i = 0;
                teamHidden.getTeamPieces().get(i).setHidden(false);
            }
        }
    }

    public void performToolAction(Tool tool){
        if(tool.getToolType().equals(Tool.ITEM.CLOAK) && tool.getToolStrength().equals(Tool.STRENGTH.SILVER)){
            performHide(true,false, this.game.getCurrentTeam());
        }
        else if(tool.getToolType().equals(Tool.ITEM.GLASSES) && tool.getToolStrength().equals(Tool.STRENGTH.GOLD)){
            performHide(false,true, this.game.getOpponentTeam());
        }

        else if(tool.getToolType().equals(Tool.ITEM.GLASSES) && tool.getToolStrength().equals(Tool.STRENGTH.SILVER)){
            performHide(false,false, this.game.getOpponentTeam());
        }
        else if(tool.getToolType().equals(Tool.ITEM.MYSTERYBOX)) {
            int rand = (int) (Math.random() * 4);
            ArrayList<Tool> Tools = new ArrayList<Tool>();
            Tools.add(new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
            Tools.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
            Tools.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER));
            Tools.add(new Tool(Tool.ITEM.POTION,Tool.STRENGTH.SILVER));
            Tool newTool = Tools.get(rand);
            this.game.getCurrentTeam().getToolBox().addTool(Tools.get(rand));
            System.out.println(newTool+ " added to team toolbox");
        }
        else if (tool.getToolType().equals(Tool.ITEM.POTION)&&(tool.getToolStrength().equals(Tool.STRENGTH.SILVER))){
            int fromrow;
            int fromcolumn;
            int toRow;
            int toColumn;
            System.out.println("Enter the row and column of the from space");
            fromrow = scnr.nextInt();
            fromcolumn = scnr.nextInt();
            System.out.println("Enter the row and column of the to space");
            toRow = scnr.nextInt();
            toColumn = scnr.nextInt();
            ActionMove move = new ActionMove(this.game,fromrow,fromcolumn,toRow,toColumn);
            if (move.fromSpaceValid()&&(this.game.getBoard().getSpaces()[toRow][toColumn]).isEmpty()){
                move.performAction();
            }
        }

    }
}
