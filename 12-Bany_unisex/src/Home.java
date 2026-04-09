public class Home extends Thread {

    private final String nom;
    private final BanyUnisex lavabo;

    public Home(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    private void utilitzaLavabo() throws InterruptedException {
        Thread.sleep(1000 + (long)(Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            System.out.println(nom + " vol entrar al bany");
            lavabo.entraHome();
            utilitzaLavabo();
            System.out.println(nom + " ha acabat d'usar el bany");
            lavabo.surtHome();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}