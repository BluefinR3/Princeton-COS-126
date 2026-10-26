/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Partner Name:    Ada Lovelace
 *  Partner NetID:   alovelace
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MarkovModel {

    private int k;
    private Map<String, Map<Character, Integer>> markovModel;

    // creates a Markov model of order k for the specified text
    public MarkovModel(String text, int k) {
        this.k = k;
        this.markovModel = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            String kgram = "";
            for (int j = 0; j < k; j++) {
                kgram += text.charAt((i + j) % text.length());
            }
            if (markovModel.get(kgram) == null) {
                markovModel.put(kgram, new HashMap<>());
            }
            char next = text.charAt((i + k) % text.length());
            Map<Character, Integer> markovMap = markovModel.get(kgram);
            int value = 0;
            if (markovMap.containsKey(next)) {
                value = markovMap.get(next);
            }
            markovMap.put(next, value + 1);
        }
    }

    // Returns the order k of this Markov model
    public int order() {
        return k;
    }

    // Returns a string representation of the Markov model (as described)
    public String toString() {
        String output = "";
        for (String key : markovModel.keySet()) {
            Map<Character, Integer> map = markovModel.get(key);
            output += key + ": ";
            for (Character character : map.keySet()) {
                output += character + "(" + map.get(character) + ") ";
            }
            output += "\n";
        }
        return output;
    }

    // returns the number of times the specified kgram appears in the text
    public int freq(String kgram) {
        int frequency = 0;
        if (kgram.length() == k) {
            Map<Character, Integer> map = markovModel.get(kgram);
            if (map != null) {
                for (int each : map.values()) {
                    frequency += each;
                }
            }
        }
        return frequency;
    }

    // returns the number of times the character c follows the specified
    // kgram in the text
    public int freq(String kgram, char c) {
        int frequency = 0;
        if (kgram.length() == k) {
            Map<Character, Integer> map = markovModel.get(kgram);
            if (map != null && map.containsKey(c)) {
                frequency = map.get(c);
            }
        }
        return frequency;
    }

    // returns a random character that follows the specified kgram in the text,
    // chosen with weight proportional to the number of times that character
    // follows the specified kgram in the text
    public char random(String kgram) {
        if (kgram.length() == k) {
            Map<Character, Integer> map = markovModel.get(kgram);
            if (map != null && map.size() > 0) {
                Random randomGenerator = new Random();
                int frequency = 0;
                for (int each : map.values()) {
                    frequency += each;
                }
                int randomValue = randomGenerator.nextInt(frequency);
                for (Character each : map.keySet()) {
                    int count = map.get(each);
                    randomValue -= count;
                    if (randomValue < 0) {
                        return each;
                    }
                }
            }
        }
        throw new RuntimeException("Should not be here.");
    }

    // Tests this class by directly calling all instance methods
    public static void main(String[] args) {
        String text1 = "banana";
        MarkovModel model1 = new MarkovModel(text1, 2);
        StdOut.println("freq(\"an\", 'a')    = " + model1.freq("an", 'a'));
        StdOut.println("freq(\"na\", 'b')    = " + model1.freq("na", 'b'));
        StdOut.println("freq(\"na\", 'a')    = " + model1.freq("na", 'a'));
        StdOut.println("freq(\"na\")         = " + model1.freq("na"));
        StdOut.println();

        String text3 = "one fish two fish red fish blue fish";
        MarkovModel model3 = new MarkovModel(text3, 4);
        StdOut.println("freq(\"ish \", 'r') = " + model3.freq("ish ", 'r'));
        StdOut.println("freq(\"ish \", 'x') = " + model3.freq("ish ", 'x'));
        StdOut.println("freq(\"ish \")      = " + model3.freq("ish "));
        StdOut.println("freq(\"tuna\")      = " + model3.freq("tuna"));
    }
}
