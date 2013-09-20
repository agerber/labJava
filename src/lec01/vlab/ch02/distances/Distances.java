package lec01.vlab.ch02.distances;

import java.util.Scanner;

public class Distances
{
   public static void main(String[] args)
   {
      // Read inputs
      Scanner in = new Scanner(System.in);
      System.out.print("First latitude in degrees: ");
      double lat1 = in.nextDouble();
      System.out.print("First longitude: ");
      double long1 = in.nextDouble();
      System.out.print("Second latitude: ");
      double lat2 = in.nextDouble();
      System.out.print("Second longitude: ");
      double long2 = in.nextDouble();

      // convert to radians
      lat1 = lat1 * Math.PI / 180;
      long1 = long1 * Math.PI / 180;
      lat2 = lat2 * Math.PI / 180;
      long2 = long2 * Math.PI / 180;

      double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
         + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));

      final double RADIUS = 3958.76;

      double distance = RADIUS * angle;
      System.out.println("Distance: " + distance);
      
      System.out.println();
   }
}