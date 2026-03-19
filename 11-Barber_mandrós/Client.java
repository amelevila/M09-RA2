public class Client {
    private String nom;

    public Client(int id) {
        this.nom = "Client Client-" + id;
    }

    public String getNom() {
        return nom;
    }

    public void tallarseElCabell(String nomBarber) {
        System.out.println("Tallant cabell a " + nom);
        try {
            Thread.sleep((long) (900 + Math.random() * 100));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
