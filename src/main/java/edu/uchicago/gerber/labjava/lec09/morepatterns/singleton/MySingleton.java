package edu.uchicago.gerber.labjava.lec09.morepatterns.singleton;

public class MySingleton {

    private String report;

    //3. check if there is an instance on the heap, if not insantiate
    //2. create an instance of itself
    //1. make the constructor private

    private static MySingleton mySingleton;


    public static MySingleton getInstance(){
        if (null == mySingleton){
            mySingleton =new MySingleton();
        }
        return mySingleton;
    }

    private MySingleton() {
    }



    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
