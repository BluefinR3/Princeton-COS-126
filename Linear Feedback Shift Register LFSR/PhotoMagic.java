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

import java.awt.Color;

public class PhotoMagic {

    // returns a transformed copy of the specified picture, using the specified lfsr.
    public static Picture transform(Picture picture, LFSR lfsr) {
        Picture transformedImage = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                Color eachColor = picture.get(col, row);
                // generate 8-bit
                int red = eachColor.getRed() ^ lfsr.generate(8);
                int green = eachColor.getGreen() ^ lfsr.generate(8);
                int blue = eachColor.getBlue() ^ lfsr.generate(8);
                // updating values to mod them in range.
                red = Math.floorMod(red, 256);
                green = Math.floorMod(green, 256);
                blue = Math.floorMod(blue, 256);
                transformedImage.set(col, row, new Color(red, green, blue));
            }
        }
        return transformedImage;
    }

    // takes the name of an image file and a description of an lfsr as command-line arguments;
    // displays a copy of the image that is "encrypted" using the LFSR.
    public static void main(String[] args) {

        String filename = args[0];
        String seed = args[1];
        int tap = Integer.parseInt(args[2]);
        transform(new Picture(filename), new LFSR(seed, tap)).show();

    }

}