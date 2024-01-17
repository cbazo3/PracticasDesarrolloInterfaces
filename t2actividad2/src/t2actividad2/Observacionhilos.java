package t2actividad2;

public class Observacionhilos {
	    static class MiHilo implements Runnable {
	        @Override
	        public void run() {
	            int suma = 0;
	            for (int i = 0; i <= 10; i++) {
	                suma += i;
	            }
	            System.out.println(Thread.currentThread().getName() + " - Suma: " + suma);
	        }
	    }

	    public static void main(String[] args) {
	        for (int i = 0; i < 5; i++) {
	            Thread hilo = new Thread(new MiHilo());
	            hilo.start();
	        }
	    }
	}
