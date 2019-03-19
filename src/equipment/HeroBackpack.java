package equipment;

public class HeroBackpack {
    private Integer keyNumber = 0;
    private Integer appleNumber = 0;
    private boolean hasRuby = false;
    private boolean hasSapphire = false;

    // 使用钥匙打开城堡
    public boolean openCastle() {
        if(this.getKeyNumber() > 0) {
            this.keyNumber--;
            return true;
        } else {
            return false;
        }
    }

    public boolean getNewKey() {
        Integer max = 5;
        if(this.getKeyNumber() < max) {
            this.keyNumber++;
            return true;
        } else {
            return false;
        }
    }

    public boolean eatApple() {
        if(this.getAppleNumber() > 0) {
            this.appleNumber--;
            return true;
        } else {
            return false;
        }
    }

    public boolean getNewApple() {
        Integer max = 5;
        if(this.getAppleNumber() < max) {
            this.appleNumber++;
            return true;
        } else {
            return false;
        }
    }

    // 获取背包格式化描述
    public String getbackpackDesc() {
        String backpackStr = "红宝石: ";
        if(this.isHasRuby()) {
            backpackStr += "Yes";
        } else {
            backpackStr += "No";
        }
        backpackStr += "\n" + "蓝宝石: ";
        if(this.isHasSapphire()) {
            backpackStr += "Yes";
        } else {
            backpackStr += "No";
        }
        backpackStr += "\n" + "城堡钥匙数量: " + this.getKeyNumber();
        backpackStr += "\n" + "智慧果实数量: " + this.getAppleNumber();
        return backpackStr;
    }

    public Integer getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(Integer keyNumber) {
        this.keyNumber = keyNumber;
    }

    public Integer getAppleNumber() {
        return appleNumber;
    }

    public void setAppleNumber(Integer appleNumber) {
        this.appleNumber = appleNumber;
    }

    public boolean isHasRuby() {
        return hasRuby;
    }

    public void setHasRuby(boolean hasRuby) {
        this.hasRuby = hasRuby;
    }

    public boolean isHasSapphire() {
        return hasSapphire;
    }

    public void setHasSapphire(boolean hasSapphire) {
        this.hasSapphire = hasSapphire;
    }
}
