package ThreadRunnableDemo;

public class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("Hilo creado implementando la interfaz Runnable: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }
}