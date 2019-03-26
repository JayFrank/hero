package component;

import dragon.DragonFlyweight;
import dragon.DragonFlyweightFactory;
import user.Hero;

// 一场战斗，可能包含多个回合
public class War {
    private Hero hero = null;
    private DragonFlyweightFactory factory = new DragonFlyweightFactory();
    private DragonFlyweight dragon = null;

    public War() {
        createDragon();
    }

    public War(Hero hero) {
        this();
        this.hero = hero;
    }

    // 创建不同等级的小怪龙
    public void createDragon() {
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



}
