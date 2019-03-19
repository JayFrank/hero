package user;

import equipment.HeroBackpack;
import equipment.Weapon;

public class Hero {

    // 英雄名字
    private String name;

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
    private HeroBackpack backpack = new HeroBackpack();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean becomeTutor() {
        this.isTutor = true;
        // 属性能力提升
        return true;
    }

    // 计算英雄一次成功攻击的伤害，使用策略模式
    private Integer attack(Integer choice) {
        AttackStrategy attack = null;
        switch (choice) {
            case 0:
                attack = new NormalAttack();
            case 1:
                attack = new RubyAttack();
            case 2:
                attack = new SapphireAttack();
        }
        Integer damage = attack.calculateAttack(this);
        return damage;
    }

    // hero的信息输出给UI类字符串
    public String getHeroDesc () {
        String title = "";
        if(this.isTutor()) {
            title = "英雄导师: ";
        } else {
            title = "英雄: ";
        }
        String name = this.getName();
        if(name == null) {
            name = "Frank";
        }
        String attack = String.valueOf(this.getAttack());
        String health = String.valueOf(this.getHealth());
        String mentalValue = String.valueOf(this.getMentalValue());
        String experience = String.valueOf(this.getExperience());
        String level = String.valueOf(this.getLevel());

        String heroStr = title + name + "    " + "攻击力: " + attack + "    " + "生命值: " + health + "    ";
        heroStr += "智力值: " + mentalValue + "    " + "经验值: " + experience + "    " + "等级: " + level;
        return heroStr;
    }
}
