package cisc181.lab_4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class TeamH {

    private String teamName;
    private String teamColor;
    private ArrayList<Piece>teamPieces;
    private ToolBox toolBox;
    private int numRecruited;

    public TeamH(String teamName, String teamColor, ArrayList<Piece> teamPieces){
        this.teamName = teamName;
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
        this.numRecruited =0;
       // this.teamPieces =new ArrayList<>();
        toolBox = new ToolBox(false);
    }
    public TeamH(String teamName,String teamColor){
        this.teamName = teamName;
        this.teamColor = teamColor;
        teamPieces =makeTeam();
    }
    public int getNumRecruited(){
        return this.numRecruited;
    }

    public void setNumRecruited(int num){
        numRecruited+=num;
    }
    public TeamH(){
        this("Blah","Blah",null);
    }
    public String getTeamName(){
        return teamName;
    }
    public String getTeamColor(){
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    private void displayAvailPieces(ArrayList<Piece>pieces){
        System.out.println("You can choose 3 pieces from the following list");
        for(Piece piece:pieces){
            System.out.println(piece);
        }
        System.out.println("A. Horse: Can move 1-3 steps in any direction. Only recruits other horses\n" +
                "Enter H to choose");
        System.out.println("B. Frog: Can hop up left, right, up, down two spaces  \n" +
                "Can eat any piece and revive 1 new SharkBait piece\n Enter F to choose");
        System.out.println("C. SharkBait: Can move two spaces diagonally and recruit pieces" +
                "\nEnter S to choose");
        System.out.println("D. Penguin: Can move up and down and left and right. Attacks pieces in the same way\n" +
                "Enter P to choose");
        System.out.println("E. Hen: Can fly to any space when it has laid low enough eggs\n" +
                "or move one space up,down,left, right when it has laid too many eggs\n" +
                "Attacks the same way. Enter B to choose");

    }
    private void createMasterPiece(ArrayList<Piece> pieces){
        int randomIndex = ((int)(Math.random()*3));
        pieces.get(randomIndex).setSymbol("M"+pieces.get(randomIndex).getSymbol());
        pieces.get(randomIndex).setMasterPiece(true);
        System.out.println("MASTERPIECE CREATED. Your masterpiece is "+pieces.get(randomIndex));
        }


    public ArrayList<Piece> makeTeam (){
        ArrayList<Piece>Pieces = new ArrayList<Piece>();
        ArrayList<Piece>piecesToBeAdded = new ArrayList<Piece>();
        Piece horse = new PieceHorse("Hors",teamColor);
        Piece frog = new PieceFrog("Frog",teamColor,0,0);
        Piece nemo = new PieceSharkBait("Nemo",teamColor);
        Piece penguin = new PiecePenguin("Peng",teamColor,0,0);
        Piece hen = new PieceBlueHen("Hen",teamColor,0,0);
        Pieces.add(horse);
        Pieces.add(frog);
        Pieces.add(nemo);
        Pieces.add(penguin);
        Pieces.add(hen);
        displayAvailPieces(Pieces);
        Scanner scnr = new Scanner(System.in);
        String piece = "";
        int count =2;
        while(teamPieces.size()<3){
            piece = scnr.next();
            if(piece.charAt(0)=='H'&&Pieces.contains(horse)){
                Pieces.remove(horse);
                teamPieces.add(horse);
                System.out.println("Wonderful,added horse to team. "+count+ " more to choose");
                count--;
            }
            else if(piece.charAt(0)=='F'&&Pieces.contains(frog)){
                Pieces.remove(frog);
                teamPieces.add(frog);
                System.out.println("Wonderful,added frog to team. "+count+ " more to choose");
                count--;

            }
            else if(piece.charAt(0)=='S'&&Pieces.contains(nemo)){
                Pieces.remove(nemo);
                teamPieces.add(nemo);
                System.out.println("Wonderful,added shark to team. "+count+ " more to choose");
                count--;
            }
            else if(piece.charAt(0)=='P'&&Pieces.contains(penguin)){
                Pieces.remove(penguin);
                teamPieces.add(penguin);
                System.out.println("Wonderful,added penguin to team. "+count+ " more to choose");
                count--;
            }
            else if(piece.charAt(0)=='B'&&Pieces.contains(hen)){
                Pieces.remove(hen);
                teamPieces.add(hen);
                System.out.println("Wonderful,added hen to team. "+count+ " more to choose");
                count--;
            }
            else{
                System.out.println("Invalid choice, try again");
            }
        }
        createMasterPiece(teamPieces);
        System.out.println("These are team"+ teamName + "'s pieces: "+teamPieces);
        return piecesToBeAdded;
        }


    public ToolBox getToolBox() {
        return toolBox;
    }

    public void removePieceFromTeam(Piece piece){
        teamPieces.remove(piece);
    }
    public void addPieceToTeam(Piece piece){
        piece.setColor(getTeamColor());
        teamPieces.add(piece);


    }
    public void setTeamPieces(ArrayList<Piece> me){
        this.teamPieces=me;
    }

    public String toString() {
            StringBuilder toolString = new StringBuilder();
            for (int i = 0; i < teamPieces.size(); i++) {
                if (teamPieces.get(i) != null) {
                    toolString.append(teamPieces.get(i).toString());
                    toolString.append("\n");
                }
            }
            return "Team " + teamName + " : " + teamColor + "\nPieces : " + toolString.toString() + "Tools : " +
                    getToolBox().toString();

    }
    public static void main(String[]args){
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);

        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(penguinB);

        TeamH teamA = new TeamH("CISC", "Red",piecesTeamA);
        TeamH teamB = new TeamH("181",  "Green",piecesTeamB);
        System.out.println(teamA.getTeamPieces().size());

    }
}
