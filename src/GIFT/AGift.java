package GIFT;

import GAMEPLAYER.AGamePlayer;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午10:50
 * To change this template use File | Settings | File Templates.
 */
public abstract class AGift {
    protected int id;       //礼品编号
    protected String name;      //礼品名称

    public AGift()
    {
        this.id = 0;
        this.name = "无";
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void use(AGamePlayer gameplayer);     //对玩家使用礼品
}
