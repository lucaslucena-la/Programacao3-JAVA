public class YieldDemo extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " running: " + i);
            //Thread.yield(); // Hint to let other threads run
        }
    }

    public static void main(String[] args) {
        YieldDemo t1 = new YieldDemo();
        YieldDemo t2 = new YieldDemo();
        t1.start();
        t2.start();
    }
}

