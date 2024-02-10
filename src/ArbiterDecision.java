public class ArbiterDecision {
    private char symbol;


    public ArbiterDecision(char symbol, int[] coordinates) {
        this.symbol = symbol;
        this.coordinates = coordinates;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public char getSymbol() {
        return symbol;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    private int[] coordinates;

}
