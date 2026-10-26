public class Avogadro {

    // main method
    public static void main(String[] args) {

        double squaredDisplaceSum = 0;
        int total = 0;

        while (!StdIn.isEmpty()) {
            // square displacement
            squaredDisplaceSum += Math.pow(StdIn.readDouble() * 0.175e-6, 2);
            total += 1;
        }

        double squareDisplaceAvg = squaredDisplaceSum / (2 * total * 0.5);
        double boltConst = ((6 * Math.PI * 9.135e-4 * 0.5e-6 * squareDisplaceAvg) / 297) / 2;
        double avogadroNumber = 8.31446 / boltConst;
        System.out.printf("Boltzmann = %.4e\nAvogadro = %.4e", boltConst, avogadroNumber);

    }
}