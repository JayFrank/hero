package component;

import ui.InfoBoard;
import ui.OperationPanel;
import user.Hero;

public class WarButtonController {
    // 信息面板
    private InfoBoard infoBoard;
    // 战斗模式按钮面板以控制按钮
    private OperationPanel operationPanel;
    // 方向按钮控制器
    private DirectionButtonController directionButtonController;

    // 英雄的引用
    private Hero hero = null;
    // 战役引用
    private War war = null;

    public WarButtonController(InfoBoard infoBoard, OperationPanel operationPanel){
        this.infoBoard = infoBoard;
        this.operationPanel = operationPanel;

    }

    /**
     * 将被点击的按钮信息直接传给战斗类，由其处理
     */
    public void operationButtonPressed(String pressedButton) {

        System.out.println("0000");
        // 战斗类处理当前用户点击按钮并返回状态结果，指明当前战斗状态

        // 战斗状态为1表示退出战斗，切换模式

        // pressedButton若为“逃离战斗”,也切换模式
        if(pressedButton.equals("逃离战斗")){
            this.disableWar();
        }

    }

    /**
     * 向按钮对象组传入自身，绑定按钮响应事件
     */
    private void activeController(){
        this.operationPanel.initializeController(this);
    }

    /**
     * 退出战斗模式，先关闭战斗按钮，再激活方向按钮
     */
    private void disableWar(){
        // 关闭操作按钮
        this.operationPanel.disableButtons();
        // 激活方向按钮控制器
        if(this.directionButtonController != null){
            this.directionButtonController.enableDirectionsButton();
        }
    }

    public void enableWar(Integer mood, Hero hero){
        //激活操作按钮
        this.operationPanel.enableButtons();
        this.hero = hero;
        // 根据mood激活终极战斗类,1为普通战斗,2为终极战斗
        if (mood == 1) {
           this.war = new War(hero, "normal");
        } else if (mood == 2) {
            this.war = new War(hero, "magic");
        }
    }

    public void setDirectionButtonController(DirectionButtonController directionButtonController){
        this.directionButtonController = directionButtonController;
        // 设置另一按钮控制器后才绑定按钮
        this.activeController();
        // 初始状态关闭操作按钮
        this.disableWar();
    }


}
