package ui;

import component.DirectionButtonController;
import component.WorldMap;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 负责当前地图的UI展示
 */
public class MapPanel {
    private JTextArea mapTextArea;
    private WorldMap worldMap;
    private JPanel mapPanel;
    private DirectionButtonPanel directionButtonPanel;

    public MapPanel(WorldMap worldMap){
        this.worldMap = worldMap;
        // 由地图面板生成方向控制面板UI
        this.directionButtonPanel = new DirectionButtonPanel();
        initialize();
    }

    /**
     * 初始化UI展示内容
     */
    private void initialize(){
        this.mapTextArea = new JTextArea(worldMap.getMapText());
        this.mapTextArea.setEditable(false);

        this.mapPanel = new JPanel();
        Border mapTitle = BorderFactory.createTitledBorder("蛮荒之地");
        this.mapTextArea.setBorder(mapTitle);
        this.mapPanel.setLayout(new BorderLayout());
        this.mapPanel.add(mapTextArea, BorderLayout.NORTH);
        this.mapPanel.add(directionButtonPanel.getMovePanel(), BorderLayout.SOUTH);
    }

    public JPanel getMapPanel(){
        return this.mapPanel;
    }

    public void setMapText(String mapText){
        this.mapTextArea.setText(mapText);
        this.mapTextArea.revalidate();
    }

    public void activeButtonPanel(DirectionButtonController directionButtonController){
        this.directionButtonPanel.initializeController(directionButtonController);
    }
}
