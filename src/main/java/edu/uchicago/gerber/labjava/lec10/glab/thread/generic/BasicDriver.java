package edu.uchicago.gerber.labjava.lec10.glab.thread.generic;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/30/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicDriver {




    public static void main(String[] args) {


        //concrete runner
        //reference to thread
        MyRunner myRunner= new MyRunner();
        Thread thrZero = new Thread(myRunner);
        thrZero.start();




        //Thread is called thrOne, and Runnable is an anonymous inner class BasicDriver$1
        Thread thrOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    System.out.println("hello from " + getMetaData(this.getClass()));
                }
            }
        });
        thrOne.start();
        System.out.println(thrOne.getState());


        //Thread is reference anonymous, and Runnable is an anonymous inner class BasicDriver$2
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    System.out.println("hello from " + getMetaData(this.getClass()));
                }
            }
        }).start();



    }

    //used for reflection
    private static String getMetaData(Class cls){
        String strBuild = "class name: "+ cls.getName();

        Class[] interfaces = cls.getInterfaces();
        strBuild += " interfaces: ";
        for (Class aClass : interfaces) {
            strBuild += aClass.getName() + ", ";
        }
        strBuild += " superclass: "+ cls.getClass().getSuperclass();
        return  strBuild;
    }


    static class MyRunner implements  Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                System.out.println("hello from " + getMetaData(this.getClass()));
            }
        }
    }

}
