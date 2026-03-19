import java.util.LinkedList;
import java.util.Queue;

public class Barberia implements Runnable {
    private Queue<Client> salaEspera;
    private int maxCadires;
    public Object condBarber;
    private static Barberia instancia;

    public Barberia(int numCadires) {
        this.maxCadires = numCadires;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
    }

    public Client seguentClient() {
        if (salaEspera.isEmpty()) {
            System.out.println("Ningú en espera");
            return null;
        }
        return salaEspera.poll();
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println(client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    @Override
    public void run() {
        int id = 1;
        for (int i = 0; i < 10; i++) {
            Client c = new Client(id++);
            entrarClient(c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        for (int i = 0; i < 10; i++) {
            Client c = new Client(id++);
            entrarClient(c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Pepe", barberia);

        Thread tBarber = new Thread(barber);
        Thread tBarberia = new Thread(barberia);

        tBarber.setDaemon(true);
        tBarber.start();
        tBarberia.start();

        try {
            tBarberia.join();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
