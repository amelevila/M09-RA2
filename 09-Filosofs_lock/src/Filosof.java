import java.util.concurrent.ThreadLocalRandom;

public class Filosof extends Thread {
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private long iniciGana;
    private long fiGana;
    private int gana;

    public Filosof(int num, Forquilla esquerra, Forquilla dreta) {
        super("Fil" + num);
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
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

            fiGana = System.currentTimeMillis();
            gana = calcularGana();

            System.out.printf("%s té forquilles esq(%d) dreta(%d)%n",
                    this.getName(), esquerra.getNum(), dreta.getNum());

            System.out.printf("%s menja amb gana %d%n",
                    this.getName(), gana);

            int t = ThreadLocalRandom.current().nextInt(1000, 2001);
            sleep(t);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resetGana();
        deixarForquilles();
    }

    public void pensar() {
        System.out.printf("%s pensant%n", getName());

        iniciGana = System.currentTimeMillis();

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
        esquerra.agafar();
    }

    private void agafarForquillaDreta() {
        dreta.agafar();
    }

    private void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
    }

    private int calcularGana() {
        return (int) (fiGana - iniciGana)/1000;
    }

    private void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    public long getGana() {
        return this.gana;
    }
}