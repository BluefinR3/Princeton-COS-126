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

public class Tour {

    private Node root;
    private int manyPoints;

    // Main node.
    private class Node {
        Point p;
        Node next;

        Node(Point p) {
            this.p = p;
        }
    }

    // creates an empty tour
    public Tour() {
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        Node pointA = new Node(a);
        Node pointB = new Node(b);
        Node pointC = new Node(c);
        Node pointD = new Node(d);
        pointA.next = pointB;
        pointB.next = pointC;
        pointC.next = pointD;
        pointD.next = pointA;
        root = pointA;
        manyPoints = 4;
    }

    // returns the number of points in the tour
    public int size() {
        return manyPoints;
    }

    // returns the Length of this tour
    public double length() {
        double length = 0;
        if (root != null) {
            Node iter = root;
            do {
                length += iter.p.distanceTo(iter.next.p);
                iter = iter.next;
            } while (iter != root);
        }
        return length;
    }

    // returns a string representation of this tour
    public String toString() {
        String output = "";
        if (root != null) {
            Node iter = root;
            do {
                output += iter.p.toString() + "\n";
                iter = iter.next;
            } while (iter != root);
        }
        return output;
    }

    // draws this tour to standard drawing
    public void draw() {
        if (root != null) {
            Node iter = root;
            do {
                iter.p.drawTo(iter.next.p);
                iter = iter.next;
            } while (iter != root);
        }
    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        if (root == null) {
            root = new Node(p);
            root.next = root;
            manyPoints++;
        } else {
            Node newNode = new Node(p);
            Node nearest = root;
            double nearDist = p.distanceTo(root.p);

            Node iter = root;
            do {
                double distance = p.distanceTo(iter.p);
                if (distance < nearDist) {
                    nearest = iter;
                    nearDist = distance;
                }
                iter = iter.next;
            } while (iter != root);
            newNode.next = nearest.next;
            nearest.next = newNode;
            manyPoints++;
        }
    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        if (root == null) {
            root = new Node(p);
            root.next = root;
            manyPoints++;
        } else {
            Node newNode = new Node(p);
            Node smallest = root;
            double smallIncrease = Double.POSITIVE_INFINITY;
            Node iter = root;
            do {
                double distance = iter.p.distanceTo(p) + p.distanceTo(iter.next.p)
                        - iter.p.distanceTo(iter.next.p);
                if (distance < smallIncrease) {
                    smallIncrease = distance;
                    smallest = iter;
                }
                iter = iter.next;
            } while (iter != root);
            newNode.next = smallest.next;
            smallest.next = newNode;
            manyPoints++;
        }
    }

    // tests this class by directly calling all constructors and instance methods
    public static void main(String[] args) {
        Point pointA = new Point(10, 10);
        Point pointB = new Point(25, 24);
        Point pointC = new Point(14, 18);
        Point pointD = new Point(19, 25);
        Tour tour = new Tour(pointA, pointB, pointC, pointD);

        System.out.println("Length: " + tour.length());
        System.out.println("Size: " + tour.size());
        System.out.println("Tour: " + tour);

        System.out.println("\nSecond Constructor: ");
        Tour secondTour = new Tour();
        secondTour.insertNearest(pointA);
        secondTour.insertNearest(pointB);
        System.out.println("Inserting Nearest Point");
        System.out.println("Length: " + tour.length());
        System.out.println("Size: " + tour.size());
        System.out.println("Tour: " + tour);

        secondTour.insertSmallest(pointC);
        System.out.println("Smallest Point");
        System.out.println("Length: " + tour.length());
        System.out.println("Size: " + tour.size());
        System.out.println("Tour: " + tour);
    }
}
