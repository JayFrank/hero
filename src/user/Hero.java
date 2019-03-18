package user;

import equipment.HeroBackpack;

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

    // 英雄等级
    private Integer level = 0;

    // 背包
    private HeroBackpack backpack;

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
