package count_words_in_string;

public class SimulationOfDeadlock {
    final String resource1 = "resource1";
    final String resource2 = "resource2";

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting thread1!");
            synchronized (resource1) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Acquired both!");
                }
            }
            System.out.println("Completed thread1");
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting thread2");
            synchronized (resource2) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("Acquired both!");
                }
            }
            System.out.println("Completed thread2");
        }
    });

    public static void main(String[] args) {
        SimulationOfDeadlock simulationOfDeadlock = new SimulationOfDeadlock();
        simulationOfDeadlock.thread1.start();
        simulationOfDeadlock.thread2.start();
    }
}
