package user;

import java.util.Random;

public class RubyAttack implements AttackStrategy {

    @Override
    public Integer calculateAttack(Hero hero) {
        Integer attack = hero.getAttack();
        if(null != hero.getWeapon()) {
            attack = attack + hero.getWeapon().getAttackBouns();
        }
        if(hero.getBackpack().isHasRuby()) {
            Random rand = new Random();
            Integer num = rand.nextInt(10);
            if(num <= 3) {
                // 30% 概率触发10倍暴击
                attack = attack * 10;
            }
        }
        return attack;
    }
}
