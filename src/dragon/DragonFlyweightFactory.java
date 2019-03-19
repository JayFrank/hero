package dragon;

import java.util.HashMap;

public class DragonFlyweightFactory {
    private HashMap dragonFlyweights = new HashMap();

    public DragonFlyweightFactory(){

    }

    public DragonFlyweight getDragonFlyweight(String key){
        if(dragonFlyweights.containsKey(key)){
            return (DragonFlyweight) dragonFlyweights.get(key);
        }
        else{
            return createDragonFlyweight(key);
        }
    }

    private DragonFlyweight createDragonFlyweight(String key){
        if(key.equals("magic")){
            DragonFlyweight dragonFlyweight = new MagicDragonFlyweight();
            dragonFlyweights.put(key,dragonFlyweight);
            return dragonFlyweight;
        }else{
            DragonFlyweight dragonFlyweight = new NormalDragonFlyweight(Integer.parseInt(key));
            dragonFlyweights.put(key,dragonFlyweight);
            return dragonFlyweight;
        }
    }
}
