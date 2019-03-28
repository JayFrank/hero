package component;

import dragon.DragonFlyweight;
import dragon.DragonFlyweightFactory;
import user.Hero;

// 一场战斗，可能包含多个回合
public class War {
    private Hero hero = null;
    private DragonFlyweightFactory factory = new DragonFlyweightFactory();
    private DragonFlyweight dragon = null;
    private Battle battle = null;
    private String type = null;

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

    public War(Hero hero, String type) {
        // 策略模式
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
    }

    // 创建大魔王龙
    public void createMagicDragon() {
        dragon = factory.getDragonFlyweight("magic");
    }

    public void createNewBattle() {
        if (this.battle != null) {
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
        switch (command) {
            case "红宝石技能":
                this.createNewBattle();
                this.battle.setAttackChoice(1);
                resCode = 0;
                break;
            case "蓝宝石技能":
                this.createNewBattle();
                this.battle.setAttackChoice(2);
                resCode = 0;
                break;
            case "抵近侦察":
                resCode = 0;
                this.createNewBattle();
                if(hero.canDetectAttack()) {
                    Integer dragonAttack = this.battle.getDragonAttack();
                    if(dragonAttack == 1) {

                    } else if(dragonAttack == 2) {

                    } else if(dragonAttack == 3) {

                    } else {

                    }
                } else {
                    // 不能侦测
                }
                break;
            case "使用智慧果":
                this.createNewBattle();
                resCode = 0;
                if(hero.eatApple()) {

                } else {

                }
                break;
            case "合成武器":
                resCode = 0;
                break;
            case "逃离战斗":
                resCode = 2;
                if(hero.canEscape()) {

                } else {

                }
                this.battle = null;
                break;
            case "冲撞攻击":
                resCode = 1;
                attackCode = 1;
                break;
            case "侧身攻击":
                resCode = 1;
                attackCode = 2;
                break;
            case "跳跃攻击":
                resCode = 1;
                attackCode = 3;
                break;
        }
        if (resCode == 1) {
            // 创建一次Battle
            this.createNewBattle();

            this.battle.setHeroAttack(attackCode);
            this.battle.setDragonAttack(dragon.attack());
            String res = this.battle.winBattle();

            // 攻击力设置
            this.battle.setHeroAttackValue(hero.attack(this.battle.getAttackChoice()));

            // 这里Battle胜利方
            Integer damage = 0;
            if(res == "hero") {
                damage = this.battle.getHeroAttackValue();
                dragon.beAttacked(damage);
            } else if (res == "dragon") {
                damage = this.battle.getDragonAttackValue();
                hero.beAttacked(damage);
            } else {
                // 出现平局，两败俱伤
                damage = this.battle.getHeroAttackValue();
                dragon.beAttacked(damage);
                damage = this.battle.getDragonAttackValue();
                hero.beAttacked(damage);
            }
            if((dragon.getLifeValue() <= 0) && (hero.getHealth() > 0)) {
                // 敌方死亡，战斗结束
                resCode = 2;
                hero.rebirth();
            } else if (hero.getHealth() <= 0) {
                // 英雄死亡，战斗结束
                resCode = 2;
                hero.rebirth();
            } else {

            }
            this.battle = null;
        }
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
