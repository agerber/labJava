package lec01.hlab;

/**
 4) Suppose you have 5 1/2 gallons of milk and want to store them in milk jars that can hold up to 0.75 gallons each.
 You want to know ahead of time how many completely filled jars you will have. The following program has been written
 for that purpose. What is wrong with it? Why? How can you fix it?

 */

public class MilkJarCalculator
{
    public static void main(String[] args)
    {
        double milk = 5.5; // gallons
        double jarCapacity = 0.75; // gallons
        //apply the cast here
        int completelyFilledJars = (int) (milk / jarCapacity);

        System.out.println(completelyFilledJars);
    }
}