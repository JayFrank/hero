package component;

import dragon.DragonFlyweight;
import dragon.DragonFlyweightFactory;
import user.Hero;

// 一场战斗，可能包含多个回合
public class War {
    private Hero hero = null;
    private DragonFlyweightFactory factory = new DragonFlyweightFactory();
    private DragonFlyweight dragon = null;

    public War(Hero hero, String type) {
        // 策略模式
        this.hero = hero;
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

}
