import java.util.ArrayList;
import java.util.Random;

public class AgentJoueur {
    private char symbol ;

// get set const
    public AgentJoueur(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
// methods
    public int[] Play(char[][] mat){
        ArrayList<int[]> empty_spots = new ArrayList<>();
        for (int i =0 ; i< mat.length;i++) {
            for (int j =0 ; j<mat[0].length;j++) {
                if (mat[i][j] == '_') {
                    int[] cor = {i,j};
                    empty_spots.add(cor);
                }
            }
        }
        Random rand = new Random();
        int index = rand.nextInt(empty_spots.size());
        return empty_spots.get(index);
    }


}
