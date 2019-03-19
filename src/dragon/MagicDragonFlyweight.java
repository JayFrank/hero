package dragon;

import attribute.DragonAttribute;

public class MagicDragonFlyweight extends DragonFlyweight{

    // 大魔王龙的高级技能是否被屏蔽
    private Boolean magicPrevented;

    public MagicDragonFlyweight() {
        super(DragonAttribute.lifeValueOfMagic,DragonAttribute.attackValueOfMagic);
        this.magicPrevented = false;
    }

    public void preventMagic(){
        this.magicPrevented = true;
    }

    @Override
    public Integer attack(Integer heroAttack) {
        if(this.magicPrevented.equals(false))
            return this.normalAttack(heroAttack);
        else return this.magicAttack(heroAttack);
    }

    private Integer magicAttack(Integer heroAttack){
        Integer attack = 0;
        switch (heroAttack){
            case 1:
                attack = 2;
                break;
            case 2:
                attack = 3;
                break;
            case 3:
                attack = 1;
                break;
                default:
                    System.out.println("错误的攻击方式");
        }
        return attack;
    }


}
