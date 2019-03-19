package component;

public class WorldMap {
    private Integer length = 8;
    private Integer width = 9;
    private char[][] matrix;

    public WorldMap() {
        matrix = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j =0; j < width; j++) {
                matrix[i][j] = '#';
            }
        }
        matrix[length - 1][width / 2] = '^';
    }

    public void printMatrix() {
        System.out.println("The Map Of Your World!");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(this.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
