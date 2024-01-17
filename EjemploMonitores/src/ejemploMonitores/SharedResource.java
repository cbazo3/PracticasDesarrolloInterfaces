package ejemploMonitores;

import java.util.concurrent.Semaphore;

class SharedResource {
    private int item;
    private Semaphore producerSemaphore = new Semaphore(1);
    private Semaphore consumerSemaphore = new Semaphore(0);

    public int get() {
        try {
            consumerSemaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int value = item;
        producerSemaphore.release();
        return value;
    }

    public void put(int value) {
        try {
            producerSemaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        item = value;
        consumerSemaphore.release();
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.put(i);
            System.out.println("Produced: " + i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = resource.get();
            System.out.println("Consumed: " + value);
        }
    }
}