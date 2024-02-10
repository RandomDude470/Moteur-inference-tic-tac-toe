import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


// Abbriviations:
//      BF : base de faits
//      BR : base de regles
public class AgentIntelligent {
    //basics
    char symbol ;
    ArrayList<String> BF;
    public AgentIntelligent(char symbol, char[][] matrix) {
        this.symbol = symbol;
        this.BF = this.GetBF(matrix,symbol);
    }

    //Methods

    private ArrayList<String> GetBF(char[][] matrix, char symb){
        ArrayList<String> result = new ArrayList<>();
        for (int i =0 ; i<3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == symb) {
                    result.add(i + "," + j);
                }
            }
        }
        return result;
    }
    private ArrayList<int[]> GetEmptySpots(char[][] matrix){
        ArrayList<int[]> empty_spots = new ArrayList<>();
        for (int i =0 ; i< matrix.length;i++) {
            for (int j =0 ; j<matrix[0].length;j++) {
                if (matrix[i][j] == '_') {
                    int[] cor = {i,j};
                    empty_spots.add(cor);
                }
            }
        }
        return empty_spots;
    }
    /**
     * Returns the first empty square that has one of its adjacent squares occupied by a similar symbol to the one the fact base is for.
     */
    private int[] AdjacentSquare(ArrayList<int[]> eptSpts , ArrayList<String> BF){

        for (int[] coor : eptSpts){
            if (BF.contains(Integer.toString(coor[0]+1) + "," + Integer.toString(coor[1]))) return coor;
            if (BF.contains(Integer.toString(coor[0]-1) + "," + Integer.toString(coor[1]))) return coor;
            if (BF.contains(Integer.toString(coor[0]) + "," + Integer.toString(coor[1]+1))) return coor;
            if (BF.contains(Integer.toString(coor[0]) + "," + Integer.toString(coor[1]-1))) return coor;
            if (BF.contains(Integer.toString(coor[0]+1) + "," + Integer.toString(coor[1]+1))) return coor;
            if (BF.contains(Integer.toString(coor[0]-1) + "," + Integer.toString(coor[1]-1))) return coor;
            if (BF.contains(Integer.toString(coor[0]-1) + "," + Integer.toString(coor[1]+1))) return coor;
            if (BF.contains(Integer.toString(coor[0]+1) + "," + Integer.toString(coor[1]-1))) return coor;


        }
        return new int[] {-1,-1};
    }
    private ArrayList<String> cpBF(ArrayList<String> bf){
        ArrayList<String> dest = new ArrayList<>();
        for (String str:bf) {
            dest.add(str);
        }
        return dest;
    }
    private ArrayList<RegleComplex> cpBR(ArrayList<RegleComplex> br){
        ArrayList<RegleComplex> dest = new ArrayList<>();
        for (RegleComplex rgl:br) {
            dest.add(rgl);
        }
        return dest;
    }
    public int[] Play(char[][] matrix,char symbolOp,  ArrayList<RegleComplex> BR) {
        BF =  this.GetBF(matrix,symbol);
        ArrayList<int[]> emptySpots = this.GetEmptySpots(matrix);

        for (int i =0 ; i<emptySpots.size() ; i++) {
            int[] coor = emptySpots.get(i);
            String fait = Integer.toString(coor[0])+","+Integer.toString(coor[1]);
            ArrayList<String> tempBF = cpBF(BF);
            ArrayList<RegleComplex> tempBR = cpBR(BR);
            tempBF.add(fait);
            boolean result = MoteurInference.chainageAvantComplex(tempBF, tempBR, "win");
            if (result) {
                return new int[]{Integer.parseInt(fait.split(",")[0]),Integer.parseInt(fait.split(",")[1])};
            }

        }
        ArrayList<String> BF_Op = this.GetBF(matrix,symbolOp);
        for (int i =0;i<emptySpots.size() ; i++ ) {
            int[] coor = emptySpots.get(i);
            String fait = Integer.toString(coor[0])+","+Integer.toString(coor[1]);
            ArrayList<String> tempBF1 = cpBF(BF_Op);
            ArrayList<RegleComplex> tempBR = cpBR(BR);
            tempBF1.add(fait);
            boolean result = MoteurInference.chainageAvantComplex(tempBF1, tempBR, "win");
            if (result) {
                return new int[]{Integer.parseInt(fait.split(",")[0]),Integer.parseInt(fait.split(",")[1])};
            }
        }
        int[] adjacentSquare = this.AdjacentSquare(emptySpots, BF);
        if (!Arrays.equals(adjacentSquare, new int[]{-1, -1})) {
            return adjacentSquare;
        }else {
            Random rd = new Random();
            int rdn = rd.nextInt(emptySpots.size());
            return emptySpots.get(rdn);
        }

    }







    //getters and setters
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setBF(ArrayList<String> BF) {
        this.BF = BF;
    }
    public char getSymbol() {
        return symbol;
    }
    public ArrayList<String> getBF() {
        return BF;
    }
}
