public class Forquilla {
    private final int num;
    private int numPropietari;
    private final int LLIURE = -1;

    public Forquilla(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public int getNumPropietari() {
        return numPropietari;
    }

    public void setNumPropietari(int numPropietari) {
        this.numPropietari = numPropietari;
    }
}
