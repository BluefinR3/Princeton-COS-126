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

public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int x = 0, y = 0;
        Random rand = new Random();

        System.out.printf("(%d, %d)%n", x, y);

        for (int i = 0; i < n; i++) {
            int direction = rand.nextInt(4);

            if (direction == 0) x++;
            else if (direction == 1) x--;
            else if (direction == 2) y++;
            else y--;

            System.out.printf("(%d, %d)%n", x, y);
        }

        int squaredDistance = x * x + y * y;
        System.out.printf("squared distance = %d%n", squaredDistance);
    }
}
