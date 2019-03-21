package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 负责展示英雄信息的UI展示
 */
public class HeroInfoUI {
    private JPanel heroInfoPanel;
    public HeroInfoUI(String heroDescription){
        initialize(heroDescription);
    }

    private void initialize(String heroDescription){
        this.heroInfoPanel = new JPanel();
        this.heroInfoPanel.setLayout(new BorderLayout());

        Border heroTitle = BorderFactory.createTitledBorder("英雄信息");
        this.heroInfoPanel.setBorder(heroTitle);

        JTextArea heroInfoArea = new JTextArea(heroDescription);
        heroInfoArea.setEditable(false);

        this.heroInfoPanel.add(heroInfoArea, BorderLayout.WEST);
        JButton editInfo = new JButton ("编辑英雄名");
        this.heroInfoPanel.add(editInfo, BorderLayout.EAST);
        this.heroInfoPanel.setVisible(true);
    }

    public JPanel getHeroInfoPanel(){
        return this.heroInfoPanel;
    }
}
