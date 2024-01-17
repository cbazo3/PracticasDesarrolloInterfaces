package actividad6;
import java.util.concurrent.Semaphore;
class SharedResource {
    private Semaphore semaphore = new Semaphore(1);
    private int data = 0;

    public void accessResource() {
        try {
            semaphore.acquire();
            data++;
            System.out.println("Data accessed and incremented by " + Thread.currentThread().getName() + ": " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}


