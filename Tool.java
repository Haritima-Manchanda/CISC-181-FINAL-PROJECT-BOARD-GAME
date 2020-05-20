package cisc181.lab_4;

public class Tool {
    public enum ITEM{
    CLOAK, GLASSES,COIN,MYSTERYBOX,POTION
    }
    public enum STRENGTH{
        GOLD,SILVER,WOODEN
    }
    private ITEM toolType;
    private STRENGTH toolStrength;

    public Tool(ITEM toolType,STRENGTH toolStrength){
        this.toolType = toolType;
        this.toolStrength = toolStrength;
    }
    public Tool(){
        this(ITEM.CLOAK,STRENGTH.GOLD);
    }
    public ITEM getToolType(){
        return toolType;
    }
    public STRENGTH getToolStrength(){
        return toolStrength;
    }

    public String toString(){
        return toolStrength + " " + toolType;
    }

    //Purpose: To return a string for some combination of tool and strength
    //General Algorithm: Uses a nested switch case, switching tool and strength. If
    // a valid match is found, a string is assigned to the variable string. If not,
    //a default string is saved to that variable. Either way, what is stored in the
    //string variable is returned
    public String getDescription(){
        String string;
        switch(toolType){
            case CLOAK:
                switch(toolStrength){
                    case SILVER:
                        string ="Hide one of your own team's pieces";
                        break;
                    default:
                        string = ("Unidentified tool");
                        break;
                }
            break;
            case MYSTERYBOX:
                string = "Chooses a random new existing tool";
                break;
            case POTION:
                string = "Can move to any space if it's open regardless of piece's movement limitations";
                break;
            case GLASSES:
                switch(toolStrength){
                    case GOLD:
                        string = ("Unhide all of the other team's pieces");
                        break;
                    case SILVER:
                        string=("Unhide one of the other team's pieces");
                        break;
                    default:
                        string = ("Unidentified tool");
                        break;
                }
            break;
            case COIN:
                switch(toolStrength){
                    case GOLD:
                        string = ("Trade for any tool in the game");
                        break;
                    case SILVER:
                        string = ("Buy any tool from the game's toolbox");
                        break;
                    default:
                        string = ("Unidentified tool");
                        break;
                }
            break;
            default:
                string = ("Unidentified tool");
                break;}
        return string;
    }

    public static void main(String[]args){
        Tool me = new Tool(ITEM.CLOAK,STRENGTH.SILVER);
        System.out.println(me.getDescription());
    }

}

