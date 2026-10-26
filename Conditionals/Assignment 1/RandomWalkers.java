/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import java.util.Random;

public class RandomWalkers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        Random rand = new Random();

        double totalSquaredDistance = 0.0;

        for (int t = 0; t < trials; t++) {
            int x = 0, y = 0;

            for (int i = 0; i < n; i++) {
                int direction = rand.nextInt(4);

                if (direction == 0) x++;
                else if (direction == 1) x--;
                else if (direction == 2) y++;
                else y--;
            }

            totalSquaredDistance += x * x + y * y;
        }

        double meanSquaredDistance = totalSquaredDistance / trials;
        System.out.printf("mean squared distance = %.5f%n", meanSquaredDistance);
    }
}
