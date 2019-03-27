package component;

import dragon.DragonFlyweight;
import user.Hero;

public class NormalBattle extends Battle {
    public NormalBattle() {}

    public NormalBattle(Hero hero, DragonFlyweight dragon) {
        this.setHero(hero);
        this.setDragon(dragon);
        // Dragon确定出招方式
        Integer dragonAttack = dragon.attack();
        this.setDragonAttack(dragonAttack);
    }

    @Override
    public Integer detectDragonAttack() {
        return this.getDragonAttack();
    }


}
