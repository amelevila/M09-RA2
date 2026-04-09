public class Dona extends Thread {

    private final String nom;
    private final BanyUnisex lavabo;

    public Dona(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    private void utilitzaLavabo() throws InterruptedException {
        Thread.sleep(2000 + (long)(Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            System.out.println(nom + " vol entrar al bany");
            lavabo.entraDona();
            utilitzaLavabo();
            System.out.println(nom + " ha acabat d'usar el bany");
            lavabo.surtDona();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}