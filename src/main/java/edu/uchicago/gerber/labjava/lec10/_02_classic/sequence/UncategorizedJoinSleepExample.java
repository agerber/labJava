package edu.uchicago.gerber.labjava.lec10._02_classic.sequence;



public class UncategorizedJoinSleepExample {
    public static void main(String[] args)  {
        // Create a new thread
        Thread myThread = new Thread(new Runnable() {

            //if my background thread has intermittant sleep calls. I can use it's checked exception to interrupt the
            // thread. Overkill otherwise.
            public void run() {
                int i = 0;
                while (true) {
                    i  += 10;
                    if (i > 300) break;

                    System.out.println("Running... " + i);
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

//        try {
//            myThread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
}


