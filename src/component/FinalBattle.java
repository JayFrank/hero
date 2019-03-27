package component;
import dragon.DragonFlyweight;
import user.Hero;

public class FinalBattle extends Battle {

    public FinalBattle() {}

    public FinalBattle(Hero hero, DragonFlyweight dragon) {
        this.setHero(hero);
        this.setDragon(dragon);
    }

    @Override
    public Integer detectDragonAttack() {
        return null;
    }


}
