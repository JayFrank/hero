package component;

import ui.MapPanel;

import javax.swing.*;

public class DirectionButtonController {
    // 持有地图显示面板引用以更新地图
    private MapPanel mapPanel;
    // 持有地图引用以更新地图
    private WorldMap worldMap;
    // 信息面板
    private JTextArea infoTextArea;
    // 风景生成器
    private Scenery scenery;

    public DirectionButtonController(MapPanel mapPanel,
                                     WorldMap worldMap,
                                     JTextArea infoTextArea
                                     ){
        this.mapPanel = mapPanel;
        this.infoTextArea = infoTextArea;
        this.worldMap = worldMap;
        // 由Controller生成风景数据生成器
        this.scenery = new Scenery();
        //激活方向按钮
        activeController();
    }

    private void activeController(){
        this.mapPanel.activeButtonPanel(this);
    }


    /**
     * 更新地图
     * @param direction
     */
    private void updateMapPanel(char direction){
        worldMap.move(direction);
        String newText = worldMap.getMapText();
        mapPanel.setMapText(newText);

    }

    /**
     * 更新信息面板
     * @param reachCastle 是否到达守护者宫殿
     */
    private void updateInfoPanel(boolean reachCastle){
        String sceneryDescription = scenery.getScenery(reachCastle);
        infoTextArea.setText(sceneryDescription);
        infoTextArea.revalidate();
    }

    /**
     * 根据算法随机决定下一状态
     * 输出：0 --- 未遇到恶龙
     *      1 ---  进入普通战斗模式
     *      2 ---  进入终极战斗模式
     */
    private Integer getNextState(){
        // 待实现下一状态生成算法

        return 0;
    }

    public void directionButtonPressed(char direction){
        // 更新地图
        updateMapPanel(direction);
        Integer nextState = getNextState();
        switch(nextState){
            case 0:
                updateInfoPanel(false);
                break;
            case 1:
                updateInfoPanel(false);
                // 进入普通战斗模式 --- 开始监听战斗模式的操作按钮，同时屏蔽对方向控制按钮的监听

                break;
            case 2:
                updateInfoPanel(true);
                // 进入终极战斗模式 --- 开始监听战斗模式的操作按钮，同时屏蔽对方向控制按钮的监听

                break;
                default:
                    updateInfoPanel(false);
        }


    }

}
