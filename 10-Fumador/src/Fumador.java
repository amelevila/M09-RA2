import java.util.Random;

public class Fumador implements Runnable {
    private final int id;
    private final Estanc estanc;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int numFumades = 0;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    public void compraTabac() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Tabac");
        this.tabac = estanc.venTabac();
    }

    public void compraPaper() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Paper");
        this.paper = estanc.venPaper();
    }

    public void compraLlumi() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Llumi");
        this.llumi = estanc.venLlumi();
    }

    public void fuma() throws InterruptedException {
        if (tabac != null && paper != null && llumi != null) {
            System.out.println("Fumador " + id + " fumant");
            tabac = null; paper = null; llumi = null;
            
            Thread.sleep(500 + new Random().nextInt(501));
            numFumades++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
        }
    }

    @Override
    public void run() {
        try {
            while (numFumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();
                fuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}