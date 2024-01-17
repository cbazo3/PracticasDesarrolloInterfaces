package actividad6;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            resource.accessResource();
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            resource.accessResource();
        }, "Thread-2");

        Thread thread3 = new Thread(() -> {
            resource.accessResource();
        }, "Thread-3");

        Thread thread4 = new Thread(() -> {
            resource.accessResource();
        }, "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
