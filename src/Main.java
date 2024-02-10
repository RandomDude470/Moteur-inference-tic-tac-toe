import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] Matrix = AgentArbitre.init_matrix();
        AgentIntelligent p1 = new AgentIntelligent('X',Matrix);
        AgentIntelligent p2 = new AgentIntelligent('O',Matrix);



        RegleComplex[] rules = {
                new RegleComplex("0,0&0,1&0,2","win"),
                new RegleComplex("1,0&1,1&1,2","win"),
                new RegleComplex("2,0&2,1&2,2","win"),
                new RegleComplex("0,0&1,0&2,0","win"),
                new RegleComplex("0,1&1,1&2,1","win"),
                new RegleComplex("0,2&1,2&2,2","win"),
                new RegleComplex("0,0&1,1&2,2","win"),
                new RegleComplex("0,2&1,1&2,0","win")
        };
        ArrayList<RegleComplex> BR = new ArrayList<>(Arrays.asList(rules));






        // game loop
        int turn = 1;
        boolean flag = true;
        while(flag){
            ArbiterDecision decision = AgentArbitre.Partie(Matrix,(turn == 1)? 'X' : 'O',p1,p2,BR);
            if (decision.getSymbol() == '_') {
                flag =false;
            }else{
                Matrix[decision.getCoordinates()[0]][decision.getCoordinates()[1]] = decision.getSymbol();
                AgentArbitre.affich(Matrix);
                System.out.println();
                turn = (turn == 1)? 0:1;
            }

        }




    }

}