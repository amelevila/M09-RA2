public class DormAleatori extends Thread {
    private final long instant_creat;
    
    public DormAleatori(String nom) {
        super(nom);
        this.instant_creat = System.currentTimeMillis();
    }

    public long getCreat() {
        return instant_creat;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i<10; i++) {
                int interval_aleatori = (int) (Math.random()*1000);
                int total_temps = (int) (System.currentTimeMillis()-instant_creat);
                System.out.printf("%-4s(%d) a dormir %4dms total %5dms%n", 
                getName(), i, interval_aleatori, total_temps);
                sleep(interval_aleatori);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + getName() + "interromput.");
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();
        System.out.println("-- Fi de main -----------");
    }
}
