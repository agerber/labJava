package edu.uchicago.gerber.labjava.lec10.glab._01_basics.sleep;



public class InterruptSleepExample {
    public static void main(String[] args) {
        // Create a new thread
        Thread myThread = new Thread(new Runnable() {

            //if my background thread has intermittant sleep calls. I can use it's checked exception to interrupt the
            // thread. Overkill otherwise.
            public void run() {
                int i = 0;
                while (true) {
                    System.out.println("Running... " + (i += 10));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted while sleeping!");
                        System.out.println("Closing any open connections or cleaning up resources");
                        break; // Break out of the loop and end the run method, thereby terminated the thread.
                    }
                }
            }
        });
        myThread.start();

        // Sleep the main thread for 3 seconds and let myThread run concurrently
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the thread background thread
        myThread.interrupt();
    }
}


