import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {

    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;

    private int estatActual;
    private int ocupants;
    private final int CAPACITAT_MAX = 3;
    private final Semaphore capacitat;
    private final ReentrantLock lockEstat;

    public BanyUnisex() {
        estatActual = BANY_BUIT;
        ocupants = 0;
        capacitat = new Semaphore(CAPACITAT_MAX, true);
        lockEstat = new ReentrantLock(true);
    }

    public void entraHome() {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) {
                        ocupants++;
                        estatActual = BANY_AMB_HOMES;
                        System.out.println("Home entra al bany. Ocupants: " + ocupants);
                        return;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
        }
    }

    public void entraDona() {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) {
                        ocupants++;
                        estatActual = BANY_AMB_DONES;
                        System.out.println("Dona entra en el bany. Ocupants: " + ocupants);
                        return;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
        }
    }

    public void surtHome() {
        lockEstat.lock();
        try {
            ocupants--;
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
            }
            System.out.println("Home surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                System.out.println("El bany està buit");
            }
            capacitat.release();
        } finally {
            lockEstat.unlock();
        }
    }

    public void surtDona() {
        lockEstat.lock();
        try {
            ocupants--;
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
            }
            System.out.println("Dona surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                System.out.println("El bany està buit");
            }
            capacitat.release();
        } finally {
            lockEstat.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BanyUnisex bany = new BanyUnisex();
 
        for (int i = 0; i < 5; i++) {
            new Home("Home-" + i, bany).start();
        }
        for (int i = 0; i < 5; i++) {
            new Dona("Dona-" + i, bany).start();
        }
    }
}