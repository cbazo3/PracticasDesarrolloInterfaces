package ThreadSynchronizationDemo;

public class ThreadSyncDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.setMessage("Mensaje " + (i + 1));
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Recibido: " + resource.getMessage());
            }
        });

        producer.start();
        consumer.start();
    }
}
