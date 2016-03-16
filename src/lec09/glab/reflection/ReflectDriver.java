package lec09.glab.reflection;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/18/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReflectDriver {

    public static void main(String[] args) {
//        Rectangle recMe = new Rectangle(5,6,45,89);
//        Reflector.printClass(recMe.getClass());
//
         String strMe = "Adam";
         Reflector.printClass(strMe.getClass());

//        try {
//            Reflector.printClass("java.lang.Double");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
    }

}
