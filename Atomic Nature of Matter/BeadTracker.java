public class BeadTracker {

    // main method
    public static void main(String[] args) {
        int minimum = Integer.parseInt(args[0]);
        double threshold = Double.parseDouble(args[1]);
        double change = Double.parseDouble(args[2]);
        String[] files = new String[args.length - 3];
        for (int i = 3; i < args.length; i++) {
            files[i - 3] = args[i];
        }
        for (int i = 0; i < files.length - 1; i++) {
            Blob[] current = new BeadFinder(new Picture(files[i]), threshold).getBeads(minimum);
            Blob[] next = new BeadFinder(new Picture(files[i + 1]), threshold).getBeads(minimum);
            for (int j = 0; j < current.length; j++) {
                double minDistance = Double.MAX_VALUE;
                for (int k = 0; k < next.length; k++) {
                    double distance = current[j].distanceTo(next[k]);
                    if (distance < minDistance && distance <= change) {
                        minDistance = distance;
                    }
                }
                if (minDistance <= change) {
                    System.out.printf("%.4f", minDistance);
                    System.out.println();
                }
            }
        }
    }
}
