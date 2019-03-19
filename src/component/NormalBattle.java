package component;

import user.Hero;

public class NormalBattle implements Battle {
    private Hero hero;
    // private Dragon dragon;
    private Integer heroA = 0;
    private Integer dragonA = 0;

    public NormalBattle() {}

    public NormalBattle(Hero hero) {
        // 这里需要把Dragon的实体类传入进来

    }

    @Override
    public void attack(Integer heroA, Integer dragonA) {

    }

    @Override
    public void damage() {
        // 对于某一方造成攻击，可以使用策略模式

    }
}
