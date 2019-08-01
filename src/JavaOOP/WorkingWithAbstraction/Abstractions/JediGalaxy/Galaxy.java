package JavaOOP.WorkingWithAbstraction.Abstractions.JediGalaxy;

public class Galaxy {
    private int[][] stars;

    public Galaxy(int row, int col) {
        this.stars = new int[row][col];
        fillTheStars();
    }

    private void fillTheStars() {
        int startValue = 0;

        for (int row = 0; row < this.stars.length; row++) {
            for (int col = 0; col < this.stars[row].length; col++) {
                this.stars[row][col] = startValue++;
            }
        }
    }

    public int getStarValue(int row, int col) {
        return this.stars[row][col];
    }

    public void setStarValue(int row, int col, int value) {
        this.stars[row][col] = value;
    }

    public int getRows() {
        return this.stars.length;
    }

    public int getCols() {
        return this.stars[0].length;
    }
}
