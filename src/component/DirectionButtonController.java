package component;

import ui.InfoBoard;
import ui.MapPanel;
import user.Hero;

import javax.swing.*;


public class DirectionButtonController {
    // 持有地图显示面板引用以更新地图
    private MapPanel mapPanel;
    // 持有地图引用以更新地图
    private WorldMap worldMap;
    // 信息面板
    private InfoBoard infoBoard;
    // 风景生成器
    private Scenery scenery;
    // 战斗按钮控制器
    private BattleButtonController battleButtonController;

    // 存放Hero的引用
    private Hero hero = null;

    public DirectionButtonController(MapPanel mapPanel,
                                     WorldMap worldMap,
                                     InfoBoard infoBoard
                                     ){
        this.mapPanel = mapPanel;
        this.infoBoard = infoBoard;
        this.worldMap = worldMap;
        // 由Controller生成风景数据生成器
        this.scenery = new Scenery();

    }

    /**
     * 向按钮对象组传入自身，绑定按钮响应事件
     */
    public DirectionButtonController(MapPanel mapPanel,
                                     WorldMap worldMap,
                                     InfoBoard infoBoard,
                                     Hero hero
    ){
        this(mapPanel, worldMap, infoBoard);
        this.hero = hero;
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
        infoBoard.getInfoTextArea().setText(sceneryDescription);
        infoBoard.getInfoTextArea().revalidate();
    }

    /**
     * 根据算法随机决定下一状态
     * 输出：0 --- 未遇到恶龙
     *      1 ---  进入普通战斗模式
     *      2 ---  进入终极战斗模式
     */
    private Integer getNextState(){
        // 待实现下一状态生成算法
        Integer num = (int) ( Math.random() * 100);
        // System.out.println("num"+ num);
        Integer stateCode = 0;
        if (num < 20) {
            // 进入普通战斗模式
            stateCode = 1;
        } else if (num < 30) {
            // 进入终极战斗模式
            stateCode = 2;
        }
        return stateCode;
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
                this.disableDirectionsButton(1);
                War war1 = new War(hero, "normal");

                break;

            case 2:
                updateInfoPanel(true);
                // 进入终极战斗模式 --- 开始监听战斗模式的操作按钮，同时屏蔽对方向控制按钮的监听
                this.disableDirectionsButton(2);
                War war2 = new War(hero, "magic");
                break;

                default:
                    updateInfoPanel(false);
        }


    }

    /**
     * 激活方向按钮
     */
    public void enableDirectionsButton(){
        this.mapPanel.enbaleButtons();
    }

    /**
     * 进入战斗模式，先关闭方向按钮响应，再激活战斗按钮
     * @param mood 战斗模式
     */
    private void disableDirectionsButton(Integer mood){
        this.mapPanel.disableButtons();
        if(this.battleButtonController != null){
            this.battleButtonController.enableWar(mood);
        }
    }

    public void setBattleButtonController(BattleButtonController battleButtonController){
        this.battleButtonController = battleButtonController;
        //设定另一按钮控制器后，绑定方向按钮响应事件
        this.activeController();
    }

}
