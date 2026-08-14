public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("worker: " + i);
            }
        });

        worker.start();
        worker.join();
        System.out.println("main 종료");
    }
}
