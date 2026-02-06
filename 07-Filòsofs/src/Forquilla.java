public class Forquilla {
    private final int num;
    volatile private boolean enUs;

    public Forquilla(int num) {
        this.num = num;
    }

    public boolean isEnUs() {
        return this.enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }

    public int getNum() {
        return this.num;
    }

}
