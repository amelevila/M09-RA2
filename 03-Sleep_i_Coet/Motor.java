public class Motor extends Thread {
    private int potenciaActual;
    private volatile int potenciaObjectiu;
    private int index;
    private boolean enMarxa;

    public Motor(int index) {
        this.index = index;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        enMarxa = true;
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        try {
            while(enMarxa) {
                sleep(((int) (Math.random()*1000)) + 1000);

                if (potenciaActual != potenciaObjectiu){  
                    String accio = "FerRes";
                    if (potenciaActual < potenciaObjectiu) {
                        potenciaActual++;
                        accio = "Incre.";
                    }
                    else if (potenciaActual > potenciaObjectiu) {
                        potenciaActual--;
                        accio = "Decre.";
                    }
                    
                    if (potenciaActual == potenciaObjectiu) {
                        accio = "FerRes";
                    }
                    System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n",
                        index, accio, potenciaObjectiu, potenciaActual
                    );
                    if (potenciaActual == 0) enMarxa = false;
                }
            }
        } catch (InterruptedException e) {
            System.out.printf("Motor %d interrumput%n", index);
        }
    }
}
