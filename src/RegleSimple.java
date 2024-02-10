public class RegleSimple {
    private String Premise;
    private String Conclusion;
    public RegleSimple(){

    }
    public RegleSimple(String P , String C){
        this.Conclusion = C;
        this.Premise = P;

    }

    public String getConclusion() {
        return Conclusion;
    }

    public String getPremise() {
        return Premise;
    }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }

    public void setPremise(String premise) {
        Premise = premise;
    }
}
