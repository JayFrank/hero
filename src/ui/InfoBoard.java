package ui;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * 展示系统信息面板
 */
public class InfoBoard {
    private JTextArea infoTextArea;

    public InfoBoard(){
        initialize();
    }

    private void initialize(){
        this.infoTextArea = new JTextArea("二狗：欢迎来到蛮荒之地！");
        Border infoTitle = BorderFactory.createTitledBorder("信息面板");
        this.infoTextArea.setBorder(infoTitle);
        this.infoTextArea.setEditable(false);
    }

    public JTextArea getInfoTextArea(){
        return this.infoTextArea;
    }
}
