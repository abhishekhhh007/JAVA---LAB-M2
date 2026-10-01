
class MyThread extends Thread {

    public void run() {
        try {
            System.out.println("Thread is Running");

            System.out.println("Thread is going to sleep...");
            Thread.sleep(3000);

            System.out.println("Thread completed execution");
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

public class ThreadLifeCycle {
    public static void main(String[] args) {

        MyThread t = new MyThread();

        System.out.println("Thread created ");

        t.start();
        System.out.println("Thread started ");

        try {
            Thread.sleep(1000);
            System.out.println("Thread state after start: " + t.getState());

            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Thread state: " + t.getState());
        System.out.println("Thread has TERMINATED");
    }
}


