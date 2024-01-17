package tarea;

public class Concurrente {

	    static class Tarea implements Runnable {
	        @Override
	        public void run() {
	            try {
	                System.out.println("Ejecutando tarea en: " + Thread.currentThread().getName());
	                Thread.sleep(1000); // Simulando tarea
	                System.out.println("Tarea completada en: " + Thread.currentThread().getName());
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Thread hilo1 = new Thread(new Tarea());
	        Thread hilo2 = new Thread(new Tarea());
	        
	        hilo1.start();
	        hilo2.start();
	    }
	}
