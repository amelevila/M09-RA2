public class MainDemoFil {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("MainDemoFil.main:");
        System.out.printf(
            "Prioritat -> %d, Nom -> %s\ntoString() -> %s",
            t.getPriority(), t.getName(), t.toString()
        );
    }
}