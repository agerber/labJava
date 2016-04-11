package lec02.glab;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/7/13
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
class Student{
    private String mName;
    private int mGraduate;

    private static int sNumStudent;
    public static final String SCHOOL = "UCHICAGO";

    Student(String name, int graduate) {
        mName = name;
        mGraduate = graduate;
        sNumStudent++;
    }


    int getGraduate() {
        return mGraduate;
    }

    void setGraduate(int graduate) {
        mGraduate = graduate;
    }

    private String getName() {
        return mName;
    }

    private void setName(String name) {
        mName = name;
    }

    public static int getNumStudent() {
        return sNumStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mName='" + mName + '\'' +
                ", mGraduate=" + mGraduate + " instanceNum: "+ getNumStudent() +
                '}';
    }



}
