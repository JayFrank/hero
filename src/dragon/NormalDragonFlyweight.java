package dragon;

import attribute.DragonAttribute;

public class NormalDragonFlyweight extends DragonFlyweight{
    private Integer level;


    public NormalDragonFlyweight( Integer level) {
        super(DragonAttribute.lifeValueOfDragon[level], DragonAttribute.attackValueOfDragon[level]);
        this.level = level;
    }

    @Override
    public Integer attack() {
        Integer attack = (int)(Math.random() * 3 + 1);
        return attack;
    }

    @Override
    public Integer attack(Integer heroAttack) {
        //随机生成攻击方式

        return this.normalAttack(heroAttack);
    }
}
