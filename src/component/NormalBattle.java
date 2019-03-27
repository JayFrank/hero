package component;

import dragon.DragonFlyweight;
import user.Hero;

public class NormalBattle extends Battle {
    public NormalBattle() {}

    public NormalBattle(Hero hero, DragonFlyweight dragon) {
        this.setHero(hero);
        this.setDragon(dragon);
        Integer dragonAttack = dragon.attack();

    }

}
