package ejemploMonitores;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}