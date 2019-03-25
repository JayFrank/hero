package ui;

import javax.swing.*;
import java.awt.*;

/**
 * 管理操作按钮面板的UI
 */
public class OperationPanel {
    // 管理操作按钮的面板
    private JPanel btPanel;

    // 各种操作按钮
    // 三种攻击方式
    private JButton attack1;
    private JButton attack2;
    private JButton attack3;

    // 抵近侦察，需要消耗一定的智力值
    private JButton detectBT;
    // 使用智慧果实
    private JButton eatBT;
    // 合成武器
    private JButton synthesisBT;
    // 逃跑
    private JButton escapeBT;
    // 使用宝石
    private JButton useRubyBT;
    private JButton useSapphireBT;

    public OperationPanel(){
        initializeUI();
        initializeController();
    }

    /**
     * 初始化UI元素
     */
    private void initializeUI(){
        // 功能按键初始化
        this.attack1 = new JButton("冲撞攻击");
        this.attack2 = new JButton("侧身攻击");
        this.attack3 = new JButton("跳跃攻击");

        this.detectBT = new JButton("抵近侦察");

        this.eatBT = new JButton("使用智慧果");

        this.synthesisBT = new JButton("合成武器");

        this.escapeBT = new JButton("逃离战斗");

        this.useRubyBT = new JButton("红宝石技能");
        this.useSapphireBT = new JButton("蓝宝石技能");

        this.btPanel = new JPanel();
        btPanel.setLayout(new GridLayout(2, 5));
        btPanel.add(attack1);
        btPanel.add(attack2);
        btPanel.add(attack3);
        btPanel.add(useRubyBT);
        btPanel.add(useSapphireBT);
        btPanel.add(detectBT);
        btPanel.add(eatBT);
        btPanel.add(synthesisBT);
        btPanel.add(escapeBT);
    }

    /**
     * 初始化控制器元素，绑定响应函数
     */
    private void initializeController(){

    }

    public JPanel getBtPanel(){
        return this.btPanel;
    }
}
