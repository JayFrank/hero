package user;

public class NormalAttack implements AttackStrategy {

    @Override
    public Integer calculateAttack(Hero hero) {
        Integer attack = hero.getAttack();
        if(null != hero.getWeapon()) {
            attack = attack + hero.getWeapon().getAttackBouns();
        }
        return attack;
    }
}
