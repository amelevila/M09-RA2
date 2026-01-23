import java.util.Random;

public class Treballador extends Thread {
    private final float sou_anual_brut;
    private final int edad_inici_treball;
    private final int edad_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(String nom, float sou_anual_brut, int edad_inici_treball, int edad_fi_treball) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edad_inici_treball = edad_inici_treball;
        this.edad_fi_treball = edad_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        rnd = new Random();
    }

    public void cobra() {
        cobrat += sou_anual_brut/12;
    }

    public void pagaImpostos() {
        cobrat -= (sou_anual_brut/12)*0.24;
    }

    public float getCobrat() {
        return this.cobrat;
    }

    public int getEdat() {
        return this.edat_actual;
    }

    @Override
    public void run() {
        while (edat_actual<edad_fi_treball) {
            int t = rnd.nextInt(10);
            if (edat_actual>=edad_inici_treball) {
                for (int i = 0; i<12; i++) {
                    cobra();
                    pagaImpostos();
                }
            }
            edat_actual++;
            try {
                sleep(t);
            } catch (InterruptedException e) {
                System.out.printf("Treballador %s interrumput%n", this.getName());
            }
        }
    }
}
