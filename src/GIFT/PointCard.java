package GIFT;

import GAMEPLAYER.AGamePlayer;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-2-3
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */

//200点的点数卡
public class PointCard extends AGift {

    //初始化
    public PointCard(){
        this.id = 2;
        this.name = "点数卡";
    }
    //使用礼品
    public void use(AGamePlayer gameplayer){
        System.out.println("奖励玩家200点的点数卡！");
        gameplayer.addPointCount(200);          //增加玩家资金
    }
}
