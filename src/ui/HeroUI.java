package ui;

import component.WorldMap;
import equipment.Weapon;
import user.Hero;

import javax.swing.*;
import java.awt.*;
public class HeroUI {
    public static void main(String[] agrs)
    {
        JFrame frame=new JFrame("Hero");
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout());

        // 游戏地图显示
        WorldMap worldMap = new WorldMap();
        char[][] matrix = worldMap.getMatrix();

        String mapText = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mapText += matrix[i][j] + "  ";
            }
            mapText += "\n";
        }

        JTextArea mapTextArea = new JTextArea(mapText);
        mapTextArea.setEditable(false);

        JPanel mapPanel = new JPanel();
        mapPanel.setName("你的世界地图");
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(mapTextArea, BorderLayout.NORTH);

        // 英雄信息展示
        Hero hero = new Hero();

        JPanel heroInfoPanel = new JPanel();
        heroInfoPanel.setLayout(new BorderLayout());

        JTextArea heroInfoArea = new JTextArea(hero.getHeroDesc());
        heroInfoArea.setEditable(false);

        heroInfoPanel.add(heroInfoArea, BorderLayout.WEST);
        JButton editInfo = new JButton ("编辑英雄名");
        heroInfoPanel.add(editInfo, BorderLayout.EAST);
        heroInfoPanel.setVisible(true);

        // 武器与背包信息
        Weapon weapon = hero.getWeapon();
        String weaponDesc = "暂未装备武器";
        if(null != weapon) {
            weaponDesc = weapon.getWeaponDesc();
        }
        String backpackDesc = hero.getBackpack().getbackpackDesc();

        JPanel otherInfoPanel = new JPanel();
        otherInfoPanel.setLayout(new BorderLayout());

        JTextArea weaponArea = new JTextArea(weaponDesc);
        JTextArea backpackArea = new JTextArea(backpackDesc);

        otherInfoPanel.add(weaponArea, BorderLayout.NORTH);
        otherInfoPanel.add(backpackArea, BorderLayout.SOUTH);

        JButton button1=new JButton ("上");
        JButton button3=new JButton("中");
        JButton button4=new JButton("右");
        JButton button5=new JButton("下");


        frame.add(heroInfoPanel,BorderLayout.NORTH);
        frame.add(mapTextArea,BorderLayout.WEST);

        frame.add(button3,BorderLayout.CENTER);
        frame.add(otherInfoPanel,BorderLayout.EAST);
        frame.add(button5,BorderLayout.SOUTH);

        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
