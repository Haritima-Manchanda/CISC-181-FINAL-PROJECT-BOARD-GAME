package cisc181.lab_4;

public class PurchaseTool {
    protected Game181H game;

    public PurchaseTool(Game181H game181H) {
        this.game = game181H;
    }

    public boolean validToolPurchase(Tool tool1, Tool tool2) {
        boolean isCoin = tool1.getToolType().equals(Tool.ITEM.COIN);
        boolean inCurrentTeam = false;
        boolean toolPurchasedOccurance = false;

        if (isCoin) {
            inCurrentTeam = this.game.getCurrentTeam().getToolBox().hasTool(tool1.getToolType(), tool1.getToolStrength());
        }
       if (isCoin && tool1.getToolStrength().equals(Tool.STRENGTH.GOLD)) {
            toolPurchasedOccurance = (this.game.getOpponentTeam().getToolBox().hasTool(tool2.getToolType(), tool2.getToolStrength()) ||
                    this.game.getGameToolBox().hasTool(tool2.getToolType(), tool2.getToolStrength()));
        }
       if (isCoin && tool1.getToolStrength().equals(Tool.STRENGTH.SILVER)) {
            toolPurchasedOccurance = this.game.getGameToolBox().hasTool(tool2.getToolType(), tool2.getToolStrength());
        }

        return isCoin && inCurrentTeam && toolPurchasedOccurance;
    }

    public void exchangeTool(Tool tool, ToolBox toolBoxRemovedFrom, ToolBox toolBoxAddedTo) {
        toolBoxAddedTo.addTool(tool);
        toolBoxRemovedFrom.removeTool(tool.getToolType(), tool.getToolStrength());
    }

    public void performToolPurchase(Tool coin, Tool toolPurchased) {
        if (coin.getToolStrength().equals(Tool.STRENGTH.GOLD)) {
            if(this.game.getOpponentTeam().getToolBox().hasTool(toolPurchased.getToolType(),toolPurchased.getToolStrength())){
                exchangeTool(coin, this.game.getCurrentTeam().getToolBox(), this.game.getCurrentTeam().getToolBox());
                exchangeTool(toolPurchased, this.game.getOpponentTeam().getToolBox(), this.game.getCurrentTeam().getToolBox());
            }
            else{
                exchangeTool(coin, this.game.getCurrentTeam().getToolBox(), this.game.getGameToolBox());
                exchangeTool(toolPurchased, this.game.getGameToolBox(), this.game.getCurrentTeam().getToolBox());
            }
        }

        else if(coin.getToolStrength().equals(Tool.STRENGTH.SILVER)){
            exchangeTool(coin, this.game.getCurrentTeam().getToolBox(), this.game.getGameToolBox());
            exchangeTool(toolPurchased, this.game.getGameToolBox(), this.game.getCurrentTeam().getToolBox());
        }

        this.game.changeTurn();
    }
}