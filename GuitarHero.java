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

public class GuitarHero {

    // CONSTANTS.
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {

        // Strings.
        GuitarString[] guitarStrings = new GuitarString[KEYBOARD.length()];
        for (int i = 0; i < guitarStrings.length; i++) {
            guitarStrings[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }

        // running.
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                int index = KEYBOARD.indexOf(StdDraw.nextKeyTyped());
                if (index != -1){
                    guitarStrings[index].pluck();
                }
            }
            double sample = 0;
            for (int i = 0; i < guitarStrings.length; i++) {
                sample += guitarStrings[i].sample();
                guitarStrings[i].tic();
            }
            StdAudio.play(sample);

        }

    }
}
