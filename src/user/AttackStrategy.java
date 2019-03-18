package user;

// 攻击策略
public interface AttackStrategy {
    // 计算攻击值
    public Integer calculateAttack(Hero hero);
}
