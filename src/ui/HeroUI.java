package ui;

import component.WarButtonController;
import component.DirectionButtonController;
import component.WorldMap;
import user.Hero;

import javax.swing.*;
import java.awt.*;

public class HeroUI {
    // ---- UI元素 ---
    private JFrame frame;

    // 英雄信息面板
    private HeroInfoUI heroInfoUI;
    //其他信息面板
    private OtherInfoUI otherInfoUI;
    // 地图与方向控制面板
    private MapPanel mapPanel;
    //管理操作按钮面板
    private OperationPanel operationPanel;
    // 展示系统信息面板
    private InfoBoard infoBoard;

    // --- 控制器 ---
    private DirectionButtonController directionButtonController;
    private WarButtonController warButtonController;

    public HeroUI() {
        // 初始化组成元素
        Hero hero = new Hero();
        WorldMap worldMap = hero.getWorldMap();
        this.heroInfoUI = new HeroInfoUI(hero.getHeroDesc());
        this.otherInfoUI = new OtherInfoUI(hero);
        this.mapPanel = new MapPanel(worldMap);
        this.operationPanel = new OperationPanel();
        this.infoBoard = new InfoBoard();

        // 初始化控制器元素
        this.directionButtonController = new DirectionButtonController(this.mapPanel,worldMap,this.infoBoard);
        this.warButtonController = new WarButtonController(this.infoBoard,this.operationPanel);
        this.directionButtonController.setWarButtonController(this.warButtonController);
        this.warButtonController.setDirectionButtonController(this.directionButtonController);
        initializeUI();

    }

    private void initializeUI() {
        this.frame = new JFrame("Hero");
        this.frame.setSize(400, 200);
        this.frame.setLayout(new BorderLayout());

        frame.add(heroInfoUI.getHeroInfoPanel(), BorderLayout.NORTH);
        frame.add(this.mapPanel.getMapPanel(), BorderLayout.WEST);

        frame.add(this.infoBoard.getInfoTextArea(), BorderLayout.CENTER);
        frame.add(this.otherInfoUI.getOtherInfoPanel(), BorderLayout.EAST);
        frame.add(this.operationPanel.getBtPanel(), BorderLayout.SOUTH);

        frame.setBounds(300, 200, 800, 420);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    // 构造器模式？

//    public static String getMapText(char[][] matrix) {
//        String mapText = "";
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                mapText += matrix[i][j] + "  ";
//            }
//            mapText += "\n";
//        }
//        return mapText;
//    }


//    public static void main(String[] agrs) {
//        JFrame frame=new JFrame("Hero");
//        frame.setSize(400,200);
//        frame.setLayout(new BorderLayout());

//        Hero hero = new Hero();
//        WorldMap worldMap = hero.getWorldMap();

//        // 游戏地图显示
//        char[][] matrix = worldMap.getMatrix();
//        String mapText = getMapText(matrix);
//
//        JTextArea mapTextArea = new JTextArea(mapText);
//        mapTextArea.setEditable(false);
//
//        JPanel mapPanel = new JPanel();
//        Border mapTitle = BorderFactory.createTitledBorder("蛮荒之地");
//        mapTextArea.setBorder(mapTitle);
//        mapPanel.setLayout(new BorderLayout());
//        mapPanel.add(mapTextArea, BorderLayout.NORTH);

//        JPanel movePanel = new JPanel();
//        Border moveTitle = BorderFactory.createTitledBorder("方向移动");
//        movePanel.setBorder(moveTitle);
//        movePanel.setLayout(new GridLayout(2, 3));
//        JButton emptyBt1 = new JButton("Monster");
//        // emptyBt1.setEnabled(false);
//        JButton emptyBt2 = new JButton("");
//        emptyBt2.setEnabled(false);
//        JButton wbt = new JButton("↑");
//        JButton abt = new JButton("←");
//        JButton sbt = new JButton("↓");
//        JButton dbt = new JButton("→");

//        // 模拟遇到了怪兽，最终要删除
//        emptyBt1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                worldMap.resetWorldMap();
//                String newText = getMapText(worldMap.getMatrix());
//                mapTextArea.setText(newText);
//                mapTextArea.revalidate();
//            }
//        });

//        wbt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                worldMap.move('W');
//                String newText = getMapText(worldMap.getMatrix());
//                mapTextArea.setText(newText);
//                mapTextArea.revalidate();
//            }
//        });
//
//        abt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                worldMap.move('A');
//                String newText = getMapText(worldMap.getMatrix());
//                mapTextArea.setText(newText);
//                mapTextArea.revalidate();
//            }
//        });
//
//        sbt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                worldMap.move('S');
//                String newText = getMapText(worldMap.getMatrix());
//                mapTextArea.setText(newText);
//                mapTextArea.revalidate();
//            }
//        });
//
//        dbt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                worldMap.move('D');
//                String newText = getMapText(worldMap.getMatrix());
//                mapTextArea.setText(newText);
//                mapTextArea.revalidate();
//            }
//        });


//        movePanel.add(emptyBt1);
//        movePanel.add(wbt);
//        movePanel.add(emptyBt2);
//        movePanel.add(abt);
//        movePanel.add(sbt);
//        movePanel.add(dbt);

//        mapPanel.add(movePanel, BorderLayout.SOUTH);

        // 英雄信息展示


//        JPanel heroInfoPanel = new JPanel();
//        heroInfoPanel.setLayout(new BorderLayout());
//
//        Border heroTitle = BorderFactory.createTitledBorder("英雄信息");
//        heroInfoPanel.setBorder(heroTitle);
//
//        JTextArea heroInfoArea = new JTextArea(hero.getHeroDesc());
//        heroInfoArea.setEditable(false);
//
//        heroInfoPanel.add(heroInfoArea, BorderLayout.WEST);
//        JButton editInfo = new JButton ("编辑英雄名");
//        heroInfoPanel.add(editInfo, BorderLayout.EAST);
//        heroInfoPanel.setVisible(true);

        // 武器与背包信息
//        Weapon weapon = hero.getWeapon();
//        String weaponDesc = "暂未装备武器";
//        if(null != weapon) {
//            weaponDesc = weapon.getWeaponDesc();
//        }
//        String backpackDesc = hero.getBackpack().getbackpackDesc();
//
//        JPanel otherInfoPanel = new JPanel();
//        otherInfoPanel.setLayout(new BorderLayout());
//
//        JTextArea weaponArea = new JTextArea(weaponDesc);
//        weaponArea.setEditable(false);
//        Border weaponTitle = BorderFactory.createTitledBorder("武器装备");
//        weaponArea.setBorder(weaponTitle);
//
//        JTextArea backpackArea = new JTextArea(backpackDesc);
//        backpackArea.setEditable(false);
//
//        Border backTitle = BorderFactory.createTitledBorder("你的背包");
//        backpackArea.setBorder(backTitle);
//
//        otherInfoPanel.add(weaponArea, BorderLayout.NORTH);
//        otherInfoPanel.add(backpackArea, BorderLayout.SOUTH);


//        // 功能按键
//        // 三种攻击方式
//        JButton attack1 = new JButton("冲撞攻击");
//        JButton attack2 = new JButton("侧身攻击");
//        JButton attack3 = new JButton("跳跃攻击");
//
//        // 抵近侦察，需要消耗一定的智力值
//        JButton detectBT = new JButton("抵近侦察");
//
//        // 使用智慧果实
//        JButton eatBT = new JButton("使用智慧果");
//
//        // 合成武器
//        JButton synthesisBT = new JButton("合成武器");
//
//        // 逃跑
//        JButton escapeBT = new JButton("逃离战斗");
//
//        // 使用宝石
//        JButton useRubyBT = new JButton("红宝石技能");
//        JButton useSapphireBT = new JButton("蓝宝石技能");
//
//        JPanel btPanel = new JPanel();
//        btPanel.setLayout(new GridLayout(2, 5));
//        btPanel.add(attack1);
//        btPanel.add(attack2);
//        btPanel.add(attack3);
//        btPanel.add(useRubyBT);
//        btPanel.add(useSapphireBT);
//        btPanel.add(detectBT);
//        btPanel.add(eatBT);
//        btPanel.add(synthesisBT);
//        btPanel.add(escapeBT);


//        JButton button1=new JButton ("上");
//        JButton button3=new JButton("中");
//        JButton button4=new JButton("右");
//        JButton button5=new JButton("下");

//        // 信息显示面板
//        JTextArea infoTextArea = new JTextArea("二狗：欢迎来到蛮荒之地！");
//        Border infoTitle = BorderFactory.createTitledBorder("信息面板");
//        infoTextArea.setBorder(infoTitle);
//        infoTextArea.setEditable(false);


//        frame.add(heroInfoPanel,BorderLayout.NORTH);
//        frame.add(mapPanel, BorderLayout.WEST);
//
//        frame.add(infoTextArea,BorderLayout.CENTER);
//        frame.add(otherInfoPanel,BorderLayout.EAST);
//        frame.add(btPanel,BorderLayout.SOUTH);
//
//        frame.setBounds(300,200,600,420);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

}
