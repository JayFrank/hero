package equipment;

public abstract class Weapon {
    // 武器名称
    private String name;

    // 武器等级
    private Integer level;

    // 武器攻击加成
    private Integer attackBouns;

    // 是否可以合成
    private boolean canSynthesize;

    // 装备武器
    public boolean carry() {
        return true;
    }

    // 卸下武器
    public boolean takeOff() {
        return true;
    }

    // 武器融合
    public boolean synthesize(Weapon newWeapon) {
        if(this.isCanSynthesize() && newWeapon.isCanSynthesize()) {
            Integer newAttackBouns = this.getAttackBouns();
            if(this.getLevel() >= newWeapon.getLevel()) {
                newAttackBouns += newWeapon.getAttackBouns() / 2;
            } else {
                this.setName(newWeapon.getName());
                this.setLevel(newWeapon.getLevel());
                newAttackBouns = this.getAttackBouns() / 2  + newWeapon.getAttackBouns();
            }
            this.setAttackBouns(newAttackBouns);
        } else {
            return false;
        }
        return true;
    }

    // 格式化输出武器信息
    public String getWeaponDesc() {
        String weaponStr;
        weaponStr = "武器名称: " + name + "\n" + "等级: " + level + "\n" + "攻击加成: " + attackBouns + "\n";
        if (this.isCanSynthesize()) {
            weaponStr += "可以合成";
        } else {
            weaponStr += "不可合成";
        }
        return weaponStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAttackBouns() {
        return attackBouns;
    }

    public void setAttackBouns(Integer attackBouns) {
        this.attackBouns = attackBouns;
    }

    public boolean isCanSynthesize() {
        return canSynthesize;
    }

    public void setCanSynthesize(boolean canSynthesize) {
        this.canSynthesize = canSynthesize;
    }

}
