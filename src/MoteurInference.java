import java.util.ArrayList;

public class MoteurInference {
    public MoteurInference(){

    }
    private static ArrayList<RegleComplex> applicableRulesComplex(ArrayList<String> BF, ArrayList<RegleComplex> BR){
        ArrayList<RegleComplex> applicableR = new ArrayList<>();
        for (RegleComplex R : BR) {
            if (R.isApplicableIn(BF)) {
                applicableR.add(R);
            }
        }
        return applicableR;
    }
    private static   ArrayList<RegleSimple> applicableRulesSimple(ArrayList<String> BF, ArrayList<RegleSimple> BR){
        ArrayList<RegleSimple> applicableR = new ArrayList<>();
        for (RegleSimple R : BR) {
            if (BF.contains(R.getPremise())) {
                applicableR.add(R);
            }
        }
        return applicableR;
    }


    public static boolean chainageAvantComplex(ArrayList<String> BF, ArrayList<RegleComplex> BR,String PropAVerif){
        ArrayList<RegleComplex> applicableR;
        applicableR = applicableRulesComplex(BF, BR);
        while (!BR.isEmpty() && !BF.contains(PropAVerif) && !applicableR.isEmpty() ){
            System.out.println(BF);
           for (RegleComplex r : applicableR) {
                BF.add(r.getConclusion());
                BR.remove(r);
           }
           applicableR = applicableRulesComplex(BF, BR);

        }
        return BF.contains(PropAVerif);
    }
    public static ArrayList<String> chainageAvantComplex(ArrayList<String> BF, ArrayList<RegleComplex> BR){
        ArrayList<RegleComplex> applicableR;
        applicableR = applicableRulesComplex(BF, BR);
        while (!BR.isEmpty()  && !applicableR.isEmpty() ){
            for (RegleComplex r : applicableR) {
                BF.add(r.getConclusion());
                BR.remove(r);
            }
            applicableR = applicableRulesComplex(BF, BR);

        }
        return BF;
    }

    public static boolean chainageAvant(ArrayList<String> BF, ArrayList<RegleSimple> BR,String PropAVerif){
        ArrayList<RegleSimple> applicableR;
        applicableR = applicableRulesSimple(BF, BR);
        while (!BR.isEmpty() && !BF.contains(PropAVerif) && !applicableR.isEmpty() ){
            for (RegleSimple r : applicableR) {
                BF.add(r.getConclusion());
                BR.remove(r);

            }
            applicableR = applicableRulesSimple(BF, BR);
        }
        return BF.contains(PropAVerif);
    }
}
