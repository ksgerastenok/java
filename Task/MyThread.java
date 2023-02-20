    private class MyThread extends Thread {
        private final AtomicReference<String> name = new AtomicReference<>("");
        private final AtomicReference<Integer> current = new AtomicReference<>(0);
        private static final AtomicReference<Integer> total = new AtomicReference<>(0);
        private static final AtomicReference<Integer> count = new AtomicReference<>(0);

        public MyThread(String name) {
            this.name.set(name);
            this.current.set(MyThread.total.get());
            MyThread.total.set(MyThread.total.get() + 1);
        }

        public void run() {
            try {
                for (int i = 0; i != 15; i += 1) {
                    synchronized (MyThread.count) {
                        while(!MyThread.count.get().equals(this.current.get())) {
                            MyThread.count.wait();
                        }
                        Thread.sleep(500);
                        System.out.println(this.name.get());
                        MyThread.count.set((MyThread.count.get() + 1) % MyThread.total.get());
                        MyThread.count.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
