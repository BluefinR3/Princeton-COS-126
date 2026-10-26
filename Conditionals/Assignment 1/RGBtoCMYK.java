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

public class RGBtoCMYK {
    public static void main(String[] args) {
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);

        double white = Math.max(red / 255.0, Math.max(green / 255.0, blue / 255.0));

        // Compute CMYK values, handling the case where white is 0
        double cyan = white == 0 ? 0 : (white - (red / 255.0)) / white;
        double magenta = white == 0 ? 0 : (white - (green / 255.0)) / white;
        double yellow = white == 0 ? 0 : (white - (blue / 255.0)) / white;
        double black = 1 - white;

        System.out.printf("red     = %d%n", red);
        System.out.printf("green   = %d%n", green);
        System.out.printf("blue    = %d%n", blue);
        System.out.printf("cyan    = %.6f%n", cyan);
        System.out.printf("magenta = %.6f%n", magenta);
        System.out.printf("yellow  = %.6f%n", yellow);
        System.out.printf("black   = %.6f%n", black);
    }
}
