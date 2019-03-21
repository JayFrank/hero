package component;

public class WorldMap {
    private Integer length = 10;
    private Integer width = 11;
    private char[][] matrix;

    // 英雄坐标，初始时位于最底层的中间位置
    private Integer heroX = length - 1;
    private Integer heroY = width / 2;
    private char curPos = 'H';
    private char markTag = '^';
    private char monster = 'X';

    public WorldMap() {
        matrix = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j =0; j < width; j++) {
                matrix[i][j] = '#';
            }
        }
        matrix[heroX][heroY] = this.curPos;
    }

    public void resetWorldMap() {
        matrix = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j =0; j < width; j++) {
                matrix[i][j] = '#';
            }
        }
        matrix[heroX][heroY] = this.monster;
    }

    public String move(char direction) {
        String result = "无法实现此次移动，英雄停留在原地!";
        switch (direction) {
            case 'W':
                this.markTrace(-1, 0);
                result = "英雄向上移动啦！";
                break;
            case 'A':
                this.markTrace(0, -1);
                result = "英雄向左移动啦！";
                break;
            case 'S':
                this.markTrace(1, 0);
                result = "英雄向后移动啦！";
                break;
            case 'D':
                this.markTrace(0, 1);
                result = "英雄向右移动啦！";
                break;
        }
        return result;
    }

    public void markTrace(Integer moveX, Integer moveY) {
        Integer x = this.getHeroX();
        Integer y = this.getHeroY();

        Integer newX = x + moveX;
        Integer newY = y + moveY;
        // 验证
        if((newX) >= 0 && (newX) < this.getLength() && (newY) >= 0 && (newY) < this.getWidth()) {
            this.matrix[x][y] = this.markTag;
            this.matrix[newX][y + moveY] = this.curPos;
            this.setHeroX(newX);
            this.setHeroY(newY);
            // printMatrix();
        }

    }

    // 判断怪兽能否在地图上的该处出现
    public boolean canMonsterAppear(Integer x, Integer y) {
        boolean res = true;
        if(this.getMatrix()[x][y] != '#') {
            res = false;
        }
        return res;
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

    /**
     * 由WorldMap即时生成地图
     *
     * @return
     */
    public String getMapText() {
        String mapText = "";
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                mapText += this.matrix[i][j] + "  ";
            }
            mapText += "\n";
        }
        return mapText;
    }

    public Integer getHeroX() {
        return heroX;
    }

    public void setHeroX(Integer heroX) {
        this.heroX = heroX;
    }

    public Integer getHeroY() {
        return heroY;
    }

    public void setHeroY(Integer heroY) {
        this.heroY = heroY;
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
