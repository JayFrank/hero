package user;

import equipment.HeroBackpack;
import equipment.Weapon;

public class Hero {

    // 英雄导师
    private Hero tutor = null;

    // 初始状态下，不是英雄导师，无法触发英雄导师效果
    private boolean isTutor = false;

    // 攻击力
    private Integer attack = 10;

    // 生命值
    private Integer health = 200;

    // 智力值
    private Integer mentalValue = 50;

    // 经验值
    private Integer experience = 0;

    // 英雄等级
    private Integer level = 0;

    // 背包
    private HeroBackpack backpack;

    // 武器
    private Weapon weapon = null;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Hero getTutor() {
        return tutor;
    }

    public void setTutor(Hero tutor) {
        this.tutor = tutor;
    }

    public boolean isTutor() {
        return isTutor;
    }

    public void setTutor(boolean tutor) {
        isTutor = tutor;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getMentalValue() {
        return mentalValue;
    }

    public void setMentalValue(Integer mentalValue) {
        this.mentalValue = mentalValue;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public HeroBackpack getBackpack() {
        return backpack;
    }

    public void setBackpack(HeroBackpack backpack) {
        this.backpack = backpack;
    }

    private boolean becomeTutor() {
        this.isTutor = true;
        // 属性能力提升
        return true;
    }

    // 计算英雄一次成功攻击的伤害，使用策略模式？
    private Integer attack() {

        return 0;
    }

}
