public class Fil extends Thread {
    private final String nom;
    private final boolean estricte;

    public Fil(String nom, boolean estricte) {
        this.nom = nom;
        this.estricte = estricte;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            if (estricte) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            else {
                @SuppressWarnings("unused")
                int comptador = 0;
                for (int x = 0; x < 1000; x++) {
                    comptador++;
                }
            }
            System.out.printf("%s %d\n", nom, i);
        }

        System.out.println("Acaba el fil " + nom);
    }
}