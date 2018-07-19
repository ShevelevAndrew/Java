public class MFUClass {
    private final Object monitor = new Object();
    private char currentPrintOrScan = 'P';

    public static void mfu() {
        MFUClass p = new MFUClass();
        Thread t1 = new Thread(() -> {
            p.print();
        });
        Thread t2 = new Thread(() -> {
            p.scan();
        });

        t1.start();
        t2.start();
    }

    void print() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentPrintOrScan != 'P')
                        monitor.wait();
                    System.out.println("Print ");
                    currentPrintOrScan = 'S';
                    monitor.notify();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    void scan() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentPrintOrScan != 'S')
                        monitor.wait();
                    System.out.println("Scan ");
                    currentPrintOrScan = 'P';
                    monitor.notify();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
