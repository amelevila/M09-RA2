public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", true);
        Fil pepe = new Fil("Pepe", true);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}