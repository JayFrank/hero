package ui;

import equipment.Weapon;
import user.Hero;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 负责管理其他信息面板
 * 如需其他具体化设置，可进一步修改类
 */
public class OtherInfoUI {
    private Hero hero;
    private JPanel otherInfoPanel;

    public OtherInfoUI(Hero hero){
        this.hero = hero;
        initialize();
    }

    private void initialize(){
        Weapon weapon = hero.getWeapon();
        String weaponDesc = "暂未装备武器";
        if(null != weapon) {
            weaponDesc = weapon.getWeaponDesc();
        }
        String backpackDesc = hero.getBackpack().getbackpackDesc();

        this.otherInfoPanel = new JPanel();
        this.otherInfoPanel.setLayout(new BorderLayout());

        JTextArea weaponArea = new JTextArea(weaponDesc);
        weaponArea.setEditable(false);
        Border weaponTitle = BorderFactory.createTitledBorder("武器装备");
        weaponArea.setBorder(weaponTitle);

        JTextArea backpackArea = new JTextArea(backpackDesc);
        backpackArea.setEditable(false);

        Border backTitle = BorderFactory.createTitledBorder("你的背包");
        backpackArea.setBorder(backTitle);

        this.otherInfoPanel.add(weaponArea, BorderLayout.NORTH);
        this.otherInfoPanel.add(backpackArea, BorderLayout.SOUTH);
    }

    public JPanel getOtherInfoPanel(){
        return this.otherInfoPanel;
    }

}
