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

    public abstract Integer detectDragonAttack();

    // 判定输赢情况
    public String winBattle(Integer heroA, Integer dragonA) {
        String heroWin = "hero";
        String dragonWin = "dragon";
        String res = "tie";
        switch (heroA) {
            case 1:
                switch (dragonA) {
                    case 1:
                        break;
                    case 2:
                        res = dragonWin;
                        break;
                    case 3:
                        res = heroWin;
                        break;
                }
            case 2:
                switch (dragonA) {
                    case 1:
                        res = heroWin;
                        break;
                    case 2:
                        break;
                    case 3:
                        res = dragonWin;
                        break;
                }
            case 3:
                switch (dragonA) {
                    case 1:
                        res = dragonWin;
                        break;
                    case 2:
                        res = heroWin;
                        break;
                    case 3:
                        break;
                }
        }
        return res;
    }

    public void damage(){}
}
