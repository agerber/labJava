/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec08.glab.javafx;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class InvalidationDriver {
  public static void main(String[] args) {
    IntegerProperty intProperty = new SimpleIntegerProperty(1024);
    
    final ChangeListener changeListener = new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            System.out.println("changed detected from " + oldValue + " to " +newValue);
        }
    };
    
    final InvalidationListener invalidationListener = new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("invalidation detected: " + observable);
      }
    };

    intProperty.addListener(invalidationListener);
    intProperty.addListener(changeListener);

    intProperty.set(2048);
  

//    intProperty.removeListener(invalidationListener);
//    intProperty.set(4096);
  }
}