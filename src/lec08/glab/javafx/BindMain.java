/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec08.glab.javafx;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Bill {
 
    // Define a variable to store the property
    private DoubleProperty amountDue = new SimpleDoubleProperty();
 
    // Define a getter for the property's value
    public final double getAmountDue(){return amountDue.get();}
 
    // Define a setter for the property's value
    public final void setAmountDue(double value){amountDue.set(value);}
 
     // Define a getter for the property itself
    public DoubleProperty amountDueProperty() {return amountDue;}
 
}

class Person {
       private StringProperty name = new SimpleStringProperty();

      public Person(String name) {
         setName(name);
      }


      public String getName() {
          return name.get();
      }

      public void setName(String name) {
          this.name.set(name);
      }

           public StringProperty getNamePropety() {
          return name;
      }


  }
    
 
public class BindMain {
 
    public static void main(String[] args)  {
 
     final Bill electricBill = new Bill();
     final Person person = new Person("Adam");
     
//     person.getNamePropety().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                System.out.println("changed name property of person to " + person.getName());
//            }
//        });
//
//       electricBill.amountDueProperty().addListener(new ChangeListener(){
//        @Override public void changed(ObservableValue o,Object oldVal,
//                 Object newVal){
//             System.out.println("Electric bill has changed to " + electricBill.getAmountDue());
//        }
//      });




        person.getNamePropety().addListener(cl -> {

            System.out.println("changed name property of person to " + person.getName());
        });

        electricBill.amountDueProperty().addListener(cl -> {
            System.out.println("Electric bill has changed to " + electricBill.getAmountDue());
        });

     
        for (int i = 0; i < 10; i++) {
           
             electricBill.setAmountDue(new Random().nextDouble() * 100);
              person.setName("Adam" +new Random().nextInt(999999));
         try {
             Thread.sleep(200);
         } catch (InterruptedException ex) {
             Logger.getLogger(BindMain.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        }
 
       
       
     
     
    }
}