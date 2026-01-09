public class PrincipalIguals {
    public static void main(String[] args) {
        Fil pepe = new Fil("Pepe", false);
        Fil juan = new Fil("Juan", false);

        pepe.setPriority(Thread.MIN_PRIORITY);
        juan.setPriority(Thread.MIN_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}