public class Main {
    public static void main(String[] args) throws Exception {
        AtomicInteger count = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i != 15; i += 1) {
                    synchronized (count) {
                        while(count.get() != 0) {
                            count.wait();
                        }
                        Thread.sleep(500);
                        System.out.println("Ping");
                        count.set((count.get() + 1) % 3);
                        count.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i != 15; i += 1) {
                    synchronized (count) {
                        while (count.get() != 1) {
                            count.wait();
                        }
                        Thread.sleep(500);
                        System.out.println("Pong");
                        count.set((count.get() + 1) % 3);
                        count.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                for (int i = 0; i != 15; i += 1) {
                    synchronized (count) {
                        while (count.get() != 2) {
                            count.wait();
                        }
                        Thread.sleep(500);
                        System.out.println("Net");
                        count.set((count.get() + 1) % 3);
                        count.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        thread3.start();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}