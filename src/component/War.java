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

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public War(Hero hero, String type) {
        // 策略模式
        this.hero = hero;
        if (type == "magic") {
            this.createMagicDragon();
        } else {
            this.createNormalDragon();
        }
    }

    // 创建不同等级的小怪龙以及战斗
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
        // 创建一次Battle
        this.battle = new NormalBattle(hero, dragon);
    }

    // 创建大魔王龙以及一次Battle
    public void createMagicDragon() {
        dragon = factory.getDragonFlyweight("magic");
        this.battle = new FinalBattle(hero, dragon);
    }

    // 抵近侦察
    public Integer detect(Battle battle) {
        Integer res = 0;

        return 0;
    }

}
