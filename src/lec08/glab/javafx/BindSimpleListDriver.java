/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lec08.glab.javafx;

import java.util.List;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class BindSimpleListDriver {

    public static void main(String[] args) {

        // Use Java Collections to create the List.
        List<String> list = new ArrayList<String>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(Change change) {
                System.out.println("Detected a change when you added the item to the wrapper 'ObservableList object' " +list.size() );
            }
        });
        
       

        // Changes to the observableList WILL be reported.
        // This line will print out "Detected a change!"
       // observableList.add("item one");

        for (int nC = 0; nC <20 ; nC++) {

            observableList.add("item " + nC);

        }

        // Changes to the underlying list will NOT be reported
        // Nothing will be printed as a result of the next line.
       // list.add("item two");

       // System.out.println("Size: " + observableList.size());

    }
}
