import java.util.concurrent.ThreadLocalRandom;

public class Filosof extends Thread {
    private int gana;
    private final Forquilla esquerra;
    private final Forquilla dreta;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom);
        this.gana = 0;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }
    
    public Forquilla getEsquerra() {
        return this.esquerra;
    }

    public Forquilla getDreta() {
        return this.dreta;
    }

    public int getGana() {
        return this.gana;
    }

    public void menjar() {
        int t = ThreadLocalRandom.current().nextInt(500, 1001);
        if (!esquerra.isEnUs()) {
            agafaForquilla(esquerra, "esquerra");
            if (!dreta.isEnUs()) {
                agafaForquilla(dreta, "dreta");
                gana=0;
                System.out.printf("Filòsof: %s menja", this.getName());
                t = ThreadLocalRandom.current().nextInt(1000, 2001);
                try {
                    sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                esquerra.setEnUs(false);
                System.out.printf("Filòsof: %s deixa l'esquerra(%n) i espera (dreta ocupada)",
                this.getName(), esquerra.getNum());
                gana++;
                System.out.printf("Filòsof: %s gana=%n", this.getName(), gana);
            }
        }
    }

    public void pensar() {
        System.out.printf("Filòsof: %s pensant", this.getName());
        int t = ThreadLocalRandom.current().nextInt(1000, 2001);
        try {
            sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    private void agafaForquilla(Forquilla forquilla, String posicio) {
        
        System.out.printf("Filòsof: %s agafa la forquilla %s %n", 
        this.getName(), posicio, forquilla.getNum());
        forquilla.setEnUs(true);
    }
}
