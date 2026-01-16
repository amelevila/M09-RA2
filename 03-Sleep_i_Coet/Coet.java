import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    static Scanner in = new Scanner(System.in);

    public void passaAPotencia(int p) {
        if (p<0 || p>10) {
            System.out.println("Potència ha d'estar entre 0 i 10");
            return;
        }
        
        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {
        for (int i = 0; i<motors.length; i++) {
            motors[i] = new Motor(i);
            motors[i].start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        int p = -1;
        
        coet.arranca();      
        
        while (p != 0) {
            p = in.nextInt();
            coet.passaAPotencia(p);
        }
    }
}
