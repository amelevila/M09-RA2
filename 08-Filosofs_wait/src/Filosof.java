import java.util.concurrent.ThreadLocalRandom;

public class Filosof extends Thread {
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private final int num;

    public Filosof(int num, Forquilla esquerra, Forquilla dreta) {
        super("Fil " + num);
        this.num = num;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }
    
    public Forquilla getEsquerra() {
        return this.esquerra;
    }

    public Forquilla getDreta() {
        return this.dreta;
    }

    public void menjar() {
        try {
            agafarForquilles();

            System.out.printf("Filòsof: %s menja%n", this.getName());

            int t = ThreadLocalRandom.current().nextInt(1000, 2001);
        
            sleep(t);
            } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Filòsof: %s ha acabat de menjar%n", this.getName());
        deixarForquilles();
    }

    public void pensar() {
        System.out.printf("Filòsof: %s pensant%n", this.getName());
        int t = ThreadLocalRandom.current().nextInt(1000, 2001);
        try {
            sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            menjar();
            pensar();
        }
    }

    private void agafarForquillaEsquerra() {
        esquerra.setNumPropietari(num);
    }

    private void agafarForquillaDreta() {
        dreta.setNumPropietari(num);
    }

    private void agafarForquilles() throws InterruptedException {
        synchronized (esquerra) {
            while (dreta.getNumPropietari() != dreta.getLliure()) {
                esquerra.wait(); 
            }
            agafarForquillaEsquerra();

            synchronized (dreta) {
                agafarForquillaDreta();
            }
        }
    }

    private void deixarForquilles() {
        synchronized (esquerra) {
            esquerra.setNumPropietari(esquerra.getLliure());
            esquerra.notifyAll();
        }

        synchronized (dreta) {
            dreta.setNumPropietari(dreta.getLliure());
            dreta.notifyAll();
        }
    }
}
