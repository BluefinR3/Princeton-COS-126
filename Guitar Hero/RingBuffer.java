/* *****************************************************************************
 *  Name:    
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:    
 *  Partner NetID:   
 *  Partner Precept: 
 * 
 *  Description:  This is a template file for RingBuffer.java. It lists the 
 *                constructors and methods you need, along with descriptions
 *                of what they're supposed to do.
 *  
 *                Note: it won't compile until you fill in the constructors 
 *                and methods (or at least commment out the ones whose return 
 *                type is non-void).
 *
 **************************************************************************** */

public class RingBuffer {

    // YOUR INSTANCE VARIABLES HERE
    private double[] buffer;
    private int first, last, size, capacity;

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new double[capacity];
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return this.capacity;
    }

    // return number of items currently in this ring buffer
    public int size() {
        return this.size;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        return this.size == this.capacity;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        if (!isFull()){
            buffer[last] = x;
            size++;
            last++;
            last %= capacity;
        } else {
            throw new RuntimeException();
        }
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        if (!isEmpty()) {
            double output = buffer[first];
            buffer[first] = 0.0;
            first++;
            first %= capacity;
            size--;
            return output;
        } else {
            throw new RuntimeException();
        }
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        if (!isEmpty()) {
            return buffer[first];
        } else {
            throw new RuntimeException();
        }
    }

    // tests and calls every instance method in this class
    public static void main(String[] args) {
        RingBuffer ring = new RingBuffer(10);
        ring.enqueue(1);
        ring.enqueue(2);
        ring.enqueue(3);
        System.out.println(ring.isEmpty());
        System.out.println(ring.isFull());
        System.out.println(ring.size());
        System.out.println(ring.capacity());
        System.out.println(ring.peek());
        System.out.println(ring.dequeue());
        System.out.println(ring.peek());
    }

}
