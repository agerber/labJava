package lec04.glab.employee;


import java.util.Date;
import java.util.GregorianCalendar;


public class Employee extends Person {

    private double mSalary;
    private Date mHireDate;

    public Employee(String strName, double dSalary, int nYear, int nMonth, int nDay) {
        super(strName);
        this.mSalary = dSalary;
        this.mHireDate = new GregorianCalendar(nYear, nMonth - 1, nDay).getTime();

    }

    public double getSalary() {
        return mSalary;
    }

    public void setSalary(double salary) {
        mSalary = salary;
    }

    public Date getHireDate() {
        return mHireDate;
    }

    public void setHireDate(Date hireDate) {
        this.mHireDate = hireDate;
    }

    public void raiseSalary(double dPercent) {
        double dRaise = mSalary * dPercent / 100;
        mSalary += dRaise;
    }


    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return String.format("an Employee with a salary of $%.2f", mSalary);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString();
    }



}
