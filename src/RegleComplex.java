import java.util.ArrayList;

public class RegleComplex {
    private String Conclusion;
    private String[] Premises;

    public RegleComplex( String premises,String conclusion) {
        Conclusion = conclusion;
        Premises = premises.split("&");
    }

    public  boolean  isApplicableIn( ArrayList<String> BF){
        for (String S : this.Premises){
            if (!BF.contains(S)) {
                return false;
            }
        }
        return true;
    }
    public String getConclusion() {
        return Conclusion;
    }

    public String[] getPremises() {
        return Premises;
    }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }

    public void setPremises(String[] premises) {
        Premises = premises;
    }
}
