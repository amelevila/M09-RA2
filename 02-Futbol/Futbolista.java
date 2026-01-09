public class Futbolista extends Thread {
    private int ngols;
    private int ntirades;
    
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i<NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) ngols++;
        }
    }

    public int getGols() {
        return this.ngols;
    }

    public int getTirades() {
        return this.ntirades;
    }
    
    public static void main(String[] args) {
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};
        Futbolista[] futbolistes = new Futbolista[NUM_JUGADORS];

        for (int i = 0; i<NUM_JUGADORS; i++) {
            futbolistes[i] = new Futbolista(noms[i]);
        }

        System.out.println("Inici dels xuts -----------------");
        for (Futbolista futbolista : futbolistes) {
            futbolista.start();
        }
        System.out.println("Fi dels xuts --------------------");

        // Esperar que tots acabin
        for (Futbolista futbolista : futbolistes) {
            try {
                futbolista.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("--- Estadístiques ------");
        for (Futbolista futbolista : futbolistes) {
            System.out.printf("%-20s -> %d gols\n", futbolista.getName(), futbolista.getGols());
        }
    }
}
