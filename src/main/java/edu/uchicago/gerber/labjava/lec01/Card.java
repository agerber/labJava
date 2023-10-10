package edu.uchicago.gerber.labjava.lec01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Card {

    //instance field definitions loaded by class-loader
    //instance field values stored in individual instances on the heap
    private char face;
    private char suit;
    private byte value;

    //static field definition loaded by class-loader
    //static field value loaded by class-loader; value does not exist on heap
    private static final int NUM_CARDS_IN_DECK = 52;

    //calling syntax: Card.howManyCards()
    //static method definition loaded by class-loader
    public static int howManyCards(){
        return NUM_CARDS_IN_DECK;
    }

    //calling syntax: new Card('K', 'S', 11)
    //constructor definition loaded by class-loader
    public Card(char face, char suit1, byte value1) {
        this.face = face;
        suit = suit1;
        value = value1;
    }

    //calling syntax: implicitParameter.getFace()
    //instance methods definitions loaded by class-loader
    public char getFace() {
        return face;
    }

    public void setFace(char face) {
        this.face = face;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====instance =====\n");
        sb.append("===     " + face + "       ==\n");
        sb.append("===     " + suit + "       ==\n");
        sb.append("===     " + value + "      ==\n");
        sb.append("==================\n\n");
        return sb.toString();
    }
//
//    public String getClassObjectAsString() throws IllegalAccessException {
//        StringBuilder sb = new StringBuilder();
//        sb.append("====class-object =============================================================\n");
//
//        sb.append("METHODS\n");
//        Method[] methods = Card.class.getDeclaredMethods();
//        for (Method method : methods) {
//            if (Modifier.isStatic(method.getModifiers()))
//                sb.append(":::::::::STATIC \n");
//
//            sb.append("\n");
//        }
//
//        sb.append("FIELOS\n");
//        Field[] fields = Card.class.getDeclaredFields();
//        for (Field field : fields) {
//
//            if (Modifier.isStatic(field.getModifiers())){
//                sb.append(":::::::::STATIC\n");
//                field.setAccessible(true);
//                sb.append(field.get(null).toString() + "\n");
//            }
//            sb.append(field+ "\n");
//        }
//        sb.append("CONSTRUCTORS \n");
//        Constructor<?>[] constructors = Card.class.getDeclaredConstructors();
//        for (Constructor<?> constructor : constructors) {
//            sb.append(constructor+ "\n");
//        }
//
//
//        sb.append("\n");
//        sb.append("====end class-object =============================================================\n");
//
//        return sb.toString();
//
//
//    }
}
