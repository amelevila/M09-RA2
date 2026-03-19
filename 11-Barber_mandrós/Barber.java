public class Barber implements Runnable {
    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = null;
            synchronized (barberia.condBarber) {
                client = barberia.seguentClient();
                while (client == null) {
                    System.out.println("Barber " + nom + " dormint");
                    try {
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    client = barberia.seguentClient();
                }
                System.out.println("Li toca al client " + client.getNom());
            }
            client.tallarseElCabell(nom);
        }
    }
}
