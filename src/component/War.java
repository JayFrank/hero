package component;

import dragon.DragonFlyweight;
import dragon.DragonFlyweightFactory;
import equipment.Trophy;
import ui.InfoBoard;
import user.Hero;

// 一场战斗，可能包含多个回合
public class War {
    private Hero hero = null;
    private DragonFlyweightFactory factory = new DragonFlyweightFactory();
    private DragonFlyweight dragon = null;
    private Battle battle = null;
    private String type = null;

    private InfoBoard infoBoard = null;

    public InfoBoard getInfoBoard() {
        return infoBoard;
    }

    public void setInfoBoard(InfoBoard infoBoard) {
        this.infoBoard = infoBoard;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public void createNormalBattle() {
        this.battle = new NormalBattle(hero, dragon);
    }

    public void createFinalBattle() {
        this.battle = new FinalBattle(hero, dragon);
    }

    public War(Hero hero, String type, InfoBoard infoBoard) {
        this.infoBoard = infoBoard;
        this.hero = hero;
        this.type = type;
        if (type == "magic") {
            this.createMagicDragon();
        } else {
            this.createNormalDragon();
        }
    }

    // 创建不同等级的小怪龙
    public void createNormalDragon() {
        Integer num = (int) ( Math.random() * 100);
        String key = "1";
        if (num < 5) {
            key = "5";
        } else if (num < 15) {
            key = "4";
        } else if (num < 35) {
            key = "3";
        } else if(num < 60) {
            key = "4";
        }
        dragon = factory.getDragonFlyweight(key);
        infoBoard.setInfoText("你遇到了恶龙！！！攻击力为: "+ dragon.getAttackValue() + ";当前生命值为: "+dragon.getLifeValue());
    }

    // 创建大魔王龙
    public void createMagicDragon() {
        dragon = factory.getDragonFlyweight("magic");
        infoBoard.setInfoText("哈哈哈，你遇到了大魔王龙！！！攻击力为: " + dragon.getAttackValue() + ";当前生命值为: "+dragon.getLifeValue());
    }

    public void createNewBattle() {
        if (this.battle == null) {
            if (this.type == "magic") {
                this.battle = new FinalBattle(hero, dragon);
            } else {
                this.battle = new NormalBattle(hero, dragon);
            }
        }
    }

    // 游戏战斗，返回状态码:0表示此次Battle继续接收输入;1表示本次Battle结束，需要更新英雄显示数据;2表示War结束，更新数据
    public Integer warAction(String command) {
        Integer resCode = 0;
        Integer attackCode = 0;
        String outStr = "";
        switch (command) {
            case "红宝石技能":
                System.out.println(hero);

                this.createNewBattle();
                if(hero.getBackpack().isHasRuby()) {
                    this.battle.setAttackChoice(1);
                    outStr += "Hero触发了红宝石技能！将有30%概率得到10倍暴击!" + "\n";
                } else {
                    outStr += "哈哈哈，红宝石你还没有！" + "\n";
                }
                resCode = 0;
                break;
            case "蓝宝石技能":
                this.createNewBattle();
                if(hero.getBackpack().isHasSapphire()) {
                    this.battle.setAttackChoice(2);
                    outStr += "Hero触发了蓝宝石技能！将有30%概率得到10倍暴击!" + "\n";
                } else {
                    outStr += "哈哈哈，蓝宝石你还没有！" + "\n";
                }
                resCode = 0;
                break;
            case "抵近侦察":
                resCode = 0;
                this.createNewBattle();
                if(hero.canDetectAttack()) {
                    outStr += "Hero成功使用了抵近侦查技术！" + "\n";
                    Integer dragonAttack = this.battle.getDragonAttack();
                    if(dragonAttack == 1) {
                        outStr += "恶龙攻击方式:冲撞攻击" + "\n";
                    } else if(dragonAttack == 2) {
                        outStr += "恶龙攻击方式:侧身攻击" + "\n";
                    } else if(dragonAttack == 3) {
                        outStr += "恶龙攻击方式:跳跃攻击" + "\n";
                    }
                } else {
                    outStr += "糟糕！无法侦测恶龙攻击方式，请小心！" + "\n";
                }
                break;
            case "使用智慧果":
                this.createNewBattle();
                resCode = 0;
                if(hero.eatApple()) {
                    outStr += "嗯！智慧苹果真好吃！" + "\n";
                } else {
                    outStr += "嗯？你看到我的苹果了吗？？？" + "\n";
                }
                break;
            case "合成武器":
                outStr += "嗯？似乎没什么武器可以合成哦！" + "\n";
                resCode = 0;
                break;
            case "逃离战斗":
                resCode = 2;
                if(hero.canEscape()) {
                    outStr += "三十六计，走为上计!" + "\n";
                } else {
                    outStr += "为了部落！我不得不迎战恶龙！" + "\n";
                }
                this.battle = null;
                break;
            case "冲撞攻击":
                resCode = 1;
                attackCode = 1;
                outStr += "Hero发动了 冲撞攻击！" + "\n";
                break;
            case "侧身攻击":
                resCode = 1;
                attackCode = 2;
                outStr += "Hero发动了 侧身攻击！" + "\n";
                break;
            case "跳跃攻击":
                resCode = 1;
                attackCode = 3;
                outStr += "Hero发动了 跳跃攻击！" + "\n";
                break;
        }
        if (resCode == 1) {
            // 创建一次Battle
            this.createNewBattle();
            this.battle.setHeroAttack(attackCode);
            this.battle.setDragonAttack(dragon.attack());
            String res = this.battle.winBattle();

            // 攻击力设置
            Integer choice = this.battle.getAttackChoice();
            Integer attackValue = hero.attack(choice);
            this.battle.setHeroAttackValue(attackValue);
            outStr += "Hero本次的总攻击力: " + attackValue + "\n";

            // 这里Battle胜利方
            Integer damage = 0;
            if(res == "hero") {
                damage = this.battle.getHeroAttackValue();
                dragon.beAttacked(damage);
                outStr += "Hero击中了恶龙，并对其造成了"+damage+"点伤害！" + "\n";
            } else if (res == "dragon") {
                damage = this.battle.getDragonAttackValue();
                hero.beAttacked(damage);
                outStr += "Hero被恶龙击中了！受到了"+damage+"点伤害！"  + "\n";
            } else {
                // 出现平局，两败俱伤
                damage = this.battle.getHeroAttackValue();
                dragon.beAttacked(damage);
                outStr += "Hero击中了恶龙，并对其造成了"+damage+"点伤害！" + "\n";
                damage = this.battle.getDragonAttackValue();
                hero.beAttacked(damage);
                outStr += "Hero被恶龙击中了！受到了"+damage +"点伤害！"  + "\n";
            }
            outStr += "恶龙:攻击力:" + dragon.getAttackValue() + "; 当前生命值为: "+dragon.getLifeValue() + "\n";
            if((dragon.getLifeValue() <= 0) && (hero.getHealth() > 0)) {
                // 敌方死亡，战斗结束
                resCode = 2;
                Trophy trophy = dragon.createTrophy();
                // hero.pickUp(trophy);
                hero.rebirth();
                outStr += "Hero杀死了恶龙！安息吧！" + "\n";
            } else if (hero.getHealth() <= 0) {
                // 英雄死亡，战斗结束
                resCode = 2;
                hero.rebirth();
                outStr += "Hero被打败了！" + "\n";
            } else {

            }
            this.battle = null;
        }
        infoBoard.setInfoText(outStr);
        return resCode;
    }

    // 抵近侦察
    public Integer detect() {
        // 如果为0标识，无法侦查
        Integer res = 0;
        if (this.hero.canDetectAttack() == true) {
            res = this.battle.getDragonAttack();
        }
        return res;
    }

    // 英雄食用苹果
    public boolean eatApple() {
        return this.hero.eatApple();
    }

    // 英雄脱离战斗
    public boolean escape() {
        return this.hero.canEscape();
    }


}
