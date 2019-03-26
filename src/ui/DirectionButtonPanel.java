package ui;


import component.DirectionButtonController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectionButtonPanel {
    private JPanel movePanel;

    // 四个方向键
    private JButton wbt;
    private JButton abt;
    private JButton sbt;
    private JButton dbt;

    // 方向键控制器
//    private DirectionButtonController directionButtonController;

    public DirectionButtonPanel(){
//        this.directionButtonController = directionButtonController;
        initializeUI();
//        initializeController();

    }

    private void initializeUI(){
        this.movePanel = new JPanel();
        Border moveTitle = BorderFactory.createTitledBorder("方向移动");
        this.movePanel.setBorder(moveTitle);
        this.movePanel.setLayout(new GridLayout(2, 3));
        this.wbt = new JButton("↑");
        this.abt = new JButton("←");
        this.sbt = new JButton("↓");
        this.dbt = new JButton("→");

        JButton emptyBt1 = new JButton("");
        emptyBt1.setEnabled(false);
        JButton emptyBt2 = new JButton("");
        emptyBt2.setEnabled(false);

        this.movePanel.add(emptyBt1);
        this.movePanel.add(wbt);
        this.movePanel.add(emptyBt2);
        this.movePanel.add(abt);
        this.movePanel.add(sbt);
        this.movePanel.add(dbt);
    }

    public void initializeController(DirectionButtonController directionButtonController){
        this.wbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directionButtonController.directionButtonPressed('W');
            }
        });

        this.abt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directionButtonController.directionButtonPressed('A');
            }
        });

        this.sbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directionButtonController.directionButtonPressed('S');
            }
        });

        this.dbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                directionButtonController.directionButtonPressed('D');
            }
        });
    }

    public JPanel getMovePanel(){
        return this.movePanel;
    }

    public void diableItself(){
        this.wbt.setEnabled(false);
        this.abt.setEnabled(false);
        this.sbt.setEnabled(false);
        this.dbt.setEnabled(false);
    }

    public void enableItself(){
        this.wbt.setEnabled(true);
        this.abt.setEnabled(true);
        this.sbt.setEnabled(true);
        this.dbt.setEnabled(true);
    }
}
