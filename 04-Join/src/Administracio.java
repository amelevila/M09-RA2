public class Administracio {
    private final int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int i = 0; i<num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador(
                ("Ciutadà-"+i), 
                25000f, 
                20,
                65
            );
        }
    }

    public static void main(String[] args) {
        
        Administracio admin = new Administracio();
        for (Treballador treballador : admin.poblacio_activa) {
            treballador.start();
            try {
                treballador.join();
            } catch (InterruptedException e) {
                System.out.printf("Join de treballador %s interrumput%n", treballador.getName());
            }
            System.out.printf(
                "%-10s -> edat: %d / total: %.2f%n", 
                treballador.getName(), treballador.getEdat(), treballador.getCobrat()
            );
        }
    }
}
