package JavaOOP.WorkingWithAbstraction.Abstractions.JediGalaxy;

public class StarsManipulator {
    private Galaxy galaxy;

    public StarsManipulator(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroy(int[] evilCoordinates) {
        int row = evilCoordinates[0];
        int col = evilCoordinates[1];

        while (row >= 0 && col >= 0) {
            if (checkBounds(row, col)) {
                this.galaxy.setStarValue(row, col, 0);
            }
            row--;
            col--;
        }
    }

    public long collect(int[] playerCoordinates) {
        int row = playerCoordinates[0];
        int col = playerCoordinates[1];

        long result = 0;

        while (row >= 0 && col < this.galaxy.getCols()) {
            if (checkBounds(row, col)) {
                result += this.galaxy.getStarValue(row, col);
            }
            row--;
            col++;
        }
        return result;
    }

    private boolean checkBounds(int row, int col) {
        return row >= 0 && col >= 0 && this.galaxy.getRows() > row && this.galaxy.getCols() > col;
    }
}
