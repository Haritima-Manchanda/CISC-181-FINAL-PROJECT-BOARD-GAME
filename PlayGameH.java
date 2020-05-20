package cisc181.lab_4;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayGameH {

    protected Game181H game;

    public PlayGameH(Game181H game181H){
        this.game = game181H ;
    }

    Scanner scnr = new Scanner(System.in);

    private char getValidActionType(){
        String keyword = "";
        boolean run = true;

        while(run){
            System.out.print("\nACTION TYPES AVAILABLE\n");

            System.out.print("\nA. Move : " + "1. player moves piece from from space selected to the to space selected\n" +
                    "2. from space must contain a piece belonging to team making the move\n" +
                    "3. to space must be empty\n" +
                    "\n4. CHARACTER TO BE ENTERED : M\n");

            System.out.print("\nB. Recruit : " + "1. player selects piece from from space selected to recruit the piece in the to space selected\n" +
                    "2. from space must contain a piece belonging to team whose turn it is -this piece must have the ability to ‘recruit’ \n" +
                    "3. to space must contain a piece belonging to the other team\n" +
                    "\n 4. CHARACTER TO BE ENTERED : R\n");

            System.out.print("\nC. Attack : " + "1. player selects piece from from space selected to attack the piece in the to space selected\n" +
                    "2. from space must contain a piece belonging to team whose turn it is -this piece must have the ability to ‘attack’\n" +
                    "3. to space must contain a piece belonging to the other team\n" +
                    "4. CHARACTER TO BE ENTERED : A\n");

            System.out.print("\nD. Use Tool : " + "1. player selects a Tool from their own Team ToolBox\n"+
                    "2. if using a COIN to purchase a Tool,then player also selects the Tool they want to purchase\n" +
                    "3. CHARACTER TO BE ENTERED: T\n");
            System.out.print("\nE. Duplicate: " + "1. player selects piece from from space selected to duplicate the piece in the to space selected\n" +
                    "2. from space must contain a piece belonging to team whose turn it is -this piece must have the ability to ‘duplicate’\n" +
                    "3. to space must contain a piece belonging to the other team\n" +
                    "4. CHARACTER TO BE ENTERED : A\n");
            System.out.print("\nF. Revive: " + "1. player selects piece from from space selected to revive the piece in the to space selected\n" +
                    "2. from space must contain a piece belonging to team whose turn it is -this piece must have the ability to ‘revive’\n" +
                    "3. to space must be empty\n" +
                    "4. CHARACTER TO BE ENTERED : V\n");



            System.out.println("Enter your choice: Move : 'M' , Recruit : 'R' , Attack : 'A' , Use Tool : 'T' , Duplicate : 'D' , Revive : 'V'");
            keyword = scnr.next();
            if(keyword.charAt(0) == 'M' || keyword.charAt(0) == 'R' || keyword.charAt(0) == 'A' || keyword.charAt(0) == 'T'||keyword.charAt(0)=='D'||keyword.charAt(0)=='V'){
                run = false;
            }
        }
        return keyword.charAt(0);
    }

    private Tool getValidTool(){
        boolean run = true;
        String toolChosen = "";
        Tool tool= null;
        while(run) {
            System.out.println("Tools Available :");
            System.out.println("SCLOAK : " + "GGLASSES : " + "SGLASSES : " + "GCOIN : " + "SCOIN : " + "MYSTERY : "+"POTION : ");
            System.out.println("PICK A TOOL:");
            toolChosen = scnr.next();

            switch (toolChosen){
                case "MYSTERY":
                    tool = new Tool(Tool.ITEM.MYSTERYBOX,Tool.STRENGTH.WOODEN);
                    run = false;
                    break;
                case "POTION":
                    tool = new Tool(Tool.ITEM.POTION,Tool.STRENGTH.SILVER);
                    run = false;
                    break;
                case "SCLOAK":
                    tool = new Tool(Tool.ITEM.CLOAK,Tool.STRENGTH.SILVER);
                    run =false;
                    break;
                case "GGLASSES":
                    tool = new Tool(Tool.ITEM.GLASSES,Tool.STRENGTH.GOLD);
                    run = false;
                    break;
                case "SGLASSES":
                    tool = new Tool(Tool.ITEM.GLASSES,Tool.STRENGTH.SILVER);
                    run = false;
                    break;
                case "GCOIN":
                    tool = new Tool(Tool.ITEM.COIN,Tool.STRENGTH.GOLD);
                    run = false;
                    break;
                case "SCOIN":
                    tool = new Tool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER);
                    run = false;
                    break;
                default:
                    run = true;
            }

        }
        return tool;
    }

    private void nextPlayersAction() {
        boolean run = true;
        while (run) {
            char choice = getValidActionType();
            if (choice == 'T') {
                System.out.println(this.game.getCurrentTeam().getToolBox().toString() + "\n Pick an available tool");
                Tool tool = getValidTool();//returns a tool
                if (tool.getToolType().equals(Tool.ITEM.COIN)) {
                    if (tool.getToolStrength().equals(Tool.STRENGTH.GOLD)) {
                        System.out.println(this.game.getCurrentTeam().getToolBox().toString() +
                                "\n" + this.game.getGameToolBox().toString());

                    } else if (tool.getToolStrength().equals(Tool.STRENGTH.SILVER)) {
                        System.out.println(this.game.getCurrentTeam().getToolBox().toString());
                    }
                    Tool secondTool = getValidTool();
                    PurchaseTool purchase = new PurchaseTool(this.game);
                    if (purchase.validToolPurchase(tool, secondTool)) {
                        purchase.performToolPurchase(tool, secondTool);
                        System.out.println(tool+ " "+secondTool+" Purchase approved");
                        run = false;

                    } else {
                        System.out.println(tool+ " "+secondTool);
                        System.out.println(secondTool+" Not valid purchase");
                        run = true;
                    }
                }
                else{//if tool is not a coin
                    UseTool useTool = new UseTool(this.game);
                    //this.game.getCurrentTeam().getToolBox().addTool(tool);
                    if(useTool.validUseToolAction(tool)){
                        System.out.println("Tool use approved");
                        useTool.performToolAction(tool);
                        run = false;
                    }
                    else{
                        System.out.println("Item not found in current team toolbox try again");
                        run=true;
                    }
                }
            } else if (choice == 'A' || choice == 'M' || choice == 'R'||choice =='D'||choice =='V') {
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
                switch (choice) {
                    case 'D':
                        ActionDuplicate duplicate = new ActionDuplicate(this.game,fromrow,fromcolumn,toRow,toColumn);
                        if(duplicate.validAction()){
                            duplicate.performAction();
                            run = false;
                        }
                        else{
                            run = true;
                        }
                        break;
                    case 'A':
                        ActionAttack attack = new ActionAttack(this.game, fromrow, fromcolumn, toRow, toColumn);
                        if (attack.validAction()) {
                            attack.performAction();
                            run =false;
                        } else {
                            run=true;
                        }
                        break;
                    case 'M':
                        ActionMove move = new ActionMove(this.game, fromrow, fromcolumn, toRow, toColumn);
                        if (move.validAction()) {
                            move.performAction();
                            run = false;
                        } else {
                            run=true;
                        }
                        break;
                    case 'R':
                        ActionRecruit recruit = new ActionRecruit(this.game, fromrow, fromcolumn, toRow, toColumn);
                        if (recruit.validAction()&&this.game.getCurrentTeam().getNumRecruited()<2) {
                            recruit.performAction();
                            run=false;
                        } else {
                            run=true;
                        }
                        break;
                    case 'V':
                        ActionRevive revive = new ActionRevive(this.game,fromrow, fromcolumn, toRow, toColumn);
                        if(revive.validAction()){
                        revive.performAction();
                        run = false;
                        } else {
                            run = true;
                        }
                        break;
                    default:
                        run=true;
                }
            }
        }
    }

    public void playOurGame(){

        boolean run=false;
        while(run==false) {
            System.out.println(this.game.toString());
            nextPlayersAction();
            run=game.isGameEnded();
            //System.out.println("Game has ended = "+game.isGameEnded());
        }
        System.out.println("The game has ended");
        if(game.isAWinner()||game.masterCaptured()){
            System.out.println("The winner is " + game.getWinner());
        }
    }

    public static void main(String[] args){
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        ArrayList<Piece>piecesTeamB = new ArrayList<>();
        System.out.println("Team A, please select your players");
        TeamH teamA = new TeamH("A", "Blue",piecesTeamA);
        teamA.makeTeam();
        System.out.println("Team B, please select your players");
        TeamH teamB = new TeamH("B","Green",piecesTeamB);
        teamB.makeTeam();
        Game181H ourGame = new Game181H(4, 4,teamA, teamB);
        teamA.getToolBox().addTool(new Tool(Tool.ITEM.MYSTERYBOX,Tool.STRENGTH.WOODEN));
        teamA.getToolBox().addTool(new Tool(Tool.ITEM.COIN,Tool.STRENGTH.GOLD));
        teamB.getToolBox().addTool(new Tool(Tool.ITEM.COIN,Tool.STRENGTH.GOLD));
        System.out.println("To win, wipe the board or capture the master piece. Note if you land on [3][3] you can revive any piece with any piece");
        PlayGameH play = new PlayGameH(ourGame);
        play.playOurGame();
    }
}

