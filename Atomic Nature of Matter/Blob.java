public class Blob {

    /*
    Attributes.
     */
    // pixel count
    private int pixels;
    // sum of x -xis
    private double xcord;
    // sum of y-axis
    private double ycord;

    // Constructor
    public Blob() {
    }

    // Adds a new pixel
    public void add(int x, int y) {
        this.xcord = this.xcord + x;
        this.ycord = this.ycord + y;
        this.pixels = this.pixels + 1;
    }

    // total pixels
    public int mass() {
        return this.pixels;
    }

    // distance between 2 blobs
    public double distanceTo(Blob that) {
        if (this.pixels == 0) {
            throw new IllegalArgumentException("Pixels are 0");
        }
        else if (that.pixels == 0) {
            throw new IllegalArgumentException(("That pixels are 0"));
        }
        else {
            double changeX = (this.xcord / this.pixels) - (that.xcord / that.pixels);
            double changeY = (this.ycord / this.pixels) - (that.ycord / that.pixels);
            return Math.sqrt(changeX * changeX + changeY * changeY);
        }
    }

    // string representation
    public String toString() {
        String output = "0 (0.0000, 0.0000)";
        if (pixels != 0) {
            output = String.format("%d (%.4f, %.4f)",
                                   pixels, (xcord / pixels), (ycord / pixels));
        }
        return output;
    }

    // Main method to test the Blob class
    public static void main(String[] args) {

        Blob first = new Blob();
        first.add(1, 5);
        first.add(3, 2);

        Blob second = new Blob();
        second.add(2, 7);
        second.add(8, 3);

        System.out.println("Mass: " + first.mass() + " | " + second.mass());
        System.out.println("Details: " + first + " | " + second);
        System.out.println("Distance: " + first.distanceTo(second));

    }
}
