package edu.uchicago.gerber.labjava.lec02.glab._2023.statics;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        // Create a new random number generator.
        //Notic that this is an object.
        Random random = new Random();

        // Generate a random boolean
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);

        // Generate a random integer
        int randomInt = random.nextInt();
        System.out.println("Random integer: " + randomInt);

        // Generate a random integer between 0 (inclusive) and 10 (exclusive)
        int randomIntBounded = random.nextInt(10);
        System.out.println("Random integer between 0 and 10 (exclusive): " + randomIntBounded);

        // Generate a random integer between 5 (inclusive) and 15 (inclusive)
        int randomIntBetween5And15 = 5 + random.nextInt(11);
        System.out.println("Random integer between 5 and 15: " + randomIntBetween5And15);

        // Generate a random double between 0.0 (inclusive) and 1.0 (exclusive)
        double randomDouble = random.nextDouble();
        System.out.println("Random double: " + randomDouble);

        // Generate a random float between 0.0f (inclusive) and 1.0f (exclusive)
        float randomFloat = random.nextFloat();
        System.out.println("Random float: " + randomFloat);

        // Generate a random long value
        long randomLong = random.nextLong();
        System.out.println("Random long: " + randomLong);

        // Generate random bytes and fill them into a provided byte array
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        System.out.print("Random bytes: ");
        for (byte b : bytes) {
            System.out.print(b + " ");
        }

        //Using the Math.random()


        // Random number between 0 (inclusive) and 1 (exclusive).  0 - 0.9999999
        System.out.println("Random number: " + Math.random());

        //some int between 0 and 30. Notice that (int) will truncate.
        System.out.println("Random number between 0 and 30: " + (int)(Math.random() * 31));


    }
}
