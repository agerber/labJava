package edu.uchicago.gerber.labjava.lec05.debugger;

public class RecursiveDriver {

    public static void main(String[] args) {
        // Sample sentence to reverse
        String sentence = "jedi confronted his destiny with courage and strength";
        System.out.println("Original sentence: " + sentence);

        // Call the recursive method to reverse the words
        String reversed = yodaSpeak(sentence);
        System.out.println("Reversed sentence: " + reversed);
    }
    // Recursive method to reverse the words in a sentence
    public static String yodaSpeak(String sentence) {
        // Trim leading and trailing spaces
        sentence = sentence.trim();

        // Base case: If the sentence has no spaces, it's just one word, so return it
        if (!sentence.contains(" ")) {
            return sentence;
        }

        // Find the first space in the sentence
        int spaceIndex = sentence.indexOf(" ");

        // Split the sentence into the first word and the rest of the sentence
        String firstWord = sentence.substring(0, spaceIndex);
        String restOfSentence = sentence.substring(spaceIndex + 1);

        // Recursively reverse the rest of the sentence, then append the first word at the end
        return yodaSpeak(restOfSentence) + " " + firstWord;
    }

    // Main method to test the reverseWords function

}
