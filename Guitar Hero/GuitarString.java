/* *****************************************************************************
 *  Name:    
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:    
 *  Partner NetID:   
 *  Partner Precept: 
 * 
 *  Description:  This is a template file for GuitarString.java. It lists the 
 *                constructors and methods you need, along with descriptions
 *                of what they're supposed to do.
 *  
 *                Note: it won't compile until you fill in the constructors 
 *                and methods (or at least commment out the ones whose return 
 *                type is non-void).
 *
 **************************************************************************** */

public class GuitarString {

    // CONSTANTS
    private static final int SAMPLING_RATE = 44100;
    private static final double DECAY_FACTOR = 0.996;
    private static final double LIMIT = 0.5;
    // YOUR INSTANCE VARIABLES HERE
    private RingBuffer ringBuffer;

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        int maxCapacity = (int) Math.ceil(SAMPLING_RATE / frequency);
        ringBuffer = new RingBuffer(maxCapacity);
        for (int i = 0; i < maxCapacity; i++) {
            ringBuffer.enqueue(0);
        }
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        ringBuffer = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++) {
            ringBuffer.enqueue(init[i]);
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        return ringBuffer.capacity();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        for (int i = 0; i < ringBuffer.capacity(); i++) {
            ringBuffer.dequeue();
            ringBuffer.enqueue(Math.random() - LIMIT);
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        // finding sample.
        double first = ringBuffer.dequeue();
        double second = ringBuffer.peek();
        ringBuffer.enqueue(DECAY_FACTOR * LIMIT * (first + second));
    }

    // returns the current sample
    public double sample() {
        return ringBuffer.peek();
    }

    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        GuitarString guitarString = new GuitarString(440);
        guitarString.pluck();
        System.out.println(guitarString.sample());
        guitarString.tic();
        System.out.println(guitarString.sample());
        System.out.println();

        guitarString = new GuitarString(new double[]{440, 480, 520});
        System.out.println(guitarString.length());
        guitarString.pluck();
        System.out.println(guitarString.sample());
        guitarString.tic();
        System.out.println(guitarString.sample());
        System.out.println();
    }

}
