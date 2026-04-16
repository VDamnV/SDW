public class ConcurrentDelays {

    public static void main(String[] args) {
        
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000); 
                System.out.println("1");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("2");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("3");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}