package dragon;

import equipment.Trophy;

public abstract class DragonFlyweight {
    private Integer lifeValue; //生命值
    private Integer attackValue; //武力值

    public DragonFlyweight(Integer lifeValue, Integer attackValue){
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
    }

    public Integer getLifeValue() {
        return lifeValue;
    }

    public Integer getAttackValue() {
        return attackValue;
    }

    /**
     *  随机生成攻击方式
     * @return
     */

    public abstract Integer attack();
    public abstract Integer attack(Integer heroAttack);

    /**
     * 根据规则生成攻击伤害值
     * @return
     */
    public Integer computePenalty(){
        return attackValue;
    }

    /**
     * 被攻击后生命值下降
     * @param penalty
     */
    public void beAttacked(Integer penalty){
        this.lifeValue -= penalty;
    }

    protected Integer normalAttack(Integer heroAttack) {
        //随机生成攻击方式
        Integer attack = (int)(Math.random()*3) + 1;

        return attack;
    }

    // 恐龙死亡之后生成战利品
    public Trophy createTrophy() {
        return new Trophy();
    }

}
