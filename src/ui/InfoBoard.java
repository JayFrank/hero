package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 展示系统信息面板
 */
public class InfoBoard {
    private JTextArea infoTextArea;
    private Queue<String> infoQueue = new LinkedBlockingQueue<String>();
    private static final Integer INFOSIZE = 3;

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

    /**
     * 提供給外部，直接更新信息面板内容
     * @param infoText
     */
    public void setInfoText(String infoText){
        if(this.infoQueue.size() == this.INFOSIZE){
            this.infoQueue.poll();
        }
        this.infoQueue.offer(infoText);
        changeInfoBoard();
    }

    /**
     * 更新信息面板
     */
    private void changeInfoBoard(){
        String cache = "";
        for(String info:infoQueue){
            cache += info +"\n";
        }
        this.infoTextArea.setText(cache);
        this.infoTextArea.validate();
    }

}
