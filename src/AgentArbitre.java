import java.util.ArrayList;

public class AgentArbitre {
    public static void ShowResult(char[][] m){
        if (won(m,'X')) System.out.println("X wins");
        else if (won(m,'O')) System.out.println("O wins");
        else if (is_game_over(m)) System.out.println("Draw");
    }
    public static char[][] init_matrix(){
        char[][] Matrix = new char[3][3];
        for (int i = 0 ; i<Matrix.length;i++) {
            for (int j =0 ; j<Matrix[0].length ; j++) {
                Matrix[i][j] = '_';
            }
        }
        return Matrix;
    }
    public static void affich (char[][] mat){
        for (char[] chars : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(chars[j] + "    ");
            }
            System.out.println('\n');
        }
    }
    public  static  boolean is_game_over(char[][] mat){
        for (char[] chars : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                if (chars[j] == '_') return false;
            }
        }
        return true;
    }
    public static boolean won(char[][] mat, char symb){
        if (mat[0][0]+mat[1][1]+mat[2][2] == 3*symb) return true;
        if (mat[2][0]+mat[1][1]+mat[0][2] == 3*symb) return true;
        for (char[] c : mat) {
            if (c[0]+c[1]+c[2] == 3*symb) {
                return true;
            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[0][i]+mat[1][i]+mat[2][i] == 3*symb) {
                return true;
            }
        }
        return false;
    }
    public static ArbiterDecision Partie(char[][] mat, char symb, AgentIntelligent p1, AgentIntelligent p2, ArrayList<RegleComplex> BR)  {
        if (!is_game_over(mat) && !won(mat, 'X') && !won(mat, 'O')) {

            if (p1.getSymbol() == symb) {
                return new ArbiterDecision(symb, p1.Play(mat,(p1.getSymbol()=='X')? 'O' : 'X',BR));
            } else if (p2.getSymbol() == symb) {
                return new ArbiterDecision(symb, p2.Play(mat,(p2.getSymbol()=='X')? 'O' : 'X',BR));
            }else {
                int[] coor = {0,0};
                return new ArbiterDecision('_',coor);
            }

        } else {

            int[] coor = {0,0};
            ShowResult(mat);
            return new ArbiterDecision('_',coor);
        }

    }
    public static ArbiterDecision Partie(char[][] mat, char symb, AgentIntelligent p1, AgentJoueur p2, ArrayList<RegleComplex> BR)  {
        if (!is_game_over(mat) && !won(mat, 'X') && !won(mat, 'O')) {

            if (p1.getSymbol() == symb) {
                return new ArbiterDecision(symb, p1.Play(mat,(p1.getSymbol()=='X')? 'O' : 'X',BR));
            } else if (p2.getSymbol() == symb) {
                return new ArbiterDecision(symb, p2.Play(mat));
            }else {
                int[] coor = {0,0};
                return new ArbiterDecision('_',coor);
            }

        } else {

            int[] coor = {0,0};
            ShowResult(mat);
            return new ArbiterDecision('_',coor);
        }

    }
}