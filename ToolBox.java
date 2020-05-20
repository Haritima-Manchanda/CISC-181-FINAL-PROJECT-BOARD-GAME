package cisc181.lab_4;
import java.util.ArrayList;

public class ToolBox {
    //private static int MAX_NUM_TOOLS = 12;
    ArrayList<Tool> toolset=new ArrayList<Tool>();

    public ToolBox(boolean gameToolbox) {
        if(gameToolbox){
           setUpToolBox();
        }

    }
    public ToolBox(){

    }

   public ArrayList<Tool> getToolSet() {
        return toolset;
    }

    private void setUpToolBox(){
        toolset.add(new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
        toolset.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
        toolset.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER));
        toolset.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD));
        toolset.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD));
        toolset.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        toolset.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        toolset.add(new Tool(Tool.ITEM.MYSTERYBOX,Tool.STRENGTH.WOODEN));
        toolset.add(new Tool(Tool.ITEM.POTION,Tool.STRENGTH.SILVER));
    }

    /*
    Purpose: to check if a specific tool is in an arraylist
    Algorithm: for loops across an arraylist and looks for the tool's specified features
    and returns true if that tool is found
     */
    public boolean hasTool(Tool.ITEM item,Tool.STRENGTH strength){
        for(int i =0;i<toolset.size();i++){
            if((toolset.get(i).getToolStrength()==strength)
                    &&(toolset.get(i).getToolType()==item)) {
                return true;
            }
        }
        return false;
    }

    /*
    Purpose: to remove a specific tool from an arraylist and return that tool
    Algorithm: For loops across arraylist and returns the removed tool if found, null is not
     */
    public Tool removeTool(Tool.ITEM item,Tool.STRENGTH strength){
        for(int i =0;i<toolset.size();i++){
            if(toolset.get(i).getToolType()==item&&toolset.get(i).getToolStrength()==strength)
                return toolset.remove(i);
        }
        return null;
        }

    public Tool getTool(int index) {
        if (index < 12) {
            return toolset.get(index);
        } else {
            return null;
        }
    }

    public String toString(){
        StringBuilder toolString = new StringBuilder();
        for(int i = 0; i < toolset.size(); i++){
            if(toolset.get(i)!=null){
            toolString.append(toolset.get(i).toString()+" : "+toolset.get(i).getDescription());
            toolString.append("\n");
        }}

        return toolString.toString();
    }

    public void addTool(Tool tool){
        toolset.add(tool);
    }
    public static void main(String[]args){

    }
}
