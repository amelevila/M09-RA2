public class Assistent extends Thread {
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while(true) {
            if (Math.random() <= 0.3) esdeveniment.ferReserva(this);
            else esdeveniment.cancelaReserva(this);

            double t = Math.random()*1000;
            try {
                Thread.sleep((long) t);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
