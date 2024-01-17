package ThreadSynchronizationDemo;

public class SharedResource {
    private String message;

    public synchronized void setMessage(String message) {
        while (this.message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        notify();
    }

    public synchronized String getMessage() {
        while (this.message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String temp = message;
        message = null;
        notify();
        return temp;
    }
}

