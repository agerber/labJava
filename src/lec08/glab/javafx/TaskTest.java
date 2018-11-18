package lec08.glab.javafx;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

/**
 * Created by Adam on 8/19/2015.
 */
public class TaskTest {

    public static void main(String[] args) {

        Task<String> task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                return "yes!";
            }
        };

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                // perform an UI update here depending on the state t
                System.out.println(task.getValue());

            }
        });



        new Thread(task).start();


    }
}
