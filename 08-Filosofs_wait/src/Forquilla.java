public class Forquilla {
    private final int num;
    private int numPropietari;
    private final int LLIURE = -1;

    public Forquilla(int num) {
        this.num = num;
        this.numPropietari = LLIURE;
    }

    public int getNum() {
        return this.num;
    }

    public int getLliure() {
        return this.LLIURE;
    }

    public int getNumPropietari() {
        return numPropietari;
    }

    public void setNumPropietari(int numPropietari) {
        this.numPropietari = numPropietari;
    }
}
