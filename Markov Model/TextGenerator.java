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

import java.util.Scanner;

public class TextGenerator {

    // Main class to execute the program.
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        String text = "";
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            text += scan.nextLine();
        }
        if (text.length() >= k) {
            MarkovModel markovModel = new MarkovModel(text, k);
            String output = "";
            if (k == 0) {
                for (int i = 0; i < T; i++) {
                    output += markovModel.random("");
                }
            } else {
                String kgram = text.substring(0, k);
                output += kgram;
                for (int i = 0; i < T - k; i++) {
                    char next = markovModel.random(kgram);
                    output += next;
                    kgram = kgram.substring(1, k);
                }
            }
            System.out.println(output);
        } else {
            System.out.println("Invalid text length.");
        }
    }
}
