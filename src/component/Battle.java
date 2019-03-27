package component;

import dragon.DragonFlyweight;
import user.Hero;

// 一回合战斗接口
public abstract class Battle {
    private Hero hero = null;
    private DragonFlyweight dragon = null;
    // 攻击方式
    private Integer heroAttack = 0;
    private Integer dragonAttack = 0;

    public Battle() {}

    public Battle(Hero hero, DragonFlyweight dragon) {
        this.hero = hero;
        this.dragon = dragon;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public DragonFlyweight getDragon() {
        return dragon;
    }

    public void setDragon(DragonFlyweight dragon) {
        this.dragon = dragon;
    }

    public void setHeroAttack(Integer heroAttack) {
        this.heroAttack = heroAttack;
    }

    public void setDragonAttack(Integer dragonAttack) {
        this.dragonAttack = dragonAttack;
    }

    public Integer getHeroAttack() {
        return heroAttack;
    }

    public Integer getDragonAttack() {
        return dragonAttack;
    }

    // 获取一场战斗中的双方攻击方式
    public void attack(Integer heroA, Integer dragonA){}
    public void damage(){}
}
