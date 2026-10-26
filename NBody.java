/* *****************************************************************************
 *  Name:    Roshan Srivastava
 *
 *  Description:  Simulates the motion of n particles in a place, mutually effected by gravitational forces.
 *                The results are then animated.
 **************************************************************************** */

public class NBody {
    public static void main(String[] args) {

        // Values.
        double totalTime = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        int totalBodies = StdIn.readInt();
        double radius = StdIn.readDouble();

        // Bodies.
        Body[] bodies = new Body[totalBodies];
        for (int i = 0; i < totalBodies; i++) {
            bodies[i] = new Body(new Position(StdIn.readDouble(), StdIn.readDouble()),
                                 StdIn.readDouble(), StdIn.readDouble(),
                                 StdIn.readDouble(), StdIn.readString());
        }

        // StdDraw Setup.
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();

        // Simulation.
        for (double t = 0; t < totalTime; t += dt) {
            StdDraw.picture(0, 0, "starfield.jpg");
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, bodies);
                bodies[i].drawBody();
            }
            StdDraw.show();
            StdDraw.pause(10);
            StdDraw.clear();
        }

        // output.
        System.out.printf("%d\n%.2e\n", totalBodies, radius);
        for (Body each: bodies){
            System.out.printf("%.4e %.4e %.4e %.4e %.4e %s\n",
                              each.position.getX(), each.position.getY(),
                              each.xVelocity, each.yVelocity, each.mass,
                              each.filename);
        }

    }

    /**
     * Class to handle each object in the Universe.
     */
    static class Body {

        // Attributes..
        private Position position;
        private double xVelocity;
        private double yVelocity;
        private double mass;
        private String filename;
        private static final double G = 6.67e-11;

        public Body(Position position, double xVelocity, double yVelocity, double mass,
                    String filename) {
            this.position = position;
            this.xVelocity = xVelocity;
            this.yVelocity = yVelocity;
            this.mass = mass;
            this.filename = filename;
        }

        private void update(double dt, Body[] otherBodies) {

            double xForce = 0, yForce = 0;
            for (Body each: otherBodies) {
                if (!this.equals(each)) {
                    // Calculating X and Y force by other each body.
                    double distance = position.distance(each.position);
                    double force = (G * mass * each.mass) / (distance * distance);
                    double diffX = each.position.getX() - position.getX();
                    double diffY = each.position.getY() - position.getY();
                    xForce += force * diffX / distance;
                    yForce += force * diffY / distance;
                }
            }
            // updating according to forces.
            double xAcceleration = xForce / mass;
            double yAcceleration = yForce / mass;
            this.xVelocity += (dt * xAcceleration);
            this.yVelocity += (dt * yAcceleration);
            this.position.updateX(dt * xVelocity);
            this.position.updateY(dt * yVelocity);

        }

        public void drawBody() {
            StdDraw.picture(position.getX(), position.getY(), filename);
        }

    }

    /**
     * This class represents the location including x and y.
     */
    static class Position {

        // Attributes.
        private double x;
        private double y;

        public Position(double x, double y){
            this.x = x;
            this.y = y;
        }

        private double getX(){
            return x;
        }

        private double getY(){
            return y;
        }

        public void updateX(double x) {
            this.x += x;
        }

        public void updateY(double y) {
            this.y += y;
        }

        private double distance(Position otherPos){
            double dx = x - otherPos.x;
            double dy = y - otherPos.y;
            return Math.sqrt((dx * dx) + (dy * dy));
        }

    }
}
