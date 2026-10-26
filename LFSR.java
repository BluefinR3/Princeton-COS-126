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

public class LFSR {

    // Attributes.
    private int[] registers;
    private int tap;

    // creates an LFSR with the specified seed and tap
    public LFSR(String seed, int tap) {
        this.tap = tap;
        this.registers = new int[seed.length()];
        char[] regChars = seed.toCharArray();
        for (int i = 0; i < regChars.length; i++) {
            registers[i] = regChars[i] - '0';
        }
    }

    // returns the number of bits in the LFSR.
    public int length() {
        return registers.length;
    }

    // returns bit i as 0 or 1.
    public int bitAt(int i) {
        return registers[i];
    }

    // returns a string representation of this LFSR
    public String toString() {
        String output = "";
        for (int each: registers){
            output += each;
        }
        return output;
    }

    // simulates one step of this LFSR and return the new bit as 0 or 1
    public int step() {
        int bit = bitAt(0) ^ bitAt(registers.length - tap);
        for (int i = 0; i < registers.length - 1; i++) {
            registers[i] = registers[i + 1];
        }
        registers[registers.length - 1] = bit;
        return bit;
    }

    // simulates k steps of this LFSR and return the k bits as a k-bit integer
    public int generate(int k) {
        int total = 0;
        for (int i = 0; i < k; i++) {
            total = (total << 1) | step();
        }
        return total;
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        LFSR lfsr2 = new LFSR("01101000010", 9);
        StdOut.println(lfsr2);
        for (int i = 0; i < 10; i++) {
            int r = lfsr2.generate(5);
            StdOut.println(lfsr2 + " " + r);
        }
    }

}