package equipment;

public class Trophy {
    private String name = null;
    private Integer num = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Trophy() {

    }

    public void createTrophy() {
        Integer rand = (int)(Math.random() * 50);
        if (rand < 5) {
            name = "红宝石";
        } else if (rand < 10) {
            name = "蓝宝石";
        } else if (rand < 20) {
            name = "钥匙";
        } else {
            name = "智慧苹果";
            num = (int)(Math.random() * 5);
        }
    }

}
