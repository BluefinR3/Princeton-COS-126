import java.awt.Color;
import java.util.ArrayList;

public class BeadFinder {

    /*
    Attributes.
     */
    // Tracking of pixels
    private final boolean[][] dfsTracking;
    // Picture to find beads
    private final Picture beadPicture;
    // Threshold for luminance
    private final double luminanceThreshold;
    // List of blobs
    private final ArrayList<Blob> blobArrayList;

    // Constructor to find all blobs
    public BeadFinder(Picture picture, double tau) {
        this.beadPicture = picture;
        this.luminanceThreshold = tau;
        this.dfsTracking = new boolean[beadPicture.width()][beadPicture.height()];
        this.blobArrayList = new ArrayList<>();
        for (int i = 0; i < beadPicture.width(); i++) {
            for (int j = 0; j < beadPicture.height(); j++) {
                Color color = this.beadPicture.get(i, j);
                double luminance = 0.299 * color.getRed() + 0.587 * color.getGreen()
                        + 0.114 * color.getBlue();
                if (!this.dfsTracking[i][j] && luminance >= tau) {
                    Blob newBlob = new Blob();
                    depthFirstSearch(i, j, newBlob);
                    if (newBlob.mass() > 0) {
                        this.blobArrayList.add(newBlob);
                    }
                }
            }
        }
    }

    // depth first search for beads
    private void depthFirstSearch(int xLoc, int yLoc, Blob newBlob) {

        if (xLoc >= 0 && xLoc < this.beadPicture.width() && yLoc >= 0 &&
                yLoc < this.beadPicture.height()) {
            Color color = this.beadPicture.get(xLoc, yLoc);
            double luminance = 0.299 * color.getRed() + 0.587 * color.getGreen()
                    + 0.114 * color.getBlue();
            if (!this.dfsTracking[xLoc][yLoc] &&
                    luminance >= this.luminanceThreshold) {
                this.dfsTracking[xLoc][yLoc] = true;
                newBlob.add(xLoc, yLoc);
                depthFirstSearch(xLoc + 1, yLoc, newBlob);
                depthFirstSearch(xLoc - 1, yLoc, newBlob);
                depthFirstSearch(xLoc, yLoc + 1, newBlob);
                depthFirstSearch(xLoc, yLoc - 1, newBlob);
            }
        }
    }

    // all beads in range
    public Blob[] getBeads(int min) {
        ArrayList<Blob> rangeBeadsList = new ArrayList<>();
        for (int i = 0; i < blobArrayList.size(); i++) {
            Blob each = blobArrayList.get(i);
            if (each.mass() >= min) {
                rangeBeadsList.add(each);
            }
        }
        return rangeBeadsList.toArray(new Blob[] { });
    }

    // Test client
    public static void main(String[] args) {
        BeadFinder beadFinder = new BeadFinder(new Picture(args[2]),
                                               Double.parseDouble(args[1]));
        Blob[] beads = beadFinder.getBeads(Integer.parseInt(args[0]));
        for (int i = 0; i < beads.length; i++) {
            System.out.println(beads[i]);
        }
    }
}
