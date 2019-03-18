import component.WorldMap;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // WorldMap map = new WorldMap();
        // map.printMatrix();
        Scanner scan = new Scanner(System.in);
        // 世界地图初始显示出来
        WorldMap map = new WorldMap();
        map.printMatrix();

        while (true) {
            System.out.println("You are here @. Move: W/A/S/D");
            System.out.print("Please input your option: ");
            String initStr = scan.next();
            String str = initStr.toLowerCase();
            switch (str) {
                case "w":
                    // 移动的业务逻辑？
                    break;
                case "a":
                    break;
                case "s":
                    break;
                case "d":
                    break;
                default:
                    break;
            }

            System.out.println(str);
        }
    }
}
