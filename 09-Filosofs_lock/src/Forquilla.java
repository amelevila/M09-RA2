import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private final int num;
    private final ReentrantLock bloqueig;

    public Forquilla(int num) {
        this.num = num;
        this.bloqueig = new ReentrantLock();
    }

    public int getNum() {
        return this.num;
    }

    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}