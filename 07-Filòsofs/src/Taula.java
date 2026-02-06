public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int n) {
        forquilles = new Forquilla[n];
        for (int i = 0; i<n; i++) {
            forquilles[i] = new Forquilla(i);
        }
        
        comensals = new Filosof[n];
        for (int i = 0; i<n-1; i++) {
            comensals[i] = new Filosof("fil" + i, forquilles[i], forquilles[i+1]);
        }
        comensals[n-1] = new Filosof("fil" + (n-1), forquilles[n-1], forquilles[0]);
    }

    public void showTaula() {
        for (Filosof fil : comensals) {
            System.out.printf("Comensal:%s esq:%n dret:%n", 
            fil.getName(), fil.getEsquerra().getNum(), fil.getDreta().getNum());
        }
    }

    public void cridarATaula() {
        for (Filosof fil : comensals) {
            fil.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}
