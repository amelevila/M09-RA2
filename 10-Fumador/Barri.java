public class Barri {
    private final Estanc estanc;
    private final Thread[] filsFumadors;
    private final Thread filEstanc;

    public Barri() {
        this.estanc = new Estanc();
        this.filsFumadors = new Thread[3];

        for (int i = 0; i < 3; i++) {
            this.filsFumadors[i] = new Thread(new Fumador(estanc, i));
        }
        this.filEstanc = new Thread(estanc);
    }

    public void iniciar() {
        for (Thread t : filsFumadors) t.start();
        filEstanc.start();
        
        for (Thread t : filsFumadors) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        estanc.tancarEstanc();
    }

    public static void main(String[] args) {
        new Barri().iniciar();
    }
}