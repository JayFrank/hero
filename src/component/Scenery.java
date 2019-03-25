package component;

/**
 * 管理英雄当前所见风景内容
 */
public class Scenery {
    private final static String[] normalScenery = {
            "天呐，你来到了绝境沼泽，沼泽边上长满了芦苇，沼泽里住着可爱的青蛙和小兽",
            "天呐，你来到了珞樱山，漫山遍野布满了竹林，片片毛竹叶随着微风沙沙作响",
            "天呐，你来到了天之河，碧绿的河水自西向东流去，平静的河面下可能藏着巨大的危险",
            "天呐，你来到了盐湖，盐湖里飘荡着英雄和恶龙们的死尸，散发出一阵阵令人作呕的气味",
            "天呐，你来到了原始密洞，密洞里回荡着自远古时期传来的召唤，幽怨而凄冽：‘来吧，来吧’"
    };

    private final static String castleScenery = "恭喜你，你终于找到了守护者宫殿，在这里你很可能创造新的世界，加油！";

    public String getScenery(boolean reachCastle){
        if(reachCastle == true){
            return Scenery.castleScenery;
        }else{
            // 如果玩家未到达守护者宫殿，随机返回风景内容
            Integer index = (int)(Math.random()*normalScenery.length);
            System.out.println(index);
            return normalScenery[index];
        }
    }

}
