package user;

public class SapphireAttack implements AttackStrategy {

    @Override
    public Integer calculateAttack(Hero hero) {
        Integer attack = hero.getAttack();
        if(null != hero.getWeapon()) {
            attack = attack + hero.getWeapon().getAttackBouns();
        }
        if(hero.getBackpack().isHasSapphire()) {
            attack = attack * 3;
        }
        return attack;
    }
}
