import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private final int maxAnys = 10;
    private Random random = new Random();

    public Soci() {
        this.compte = Compte.getInstancia();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        int mesosTotals = maxAnys * 12;

        for (int mes = 1; mes <= mesosTotals; mes++) {
            if (mes % 2 == 0) {
                compte.ingressar(aportacio);
            } else {
                compte.retirar(aportacio);
            }

            try {
                Thread.sleep(random.nextInt(esperaMax));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
