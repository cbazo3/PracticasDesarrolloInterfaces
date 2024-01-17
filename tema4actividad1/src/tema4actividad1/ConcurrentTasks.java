package tema4actividad1;

public class ConcurrentTasks {

    // Simulación de abrir un navegador
    static class OpenBrowserThread extends Thread {
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Abriendo pestaña " + i + " en el navegador...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Simulación de reproducir música
    static class PlayMusicThread extends Thread {
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Reproduciendo canción " + i + "...");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Simulación de descargar un archivo
    static class DownloadFileThread extends Thread {
        public void run() {
            System.out.println("Descargando archivo...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Archivo descargado con éxito.");
        }
    }

    public static void main(String[] args) {
        OpenBrowserThread t1 = new OpenBrowserThread();
        PlayMusicThread t2 = new PlayMusicThread();
        DownloadFileThread t3 = new DownloadFileThread();

        t1.start();
        t2.start();
        t3.start();
    }
}