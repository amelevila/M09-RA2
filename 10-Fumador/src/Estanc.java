import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc implements Runnable {
    private List<Tabac> llistaTabac = new ArrayList<>();
    private List<Llumi> llistaLlumi = new ArrayList<>();
    private List<Paper> llistaPaper = new ArrayList<>();
    private boolean obert = true;
    private final Random random = new Random();

    public synchronized void addTabac(Tabac t) {
        llistaTabac.add(t);
        System.out.println("Afegint tabac");
        notifyAll();
    }

    public synchronized void addLlumi(Llumi l) {
        llistaLlumi.add(l);
        System.out.println("Afegint Llumi");
        notifyAll();
    }

    public synchronized void addPaper(Paper p) {
        llistaPaper.add(p);
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public void nouSubministrament() {
        int r = random.nextInt(3);
        if (r == 0) addTabac(new Tabac());
        else if (r == 1) addPaper(new Paper());
        else addLlumi(new Llumi());
    }

    public synchronized Tabac venTabac() throws InterruptedException {
        while (llistaTabac.isEmpty() && obert) wait();
        return llistaTabac.isEmpty() ? null : llistaTabac.remove(0);
    }

    public synchronized Paper venPaper() throws InterruptedException {
        while (llistaPaper.isEmpty() && obert) wait();
        return llistaPaper.isEmpty() ? null : llistaPaper.remove(0);
    }

    public synchronized Llumi venLlumi() throws InterruptedException {
        while (llistaLlumi.isEmpty() && obert) wait();
        return llistaLlumi.isEmpty() ? null : llistaLlumi.remove(0);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
        System.out.println("Estanc tancat");
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");
        while (obert) {
            try {
                nouSubministrament();
                
                Thread.sleep(500 + random.nextInt(1001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}